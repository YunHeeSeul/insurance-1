package Practice.InsuranceCompany.Design.src.model.customer;


public interface CustomerList {

	public boolean add(Customer customer);

	public boolean delete(String customerID);

	public Customer getByCustomerId(String customerID);


}