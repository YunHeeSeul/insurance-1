package Practice.InsuranceCompany.Design.src.model.policyholder;

import Practice.InsuranceCompany.Design.src.model.customer.Customer;

public class Policyholder extends Customer {

	private boolean acceptedAccidentExistence;
	private String accountNum;
	private int ownedBuildingNumber;
	private boolean paymentState;
	private int totalPremium;

	public boolean isAcceptedAccidentExistence() {
		return acceptedAccidentExistence;
	}

	public void setAcceptedAccidentExistence(boolean acceptedAccidentExistence) {
		this.acceptedAccidentExistence = acceptedAccidentExistence;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public int getOwnedBuildingNumber() {
		return ownedBuildingNumber;
	}

	public void setOwnedBuildingNumber(int ownedBuildingNumber) {
		this.ownedBuildingNumber = ownedBuildingNumber;
	}

	public boolean isPaymentState() {
		return paymentState;
	}

	public void setPaymentState(boolean paymentState) {
		this.paymentState = paymentState;
	}

	public Policyholder(){

	}
	public void changePaymentState(boolean paymentState){ this.paymentState = paymentState; }

	public boolean getPaymentState(){
		return this.paymentState;
	}
	public int getTotalPremium(){
		return this.totalPremium;
	}

	public void setTotalPremium(int totalPremium) {
		this.totalPremium = totalPremium;
	}

}//end Policyholder