package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.insurance.InsuranceListImpl;
import Practice.InsuranceCompany.Design.src.policyholder.Policyholder;

import java.util.Scanner;

public class VCollectionMoney {

    private CustomerListImpl customerList;
    private InsuranceListImpl insuranceList;

    public VCollectionMoney() {

    }

    public void run(String selectedMenu) {
        switch (selectedMenu){
            case "1":
                this.calculateTotalPremiumOfCustomer();
                break;
            case "2":
                this.getCollectionOfPremium();
                break;
        }
    }
    private void calculateTotalPremiumOfCustomer(){
        // 고객의 월 보험료 산출하기 (유스케이스 시나리오 수정 필요)

        if(this.customerList != null) {
            System.out.println("가입자 정보는 아래와 같습니다. 월보험료를 산출하고자 하는 고객의 아이디를 입력해주세요.");
            this.customerList.printAllCustomerInfo();
            String inputID = new Scanner(System.in).next();
            if (this.customerList.checkValidationID(inputID)) {
                Policyholder policyholder = (Policyholder) this.customerList.getByCustomerId(inputID);
                // 가입자의 가입 보험이 여러개인 경우로 가정하여 구현

                Insurance insurance = this.insuranceList.get(inputID);
                int totalPremium = 0;
                totalPremium += insurance.getPremium();
                policyholder.setTotalPremiumOfMonth(totalPremium);
                System.out.println("가입자의 총 월보험료 : " + policyholder.getTotalPremiumOfMonth() + "원");
            } else
                System.out.println("입력한 아이디의 고객이 존재하지 않습니다.");
        } else{
            System.out.println("가입자 목록이 비어있습니다.");
            return;
        }

    }

    private void getCollectionOfPremium(){
        // 보험료 납부 확인하기
        System.out.println("가입자 정보는 아래와 같습니다. 보험료 납부를 확인하고자 하는 고객의 아이디를 입력해주세요.");
        this.customerList.printAllCustomerInfo();

        String inputID = new Scanner(System.in).next();
        if(this.customerList.checkValidationID(inputID)) {
            Policyholder policyholder = (Policyholder) this.customerList.getByCustomerId(inputID);
            if(policyholder.getPaymentState())
                System.out.println("당월 보험료 납부 상태는 완납입니다.");
            else
                System.out.println("당월 보험료 납부 상태는 미납입니다.");
        }
    }
}
