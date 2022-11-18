package games;

import java.util.Scanner;

public class Pages extends Methods {

	public static void mainpage(Highlow highlow, Guess guess, Gamble gamble, Account account) {
		clearScreen();
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\tNumber Games\n");
		System.out.println("1---> Play");
		System.out.println("2---> Instructions");
		System.out.println("3---> Exit");
		System.out.print("\nInput: ");
		int choice = sc.nextInt();
		if (choice == 1) {
			clearScreen();
			playpage(highlow, guess, gamble, account);
		} else if (choice == 2) {
			clearScreen();
			instructionpage(highlow, guess, gamble, account);
		} else if (choice == 3) {
			clearScreen();
			System.out.println("See you later, Goodbye!!");
		} else {
			clearScreen();
			mainpage(highlow, guess, gamble, account);
		}
		sc.close();

	}

	public static void playpage(Highlow highlow, Guess guess, Gamble gamble, Account account) {
		Scanner sc = new Scanner(System.in);
		if (account.getName() == null) {
			System.out.println("First we need to know your name!");
			System.out.print("Enter Name: ");
			String name = sc.nextLine();
			account.setName(name);
			account.add(5000);
			clearScreen();
		}
		if(account.getUsercoins() <= 0) {
			clearScreen();
			System.out.println("\t\tGAME OVER");
			account.setName(null);
			account.sub(account.getUsercoins());
			mainpage(highlow, guess, gamble, account);
		}
		System.out.println("Name: " + account.getName() + "\t\t\t\t  Coins: " + account.getUsercoins() + "\n");
		
		System.out.println(account.getName() + ", " + "select the Number Game you want to play!\n");
		System.out.println("1---> Highlow");
		System.out.println("2---> Guess");
		System.out.println("3---> Gamble\n");
		System.out.println("4---> Back to Main Page");
		System.out.print("\nInput: ");
		int choice = sc.nextInt();
		if (choice == 1) {
			clearScreen();
			highlow.play(account, highlow, guess, gamble);
		} else if (choice == 2) {
			clearScreen();
			guess.play(account, highlow, guess, gamble);
		} else if (choice == 3) {
			clearScreen();
			gamble.play(account, highlow, guess, gamble);
		} else if (choice == 4) {
			clearScreen();
			mainpage(highlow, guess, gamble, account);
		} else {
			clearScreen();
			playpage(highlow, guess, gamble, account);
		}
		
		sc.close();
	}

	public static void instructionpage(Highlow highlow, Guess guess, Gamble gamble, Account account) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\tInstructions\n");
		System.out.println("1---> Highlow");
		System.out.println("2---> Guess");
		System.out.println("3---> Gamble\n");
		System.out.println("4---> Back to Main Page");
		System.out.print("\nInput: ");
		int choice = sc.nextInt();
		if (choice == 1) {
			clearScreen();
			highlow.instructions(account, highlow, guess, gamble);
		} else if (choice == 2) {
			clearScreen();
			guess.instructions(account, highlow, guess, gamble);
		} else if (choice == 3) {
			clearScreen();
			gamble.instructions(account, highlow, guess, gamble);
		} else if (choice == 4) {
			clearScreen();
			mainpage(highlow, guess, gamble, account);
		} else {
			clearScreen();
			instructionpage(highlow, guess, gamble, account);
		}
		sc.close();
	}
}
