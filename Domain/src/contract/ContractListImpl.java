package Practice.InsuranceCompany.Design.Domain.src.contract;


import java.util.ArrayList;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public class ContractListImpl implements ContractList {

	private ArrayList<Contract> ContractList;
	public Contract m_Contract;

	public ContractListImpl(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param contract
	 */
	public boolean add(Contract contract){
		return false;
	}

	/**
	 * 
	 * @param contractID
	 */
	public boolean delete(String contractID){
		return false;
	}

	/**
	 * 
	 * @param contractID
	 */
	public Contract get(String contractID){
		return null;
	}

	/**
	 * 
	 * @param customerID
	 */
	public Contract get(String customerID){
		return null;
	}

	/**
	 * 
	 * @param contractID
	 * @param maintenanceDate
	 */
	public boolean updateMDate(String contractID, Date maintenanceDate){
		return false;
	}
}//end ContractListImpl