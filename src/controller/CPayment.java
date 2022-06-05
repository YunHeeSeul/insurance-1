package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.PaymentDao;
import Practice.InsuranceCompany.Design.src.model.payment.PaymentForm;

public class CPayment {
    private PaymentDao paymentDao;

    public CPayment(){
        this.paymentDao = new PaymentDao();
    }

    public PaymentForm getContractById(String contractId) {
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
}
