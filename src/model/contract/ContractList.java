package Practice.InsuranceCompany.Design.src.model.contract;

import java.util.ArrayList;

public interface ContractList {
	boolean add(Contract contract);

	boolean delete(String contractID);

	Contract getByContractId(String contractID);

	Contract getByCustomerId(String customerID);

	ArrayList<Contract> getAllList();

	boolean updateMDate(String contractID, String maintenanceDate);

	public void printAllList();
}