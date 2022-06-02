package Practice.InsuranceCompany.Design.src.model.employee;


import Practice.InsuranceCompany.Design.src.model.customer.Customer;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public abstract class EmployeeListImpl implements EmployeeList {

//	private ArrayList<Customer> customerList;
	public Employee m_Employee;

	public EmployeeListImpl(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param employee
	 */
	public boolean add(Employee employee){
		return false;
	}

	/**
	 * 
	 * @param employeeID
	 */
	public boolean delete(String employeeID){
		return false;
	}

	/**
	 * 
	 * @param employeeID
	 */
	public Employee get(String employeeID){
		return null;
	}

//	/**
//	 *
//	 * @param employeeName
//	 */
//	public Employee get(String employeeName){
//		return null;
//	}
}//end EmployeeListImpl