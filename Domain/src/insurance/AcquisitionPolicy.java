package Practice.InsuranceCompany.Design.Domain.src.insurance;


import Practice.InsuranceCompany.Design.Domain.src.policyholder.DeseaseHistory;
import Practice.InsuranceCompany.Design.Domain.src.policyholder.OwnedBuildingInfo;
import Practice.InsuranceCompany.Design.Domain.src.policyholder.OwnedCarInfo;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public class AcquisitionPolicy {

	private OwnedBuildingInfo buildingInfoPolicy;
	private OwnedCarInfo carInfoPolicy;
	private DeseaseHistory deseaseInfoPolicy;

	public AcquisitionPolicy(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param buildingInfo
	 */
	public boolean registerBInfoPolicy(OwnedBuildingInfo buildingInfo){
		return false;
	}

	/**
	 * 
	 * @param carInfo
	 */
	public boolean registerCInfoPolicy(OwnedCarInfo carInfo){
		return false;
	}

	/**
	 * 
	 * @param deseaseInfo
	 */
	public boolean registerDInfoPolicy(DeseaseHistory deseaseInfo){
		return false;
	}
}//end AcquisitionPolicy