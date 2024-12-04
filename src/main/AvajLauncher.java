import base.Simulation;
import utils.LoggerUtils;

/**
 * AvajLauncher
 */
public class AvajLauncher {

    public static void main(final String[] args) {
        try {
            if (args.length != 1) {
                throw new Exception("Invalid usage! make run SCENARIO=<file.txt>");
            }

            Simulation sim = Simulation.getInstance(args[0]);

            sim.initSimulation();
            sim.run();
            sim.cleanup(); // close file & show post simulation instruction
        } catch (Exception e) {
            LoggerUtils.error(e.getMessage());
        }
    }

}
