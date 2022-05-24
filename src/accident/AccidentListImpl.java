package Practice.InsuranceCompany.Design.src.accident;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:47
 */
public abstract class AccidentListImpl implements AccidentList {

	public Accident m_Accident;

	public AccidentListImpl(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param Accident
	 */
	public boolean add(Accident Accident){
		return false;
	}

	/**
	 * 
	 * @param accidentID
	 */
	public boolean delete(String accidentID){
		return false;
	}

	/**
	 * 
	 * @param accidentID
	 */
//	public Accident get(String accidentID){
//		return null;
//	}

	/**
	 * 
	 * @param customerID
	 */
	public Accident get(String customerID){
		return null;
	}

	/**
	 * 
	 * @param accidentID
	 * @param accidentScale
	 */
	public boolean updateAccidentScale(String accidentID, Level accidentScale){
		return false;
	}

	/**
	 * 
	 * @param accidentID
	 * @param doingHarm
	 */
	public boolean updateDoingHarm(String accidentID, boolean doingHarm){
		return false;
	}

	/**
	 * 
	 * @param accidentID
	 * @param ExemptionInfo
	 */
	public boolean updateExemptionInfo(String accidentID, ExemptionInfo ExemptionInfo){
		return false;
	}
}//end AccidentListImpl