package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.contract.Contract;
import Practice.InsuranceCompany.Design.src.contract.ContractList;
import Practice.InsuranceCompany.Design.src.customer.Customer;
import Practice.InsuranceCompany.Design.src.customer.CustomerList;
import Practice.InsuranceCompany.Design.src.payment.PaymentForm;
import Practice.InsuranceCompany.Design.src.payment.PaymentType;

import java.util.Optional;
import java.util.Scanner;

public class VPayment {

    Scanner scn;
    CustomerList customerList;

    ContractList contractList;

    public VPayment(Scanner scn, CustomerList customerList, ContractList contractList) {
        this.scn = scn;
        this.customerList = customerList;
        this.contractList = contractList;
    }

    public boolean registerPayment(){
        PaymentForm paymentForm = new PaymentForm();

        Optional<Customer> customer;
        Customer existingCustomer;

        System.out.print("고객 ID : ");
        String customerID = scn.next();
        customer= customerList.getByCustomerId(customerID);

        // 입력받은 customerID를 가진 customer 가 있는 경우
        if(customer.isPresent()){
            existingCustomer = customer.get();
        }

        // 입력받은 customerID를 가진 customer 가 없는 경우
        else{

            System.out.println("없는 고객입니다. 다시 입력해주세요.");

            while(customer.isPresent()){
                customerID = scn.next();
                customer= customerList.getByCustomerId(customerID);
            }
        }

        System.out.println("제지급금 유형을 선택하세요.");
        System.out.println("(1)보험금 (2)만기보험금 (3)해약환급금");

        int paymentType = scn.nextInt();

        while (paymentType != 1 && paymentType != 2 && paymentType != 3){
            paymentType = scn.nextInt();
        }

        switch (paymentType){
                case 1:
                    paymentForm.setPaymentType(PaymentType.payout);
                    break;

                case 2:
                    paymentForm.setPaymentType(PaymentType.maturity);
                    break;

                case 3:
                    paymentForm.setPaymentType(PaymentType.cancellation);
                    break;

                default:
                    break;
        }


        paymentForm.setPayment(paymentForm.getPaymentType().getPayment());
        paymentForm.getPayment().setPaymentInfo();

        return paymentForm.getPayment() == null? false : true;
    }

    // 제지급금 지급 실패 : -1 반환
    public int sendPayment(){
        return 0;
    }

    public boolean sendPaymentGuide(){
        return true;
    }
}
