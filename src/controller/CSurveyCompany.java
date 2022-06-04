package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.SurveyCompanyDao;
import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompany;
import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompanyListImpl;
public class CSurveyCompany {
    private SurveyCompanyDao surveyCompanyDao;
    public CSurveyCompany(){
        this.surveyCompanyDao=new SurveyCompanyDao();
    }
    public SurveyCompanyListImpl getAllSurveyCompany() {
        return this.surveyCompanyDao.retrieveAll();
    }
    public SurveyCompany getBySurveyCompanyID (String surveyCompanyID) {
        return this.surveyCompanyDao.retrieveById(surveyCompanyID);
    }
    public boolean addSurveyCompany(SurveyCompany surveyCompany){
        return this.surveyCompanyDao.create(surveyCompany);
    }
    public int getMaxID() { return this.surveyCompanyDao.retrieveMaxID(); }
}
