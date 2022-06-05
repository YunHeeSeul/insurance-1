package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CContract;
import Practice.InsuranceCompany.Design.src.controller.CCustomer;
import Practice.InsuranceCompany.Design.src.controller.CPayment;

import Practice.InsuranceCompany.Design.src.model.contract.Contract;
import Practice.InsuranceCompany.Design.src.model.contract.ContractListImpl;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;

import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.model.payment.PaymentForm;
import Practice.InsuranceCompany.Design.src.model.payment.PaymentFormListImpl;
import Practice.InsuranceCompany.Design.src.model.payment.PaymentType;
import java.util.Scanner;

public class VPayment {

    Scanner scn;

    private CContract cContract = new CContract();
    private CPayment cPayment = new CPayment();
    private CCustomer cCustomer = new CCustomer();

    public VPayment(Scanner scn) {
        this.scn = scn;
    }

    public void run(){
        while (true) {
//            VPayment vPayment = new VPayment(scn, customerList, contractList, paymentFormList);
            System.out.println("---------------------지급 관리-----------------------");
            System.out.println("(1). 지급금 접수받기 (2). 지급금 산정하기 (3). 지급 안내서 전송하기 (4) 뒤로 가기");
            int selectPaymentMenu = scn.nextInt();

            switch (selectPaymentMenu) {

                case 1:
                    boolean registerPaymentResult = this.registerPayment();

                    if (registerPaymentResult) System.out.println("제지급금 접수에 성공하였습니다.");
                    else System.out.println("제지급금 접수에 실패하였습니다.");
                    return;

                case 2:
                    Long sendPaymentResult = this.sendPayment();
                    if (sendPaymentResult == -1L) System.out.println("제지급금 산정에 실패하였습니다.");

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
        String paymentFormId ="PM"+(this.cPayment.getMaxID()+1);
        paymentForm.setPaymentFormId(paymentFormId);

        Customer customer;

        System.out.println("=======================고객 정보==============================");
        CustomerListImpl customerList =  cCustomer.retrieveAll();
        customerList.printAllCustomerInfo();
        System.out.println("============================================================");

        System.out.print("고객 고유 번호를 입력하세요: ");
        String customerID = scn.next();
        customer= cCustomer.retrieveById(customerID);

        while(customer == null) {
            System.out.println("없는 고객입니다. 다시 입력해주세요.");
            System.out.println("고객 고유 번호를 입력하세요: ");
            customerID = scn.next();
            customer = cCustomer.retrieveById(customerID);
        }

        System.out.println("\n제지급금 유형을 선택하세요.");
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

        ContractListImpl contractList = cContract.getByCustomerId(customer.getCustomerID());

        if(contractList.getSize() == 0){
            System.out.println(customerID +" 고객은 가입한 보험 목록이 없습니다.");
            return false;
        }
        else{
            contractList.printAllList();

            System.out.println("계약 고유 코드를 입력해주세요");
            String contractId = scn.next();

            if (contractId.isEmpty() || cContract.getContractById(contractId) == null){
                System.out.println("계약 고유 코드를 다시 입력해주세요");
                contractId = scn.next();
            }

            paymentForm.getPayment().setPaymentInfo(scn,paymentForm.getPayment());
            paymentForm.setContractID(contractId);
            paymentForm.setCustomerId(customer.getCustomerID());

            if(cPayment.save(paymentForm)) return true;
            else return false;
        }
    }

    // (2). 지급금 산정하기
    // 제지급금 산정 실패 : -1 반환
    public Long sendPayment() {
        System.out.println("아래 고객 정보를 참고하여 지급금을 지급할 고객을 선택해주세요");
        System.out.println();
        System.out.println("=======================고객 정보==============================");
        CustomerListImpl customerList =  cCustomer.retrieveAll();
        customerList.printAllCustomerInfo();
        System.out.println();
        System.out.println("제지급금 지급 업무를 취소하고 돌아가시려면 고객 고유번호 란에 x를 입력해주세요.");
        System.out.println("=============================================================");
        System.out.print("고객 고유번호 : ");

        String customerID = scn.next();

        while (customerID.isEmpty()){
            customerID = scn.next();
        }

        if (customerID.equals("x")||customerID.equals("X")){
            System.out.println("제지급금 지급 업무를 취소하고 돌아갑니다.");
            System.out.println("y: yes, n: no");
            String decision = scn.next();

            while(!decision.equals("y") && !decision.equals("Y") && !decision.equals("n") && !decision.equals("N")){
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요 (y: yes, n: no)");
                decision = scn.next();
            }

            if(decision.equals("Y")||decision.equals("y") ){
                return -1l;
            }
            else if(decision.equals("N")||decision.equals("n")){
                System.out.print("고객 고유번호 : ");
                customerID = scn.next();

                while (customerID.isEmpty()){
                    customerID = scn.next();
                }
            }
        }

        Customer customer = cCustomer.retrieveById(customerID);

        while (customer == null) {
            System.out.println("해당 고유번호를 가진 고객이 존재하지 않습니다.");
            System.out.println("고객 고유번호를 다시 선택해주세요.");
            System.out.println("=============================================================");
            System.out.print("고객 고유번호 : ");
            customerID = scn.next();
            customer = cCustomer.retrieveById(customerID);
        }

        ContractListImpl contractList = cContract.getByCustomerId(customerID);
        if (contractList.getSize() ==0) {
            System.out.println("고객 고유번호가 " + customerID + "인 고객이 소유하고 있는 보험이 존재하지 않습니다.");
            return -1L;
        }
        else {
            contractList.printAllList();
            System.out.println("------------------------------------------------------------------");

            System.out.print("계약 고유번호를 선택해주세요: ");
            String contractId = scn.next();

            while(contractId.isEmpty()){
                System.out.print("계약 고유번호를 다시 선택해주세요: ");
                contractId = scn.next();
            }

            PaymentFormListImpl paymentFormList = this.cPayment.getByContractIdAndCustomerId(contractId,customerID);

            if (paymentFormList.getSize() == 0) {
                System.out.println("고객 ID가 " + customerID + "인 고객이 계약 ID " + contractId + "에 대해 신청한 지급 신청서가 존재하지 않습니다.");
                return -1L;
            }
            else {

                System.out.println();
                System.out.println("=================================" + customerID +" 고객의 지급 신청서 목록" + "=================================");
                paymentFormList.printAllPaymentForm();
                System.out.println("=========================================================================================");
                System.out.println();

                System.out.println();
                System.out.println("제지급금을 지급할 제지급금 신청서를 선택하세요.");

                System.out.print("제지급금 신청서 고유번호 입력: ");
                String paymentFormId = scn.next();

                while(paymentFormId.isEmpty()){
                    System.out.println("제지급금 신청서 고유번호를 다시 입력하세요.");
                    paymentFormId = scn.next();
                }

                PaymentForm paymentForm = cPayment.getByPaymentFormId(paymentFormId);

                while(paymentForm == null){
                    System.out.println("고유번호가 "+ paymentFormId +"인 제지급금 신청서가 존재하지 않습니다.");
                    System.out.println("제지급금 신청서 고유번호를 다시 입력하세요.");
                    paymentFormId = scn.next();
                    paymentForm = cPayment.getByPaymentFormId(paymentFormId);
                }

                Contract contract = cContract.getContractById(contractId);
                int amount =  paymentForm.getPayment().calculatePayment(contract.getPremium());
                Long result = cPayment.setAmount(amount, paymentForm.getPaymentFormId());
                System.out.println(customerID +" 고객에게 " + result + "원의 제지급금이 산정되었습니다.");

                return result;
            }
        }
    }



    // (3). 지급 안내서 전송하기
    public boolean sendPaymentGuide(){
        System.out.println("아래 고객 정보를 참고하여 지급금 안내서를 전송받을 고객을 선택해주세요");
        System.out.println();
        System.out.println("=======================고객 정보==============================");
        CustomerListImpl customerList =  cCustomer.retrieveAll();
        customerList.printAllCustomerInfo();
        System.out.println();
        System.out.println("제지급금 안내서 전송을 취소하고 돌아가시려면 고객 고유번호 란에 x를 입력해주세요.");
        System.out.println("=============================================================");
        System.out.print("고객 고유번호 : ");

        String customerID = scn.next();

        while (customerID.isEmpty()){
            customerID = scn.next();
        }

        if (customerID.equals("x")||customerID.equals("X")){
            System.out.println("제지급금 안내서 전송 업무를 취소하고 돌아갑니다.");
            System.out.println("y: yes, n: no");
            String decision = scn.next();

            while(!decision.equals("y") && !decision.equals("Y") && !decision.equals("n") && !decision.equals("N")){
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요 (y: yes, n: no)");
                decision = scn.next();
            }

            if(decision.equals("Y")||decision.equals("y") ){
                return false;
            }
            else if(decision.equals("N")||decision.equals("n")){
                System.out.print("고객 고유번호 : ");
                customerID = scn.next();

                while (customerID.isEmpty()){
                    customerID = scn.next();
                }
            }
        }

        Customer customer = cCustomer.retrieveById(customerID);

        PaymentFormListImpl paymentFormList = this.cPayment.getByCustomerId(customerID);

        if (paymentFormList.getSize() == 0) {
            System.out.println("고객 ID가 " + customerID + "인 고객의 제지급금 신청서 목록이 존재하지 않습니다.");
            return false;
        }
        else {

            System.out.println();
            System.out.println("=================================" + customerID +" 고객의 지급 신청서 목록" + "=================================");
            paymentFormList.printAllPaymentForm();
            System.out.println("=========================================================================================");
            System.out.println();

            System.out.println();
            System.out.println("지급 안내서를 발송할 제지급금 신청서를 선택하세요.");

            System.out.print("제지급금 신청서 고유번호 입력: ");
            String paymentFormId = scn.next();

            while(paymentFormId.isEmpty()){
                System.out.println("제지급금 신청서 고유번호를 다시 입력하세요.");
                paymentFormId = scn.next();
            }

            PaymentForm paymentForm = cPayment.getByPaymentFormId(paymentFormId);

            while(paymentForm == null){
                System.out.println("고유번호가 "+ paymentFormId +"인 제지급금 신청서가 존재하지 않습니다.");
                System.out.println("제지급금 신청서 고유번호를 다시 입력하세요.");
                paymentFormId = scn.next();
                paymentForm = cPayment.getByPaymentFormId(paymentFormId);
            }

            if(paymentForm.isExaminationResult()){
                    // 지급 안내서 표출
                    paymentForm.getPayment().sendPaymentGuide(customer, paymentForm);
                    return true;
                }

                return false;
            }
        }
}

