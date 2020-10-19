/*
 * I commented out the the readto() and writeto() methods because they are currently not working, the rest of the code is working aside from
 * the CD offering class. I have not done that much work to the assignment 3 and I will also need to fix my errors from assignment 2 before 
 * submitting the project
 * 
 * */


package assignment3;

//import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java. util. ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

	public class BankAccount {
		private static double interestRate;
		private double balance;
		private long accountNumber;
		private static long accountNum = 1000;
		protected Date openDate;
		private final static double DEFAULT_INTEREST_RATE = 0.01;
		private final static String DEFAULT_DATE_STRING = "01/01/2020";

		public BankAccount() {
			accountNum = accountNum + 1;
			this.accountNumber = accountNum;
		}

		public BankAccount(double openingBalance) {
			this.balance = openingBalance;
		}

		public BankAccount(double interestRate, double balance) {
			super();
			this.interestRate = interestRate;
			this.balance = balance;
		}

		public BankAccount(long accountNumber, double interestRate, double balance) {
			super();
			this.accountNumber = accountNumber;
			this.interestRate = interestRate;
			this.balance = balance;
		}

	// Made accountOpenedOn static and created getters and setters
		public BankAccount(double interestRate, double balance, java.util.Date accountOpenedOn) {
			super();
			this.interestRate = interestRate;
			this.balance = balance;
			this.openDate = accountOpenedOn;

		}

		public BankAccount(long accountNumber, double interestRate, double balance, java.util.Date accountOpenedOn) {
			super();
			this.accountNumber = accountNumber;
			this.interestRate = interestRate;
			this.balance = balance;
			this.openDate = accountOpenedOn;
		}

// Not sure why there is a suppress warning, but the solution will work for both methods 
		public java.util.Date accountOpenedOn() {
			@SuppressWarnings("deprecation")
			Date format = new Date("MM-dd-yyyy");
			return format;
		}

		public static java.util.Date getOpenedOn() {
			@SuppressWarnings("deprecation")
			Date format = new Date("MM-dd-yyyy");
			return format;
		}

		

		
/* This is in the right direction I think, I believe what's missing is the conversion of the String accountData into  
 * an instance of BankAccount 
	*/
		public  static BankAccount readFromString(String accountData) throws ParseException {
			int commaCounter = 0;
		final int NUM_FIELDS = 4;
		String[] field = new String[NUM_FIELDS];
		
		for (int i = 0; i < NUM_FIELDS; i++) {field[i] = "";}
		
		for (int i = 0; i < accountData.length() ; i ++) {
			if (accountData.charAt(i) == ',') {
				commaCounter++;
			} 
			else {
				try {
					field[commaCounter] += accountData.charAt(i);
				}
				catch (ArrayIndexOutOfBoundsException e) {
					throw new NumberFormatException();
				}
				 
			}
		}
		if (commaCounter != NUM_FIELDS-1) {
			throw new NumberFormatException();
		}
		
		BankAccount newBankAccount = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
			newBankAccount = new BankAccount(Long.parseLong(field[0]), Double.parseDouble(field[1]),
					Double.parseDouble(field[2]), dateFormat.parse(field[3]));
		}
		catch (NumberFormatException e) {
			throw e;
			
		}
		catch (ParseException e) {
			throw new NumberFormatException();
		}
		
		return newBankAccount;}
		
		public String writeToString() {
			DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
			return this.accountNumber + "," + this.balance + "," + this.interestRate + "," + dateFormat.format(this.openDate);
		}

		public double futureValue(int years) {
			double balance = getBalance();
			double interestRate = getInterestRate();

			return balance * (Math.pow(1 + interestRate, years));
		}

		public boolean withdraw(double amount) {
			if (amount < 0) {
				System.out.println("You may not withdraw a negative amount.");
				return false;
			}
			if (amount > getBalance()) {
				System.out.println("There is not enough money in the checking account " + "to make this widrawal");
				return false;
			}

		this.balance = getBalance() - amount;
		return true;
		}

		public boolean deposit(double amount) {
			if (amount < 0) {
				System.out.println("You may not deposit a negative amount.");
				return false;
		}

		this.balance = getBalance() + amount;
			return true;
		}

		public static double getInterestRate() {
			return interestRate;
		}

		public void setInterestRate(double interestRate) {
			this.interestRate = interestRate;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public long getAccountNumber() {
			return accountNumber;
		}

		@Override
		public String toString() {
			return generateStringForToString();
		}

	/*
	 * returns a string to be used in the toString method
	 */
		public String generateStringForToString() {
			StringBuilder str = new StringBuilder();

		str.append("Checking Account Balance: " + displayInUSD(getBalance()) + "\n");
		str.append("Checking Account Interest Rate : " + String.format("%.5f", getInterestRate()) + " \n");
		str.append("Checking Account Balance in 3 years: " + displayInUSD(futureValue(3)) + "\n");

		return str.toString();
	}

	/*
	 * returns the specified decimal formatted in United States Dollar
	 */
	public String displayInUSD(double decimal) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

		return formatter.format(decimal);
	}

	

}
