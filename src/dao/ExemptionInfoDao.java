package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.etcEnum.Responsibility;
import Practice.InsuranceCompany.Design.src.model.accident.ExemptionInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemptionInfoDao extends Dao{
    public ExemptionInfoDao() {
        super.connect();
    };

    public boolean create(ExemptionInfo exemptionInfo){
        try {
            PreparedStatement pstmt = null;
        /*  String query = "insert into surveyCompany values (?,?,?,?,?)";

            pstmt = connectPrepareStatement(query);
            pstmt.setString(1, exemptionInfo.getExemptionInfoID());
            pstmt.setObject(2, exemptionInfo.getResponsibility());
            pstmt.setString(3, exemptionInfo.getJudgementReason());
            pstmt.setDouble(4, exemptionInfo.getPaymentRatio());

            super.create(pstmt);
         */
            String query = "insert into exemptionInfo values ('"
                    +exemptionInfo.getExemptionInfoID()+"','"
                    +exemptionInfo.getResponsibility()+"','"
                    +exemptionInfo.getJudgementReason()+"','"
                    +exemptionInfo.getPaymentRatio()+"';";
            return super.create(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String exemptionInfoID){
        String query = "delete from exemptionInfo where exemptionInfoID='"+exemptionInfoID+"';";
        return super.delete(query);
    }

    public boolean update(String exemptionInfoID, Responsibility responsibility, String judgementReason, Double paymentRatio){
        String query = "update exemptionInfo set responsibility='"+responsibility+"', judgementReason='"+judgementReason+"', paymentRatio='"+paymentRatio+"' where exemptionInfoID='"+exemptionInfoID+"';";
        return super.update(query);
    }

    public ExemptionInfo retrieveById(String exemptionInfoID){
        try {
            String query = "select * from exemptionInfo where exemptionInfoID='"+exemptionInfoID+"';";
            ResultSet rs = super.retrieve(query);

            if(rs.next()){
                return getFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ExemptionInfo retrieveAll(){
        try {
            String query = "select * from exemptionInfo;";
            ResultSet rs = super.retrieve(query);
            ExemptionInfo exemptionInfoList=new ExemptionInfo();
            while(rs.next()){
                exemptionInfoList.add(getFromResultSet(rs));
            }
            return exemptionInfoList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ExemptionInfo getFromResultSet(ResultSet rs){
        try{
            ExemptionInfo exemptionInfo = new ExemptionInfo();
            exemptionInfo.setExemptionInfoID(rs.getString("exemptionInfoID"));
            exemptionInfo.setResponsibility((Responsibility) rs.getObject("responsibility"));
            exemptionInfo.setJudgementReason(rs.getString("judgementReason"));
            exemptionInfo.setPaymentRatio(rs.getDouble("paymentRatio"));

            return exemptionInfo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int retrieveMaxID() {
        try {
            String query = "select max(exemptionInfoID) as ID from exemptionInfo;";
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
