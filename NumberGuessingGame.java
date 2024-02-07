//Task 1
//        1. Generate a random number within a specified range, such as 1 to 100.
//
//        2. Prompt the user to enter their guess for the generated number.
//
//        3. Compare the user's guess with the generated number and provide feedback on whether the guess
//        is correct, too high, or too low.
//
//        4. Repeat steps 2 and 3 until the user guesses the correct number.
//
//        You can incorporate additional details as follows:
//
//        5. Limit the number of attempts the user has to guess the number.
//        6. Add the option for multiple rounds, allowing the user to play again.
//        7. Display the user's score, which can be based on the number of attempts taken or rounds won.
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nRound " + (rounds + 1) + ": Guess a number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                attempts++;
                totalAttempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + targetNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (playAgain.equals("yes")) {
                rounds++;
            } else {
                break;
            }

        } while (true);

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Total Attempts: " + totalAttempts);

        scanner.close();
    }
}
