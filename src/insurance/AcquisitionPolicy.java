package Practice.InsuranceCompany.Design.src.insurance;


import Practice.InsuranceCompany.Design.src.policyholder.DeseaseHistory;
import Practice.InsuranceCompany.Design.src.policyholder.OwnedBuildingInfo;
import Practice.InsuranceCompany.Design.src.policyholder.OwnedCarInfo;

public class AcquisitionPolicy {

	private OwnedBuildingInfo buildingInfoPolicy;
	private OwnedCarInfo carInfoPolicy;
	private DeseaseHistory deseaseInfoPolicy;

	public AcquisitionPolicy(){

	}

	public boolean registerBInfoPolicy(OwnedBuildingInfo buildingInfo){
		return false;
	}

	public boolean registerCInfoPolicy(OwnedCarInfo carInfo){
		return false;
	}

	public boolean registerDInfoPolicy(DeseaseHistory deseaseInfo){
		return false;
	}

}