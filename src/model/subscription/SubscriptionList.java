package Practice.InsuranceCompany.Design.src.model.subscription;

public interface SubscriptionList {

    boolean add(Subscription subscription);

    boolean delete(String subscriptionID);

    Subscription get(String subscriptionID);

    boolean update(String subscriptionID);

}