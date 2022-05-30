package Practice.InsuranceCompany.Design.src.customer;


import Practice.InsuranceCompany.Design.src.etcEnum.Gender;
import Practice.InsuranceCompany.Design.src.contract.Contract;
import Practice.InsuranceCompany.Design.src.policyholder.DiseaseHistory;
import Practice.InsuranceCompany.Design.src.policyholder.OwnedBuildingInfo;
import Practice.InsuranceCompany.Design.src.policyholder.OwnedCarInfo;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public class Customer {

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

	public DiseaseHistory getDiseaseHistory() {
		return m_DiseaseHistory;
	}

	public OwnedBuildingInfo getOwnedBuildingInfo() {
		return m_OwnedBuildingInfo;
	}

	public OwnedCarInfo getOwnedCarInfo() {
		return m_OwnedCarInfo;
	}

	public Customer(){

	}

	public String getCustomerID(){ return this.customerID; }
	public String getName(){ return this.name; }
	
	public void printInsuranceDetails(){
		System.out.println("ID : " + this.customerID);
		System.out.println("Name : " + this.name);
		System.out.println("Date of Birth : " + this.dateOfBirth);

	}

	public void finalize() throws Throwable {

	}
}//end Customer