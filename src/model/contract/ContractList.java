package Practice.InsuranceCompany.Design.src.model.contract;

import java.util.ArrayList;
import java.util.Optional;

public interface ContractList {
	// list 지움
	boolean add(Contract contract);

	boolean delete(String contractID);

	Contract getByContractId(String contractID);

	Contract getByCustomerId(String customerID);

	// 추가
	ArrayList<Contract> getAllList();

	// 추가
//	ArrayList<Contract> getMaintenanceTargetList();

	boolean updateMDate(String contractID, String maintenanceDate);

	Optional<Contract> getOptionalContractByCustomerId(String customerID);
}