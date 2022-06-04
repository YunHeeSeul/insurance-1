package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.etcEnum.Gender;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao extends Dao {

    private DiseaseHistoryDao diseaseHistoryDao;
    private OwnedBuildingInfoDao ownedBuildingInfoDao;
    private OwnedCarInfoDao ownedCarInfoDao;

    public CustomerDao(){
        super.connect();
        this.diseaseHistoryDao = new DiseaseHistoryDao();
        this.ownedBuildingInfoDao = new OwnedBuildingInfoDao();
        this.ownedCarInfoDao = new OwnedCarInfoDao();
    }

    public boolean create(Customer customer){
        String query = "insert into customer value(";
        query += dq + customer.getCustomerID() + dq + ", "
                        + dq + customer.getName() + dq + ", "
                        + dq + CustomerType.interested.getDetail() + dq + ", "
                        + dq + customer.getResidentRegistrationNumber() + dq + ", "
                        + dq + customer.getGender().getDetail() + dq + ", "
                        + dq + customer.getDateOfBirth() + dq + ", "
                        + dq + customer.getPhoneNumber() + dq + ", "
                        + dq + customer.getEmailAddress() + dq + ", "
                        + dq + customer.getAddress() + dq + ", ";

        if(customer.getDiseaseHistory() == null) query += "null" + ", ";
        else query += dq + customer.getDiseaseHistory().getId() + dq + ", ";

        if(customer.getOwnedBuildingInfo() == null) query += "null" + ", ";
        else query += dq + customer.getOwnedBuildingInfo().getId() + dq + ", ";

        if(customer.getOwnedCarInfo() == null) query += "null" + ");";
        else query += dq + customer.getOwnedCarInfo().getId() + dq + ");";

        return super.create(query);
    }

    public CustomerListImpl retrieveAll() {
        try {
            CustomerListImpl customerList = new CustomerListImpl();

            String query = "select * from customer";
            ResultSet resultSet = super.retrieve(query);
            while (resultSet.next()) { customerList.add(setCustomerByResultset(resultSet)); }
            return customerList;

        } catch (SQLException e){}
        return null;
    }


    public Customer retrieveById(String inputID) {
        try {
            String query = "select * from customer where customerId = " + dq + inputID + dq + ";";
            ResultSet resultSet = super.retrieve(query);

            if (resultSet.next()) { return setCustomerByResultset(resultSet); }
            else return null;
        } catch (SQLException e){}
        return null;
    }

    public boolean deleteById(String id){
        String deleteQuery = "delete from customer where customerId = " + dq + id + dq + ";";
        return super.delete(deleteQuery);
    }

    public int retrieveMaxID() {
        try {
            String query = "select max(customerId) as ID from customer;";
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


    private Customer setCustomerByResultset(ResultSet resultSet) {
        try {
            Customer customer = new Customer();

            customer.setCustomerID(resultSet.getString("customerId"));
            customer.setName(resultSet.getString("customerName"));
            customer.setCustomerType(CustomerType.makeCustomerType(resultSet.getString("customerType")));
            customer.setResidentRegistrationNumber(resultSet.getString("residentRegistrationNum"));
            customer.setGender(Gender.makeGender(resultSet.getString("gender")));
            customer.setDateOfBirth(resultSet.getString("date_of_birth"));
            customer.setPhoneNumber(resultSet.getString("phone_number"));
            customer.setEmailAddress(resultSet.getString("email_address"));
            customer.setAddress(resultSet.getString("address"));

            customer.setDiseaseHistory(this.diseaseHistoryDao.retrieveById(resultSet.getString("diseaseHistoryId")));
            customer.setOwnedBuildingInfo(this.ownedBuildingInfoDao.retrieveById(resultSet.getString("ownedBuildingInfoId")));
            customer.setOwnedCarInfo(this.ownedCarInfoDao.retrieveById(resultSet.getString("ownedCarInfoId")));
            return customer;
        } catch (SQLException e){

        }
        return null;

    }


    public boolean updateById(String inputID, Customer customer) {
        String query = "update customer set ";
        query += "customerName = " + dq + customer.getName() + dq + ", "
                + "residentRegistrationNum = " + dq + customer.getResidentRegistrationNumber() + dq + ", "
                + "gender = " + dq + customer.getGender().getDetail() + dq + ", "
                + "date_of_birth = " + dq + customer.getDateOfBirth() + dq + ", "
                + "phone_number = " + dq + customer.getPhoneNumber() + dq + ", "
                + "email_address = " + dq  + customer.getEmailAddress() + dq + ", "
                + "address = " + dq + customer.getAddress() + dq + ", "
                + "customerType = " + dq + customer.getCustomerType().getDetail() + dq + ", ";

        if(customer.getDiseaseHistory() == null) query += "diseaseHistoryId = null, ";
        else query += "diseaseHistoryId = " + dq + customer.getDiseaseHistory().getId() + dq + ", ";

        if(customer.getOwnedBuildingInfo() == null) query += "ownedBuildingInfoId = null, ";
        else query += "ownedBuildingInfoId = " + dq + customer.getOwnedBuildingInfo().getId() + dq + ", ";

        if(customer.getOwnedCarInfo() == null) query += "ownedCarInfoId = null";
        else query += "ownedCarInfoId = " + dq + customer.getOwnedCarInfo().getId() + dq;

        query += " where customerId = " + dq + inputID + dq ;

        return super.update(query);
    }

    public boolean updateCustomerTypeById(String inputID) {
        String query = "update customer set customerType = '"+ CustomerType.subscriber.getDetail()
                + "' where customerId = " + dq + inputID + dq +";" ;
        return super.update(query);
    }
}
