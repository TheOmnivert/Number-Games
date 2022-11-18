package games;

import java.util.Random;
import java.util.Scanner;

public class Highlow extends Pages implements Games {
	private int choice;
	private int answer;
	private int hint;
	private int wager;
	Scanner sc = new Scanner(System.in);

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	Random random = new Random();

	public void play(Account account, Highlow highlow, Guess guess, Gamble gamble) {
		answer = random.nextInt(99);
		hint = random.nextInt(99);
		System.out.println("Name: " + account.getName() + "\t\t\t\t  Coins: " + account.getUsercoins() + "\n");
		System.out.println("\t\tHIGHLOW\n");
		System.out.print("Hello " + account.getName() + ", " +  "Enter your wager: ");
		wager = sc.nextInt();
		account.sub(wager);
		System.out.println("\nYour hint is: " + hint);
		System.out.println("1---> LOWER\n" + "2---> JACKPOT\n" + "3---> HIGHER\n");

		choice = sc.nextInt();
		int result = 0;
		if (answer < hint && choice == 1)
			result = 1;
		else if (hint == answer && choice == 2)
			result = 1;
		else if (answer > hint && choice == 3)
			result = 1;
		if (result == 1) {
			System.out.println("You won " + (2 * wager) + " coins!!");
			account.add(2 * wager);
		} else
			System.out.println("You lost!!");
		System.out.println("Hidden Number was: " + answer);
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
		System.out.println("\t\tHIGHLOW\n");
		System.out.println("In this game I choose a secret number between 1 to 100."
				+ "\nYou have to guess if the number is" + "\nHIGHER, LOWER or the SAME i.e JACKPOT"
				+ "\nIf you guess correctly then you win 2xcoins you wagered");
		System.out.println("\n1---> Instructions Menu");
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
