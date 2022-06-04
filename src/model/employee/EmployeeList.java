package Practice.InsuranceCompany.Design.src.model.employee;

public interface EmployeeList {

	public boolean add(Employee employee);

	public boolean delete(String employeeID);

	public Employee getByID(String employeeID);

}