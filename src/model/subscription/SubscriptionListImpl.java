package Practice.InsuranceCompany.Design.src.model.subscription;

import Practice.InsuranceCompany.Design.src.model.insurance.Insurance;

import java.util.ArrayList;

public class SubscriptionListImpl implements SubscriptionList {

    private ArrayList<Subscription> subscriptionList;

    public SubscriptionListImpl(){ this.subscriptionList = new ArrayList<>(); }
    public ArrayList<Subscription> getSubscriptionList(){ return this.subscriptionList; }

    @Override
    public boolean add(Subscription subscription) {
        if(this.subscriptionList != null){
            this.subscriptionList.add(subscription);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String subscriptionID) {
        if(this.subscriptionList != null) {
            for (Subscription subscription : this.subscriptionList) {
                if (subscriptionID.equals(subscription.getInsuranceID())) { this.subscriptionList.remove(subscription); }
                return true;
            }
        }
        return false;
    }

    @Override
    public Subscription get(String subscriptionID) {
        if(this.subscriptionList != null) {
            for (Subscription subscription : this.subscriptionList)
                if (subscriptionID.equals(subscription.getInsuranceID())) return subscription;
        }
        return null;
    }

    @Override
    public boolean update(String subscriptionID) {
        return false;
    }
}