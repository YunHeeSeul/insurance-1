package Practice.InsuranceCompany.Design.src.model.subscription;


import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.etcEnum.UnderwritingStatus;
import Practice.InsuranceCompany.Design.src.model.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.model.insurance.InsuranceListImpl;
import Practice.InsuranceCompany.Design.src.model.insurance.InsuranceType;
import Practice.InsuranceCompany.Design.src.model.policyholder.DiseaseHistory;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedBuildingInfo;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedCarInfo;

public class Subscription {

	private String customerID;
	private String dateCreated;
	private String insuranceAgentID;
	private String insuranceID;
	private int insurancePeriod;
	private int premium;
	private String subscriptionID;
	private UnderwritingStatus underwritingStatus;

	public Subscription(){

	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getInsuranceAgentID() {
		return insuranceAgentID;
	}

	public int getInsurancePeriod() {
		return insurancePeriod;
	}

	public int getPremium() {
		return premium;
	}

	public String getSubscriptionID() {
		return subscriptionID;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public UnderwritingStatus getUnderwritingStatus() {
		return underwritingStatus;
	}

	public void finalize() throws Throwable {

	}

	public void updateUnderwritingStatus(UnderwritingStatus underwritingStatus){
		this.underwritingStatus = underwritingStatus;
	}

	public void printInfo() {
		System.out.println("청약서 작성일자 : " + this.dateCreated);
		System.out.println("담당 보험설계사 ID : " + this.insuranceAgentID);
		System.out.println("가입 신청된 보험 ID : " + this.insuranceID);
		System.out.println("가입 신청한 고객 ID : " + this.customerID);
		System.out.println("인수심사 신청 여부 : " + this.underwritingStatus.getDetail());
	}

	public boolean signUpUnderwriting(CustomerListImpl customerList, InsuranceListImpl insuranceList){
		Customer customer = customerList.getByCustomerId(this.customerID);
		Insurance insurance = insuranceList.get(this.insuranceID);
		this.checkAvailabilityOfUW(customer, insurance);
		return false;
	}


	/*** methods for Signup UW ***/
	private boolean checkAvailabilityOfUW(Customer customer, Insurance insurance) {
		// 자동차 보험일 경우
		if(insurance.getInsuranceType() == InsuranceType.car){
			OwnedCarInfo ownedCarInfo = customer.getOwnedCarInfo();
			return this.checkAvailabilityOfCarInsurance(insurance, ownedCarInfo);
		}
		// 화재 보험일 경우
		else if(insurance.getInsuranceType() == InsuranceType.fire){
			OwnedBuildingInfo ownedBuildingInfo = customer.getOwnedBuildingInfo();
			return this.checkAvailabilityOfFireInsurance(insurance, ownedBuildingInfo);
		}
		// 실손 보험일 경우
		else if(insurance.getInsuranceType() == InsuranceType.personalHealth){
			DiseaseHistory diseaseHistory = customer.getDiseaseHistory();
			return this.checkAvailabilityOfHealthInsurance(insurance, diseaseHistory);
		}
		else{
			System.out.println("보험의 세부 종류가 올바르지 않습니다.");
			return false;
		}
	}


	private boolean checkAvailabilityOfHealthInsurance(Insurance insurance, DiseaseHistory diseaseHistory) {
		// 중증도, 투병기간
		DiseaseHistory availableDiseaseHistory = insurance.getAcquisitionPolicy().getDiseaseInfoPolicy();
		if(diseaseHistory.getSeverity().getLevelNum() <= availableDiseaseHistory.getSeverity().getLevelNum()
			&& diseaseHistory.getStrugglePeriod() <= availableDiseaseHistory.getStrugglePeriod()){
			System.out.println("인수 허가가 가능한 고객입니다.");
			return true;
		} else {
			System.out.println("인수 허가가 불가능한 고객입니다.");
			return false;
		}

	}

	private boolean checkAvailabilityOfFireInsurance(Insurance insurance, OwnedBuildingInfo ownedBuildingInfo) {
		// 건물 층 수, 특수건물 여부
		OwnedBuildingInfo availableBuildingInfo = insurance.getAcquisitionPolicy().getBuildingInfoPolicy();
		if(availableBuildingInfo.getFloorNumber() >= ownedBuildingInfo.getFloorNumber()
				&& availableBuildingInfo.getSpecializedBuilding() == ownedBuildingInfo.getSpecializedBuilding()){
			System.out.println("인수 허가가 가능한 고객입니다.");
			return true;
		} else {
			System.out.println("인수 허가가 불가능한 고객입니다.");
			return false;
		}
	}

	private boolean checkAvailabilityOfCarInsurance(Insurance insurance, OwnedCarInfo ownedCarInfo) {
		// 사고 횟수, 법규 위반 횟수
		OwnedCarInfo availableCarInfo = insurance.getAcquisitionPolicy().getCarInfoPolicy();
		if(availableCarInfo.getAccidentNumber() >= ownedCarInfo.getAccidentNumber()
			&& availableCarInfo.getAvailableNumOfViolation() >= ownedCarInfo.getViolationHistory().size()){
			System.out.println("인수 허가가 가능한 고객입니다.");
			return true;
		} else{
			System.out.println("인수 허가가 불가능한 고객입니다.");
			return false;
		}
	}

}//end Subscription