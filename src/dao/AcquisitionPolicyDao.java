package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.model.insurance.AcquisitionPolicy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcquisitionPolicyDao extends Dao {
    private OwnedCarInfoDao ownedCarInfoDao;
    private OwnedBuildingInfoDao ownedBuildingInfoDao;
    private DiseaseHistoryDao diseaseHistoryDao;

    public AcquisitionPolicyDao() {
        super.connect();
        this.ownedCarInfoDao = new OwnedCarInfoDao();
        this.ownedBuildingInfoDao = new OwnedBuildingInfoDao();
        this.diseaseHistoryDao = new DiseaseHistoryDao();
    }

    public boolean create(AcquisitionPolicy acquisitionPolicy) {
        String buildingInfoID = "null";
        String carInfoID = "null";
        String diseaseHistoryID = "null";

        if(acquisitionPolicy.getCarInfoPolicy() != null) {
            this.ownedCarInfoDao.create(acquisitionPolicy.getCarInfoPolicy());
            carInfoID = dq + acquisitionPolicy.getCarInfoPolicy().getId() + dq;
        }
        else if(acquisitionPolicy.getDiseaseInfoPolicy() != null) {
            this.diseaseHistoryDao.create(acquisitionPolicy.getDiseaseInfoPolicy());
            diseaseHistoryID = dq + acquisitionPolicy.getCarInfoPolicy().getId() + dq;
        }
        else if(acquisitionPolicy.getBuildingInfoPolicy() != null) {
            this.ownedBuildingInfoDao.create(acquisitionPolicy.getBuildingInfoPolicy());
            buildingInfoID = dq + acquisitionPolicy.getBuildingInfoPolicy().getId() + dq;
        }

        String query = "insert into acquisitionPolicy value(";
        query += dq + acquisitionPolicy.getID() + dq + ", "
                + buildingInfoID + ", "
                + carInfoID + ", "
                + diseaseHistoryID + ");";

        return super.create(query);
    }

    public void retrieve(){}

    public ArrayList<AcquisitionPolicy> retrieveAll() {
        return null;
    }

    public AcquisitionPolicy retrieveById(String inputID) {
        try {
            if(inputID == null) return null;

            String query = "select * from acquisitionPolicy where acquisitionPolicyId = " + dq +inputID + dq + ";";
            ResultSet resultSet = super.retrieve(query);

            if(resultSet.next()){ return setAcquisitionPolicyByResultSet(resultSet); }
            else return null;
        } catch (SQLException e){}
        return null;
    }

    private AcquisitionPolicy setAcquisitionPolicyByResultSet(ResultSet resultSet) {
        try {
            AcquisitionPolicy acquisitionPolicy = new AcquisitionPolicy();

            acquisitionPolicy.setAcquisitionPolicyId(resultSet.getString("acquisitionPolicyId"));
            acquisitionPolicy.setBuildingInfoPolicy(ownedBuildingInfoDao.retrieveById(resultSet.getString("buildingInfoPolicyId")));
            acquisitionPolicy.setCarInfoPolicy(ownedCarInfoDao.retrieveById(resultSet.getString("carInfoPolicyId")));
            acquisitionPolicy.setDiseaseInfoPolicy(diseaseHistoryDao.retrieveById(resultSet.getString("diseaseInfoPolicyId")));
            return acquisitionPolicy;
        } catch (SQLException e){

        }
        return null;
    }

    public int retrieveMaxID() {
        try {
            String query = "select max(n.num) as ID from (select convert(substring_index(acquisitionPolicyId,'AP',-1),unsigned) as num from acquisitionPolicy) n;";
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

}
