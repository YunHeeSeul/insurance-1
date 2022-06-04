package Practice.InsuranceCompany.Design.src.dao;
import Practice.InsuranceCompany.Design.src.model.contract.Contract;
import Practice.InsuranceCompany.Design.src.model.contract.ContractListImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
public class ContractDao extends Dao{

    public ContractDao(){
        super.connect();
    }

    public boolean create(Contract contract){
        try {
//            PreparedStatement pstmt = null;
//            String query = "insert into contract values (?,?,?,?,?,?,?,?)";
//            pstmt = connectPrepareStatement(query);
//            pstmt.setString(1, contract.getContractID());
//            pstmt.setString(2, contract.getCustomerID());
//            pstmt.setString(3, contract.getInsuranceID());
//            pstmt.setString(4, contract.getJoinDate());
//            pstmt.setInt(5, contract.getContractPeriod());
//            pstmt.setInt(6, contract.getPremium());
//            pstmt.setString(7, contract.getActivityDate());
//            pstmt.setString(8, contract.getInsuranceAgentID());
            String query = "insert into contract values ('"
                    +contract.getContractID()+"','"
                    +contract.getCustomerID()+"','"
                    +contract.getInsuranceID()+"','"
                    +contract.getJoinDate()+"',"
                    +contract.getContractPeriod()+","
                    +contract.getPremium()+",'"
                    +contract.getActivityDate()+"','"
                    +contract.getInsuranceAgentID()+"';";
            return super.create(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String contractId){
        String query = "delete from contract where contractID='"+contractId+"';";
        return super.delete(query);
    }

    public boolean update(String contractId, String activityDate){
        String query = "update contract set activityDate='"+activityDate+"' where contractID='"+contractId+"';";
        return super.update(query);
    }

    public Contract retrieveById(String contractId){
        try {
            String query = "select * from contract where contractID='"+contractId+"';";
            ResultSet rs = super.retrieve(query);
            if(rs.next()){
                return getFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ContractListImpl retrieveAll(){
        try {
            String query = "select * from contract;";
            ResultSet rs = super.retrieve(query);
            ContractListImpl contractList=new ContractListImpl();
            while(rs.next()){
                contractList.add(getFromResultSet(rs));
            }
            return contractList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Contract getFromResultSet(ResultSet rs){
        try {
            Contract contract=new Contract();
            contract.setContractID(rs.getString("contractID"));
            contract.setCustomerID(rs.getString("customerID"));
            contract.setInsuranceID(rs.getString("insuranceID"));
            contract.setJoinDate(rs.getString("joinDate"));
            contract.setContractPeriod(rs.getInt("contractPeriod"));
            contract.setPremium(rs.getInt("premium"));
            contract.setActivityDate(rs.getString("activityDate"));
            contract.setInsuranceAgentID(rs.getString("insuranceAgentID"));
            return contract;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ContractListImpl retrieveMaintenanceTargetList() {
        try {
            String query = "select * from contract where datediff(date_add(joindate, interval contractPeriod*12 Month), now()) between 0 and 31;";
            ResultSet rs = super.retrieve(query);
            ContractListImpl contractList=new ContractListImpl();
            while(rs.next()){
                contractList.add(getFromResultSet(rs));
            }
            return contractList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ContractListImpl retrieveValidByCustomerId(String cusID) {
        try {
            String query = "select * from contract where customerID = '"+cusID+"' and date_add(joindate, interval contractPeriod*12 Month)>now();";
            ResultSet rs = super.retrieve(query);
            ContractListImpl contractList=new ContractListImpl();
            while(rs.next()){
                contractList.add(getFromResultSet(rs));
            }
            return contractList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int retrieveMaxID() {
        try {
            String query = "select max(contractID) as ID from contract;";
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

    public ContractListImpl retrieveByCustomerId(String customerID) {
        try {
            ContractListImpl contractList = new ContractListImpl;

            String query = "select * from contract where customerId='"+customerID+"';";
            ResultSet rs = super.retrieve(query);

            while(rs.next()){
                Contract contract = getFromResultSet(rs);
                contractList.add(contract);
            }

            return contractList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
