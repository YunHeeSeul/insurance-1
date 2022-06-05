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
        query += "underwritingStatus = " + dq + detail + dq
                + " where subscriptionID = "+ dq + id + dq +";";

        return super.update(query);
    }

    private Subscription setSubscriptionByResultset(ResultSet resultSet) {
        try {
            Subscription subscription = new Subscription();

            subscription.setSubscriptionID(resultSet.getString("subscriptionId"));
            subscription.setUnderwritingStatus(UnderwritingStatus.makeUnderwritingStatus(resultSet.getString("underwritingStatus")));
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
            String query = "select max(n.num) as ID from (select convert(substring_index(subscriptionId,'SC',-1),unsigned) as num from subscription) n;";
            ResultSet rs = super.retrieve(query);
            if(rs.next()) {
                int id=rs.getInt("ID");
                if (rs.wasNull()) return 0;
                return id;
            }
            else return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
