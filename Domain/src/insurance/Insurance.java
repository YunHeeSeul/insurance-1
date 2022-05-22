package Practice.InsuranceCompany.Design.Domain.src.insurance;


import Practice.InsuranceCompany.Design.Domain.src.contract.Contract;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:49
 */
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

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param peril
	 */
	public double calculateRate(double peril){
		return 0;
	}

	/**
	 * 
	 * @param permisson
	 */
	public boolean modifyPermission(boolean permisson){
		return false;
	}

	public void printInsuranceDetails(){

	}
}//end Insurance