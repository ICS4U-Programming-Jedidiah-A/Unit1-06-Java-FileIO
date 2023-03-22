import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
* This program reads and outputs to text files.
*
* @author Jedidiah Alfred
* @version 1.0
* @since   2023-03-07
*/

public final class FileIo {
    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private FileIo() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        try {
            // File to take in the input.
            final File input = new File("input.txt");
            final Scanner inputScanner = new Scanner(input);

            // File to print out the output.
            final FileWriter output = new FileWriter("output.txt");
            while (inputScanner.hasNextLine()) {

                // variables for error checking.
                boolean error = false;

                // loop variables
                int sumUp = 0;
                int counter = 0;

                // Split line
                final String[] fromFile = inputScanner.nextLine().split(" ");
                while (counter < fromFile.length) {
                    try {

                        // Converting strings to int and putting them together.
                        sumUp += Integer.parseInt(fromFile[counter]);
                    } catch (NumberFormatException err) {

                        // Check for empty line.
                        if (fromFile[counter].isEmpty()) {
                            output.write("Error: Line is empty.\n");
                        } else {

                            // For any input that is not an int found on the line.
                            output.write("Error: \"" + fromFile[counter]
                                        + "\" is invalid.\n");
                        }

                        // Variable for error check.
                        error = true;

                        // If an error occurs
                        // Then stop adding elements on this line.
                        break;
                    }

                    // Add one to the counter.
                    counter++;
                }

                // If no error has occurred.
                if (!error) {

                    // Output the sum up of all ints on the line to output file.
                    output.write(sumUp + "\n");
                }
            }

            // Close writer.
            output.close();

        } catch (IOException error) {
            System.out.println("That input is invalid");
        }
    }
}
