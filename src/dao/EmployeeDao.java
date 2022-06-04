package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.etcEnum.Department;
import Practice.InsuranceCompany.Design.src.model.employee.Employee;
import Practice.InsuranceCompany.Design.src.model.employee.EmployeeListImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao extends Dao {

    public EmployeeDao(){
        super.connect();
    }

    public boolean create(Employee employee){
        String query = "insert into employee value('"
                +employee.getEmployeeId()+"', '"
                +employee.getName()+"', '"
                +employee.getDepartment().getDetail()+"', '"
                +employee.getPhoneNum()+"');";

        return super.create(query);
    }

    public EmployeeListImpl retrieveAll() {
        try {
            EmployeeListImpl employeeList = new EmployeeListImpl();

            String query = "select * from employee";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) { employeeList.add(setEmployeeByResultset(resultSet)); }
            return employeeList;

        } catch (SQLException e){}
        return null;
    }


    public Employee retrieveById(String inputID) {
        try {
            String query = "select * from employee where employeeId = " + dq + inputID + dq + ";";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) { return setEmployeeByResultset(resultSet); }
            else return null;
        } catch (SQLException e){}
        return null;
    }

    public boolean deleteById(String id){
        String deleteQuery = "delete from employee where employeeId = " + dq + id + dq + ";";
        return super.delete(deleteQuery);
    }

    public int retrieveMaxID() {
        try {
            String query = "select max(employeeId) as ID from employee;";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String id = resultSet.getString("ID");
                if (id == null) return 0;
                else return Integer.parseInt(id.substring(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }


    private Employee setEmployeeByResultset(ResultSet resultSet) {
        try {
            Employee employee = new Employee();

            employee.setEmployeeId(resultSet.getString("employeeId"));
            employee.setName(resultSet.getString("name"));
            employee.setDepartment(Department.makeDepartment(resultSet.getString("department")));
            employee.setPhoneNum(resultSet.getString("phoneNum"));
            return employee;
        } catch (SQLException e){

        }
        return null;

    }
}
