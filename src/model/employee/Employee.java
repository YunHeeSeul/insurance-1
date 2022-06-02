package Practice.InsuranceCompany.Design.src.model.employee;


import Practice.InsuranceCompany.Design.src.etcEnum.Department;
import Practice.InsuranceCompany.Design.src.model.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;

import java.util.ArrayList;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public class Employee {

	private Department deparment;
	private String EmployeeId;
	private String name;
	private String phoneNum;

	public Employee(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param insurance
	 */
	public boolean createInsurance(Insurance insurance){
		return false;
	}

	public ArrayList<Customer> findUnpaidCustomer(){
		return null;
	}

	/**
	 * 
	 * @param insurance
	 */
	public boolean sendAuthorizationRequest(Insurance insurance){
		return false;
	}

	/**
	 * 
	 * @param employeeID
	 * @param subscriptionID
	 */
	public boolean sendContractStatus(String employeeID, String subscriptionID){
		return false;
	}

	/**
	 * 
	 * @param customerID
	 * @param paymentFormID
	 */
	public boolean sendPamentStatus(String customerID, String paymentFormID){
		return false;
	}

	/**
	 * 
	 * @param insurance
	 */
	public boolean sendRateVerfication(Insurance insurance){
		return false;
	}

	/**
	 * 
	 * @param customerID
	 */
	public boolean sendUnpaidInformation(String customerID){
		return false;
	}
}//end Employee