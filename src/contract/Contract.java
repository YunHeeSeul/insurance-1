package Practice.InsuranceCompany.Design.src.contract;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contract {

	private String contractID;
	private String customerID;
	private String insuranceID;
	private int contractPeriod;
	private String insuranceAgentID;
	private String joinDate;
	private String activityDate;
	private int monthlyPremium;

	public String getContractID() {
		return contractID;
	}
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}
	public int getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}
	public String getInsuranceAgentID() {
		return insuranceAgentID;
	}
	public void setInsuranceAgentID(String insuranceAgentID) {
		this.insuranceAgentID = insuranceAgentID;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public int getMonthlyPremium() {
		return monthlyPremium;
	}
	public void setMonthlyPremium(int monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}

	public Contract(String customerID, String insuranceID, int contractPeriod, int monthlyPremium, String insuranceAgentID) {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date today=new Date();
		String todayS=format.format(today);
		this.contractID = "ct1";
		this.customerID = customerID;
		this.insuranceID = insuranceID;
		this.contractPeriod = contractPeriod;
		this.joinDate = todayS;
		this.monthlyPremium = monthlyPremium;
		this.activityDate = todayS;
		this.insuranceAgentID = insuranceAgentID;
	}

	// 추가
	public String getContractInfo(){
		return contractID+" "+customerID+" "+insuranceID+" "+monthlyPremium+" "+joinDate+" "+ contractPeriod +" "+ activityDate;
	}

	// 추가
	public boolean isMaintenanceTarget(){
		try {
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			Date today=new Date();
			Date date=format.parse(joinDate);
			return date.compareTo(today) <= 31;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	// 매개변수 수정
	public boolean modifyActivityI(String residentRegistrationNumber){
		return false;
	}

	public Contract searchActivityT(){
		return null;
	}
}//end Contract