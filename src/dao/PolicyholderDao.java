package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.etcEnum.Gender;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.model.policyholder.Policyholder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PolicyholderDao extends Dao {

    private DiseaseHistoryDao diseaseHistoryDao;
    private OwnedBuildingInfoDao ownedBuildingInfoDao;
    private OwnedCarInfoDao ownedCarInfoDao;

    public PolicyholderDao(){
        super.connect();
        this.diseaseHistoryDao = new DiseaseHistoryDao();
        this.ownedBuildingInfoDao = new OwnedBuildingInfoDao();
        this.ownedCarInfoDao = new OwnedCarInfoDao();
    }

    public boolean create(Policyholder policyholder){
        String query = "insert into policyholder value('"
                + policyholder.getCustomerID() +"',"
                + policyholder.getTotalPremium()+",'"
                + policyholder.getAccountNum()+"',"
                + policyholder.isAcceptedAccidentExistence()+","
                + policyholder.getOwnedBuildingNumber()+","
                + policyholder.isPaymentState()+");";
        return super.create(query);
    }

    public CustomerListImpl retrieveAll() {
        try {
            CustomerListImpl policyHolderList = new CustomerListImpl();

            String query = "select * from customer c right join policyholder p on c.customerid=p.customerid;";
            ResultSet resultSet = super.retrieve(query);
            while (resultSet.next()) { policyHolderList.add(setPolicyHolderByResultset(resultSet)); }
            return policyHolderList;

        } catch (SQLException e){}
        return null;
    }

    public Policyholder retrieveById(String inputID) {
        try {
            String query = "select * from customer c right join policyholder p on c.customerid=p.customerid where customerId = ''" + inputID +  "'';";
            ResultSet resultSet = super.retrieve(query);

            if (resultSet.next()) { return setPolicyHolderByResultset(resultSet); }
            else return null;
        } catch (SQLException e){}
        return null;
    }

    private Policyholder setPolicyHolderByResultset(ResultSet resultSet) {
        try {
            Policyholder policyholder = new Policyholder();

            policyholder.setCustomerID(resultSet.getString("customerId"));
            policyholder.setName(resultSet.getString("customerName"));
            policyholder.setResidentRegistrationNumber(resultSet.getString("residentRegistrationNum"));
            policyholder.setGender(Gender.makeGender(resultSet.getString("gender")));
            policyholder.setDateOfBirth(resultSet.getString("date_of_birth"));
            policyholder.setPhoneNumber(resultSet.getString("phone_number"));
            policyholder.setEmailAddress(resultSet.getString("email_address"));
            policyholder.setAddress(resultSet.getString("address"));
            policyholder.setDiseaseHistory(this.diseaseHistoryDao.retrieveById(resultSet.getString("diseaseHistoryId")));
            policyholder.setOwnedBuildingInfo(this.ownedBuildingInfoDao.retrieveById(resultSet.getString("ownedBuildingInfoId")));
            policyholder.setOwnedCarInfo(this.ownedCarInfoDao.retrieveById(resultSet.getString("ownedCarInfoId")));

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
