package Practice.InsuranceCompany.Design.Domain.src.contract;


import Practice.InsuranceCompany.Design.Domain.src.customer.CustomerListImpl;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public class Contract {

	private String contractID;
	private int contractTerm;
	private String customerID;
	private String insuranceID;
	private String insurancePlannerID;
	private Date joinDate;
	private Date maintenanceDate;
	private int monthlyPremium;

	public Contract(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param residentRegistrationNumber
	 */
	public boolean modifyActivityI(String residentRegistrationNumber){
		return false;
	}

	public CustomerListImpl searchActivityT(){
		return null;
	}
}//end Contract