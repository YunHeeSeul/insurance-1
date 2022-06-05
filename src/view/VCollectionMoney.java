package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CContract;
import Practice.InsuranceCompany.Design.src.controller.CCustomer;
import Practice.InsuranceCompany.Design.src.controller.CPolicyholder;
import Practice.InsuranceCompany.Design.src.model.contract.Contract;
import Practice.InsuranceCompany.Design.src.model.contract.ContractListImpl;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.model.policyholder.Policyholder;

import java.util.Scanner;

public class VCollectionMoney {

    private Scanner scn;
    private CContract cContract;
    private CCustomer cCustomer;
    private CPolicyholder cPolicyholder;

    public VCollectionMoney(Scanner scn) {
        this.scn = scn;
        this.cCustomer = new CCustomer();
        this.cContract=new CContract();
        this.cPolicyholder=new CPolicyholder();
    }

    public void run() {
        while (true) {
            System.out.println("(1)월보험료 산출 (2)보험료 납부 여부 확인 및 안내");
            System.out.println("(b)뒤로가기");
            String input = scn.next();
            switch (input) {
                case "1": calculateTotalPremiumOfCustomer(); break;
                case "2": getCollectionOfPremium(); break;
                case "b": return;
                default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    private void calculateTotalPremiumOfCustomer() {
        System.out.println("--------------------가입자 목록--------------------");
        CustomerListImpl customerList=this.cCustomer.retrieveAll();
        customerList.printAllCustomerInfo();

        System.out.println("(c) 나가기");
        System.out.print("고객 ID : ");
        String cusID = scn.next();
        if(cusID.equals("c")) return;

        if (customerList.checkValidationID(cusID)) {
            ContractListImpl contractList=this.cContract.getValidByCustomerID(cusID);

            int totalPremium = 0;
            if(contractList.getAllList().size()==0) System.out.println("유효한 계약이 없습니다.");
            else{
                for(Contract contract: contractList.getAllList()){
                    totalPremium+=contract.getPremium();
                }
                System.out.println("가입자의 총 월보험료 : " + totalPremium + "원");
                if(this.cPolicyholder.updateTotalPremiumTypeById(cusID,totalPremium)) System.out.println("총 월보험료가 설정되었습니다.");
                else System.out.println("DB 오류입니다.");
            }
        } else System.out.println("입력한 아이디의 고객이 존재하지 않습니다.");
    }

    private void getCollectionOfPremium() {
        CustomerListImpl customerList = this.cPolicyholder.retrieveAll();
        if (customerList.getCustomerList().size() == 0) {
            System.out.println("가입자가 없습니다.");
            return;
        }
        System.out.println("--------------------가입자 목록--------------------");
        System.out.println("(고객ID)(고객명)(총월보험료)(납부상태)");
        for (Customer customer : customerList.getCustomerList()) {
            Policyholder p = (Policyholder) customer;
            String state = p.getPaymentState() ? "납부" : "미납";
            System.out.println("   "+p.getCustomerID() + "   " + p.getName() + "   " + p.getTotalPremium() + "   " + state);
        }

        System.out.println("(c) 나가기");
        System.out.print("고객 ID : ");
        String cusID = scn.next();
        if(cusID.equals("c")) return;

        if (customerList.checkValidationID(cusID)) {
            Policyholder policyholder = this.cPolicyholder.retrieveById(cusID);
            if (policyholder.isPaymentState())
                System.out.println("당월 보험료 납부 상태는 완납입니다.");
            else {
                System.out.print("미납안내 메일을 전송하시겠습니까?(y/n) ");
                String input = scn.next();
                if (input.equals("y")) System.out.println(policyholder.getEmailAddress() + "로 미납안내 메일을 전송했습니다.");
                else System.out.println("전송 취소합니다.");
            }
        } else System.out.println("해당 고객이 없습니다.");
    }
}
