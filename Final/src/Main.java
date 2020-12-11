//Justin Luu
// Sorry in advanced. It is pretty messy. Nothing ever worked the way I wanted it to.

public class Main {
	
//the values for each account
	private static int[] jonBalance = {1000,0,0};
	private static int[] sarBalance = {200,300,150};
	private static int[] josBalance = {2000,40,50};
	private static int[] eliBalance = {300,1000,4500};
	private static int[] KPLBalance = {0,0,0};

	private static String account = "";
	private static int temp = 0;
	private static boolean truth = false;
	
//main method. Starts the program
	public static void main(String[] args) {	
		new Login();
	}
	
//getters and setters for each variable
	public static int getJonBalance(int i) {
		return jonBalance[i];
	}
	public static void setJonBalance(int i, int cash) {
		Main.jonBalance[i] = cash;
	}
	public static int getSarBalance(int i) {
		return sarBalance[i];
	}
	public static void setSarBalance(int i, int cash) {
		Main.sarBalance[i] = cash;
	}
	public static int getJosBalance(int i) {
		return josBalance[i];
	}
	public static void setJosBalance(int i, int cash) {
		Main.josBalance[i] = cash;
	}
	public static int getEliBalance(int i) {
		return eliBalance[i];
	}
	public static void setEliBalance(int i, int cash) {
		Main.eliBalance[i] = cash;
	}
	public static int getKPLBalance(int i) {
		return KPLBalance[i];
	}
	public static void setKPLBalance(int i, int cash) {
		Main.KPLBalance[i] = cash;
	}
	public static String getAccount() {
		return account;
	}
	public static void setAccount(String name) {
		Main.account = name;
	}
	public static void setTemp(int i) {
		Main.temp = i;
	}
	public static int getTemp() {
		return temp;
	}

	public static boolean getTruth() {
		return truth;
	}

	public static void setTruth(boolean truth) {
		Main.truth = truth;
	}
	
}
