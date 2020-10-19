package assignment3;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

	public class CDAccount extends BankAccount {
		private int term;
	
//		private CDOffering offering;
//		private double balance;
	
		public CDAccount(CDOffering offering, double balance) throws ParseException {
			super(balance, offering.getInterestRate());
			this.term = offering.getTerm();
		}
		
		public CDAccount(CDOffering offering, double balance, Date accountOpenedOn) {
			super(balance, offering.getInterestRate(), accountOpenedOn);
			this.term = offering.getTerm();
		}

		public CDAccount(long accountNumber, CDOffering offering, double balance, Date accountOpenedOn) {
			super(accountNumber, balance, offering.getInterestRate(), accountOpenedOn);
			this.term = offering.getTerm();
		}
		
		@Override
		public boolean deposit(double amount) {return false;}
		
		@Override
		public boolean withdraw(double amount) {return false;}
		
		public static CDAccount readFromString(String accountData) throws NumberFormatException{
			int commaCounter = 0;
			final int NUM_FIELDS = 5;
			String[] field = new String[NUM_FIELDS];
			
			for (int i = 0; i < NUM_FIELDS; i++) {
				field[i] = "";
			}
			
			for ( int i = 0; i < accountData.length(); i++) {
				if (accountData.charAt(i) == ',') {
					commaCounter ++;
				} else {
					try {
						field[commaCounter] += accountData.charAt(i);
					}
					catch (ArrayIndexOutOfBoundsException e ) {
						throw new NumberFormatException(); 
					}
						
				}
			}
			if (commaCounter != NUM_FIELDS-1) {
				throw new NumberFormatException();
			}
			CDAccount newCDAccount = null;
			try {
				DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
				CDOffering newCDOffering = new CDOffering (Integer.parseInt(field[4]), Double.parseDouble(field[2]));
				newCDAccount = new CDAccount(Long.parseLong(field[0]), newCDOffering, Double.parseDouble(field[1]), dateFormat.parse(field[3]));
			}
			catch (NumberFormatException e) {
				throw e;
				
			}
			catch (ParseException e) {
				throw new NumberFormatException();
			}
			
			return newCDAccount;
		}

		
		public String writeTostring() {
			DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
			return this.getAccountNumber() + "," + this.getBalance() + "," + BankAccount.getInterestRate() + "," + dateFormat.format(this.openDate) + "," + this.term;
		}}