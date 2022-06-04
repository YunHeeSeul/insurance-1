package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.CustomerDao;
import Practice.InsuranceCompany.Design.src.dao.PolicyholderDao;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.model.policyholder.Policyholder;

import java.util.ArrayList;

public class CPolicyholder {
    private PolicyholderDao policyholderDao;

    public CPolicyholder(){
        this.policyholderDao = new PolicyholderDao();
    }

    public CustomerListImpl retrieveAll(){ return this.policyholderDao.retrieveAll();}
    public Policyholder retrieveById(String inputID) { return this.policyholderDao.retrieveById(inputID); }
    public boolean create(Policyholder customer){
        return this.policyholderDao.create(customer);
    }
    public boolean updateTotalPremiumTypeById(String inputID, int premium){
        return this.policyholderDao.updateTotalPremiumTypeById(inputID,premium);
    }


}
