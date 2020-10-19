package assignment3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import com.meritamerica.assignment1.BankAccount;

	public class CheckingAccount extends BankAccount {
	
		public CheckingAccount() {
			super();
		}
	
		public CheckingAccount(double openingBalance) {
			super(openingBalance);
		}
	
		public CheckingAccount(double openingBalance, double interestRate) throws ParseException {
			super(openingBalance, interestRate);
		}
	
		public CheckingAccount(long accountNumber, double openingBalance, double interestRate) {
			super(accountNumber, openingBalance, interestRate);
		}
		
		public CheckingAccount(long accountNumber, double openingBalance, double interestRate, java.util.Date accountOpenedOn) {
			super(accountNumber, openingBalance, interestRate, accountOpenedOn);
		}
		
		public static CheckingAccount readFromString(String accountData) throws NumberFormatException{
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
			if (commaCounter != NUM_FIELDS-1) {
				throw new NumberFormatException();
			}
			
			CheckingAccount newCheckingAccount = null;
			try {
				DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
				newCheckingAccount = new CheckingAccount(Long.parseLong(field[0]), Double.parseDouble(field[1]),
						Double.parseDouble(field[2]), dateFormat.parse(field[3]));
			}
			catch (NumberFormatException e) {
				throw e;
				
			}
			catch (ParseException e) {
				throw new NumberFormatException();
			}
			
			return newCheckingAccount;
		}
}