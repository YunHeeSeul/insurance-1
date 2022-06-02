package Practice.InsuranceCompany.Design.src.model.payment;

public enum PaymentType {
	payout(new ClaimsPaid()),
	maturity(new MaturityDividend()),
	cancellation(new CancellationReturn());

	private Payment payment;
	PaymentType(Payment payment){
		this.payment=payment;
	}

	public Payment getPayment(){
		return this.payment;
	}
}