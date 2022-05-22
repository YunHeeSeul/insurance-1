package Practice.InsuranceCompany.Design.Domain.src.subscription;


import Practice.InsuranceCompany.Design.Domain.src.etcEnum.UnderwritingStatus;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
public abstract class SubscriptionListImpl implements SubscriptionList {

	private ArrayList<Subscription> subscriptionList;
	public Subscription m_Subscription;

	public SubscriptionListImpl(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param subscription
	 */
	public boolean add(Subscription subscription){
		return false;
	}

	/**
	 * 
	 * @param subscriptionID
	 */
	public boolean delete(String subscriptionID){
		return false;
	}

	/**
	 * 
	 * @param custiomerID
	 */
	public Subscription get(String custiomerID){
		return null;
	}

	/**
	 * 
	 * @param subscriptionID
	 */
	public Subscription get(String subscriptionID){
		return null;
	}

	/**
	 * 
	 * @param updateSubscriptionID
	 * @param underwritingStatus
	 */
	public boolean updateUnderwriting(String updateSubscriptionID, UnderwritingStatus underwritingStatus){
		return false;
	}

	/**
	 * 
	 * @param subscriptionID
	 * @param underwritingStatus
	 */
	public boolean updateUnderwritingStatus(String subscriptionID, UnderwritingStatus underwritingStatus){
		return false;
	}
}//end SubscriptionListImpl