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
        String query = "insert into accident values ("
                + dq + accident.getAccidentID() + dq + ", "
                + dq + accident.getCustomerID() + dq + ", "
                + dq + accident.getAccidentType().getDetail() + dq + ", "
                + dq + accident.getAccidentDate() + dq + ", "
                + dq + accident.getAccidentLocation() + dq + ", "
                + null + ", "
                + dq + accident.getAccidentContent() + dq + ", "
                + null + ", "
                + null + ", "
                + null + ", "
                + null + ");";
        return super.create(query);

      /*  String query = "insert into accident values ('"
                + accident.getAccidentID() + "','"
                + accident.getCustomerID() + "','"
                + accident.getAccidentType().getDetail() + "','"
                + accident.getAccidentDate() + "','"
                + accident.getAccidentLocation() + "','"
                + accident.getAccidentScale().getDetail() + "','"
                + accident.getAccidentContent() + ");";
                + accident.isDoingHarm() + ",'"
                + accident.getRepSurveyCompany().getSurveyCompanyID() + "','"
                + accident.getRepSurveyCompanyID() + "','"
                + accident.getExemptionInfoID() + "',"
                + accident.isOnsite() + ");";
        return super.create(query);

       */
    }

    public boolean delete(String accidentID){
        String query = "delete from accident where accidentID='"+accidentID+"';";
        return super.delete(query);
    }

    public boolean update(String accidentID, Accident accident){
        String query = "update accident set ";
        query += "accidentID = " + dq + accident.getAccidentID() + dq + ", "
                + "customerID = " + dq + accident.getCustomerID() + dq + ", "
                + "accidentType = " + dq + accident.getAccidentType() + dq + ", "
                + "accidentDate = " + dq + accident.getAccidentDate() + dq + ", "
                + "accidentLocation = " + dq + accident.getAccidentLocation() + dq + ", "
                + "accidentScale = " + dq + accident.getAccidentScale().getDetail() + dq + ", "
                + "accidentContent = " + dq + accident.getAccidentContent() + dq + ", "
                + "doingHarm = " + accident.isDoingHarm() + ", ";

        if(accident.getRepSurveyCompanyID() == null){
            query += "repSurveyCompanyID = " + null + ", ";
        } else query += "repSurveyCompanyID = " + dq + accident.getRepSurveyCompanyID() + dq + ", " ;

        if(accident.getExemptionInfo() == null){
            query += "exemptionInfoId = " + null + ", ";
        } else query += "exemptionInfoId = " + accident.getExemptionInfo().getExemptionInfoID();

        query += "onSite = " + accident.isOnsite()
                + " where accidentID = " + dq + accidentID + dq;
        return super.update(query);
    }
    public boolean updateSurvey(String accidentID, boolean doingHarm, String accidentScale, String surveyCompanyID){
        String query = "update accident set doingHarm="+doingHarm+", "+"accidentScale='"+accidentScale+"', "+"repSurveyCompanyID='"+surveyCompanyID+"' where accidentID='"+accidentID+"';";
        return super.update(query);
    }
    public boolean updateExemptionInfo(String accidentID, String exemptionInfoID){
        String query = "update accident set exemptionInfoId='"+exemptionInfoID+"' where accidentID='"+accidentID+"';";
        System.out.println(query);
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
            AccidentListImpl accidentList=new AccidentListImpl();
            String query = "select * from accident;";
            ResultSet rs = super.retrieve(query);

            while(rs.next()){
                accidentList.add(getFromResultSet(rs));
            }
            return accidentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AccidentListImpl retrieve(){
        try {
            AccidentListImpl accidentList=new AccidentListImpl();
            //     String query = "select * from accident where accidentID='"+accidentList.getAllList().+"', customerId='"+accident.getCustomerID()+"',accidentType='"+accident.getAccidentType().getDetail()+"',accidentDate='"+accident.getAccidentDate()+"'accidentLocation='"+accident.getAccidentLocation()+"'accidentScale='"+accident.getAccidentScale().getDetail()+"'accidentContent='"+accident.getAccidentContent()+"';";
            String query = "select accidentID,customerId,accidentType, accidentDate, accidentLocation, accidentContent from accident;";
            ResultSet rs = super.retrieve(query);

            while(rs.next()){
                accidentList.add(getAFromResultSet(rs));
            }
            return accidentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Accident getFromResultSet(ResultSet rs){
        try{
            Accident accident = new Accident();
            accident.setAccidentID(rs.getString("accidentID"));
            accident.setCustomerID(rs.getString("customerID"));
            accident.setAccidentType(AccidentType.makeAccidentType(rs.getString("accidentType")));
            accident.setAccidentDate(rs.getString("accidentDate"));
            accident.setAccidentLocation(rs.getString("accidentLocation"));
            if(rs.getString("accidentScale") == null){
                accident.setAccidentScale(null);
            } else accident.setAccidentScale(Level.makeLevel(rs.getString("accidentScale")));
            //   accident.setAccidentScale(Level.makeLevel(rs.getString("accidentScale")));
            accident.setAccidentContent(rs.getString("accidentContent"));
            accident.setDoingHarm(rs.getBoolean("doingHarm"));
            //       accident.setRepSurveyCompany(this.surveyCompanyDao.retrieveById(rs.getString("repSurveyCompanyID")));
            accident.setRepSurveyCompanyID(rs.getString("repSurveyCompanyID"));
            accident.setExemptionInfoID(rs.getString("exemptionInfoID"));
            accident.setOnsite(rs.getBoolean("onSite"));
            return accident;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Accident getAFromResultSet(ResultSet rs){
        try{
            Accident accident = new Accident();
            accident.setAccidentID(rs.getString("accidentID"));
            accident.setCustomerID(rs.getString("customerID"));
            accident.setAccidentType(AccidentType.makeAccidentType(rs.getString("accidentType")));
            accident.setAccidentDate(rs.getString("accidentDate"));
            accident.setAccidentLocation(rs.getString("accidentLocation"));
            accident.setAccidentContent(rs.getString("accidentContent"));
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
