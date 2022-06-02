package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.accident.ExemptionInfo;
import Practice.InsuranceCompany.Design.src.etcEnum.Responsibility;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemptionInfoDao extends Dao{

    public ExemptionInfoDao(){
        super.connect();
    }

    public boolean create(ExemptionInfo exemptionInfo){
        PreparedStatement pstmt = null;
        String query = "insert into exemptionInfo values (?,?,?,?)";
        try {
            pstmt = connectPrepareStatement(query);
            pstmt.setString(1, exemptionInfo.getExemptionInfoID());
            pstmt.setObject(2, exemptionInfo.getResponsibility());
            pstmt.setString(3, exemptionInfo.getJudgementReason());
            pstmt.setDouble(4, exemptionInfo.getPaymentRatio());
            super.create(pstmt);
            return super.create(pstmt);
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
        String query = "update exemptionInfo set responsibility='"+responsibility+"', "+"judgementReason='"+judgementReason+"', "+"paymentRatio='"+paymentRatio+"' where exemptionInfoID='"+exemptionInfoID+"';";
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

    public ExemptionInfo getFromResultSet(ResultSet rs){
        try{
            ExemptionInfo exemptionInfo=new ExemptionInfo();
            exemptionInfo.setExemptionInfoID(rs.getString("exemptionInfoID"));
            exemptionInfo.setResponsibility((Responsibility) rs.getObject("responsibility"));
            exemptionInfo.setJudgementReason(rs.getString("judgementReason"));
            exemptionInfo.setPaymentRatio(rs.getDouble("paymentRatio"));
            return exemptionInfo;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
