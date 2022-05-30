package Practice.InsuranceCompany.Design.src.payment;

public class PaymentForm {

	private String paymentFormID;  // 오타 수정
	private String contractID;
	private PaymentType paymentType;
	private Payment payment;
	// 수정
	private boolean examinationResult;
//	private Payment m_Payment;  // 왜 또 있지...?

	public PaymentForm(){
		this.paymentFormID="1";
		this.examinationResult=false;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void setExaminationResult(boolean examinationResult) {
		this.examinationResult = examinationResult;
	}

	/**
	 *
	 * @param result
	 */
	// 한글&오타 수정
	public boolean saveExaminationResult(boolean result){
		return false;
	}
}//end PaymentForm