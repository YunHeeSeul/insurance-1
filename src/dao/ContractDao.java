package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.contract.Contract;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractDao extends Dao{

    public ContractDao(){
        super.connect();
    }

    public void create(Contract contract){
        PreparedStatement pstmt = null;
        String query = "insert into contract values (?,?,?,?,?,?,?,?)";
        try {
            pstmt = connectPrepareStatement(query);
            pstmt.setString(1, contract.getContractID());
            pstmt.setString(2, contract.getCustomerID());
            pstmt.setString(3, contract.getInsuranceID());
            pstmt.setString(4, contract.getJoinDate());
            pstmt.setInt(5, contract.getContractPeriod());
            pstmt.setInt(6, contract.getPremium());
            pstmt.setString(7, contract.getActivityDate());
            pstmt.setString(8, contract.getInsuranceAgentID());
            super.create(pstmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String contractId){
        String query = "delete from contract where contractID="+contractId;
        super.delete(query);
    }

    public void update(String contractId, String activityDate){
        String query = "update contract set activityDate="+activityDate+" where contractID="+contractId;
        super.update(query);
    }

    public Contract retrieveById(String contractId){
        try {
            String query = "select * from where contractID="+contractId;
            ResultSet rs = super.retrieve(query);
            Contract contract=new Contract();
            if(rs.next()){
                contract.setContractID(rs.getString("contractID"));
                contract.setCustomerID(rs.getString("customerID"));
                contract.setInsuranceID(rs.getString("insuranceID"));
                contract.setJoinDate(rs.getString("joinDate"));
                contract.setContractPeriod(rs.getInt("contractPeriod"));
                contract.setPremium(rs.getInt("premium"));
                contract.setActivityDate(rs.getString("activityDate"));
                contract.setInsuranceAgentID(rs.getString("insuranceAgentID"));
            }
            return contract;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
