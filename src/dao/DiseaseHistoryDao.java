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
                + dq + diseaseHistory.getSeverity().name() + dq + ", "
                + diseaseHistory.getStrugglePeriod() + ");";
        System.out.println("Execute Query - " + query);

        if(super.create(query)) return true;
        else return false;
    }

    public DiseaseHistory retrieveById(String inputID) {
        try {
            if(inputID == null) return null;

            String query = "select * from diseaseHistory where diseaseHistoryId = " + dq + inputID + dq + ";";
            ResultSet resultSet = statement.executeQuery(query);
            DiseaseHistory diseaseHistory = new DiseaseHistory();
            while(resultSet.next()) { diseaseHistory = setInfoByResultset(diseaseHistory, resultSet); }
            return diseaseHistory;
        } catch (SQLException e){}
        return null;
    }

    private DiseaseHistory setInfoByResultset(DiseaseHistory diseaseHistory, ResultSet resultSet) {
        try {
            diseaseHistory.setId(resultSet.getString("diseaseHistoryId"));
            diseaseHistory.setName(resultSet.getString("diseaseName"));
            diseaseHistory.setSeverity(Level.valueOf(resultSet.getString("severity")));
            diseaseHistory.setStrugglePeriod(resultSet.getInt("strugglePeriod"));
            return diseaseHistory;
        } catch (SQLException e){}
        return null;
    }
}
