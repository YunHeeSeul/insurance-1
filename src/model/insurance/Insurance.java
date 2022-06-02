package Practice.InsuranceCompany.Design.src.model.insurance;


import Practice.InsuranceCompany.Design.src.model.contract.Contract;
import Practice.InsuranceCompany.Design.src.model.policyholder.DiseaseHistory;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedBuildingInfo;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedCarInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class Insurance {

	private static int IDnum = 0;

	private AcquisitionPolicy acquisitionPolicy;

	private String insuranceEx;
	private String insuranceID;
	private String insuranceName;
	private InsuranceType insuranceType;

	private int joinAge;
	private double peril;
	private boolean permission;
	private int premium;

	public ArrayList<WarrantyInfo> getWarrantyContent() {
		return warrantyContent;
	}

	public void setWarrantyContent(ArrayList<WarrantyInfo> warrantyContent) {
		this.warrantyContent = warrantyContent;
	}

	private double rate;

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

	public boolean isPermission() {
		return permission;
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

	private ArrayList<WarrantyInfo> warrantyContent;
	public AcquisitionPolicy m_AcquisitionPolicy;
	public WarrantyInfo m_WarrantyInfo;
	public Contract m_Contract;

	public Insurance(){
		this.insuranceID = Integer.toString(IDnum + 1);
		this.peril = 0.0;
		this.permission = false;
		this.rate = 0.0;
		this.warrantyContent = new ArrayList<>(10);
		this.acquisitionPolicy = null;
	}

	public String getInsuranceID(){ return this.insuranceID; }
	public InsuranceType getInsuranceType(){ return this.insuranceType; }
	public int getPremium(){ return this.premium; }
	public AcquisitionPolicy getAcquisitionPolicy(){ return this.m_AcquisitionPolicy; }

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

	public void printInsuranceDetails(){
		System.out.println("ID : " + this.insuranceID);
		System.out.println("보험명 : " + this.insuranceName);
		System.out.println("보험 정보 : " + this.insuranceEx);
		System.out.println("가입제한연령 : " + this.joinAge);
		System.out.println("기본 보험료 : " + this.premium + "원");
		System.out.println("보장 내용 :");
		for(int i=0; i<this.warrantyContent.size(); i++){
			System.out.println("항목" + (i+1));
			System.out.println("보장 정보 : " + this.warrantyContent.get(i).getWarrantyInfo());
			System.out.println("보장 금액 : " + this.warrantyContent.get(i).getWarrantyAmount());
			System.out.println("보장 내용 : " + this.warrantyContent.get(i).getWarrantyContent());
			System.out.println("보장 조건 : " + this.warrantyContent.get(i).getWarrantyConditions());
		}
	}

	/*** methods for VInsurance  ***/


	public void addAcquisitionPolicy() {
		System.out.println("<== 보험상품 '" + this.insuranceName + "'의 인수정책을 등록합니다. ==>");
		this.acquisitionPolicy = new AcquisitionPolicy();
		if(this.insuranceType == InsuranceType.car) {
			OwnedCarInfo ownedCarInfo = new OwnedCarInfo();
//			ownedCarInfo.
			this.acquisitionPolicy.registerCInfoPolicy(ownedCarInfo);
		}
		else if(this.insuranceType == InsuranceType.fire) {
			OwnedBuildingInfo ownedBuildingInfo = new OwnedBuildingInfo();
			ownedBuildingInfo.setBuildingInfoForAcquisitionPolicy(new Scanner(System.in));
			this.acquisitionPolicy.registerBInfoPolicy(ownedBuildingInfo);
		}
		else if(this.insuranceType == InsuranceType.personalHealth){
			DiseaseHistory diseaseHistory = new DiseaseHistory();
//			diseaseHistory.
			this.acquisitionPolicy.registerDInfoPolicy(diseaseHistory);
		}
		else
			System.out.println("보험의 세부 종류가 등록되어있지 않으므로, 인수정책을 등록할 수 없습니다.");
	}

}