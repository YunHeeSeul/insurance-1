package Practice.InsuranceCompany.Design.src.model.payment;

public interface PaymentFormList {

	/**
	 * 
	 * @param paymentForm
	 */
	public boolean add(PaymentForm paymentForm);

	/**
	 * 
	 * @param paymentFormID
	 */
	public boolean delete(String paymentFormID);

	/**
	 * 
	 * @param contractID
	 */
	public PaymentForm get(String contractID);

	/**
	 * 
	 * @param examinationResult
	 */
	public boolean updateExaminationResult(boolean examinationResult);

}