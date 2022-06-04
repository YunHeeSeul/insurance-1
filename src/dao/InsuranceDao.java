package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.model.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.model.insurance.InsuranceListImpl;
import Practice.InsuranceCompany.Design.src.model.insurance.InsuranceType;
import Practice.InsuranceCompany.Design.src.model.insurance.WarrantyInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsuranceDao extends Dao{

    private WarrantyInfoDao warrantyInfoDao;
    private AcquisitionPolicyDao acquisitionPolicyDao;

    public InsuranceDao(){
        super.connect();
        this.warrantyInfoDao = new WarrantyInfoDao();
        acquisitionPolicyDao = new AcquisitionPolicyDao();
    }

    public boolean create(Insurance insurance){
        String queryForInsurance = "insert into insurance value(";
        queryForInsurance += dq + insurance.getInsuranceID() + dq + ", "
                + dq + insurance.getInsuranceName() + dq + ", "
                + dq + insurance.getInsuranceType().getDetail() + dq + ", "
                + dq + insurance.getJoinAge() + dq + ", "
                + dq + insurance.getPeril() + dq + ", "
                + dq + insurance.getRate() + dq + ", "
                + dq + insurance.isPermission() + dq + ", "
                + dq + insurance.getPremium() + dq + ", ";

        if(insurance.getAcquisitionPolicy() == null) queryForInsurance += dq + null + dq + ");";
        else queryForInsurance += dq + insurance.getAcquisitionPolicy().getID() + dq + ");";

        return super.create(queryForInsurance);
    }

    public void retrieve(){}

    public InsuranceListImpl retrieveAll() {
        try {
            InsuranceListImpl insuranceList = new InsuranceListImpl();

            String query = "select * from insurance";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) { insuranceList.add(setInsuranceByResultset(resultSet)); }
            return insuranceList;

        } catch (SQLException e){}
        return null;
    }

    public Insurance retrieveById(String inputID) {
        try {
            String query = "select * from insurance where insuranceId = " + dq + inputID + dq + ";";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) { return setInsuranceByResultset(resultSet); }
            else return null;
        } catch (SQLException e){}
        return null;
    }

    public boolean updateById(String inputID, Insurance insurance) {
        String query = "update insurance set ";
        query += "insuranceName = " + dq + insurance.getInsuranceName() + dq + ", "
                + "insuranceType = " + dq + insurance.getInsuranceType().getDetail() + dq + ", "
                + "join_age = " + insurance.getJoinAge() + ", "
                + "peril = " + insurance.getPeril() + ", "
                + "rate = " + insurance.getRate() + ", "
                + "permission = " + dq + insurance.isPermission() + dq + ", "
                + "premium = " + insurance.getPremium() + ", "
                + "acquisitionPolicyId = " + dq + insurance.getAcquisitionPolicy().getID() + dq
                + " where insuranceId = " + dq + inputID + dq + ";";

        return super.update(query);
    }

    public void updateNameById(String inputID, String newName) {
        String query = "update insurance set insuranceName = " + dq +newName + dq + " where insuranceId = " + dq + inputID + dq + ";";
        super.update(query);
    }

    public void delete(){}

    public boolean deleteById(String inputID) {
        Insurance insurance = retrieveById(inputID);

        String deleteQuery = "delete from warrantyInfo where insuranceId = " + dq +inputID + dq + ";";
        super.delete(deleteQuery);

        if(insurance.getAcquisitionPolicy() == null) {
            deleteQuery = "delete from insurance where insuranceId = " + dq +inputID + dq + ";";
            return super.delete(deleteQuery);
        }

        deleteQuery = "delete from acquisitionPolicy where acquisitionPolicyId = " + dq + insurance.getAcquisitionPolicy().getID() + dq + ";";
        super.delete(deleteQuery);

        deleteQuery = "delete from ownedCarInfo where ownedCarInfoId = " + dq +insurance.getAcquisitionPolicy().getCarInfoPolicy().getId() + dq + ";";
        super.delete(deleteQuery);

        deleteQuery = "delete from insurance where insuranceId = " + dq +inputID + dq + ";";
        return super.delete(deleteQuery);
    }

    private Insurance setInsuranceByResultset(ResultSet resultSet){
        try {
            Insurance insurance = new Insurance();

            insurance.setInsuranceID(resultSet.getString("insuranceId"));
            insurance.setInsuranceName(resultSet.getString("insuranceName"));
            insurance.setInsuranceType(InsuranceType.makeInsuranceType(resultSet.getString("insuranceType")));
            insurance.setJoinAge(resultSet.getInt("join_age"));
            insurance.setPeril(resultSet.getDouble("peril"));
            insurance.setRate(resultSet.getDouble("rate"));
            insurance.setPermission(resultSet.getBoolean("permission"));
            insurance.setPremium(resultSet.getInt("premium"));

            insurance.setWarrantyContent(warrantyInfoDao.retrieveAllByInsuranceId(insurance.getInsuranceID()));

            insurance.setAcquisitionPolicy(acquisitionPolicyDao.retrieveById(resultSet.getString("acquisitionPolicyId")));

            return insurance;
        } catch (SQLException e){

        }
        return null;
    }

    public int retrieveMaxID() {
        try {
            String query = "select max(insuranceId) as ID from insurance;";
            ResultSet resultSet = statement.executeQuery(query);
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


}
