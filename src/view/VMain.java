package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.contract.ContractList;
import Practice.InsuranceCompany.Design.src.contract.ContractListImpl;
import Practice.InsuranceCompany.Design.src.customer.CustomerList;
import Practice.InsuranceCompany.Design.src.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.payment.PaymentFormList;
import Practice.InsuranceCompany.Design.src.payment.PaymentFormListImpl;
import Practice.InsuranceCompany.Design.src.subscription.SubscriptionListImpl;

import java.util.Scanner;

public class VMain {
    CustomerList customerList = new CustomerListImpl();
    ContractList contractList = new ContractListImpl();

    PaymentFormList paymentFormList = new PaymentFormListImpl();

    private VInsurance vInsurance;
    private VContract vContract;
    private VUnderwriting vUnderwriting;
    private VPayment vPayment;
    private VAccident vAccident;
    private VCollectionMoney vCollectionMoney;



    public void run(){
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------보험 시스템-----------------------------");
            System.out.println("1. 상품 관리 2. 계약 관리 3. Underwriting 4. 지급 관리 5. 사고처리 관리 6. 수금 관리 0. 종료");


            String input = scn.next();
            System.out.println(input + " 선택");

            if (input.equals("1")) {
                this.vInsurance = new VInsurance();
                this.vInsurance.run();  //
//                while(true){
//                    System.out.println("----------------------상품 관리-----------------------");
//                    System.out.println("(1). 상품 조회 (2). 상품 등록 (3). 상품 수정 (4). 상품 삭제");
//                    String input1 = scn.next();
//
////                    System.out.println(input1 + " 선택");
//                }
            } else if (input.equals("2")) {
                    this.vContract = new VContract(scn, contractList, ); //
                    this.vContract.run();

            } else if (input.equals("3")) {
                    this.vUnderwriting = new VUnderwriting();
                    this.vUnderwriting.run();

            } else if (input.equals("4")) {
                this.vPayment = new VPayment(scn, customerList, contractList, paymentFormList);
                this.vPayment.run();

            } else if (input.equals("5")) {
                this.vAccident = new VAccident();   //
                this.vAccident.run();   //

            } else if (input.equals("0")) {
                return;
            } else
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

        }
    }

    public static boolean makeError(){
        int result=(int)(Math.random()*10);
        return result > 0.2;
    }
}
