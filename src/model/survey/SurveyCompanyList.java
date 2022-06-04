package Practice.InsuranceCompany.Design.src.model.survey;

import java.util.ArrayList;

public interface SurveyCompanyList {

	boolean add(SurveyCompany surveyCompany);

	boolean delete(String surveyCompanyID);

	SurveyCompany get(String surveyCompanyID);
	ArrayList<SurveyCompany> getAllList();

 	boolean updateSurveyAbility(String surveyCompanyID, boolean surveyAbility);

}

