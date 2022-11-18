package games;

import java.util.Random;
import java.util.Scanner;

public class Gamble extends Pages implements Games{
	private int user_roll;
	private int cpu_roll;
	private int wager;
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	public void play(Account account, Highlow highlow, Guess guess, Gamble gamble) {
		user_roll = random.nextInt(12);
		cpu_roll = random.nextInt(12);
		System.out.println("Name: " + account.getName() + "\t\t\t\t  Coins: " + account.getUsercoins() + "\n");
		System.out.println("\t\tWelcome to Gamble\n");
		System.out.print("Enter the amount to gamble: ");
		wager = sc.nextInt();
		account.sub(wager);
		System.out.println("You threw your dice and Rolled.......... " + user_roll);
		System.out.println("CPU threw its dice and Rolled........... " + cpu_roll);
		if(user_roll > cpu_roll) {
			System.out.println("Congratulations you won " + (2*wager) + " coins");
			account.add(wager*2);
		}
		else if(user_roll < cpu_roll) {
			System.out.println("Sorry, you lost " + wager + " coins");
		}
		else {
			System.out.println("You tied, you won 0 coins");
		}
		System.out.println("\n\n1---> Play again?");
		System.out.println("2---> Back to Game Selection Menu?");
		System.out.print("\nInput: ");
		int decision = sc.nextInt();
		if(decision == 1) {
			clearScreen();
			play(account, highlow, guess, gamble);
		}
		if(decision == 2) {
			clearScreen();
			playpage(highlow, guess, gamble, account);
		}
	}
	public void instructions(Account account, Highlow highlow, Guess guess, Gamble gamble) {
		System.out.println("\t\tGamble\n");
		System.out.println("In this game you and the computor both roll 2 dices."
				+ "\nIf you roll more than computer you win."
				+ "\nIf you win, you get 2xcoins you wagered.");
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
