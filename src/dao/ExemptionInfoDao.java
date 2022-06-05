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

    public boolean create(ExemptionInfo exemptionInfo) {
        String query = "insert into exemptionInfo values ('"
                + exemptionInfo.getExemptionInfoID() + "','"
                + exemptionInfo.getResponsibility().getDetail() + "','"
                + exemptionInfo.getJudgementReason() + "',"
                + exemptionInfo.getPaymentRatio() + ");";
        return super.create(query);
    }

    public boolean delete(String exemptionInfoID){
        String query = "delete from exemptionInfo where exemptionInfoID='"+exemptionInfoID+"';";
        return super.delete(query);
    }

    public boolean update(String exemptionInfoID, Responsibility responsibility, String judgementReason, Double paymentRatio){
        String query = "update exemptionInfo set responsibility='"+responsibility.getDetail()+"', judgementReason='"+judgementReason+"', paymentRatio="+paymentRatio+" where exemptionInfoID='"+exemptionInfoID+"';";
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
            exemptionInfo.setResponsibility(Responsibility.makeResponsibility(rs.getString("responsibility")));
            exemptionInfo.setJudgementReason(rs.getString("judgementReason"));
            exemptionInfo.setPaymentRatio(rs.getDouble("paymentRatio"));

            return exemptionInfo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int retrieveMaxID() {
        try {
            String query = "select max(n.num) as ID from (select convert(substring_index(exemptionInfoID,'EX',-1),unsigned) as num from exemptionInfo) n;";
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
