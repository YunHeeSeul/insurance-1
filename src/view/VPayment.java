package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.contract.Contract;
import Practice.InsuranceCompany.Design.src.customer.Customer;
import Practice.InsuranceCompany.Design.src.payment.PaymentForm;
import Practice.InsuranceCompany.Design.src.payment.PaymentType;

public class VPayment {
    public void signUp(){
        PaymentForm paymentForm = new PaymentForm();
        System.out.println("고객 ID : ");
        String customerID = scn.next();
        Customer customer = customerList.getByCustomerId(customerID);
        if(customer==null) {
            System.out.println("없는 고객입니다. 다시 입력해주세요."); continue;
        } else {
            Contract contract = contractList.getByCustomerId(customerID);
            paymentForm.setContractID(contract.getContractID());
        }
        System.out.println("(1)보험금 (2)만기보험금 (3)해약환급금");
        System.out.println("제지급금 유형 : ");
        String paymentType=scn.next();
        if(paymentType.equals("1"))
            paymentForm.setPaymentType(PaymentType.payout);
        else if(paymentType.equals("2"))
            paymentForm.setPaymentType(PaymentType.maturity);
        else if(paymentType.equals("3"))
            paymentForm.setPaymentType(PaymentType.cancellation);
        else {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); continue;
        }
        paymentForm.setPayment(paymentForm.getPaymentType().getPayment());
        paymentForm.getPayment().setPaymentInfo();
    }

    public int sendMoney(){

    }

    public boolean simsa(){

    }
}
