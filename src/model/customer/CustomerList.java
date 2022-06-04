package Practice.InsuranceCompany.Design.src.model.customer;


import java.util.Optional;

public interface CustomerList {

	public boolean add(Customer customer);

	public boolean delete(String customerID);

	public Customer getByCustomerId(String customerID);


}