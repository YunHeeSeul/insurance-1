package Practice.InsuranceCompany.Design.Domain.src.customer;


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

	/**
	 * 
	 * @param customerID
	 */
	public Customer get(String customerID){
		return null;
	}

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