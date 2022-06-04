package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedBuildingInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnedBuildingInfoDao extends Dao {

    public OwnedBuildingInfoDao(){ super.connect(); }

    public boolean create(OwnedBuildingInfo ownedBuildingInfo) {
        String query = "insert into ownedBuildingInfo value(";
        query += dq + ownedBuildingInfo.getId() + dq + ", "
                        + dq + ownedBuildingInfo.getFloorNumber() + dq + ", "
                        + dq + ownedBuildingInfo.getSpecializedBuilding() + dq + ");";
        return super.create(query);
    }

    public OwnedBuildingInfo retrieveById(String inputID) {
        try {
            if(inputID == null) return null;
            String query = "select * from ownedBuildingInfo where ownedBuildingInfoId = " + dq + inputID + dq + ";";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()) return setInfoByResultset(resultSet);
            else return null;
        } catch (SQLException e){}
        return null;
    }

    private OwnedBuildingInfo setInfoByResultset(ResultSet resultSet) {
        try {
            OwnedBuildingInfo ownedBuildingInfo = new OwnedBuildingInfo();
            ownedBuildingInfo.setId(resultSet.getString("ownedBuildingInfoId"));
            ownedBuildingInfo.setFloorNumber(resultSet.getInt("floorNum"));
            ownedBuildingInfo.setSpecializedBuilding(resultSet.getBoolean("specializedBuilding"));
            return ownedBuildingInfo;
        } catch (SQLException e) {
        }
        return null;
    }
}
