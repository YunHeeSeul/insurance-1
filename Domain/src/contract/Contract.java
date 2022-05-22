package Practice.InsuranceCompany.Design.Domain.src.contract;


import Practice.InsuranceCompany.Design.Domain.src.customer.CustomerListImpl;

import java.util.Date;

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

	public boolean modifyActivityI(String residentRegistrationNumber){
		return false;
	}

	public CustomerListImpl searchActivityT(){
		return null;
	}
}//end Contract