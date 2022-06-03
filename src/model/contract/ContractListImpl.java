package Practice.InsuranceCompany.Design.src.model.contract;

import java.util.ArrayList;
import java.util.Optional;

public class ContractListImpl implements ContractList {

	private ArrayList<Contract> ContractList;

	public ContractListImpl(){
		this.ContractList=new ArrayList<>();
	}

	public boolean add(Contract contract){
		this.ContractList.add(contract);
		return true;
	}

	public boolean delete(String contractID){
		for(Contract contract : this.ContractList) {
			if (contract.getContractID().equals(contractID))
				return this.ContractList.remove(contract);
		}
		return false;
	}

	@Override
	public Contract getByContractId(String contractID) {
		for(Contract contract : this.ContractList) {
			if (contract.getContractID().equals(contractID))
				return contract;
		}
		return null;
	}

	@Override
	public Contract getByCustomerId(String customerID) {
		for(Contract contract : this.ContractList) {
			if (contract.getCustomerID().equals(customerID))
				return contract;
		}
		return null;
	}

	@Override
	public ArrayList<Contract> getAllList() {
		return this.ContractList;
	}

//	@Override
//	public ArrayList<Contract> getMaintenanceTargetList() {
//		ArrayList<Contract> maintenanceTargetList = new ArrayList<>();
//		for (Contract contract :this.ContractList){
//			if(contract.isMaintenanceTarget()) maintenanceTargetList.add(contract);
//		}
//		return maintenanceTargetList;
//	}

	@Override
	public boolean updateMDate(String contractID, String maintenanceDate) {
		for(Contract contract : this.ContractList) {
			if (contract.getContractID().equals(contractID)){
				contract.setActivityDate(maintenanceDate);
				return true;
			}
		}
		return false;
	}

	@Override
	public Optional<Contract> getOptionalContractByCustomerId(String customerID) {
		return Optional.empty();
	}
}//end ContractListImpl