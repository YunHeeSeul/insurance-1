package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.etcEnum.Level;
import Practice.InsuranceCompany.Design.src.model.accident.Accident;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentListImpl;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentType;
import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompany;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccidentDao extends Dao{
    private SurveyCompanyDao surveyCompanyDao;
    public AccidentDao(){
        super.connect();
        this.surveyCompanyDao=new SurveyCompanyDao();
    }

    public boolean create(Accident accident) {
        String query = "insert into accident values ('"
                + accident.getAccidentID() + "','"
                + accident.getCustomerID() + "','"
                + accident.getAccidentType().getDetail() + "','"
                + accident.getAccidentDate() + "','"
                + accident.getAccidentLocation() + "','"
                + accident.getAccidentScale().getDetail() + "','"
                + accident.getAccidentContent() + "',"
                + accident.isDoingHarm() + ",'"
                + accident.getRepSurveyCompany().getSurveyCompanyID() + "','"
                + accident.getExemptionInfoID() + "',"
                + accident.isOnsite() + ");";
        return super.create(query);
    }

    public boolean delete(String accidentID){
        String query = "delete from accident where accidentID='"+accidentID+"';";
        return super.delete(query);
    }

    public boolean update(String accidentID, boolean doingHarm, String exemptionInfoID, String accidentScale){
        String query = "update accident set doingHarm="+doingHarm+", "+"exemptionInfo='"+exemptionInfoID+"', "+"accidentScale='"+accidentScale+"' where accidentID='"+accidentID+"';";
        return super.update(query);
    }

    public Accident retrieveById(String accidentId){
        try {
            String query = "select * from accident where accidentId='"+accidentId+"';";
            ResultSet rs = super.retrieve(query);

            if(rs.next()){
                return getFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AccidentListImpl retrieveAll(){
        try {
            String query = "select * from accident;";
            ResultSet rs = super.retrieve(query);
            AccidentListImpl accidentList=new AccidentListImpl();
            while(rs.next()){
                accidentList.add(getFromResultSet(rs));
            }
            return accidentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Accident getFromResultSet(ResultSet rs){
        try{
            Accident accident = new Accident();
            accident.setAccidentID(rs.getString("accidentID"));
            accident.setCustomerID(rs.getString("customerID"));
            accident.setAccidentType(AccidentType.makeAccidentType(rs.getString("accidentType")));
            accident.setAccidentDate(rs.getString("accidentDate"));
            accident.setAccidentLocation(rs.getString("accidentLocation"));
            accident.setAccidentScale(Level.makeLevel(rs.getString("accidentScale")));
            accident.setAccidentContent(rs.getString("accidentContent"));
            accident.setDoingHarm(rs.getBoolean("doingHarm"));
            accident.setRepSurveyCompany(this.surveyCompanyDao.retrieveById(rs.getString("repSurveyCompanyID")));
            accident.setExemptionInfoID(rs.getString("exemptionInfoID"));
            accident.setOnsite(rs.getBoolean("onSite"));
            return accident;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int retrieveMaxID() {
        try {
            String query = "select max(n.num) as ID from (select convert(substring_index(accidentID,'AC',-1),unsigned) as num from accident) n;";
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
