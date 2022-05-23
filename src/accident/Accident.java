package Practice.InsuranceCompany.Design.src.accident;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;
import Practice.InsuranceCompany.Design.src.survey.SurveyCompany;

import java.util.Date;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:47
 */
public class Accident {

	private String accidentContent;
	private Date accidentDate;
	private String accidentID;
	private String accidentLocation;
	private Level accidentScale;
	private AccidentType accidentType;
	private String customerID;
	private boolean doingHarm;
	private ExemptionInfo exemptionInfo;
	private boolean onsite;
	private SurveyCompany repSurveyCompany;
	public ExemptionInfo m_ExemptionInfo;
	public SurveyCompany m_SurveyCompany;

	public Accident(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param surveyCompany
	 * @param accidentDate
	 * @param accidentLocation
	 * @param accidentType
	 * @param doingHarm
	 * @param accidentContent
	 */
	public boolean addAccidentSurvey(SurveyCompany surveyCompany, Date accidentDate, String accidentLocation, AccidentType accidentType, boolean doingHarm, String accidentContent){
		return false;
	}

	public boolean dispatchOnsite(){
		return false;
	}

	public Accident getAccidentReception(){
		return null;
	}

	/**
	 * 
	 * @param exemptionInfo
	 */
	public boolean registerExemptionInfo(ExemptionInfo exemptionInfo){
		return false;
	}
}//end Accident