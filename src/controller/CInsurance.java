package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.InsuranceDao;
import Practice.InsuranceCompany.Design.src.model.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.model.insurance.InsuranceListImpl;

public class CInsurance {
    private InsuranceDao insuranceDao;

    public CInsurance(){
        this.insuranceDao = new InsuranceDao();
    }

    public InsuranceListImpl retrieveAll() { return this.insuranceDao.retrieveAll(); }
    public Insurance retrieveById(String inputID) {
        return this.insuranceDao.retrieveById(inputID);
    }
    public boolean create(Insurance insurance) { return this.insuranceDao.create(insurance); }
    public boolean updateById(String inputID, Insurance insurance) { return this.insuranceDao.updateById(inputID, insurance); }
    public boolean deleteById(String inputID) {
        return this.insuranceDao.deleteById(inputID);
    }

    public int getMaxID() { return this.insuranceDao.retrieveMaxID(); }
}
