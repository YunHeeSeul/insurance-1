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

	public static PaymentType makePaymentType(String detail){
		if (detail.equals(payout.getDetail())) return payout;
		if (detail.equals(maturity.getDetail())) return maturity;
		if (detail.equals(cancellation.getDetail())) return cancellation;
		else return null;
	}

	public String getDetail() {
		return this.detail;
	}

	public Payment getPayment(){
		return this.payment;
	}
}