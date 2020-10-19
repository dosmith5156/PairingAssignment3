package assignment3;

import java.text.ParseException;

public class AccountHolder implements Comparable<AccountHolder> {

		private String firstName;
		private String middleName;
		private String lastName;
		private String ssn;

		private CheckingAccount[] checkingAccounts = new CheckingAccount[0];
		private SavingsAccount[] savingsAccounts = new SavingsAccount[0];
		private CDAccount[] cdAccounts = new CDAccount[0];

	
		public AccountHolder() {
			this.firstName = "";
			this.middleName = "";
			this.lastName = "";
			this.ssn = "";

		}

		public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
			super();
				this.firstName = firstName;
				this.middleName = middleName;
				this.lastName = lastName;
				this.ssn = ssn;
		}
		
// getters and setters
		
		public String getFirstName() {return firstName;}
		public void setFirstName(String firstName) {this.firstName = firstName;}

		public String getMiddleName() {return middleName;}
		public void setMiddleName(String middleName) {this.middleName = middleName;}

		public String getLastName() {return lastName;}
		public void setLastName(String lastName) {this.lastName = lastName;}

		public String getSSN() {return ssn;}
		public void setSsn(String ssn) {this.ssn = ssn;}

		public CheckingAccount[] getCheckingAccounts() {return checkingAccounts;}
		public void setCheckingAccount(CheckingAccount[] checkingAccount) {this.checkingAccounts = checkingAccount;}

		public SavingsAccount[] getSavingsAccounts() {return savingsAccounts;}
		public void setSavingsAccount(SavingsAccount[] savingsAccount) {this.savingsAccounts = savingsAccount;}
		
// method that calls the SavingsAccount class and creates array of savings accounts
		public SavingsAccount addSavingsAccount(double openingBalance) {
			SavingsAccount newAccount = new SavingsAccount(openingBalance);
			SavingsAccount[] currentArray = getSavingsAccounts();

			if (currentArray == null) {
				SavingsAccount[] newSavingsAccountArray = new SavingsAccount[1];
				newSavingsAccountArray[0] = newAccount;
				this.savingsAccounts = newSavingsAccountArray;
			} 
			else if ((getSavingsBalance() + openingBalance) < 250000) {
				SavingsAccount[] newSavingsAccountArray = new SavingsAccount[currentArray.length + 1];

			for (int i = 0; i < currentArray.length; i++) {newSavingsAccountArray[i] = currentArray[i];}
				newSavingsAccountArray[newSavingsAccountArray.length - 1] = newAccount;
				this.savingsAccounts = newSavingsAccountArray;
			} 
			else {System.out.println("Your combined savings and checking account balances" + " must be less than 250,000");}

				return newAccount;
		}
// increments new savings accounts determines if account balance is too large
		public SavingsAccount addSavingsAccount(SavingsAccount savingsObj) {
			SavingsAccount[] currentArray = getSavingsAccounts();
			double sum = getSavingsBalance() + getCheckingBalance();
			if (currentArray == null) {
				if (sum < 250000) {
					SavingsAccount[] newSavingsAccountArray = new SavingsAccount[1];
					newSavingsAccountArray[0] = savingsObj;
					this.savingsAccounts = newSavingsAccountArray;
			} 
				else {
				
					System.out.println("Your combined savings and checking account balances" + " must be less than 250,000");
				}
			} 
			else if ((sum + savingsObj.getBalance()) < 250000) {
				SavingsAccount[] newSavingsAccountArray = new SavingsAccount[currentArray.length + 1];

			for (int i = 0; i < currentArray.length; i++) {newSavingsAccountArray[i] = currentArray[i];}
				newSavingsAccountArray[newSavingsAccountArray.length - 1] = savingsObj;
				this.savingsAccounts = newSavingsAccountArray;
			} 
				else {
					System.out.println("Your combined savings and checking account balances" + " must be less than 250,000");
				}

					return savingsObj;
			}
		
// method that calls the CheckingAccount class and creates array of savings accounts
		public CheckingAccount addCheckingAccount(double openingBalance) {

			CheckingAccount newAccount = new CheckingAccount(openingBalance);
			CheckingAccount[] currentArray = getCheckingAccounts();

			if (openingBalance < 250000) {
				if (currentArray == null) {
					CheckingAccount[] newCheckingAccountArray = new CheckingAccount[1];
					newCheckingAccountArray[0] = newAccount;
					this.checkingAccounts = newCheckingAccountArray;
				} 
				else {double sum = getCheckingBalance();
				if (sum < 250000) {
					CheckingAccount[] newCheckingAccountArray = new CheckingAccount[currentArray.length + 1];

					for (int i = 0; i < currentArray.length; i++) {newCheckingAccountArray[i] = currentArray[i];}
						newCheckingAccountArray[newCheckingAccountArray.length - 1] = newAccount;
						this.checkingAccounts = newCheckingAccountArray;
				} 
				else {System.out.println("Checking & Savings Balance Exceed 250,000");}
				return newAccount;
			}
				return newAccount;
			} 
				else {System.out.println("Checking & Savings Balance Exceed 250,000");
					return newAccount;
				}

		}

		public CheckingAccount addCheckingAccount(CheckingAccount checkingObj) {
			CheckingAccount[] currentArray = getCheckingAccounts();
			double sum = getCheckingBalance() + getSavingsBalance();

			if (currentArray == null) {
				if (sum < 250000) {
					CheckingAccount[] newCheckingAccountArray = new CheckingAccount[1];
					newCheckingAccountArray[0] = checkingObj;
					this.checkingAccounts = newCheckingAccountArray;
				} 	
				else {
				System.out.println("Checking & Savings Balance Exceed 250,000");}
			} 
			
			else if ((sum + checkingObj.getBalance()) < 250000) {
				CheckingAccount[] newCheckingAccountArray = new CheckingAccount[currentArray.length + 1];

				for (int i = 0; i < currentArray.length; i++) {newCheckingAccountArray[i] = currentArray[i];}
					newCheckingAccountArray[newCheckingAccountArray.length - 1] = checkingObj;
					this.checkingAccounts = newCheckingAccountArray;
			} 
			else {System.out.println("Checking & Savings Balance Exceed 250,000");}
				return checkingObj;
		}

		public double getCheckingBalance() {
			CheckingAccount[] currentCheckingAccount = getCheckingAccounts();
			double checkingBalance = 0;
			if (currentCheckingAccount != null) {
				for (int i = 0; i < currentCheckingAccount.length; i++) {
					checkingBalance += currentCheckingAccount[i].getBalance();
				}
			}

				return checkingBalance;
		}

		public double getSavingsBalance() {
		SavingsAccount[] currentSavingsAccount = getSavingsAccounts();
		double savingsBalance = 0;
		if (currentSavingsAccount != null) {
			for (int i = 0; i < currentSavingsAccount.length; i++) {
				savingsBalance += currentSavingsAccount[i].getBalance();
			}
		}

		return savingsBalance;
	}

	
	

	public CDAccount[] getCDAccounts() {return cdAccounts;}
	
	// This first one creates a new CDAccount...
	
	public CDAccount addCDAccount(CDOffering offering, double openingBalance) throws ParseException {
	CDAccount newName = new CDAccount(offering, openingBalance);
	return addCDAccount(newName);
	}
	
	// ... and this second one adds it to the CDAccount array.
	
	public CDAccount addCDAccount(CDAccount cdAccount) {
		CDAccount[] newArray = new CDAccount[cdAccounts.length + 1];
		int i;
		for (i = 0; i < cdAccounts.length; i++) {
			newArray[i] = cdAccounts[i];
		}
		newArray[i] = cdAccount;
		cdAccounts = newArray;
		return cdAccount;
	}



	public double getCDBalance() {
		CDAccount[] currentCdAccounts = getCDAccounts();
		double CdBalance = 0;

		if (currentCdAccounts != null) {
			for (int i = 0; i < cdAccounts.length; i++){
				CdBalance += cdAccounts[i].getBalance();
			}
		}

		return CdBalance;
	}


	public double getCombinedBalance() {

		return getCheckingBalance() + getSavingsBalance() + getCDBalance();
	}

	public int getNumberOfCheckingAccounts() {
		int numberOfCheckingAccounts = 0;

		if (checkingAccounts == null) {
			return numberOfCheckingAccounts;
		} else {
			return checkingAccounts.length;
		}
	}

	public int getNumberOfSavingsAccounts() {
		int numberOfSavingsAccounts = 0;
		if (savingsAccounts == null) {
			return numberOfSavingsAccounts;
		} else {
			return savingsAccounts.length;
		}
	}

	public int getNumberOfCDAccounts() {
		int numberOfCDAccounts = 0;
		if (cdAccounts == null) {
			return numberOfCDAccounts;
		} else {
			return cdAccounts.length;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * returns the state of the object as a string.
	 */
	@Override
	public String toString() {
		return generateStringForToString();
	}

	
	private String generateStringForToString() {
		StringBuilder str = new StringBuilder();

		// append the name
		str.append("Name: " + getFirstName() + " " + getMiddleName() + " " + getLastName() + "\n");

		
		str.append("SSN: " + getSSN() + "\n");

		
		str.append(getCheckingAccounts().toString());

		// append savings account balance
		// append savings account interest rate
		// append the savings account balance in 3 years
		str.append(getSavingsAccounts().toString());

		// return the StringBuilder object as a string.
		return str.toString();
	}

	@Override
	public int compareTo(AccountHolder otherAccountHolder) {
		if(getCombinedBalance() == otherAccountHolder.getCombinedBalance()) {
			return 0;
		} else if (getCombinedBalance() > otherAccountHolder.getCombinedBalance()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public String writeToString() {
		return firstName+", "+ middleName+", "+ lastName+", "+ ssn;
	}
	
	public static AccountHolder readFromString(String accountHolderData) throws Exception {
		String[] accountinfo = accountHolderData.split(",");
		AccountHolder accountHolder = new AccountHolder(accountinfo[0], accountinfo[1], accountinfo[2], accountinfo[3]);
		return accountHolder;
	}
	
}