package Practice.InsuranceCompany.Design.src.model.payment;

public class PaymentFormListImpl implements PaymentFormList {

	public PaymentForm m_PaymentForm;

	public PaymentFormListImpl(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param paymentForm
	 */
	public boolean add(PaymentForm paymentForm){
		return false;
	}

	/**
	 * 
	 * @param paymentFormID
	 */
	public boolean delete(String paymentFormID){
		return false;
	}

	/**
	 * 
	 * @param contractID
	 */
	public PaymentForm get(String contractID){
		return null;
	}

	/**
	 * 
	 * @param examinationResult
	 */
	public boolean updateExaminationResult(boolean examinationResult){
		return false;
	}
}//end PaymentFormListImpl