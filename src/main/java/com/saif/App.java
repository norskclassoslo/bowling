package com.saif;

import java.util.Scanner;

/**
 * Main method
 */
public class App
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        //input pattern should be (([0-9-][0-9/-])|X)*
        System.out.print("Enter sequence of rolls (for example, X2/3-):");
        String rolls = input.nextLine();
        Score s = new Score(rolls.trim());
        System.out.println("Score is " + s.getResult());
    }
}
