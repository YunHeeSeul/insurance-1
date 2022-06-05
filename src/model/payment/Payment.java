package Practice.InsuranceCompany.Design.src.model.payment;

import Practice.InsuranceCompany.Design.src.etcEnum.ClaimType;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentType;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;

import java.util.Scanner;

public abstract class Payment {

	public Payment(){
		this.amount = 0;
	}
	private long amount;

	// 보험금 필드
	protected String accidentCircumstance;
	protected String accidentDateTime;
	protected String accidentPlace;
	protected AccidentType accidentType;
	protected ClaimType claimReason;
	protected String diseaseName;


	// 해약 환급금 필드
	protected String cancellationReason;

	// 만기보험금 필드
	protected String dateOfExpiry;

	abstract public void sendPaymentGuide(Customer customer);
	public abstract void setPaymentInfo(Scanner scn, Payment payment);
	public abstract int calculatePayment(int premium);

	public String getAccidentCircumstance() {
		return accidentCircumstance;
	}

	public String getAccidentDateTime() {
		return accidentDateTime;
	}

	public String getAccidentPlace() {
		return accidentPlace;
	}

	public AccidentType getAccidentType() {
		return accidentType;
	}

	public ClaimType getClaimReason() {
		return claimReason;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public String getCancellationReason() {
		return cancellationReason;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public void setAccidentCircumstance(String accidentCircumstance) {
		this.accidentCircumstance = accidentCircumstance;
	}

	public void setAccidentDateTime(String accidentDateTime) {
		this.accidentDateTime = accidentDateTime;
	}

	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}

	public void setAccidentType(AccidentType accidentType) {
		this.accidentType = accidentType;
	}

	public void setClaimReason(ClaimType claimReason) {
		this.claimReason = claimReason;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
}