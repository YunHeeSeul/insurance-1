package Practice.InsuranceCompany.Design.Domain.src.contract;


import java.util.Date;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public interface ContractList {

//	ArrayList<Contract> ContractList;

	/**
	 * 
	 * @param contract
	 */
	public boolean add(Contract contract);

	/**
	 * 
	 * @param contractID
	 */
	public boolean delete(String contractID);

	/**
	 * 
	 * @param contractID
	 */
	public Contract getByContractId(String contractID);

	/**
	 *
	 * @param customerID
	 */
	public Contract getByCustomerId(String customerID);

	/**
	 * 
	 * @param contractID
	 * @param maintenanceDate
	 */
	public boolean updateMDate(String contractID, Date maintenanceDate);

}