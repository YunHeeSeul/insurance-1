package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.OwnedCarInfoDao;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedCarInfo;

public class COwnedCarInfo {
    private OwnedCarInfoDao ownedCarInfoDao;

    public COwnedCarInfo(){
        this.ownedCarInfoDao = new OwnedCarInfoDao();
    }

    public boolean addCarInfo(OwnedCarInfo ownedCarInfo){
        return this.ownedCarInfoDao.create(ownedCarInfo);
    }
}
