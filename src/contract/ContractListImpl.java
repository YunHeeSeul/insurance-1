package Practice.InsuranceCompany.Design.src.contract;

import java.util.ArrayList;
import java.util.Date;

public class ContractListImpl implements ContractList {

	private ArrayList<Contract> ContractList;
	public Contract m_Contract;

	public ContractListImpl(){

	}

	public boolean add(Contract contract){
		return false;
	}

	public boolean delete(String contractID){
		return false;
	}

	@Override
	public Contract getByContractId(String contractID) {
		return null;
	}

	@Override
	public Contract getByCustomerId(String customerID) {
		return null;
	}

	@Override
	public boolean updateMDate(String contractID, Date maintenanceDate) {
		return false;
	}


}//end ContractListImpl