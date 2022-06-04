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
        String query = "insert into payment values ('"
                +paymentForm.getPaymentFormId()+"',"
                +paymentForm.getCustomerId()+"','"
                +paymentForm.getContractID()+"',"
                +paymentForm.getPayment().getAmount()+",'"
                +paymentForm.getPayment().getAccidentCircumstance()+"','"
                +paymentForm.getPayment().getAccidentDateTime()+"','"
                +paymentForm.getPayment().getAccidentPlace()+"','"
                +paymentForm.getPayment().getAccidentType().getDetail()+"','"
                +paymentForm.getPayment().getClaimReason().getDetail()+"','"
                +paymentForm.getPayment().getDiseaseName()+"','"
                +paymentForm.getPayment().getCancellationReason()+"','"
                +paymentForm.getPayment().getDateOfExpiry()+"','"
                +paymentForm.getPaymentType().getDetail()+"',"
                +paymentForm.isExaminationResult()+");";
        return super.create(query);
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
            paymentForm.setPaymentType(PaymentType.makePaymentType(rs.getString("paymentType")));

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
