package Practice.InsuranceCompany.Design.src.model.accident;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;

import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompany;

import java.util.ArrayList;

public class Accident {
	private String accidentID;
	private String customerID;
	private AccidentType accidentType;
	private String accidentDate;
	private String accidentLocation;
	private Level accidentScale;
	private String accidentContent;
	private boolean doingHarm;
	private SurveyCompany repSurveyCompany;
	private String surveyCompanyID;
	private String exemptionInfoID;
	private ExemptionInfo exemptionInfo;
	private boolean onSite;

	public Accident(){
	}
	private ArrayList<ExemptionInfo> exemptionContent;

	public String getAccidentID() {
		return accidentID;
	}

	public void setAccidentID(String accidentID) {
		this.accidentID = accidentID;
	}
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public AccidentType getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(AccidentType accidentType) {
		this.accidentType = accidentType;
	}

	public String getAccidentContent() {
		return accidentContent;
	}

	public void setAccidentContent(String accidentContent) {
		this.accidentContent = accidentContent;
	}

	public String getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getAccidentLocation() {
		return accidentLocation;
	}

	public void setAccidentLocation(String accidentLocation) {
		this.accidentLocation = accidentLocation;
	}

	public Level getAccidentScale() {

		return accidentScale;
	}

	public void setAccidentScale(Level accidentScale) {
		this.accidentScale = accidentScale;
	}

	public boolean isDoingHarm() {
		return doingHarm;
	}

	public void setDoingHarm(boolean doingHarm) {
		this.doingHarm = doingHarm;
	}

	public SurveyCompany getRepSurveyCompany() {
		return repSurveyCompany;
	}
	public void setRepSurveyCompany(SurveyCompany repSurveyCompany) {
		this.repSurveyCompany = repSurveyCompany;
	}

	public String getRepSurveyCompanyID() {
		return surveyCompanyID;
	}
	public void setRepSurveyCompanyID(String surveyCompanyID) {
		this.surveyCompanyID = surveyCompanyID;
	}
	public String getExemptionInfoID() {
		return exemptionInfoID;
	}

	public void setExemptionInfoID(String exemptionInfoID) {
		this.exemptionInfoID = exemptionInfoID;
	}
	public ExemptionInfo getExemptionInfo() {
		return exemptionInfo;
	}

	public void setExemptionInfo(ExemptionInfo exemptionInfo) {
		this.exemptionInfo = exemptionInfo;
	}

	public ArrayList<ExemptionInfo> getExemptionContent() {
		return exemptionContent;
	}
	public void setExemptionContent(ArrayList<ExemptionInfo> exemptionContent) {
		this.exemptionContent = exemptionContent;
	}
	public boolean isOnsite() {
		return onSite;
	}

	public void setOnsite(boolean onsite) {
		this.onSite = onsite;
	}

}//end Accident