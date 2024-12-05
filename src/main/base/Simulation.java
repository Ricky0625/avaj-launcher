package base;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import aircraft.AircraftFactory;
import exceptions.ParsingException;
import parser.Parser;
import parser.PositiveNumberParser;
import parser.ScenarioParser;
import utils.FileSource;
import utils.LoggerUtils;
import weather.WeatherTower;

public class Simulation {

    private static Simulation instance;

    private Parser<Integer> headerParser;
    private Parser<Scenario> contentParser;

    private int numOfSimulation;
    private List<Scenario> scenarios = new ArrayList<Scenario>();

    private final FileSource source;
    private final String outputFilePath = "./out/simulation.txt";
    private File outputFile;

    public static Simulation getInstance(final String fileName) throws Exception {
        if (instance == null) {
            instance = new Simulation(fileName);
        }
        return instance;
    }

    private Simulation(final String fileName) throws Exception {
        source = new FileSource(fileName);
        headerParser = new PositiveNumberParser();
        contentParser = new ScenarioParser();
    }

    public void initSimulation() throws ParsingException, IOException {
        if (headerParser == null || contentParser == null) {
            throw new ParsingException("Parser for simulation not initialized!");
        }

        numOfSimulation = headerParser.parse(source.getCurrentLine());
        while (source.nextLine()) {
            scenarios.add(contentParser.parse(source.getCurrentLine()));
        }

        // prepare the output file only if the parsing is ok
        prepareOutputFile();
    }

    public void run() throws IOException {
        WeatherTower weatherTower = new WeatherTower();

        registerAircraft(weatherTower);
        // begin simulation, change weather
        while (numOfSimulation-- > 0) {
            weatherTower.changeWeather();
        }
    }

    public int getNumOfSimulation() {
        return numOfSimulation;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void cleanup() throws IOException {
        // simulation ended, system.out call will print to console from now
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        LoggerUtils.info(String.format("Generated simulation log: %s.", outputFilePath));
        LoggerUtils.log(LoggerUtils.YELLOW, "INST", "Run `make log` to view the simulation log.");
    }

    private void registerAircraft(final WeatherTower tower) throws IOException {
        AircraftFactory aircraftFactory = AircraftFactory.getInstance();

        for (Scenario scenario : scenarios) {
            Flyable aircraft = aircraftFactory.newAircraft(
                    scenario.getType(),
                    scenario.getName(),
                    scenario.getCoordinates());
            tower.register(aircraft);
            aircraft.registerTower(tower);
        }
    }

    private void prepareOutputFile() throws IOException {
        // create file
        outputFile = new File(outputFilePath);
        // this is a sanity check lol. log file will be generated in out/ which will be
        // deleted everytime the application runs
        if (outputFile.exists()) {
            outputFile.delete();
        }
        outputFile.createNewFile();

        // redirect any system.out call to the output file from now on
        System.setOut(new PrintStream(new FileOutputStream(outputFile)));
    }

}
