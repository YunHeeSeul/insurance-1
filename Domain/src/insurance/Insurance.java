package Practice.InsuranceCompany.Design.Domain.src.insurance;


import Practice.InsuranceCompany.Design.Domain.src.contract.Contract;

import java.util.ArrayList;

public class Insurance {

	private AcquisitionPolicy acquisitionPolicy;

	private String insuranceEx;
	private String insuranceID;
	private String insuranceName;
	private InsuranceType insuranceType;

	private int joinAge;
	private double peril;
	private boolean permission;
	private int premium;
	private double rate;

	private ArrayList<WarrantyInfo> warrantyContent;
	public AcquisitionPolicy m_AcquisitionPolicy;
	public WarrantyInfo m_WarrantyInfo;
	public Contract m_Contract;

	public Insurance(){

	}

	public double calculateRate(double peril){
		return 0;
	}

	public boolean modifyPermission(boolean permisson){
		return false;
	}

	public void printInsuranceDetails(){

	}
}