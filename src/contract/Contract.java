package Practice.InsuranceCompany.Design.src.contract;


import Practice.InsuranceCompany.Design.src.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.insurance.Insurance;

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

	public String getInsuranceIDOfContract(){ return this.insuranceID; }
}//end Contract