package Practice.InsuranceCompany.Design.src.model.survey;

import java.util.ArrayList;

=======

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */

public interface SurveyCompanyList {


	boolean add(SurveyCompany surveyCompany);


	boolean delete(String surveyCompanyID);

	SurveyCompany get(String surveyCompanyID);
	ArrayList<SurveyCompany> getAllList();

 	boolean updateSurveyAbility(String surveyCompanyID, boolean surveyAbility);

}

