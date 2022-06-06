package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.ExemptionInfoDao;
import Practice.InsuranceCompany.Design.src.model.accident.ExemptionInfo;

public class CExemptionInfo {
    private ExemptionInfoDao exemptionInfoDao;
    public CExemptionInfo(){
        this.exemptionInfoDao=new ExemptionInfoDao();
    }
    public ExemptionInfo getByID(String exemptionInfoID){
        return this.exemptionInfoDao.retrieveById(exemptionInfoID);
    }
    public boolean create(ExemptionInfo exemptionInfo){ return this.exemptionInfoDao.create(exemptionInfo); }
    public boolean addExemptionInfo(ExemptionInfo exemptionInfo){
        return this.exemptionInfoDao.create(exemptionInfo);
    }
    public int getMaxID() { return this.exemptionInfoDao.retrieveMaxID(); }
}
