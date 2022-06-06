package Practice.InsuranceCompany.Design.src.model.customer;

import java.util.ArrayList;

public class CustomerListImpl implements CustomerList {

	private ArrayList<Customer> customerList;

	public CustomerListImpl(){ this.customerList = new ArrayList<>(); }

	@Override
	public boolean add(Customer customer){
		if(this.customerList != null) {
			this.customerList.add(customer);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String customerID){
		return false;
	}


	@Override
	public Customer getByCustomerId(String customerID) {
		if(this.customerList != null) {
			for (Customer customer : this.customerList)
				if (customerID.equals(customer.getCustomerID())) { return customer; }
		}
		return null;
	}

	@Override
	public ArrayList<Customer> getCustomerList(){ return this.customerList; }

	@Override
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
			System.out.println("가입자 목록이 비어있습니다.");
			return;
		}
	}
}//end CustomerListImpl