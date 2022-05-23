package Practice.InsuranceCompany.Design.src.subscription;


import Practice.InsuranceCompany.Design.src.etcEnum.UnderwritingStatus;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
public interface SubscriptionList {

	/**
	 * 
	 * @param subscription
	 */
	public boolean add(Subscription subscription);

	/**
	 * 
	 * @param subscriptionID
	 */
	public boolean delete(String subscriptionID);

	/**
	 * 
	 * @param customerID
	 */
	public Subscription get(String customerID);

	/**
	 * 
	 * @param subscriptionID
	 */
	public Subscription get(String subscriptionID);

	/**
	 * 
	 * @param subscriptionID
	 * @param underwritingStatus
	 */
	public boolean updateUnderwritingStatus(String subscriptionID, UnderwritingStatus underwritingStatus);

}