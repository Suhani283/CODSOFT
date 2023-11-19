import java.util.*;
public class NumberGame
 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 
        int numberOfTries = 0; 
        boolean round=true;
        int count=0;
        String answer="";

        while(round) {
            System.out.println(" \n Enter the UpperBound and the LowerBound");
        int lowerBound = sc.nextInt();
        int upperBound = sc.nextInt();
        int randomNumber = lowerBound  + (int)(Math.random() * upperBound);
            count++;
            boolean hasGuessedCorrectly = false;
        System.out.println("Welcome to the Number Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");
             while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = sc.nextInt();
            sc.nextLine();
            numberOfTries++;

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please guess a number between " + lowerBound + " and " + upperBound + ".");
            } else if (userGuess == randomNumber) {
                hasGuessedCorrectly = true;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
        System.out.println("\n Do you want to play more?");
        answer=sc.nextLine();
        round= YesNoToBooleanConverter.convertYesNoToBoolean(answer);
   }     
            System.out.println("The number of rounds played are "+count);
            System.out.println("Player does not want to play");    
    }
}
