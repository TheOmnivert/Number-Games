package games;

public class Account {
	public static int usercoins;
	String name = null;
	public void add(int win) {
		usercoins += win;
	}
	public void sub(int wager) {
		usercoins -= wager;
	}
	public int getUsercoins() {
		return usercoins;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
