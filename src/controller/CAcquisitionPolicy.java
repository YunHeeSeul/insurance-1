package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.AcquisitionPolicyDao;
import Practice.InsuranceCompany.Design.src.model.insurance.AcquisitionPolicy;
import Practice.InsuranceCompany.Design.src.enums.InsuranceType;

public class CAcquisitionPolicy {

    private AcquisitionPolicyDao acquisitionPolicyDao;
    private COwnedCarInfo cOwnedCarInfoDao;
    private COwnedBuildingInfo cOwnedBuildingInfo;
    private CDiseaseHistory cDiseaseHistory;

    public CAcquisitionPolicy(){
        this.acquisitionPolicyDao = new AcquisitionPolicyDao();
        this.cOwnedCarInfoDao = new COwnedCarInfo();
        this.cOwnedBuildingInfo = new COwnedBuildingInfo();
        this.cDiseaseHistory = new CDiseaseHistory();
    }

    public boolean addAcquisitionPolicy(AcquisitionPolicy acquisitionPolicy) {
        if(acquisitionPolicy.getInsuranceType() == InsuranceType.car)
            cOwnedCarInfoDao.addCarInfo(acquisitionPolicy.getCarInfoPolicy());
        else if(acquisitionPolicy.getInsuranceType() == InsuranceType.personalHealth)
            cDiseaseHistory.addDiseaseHistory(acquisitionPolicy.getDiseaseInfoPolicy());
        else if(acquisitionPolicy.getInsuranceType() == InsuranceType.fire)
            cOwnedBuildingInfo.addBuildingInfo(acquisitionPolicy.getBuildingInfoPolicy());

        return this.acquisitionPolicyDao.create(acquisitionPolicy);
    }

    public int getMaxID() { return this.acquisitionPolicyDao.retrieveMaxID(); }

}
