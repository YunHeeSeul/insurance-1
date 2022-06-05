package Practice.InsuranceCompany.Design.src.model.employee;

import java.util.ArrayList;

public class EmployeeListImpl implements EmployeeList {
    private ArrayList<Employee> employeeList;

    public EmployeeListImpl(){
        this.employeeList=new ArrayList<>();
    }
    public ArrayList<Employee> getEmployeeList(){ return this.employeeList; }

    @Override
    public boolean add(Employee employee){
        this.employeeList.add(employee);
        return true;
    }

    @Override
    public boolean delete(String employeeID){
        for(Employee employee : this.employeeList) {
            if (employee.getEmployeeId().equals(employeeID))
                return this.employeeList.remove(employee);
        }
        return false;
    }

    @Override
    public Employee getByID(String employeeID){
        for(Employee employee : this.employeeList) {
            if (employee.getEmployeeId().equals(employeeID))
                return employee;
        }
        return null;
    }
}
