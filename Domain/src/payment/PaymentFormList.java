package Practice.InsuranceCompany.Design.Domain.src.payment;


/**
 * @author ����
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
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
	 * @param examinationResul
	 */
	public boolean updateExaminationResult(boolean examinationResul);

}