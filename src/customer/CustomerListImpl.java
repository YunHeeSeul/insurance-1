package Practice.InsuranceCompany.Design.src.customer;


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
	public Optional<Customer> getByCustomerId(String customerID) {
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
}//end CustomerListImpl