package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.model.contract.Contract;
import Practice.InsuranceCompany.Design.src.model.contract.ContractListImpl;
import Practice.InsuranceCompany.Design.src.dao.ContractDao;

public class CContract {
    private ContractDao contractDao;

    public CContract(){
        this.contractDao = new ContractDao();
    }

    public ContractListImpl getAllContractList() {
        return this.contractDao.retrieveAll();
    }

    public Contract getContractById(String contractID) {
        return this.contractDao.retrieveById(contractID);
    }

    public boolean addContract(Contract contract) {
        return this.contractDao.create(contract);
    }

    public boolean updateActivityDate(String contractID, String activityDate) {
        return this.contractDao.update(contractID,activityDate);
    }

    public boolean deleteContractById(String contractID) {
        return this.contractDao.delete(contractID);
    }

    public ContractListImpl getMaintenanceTargetList(){
        return this.contractDao.retrieveMaintenanceTargetList();
    }

    public int getMaxID() {
        return this.contractDao.retrieveMaxID();
    }

    public ContractListImpl getByCustomerId(String customerID) {
        return this.contractDao.retrieveByCustomerId(customerID);
    }
}
