package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.etcEnum.Level;
import Practice.InsuranceCompany.Design.src.model.policyholder.DiseaseHistory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiseaseHistoryDao extends Dao {
    public DiseaseHistoryDao(){ super.connect(); }

    public boolean create(DiseaseHistory diseaseHistory){
        String query = "insert into diseaseHistory value(";
        query += dq + diseaseHistory.getId() + dq + ", "
                + dq + diseaseHistory.getName() + dq + ", "
                + dq + diseaseHistory.getSeverity().getDetail() + dq + ", "
                + diseaseHistory.getStrugglePeriod() + ");";

        return super.create(query);
    }

    public DiseaseHistory retrieveById(String inputID) {
        try {
            if(inputID == null) return null;

            String query = "select * from diseaseHistory where diseaseHistoryId = " + dq + inputID + dq + ";";
            ResultSet resultSet = super.retrieve(query);
            if(resultSet.next()) { return setInfoByResultset(resultSet); }
            else return null;
        } catch (SQLException e){}
        return null;
    }

    private DiseaseHistory setInfoByResultset(ResultSet resultSet) {
        try {
            DiseaseHistory diseaseHistory = new DiseaseHistory();
            diseaseHistory.setId(resultSet.getString("diseaseHistoryId"));
            diseaseHistory.setName(resultSet.getString("diseaseName"));
            diseaseHistory.setSeverity(Level.makeLevel(resultSet.getString("severity")));
            diseaseHistory.setStrugglePeriod(resultSet.getInt("strugglePeriod"));
            return diseaseHistory;
        } catch (SQLException e){}
        return null;
    }

    public int retrieveMaxID() {
        try {
            String query = "select max(n.num) as ID from (select convert(substring_index(diseaseHistoryId,'DH',-1),unsigned) as num from diseaseHistory) n;";
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
