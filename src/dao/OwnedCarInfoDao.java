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
                + dq + ownedCarInfo.getAccidentNumber() + dq + ", "
                + dq + ownedCarInfo.getCarType().getDetail() + dq + ", "
                + dq + ownedCarInfo.getCarPurpose().getDetail() + dq + ", "
                + dq + ownedCarInfo.getDisplacement() + dq + ");";
        return super.create(query);
    }

    public OwnedCarInfo retrieveById(String inputID) {
        try {
            if(inputID == null ) return null;
            String query = "select * from ownedCarInfo where ownedCarInfoId = " + dq + inputID + dq + ";";
            ResultSet resultSet = super.retrieve(query);
            if(resultSet.next()) return setInfoByResultset(resultSet);
            else return null;
        } catch (SQLException e){}
        return null;
    }

    private OwnedCarInfo setInfoByResultset(ResultSet resultSet) {
        try {
            OwnedCarInfo ownedCarInfo = new OwnedCarInfo();
            ownedCarInfo.setId(resultSet.getString("ownedCarInfoId"));
            ownedCarInfo.setAccidentNumber(resultSet.getInt("accidentNum"));
            ownedCarInfo.setCarType(CarType.makeCarType(resultSet.getString("carType")));
            ownedCarInfo.setCarPurpose(CarPurpose.makeCarPurpose(resultSet.getString("carPurpose")));
            ownedCarInfo.setDisplacement(resultSet.getInt("displacement"));
            return ownedCarInfo;
        } catch (SQLException e) {
        }
        return null;
    }

}
