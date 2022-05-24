package Practice.InsuranceCompany.Design.src.main;

import Practice.InsuranceCompany.Design.src.contract.ContractListImpl;
import Practice.InsuranceCompany.Design.src.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.view.VPayment;

import java.util.Scanner;

public class Main {
    static Scanner scn;

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

            } else if (input.equals("4")) {

            } else if (input.equals("5")) {
                return;
            } else if (input.equals("0")) {
                return;
            } else
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

        }


    }

    public void vPayment(){
        CustomerListImpl customerList = new CustomerListImpl();
        ContractListImpl contractList = new ContractListImpl();

        while (true) {
            System.out.println("----------------제지급금 업무----------------");
            System.out.println("(1)제지급금 접수 (2)제지급금 지급 (3) 제지급금 심사 (4) 제지급금 산출 (5)종료");

            String input = scn.next();

            VPayment vPayment = new VPayment();

            if (input.equals("1")) {
                vPayment.signUp();

            } else if (input.equals("2")) {
                int resultMuoney = vPayment.sendMoney();
                System.out.println("지급금은 " + resultMuoney + "원 입니다.");

            } else if (input.equals("3")) {
                boolean result = vPayment.simsa();

            } else if (input.equals("4")) {
            } else if (input.equals("5")) {
                return;
            } else
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

        }
    }

}
