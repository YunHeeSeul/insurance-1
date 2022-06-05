package Practice.InsuranceCompany.Design.src.model.subscription;

import java.util.ArrayList;

public interface SubscriptionList {

    ArrayList<Subscription> getSubscriptionList();

    boolean add(Subscription subscription);

    boolean delete(String subscriptionID);

    Subscription get(String subscriptionID);

    boolean update(String subscriptionID);

}