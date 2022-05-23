package Practice.InsuranceCompany.Design.src.payment;


import java.util.Date;

public class MaturityDividend extends Payment {

	private Date dateOfExpiry;

	public MaturityDividend(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public boolean setPaymentInfo() {
		return false;
	}

	@Override
	public int calculatePayment() {
		return 0;
	}

	@Override
	public boolean sendPaymentGuide(String customerID) {
		return false;
	}
}//end MaturityDividend