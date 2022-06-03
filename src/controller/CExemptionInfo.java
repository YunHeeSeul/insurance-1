package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.ExemptionInfoDao;
import Practice.InsuranceCompany.Design.src.dao.SurveyCompanyDao;
import Practice.InsuranceCompany.Design.src.model.accident.ExemptionInfo;
import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompany;

public class CExemptionInfo {
    private ExemptionInfoDao exemptionInfoDao;
    public CExemptionInfo(){
        this.exemptionInfoDao=new ExemptionInfoDao();
    }
    public boolean addExemptionInfo(ExemptionInfo exemptionInfo){
        return this.exemptionInfoDao.create(exemptionInfo);
    }
    public int getMaxID() { return this.exemptionInfoDao.retrieveMaxID(); }
}
