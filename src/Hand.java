/*
This program creates a Hand class that creates a hand with
numDie amount of die
CPSC 224, Spring 2020
Homework #2
No sources to cite.

 */

/**
 *This program computes creates a Yahtzee class that utilizes the
 *Die and Hand classes to play a game of Yahtzee
 *
 *
 * @author Mateo Martinez
 * @version v1.8 2/14/20
 * @see Yahtzee Score Files Die
 */
public class Hand
{
    /**
     * Creates a new integer array
     * with numDie amount of elements
     * and rolls each of them die beforehand
     */
    public Hand()
    {

        diceInHand = new int[numDie];
        makeHand();
    }

    /**
     * numDie is the number of die
     * for each user
     */
    private static int numDie;
    /**
     * DiceInHand is an integer array
     * that represents one hand per user
     */
    public int[] diceInHand;

    /**
     * Reads in a value and sets NumDie
     * @param numberDie the number of die per hadn
     */
    public static void setNumDie(int numberDie) {
        numDie = numberDie;
    }

    /**
     * Returns the numDie
     */
    public static int getNumDie() {
        return numDie;
    }

    //makes hand with numDie and rolls each die

    /**
     * makes a hand with numDie amount of die
     * and rolls each die beforehand
     */
    private void makeHand() {
        Die die = new Die();
        int diePosition;
        for(diePosition = 0; diePosition < numDie - 1; diePosition++)
        {
            diceInHand[diePosition] = die.rollDie();
        }
    }

    //rerolls unwanted die

    /**
     * Rerolls die that are unwanted by the user
     * @param n index for the array DiceInHand
     * @param array DiceInHand which holds die
     */
    public void reroll(int n, int array[])
    {
        Die die = new Die();
        array[n] = die.rollDie();
    }

    //outputs hand to user

    /**
     * outputs the users hand to the user
     */
    public void showHand()
    {
        for(int diePosition = 0; diePosition < numDie; diePosition++)
        {
            System.out.print(" " + diceInHand[diePosition]);

        }
        System.out.println();
    }
    //sorts the dice in diceInHand

    /**
     * Sorts the users Hand in ascending order
     * @param array DiceInHand is read in
     */
    public void sortHand(int array[])
    {
        boolean swap;
        int temp;

        do
        {
            swap = false;
            for(int count = 0; count < numDie -1; count++)
            {
                if(array[count] > array[count +1])
                {
                    temp = array[count];
                    array[count] = array[count + 1];
                    array[count + 1] = temp;
                    swap = true;

                }
            }
        } while(swap);
    }

    //checks diceInHand for how many die there are of each side
    //in the hand

    /**
     * Checks DiceInHand for the max amount of the same
     * die found in the users hand
     * @param array DiceInHand is the users hand
     * @return maxCount the maximum count of one die
     */
    public int maxOfAKindFound(int array[])
    {
        int maxCount = 0;
        int currCount;


        for(int dieValue = 1; dieValue <= Die.getNumSides(); dieValue++)
        {
            currCount = 0;
            for(int diePosition = 0; diePosition < getNumDie(); diePosition++)
            {
                if(array[diePosition] == dieValue)
                {
                    currCount++;
                }
            }
            if(currCount > maxCount)
            {
                maxCount = currCount;
            }
        }

        return maxCount;
    }

    //adds up the total of all the die

    /**
     * Totals the users hand
     * @param array DiceInHand the users hand
     * @return totals
     */
    public int totalAllDice(int array[])
    {
        int total = 0;

        for(int diePosition = 0; diePosition < Die.getNumSides(); diePosition++)
        {
            total += array[diePosition];
        }

        return total;
    }

    //Finds the highest straight in the hand

    /**
     * Checks for the max consecutive in the users hand
     * @param array DiceInHand the users hand
     * @return maxLength the longest straight in the hand
     */
    public int maxStraightFound(int array[])
    {
        int maxLength = 1;
        int curLength = 1;

        for(int counter = 0; counter < getNumDie() -1; counter++)
        {
            if (array[counter] + 1 == array[counter +1])
            {
                curLength++;
            }
            else if(array[counter] + 1 < array[counter + 1])
            {
                curLength = 1;
            }
            if(curLength > maxLength)
            {
                maxLength = curLength;
            }

        }

        return maxLength;
    }

    //Checks if there is a full house in the hand

    /**
     * Checks the users hand for a full house
     * @param array DiceInHand the users hand
     * @return foundFH true if there is a full house
     */
    public boolean fullHouseFound(int array[])
    {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currCount;

        for(int dieValue = 1; dieValue <= getNumDie(); dieValue++)
        {
            currCount = 0;

            for(int diePosition = 0; diePosition < Die.getNumSides(); diePosition++)
            {
                if (array[diePosition] == dieValue) {
                    currCount++;
                }

                if (currCount == 2) {
                    found2K = true;
                }

                if (currCount == 3) {
                    found3K = true;
                }

            }
            if(found2K && found3K)
            {
                foundFH = true;
            }
        }

        return foundFH;
    }


}
