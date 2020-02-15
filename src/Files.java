import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Files {
    /**
     * This program reads in integers from a file that
     * help setup the game
     *
     *
     * @author Mateo Martinez
     * @version v1.8 2/14/20
     * @see Hand Score Files Yahtzee
     */


    /**
     * DieIn is the number of Die
     * Read in from the txt file
     */
    public static int DieIn;
    /**
     * Turns is the number of rolls
     * Read in from the txt file
     */
    public static int TurnsIn;
    /**
     * SidesIn is the number of sides
     * per die read in from the txt file
     */
    public static int SidesIn;



    public static void ReadInFile()
    {
        /**
         * This is the main method for File that
         * reads in the number of sides per die,
         * the number of die, and the number of rolls
         * per user from the yahtzeeConfig.txt file
         */
        //file input
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("src/yahtzeeConfig.txt"));
            if(inFile.hasNextInt()) {
                SidesIn = inFile.nextInt();
                Die.setNumSides(SidesIn);
                DieIn = inFile.nextInt();
                Hand.setNumDie(DieIn);
                TurnsIn = inFile.nextInt();
                Yahtzee.setTurns(TurnsIn);
                inFile.close();

            }

        }
        catch(FileNotFoundException e) {
            System.out.println("File not Found");
        }

    }



}
