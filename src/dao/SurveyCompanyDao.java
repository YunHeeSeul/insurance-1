package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.etcEnum.Level;
import Practice.InsuranceCompany.Design.src.model.accident.Accident;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentListImpl;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentType;
import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompany;
import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompanyListImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyCompanyDao extends Dao{
    public SurveyCompanyDao() {
        super.connect();
    };

    public boolean create(SurveyCompany surveyCompany){
        try {
            PreparedStatement pstmt = null;
         /*   String query = "insert into surveyCompany values (?,?,?,?,?)";

            pstmt = connectPrepareStatement(query);
            pstmt.setString(1, surveyCompany.getSurveyCompanyID());
            pstmt.setString(2, surveyCompany.getSurveyCompanyName());
            pstmt.setString(3, surveyCompany.getAddress());
            pstmt.setString(4, surveyCompany.getPhoneNum());
            pstmt.setBoolean(5, surveyCompany.isSurveyAbility());
            super.create(pstmt);
*/
            String query = "insert into surveyCompany values ('"
                    +surveyCompany.getSurveyCompanyID()+"','"
                    +surveyCompany.getSurveyCompanyName()+"','"
                    +surveyCompany.getAddress()+"','"
                    +surveyCompany.getPhoneNum()+"',"
                    +surveyCompany.isSurveyAbility()+"';";
            return super.create(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String surveyCompanyID){
        String query = "delete from surveyCompany where surveyID='"+surveyCompanyID+"';";
        return super.delete(query);
    }

    public boolean update(String surveyCompanyID, boolean surveyAbility){
        String query = "update surveyCompany set surveyAbility='"+surveyAbility+"' where surveyCompanyID='"+surveyCompanyID+"';";
        return super.update(query);
    }

    public SurveyCompany retrieveById(String surveyCompanyID){
        try {
            String query = "select * from surveyCompany where surveyCompanyID='"+surveyCompanyID+"';";
            ResultSet rs = super.retrieve(query);

            if(rs.next()){
                return getFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public SurveyCompanyListImpl retrieveAll(){
        try {
            String query = "select * from surveyCompany;";
            ResultSet rs = super.retrieve(query);
            SurveyCompanyListImpl surveyCompanyList=new SurveyCompanyListImpl();
            while(rs.next()){
                surveyCompanyList.add(getFromResultSet(rs));
            }
            return surveyCompanyList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public SurveyCompany getFromResultSet(ResultSet rs){
        try{
            SurveyCompany surveyCompany = new SurveyCompany();
            surveyCompany.setSurveyCompanyID(rs.getString("surveyCompanyID"));
            surveyCompany.setSurveyCompanyName(rs.getString("surveyCompanyName"));
            surveyCompany.setAddress(rs.getString("address"));
            surveyCompany.setPhoneNum(rs.getString("phoneNum"));
            surveyCompany.setSurveyAbility(rs.getBoolean("surveyAbility"));

            return surveyCompany;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int retrieveMaxID() {
        try {
            String query = "select max(surveyCompanyID) as ID from surveyCompany;";
            ResultSet rs = super.retrieve(query);
            if(rs.next()) {
                String id=rs.getString("ID");
                return Integer.parseInt(id.substring(2));
            }
            else return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
