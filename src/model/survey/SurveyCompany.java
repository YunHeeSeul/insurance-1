package Practice.InsuranceCompany.Design.src.model.survey;

public class SurveyCompany {

	private String surveyCompanyID;
	private String surveyCompanyname;
	private String address;
	private String phoneNum;
	private boolean surveyAbility;

	public SurveyCompany(String surveyCompanyID, String surveyCompanyname, String address, String phoneNum, boolean surveyAbility){
		this.surveyCompanyID=surveyCompanyID;
		this.surveyCompanyname=surveyCompanyname;
		this.address=address;
		this.phoneNum=phoneNum;
		this.surveyAbility=surveyAbility;

	}

	public String getAdress() {
		return address;
	}

	public void setAdress(String adress) {
		this.address = adress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public boolean isSurveyAbility() {
		return surveyAbility;
	}

	public void setSurveyAbility(boolean surveyAbility) {
		this.surveyAbility = surveyAbility;
	}

	public String getSurveyCompanyID() {
		return surveyCompanyID;
	}

	public void setSurveyCompanyId(String surveyCompanyID) {
		this.surveyCompanyID = surveyCompanyID;
	}


}//end SurveyCompany