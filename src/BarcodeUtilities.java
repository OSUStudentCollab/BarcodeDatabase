import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is a utility class that helps to read data from a barcode
 */
public class BarcodeUtilities {

    /**
     * Runs a python script
     * 
     * @param scriptLocation Location of Python Script to run
     */
    private static void executePythonScript(String scriptLocation) {

        String s = null;

        try {
            /*
             * Run the Python Program
             */
            Process p = Runtime.getRuntime().exec("python " + scriptLocation);

            /*
             * Capture any terminal outputs from the python program
             */
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            /*
             * Capture any error messages
             */
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // // read the output from the command
            // System.out.println("Here is the standard output of the command:\n");
            // while ((s = stdInput.readLine()) != null) {
            // System.out.println(s);
            // }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }
    }

    /**
     * Runs a python script and then returns the terminal outputs from the python
     * script
     * 
     * @param scriptLocation Location of Python Script to run
     * @return Any outputs the python script made to the terminal
     */
    private static String executePythonScriptAndGetTerminalOutput(String scriptLocation) {

        String s = null;
        StringBuilder output = new StringBuilder();

        try {
            /*
             * Run the Python Program
             */
            Process p = Runtime.getRuntime().exec("python " + scriptLocation);

            /*
             * Capture any terminal outputs from the python program
             */
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            /*
             * Capture any error messages
             */
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            while ((s = stdInput.readLine()) != null) {
                output.append(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }

        return output.toString();
    }

    /**
     * This program needs there to be an image titled "toDecode.png" to exist in the
     * Images folder. After which point it will return the data from the given
     * barcode.
     * 
     * @return Barcode data
     */
    public static String getBarcodeInformation() {
        return executePythonScriptAndGetTerminalOutput("Python/BarcodeReader.py");
    }

}