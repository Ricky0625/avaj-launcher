package base;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParsingException;
import parser.Parser;
import parser.PositiveNumberParser;
import parser.ScenarioParser;
import utils.FileSource;
import utils.LoggerUtils;

public class Simulation {

    private static Simulation instance;

    private final FileSource source;
    private Parser<Integer> headerParser;
    private Parser<Scenario> contentParser;

    private int numOfSimulation;
    private List<Scenario> scenarios = new ArrayList<Scenario>();

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

    public void initSimulation() throws ParsingException {
        if (headerParser == null || contentParser == null) {
            throw new ParsingException("Parser for simulation not initialized!");
        }

        numOfSimulation = headerParser.parse(source.getCurrentLine());
        while (source.nextLine()) {
            scenarios.add(contentParser.parse(source.getCurrentLine()));
        }
    }

    public int getNumOfSimulation() {
        return numOfSimulation;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void show() {
        for (Scenario s : scenarios) {
            LoggerUtils.debug(
                    "\n[TYPE] " + s.getType() + "\n[NAME] " + s.getName() + "\n[Coord] " + s.getCoordinates().toString()
                            + "\n");
        }
    }

}
