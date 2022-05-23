package Practice.InsuranceCompany.Design.src.payment;


/**
 * @author ����
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public class CancellationReturn extends Payment {

	private String cancellationReason;

	public CancellationReturn(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end CancellationReturn