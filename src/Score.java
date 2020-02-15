import java.util.Scanner;

/**
 *This program computes takes in a hand and scores it
 * outputting the score to the user
 *
 *
 * @author Mateo Martinez
 * @version v1.8 2/14/20
 * @see Yahtzee Score Files Die
 */
public class Score {

    //set to private as a score object doesn't need to be instantiated

    /**
     * set to private as a Score object doesn't need
     * to be instantiated
     */
    private Score()
    {
    }

    /**
     * Sorts the users hand and checks for straights and outputs
     * scores to the user
     * @param hand1 DiceInHand the users hand
     */
    public static void doScore(Hand hand1)
    {
        //start scoring
        //hand needs to be sorted to check for straights
        hand1.sortHand(hand1.diceInHand);
        System.out.print("Here is your sorted hand: ");
        for(int dieNumber = 0; dieNumber < Hand.getNumDie(); dieNumber++)
        {
            System.out.print(hand1.diceInHand[dieNumber]);
        }
        System.out.println();

        //upper scorecard
        for(int dieValue = 1; dieValue <= Die.getNumSides(); dieValue++)
        {
            int currCount = 0;
            for (int diePosition = 0; diePosition < Hand.getNumDie(); diePosition++)
            {
                if (hand1.diceInHand[diePosition] == dieValue)
                {
                    currCount++;
                }
            }
            System.out.println("Score " + (dieValue * currCount) + " on the " + dieValue + " line");
        }

        //lower scorecard
        if(Hand.getNumDie() > 1)
        {
            if(hand1.maxOfAKindFound(hand1.diceInHand) >= 3)
            {
                System.out.println("Score " + hand1.totalAllDice(hand1.diceInHand) + " on the 3 of a kind line");
            }
            else
            {
                System.out.println("Score 0 on the 3 of a Kind line");
            }


            if(hand1.maxOfAKindFound(hand1.diceInHand) >= 4)
            {
                System.out.println("Score " + hand1.totalAllDice(hand1.diceInHand) + " on the 4 of a kind line");
            }
            else
            {
                System.out.println("Score 0 on the 4 of a Kind line");
            }

            if(hand1.fullHouseFound(hand1.diceInHand))
            {
                System.out.println("Score 25 on the Full House line");
            }
            else
            {
                System.out.println("Score 0 on the Full House line");
            }

            if(hand1.maxStraightFound(hand1.diceInHand) >= 4)
            {
                System.out.println("Score 30 on the Small Straight Line");
            }
            else
            {
                System.out.println("Score 0 on the Small Straight Line");
            }

            if(hand1.maxStraightFound(hand1.diceInHand) >= 5)
            {
                System.out.println("Score 40 on the Large Straight Line");
            }
            else
            {
                System.out.println("Score 0 on the Large Straight Line");
            }

            if(hand1.maxOfAKindFound(hand1.diceInHand) >= 5)
            {
                System.out.println("Score 50 on the Yahtzee line");
            }
            else
            {
                System.out.println("Score 0 on the Yahtzee line");
            }
        }
        else
        {
            System.out.println("Score 0 on the 3 of a Kind line");
            System.out.println("Score 0 on the 4 of a Kind line");
            System.out.println("Score 0 on the Full House line");
            System.out.println("Score 0 on the Small Straight Line");
            System.out.println("Score 0 on the Large Straight Line");
            System.out.println("Score 0 on the Yahtzee line");
        }


        System.out.println("Score " + hand1.totalAllDice(hand1.diceInHand) + " on the Chance line");
    }





}
