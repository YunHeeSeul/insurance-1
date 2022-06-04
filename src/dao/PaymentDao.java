package Practice.InsuranceCompany.Design.src.dao;

import Practice.InsuranceCompany.Design.src.etcEnum.ClaimType;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentType;
import Practice.InsuranceCompany.Design.src.model.payment.PaymentForm;
import Practice.InsuranceCompany.Design.src.model.payment.PaymentType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDao extends Dao{
    public PaymentDao(){
        super.connect();
    }

    public boolean save(PaymentForm paymentForm){
        PreparedStatement pstmt;
        String query = "insert into payment values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = connectPrepareStatement(query);
            pstmt.setString(1, paymentForm.getPaymentFormId());
            pstmt.setLong(2, paymentForm.getPayment().getAmount());
            pstmt.setString(3, paymentForm.getCustomerId());
            pstmt.setString(4, paymentForm.getPayment().getAccidentCircumstance());
            pstmt.setString(5, paymentForm.getPayment().getAccidentDateTime());
            pstmt.setString(6, paymentForm.getPayment().getAccidentPlace());
            pstmt.setString(7, paymentForm.getPayment().getAccidentType().getDetail());
            pstmt.setString(8, paymentForm.getPayment().getClaimReason().getDetail());
            pstmt.setString(9, paymentForm.getPayment().getDiseaseName());
            pstmt.setString(10, paymentForm.getPayment().getCancellationReason());
            pstmt.setString(11, paymentForm.getPayment().getDateOfExpiry());
            pstmt.setString(12, paymentForm.getContractID());
            pstmt.setString(12, paymentForm.getPaymentType().getDetail());
            pstmt.setBoolean(13, paymentForm.isExaminationResult());
            
            super.create(pstmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String paymentFormId) {
        String query = "delete from payment where paymentId='" + paymentFormId+"';";
        return super.delete(query);
    }

    private PaymentForm getFromResultSet(ResultSet rs){
        try {
            PaymentForm paymentForm=new PaymentForm();

            paymentForm.setPaymentFormID(rs.getString("paymentId"));
            paymentForm.setCustomerId(rs.getString("customerId"));
            paymentForm.setContractID(rs.getString("contractId"));
            paymentForm.setExaminationResult(rs.getBoolean("examinationResult"));

            // 보험금
            if (rs.getString("paymentType").equals(PaymentType.payout.getDetail())) {
                paymentForm.getPayment().setAccidentDateTime(rs.getString("accidentDateTime"));
                paymentForm.getPayment().setAccidentType(AccidentType.makeAccidentType(rs.getString("accidentType")));
                paymentForm.getPayment().setAccidentPlace(rs.getString("accidentPlace"));
                paymentForm.getPayment().setAccidentCircumstance(rs.getString("accidentCircumstance"));
                paymentForm.getPayment().setClaimReason(ClaimType.makeClaimType(rs.getString("claimReason")));
                paymentForm.getPayment().setDiseaseName(rs.getString("diseaseName"));
            }
            
            // 해약환급금
            else if (rs.getString("paymentType").equals(PaymentType.payout.getDetail())) {
                paymentForm.getPayment().setCancellationReason(rs.getString("cancellationReason"));
            }
            
            // 만기보험금
            else if (rs.getString("paymentType").equals(PaymentType.payout.getDetail())) {
                paymentForm.getPayment().setDateOfExpiry(rs.getString("dateOfExpiry"));
            }
            
            else{
                System.out.println("DB 오류");
                return null;
            }
            return paymentForm;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PaymentForm retrieveByContractId(String contractId) {
        try {
            String query = "select * from payment where contractID='"+contractId+"';";
            ResultSet rs = super.retrieve(query);
            if(rs.next()){
                return getFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PaymentForm retrieveByPaymentId(String paymentFormId) {
        try {
            String query = "select * from payment where paymentId='"+paymentFormId+"';";
            ResultSet rs = super.retrieve(query);
            if(rs.next()){
                return getFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Long setAmount(int amount, String paymentFormId) {
        String query = "update payment set amount='"+amount+"', examinationResult = true where paymentId='"+paymentFormId+"';";
        if(super.update(query)){
            return retrieveByPaymentId(paymentFormId).getPayment().getAmount();
        }

        return -1L;
    }
}
