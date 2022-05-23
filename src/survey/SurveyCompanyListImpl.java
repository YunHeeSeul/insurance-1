package Practice.InsuranceCompany.Design.src.survey;


import java.util.ArrayList;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
public class SurveyCompanyListImpl implements SurveyCompanyList {

	private ArrayList<SurveyCompany> surveyCompanyList;
	public SurveyCompany m_SurveyCompany;

	public SurveyCompanyListImpl(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param surveyCompany
	 */
	public boolean add(SurveyCompany surveyCompany){
		return false;
	}

	/**
	 * 
	 * @param surveyCompanyID
	 */
	public boolean delete(String surveyCompanyID){
		return false;
	}

	/**
	 * 
	 * @param surveyCompanyID
	 */
	public SurveyCompany get(String surveyCompanyID){
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public SurveyCompany get(String name){
		return null;
	}

	/**
	 * 
	 * @param surveyCompanyID
	 * @param surveyAbility
	 */
	public boolean update(String surveyCompanyID, boolean surveyAbility){
		return false;
	}
}//end SurveyCompanyListImpl