package Practice.InsuranceCompany.Design.src.payment;


import java.util.Date;

/**
 * @author ����
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:49
 */
public class MaturityDividend extends Payment {

	private Date dateOfExpiry;

	public MaturityDividend(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end MaturityDividend