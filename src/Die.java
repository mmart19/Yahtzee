/*
 * This program creates a Die class that makes on object of type Die
 * and can roll a die with numSides amount of sides
 * CPSC 224, Spring 2020
 * Homework #2
 * No sources to cite.
 *
 * @author Mateo Martinez
 * @version v1.8 2/3/20
 */
import java.util.Random;

public class Die {
    /**
     * This program creates a Die class that makes on object of type Die
     * and can roll a die with numSides amount of sides
     *
     *
     * @author Mateo Martinez
     * @version v1.8 2/14/20
     * @see Hand Score Files Yahtzee
     */

    //fields
    /**
     * NumSides in the number of sides per die
     */
    private static int numSides;
    /**
     * side is used to set the side the die
     * was rolled to
     */
    private int side;

    /**
     * Takes in a value that is then used
     * to set the number of sides per die
     * @param numberSides number of sides per die
     */
    public static void setNumSides(int numberSides) {
        numSides = numberSides;
    }

    /**
     * Returns the number of sides for one die
     * @return numSides
     */
    public static int getNumSides() {
        return numSides;
    }

    //rolls die with results from 1-6
    /**
     * Rolls a die from 1-numSides and returns
     * that
     * @return numSides
     */
    public int rollDie()
    {
        side = (int) (Math.random() * numSides) + 1;
        if(side == 0)
        {
            side = 1;
        }
        return side;
    }


}
