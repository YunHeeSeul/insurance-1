package Practice.InsuranceCompany.Design.src.model.insurance;

import Practice.InsuranceCompany.Design.src.enums.InsuranceType;

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

	public Insurance(){
		this.peril = 0.0;
		this.permission = false;
		this.rate = 0.0;
		this.warrantyContent = new ArrayList<>(10);
		this.acquisitionPolicy = null;
	}

	public void setWarrantyContent(ArrayList<WarrantyInfo> warrantyContent) {
		this.warrantyContent = warrantyContent;
	}
	public void setAcquisitionPolicy(AcquisitionPolicy acquisitionPolicy) {
		this.acquisitionPolicy = acquisitionPolicy;
	}
	public String getInsuranceEx() {
		return insuranceEx;
	}
	public void setInsuranceEx(String insuranceEx) {
		this.insuranceEx = insuranceEx;
	}
	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}
	public int getJoinAge() {
		return joinAge;
	}
	public void setJoinAge(int joinAge) {
		this.joinAge = joinAge;
	}
	public double getPeril() {
		return peril;
	}
	public void setPeril(double peril) {
		this.peril = peril;
	}
	public void setPermission(boolean permission) {
		this.permission = permission;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public ArrayList<WarrantyInfo> getWarrantyContent() {
		return warrantyContent;
	}
	public String getInsuranceID(){ return this.insuranceID; }
	public InsuranceType getInsuranceType(){ return this.insuranceType; }
	public int getPremium(){ return this.premium; }
	public AcquisitionPolicy getAcquisitionPolicy(){ return this.acquisitionPolicy; }


	public boolean isPermission() {
		return permission;
	}


	public double calculateRate(double peril){
		return peril*0.4;
	}

	public boolean modifyPermission(boolean permisson){
		if(this.warrantyContent != null) {
			this.permission = permisson;
			return true;
		} else
			return false;
	}
}