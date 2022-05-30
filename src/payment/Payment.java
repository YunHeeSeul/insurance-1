package Practice.InsuranceCompany.Design.src.payment;

import Practice.InsuranceCompany.Design.src.customer.Customer;

public abstract class Payment {

	private long amount;

	public Payment(){
		this.amount = 0;
	}

	//추가
	public abstract boolean setPaymentInfo();
	public abstract int calculatePayment();

	public long getAmount() {
		return amount;
	}

	/**
	 *
	 * @param customer
	 */
	public abstract void sendPaymentGuide(Customer customer);
}//end Payment