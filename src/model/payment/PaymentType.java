package Practice.InsuranceCompany.Design.src.model.payment;

public enum PaymentType {
	payout("보험금",new ClaimsPaid()),
	maturity("만기보험금",new MaturityDividend()),
	cancellation("해약환급금",new CancellationReturn());

	private Payment payment;
	private String detail;
	PaymentType(String detail, Payment payment){
		this.detail=detail;
		this.payment=payment;
	}

	public String getDetail() {
		return this.detail;
	}

	public Payment getPayment(){
		return this.payment;
	}
}