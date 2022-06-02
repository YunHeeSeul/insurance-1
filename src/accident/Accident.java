package Practice.InsuranceCompany.Design.src.accident;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;
import Practice.InsuranceCompany.Design.src.etcEnum.Responsibility;
import Practice.InsuranceCompany.Design.src.survey.SurveyCompany;

import java.util.ArrayList;
import java.util.Scanner;

public class Accident {
	private static int IDnum=0;
	Scanner scn;
	private String accidentID;
	private String customerID;
	private AccidentType accidentType;
	private String accidentDate;
	private String accidentLocation;
	private Level accidentScale;
	private String accidentContent;
	private boolean doingHarm;
	private SurveyCompany repSurveyCompany;
	private String exemptionInfoID;
	private boolean onSite;
	private boolean permission;

	public Accident(){
		this.accidentID = Integer.toString(IDnum + 1);
		this.permission = true;
	}
	private ArrayList<ExemptionInfo> exemptionContent;

	public Accident(Scanner scn, String accidentID, String customerID, AccidentType accidentType, String accidentDate, String accidentLocation, Level accidentScale, String accidentContent, boolean doingHarm, SurveyCompany repSurveyCompany, String exemptionInfoID, boolean onSite){
		this.scn = scn;
		this.accidentID = "acc1";
		this.customerID = customerID;
		this.accidentType = accidentType;
		this.accidentDate = accidentDate;
		this.accidentLocation = accidentLocation;
		this.accidentScale = accidentScale;
		this.accidentContent = accidentContent;
		this.doingHarm = doingHarm;
		this.repSurveyCompany = repSurveyCompany;
		this.exemptionInfoID = exemptionInfoID;
		this.onSite = onSite;

	}

	public ArrayList<ExemptionInfo> getExemptionContent() {
		return exemptionContent;
	}

	public void setExemptionContent(ArrayList<ExemptionInfo> exemptionContent) {
		this.exemptionContent = exemptionContent;
	}

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
	public String getAccidentContent() {
		return accidentContent;
	}

	public void setAccidentContent(String accidentContent) {
		this.accidentContent = accidentContent;
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
	public String getExemptionInfoID() {
		return exemptionInfoID;
	}

	public void setExemptionInfoID(String exemptionInfoID) {
		this.exemptionInfoID = exemptionInfoID;
	}

	public boolean isOnsite() {
		return onSite;
	}

	public void setOnsite(boolean onsite) {
		this.onSite = onsite;
	}

//삭제
//	public boolean addAccidentSurvey(SurveyCompany surveyCompany, String accidentDate, String accidentLocation, AccidentType accidentType, boolean doingHarm, String accidentContent){
//		return false;
//	}

	public boolean dispatchOnsite(boolean permission){
		if(repSurveyCompany.isSurveyAbility()==true) {
			this.permission = permission;
			return true;
		}else
			return false;
	}
	//VAccident에 사고 정보를 보여주는 기능이 있어서 없어도 될 것 같은 기능
/*	public Accident getAccidentReception(){
		return null;
	}
*/
	public void printAccidentDetails(){
		System.out.println("사고 ID : " + this.accidentID);
		System.out.println("고객 ID : " + this.customerID);
		System.out.println("사고 종류 : " + this.accidentType);
		System.out.println("사고 일시 : " + this.accidentDate);
		System.out.println("사고 장소 : " + this.accidentLocation);
		System.out.println("사고 규모 : " + this.accidentScale);
		System.out.println("사고 내용 : " + this.accidentContent);
		System.out.println("가해 여부 : " + this.doingHarm);
		System.out.println("담당 손해사정업체 : " + this.repSurveyCompany);
		System.out.println("["+this.exemptionInfoID+"]_면/부책 정보 : ");
		for(int i=0; i<this.exemptionContent.size(); i++){
			System.out.println("항목" + (i+1));
			System.out.println("책임 여부 : " + this.exemptionContent.get(i).getResponsibility());
			System.out.println("판단 사유 : " + this.exemptionContent.get(i).getJudgementReason());
			System.out.println("보험금 지급 비율 : " + this.exemptionContent.get(i).getPaymentRatio());
		}
		if(this.onSite==true)
			System.out.println("현장 조사 여부 : 조사함");
		else
			System.out.println("현장 조사 여부 : 조사하지 않음");
	}

	public void registerExemptionInfo(String accidentID){
		ExemptionInfo exemptionInfo=new ExemptionInfo();

		exemptionInfo.setExemptionInfoID(exemptionInfoID);

		System.out.println("책임 여부를 입력하세요.");
		System.out.println("(y)부책 (n)면책");
		String response = scn.next();
		if (response.equals("y"))
			exemptionInfo.setResponsibility(Responsibility.responsible);
		else if (response.equals("n"))
			exemptionInfo.setResponsibility(Responsibility.notResponsible);

		System.out.println("판단 사유를 입력하세요 : ");
		String judgementReason=scn.next();
		exemptionInfo.setJudgementReason(judgementReason);

		System.out.println("보험금 지급 비율을 입력하세요 : ");
		Double paymentRatio=scn.nextDouble();
		exemptionInfo.setPaymentRatio(paymentRatio);

	}

	public String getAccidentInfo(){
		return accidentID+" "+customerID+" "+accidentType+" "+accidentDate+" "+accidentLocation+" "+ accidentScale +" "+ accidentContent +" "+ doingHarm +" "+ repSurveyCompany +" "+ exemptionContent +" "+ onSite;
	}


}//end Accident