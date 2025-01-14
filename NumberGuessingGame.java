import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100. Try to guess it!");

            while (attempts < 10 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess (attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasGuessedCorrectly = true;
                    score += 10 - attempts + 1;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Too low. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();  // Consume newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}