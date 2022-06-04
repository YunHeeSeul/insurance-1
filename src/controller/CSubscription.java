package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.SubscriptionDao;
import Practice.InsuranceCompany.Design.src.etcEnum.UnderwritingStatus;
import Practice.InsuranceCompany.Design.src.model.subscription.Subscription;
import Practice.InsuranceCompany.Design.src.model.subscription.SubscriptionListImpl;

import java.util.ArrayList;

public class CSubscription {
    private SubscriptionDao subscriptionDao;

    public CSubscription(){
        this.subscriptionDao = new SubscriptionDao();
    }

    public boolean create(Subscription subscription) { return this.subscriptionDao.create(subscription); }
    public SubscriptionListImpl retrieveAll() { return this.subscriptionDao.retrieveAll(); }
    public Subscription retrieveById(String id) { return this.subscriptionDao.retrieveById(id); }
    public boolean updateById(String inputID, Subscription subscription) { return this.subscriptionDao.updateById(inputID, subscription); }
    public boolean updateUWstatusById(String id, UnderwritingStatus status){ return this.subscriptionDao.updateUWstatusById(id, status.getDetail()); }
    public ArrayList<Subscription> getAllSubscriptionOfCustomerByID(String customerID) { return this.subscriptionDao.retrieveAllById(customerID); }
    public boolean deleteById(String inputID) { return this.subscriptionDao.deleteById(inputID); }

    public int getMaxID() { return this.subscriptionDao.retrieveMaxID(); }
}
