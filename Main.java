package NumberGuess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String choice;
        int tries;
        int attempts = 1;
        boolean running = true;
        boolean finall = false;

        System.out.println("Willkommen!\nGuess a number between 0-100.");


        while(running) {
            System.out.println("\nSelect difficulty level:\n1. Easy (10 chances)\n2. Medium (5 chances)\n3. Hard (3 chances)");
            System.out.print("Enter your choice (nr): ");
            choice = scanner.nextLine();

            if (choice.equals("1") || choice.equals("1.")) {
                tries = 10;
                System.out.println("You have selected easy mode. Noob!");
            } else if (choice.equals("2") || choice.equals("2.")) {
                tries = 5;
                System.out.println("You have selected medium difficulty. Good luck!");
            } else if (choice.equals("3") || choice.equals("3.")) {
                tries = 3;
                System.out.println("You have selected hard mode! Shiver me timbers!");
            } else {
                System.out.println("Invalid option. Try again!");
                continue;
            }


            int number = random.nextInt(0, 101);

            for(int i = 1; i <= tries; i++) {
                System.out.println();
                System.out.print("Enter guess: ");
               try {
                    int guess = scanner.nextInt();
                    scanner.nextLine();

                    if (guess == number) {
                        System.out.printf("Congratulations! You guessed the number in %d attempt/s!\n", attempts);
                        finall = true;
                        break;
                    } else if (guess > number) {
                        System.out.println("Too high! " + (tries - attempts) + " attempt/s remaining!");
                        attempts++;
                    } else if (guess < number) {
                        System.out.println("Too low! " + (tries - attempts) + " attempt/s remaining!");
                        attempts++;
                    } else {
                        System.out.println("Sumetin wrong");
                        i--;
                    }


                } catch (InputMismatchException e) {
                    System.out.println("Enter an integer from 0-100!");
                    scanner.nextLine();
                    i--;
                    continue;
                }
            }
            if (!finall) {
                System.out.println("\nYou lose! The number was " + number);
            }
            System.out.println();

            System.out.print("Try again? (y / n): ");
            String again = scanner.nextLine().toLowerCase();
            if (again.equals("y")) {
                System.out.println();
            } else if (again.equals("n")) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid input! Byebye!");
                running = false;
            }
        }
        scanner.close();
    }
}
