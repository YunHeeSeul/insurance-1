package Practice.InsuranceCompany.Design.src.model.customer;


import Practice.InsuranceCompany.Design.src.etcEnum.Gender;
import Practice.InsuranceCompany.Design.src.model.policyholder.DiseaseHistory;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedBuildingInfo;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedCarInfo;

public class Customer {

	// cs1

	private String address;
	private String customerID;
	private CustomerType customerType;
	private String dateOfBirth;
	private String emailAddress;
	private Gender gender;
	private String name;
	private String phoneNumber;
	private String residentRegistrationNumber;

	public Customer(){
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

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

	public void setResidentRegistrationNumber(String residentRegistrationNumber) {
		this.residentRegistrationNumber = residentRegistrationNumber;
	}

	/*** 아래 정보는 잠재 고객 및 가입자 모두에게 필요 ***/
	public DiseaseHistory m_DiseaseHistory;
	public OwnedBuildingInfo m_OwnedBuildingInfo;
	public OwnedCarInfo m_OwnedCarInfo;

	public DiseaseHistory getDiseaseHistory() {
		return m_DiseaseHistory;
	}

	public OwnedBuildingInfo getOwnedBuildingInfo() {
		return m_OwnedBuildingInfo;
	}

	public OwnedCarInfo getOwnedCarInfo() {
		return m_OwnedCarInfo;
	}



	public String getCustomerID(){ return this.customerID; }

	public void printInsuranceDetails(){
		System.out.println("ID : " + this.customerID);
		System.out.println("Name : " + this.name);
		System.out.println("Date of Birth : " + this.dateOfBirth);

	}

}//end Customer