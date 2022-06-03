package Practice.InsuranceCompany.Design.src.model.payment;

public class PaymentForm {

	public static String paymentFormIdFormat = "pm";
	public int cnt = 0;
	private String paymentFormID;
	private String contractID;
	private String customerId;

	private PaymentType paymentType;
	private Payment payment;
	// 수정
	private boolean examinationResult;

	public PaymentForm(){
		this.paymentFormID= paymentFormIdFormat + (cnt++);
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

	public String getPaymentFormID() {
		return paymentFormID;
	}

	public void setPaymentFormID(String paymentFormID) {
		this.paymentFormID = paymentFormID;
	}

	public String getContractID() {
		return contractID;
	}

	public String getCustomerId() {
		return customerId;
	}

	public boolean isExaminationResult() {
		return examinationResult;
	}


	public String getPaymentFormId() {
		return this.paymentFormID;
	}

	public String getPaymentFormInfo() {
		return "제지급금 신청서 고유 코드: " + paymentFormID+ " 보험 계약 코드 :"+contractID+ "고객 고유 코드 :  "+ customerId;
	}

	public void setCustomerId(String customerID) {
		this.customerId = customerID;
	}

	public void setExaminationResult(boolean examinationResult) {
		this.examinationResult = examinationResult;
	}
}