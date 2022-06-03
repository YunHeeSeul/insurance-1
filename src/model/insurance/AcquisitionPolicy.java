package Practice.InsuranceCompany.Design.src.model.insurance;

import Practice.InsuranceCompany.Design.src.model.policyholder.DiseaseHistory;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedBuildingInfo;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedCarInfo;

import java.util.Scanner;

public class AcquisitionPolicy {

	private OwnedBuildingInfo buildingInfoPolicy;
	private OwnedCarInfo carInfoPolicy;
	private DiseaseHistory diseaseInfoPolicy;

	private Scanner scanner;

	public AcquisitionPolicy(){
		this.scanner = new Scanner(System.in);
	}

	public OwnedBuildingInfo getBuildingInfoPolicy(){ return this.buildingInfoPolicy; }
	public OwnedCarInfo getCarInfoPolicy(){ return this.carInfoPolicy; }
	public DiseaseHistory getDiseaseInfoPolicy(){ return this.diseaseInfoPolicy; }

	public boolean registerBInfoPolicy(OwnedBuildingInfo buildingInfo){
		// 건물 정보 정책 등록하기
		OwnedBuildingInfo ownedBuildingInfo = new OwnedBuildingInfo();
		ownedBuildingInfo.setBuildingInfoForAcquisitionPolicy(this.scanner);
		if(ownedBuildingInfo != null) return true;
		else return false;
	}

	public boolean registerCInfoPolicy(OwnedCarInfo carInfo){
		// 자동차 정보 정책 등록하기
		OwnedCarInfo ownedCarInfo = new OwnedCarInfo();
		ownedCarInfo.setCarInfoForAcquisitionPolicy(this.scanner);
		if(ownedCarInfo != null) return true;
		else return false;
	}

	public boolean registerDInfoPolicy(DiseaseHistory deseaseInfo){
		// 질환이력 정보 정책 등록하기
		DiseaseHistory diseaseHistory = new DiseaseHistory();
		diseaseHistory.setDiseaseHistoryForAcquisitionPolicy(this.scanner);
		if(diseaseHistory != null) return true;
		else return false;
	}

}