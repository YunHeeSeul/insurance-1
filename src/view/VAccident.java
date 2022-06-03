package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CCustomer;
import Practice.InsuranceCompany.Design.src.model.accident.Accident;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentListImpl;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentType;
import Practice.InsuranceCompany.Design.src.controller.CAccident;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.etcEnum.Level;

import java.util.Scanner;

public class VAccident {
    Scanner scn;
    private Accident accident;
    private CAccident cAccident;
    private CCustomer cCustomer;

    private AccidentListImpl accidentList;
    private CustomerListImpl customerList;

    public VAccident(Scanner scn) {
        this.scn = scn;
        this.cAccident = new CAccident();
        this.cCustomer = new CCustomer();
    }
//    public VAccident(Scanner scn, AccidentListImpl accidentList, CustomerListImpl customerList) {
//        this.scn=scn;
//        this.cAccident=new cAccident();
//        this.cCustomer=new cCustomer();
//        this.accidentList=accidentList;
//        this.customerList=customerList;
//}

    public void run() {
        while (true) {
            System.out.println("---------------------사고 관리-----------------------");
            System.out.println("(1)사고 접수(2)사고 조사 (3)면/부책 등록");
            System.out.println("(b)뒤로가기");
            String input = scn.next();
            switch (input) {
                case "1" : receiveAccident(); break;
                case "2" : surveyAccident(); break;
                case "3" : signUpExemption(); break;
                case "b" : return;
                default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    private boolean inquireAllAccident() {
        AccidentListImpl accidentList = this.cAccident.getAllAccidentList();
        if(accidentList.getAllList().size()==0){
            System.out.println("접수된 사고가 없습니다.");
            return false;
        }
        System.out.println("----------------------------사고 전체 목록----------------------------");
        //      System.out.println("(사고ID)  (고객ID)  (사고 종류)  (사고 일시)  (사고 장소)  (사고 규모)  (사고 내용)  (가해 여부)  (담당 손해사정업체)  (면부책 여부)  (현장 출동 여부)");
        accident.printAccidentDetails();

        return true;
    }

    public void receiveAccident() {
        Accident accident=new Accident();
        AccidentListImpl accidentList=this.cAccident.getAllAccidentList();
        Customer customer;

        System.out.println("----------------------------사고 접수----------------------------");
        System.out.print("고객 ID : ");
        String customerID = scn.next();
        customer= cCustomer.retrieveById(customerID);

        addAccident(accident);

        while(customer==null){
            System.out.println("정보와 일치하는 고객이 없습니다. 다시 입력해주세요.");
            customerID = scn.next();
            customer= cCustomer.retrieveById(customerID);
        }

        accident.setAccidentID(accident.getAccidentID());
        accident.setCustomerID(customer.getCustomerID());
    }

    public void addAccident(Accident accident){
        System.out.println("사고 종류를 선택하세요.");
        System.out.println("사고 종류 [ 자동차 | 화재 | 건강 ]");
        String accidentType=scn.next();
        if(accidentType.equals("자동차"))
            accident.setAccidentType(AccidentType.car);
        else if(accidentType.equals("화재"))
            accident.setAccidentType(AccidentType.fire);
        else if(accidentType.equals("건강"))
            accident.setAccidentType(AccidentType.health);
        else {
            System.out.println("잘못 입력하였습니다.");
            return;
        }

        scn.nextLine();
        System.out.println("사고 일자를 입력하세요 : ");
        accident.setAccidentDate(scn.nextLine());

        System.out.println("사고 장소를 입력하세요 : ");
        accident.setAccidentLocation(scn.nextLine());

        System.out.println("사고 내용을 입력하세요 : ");
        accident.setAccidentContent(scn.nextLine());

        System.out.println("사고 접수를 완료하였습니다.");
    }
    public boolean surveyAccident() {
        Accident accident=new Accident();

        System.out.println("----------------------------사고 조사----------------------------");
        System.out.print("사고 조사를 할 고객을 선택해주세요");
        System.out.print("고객 ID : ");
        String customerID = scn.next();
        Customer customer = cCustomer.retrieveById(customerID);

        while (customer==null) {
            System.out.print("정보가 일치하는 고객이 존재하지 않습니다.");
            System.out.print("고객 ID를 다시 입력해주세요.");
            System.out.print("=============================================================");
            System.out.print("고객 ID : ");
            customerID = scn.next();
            customer = cCustomer.retrieveById(customerID);

        }

        Accident accident1 = cAccident.getByAccidentID(customerID);
        if (accident1 == null) {
            System.out.println("고객 ID가 " + customerID + "인 고객이 소유하고 있는 보험이 존재하지 않습니다.");
            return false;
        }
        else{
            System.out.println("-----------------고객 ID "+customerID+"님의 사고 접수 내역-----------------");
            inquireAllAccident();
            System.out.print("조사할 사고 ID를 입력해주세요");
            System.out.print("사고 ID : ");
            String accidentID = scn.next();
            Accident accident2 = cAccident.getByAccidentID(accidentID);

            if (accident2==null) {
                System.out.println("고객 ID가 " + customerID + "인 고객의 조사할 사고 접수 내역이 존재하지 않습니다.");

            } else {
                System.out.println("현장 출동을 지시하시겠습니까?");
                System.out.println("(y)예 (n)아니오");
                String response = scn.next();
                if (response.equals("y")) {
                    accident.setOnsite(true);

                    System.out.println("가해 여부를 입력해주세요");
                    System.out.println("(y)예 (n)아니오");
                    response = scn.next();
                    if (response.equals("y"))
                        accident.setDoingHarm(true);
                    else if (response.equals("n"))
                        accident.setOnsite(false);

                    System.out.println("사고 규모를 입력해주세요");
                    System.out.println("(1)High (2)Middle (3)Low");
                    int level = scn.nextInt();
                    while (level != 1 && level != 2 && level != 3){
                        level = scn.nextInt();
                    }

                    switch (level){
                        case 1:
                            accident.setAccidentScale(Level.high); break;
                        case 2:
                            accident.setAccidentScale(Level.middle); break;
                        case 3:
                            accident.setAccidentScale(Level.low); break;
                        default:
                            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
                    }
                }
                else if (response.equals("n"))
                    accident.setOnsite(false);
            }
            return true;
        }
    }

    public boolean signUpExemption() {
        Accident accident = new Accident();

        System.out.println("----------------------------면/부책 등록----------------------------");
        System.out.print("면/부책을 등록할 고객을 선택해주세요");
        System.out.print("고객 ID : ");
        String customerID = scn.next();
        Customer customer = cCustomer.retrieveById(customerID);

        while (customer == null) {
            System.out.print("정보가 일치하는 고객이 존재하지 않습니다.");
            System.out.print("고객 ID를 다시 입력해주세요.");
            System.out.print("=============================================================");
            System.out.print("고객 ID : ");
            customerID = scn.next();
            customer = cCustomer.retrieveById(customerID);
        }
        Accident accident1 = cAccident.getByAccidentID(customerID);
        if (accident1 == null) {
            System.out.println("고객 ID가 " + customerID + "인 고객의 면/부책을 등록할 사고 접수 내역이 존재하지 않습니다.");
            return false;
        } else {
            System.out.println("-----------------고객 ID " + customerID + "님의 사고 접수 내역-----------------");
            inquireAllAccident();
            System.out.print("등록할 면/부책에 해당하는 사고ID를 입력해주세요");
            System.out.print("사고 ID : ");
            String accidentID = scn.next();

            accident.registerExemptionInfo(accidentID);
            System.out.println("사고 ID " + accidentID + "의 면/부책이 등록되었습니다.");
        }

        return true;
    }

}
