package Practice.InsuranceCompany.Design.src.model.insurance;


import Practice.InsuranceCompany.Design.src.controller.CDiseaseHistory;
import Practice.InsuranceCompany.Design.src.controller.COwnedBuildingInfo;
import Practice.InsuranceCompany.Design.src.controller.COwnedCarInfo;
import Practice.InsuranceCompany.Design.src.model.policyholder.DiseaseHistory;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedBuildingInfo;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedCarInfo;

import java.util.Scanner;

public class AcquisitionPolicy {

	private String acquisitionPolicyId;
	private InsuranceType insuranceType;	//	추가 (빌딩/차/질병 정보 db에 넣을 때 용이하게 하려고)
	private OwnedBuildingInfo buildingInfoPolicy;
	private OwnedCarInfo carInfoPolicy;
	private DiseaseHistory diseaseInfoPolicy;

	private Scanner scanner;

	public AcquisitionPolicy(){
		this.scanner = new Scanner(System.in);

		this.buildingInfoPolicy = null;
		this.carInfoPolicy = null;
		this.diseaseInfoPolicy = null;
	}

	public void setAcquisitionPolicyId(String acquisitionPolicyId) { this.acquisitionPolicyId = acquisitionPolicyId; }
	public void setBuildingInfoPolicy(OwnedBuildingInfo buildingInfoPolicy) { this.buildingInfoPolicy = buildingInfoPolicy; }
	public void setCarInfoPolicy(OwnedCarInfo carInfoPolicy) {
		this.carInfoPolicy = carInfoPolicy;
	}
	public void setDiseaseInfoPolicy(DiseaseHistory diseaseInfoPolicy) {
		this.diseaseInfoPolicy = diseaseInfoPolicy;
	}
	public String getID() {
		return this.acquisitionPolicyId;
	}
	public InsuranceType getInsuranceType(){ return this.insuranceType; }
	public OwnedBuildingInfo getBuildingInfoPolicy(){ return this.buildingInfoPolicy; }
	public OwnedCarInfo getCarInfoPolicy(){ return this.carInfoPolicy; }
	public DiseaseHistory getDiseaseInfoPolicy(){ return this.diseaseInfoPolicy; }

	public boolean registerBInfoPolicy(){
		OwnedBuildingInfo ownedBuildingInfo = new OwnedBuildingInfo();
		ownedBuildingInfo.inputBuildingInfo(this.scanner);
		if(ownedBuildingInfo != null){
			this.buildingInfoPolicy = ownedBuildingInfo;
			return true;
		}
		else return false;
	}

	public boolean registerCInfoPolicy(){
		OwnedCarInfo ownedCarInfo = new OwnedCarInfo();
		ownedCarInfo.inputCarInfo(this.scanner);
		if(ownedCarInfo != null) {
			this.carInfoPolicy = ownedCarInfo;
			return true;
		}
		else return false;
	}

	public boolean registerDInfoPolicy(){
		DiseaseHistory diseaseHistory = new DiseaseHistory();
		diseaseHistory.inputDiseaseHistory(this.scanner);
		if(diseaseHistory != null) {
			this.diseaseInfoPolicy = diseaseHistory;
			return true;
		}
		else return false;
	}

	public void inputPolicyInfo(InsuranceType insuranceType) {
		if(insuranceType == InsuranceType.car)
			this.registerCInfoPolicy();
		else if(insuranceType == InsuranceType.fire)
			this.registerBInfoPolicy();
		else if(insuranceType == InsuranceType.personalHealth)
			this.registerDInfoPolicy();
	}
}