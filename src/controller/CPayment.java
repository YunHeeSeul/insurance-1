package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.PaymentDao;
import Practice.InsuranceCompany.Design.src.model.payment.PaymentForm;
import Practice.InsuranceCompany.Design.src.model.payment.PaymentFormListImpl;

public class CPayment {
    private PaymentDao paymentDao;

    public CPayment(){
        this.paymentDao = new PaymentDao();
    }

    public PaymentForm getByContractId(String contractId) {
        return this.paymentDao.retrieveByContractId(contractId);
    }

    public boolean save(PaymentForm paymentForm) {
        return this.paymentDao.save(paymentForm);
    }


    public boolean deletePaymentById(String PaymentFormId) {
        return this.paymentDao.delete(PaymentFormId);
    }

    public Long setAmount(int amount, String paymentFormId) {  return this.paymentDao.setAmount(amount, paymentFormId);}

    public int getMaxID() {
        return this.paymentDao.retrieveMaxID();
    }

    public PaymentFormListImpl getByContractIdAndCustomerId(String contractId, String customerID) {
        return this.paymentDao.retrieveByContractIdAndCustomerId(contractId,customerID);
    }

    public PaymentForm getByPaymentFormId(String paymentFormId) {
        return this.paymentDao.retrieveByPaymentId(paymentFormId);
    }

    public PaymentFormListImpl getByCustomerId(String customerID) {
        return this.paymentDao.getByCustomerId(customerID);
    }
}
