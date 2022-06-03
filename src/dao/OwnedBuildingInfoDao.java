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
                        + dq + (ownedBuildingInfo.getSpecializedBuilding()?"t":"f") + dq + ");";
        System.out.println("Execute Query - " + query);

        if(super.create(query)) return true;
        else return false;
    }

    public OwnedBuildingInfo retrieveById(String inputID) {
        try {
            if(inputID == null) return null;
            String query = "select * from ownedBuildingInfo where ownedBuildingInfoId = " + dq + inputID + dq + ";";
            ResultSet resultSet = statement.executeQuery(query);
            OwnedBuildingInfo ownedBuildingInfo = new OwnedBuildingInfo();
            if(setInfoByResultset(ownedBuildingInfo, resultSet)) return ownedBuildingInfo;
        } catch (SQLException e){}
        return null;
    }

    private boolean setInfoByResultset(OwnedBuildingInfo ownedBuildingInfo, ResultSet resultSet) {
        try {
            while(resultSet.next()) {
                String id = resultSet.getString("ownedBuildingInfoId");
                if(id.equals("null")) return false;
                ownedBuildingInfo.setId(id);
                ownedBuildingInfo.setFloorNumber(resultSet.getInt("floorNum"));
                ownedBuildingInfo.setSpecializedBuilding(resultSet.getString("specializedBuilding") == "t" ? true : false);
            }
            return true;
        } catch (SQLException e){}
        return false;
    }
}
