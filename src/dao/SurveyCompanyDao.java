package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompany;
import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompanyListImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyCompanyDao extends Dao{
    public SurveyCompanyDao() {
        super.connect();
    };

    public boolean create(SurveyCompany surveyCompany) {
        String query = "insert into surveyCompany values ('"
                + surveyCompany.getSurveyCompanyID() + "','"
                + surveyCompany.getSurveyCompanyName() + "','"
                + surveyCompany.getAddress() + "','"
                + surveyCompany.getPhoneNum() + "',"
                + surveyCompany.isSurveyAbility() + ");";
        return super.create(query);
    }

    public boolean delete(String surveyCompanyID){
        String query = "delete from surveyCompany where surveyID='"+surveyCompanyID+"';";
        return super.delete(query);
    }

    public boolean update(String surveyCompanyID, boolean surveyAbility){
        String query = "update surveyCompany set surveyAbility="+surveyAbility+" where surveyCompanyID='"+surveyCompanyID+"';";
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
