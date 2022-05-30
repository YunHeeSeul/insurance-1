package Practice.InsuranceCompany.Design.src.accident;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;
import Practice.InsuranceCompany.Design.src.survey.SurveyCompany;

import java.util.Date;

public class Accident {

	private String accidentContent;
	private String accidentDate;
	private String accidentID;
	private String accidentLocation;
	private Level accidentScale;
	private AccidentType accidentType;
	private String customerID;
	private boolean doingHarm;
	private ExemptionInfo exemptionInfo;
	private boolean onSite;
	private SurveyCompany repSurveyCompany;
	public ExemptionInfo m_ExemptionInfo;
	public SurveyCompany m_SurveyCompany;

	public Accident(){

	}

	public Accident(String accidentID, String customerID, AccidentType accidentType, String accidentDate, String accidentLocation, Level accidentScale, String accidentContent, boolean doingHarm, SurveyCompany repSurveyCompany, ExemptionInfo exemptionInfo, boolean onSite){

		this.accidentID = "acc1";
		this.customerID = customerID;
		this.accidentType = accidentType;
		this.accidentDate = accidentDate;
		this.accidentLocation = accidentLocation;
		this.accidentScale = accidentScale;
		this.accidentContent = accidentContent;
		this.doingHarm = doingHarm;
		this.repSurveyCompany = repSurveyCompany;
		this.exemptionInfo = exemptionInfo;
		this.onSite = onSite;

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

	public AccidentType getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(AccidentType accidentType) {
		this.accidentType = accidentType;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public boolean isDoingHarm() {
		return doingHarm;
	}

	public void setDoingHarm(boolean doingHarm) {
		this.doingHarm = doingHarm;
	}

	public ExemptionInfo getExemptionInfo() {
		return exemptionInfo;
	}

	public void setExemptionInfo(ExemptionInfo exemptionInfo) {
		this.exemptionInfo = exemptionInfo;
	}

	public boolean isOnsite() {
		return onSite;
	}

	public void setOnsite(boolean onsite) {
		this.onSite = onsite;
	}

	public SurveyCompany getRepSurveyCompany() {
		return repSurveyCompany;
	}

	public void setRepSurveyCompany(SurveyCompany repSurveyCompany) {
		this.repSurveyCompany = repSurveyCompany;
	}

	public String getAccidentID() {
		return accidentID;
	}

	public void setAccidentID(String accidentID) {
		this.accidentID = accidentID;
	}

	public boolean addAccidentSurvey(SurveyCompany surveyCompany, String accidentDate, String accidentLocation, AccidentType accidentType, boolean doingHarm, String accidentContent){
		return false;
	}

	public boolean dispatchOnsite(){
		return false;
	}

	public Accident getAccidentReception(){
		return null;
	}

	public boolean registerExemptionInfo(ExemptionInfo exemptionInfo){
		ExemptionInfo exeInfo=new ExemptionInfo();
		return false;
	}

	public String getAccidentInfo(){
		return accidentID+" "+customerID+" "+accidentType+" "+accidentDate+" "+accidentLocation+" "+ accidentScale +" "+ accidentContent +" "+ doingHarm +" "+ repSurveyCompany +" "+ exemptionInfo +" "+ onSite;
	}
}//end Accident