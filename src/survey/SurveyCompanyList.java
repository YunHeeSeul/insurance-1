package Practice.InsuranceCompany.Design.src.survey;


/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
public interface SurveyCompanyList {


	boolean add(SurveyCompany surveyCompany);


	boolean delete(String surveyCompanyID);


	SurveyCompany getID(String surveyCompanyID);


	SurveyCompany getName(String name);


	boolean update(String surveyCompanyID, boolean surveyAbility);

}}