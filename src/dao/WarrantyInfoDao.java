package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.model.contract.ContractType;
import Practice.InsuranceCompany.Design.src.model.insurance.WarrantyInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WarrantyInfoDao extends Dao {
    public WarrantyInfoDao(){ super.connect(); }

    public boolean create(WarrantyInfo warrantyInfo, String insuranceID){
        String query = "insert into warrantyInfo value(";
            query += dq + insuranceID + dq + ", "
                    + dq + warrantyInfo.getContractType().getDetail() + dq + ", "
                    + warrantyInfo.getWarrantyAmount() + ", "
                    + dq + warrantyInfo.getWarrantyConditions() + dq + ", "
                    + dq + warrantyInfo.getWarrantyContent() + dq + ", "
                    + dq + warrantyInfo.getWarrantyInfo() + dq + ");";
            return super.create(query);
    }

    public ArrayList<WarrantyInfo> retrieveAllByInsuranceId(String insuranceID) {
        try {
            ArrayList<WarrantyInfo> warrantyInfos = new ArrayList<>();

            String query = "select * from warrantyInfo where insuranceId = " + dq + insuranceID + dq + ";";
            ResultSet resultSet = super.retrieve(query);
            while (resultSet.next()) { warrantyInfos.add(setWarrantyInfoByResultset(resultSet)); }
            return warrantyInfos;
        } catch (SQLException e){}
        return null;
    }

    private WarrantyInfo setWarrantyInfoByResultset(ResultSet resultSet) {
        try {
            WarrantyInfo warrantyInfo = new WarrantyInfo();
            warrantyInfo.setContractType(ContractType.makeContractType(resultSet.getString("contractType")));
            warrantyInfo.setWarrantyAmount(resultSet.getInt("warrantyAmount"));
            warrantyInfo.setWarrantyConditions(resultSet.getString("warrantyCondition"));
            warrantyInfo.setWarrantyContent(resultSet.getString("warrantyContent"));
            warrantyInfo.setWarrantyInfo(resultSet.getString("warrantyInfo"));

            return warrantyInfo;

        } catch (SQLException e){}
        return null;
    }
}
