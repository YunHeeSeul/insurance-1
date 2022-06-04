package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.etcEnum.UnderwritingStatus;
import Practice.InsuranceCompany.Design.src.model.subscription.Subscription;
import Practice.InsuranceCompany.Design.src.model.subscription.SubscriptionListImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubscriptionDao extends Dao {

    public SubscriptionDao(){ super.connect(); }

    public boolean create(Subscription subscription){
        String queryForInsurance = "insert into subscription value(";
        queryForInsurance += dq + subscription.getSubscriptionID() + dq + ", "
                + dq + subscription.getUnderwritingStatus().getDetail() + dq + ", "
                + dq + subscription.getDateCreated() + dq + ", "
                + dq + subscription.getInsurancePeriod() + dq + ", "
                + dq + subscription.getPremium() + dq + ", "
                + dq + subscription.getCustomerID() + dq + ", "
                + dq + subscription.getInsuranceID() + dq + ", "
                + dq + subscription.getInsuranceAgentID() + dq + ");";

        return super.create(queryForInsurance);
    }

    public SubscriptionListImpl retrieveAll() {
        try {
            SubscriptionListImpl subscriptionList = new SubscriptionListImpl();

            String query = "select * from subscription";
            ResultSet resultSet = super.retrieve(query);
            while (resultSet.next()) { subscriptionList.add(setSubscriptionByResultset(resultSet)); }
            return subscriptionList;

        } catch (SQLException e){}
        return null;
    }

    public ArrayList<Subscription> retrieveAllById(String customerID) {
        try {
            ArrayList<Subscription> subscriptions = new ArrayList<Subscription>();

            String query = "select * from subscription where customerId = " + dq + customerID + dq + ";";
            ResultSet resultSet = super.retrieve(query);
            while (resultSet.next()) { subscriptions.add(setSubscriptionByResultset(resultSet)); }
            return subscriptions;

        } catch (SQLException e){}
        return null;
    }

    public Subscription retrieveById(String inputID) {
        try {
            String query = "select * from subscription where subscriptionId = " + dq + inputID + dq + ";";
            ResultSet resultSet = super.retrieve(query);

            Subscription subscription = null;
            while (resultSet.next()) { subscription = setSubscriptionByResultset(resultSet); }
            return subscription;
        } catch (SQLException e){}
        return null;
    }

    public boolean updateUWstatusById(String id, String detail) {
        String query = "update subscription set ";
        query += "underwritingStatusId = " + dq + detail + dq
                + " where subscriptionID = "+ dq + id + dq +";";

        return super.update(query);
    }

    private Subscription setSubscriptionByResultset(ResultSet resultSet) {
        try {
            Subscription subscription = new Subscription();

            subscription.setSubscriptionID(resultSet.getString("subscriptionId"));

            String uwStatus = resultSet.getString("underwritingStatus");
            if(uwStatus.equals("신청")) subscription.setUnderwritingStatus(UnderwritingStatus.applied);
            else if(uwStatus.equals("미신청")) subscription.setUnderwritingStatus(UnderwritingStatus.notApplied);
            else if(uwStatus.equals("체결")) subscription.setUnderwritingStatus(UnderwritingStatus.concluded);
            else if(uwStatus.equals("반려")) subscription.setUnderwritingStatus(UnderwritingStatus.rejected);

            subscription.setDateCreated(resultSet.getString("dateCreated"));
            subscription.setInsurancePeriod(resultSet.getInt("insurancePeriod"));
            subscription.setPremium(resultSet.getInt("premium"));
            subscription.setCustomerID(resultSet.getString("customerId"));
            subscription.setInsuranceID(resultSet.getString("insuranceId"));
            subscription.setInsuranceAgentID(resultSet.getString("insuranceAgentId"));

            return subscription;

        } catch (SQLException e){

        }
        return null;
    }

    public int retrieveMaxID() {
        try {
            String query = "select max(subscriptionId) as ID from subscription;";
            ResultSet resultSet = super.retrieve(query);
            if (resultSet.next()) {
                String id = resultSet.getString("ID");
                if (id == null) return 0;
                else return Integer.parseInt(id.substring(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }


    public boolean deleteById(String inputID) {
        String deleteQuery = "delete from subscription where subscriptionId = " + dq +inputID + dq + ";";
        return super.delete(deleteQuery);
    }

    public boolean updateById(String inputID, Subscription subscription) {
        String query = "update subscription set ";
        query += "underwritingStatus = " + dq + subscription.getUnderwritingStatus().getDetail() + dq + ", "
                + "dateCreated = " + dq + subscription.getDateCreated() + dq + ", "
                + "insurancePeriod = " + subscription.getInsurancePeriod() + ", "
                + "premium = " + subscription.getPremium() + ", "
                + "customerId = " + dq + subscription.getCustomerID() + dq + ", "
                + "insuranceId = " + dq + subscription.getInsuranceID() + dq + ", "
                + "insuranceAgentId = " + dq + subscription.getInsuranceAgentID() + dq
                + " where subscriptionId = " + dq + inputID + dq + ";";

        return super.update(query);
    }
}
