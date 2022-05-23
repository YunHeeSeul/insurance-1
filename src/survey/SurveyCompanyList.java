package Practice.InsuranceCompany.Design.src.survey;


/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
public interface SurveyCompanyList {

	/**
	 * 
	 * @param surveyCompany
	 */
	public boolean add(SurveyCompany surveyCompany);

	/**
	 * 
	 * @param surveyCompanyID
	 */
	public boolean delete(String surveyCompanyID);

	/**
	 * 
	 * @param surveyCompanyID
	 */
	public SurveyCompany get(String surveyCompanyID);

	/**
	 * 
	 * @param name
	 */
	public SurveyCompany get(String name);

	/**
	 * 
	 * @param surveyCompanyID
	 * @param surveyAbility
	 */
	public boolean update(String surveyCompanyID, boolean surveyAbility);

}