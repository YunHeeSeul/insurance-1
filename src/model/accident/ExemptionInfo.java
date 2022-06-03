package Practice.InsuranceCompany.Design.src.model.accident;

import Practice.InsuranceCompany.Design.src.etcEnum.Responsibility;

import java.util.ArrayList;

public class ExemptionInfo {
//판단 자료 없앰
//	private String judgementData;

	//	private static int IDnum=0;
	private String exemptionInfoID;
	private String judgementReason;
	private double paymentRatio;
	private Responsibility responsibility;
	private String exemptionContent;


	public ArrayList<ExemptionInfo> exemptionInfoList;
	/*
	public ExemptionInfo(String exemptionInfoID, String judgementReason, double paymentRatio, Responsibility responsibility){
		this.exemptionInfoID=exemptionInfoID;
		this.judgementReason=judgementReason;
		this.paymentRatio=paymentRatio;
		this.responsibility=responsibility;
	}
	 */
	public ExemptionInfo(){
		this.exemptionInfoList = new ArrayList<>();
		//	this.exemptionInfoID = Integer.toString(IDnum + 1);
	}
	public String getExemptionInfoID(){
		return exemptionInfoID;
	}
	public void setExemptionInfoID(String exemptionInfoID){
		this.exemptionInfoID= this.exemptionInfoID;
	}
	public String getJudgementReason(){
		return judgementReason;
	}
	public void setJudgementReason(String judgementReason){
		this.judgementReason= this.judgementReason;
	}
	public double getPaymentRatio(){
		return paymentRatio;
	}
	public void setPaymentRatio(double paymentRatio){
		this.paymentRatio= this.paymentRatio;
	}
	public Responsibility getResponsibility(){
		return responsibility;
	}
	public void setResponsibility(Responsibility responsibility){
		this.responsibility= this.responsibility;
	}
	public String getExemptionContent() {
		return exemptionContent;
	}

	public void setExemptionContent(String exemptionContent) {
		this.exemptionContent = exemptionContent;
	}


	public boolean add(ExemptionInfo exemptionInfo) {
		this.exemptionInfoList.add(exemptionInfo);
		return true;
	}
}//end ExemptionInfo