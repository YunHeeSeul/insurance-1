package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.survey.SurveyCompany;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyCompanyDao extends Dao{
    public SurveyCompanyDao(){
        super.connect();
    }

    public boolean create(SurveyCompany surveyCompany){
        PreparedStatement pstmt = null;
        String query = "insert into contract values (?,?,?,?,?)";
        try {
            pstmt = connectPrepareStatement(query);
            pstmt.setString(1, surveyCompany.getSurveyCompanyID());
            pstmt.setString(2, surveyCompany.getSurveyCompanyName());
            pstmt.setString(3, surveyCompany.getAddress());
            pstmt.setString(4, surveyCompany.getPhoneNum());
            pstmt.setBoolean(5, surveyCompany.isSurveyAbility());
            super.create(pstmt);
            return super.create(pstmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String surveyCompanyID){
        String query = "delete from surveyCompany where surveyCompanyID='"+surveyCompanyID+"';";
        super.delete(query);
        return super.delete(query);
    }

    public boolean update(String surveyCompanyID, Boolean surveyAbility){
        String query = "update surveyCompany set surveyAbility='"+surveyAbility+"' where surveyCompanyID='"+surveyCompanyID+"';";
        super.update(query);
        return super.update(query);
    }

    public SurveyCompany retrieveById(String surveyCompanyID){
        try {
            String query = "select * from surveyCompany where surveyCompanyID='"+surveyCompanyID+"';";
            ResultSet rs = super.retrieve(query);
            SurveyCompany surveyCompany=new SurveyCompany();
            if(rs.next()){
                return getFromResultSet(rs);
            }
            return null;
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
}
