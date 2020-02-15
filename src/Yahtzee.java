/*
 * This program creates a Die class that makes on object of type Die
 * and can roll a die with numSides amount of sides
 * CPSC 224, Spring 2020
 * Homework #2
 * No sources to cite.
 *
 * @author Mateo Martinez
 * @version v1.8 2/14/20
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 *This program computes creates a Yahtzee class that utilizes the
 *Die and Hand classes to play a game of Yahtzee
 *
 *
 * @author Mateo Martinez
 * @version v1.8 2/14/20
 * @see Hand Score Files Die
 */
public class Yahtzee {
    /**
     * turns represents the rolls that the user is permitted
     */
    private static int turns;

    /**
     * setTurns sets the private int turns
     * @param turns the number of rolls users are allowed
     */
    public static void setTurns(int turns) {
        Yahtzee.turns = turns;
    }

    /**
     * Returns the integer stored in turns
     * @return turns
     */
    public static int getTurns() {
        return turns;
    }

    public static void main(String[] args) throws IOException {
        /**
         * this is the main() method of the yahtzee class that
         * drives the game
         */
        //making dice and hand
        char change = 'n';
        Scanner scan = new Scanner(System.in);

        Files.ReadInFile();
        System.out.println("You are playing with " + Hand.getNumDie() + " " + Die.getNumSides() + "-sided dice");
        System.out.println("You get " + getTurns() + " rolls per hand");
        //Lets user change the configuration
        System.out.println("Enter 'y' if you would like to change the configuration ");

        Scanner scanner = new Scanner(System.in);
        change = scanner.next().charAt(0);
        if(change == 'y')
        {
            Writer wr = new FileWriter("src/yahtzeeConfig.txt");
            int num;
            //changes number of sides on each die
            System.out.println("Enter the number of sides on each die ");
            num = scan.nextInt();
            Die.setNumSides(num);
            wr.write(String.valueOf(num));
            wr.append(" ");
            //changes number of die
            System.out.println("Enter the number of dice in play ");
            num = scan.nextInt();
            Hand.setNumDie(num);
            wr.write(String.valueOf(num));
            wr.append(" ");
            //changes number of turns
            System.out.println("Enter the number of rolls per hand ");
            num = scan. nextInt();
            setTurns(num);
            wr.write(String.valueOf(num));
            wr.append(" ");
            wr.close();

        }

        Die die1 = new Die();
        Hand hand1 = new Hand();

        Scanner kb = new Scanner(System.in);//used to read in input

        char playAgain = 'y';

        while(playAgain == 'y')
        {
            char[] keep = new char[Hand.getNumDie()];
            char[] roll = new char[Hand.getNumDie()];
            for(int i = 0; i < Hand.getNumDie(); i++)
            {
                keep[i] = 'n';
                roll[i] = 'y';
            }
            int turn = 1;
            while((turn < getTurns()) && keep != roll)
            {
                //roll dice not kept
                for(int dieNumber = 0; dieNumber < Hand.getNumDie(); dieNumber++)
                {
                    if(keep[dieNumber] != 'y')
                    {
                        hand1.reroll(dieNumber, hand1.diceInHand);
                    }
                }

                //output roll
                System.out.print("Your roll was: ");
                for(int dieNumber = 0; dieNumber < Hand.getNumDie(); dieNumber++)
                {
                    System.out.print(hand1.diceInHand[dieNumber]);
                }
                System.out.println();
                //if not the last roll of the hand prompt the use for dice to keep
                if(turn < getTurns())
                {
                    String inp;
                    System.out.print("enter dice to keep (y or n)");
                    inp = kb.next();
                    for(int i = 0; i < Hand.getNumDie(); i ++)
                    {
                        keep[i] = inp.charAt(i);
                    }
                }
                turn++;

            }
            //put score copy here if it doesnt work
            Score.doScore(hand1);

            //replay



            System.out.print("Enter 'y' to play again or anything else to quit");

            playAgain = scanner.next().charAt(0);
        }



    }

}

