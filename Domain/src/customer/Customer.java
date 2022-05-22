package Practice.InsuranceCompany.Design.Domain.src.customer;


import Practice.InsuranceCompany.Design.Domain.src.etcEnum.Gender;
import Practice.InsuranceCompany.Design.Domain.src.contract.Contract;

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

	public Customer(){

	}

	public void finalize() throws Throwable {

	}
}//end Customer