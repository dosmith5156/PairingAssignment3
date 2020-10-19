package assignment3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

	public class SavingsAccount extends BankAccount {
	
		//private double interestRate = 0.01;
	
		public SavingsAccount() {
			super();
		}
		
		public SavingsAccount(double openingBalance) {
			super(openingBalance);
		}
	
		public SavingsAccount(double openingBalance, double interestRate) {
			super(openingBalance, interestRate);
		}
	
		public SavingsAccount(long accountNumber, double openingBalance, double interestRate) {
			super(accountNumber, openingBalance, interestRate);
		}
	
		public SavingsAccount(long accountNumber, double openingBalance, double interestRate, java.util.Date accountOpenedOn) {
			super(accountNumber, openingBalance, interestRate, accountOpenedOn);
		}
		
		public static SavingsAccount readFromString(String accountData) throws ParseException {
			int commaCounter = 0;
			final int NUM_FIELDS = 4; 

			String[] field = new String[NUM_FIELDS];
			for (int i = 0; i < NUM_FIELDS; i++) {
				field[i] = "";
			}
			
			for (int i = 0; i < accountData.length() ; i ++) {
				if (accountData.charAt(i) == ',') {
					commaCounter++;
				} else {
					try {
						field[commaCounter] += accountData.charAt(i);
					}
					catch (ArrayIndexOutOfBoundsException e) {
						throw new NumberFormatException();
					}
					 
				}
			}
			if (commaCounter != NUM_FIELDS) {
				throw new NumberFormatException();
			}
			
			SavingsAccount newSavingsAccount = null;
			try {
				DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
				newSavingsAccount = new SavingsAccount(Long.parseLong(field[0]), Double.parseDouble(field[1]),
						Double.parseDouble(field[2]), dateFormat.parse(field[3]));
			}
			catch (NumberFormatException e) {
				throw e;
				
			}
			catch (ParseException e) {
				throw new NumberFormatException();
			}
			
			return newSavingsAccount;
		}
}