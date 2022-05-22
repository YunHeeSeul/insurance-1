package Practice.InsuranceCompany.Design.Domain.src.accident;


import Practice.InsuranceCompany.Design.Domain.src.etcEnum.Level;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:47
 */
public interface AccidentList {

	/**
	 * 
	 * @param Accident
	 */
	public boolean add(Accident Accident);

	/**
	 * 
	 * @param accidentID
	 */
	public boolean delete(String accidentID);

	/**
	 * 
	 * @param accidentID
	 */
	public Accident getByAccidentId(String accidentID);

	/**
	 * 
	 * @param customerID
	 */
	public Accident getByCustomerId(String customerID);

	/**
	 * 
	 * @param accidentID
	 * @param accidentScale
	 */
	public boolean updateAccidentScale(String accidentID, Level accidentScale);

	/**
	 * 
	 * @param accidentID
	 * @param doingHarm
	 */
	public boolean updateDoingHarm(String accidentID, boolean doingHarm);

	/**
	 * 
	 * @param accidentID
	 * @param ExemptionInfo
	 */
	public boolean updateExemptionInfo(String accidentID, ExemptionInfo ExemptionInfo);

}