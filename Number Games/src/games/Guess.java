package games;

import java.util.Random;
import java.util.Scanner;

public class Guess extends Pages implements Games {
	private int answer;
	private int guesss;
	private int guess_count = 4, hint_count = 2;
	private int guess_try = 0, hint_try = 0;
	private char selection;
	private int wager;
	Scanner sc = new Scanner(System.in);
	Random random = new Random();

	public void play(Account account, Highlow highlow, Guess guess, Gamble gamble) {
		answer = random.nextInt(20);
		guess_try = 0; 
		hint_try = 0;
		System.out.println("Name: " + account.getName() + "\t\t\t\t  Coins: " + account.getUsercoins() + "\n");
		System.out.println("\t\tWelcome to Guess\n");
		System.out.print(account.getName() + ", " + " Enter your Wager: ");
		wager = sc.nextInt();
		account.sub(wager);
		System.out.print("Enter your guess 1: ");
		guesss = sc.nextInt();
		guess_try++;
		if (guesss == answer) {
			System.out.println("Congratulations, you won " + (wager * 2) + " coins!!");
			account.add(wager * 2);
		}

		else {
			while ((guess_count != guess_try) || (hint_count != hint_try)) {
				System.out.print("Do you want to take a guess(g) or a hint(h): ");
				selection = sc.next().charAt(0);
				if (selection == 'g' && guess_count != guess_try) {
					System.out.print("Enter your guess " + (guess_try + 1) + ": ");
					guesss = sc.nextInt();
					guess_try++;
				} else if (selection == 'h' && hint_count != hint_try) {
					if (guesss < answer) {
						System.out.println("Your guess " + "(" + guesss + ")" + " is lower than answer.");
					} else if (guesss > answer) {
						System.out.println("Your guess " + "(" + guesss + ")" + " is higher than answer.");
					}
					hint_try++;
				}
				if (guesss == answer) {
					System.out.println("Congratulations, you won " + (wager * 2) + " coins!!");
					account.add(wager * 2);
					break;
				}
				if (hint_count == hint_try) {
					System.out.println("You're out of Hints!!");
				}
				if (guess_count == guess_try) {
					System.out.println("Bad luck, you're out of guesses!");
					System.out.println("The answer was " + answer);
					break;
				}
			}
		}
		System.out.println("\n\n1---> Play again?");
		System.out.println("2---> Back to Game Selection Menu?");
		System.out.print("\nInput: ");
		int decision = sc.nextInt();
		if (decision == 1) {
			clearScreen();
			play(account, highlow, guess, gamble);
		}
		if (decision == 2) {
			clearScreen();
			playpage(highlow, guess, gamble, account);
		}
	}

	public void instructions(Account account, Highlow highlow, Guess guess, Gamble gamble) {
		System.out.println("\t\tGuess\n");
		System.out.println("In this game your have 4 GUESSES and 2 HINTS" + "\nto guess a number between 1-20"
				+ "\nGame is over if you run out of guesses." + "\nIf you win then you earn 2xcoins you wagered");
		System.out.println("\n1---> Instruction Page");
		System.out.print("\nInput: ");
		int choice = sc.nextInt();
		if (choice == 1) {
			clearScreen();
			instructionpage(highlow, guess, gamble, account);
		} else {
			clearScreen();
			instructions(account, highlow, guess, gamble);
		}

	}
}
