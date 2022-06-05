package Practice.InsuranceCompany.Design.src.model.customer;


import java.util.ArrayList;

public interface CustomerList {

	public boolean add(Customer customer);

	public boolean delete(String customerID);

	public Customer getByCustomerId(String customerID);

	public ArrayList<Customer> getCustomerList();

	public boolean checkValidationID(String inputID);

}