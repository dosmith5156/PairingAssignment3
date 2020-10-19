package assignment3;

	public class CDOffering {

		private int term;
		private double interestRate;
	
		public CDOffering()	{
		
		}
		public CDOffering(int term, double interestRate) {
			this.term = term;
			this.interestRate = interestRate;
		}
	

		public int getTerm() {return term;}

		public double getInterestRate() {return interestRate;}
		
		 static CDOffering readFromString(String cdOfferingDataString) 
		 {
		    	String[] cdString = cdOfferingDataString.split(",");
		    	int term = Integer.parseInt(cdString[0]);
		    	double interestRate = Double.parseDouble(cdString[1]);
		    	return new CDOffering(term, interestRate);
		  }

		public String writeToString() 
		{
		    	StringBuilder cdData = new StringBuilder();
		    	cdData.append(term).append(",");
		    	cdData.append(interestRate);
		    	return cdData.toString(); 
}
}