package Practice.InsuranceCompany.Design.src.payment;

public class CancellationReturn extends Payment {

	private String cancellationReason;

	public CancellationReturn(){

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
}//end CancellationReturn