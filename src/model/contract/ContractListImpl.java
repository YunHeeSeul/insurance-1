package Practice.InsuranceCompany.Design.src.model.contract;

import java.util.ArrayList;

public class ContractListImpl implements ContractList {
	private ArrayList<Contract> ContractList;

	public ContractListImpl(){
		this.ContractList=new ArrayList<>();
	}

	@Override
	public boolean add(Contract contract){
		this.ContractList.add(contract);
		return true;
	}

	@Override
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


	public void printAllList() {
		System.out.println("----------------------------계약 전체 목록----------------------------");
		System.out.println("(계약ID) (고객ID) (보험ID) (월보험료) (가입일자) (가입기간) (계약유지활동일자)");

		for(Contract contract: this.ContractList){
			System.out.println(contract.getContractInfo());
		}
	}

	public int getSize(){
		return this.ContractList.size();
	}
}//end ContractListImpl