package Practice.InsuranceCompany.Design.src.customer;


import Practice.InsuranceCompany.Design.src.etcEnum.Gender;
import Practice.InsuranceCompany.Design.src.contract.Contract;

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

	public Customer(){

	}


    public String getCustomerId() {
		return this.customerID;
    }
}//end Customer