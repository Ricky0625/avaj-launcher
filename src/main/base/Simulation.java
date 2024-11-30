package base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.ParsingException;
import parser.AircraftTypeParser;
import parser.CoordinateParser;
import parser.Parser;
import parser.PositiveNumberParser;
import parser.ScenarioParser;
import utils.FileSource;

public class Simulation {

    private final FileSource source;
    private Parser<Integer> headerParser;
    private Parser<Scenario> contentParser;

    private int numOfSimulation;
    private List<Scenario> scenarios = new ArrayList<Scenario>();

    public Simulation(final String fileName) throws IOException {
        source = new FileSource(fileName);
    }

    public Simulation(final String fileName, final Parser<Integer> headerParser, final Parser<Scenario> contentParser)
            throws IOException {
        source = new FileSource(fileName);
        this.headerParser = headerParser;
        this.contentParser = contentParser;
    }

    public void useDefaultParser() {
        headerParser = new PositiveNumberParser();
        contentParser = new ScenarioParser(
                new AircraftTypeParser(),
                new CoordinateParser());
    }

    public void initSimulation() throws ParsingException {
        numOfSimulation = parseHeader();
        scenarios = parseContent();
    }

    private int parseHeader() throws ParsingException {
        return headerParser.parse(source.getCurrentLine());
    }

    private List<Scenario> parseContent() throws ParsingException {
        while (source.nextLine()) {
            scenarios.add(contentParser.parse(source.getCurrentLine()));
        }
        return scenarios;
    }

}
