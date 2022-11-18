package games;

import java.util.Scanner;

public class Main extends Pages{
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
			Highlow highlow = new Highlow();
			Guess guess = new Guess();
			Gamble gamble = new Gamble();
			Account account = new Account();
			mainpage(highlow, guess, gamble, account);
		}
}
