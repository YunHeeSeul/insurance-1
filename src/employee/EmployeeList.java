package Practice.InsuranceCompany.Design.src.employee;


/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public interface EmployeeList {

	/**
	 * 
	 * @param employee
	 */
	public boolean add(Employee employee);

	/**
	 * 
	 * @param employeeID
	 */
	public boolean delete(String employeeID);

	/**
	 * 
	 * @param employeeID
	 */
	public Employee get(String employeeID);

	/**
	 * 
	 * @param employeeName
	 */
	public Employee get(String employeeName);

}