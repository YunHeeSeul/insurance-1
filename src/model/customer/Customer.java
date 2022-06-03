package Practice.InsuranceCompany.Design.src.model.customer;


import Practice.InsuranceCompany.Design.src.etcEnum.Gender;
import Practice.InsuranceCompany.Design.src.model.contract.Contract;
import Practice.InsuranceCompany.Design.src.model.policyholder.DiseaseHistory;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedBuildingInfo;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedCarInfo;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public class Customer {

//	private static int IDNum = 0;

	private String address;
	private String customerID;
	private CustomerType customerType;
	private String dateOfBirth;
	private String emailAddress;
	private Gender gender;
	private String name;
	private String phoneNumber;
	private String residentRegistrationNumber;
	public Contract m_Contract;


	/*** 아래 정보는 잠재 고객 및 가입자 모두에게 필요 ***/
	public DiseaseHistory m_DiseaseHistory;
	public OwnedBuildingInfo m_OwnedBuildingInfo;
	public OwnedCarInfo m_OwnedCarInfo;


	public Customer(){
//		this.customerID = Integer.toString(IDNum++);
	}

	public void setCustomerID(String customerID) { this.customerID = customerID; }
	public void setCustomerType(CustomerType customerType) { this.customerType = customerType; }
	public String getCustomerID(){ return this.customerID; }
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateOfBirth() { return dateOfBirth; }
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getResidentRegistrationNumber() {
		return residentRegistrationNumber;
	}
	public void setResidentRegistrationNumber(String residentRegistrationNumber) { this.residentRegistrationNumber = residentRegistrationNumber; }
	public DiseaseHistory getDiseaseHistory() {
		return m_DiseaseHistory;
	}
	public OwnedBuildingInfo getOwnedBuildingInfo() {
		return m_OwnedBuildingInfo;
	}
	public OwnedCarInfo getOwnedCarInfo() {
		return m_OwnedCarInfo;
	}
	public void setDiseaseHistory(DiseaseHistory m_DiseaseHistory) { this.m_DiseaseHistory = m_DiseaseHistory; }
	public void setOwnedBuildingInfo(OwnedBuildingInfo m_OwnedBuildingInfo) { this.m_OwnedBuildingInfo = m_OwnedBuildingInfo; }
	public void setOwnedCarInfo(OwnedCarInfo m_OwnedCarInfo) { this.m_OwnedCarInfo = m_OwnedCarInfo; }


	// view
	public void printInsuranceDetails(){
		System.out.println("ID : " + this.customerID);
		System.out.println("Name : " + this.name);
		System.out.println("Date of Birth : " + this.dateOfBirth);
	}

	public void finalize() throws Throwable {

	}
}//end Customer