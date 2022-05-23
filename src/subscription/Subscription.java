package Practice.InsuranceCompany.Design.src.subscription;


import Practice.InsuranceCompany.Design.src.etcEnum.UnderwritingStatus;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
public class Subscription {

	private String customerID;
	private Date dateCreated;
	private String insuranceAgentID;
	private String insuranceID;
	private int insurancePeriod;
	private int premium;
	private String subscriptionID;
	private UnderwritingStatus underwritingStatus;

	public Subscription(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param customerID
	 * @param potentialCustomerID
	 */
	public boolean signUpUnderwriting(String customerID, String potentialCustomerID){
		return false;
	}
}//end Subscription