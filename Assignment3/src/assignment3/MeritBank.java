package assignment3;

import java.util.Arrays;
import java.util.Collections;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MeritBank {

	private static AccountHolder[] accountHolders;
	private static CDOffering[] cdOfferings;
	private static int accountNumber = 999;
	static List number;
	static List firstWord;
	static List rest;
	private static long nextAccountNumber = 0;
	private static AccountHolder AccountHoldersArray[] = new AccountHolder[0];
	private static CDOffering CDOfferingsArray[] = new CDOffering[0];

	public static void addAccountHolder(AccountHolder accountHolder) {
		AccountHolder[] newArray = new AccountHolder[1];
		newArray[0] = accountHolder;
		accountHolders = newArray;
	}

	public static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}

	public static CDOffering[] getCDOfferings() {

		return cdOfferings;
	}

	public static CDOffering getBestCDOffering(double depositAmount) {
		CDOffering offering = new CDOffering();

		return offering;
	}

	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		CDOffering offering = new CDOffering();

		return offering;
	}

	public static void clearCDOfferings() {
		if (getCDOfferings() != null) {
			for (int i = 0; i < cdOfferings.length; i++) {
				cdOfferings[i] = new CDOffering();
			}
		}
	}

	public static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = new CDOffering[5];
		cdOfferings[0] = new CDOffering(1, 1.8 / 100);
		cdOfferings[1] = new CDOffering(2, 1.9 / 100);
		cdOfferings[2] = new CDOffering(3, 2.0 / 100);
		cdOfferings[3] = new CDOffering(5, 2.5 / 100);
		cdOfferings[4] = new CDOffering(10, 2.2 / 100);
	}

	static long getNextAccountNumber() {long x = 0;return x;}

	public static double totalBalances() {double totalBalance = 0; return totalBalance;}

	public static double futureValue(double presentValue, double interestRate, int term) {double something = 0; return something;}
	
	public static AccountHolder readFromString(String accountHolderData) {
	    String[] holding = accountHolderData.split(",");
	    String firstName = holding[0];
	    String middleName = holding[1];
	    String lastName = holding[2];
	    String ssn = holding[3];	
	    return new AccountHolder(firstName, middleName, lastName, ssn);
	}
	
	public static boolean readFromFile(String fileName) throws Exception {
		CDOffering offering[] = new CDOffering[0];
		try {
			FileReader reader = new FileReader (fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);
			Long nextAccountNumber = Long.valueOf(bufferedReader.readLine());
			int holdOfferNum = Integer.valueOf(bufferedReader.readLine());
				for(int i = 0; i < holdOfferNum; i++) {
					offering = Arrays.copyOf(offering, offering.length + 1);
					offering [offering.length-1] = CDOffering.readFromString(bufferedReader.readLine());
				}
			int numOfAcctHld = Integer.valueOf(bufferedReader.readLine());
			AccountHolder [] newAccountHolders = new AccountHolder[numOfAcctHld];
			for(int i = 0; i<numOfAcctHld; i++) {				
				AccountHolder acctH = AccountHolder.readFromString(bufferedReader.readLine());
				int numOfChecking = Integer.valueOf(bufferedReader.readLine());
					for(int j = 0; j<numOfChecking; j++) {
						acctH.addCheckingAccount(CheckingAccount.readFromString(bufferedReader.readLine()));				
					}
				int numOfSavings = Integer.valueOf(bufferedReader.readLine());
					for(int k = 0; k<numOfSavings; k++) {
						acctH.addSavingsAccount(SavingsAccount.readFromString(bufferedReader.readLine()));				
					}
				int numOfCD = Integer.valueOf(bufferedReader.readLine());
					for(int m = 0; m<numOfCD; m++) {
						acctH.addCDAccount(CDAccount.readFromString(bufferedReader.readLine()));				
					}
				newAccountHolders[i] = acctH;	
			}
			setNextAccountNumber(nextAccountNumber);
			CDOfferingsArray = offering;
			AccountHoldersArray = newAccountHolders;
			reader.close();
			return true;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean writeToFile(String fileName) {
		return true;
	}
	
	public static AccountHolder[] sortAccountHolders() {
		Arrays.sort(AccountHoldersArray, Collections.reverseOrder());
		for(AccountHolder a : AccountHoldersArray) {
			System.out.println(a);
		}
	return AccountHoldersArray;
	}
	
	public static void setNextAccountNumber(long nextAccountNumber) {
		nextAccountNumber = accountNumber;
	}

}
