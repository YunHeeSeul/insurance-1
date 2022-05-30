package Practice.InsuranceCompany.Design.src.main;



import Practice.InsuranceCompany.Design.src.contract.ContractList;
import Practice.InsuranceCompany.Design.src.contract.ContractListImpl;
import Practice.InsuranceCompany.Design.src.customer.CustomerList;
import Practice.InsuranceCompany.Design.src.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.payment.PaymentFormList;
import Practice.InsuranceCompany.Design.src.payment.PaymentFormListImpl;
import Practice.InsuranceCompany.Design.src.view.VPayment;

import java.util.Scanner;

public class Main {
    static Scanner scn;
    static CustomerList customerList = new CustomerListImpl();
    static ContractList contractList = new ContractListImpl();

    static PaymentFormList paymentFormList = new PaymentFormListImpl();

    public static void main(String[] args) {

        scn = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------보험 시스템-----------------------------");
            System.out.println("1. 상품 관리 2. 계약 관리 3. 지급 관리 4. 사고처리 관리 5. 수금 관리 0. 종료");

            String input = scn.next();
            System.out.println(input + " 선택");

            if (input.equals("1")) {
                while(true){
                    System.out.println("----------------------상품 관리-----------------------");
                    System.out.println("(1). 상품 조회 (2). 상품 등록 (3). 상품 수정 (4). 상품 삭제");
                    String input1 = scn.next();

//                    System.out.println(input1 + " 선택");
                }
            } else if (input.equals("2")) {

            } else if (input.equals("3")) {
                while (true) {
                    VPayment vPayment = new VPayment(scn, customerList, contractList, paymentFormList);
                    System.out.println("---------------------지급 관리-----------------------");
                    System.out.println("(1). 지급금 접수받기 (2). 지급금 지급하기 (3). 지급 안내서 전송하기 (4) 뒤로 가기");
                    int selectPaymentMenu = scn.nextInt();

                    switch (selectPaymentMenu) {

                        case 1:
                            boolean registerPaymentResult = vPayment.registerPayment();

                            if (registerPaymentResult) System.out.println("제지급금 접수에 성공하였습니다.");
                            else System.out.println("제지급금 접수에 실패하였습니다.");
                            return;

                        case 2:
                            int sendPaymentResult = vPayment.sendPayment();

                            if (sendPaymentResult == -1) System.out.println("제지급금 지급에 실패하였습니다.");
                            else System.out.println(sendPaymentResult + "원의 제지급금이 지급되었습니다.");
                            return;

                        case 3:
                            boolean sendPaymentGuideResult = vPayment.sendPaymentGuide();
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
            } else if (input.equals("4")) {

            } else if (input.equals("5")) {
                return;
            } else if (input.equals("0")) {
                return;
            } else
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

        }


    }



}
