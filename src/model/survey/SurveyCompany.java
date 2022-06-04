package Practice.InsuranceCompany.Design.src.model.survey;

public class SurveyCompany {

	private String surveyCompanyID;
	private String surveyCompanyName;

	private String address;
	private String phoneNum;
	private boolean surveyAbility;


	public SurveyCompany(){}

	public SurveyCompany(String surveyCompanyID, String surveyCompanyName, String address, String phoneNum, boolean surveyAbility){
		this.surveyCompanyID=surveyCompanyID;
		this.surveyCompanyName=surveyCompanyName;
		this.address=address;
		this.phoneNum=phoneNum;
		this.surveyAbility=surveyAbility;

	}

	public String getSurveyCompanyID() {
		return surveyCompanyID;
	}

	public void setSurveyCompanyID(String surveyCompanyID) {
		this.surveyCompanyID = surveyCompanyID;
	}

	public String getSurveyCompanyName() {
		return surveyCompanyName;
	}
	public void setSurveyCompanyName(String surveyCompanyName) {
		this.surveyCompanyName = surveyCompanyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getSurveyCompanyInfo(){
		return surveyCompanyID+" "+surveyCompanyName+" "+address+" "+phoneNum+" "+surveyAbility;
	}
	/*
		System.out.println("손해사정업체 ID : " + this.surveyCompanyID);
		System.out.println("손해사정업체명 : " + this.surveyCompanyName);
		System.out.println("업체 주소 : " + this.address);
		System.out.println("업체 번호 : " + this.phoneNum);
		System.out.println("현장 조사 가능 여부 : " + this.surveyAbility);

		if(this.surveyAbility==true)
			System.out.println("현장 조사 여부 : 조사함");
		else
			System.out.println("현장 조사 여부 : 조사하지 않음");

		 */

}//end SurveyCompany