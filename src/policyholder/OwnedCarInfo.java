package Practice.InsuranceCompany.Design.src.policyholder;


import Practice.InsuranceCompany.Design.src.etcEnum.CarType;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:49
 */
public class OwnedCarInfo {

	private int accidentNumber;
	private CarType carType;
	private CarUse carUse;
	private int displacement;
	private ArrayList<violationInfo> violationHistory;
	public violationInfo m_violationInfo;

	public OwnedCarInfo(){

	}

	public void finalize() throws Throwable {

	}
}//end OwnedCarInfo