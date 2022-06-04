package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CContract;
import Practice.InsuranceCompany.Design.src.controller.CPayment;

import Practice.InsuranceCompany.Design.src.model.contract.Contract;
import Practice.InsuranceCompany.Design.src.model.contract.ContractListImpl;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;

import Practice.InsuranceCompany.Design.src.model.payment.PaymentForm;
import Practice.InsuranceCompany.Design.src.model.payment.PaymentType;

import java.util.Optional;
import java.util.Scanner;

public class VPayment {

    Scanner scn;

    private CContract cContract;

    CPayment cPayment;

    private CCustomer cCustomer;

    public VPayment(Scanner scn) {
        this.scn = scn;
    }

    public void run(){
        while (true) {
//            VPayment vPayment = new VPayment(scn, customerList, contractList, paymentFormList);
            System.out.println("---------------------지급 관리-----------------------");
            System.out.println("(1). 지급금 접수받기 (2). 지급금 지급하기 (3). 지급 안내서 전송하기 (4) 뒤로 가기");
            int selectPaymentMenu = scn.nextInt();

            switch (selectPaymentMenu) {

                case 1:
                    boolean registerPaymentResult = this.registerPayment();

                    if (registerPaymentResult) System.out.println("제지급금 접수에 성공하였습니다.");
                    else System.out.println("제지급금 접수에 실패하였습니다.");
                    return;

                case 2:
                    Long sendPaymentResult = this.sendPayment();

                    if (sendPaymentResult == -1L) System.out.println("제지급금 지급에 실패하였습니다.");
                    else System.out.println(sendPaymentResult + "원의 제지급금이 지급되었습니다.");
                    return;

                case 3:
                    boolean sendPaymentGuideResult = this.sendPaymentGuide();
                    if (sendPaymentGuideResult) System.out.println("지급 안내서가 전송 되었습니다.");
                    else System.out.println("지급 안내서 전송에 실패하였습니다.");
                    return;

                case 4:
                    return;

                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                    return;
            }
        } // 제지급금 끝
    }


    // (1). 지급금 접수받기
    public boolean registerPayment(){
        PaymentForm paymentForm = new PaymentForm();

        Customer customer;

        System.out.print("고객 ID : ");
        String customerID = scn.next();
        customer= cCustomer.getByCustomerId(customerID);


        while(customer == null) {
            System.out.println("없는 고객입니다. 다시 입력해주세요.");
            customerID = scn.next();
            customer = cCustomer.getByCustomerId(customerID);
        }

        System.out.println("제지급금 유형을 선택하세요.");
        System.out.println("(1)보험금 (2)만기보험금 (3)해약환급금");

        int paymentType = scn.nextInt();

        while (paymentType != 1 && paymentType != 2 && paymentType != 3){
            System.out.println("잘못 입력하셨습니다. 제지급금 유형을 다시 선택하세요.");
            paymentType = scn.nextInt();
        }

        switch (paymentType){
                case 1:
                    // 보험금
                    paymentForm.setPaymentType(PaymentType.payout);
                    break;

                case 2:
                    // 만기보험금
                    paymentForm.setPaymentType(PaymentType.maturity);
                    break;

                case 3:
                    // 해약환급금
                    paymentForm.setPaymentType(PaymentType.cancellation);
                    break;

                default:
                    break;
        }


        paymentForm.setCustomerId(customer.getCustomerID());

        paymentForm.setPayment(paymentForm.getPaymentType().getPayment());
        paymentForm.getPayment().setPaymentInfo(scn);

        ContractListImpl contractList = cContract.getContractByCustomerId(customer.getCustomerID());
        contractList.printAllList();

        System.out.println("계약 고유 코드를 입력해주세요");
        String contractId = scn.nextLine();

        if (contractId.isEmpty() || cContract.getContractById(contractId) == null){
            System.out.println("계약 고유 코드를 다시 입력해주세요");
            contractId = scn.nextLine();
        }

        paymentForm.setContractID(contractId);

        if(cPayment.save(paymentForm)) return true;
        else return false;
    }

    // (2). 지급금 지급하기
    // 제지급금 지급 실패 : -1 반환
    public Long sendPayment() {
        System.out.print("지급금을 지급할 고객을 선택해주세요");
        System.out.print("=============================================================");
        System.out.print("고객 ID : ");
        String customerID = scn.next();

        Customer customer = cCustomer.getByCustomerId(customerID);

        while (customer == null) {
            System.out.print("해당 고객 ID를 가진 고객이 존재하지 않습니다.");
            System.out.print("고객 ID를 다시 선택해주세요.");
            System.out.print("=============================================================");
            System.out.print("고객 ID : ");
            customerID = scn.next();
            customer = cCustomer.getByCustomerId(customerID);
        }

        Contract contract = cContract.getContractById(customerID);
        if (contract == null) {
            System.out.println("고객 ID가 " + customerID + "인 고객이 소유하고 있는 보험이 존재하지 않습니다.");
            return -1L;
        }

        else {
            String contractId = contract.getContractID();
            PaymentForm paymentForm = this.cPayment.getContractById(contractId);

            if (paymentForm == null) {
                System.out.println("고객 ID가 " + customerID + "인 고객이 계약 ID" + contractId + "에 대해 신청한 지급 신청서가 존재하지 않습니다.");
                return -1L;
            }
            else {
                int amount =  paymentForm.getPaymentType().getPayment().calculatePayment();
                Long result = cPayment.setAmount(amount, paymentForm.getPaymentFormId());

                return result;
            }
        }
    }

    // (3). 지급 안내서 전송하기
    public boolean sendPaymentGuide(){

        System.out.print("지급 안내서를 보낼 고객을 선택해주세요");
        System.out.print("=============================================================");
        System.out.print("고객 ID : ");
        String customerID = scn.next();
        Customer customer= cCustomer.getByCustomerId(customerID);

        while(customer == null){
            System.out.print("해당 고객 ID를 가진 고객이 존재하지 않습니다.");
            System.out.print("고객 ID를 다시 선택해주세요.");
            System.out.print("=============================================================");
            System.out.print("고객 ID : ");
            customerID = scn.next();
            customer= cCustomer.getByCustomerId(customerID);
        }


        // 지급 안내서를 표출한다.
        Contract contract = cContract.getContractById(customerID);
        if(contract == null){
            System.out.println("고객 ID가 " + customerID + "인 고객이 소유하고 있는 보험이 존재하지 않습니다.");
            return false;
        }
        else{
            String contractId = contract.getContractID();
            PaymentForm paymentForm = cPayment.getContractById(contractId);

            if(paymentForm == null){
                System.out.println("고객 ID가 " + customerID + "인 고객이 계약 ID" + contractId + "에 대해 신청한 지급 신청서가 존재하지 않습니다.");
                return false;
            }
            else{

                if(paymentForm.isExaminationResult()){
                    // 지급 안내서 표출
                    paymentForm.getPaymentType().getPayment().sendPaymentGuide(customer);
                    return true;
                }

                return false;
            }
        }
    }
}
