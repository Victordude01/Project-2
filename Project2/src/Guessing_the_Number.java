import java.util.Scanner;

public class Guessing_the_Number {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello! What is your name?");
        String name = keyboard.next();
        System.out.printf("\nWell, %s, I am thinking of a number between 1 and 20.\nTake a guess.",name);
        boolean playAgain = true;
        String response;

        do {
            playGame();  // call subroutine to play one game
            System.out.print("Would you like to play again? (y or n): ");
            response = keyboard.next().toLowerCase();
            if (response.equals("n")){
                playAgain = false;
            }
        } while (playAgain);
        System.out.println("Thanks for playing!");
    }

    static void playGame() {
        int computersNumber; // A random number picked by the computer.
        int usersGuess;      // A number entered by user as a guess.
        int guessCount;      // Number of guesses the user has made.
        computersNumber = (int)(20 * Math.random()) + 1;
        // The value assigned to computersNumber is a randomly
        //    chosen integer between 1 and 20, inclusive.
        guessCount = 0;
        System.out.println();
        System.out.print("What is your first guess? ");
        while (true) {
            usersGuess = keyboard.nextInt();  // Get the user's guess.
            guessCount++;
            if (usersGuess == computersNumber) {
                System.out.println("You got it in " + guessCount
                        + " guesses!  My number was " + computersNumber);
                break;  // The game is over; the user has won.
            }
            if (guessCount == 6) {
                System.out.println("You didn't get the number in 6 guesses.");
                System.out.println("You lose.  My number was " + computersNumber);
                break;  // The game is over; the user has lost.
            }
            // If we get to this point, the game continues.
            // Tell the user if the guess was too high or too low.
            if (usersGuess < computersNumber)
                System.out.print("That's too low.  Try again: ");
            else if (usersGuess > computersNumber)
                System.out.print("That's too high.  Try again: ");
        }
        System.out.println();
    } // end of playGame()
}
