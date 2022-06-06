package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.enums.CarPurpose;
import Practice.InsuranceCompany.Design.src.enums.CarType;
import Practice.InsuranceCompany.Design.src.model.customer.OwnedCarInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnedCarInfoDao extends Dao {

    public OwnedCarInfoDao(){ super.connect(); }

    public boolean create(OwnedCarInfo ownedCarInfo) {
        String query = "insert into ownedCarInfo value(";
        query += dq + ownedCarInfo.getId() + dq + ", "
                + ownedCarInfo.getAccidentNumber() + ", "
                + dq + ownedCarInfo.getCarType().getDetail() + dq + ", "
                + dq + ownedCarInfo.getCarPurpose().getDetail() + dq + ", "
                + ownedCarInfo.getDisplacement() + ");";
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

    public int retrieveMaxID() {
        try {
            String query = "select max(n.num) as ID from (select convert(substring_index(ownedCarInfoId,'CI',-1),unsigned) as num from ownedCarInfo) n;";
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
