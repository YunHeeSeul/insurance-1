package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.etcEnum.CarPurpose;
import Practice.InsuranceCompany.Design.src.etcEnum.CarType;
import Practice.InsuranceCompany.Design.src.model.policyholder.OwnedCarInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnedCarInfoDao extends Dao {

    public OwnedCarInfoDao(){ super.connect(); }

    public boolean create(OwnedCarInfo ownedCarInfo) {
        String query = "insert into ownedCarInfo value(";
        query += dq + ownedCarInfo.getId() + dq + ", "
                + dq + Integer.toString(ownedCarInfo.getAccidentNumber()) + dq + ", "
                + dq + ownedCarInfo.getCarType() + dq + ", "
                + dq + ownedCarInfo.getCarPurpose() + dq + ", "
                + dq + Integer.toString(ownedCarInfo.getDisplacement()) + dq + ");";
        System.out.println("Execute Query - " + query);

        if(super.create(query)) return true;
        else return false;
    }

    public OwnedCarInfo retrieveById(String inputID) {
        try {
            if(inputID == null ) return null;
            String query = "select * from ownedCarInfo where ownedCarInfoId = " + dq + inputID + dq + ";";
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("execture query - " + query);
            OwnedCarInfo ownedCarInfo = new OwnedCarInfo();
            if(setInfoByResultset(ownedCarInfo, resultSet)) return ownedCarInfo;
        } catch (SQLException e){}
        return null;
    }

    private boolean setInfoByResultset(OwnedCarInfo ownedCarInfo, ResultSet resultSet) {
        try {
            while(resultSet.next()) {
                String id = resultSet.getString("ownedCarInfoId");
                if(id.equals("null")) return false;

                ownedCarInfo.setId(id);
                ownedCarInfo.setAccidentNumber(resultSet.getInt("accidentNum"));
                ownedCarInfo.setCarType(CarType.valueOf(resultSet.getString("carType")));
                ownedCarInfo.setCarPurpose(CarPurpose.valueOf(resultSet.getString("carPurpose")));
                ownedCarInfo.setDisplacement(resultSet.getInt("displacement"));
            }
            return true;
        } catch (SQLException e){}
        return false;
    }

}
