package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.model.policyholder.Policyholder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PolicyholderDao extends Dao {
    public PolicyholderDao(){
        super.connect();
    }

    public boolean create(Policyholder policyholder){
        String query = "insert into policyholder value('"
                + policyholder.getCustomerID() +"',"
                + policyholder.getTotalPremium()+",'"
                + policyholder.getAccountNum()+"',"
                + policyholder.isAcceptedAccidentExistence()+","
                + policyholder.getOwnedBuildingNumber()+","
                + policyholder.isPaymentState()+";";
        return super.create(query);
    }


    public Policyholder retrieveById(String inputID) {
        try {
            String query = "select * from policyholder where customerId = ''" + inputID +  "'';";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) { return setCustomerByResultset(resultSet); }
            else return null;
        } catch (SQLException e){}
        return null;
    }

    private Policyholder setCustomerByResultset(ResultSet resultSet) {
        try {
            Policyholder policyholder = new Policyholder();

            policyholder.setCustomerID(resultSet.getString("customerId"));
            policyholder.setTotalPremium(resultSet.getInt("totalPremium"));
            policyholder.setAccountNum(resultSet.getString("accountNumber"));
            policyholder.setAcceptedAccidentExistence(resultSet.getBoolean("acceptedAccidentExistence"));
            policyholder.setOwnedBuildingNumber(resultSet.getInt("ownedBuildingNumber"));
            policyholder.setPaymentState(resultSet.getBoolean("paymentStatus"));
            return policyholder;
        } catch (SQLException e){

        }
        return null;

    }

    public boolean updateTotalPremiumTypeById(String cusID ,int premium) {
        String query = "update policyholder set totalPremium = "+ premium
                + " where customerId = " + dq + cusID + dq +";" ;
        return super.update(query);
    }
}
