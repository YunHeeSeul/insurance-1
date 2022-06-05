package Practice.InsuranceCompany.Design.src.model.customer;


import Practice.InsuranceCompany.Design.src.model.insurance.Insurance;

import java.util.ArrayList;
import java.util.Optional;

public class CustomerListImpl implements CustomerList {

	private ArrayList<Customer> customerList;
	public Customer m_Customer;

	public CustomerListImpl(){ this.customerList = new ArrayList<>(); }

	public boolean add(Customer customer){
		if(this.customerList != null) {
			this.customerList.add(customer);
			return true;
		}
		return false;
	}

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
			System.out.println("가입자 목록이 비어있습니다.");
			return;
		}
	}
}//end CustomerListImpl