package main.java.com.fourtytwo.avajlauncher;

/**
 * AvajLauncher
 */
public class AvajLauncher {

    public static void main(final String[] args) {
        System.out.println("Hello world!");
        if (args.length > 0) {
            String filePath = args[0];
            System.out.println("File path provided: " + filePath);
        } else {
            System.out.println("No file path provided");
        }
    }

}
