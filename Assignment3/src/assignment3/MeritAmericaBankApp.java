package assignment3;

public class MeritAmericaBankApp {
	
	private static final String READ_FILE_NAME = "accountData.txt";
	private static final String WRITE_FILE_NAME = "accountData.txt";
	
	public static void main(String[] args) throws Exception {
		MeritBank.readFromFile("accounts.txt");
		System.out.println("Hello Merit America!");
		
		
		MeritBank.setCDOfferings(initialCDOfferings());
					
		
		AccountHolder newAcc1 = new AccountHolder("Dominc", "Fontez", "Smith", "111111111");
					
		
		newAcc1.addCheckingAccount(new CheckingAccount(1000.00));
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addSavingsAccount(new SavingsAccount(10000.00));
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addCheckingAccount(5000.00);
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addSavingsAccount(50000.00);
					System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addCheckingAccount(50000.00);
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addSavingsAccount(500000);
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addCheckingAccount(5000.00);
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addSavingsAccount(50000.00);
		System.out.println(newAcc1.getCombinedBalance());
					
		
		System.out.println(newAcc1.getNumberOfCheckingAccounts());
		System.out.println(newAcc1.getNumberOfSavingsAccounts());
		System.out.println(newAcc1.getCheckingBalance() + newAcc1.getSavingsBalance());
					
		CDOffering bestCDOffering = MeritBank.getBestCDOffering(100);
		CDAccount aCDAccount = new CDAccount(bestCDOffering, 100);
		System.out.println("aCDAccount's balance: " + aCDAccount.getBalance());

		newAcc1.addCDAccount(aCDAccount);
		
		MeritBank.addAccountHolder(newAcc1);
		
				AccountHolder ah2 = new AccountHolder("Tim", "William", "Miller", "2545156581");
				ah2.addCheckingAccount(1000);
				ah2.addSavingsAccount(10000);
				ah2.addCDAccount(MeritBank.getSecondBestCDOffering(20000), 20000);
				MeritBank.addAccountHolder(ah2);
				MeritBank.clearCDOfferings();
				
				AccountHolder ah3 = new AccountHolder("Kim", "", "Green", "578413333");
				ah3.addCDAccount(MeritBank.getSecondBestCDOffering(30000), 30000);
				System.out.println("CD Account Balance: " + ah3.getCDBalance());
				ah3.addCheckingAccount(1000);
				ah3.addSavingsAccount(10000);
				MeritBank.addAccountHolder(ah3);
		
		
		
	}
	
	public static CDOffering[] initialCDOfferings() {
		CDOffering[] cdOfferings = new CDOffering[5];
		cdOfferings[0] = new CDOffering(1, 1.8 / 100);
		cdOfferings[1] = new CDOffering(2, 1.9 / 100);
		cdOfferings[2] = new CDOffering(3, 2.0 / 100);
		cdOfferings[3] = new CDOffering(5, 2.5 / 100);
		cdOfferings[4] = new CDOffering(10, 2.2 / 100);

		return cdOfferings;
	}
	
}


