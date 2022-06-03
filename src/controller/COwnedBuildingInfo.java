package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.OwnedBuildingInfoDao;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedBuildingInfo;

public class COwnedBuildingInfo {
    private OwnedBuildingInfoDao ownedBuildingInfoDao;

    public COwnedBuildingInfo(){
        this.ownedBuildingInfoDao = new OwnedBuildingInfoDao();
    }


    public boolean addBuildingInfo(OwnedBuildingInfo ownedBuildingInfo) {
        return this.ownedBuildingInfoDao.create(ownedBuildingInfo);
    }
}
