package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.CustomerDao;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;

public class CCustomer {
    private CustomerDao customerDao;

    public CCustomer(){
        this.customerDao = new CustomerDao();
    }

    public CustomerListImpl retrieveAll() { return this.customerDao.retrieveAll(); }
    public Customer retrieveById(String inputID) { return this.customerDao.retrieveById(inputID); }
    public boolean create(Customer customer){
        return this.customerDao.create(customer);
    }
    public boolean deleteById(String inputID) { return this.customerDao.deleteById(inputID); }
    public boolean updateById(String inputID, Customer customer) { return this.customerDao.updateById(inputID, customer); }
    public boolean updateCustomerType(String inputID){
        return this.customerDao.updateCustomerTypeById(inputID);
    }

    public int getMaxID() { return this.customerDao.retrieveMaxID(); }


}
