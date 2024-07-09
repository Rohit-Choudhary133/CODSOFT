import java.util.Random;
import java.util.Scanner;

public class Guess_Number {
    public static void main(String[] args){
        //Guess The Number Game

        //1. Generate a random number within a specified range, such as 1 to 100.
        Random random = new Random();
        //2. Prompt the user to enter their guess for the generated number.
        Scanner sc = new Scanner(System.in);
        // System.out.println(randomNumber); //Used for Debugging
        int score = 0;
        String playAgain;
        do{
            int randomNumber = random.nextInt(100)+1;
            boolean hasWon = false;
            int attempts = 0;

            System.out.println("Welcome to the Guess the number Game!");
            System.out.println("You have 10 attempts to guess the number between 1 to 100");

            while(attempts<10){//4. Repeat steps 2 and 3 until the user guesses the correct number.
                System.out.println("Enter your guess between (1-100): ");
                int playerGuess = sc.nextInt();
                attempts++;

                //3. Compare the user's guess with the generated number and provide feedback on whether the guess is correct, too high, or too low.
                if(playerGuess == randomNumber){
                    System.out.println("Congratulations! Your guess is correct! You win!");
                    score++;
                    hasWon = true;
                    break;
                }
                else if(playerGuess < randomNumber){
                    System.out.println("Incorrect! The number is bigger. Guess again!");
                }
                else{
                    System.out.println("Incorrect! The number is smaller. Guess again!");
                }
            }

            if(!hasWon){
                System.out.println("Your attempts are over you loose! The correct number was: " + randomNumber);
            }
             // Display the user's score
             System.out.println("Your current score: " + score);

             // Ask if the user wants to play another round
             System.out.println("Do you want to play again? (yes/no)");
             playAgain = sc.next();
        }while(playAgain.equalsIgnoreCase("Yes"));

        System.out.println("Thank you for playing! Your final score is: " + score);
        sc.close();
    }
}
