package Practice.InsuranceCompany.Design.src.model.customer;


import Practice.InsuranceCompany.Design.src.model.subscription.Subscription;

import java.util.ArrayList;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
public class PotentialCustomer extends Customer {

	private ArrayList<Subscription> subscription;
	public Subscription m_Subscription;

	public PotentialCustomer(){

	}

	public ArrayList<Subscription> getSubscriptionList(){ return this.subscription; }

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end PotentialCustomer