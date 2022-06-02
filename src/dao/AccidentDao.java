package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.accident.Accident;
import Practice.InsuranceCompany.Design.src.accident.AccidentListImpl;
import Practice.InsuranceCompany.Design.src.accident.AccidentType;
import Practice.InsuranceCompany.Design.src.etcEnum.Level;
import Practice.InsuranceCompany.Design.src.survey.SurveyCompany;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccidentDao extends Dao{
    public AccidentDao(){
        super.connect();
    }

    public boolean create(Accident accident){
        try {
            PreparedStatement pstmt = null;
            String query = "insert into accident values (?,?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = connectPrepareStatement(query);
            pstmt.setString(1, accident.getAccidentID());
            pstmt.setString(2, accident.getCustomerID());
            pstmt.setObject(3, accident.getAccidentType());
            pstmt.setString(4, accident.getAccidentDate());
            pstmt.setString(5, accident.getAccidentLocation());
            pstmt.setObject(6, accident.getAccidentScale());
            pstmt.setString(7, accident.getAccidentContent());
            pstmt.setBoolean(8, accident.isDoingHarm());
            pstmt.setObject(9, accident.getRepSurveyCompany());
            pstmt.setObject(10, accident.getExemptionInfoID());
            pstmt.setBoolean(11, accident.isOnsite());
            super.create(pstmt);
            return super.create(pstmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String accidentID){
        String query = "delete from accident where accidentID='"+accidentID+"';";
        return super.delete(query);
    }

    public boolean update(String accidentID, String doingHarm, String exemptionInfo, String accidentScale){
        String query = "update accident set doingHarm='"+doingHarm+"', "+"exemptionInfo='"+exemptionInfo+"', "+"accidentScale='"+accidentScale+"' where accidentID='"+accidentID+"';";
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
            accident.setAccidentType((AccidentType) rs.getObject("accidentType"));
            accident.setAccidentDate(rs.getString("accidentDate"));
            accident.setAccidentLocation(rs.getString("accidentLocation"));
            accident.setAccidentScale((Level) rs.getObject("accidentScale"));
            accident.setAccidentContent(rs.getString("accidentContent"));
            accident.setDoingHarm(rs.getBoolean("doingHarm"));
            accident.setRepSurveyCompany((SurveyCompany) rs.getObject("repSurveyCompany"));
            accident.setExemptionInfoID(rs.getString("exemptionInfo"));
            accident.setOnsite(rs.getBoolean("onSite"));
            return accident;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
