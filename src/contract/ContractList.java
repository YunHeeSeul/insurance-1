package Practice.InsuranceCompany.Design.src.contract;


import java.util.ArrayList;
import java.util.Date;

public interface ContractList {

    ArrayList<Contract> ContractList = new ArrayList<>();

	boolean add(Contract contract);

	boolean delete(String contractID);

	Contract getByContractId(String contractID);

	Contract getByCustomerId(String customerID);

	boolean updateMDate(String contractID, Date maintenanceDate);

}