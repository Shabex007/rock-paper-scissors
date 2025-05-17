import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String[] choices = { "Rock", "Paper", "Scissors" };
        String[] art = { rock(), paper(), scissors() };

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\n--- Rock Paper Scissors Game ---");
            System.out.println("Enter your choice:\n0 - Rock\n1 - Paper\n2 - Scissors");
            System.out.print("Your choice: ");

            int userChoice;
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter 0, 1, or 2.");
                scanner.next(); // discard invalid input
                continue;
            }

            if (userChoice < 0 || userChoice > 2) {
                System.out.println("Wrong Input, You Lose!");
                continue;
            }

            int computerChoice = rand.nextInt(3);

            // Display Choices
            System.out.println("\nYou chose: " + choices[userChoice]);
            System.out.println(art[userChoice]);

            System.out.println("Computer chose: " + choices[computerChoice]);
            System.out.println(art[computerChoice]);

            // Game Logic
            if (userChoice == computerChoice) {
                System.out.println("Result: Draw");
            } else if ((userChoice == 0 && computerChoice == 2) ||
                    (userChoice == 1 && computerChoice == 0) ||
                    (userChoice == 2 && computerChoice == 1)) {
                System.out.println("Result: You Win!");
            } else {
                System.out.println("Result: You Lose!");
            }

            // Play Again Prompt
            System.out.print("\nDo you want to play again? (yes/no): ");
            String again = scanner.next().toLowerCase();
            playAgain = again.startsWith("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static String rock() {
        return """
                    _______
                ---'   ____)
                      (_____)
                      (_____)
                      (____)
                ---.__(___)
                """;
    }

    public static String paper() {
        return """
                     _______
                ---'    ____)____
                           ______)
                          _______)
                         _______)
                ---.__________)
                """;
    }

    public static String scissors() {
        return """
                    _______
                ---'   ____)____
                          ______)
                       __________)
                      (____)
                ---.__(___)
                """;
    }
}
