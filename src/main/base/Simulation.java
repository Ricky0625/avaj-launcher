package base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.ParsingException;
import parser.Parser;
import parser.PositiveNumberParser;
import parser.ScenarioParser;
import utils.FileSource;
import utils.LoggerUtils;
import weather.WeatherProvider;

public class Simulation {

    private static Simulation instance;

    private final FileSource source;
    private Parser<Integer> headerParser;
    private Parser<Scenario> contentParser;

    private int numOfSimulation;
    private List<Scenario> scenarios = new ArrayList<Scenario>();

    private final String outputFilePath = "./out/simulation.txt";
    private File outputFile;
    private BufferedWriter writer;

    private Simulation(final String fileName) throws Exception {
        source = new FileSource(fileName);
        headerParser = new PositiveNumberParser();
        contentParser = new ScenarioParser();
    }

    public static Simulation getInstance(final String fileName) throws Exception {
        if (instance == null) {
            instance = new Simulation(fileName);
        }
        return instance;
    }

    public void initSimulation() throws ParsingException, IOException {
        if (headerParser == null || contentParser == null) {
            throw new ParsingException("Parser for simulation not initialized!");
        }

        numOfSimulation = headerParser.parse(source.getCurrentLine());
        while (source.nextLine()) {
            scenarios.add(contentParser.parse(source.getCurrentLine()));
        }

        // initialize here because if the scenario file cannot pass the parser,
        // no point of creating a output file and writer anyway
        prepareWriter();
    }

    public int getNumOfSimulation() {
        return numOfSimulation;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    private void prepareWriter() throws IOException {
        // create file
        outputFile = new File(outputFilePath);
        // this is a sanity check lol. log file will be generated in out/ which will be
        // deleted everytime the application runs
        if (outputFile.exists()) {
            outputFile.delete();
        }
        outputFile.createNewFile();

        writer = new BufferedWriter(new FileWriter(outputFile));
    }

    public BufferedWriter getWriter() throws ParsingException {
        // sanity check
        if (writer == null) {
            throw new ParsingException("Writer not initialized!");
        }
        return writer;
    }

    public void cleanup() throws IOException {
        writer.close();
        LoggerUtils.info(String.format("Generated simulation log: %s.", outputFilePath));
        LoggerUtils.log(LoggerUtils.YELLOW, "INST", "Run `make log` to view the simulation log.");
    }

    public void show() {
        for (Scenario s : scenarios) {
            LoggerUtils.debug(
                    "\n[TYPE] " + s.getType() + "\n[NAME] " + s.getName() + "\n[Coord] "
                            + s.getCoordinates().toString());
            LoggerUtils.warn("Weather: " + WeatherProvider.getInstance().getCurrentWeather(s.getCoordinates()) + "\n");
        }
    }

}
