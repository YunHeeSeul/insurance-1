package Practice.InsuranceCompany.Design.src.policyholder;


import Practice.InsuranceCompany.Design.src.customer.Customer;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
public class Policyholder extends Customer {

	private boolean acceptedAccidentExistence;
	private AccountInfo accountInfo;
	private ArrayList<DiseaseHistory> diseaseHistory;
	private int ownedBuildingNumber;
	private boolean paymentState;
	private int totalPremiumOfMonth;
	public AccountInfo m_AccountInfo;
	public DeseaseHistory m_DeseaseHistory;
	public OwnedBuildingInfo m_OwnedBuildingInfo;
	public OwnedCarInfo m_OwnedCarInfo;

	public Policyholder(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param paymentState
	 */
	public void changePaymentState(boolean paymentState){

	}

	public boolean getPaymentState(){
		return false;
	}

	public int getTotalPremiumOfMonth(){
		return 0;
	}
}//end Policyholder