package Practice.InsuranceCompany.Design.src.model.employee;


import Practice.InsuranceCompany.Design.src.enums.Department;

public class Employee {

	private String employeeId;
	private String name;
	private Department department;
	private String phoneNum;

	public Employee(){

	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}//end Employee