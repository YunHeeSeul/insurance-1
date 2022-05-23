package Practice.InsuranceCompany.Design.src.payment;

public abstract class Payment {

	private long amount;

	public Payment(){
		this.amount = 0;
	}

	public void finalize() throws Throwable {

	}

	//추가
	public abstract boolean setPaymentInfo();
	public abstract int calculatePayment();

	/**
	 *
	 * @param customerID
	 */
	public abstract boolean sendPaymentGuide(String customerID);
}//end Payment