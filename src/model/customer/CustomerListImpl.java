package Practice.InsuranceCompany.Design.src.model.customer;


import java.util.ArrayList;
import java.util.Optional;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public class CustomerListImpl implements CustomerList {

	private ArrayList<Customer> customerList;
	public Customer m_Customer;

	public CustomerListImpl(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param customer
	 */
	public boolean add(Customer customer){
		return false;
	}

	/**
	 * 
	 * @param customerID
	 */
	public boolean delete(String customerID){
		return false;
	}

	@Override
	public Optional<Customer> getByOptionalCustomerId(String customerID) {
		return null;
	}

	@Override
	public Customer getByCustomerId(String customerID) {
		return null;
	}

	@Override
	public Customer getByCustomerName(String customerName) {
		return null;
	}

	/**
	 * 
	 * @param customerID
	 */
//	public Customer get(String customerID){
//		return null;
//	}

	/**
	 * 
	 * @param customerType
	 */
	public Customer get(CustomerType customerType){
		return null;
	}

	/**
	 * 
	 * @param customerName
	 */
	public Customer get(String customerName){
		return null;
	}

	public ArrayList<Customer> getCustomerList(){ return this.customerList; }

	public boolean checkValidationID(String inputID) {
		if(this.customerList != null) {
			for (Customer customer : this.customerList)
				if (inputID.equals(customer.getCustomerID())) { return true; }
		}
		return false;
	}

	public void printAllCustomerInfo(){
		if(this.customerList != null) {
			for (Customer customer : this.customerList) {
				customer.printInsuranceDetails();
				System.out.println("\n");
			}
		} else {
			System.out.println("가입자 목록이 비어있습니다.-");
			return;
		}
	}
}//end CustomerListImpl