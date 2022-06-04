package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.EmployeeDao;
import Practice.InsuranceCompany.Design.src.model.employee.EmployeeListImpl;

public class CEmployee {
    private EmployeeDao employeeDao;

    public CEmployee(){
        this.employeeDao = new EmployeeDao();
    }

    public EmployeeListImpl retrieveAll(){ return this.employeeDao.retrieveAll(); }

}
