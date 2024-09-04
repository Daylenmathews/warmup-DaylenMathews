import java.io.File;
import java.io.FileNotFoundException;


/**
 * @author Daylen Mathews
 * CS221 Magic Squares Driver
 * MagicSquare Driver class for users to run a command line argument in the terminal.
 * This allows to create or check the Magioc Square.
 *
 */

public class MagicSquareDriver {
    public static void main(String[] args) throws FileNotFoundException {
        //Check for right number of arguments
        if (args.length != 2 && args.length != 3) {
            System.out.println("Usage: java MagicSquareDriver <-check | -create> <filename> < |size (has to be odd)>");
            System.exit(0);
        }


        //Capture the type of argument

        String type = args[0];
        String fileName = args[1];

        switch (type) {
            case "-check":
                File file = new File(fileName);
                if (!file.exists()) {
                    System.out.println("File not found: " + fileName);
                    System.exit(1);
                }
                MagicSquare magicSquareCheck;
                magicSquareCheck = new MagicSquare(fileName);
                System.out.println(magicSquareCheck);
                if (magicSquareCheck.isMagicSquare()) {
                    System.out.println("is a magic square.");
                } else {
                    System.out.println("is not a magic square.");
                }
                break;

            case "-create":
                if (args.length != 3) {
                    System.out.println("Usage: java MagicSquareDriver <-check | -create> <filename> < |size (has to be odd)>");
                    System.exit(0);
                }

                int size;
                try {
                    size = Integer.parseInt(args[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Size must be an integer.");
                    System.exit(0);
                    return;
                }

                if (size % 2 == 0) {
                    System.out.println("Usage: java MagicSquareDriver <-check | -create> <filename> < |size (has to be odd)>");
                    System.exit(0);
                }
                MagicSquare magicSquareCreate = new MagicSquare(String.valueOf(size));
                magicSquareCreate.generateMagicSquare(size);
                System.out.println(magicSquareCreate);

                // Save the magic square to the file
                try {
                    magicSquareCreate.saveToFile(fileName);
                } catch (Exception e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                    System.exit(1);
                }
                break;

            default:
                System.out.println("Usage: java MagicSquareDriver <-check | -create> <filename> < |size (has to be odd)>");
                break;
        }
    }
}


