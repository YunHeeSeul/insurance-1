package Practice.InsuranceCompany.Design.src.view;

import java.util.Scanner;

public class VMain {
    private Scanner scn;
    private VInsurance vInsurance;
    private VContract vContract;
    private VUnderwriting vUnderwriting;
    private VPayment vPayment;
    private VAccident vAccident;
    private VCollectionMoney vCollectionMoney;
    private VCustomer vCustomer;
    private VSubscription vSubscription;

    public void run() {
        this.scn = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------보험 시스템-----------------------------");
            System.out.println("1. 상품 관리 2. 계약 관리 3. Underwriting 4. 지급 관리 5. 사고처리 관리 6. 수금 관리 7. 고객 관리 8. 청약서 관리 0. 종료");

            String input = scn.next();
            System.out.println(input + " 선택");

            if (input.equals("1")) {
                this.vInsurance = new VInsurance(scn);
                this.vInsurance.run();

            } else if (input.equals("2")) {
                this.vContract = new VContract(scn);
                this.vContract.run();

            } else if (input.equals("3")) {
                this.vUnderwriting = new VUnderwriting(scn);
                this.vUnderwriting.run();

            } else if (input.equals("4")) {
                this.vPayment = new VPayment(scn);
                this.vPayment.run();

            } else if (input.equals("5")) {
                this.vAccident = new VAccident(scn);
                this.vAccident.run();
            } else if (input.equals("6")) {
                this.vCollectionMoney = new VCollectionMoney(scn);
                this.vCollectionMoney.run();
            } else if (input.equals("7")) {
                this.vCustomer = new VCustomer(scn);
                this.vCustomer.run();
            }else if (input.equals("8")) {
                this.vSubscription = new VSubscription(scn);
                this.vSubscription.run();
            }else if (input.equals("0")) {
                return;
            } else
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

        }
    }
}
