package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.accident.Accident;
import Practice.InsuranceCompany.Design.src.accident.AccidentListImpl;
import Practice.InsuranceCompany.Design.src.accident.AccidentType;
import Practice.InsuranceCompany.Design.src.accident.CAccident;
import Practice.InsuranceCompany.Design.src.contract.ContractListImpl;
import Practice.InsuranceCompany.Design.src.customer.Customer;
import Practice.InsuranceCompany.Design.src.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.etcEnum.Level;

import java.util.Optional;
import java.util.Scanner;

public class VAccident {
    Scanner scn;
    private CAccident cAccident;
    private CCustomer cCustomer;

    private AccidentListImpl accidentList;
    private CustomerListImpl customerList;

    public void run() {
        while (true) {
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

    public VAccident(Scanner scn, AccidentListImpl accidentList, CustomerListImpl customerList) {
        this.scn=scn;
        this.cAccident=new cAccident();
        this.cCustomer=new cCustomer();
        this.accidentList=accidentList;
        this.customerList=customerList;

    }

    private boolean inquireAllAccident() {
        AccidentListImpl accidentList = this.cAccident.getAllAccidentList();
        if(accidentList.getAllList().size()==0){
            System.out.println("접수된 사고가 없습니다.");
            return false;
        }
        System.out.println("----------------------------사고 전체 목록----------------------------");
  //      System.out.println("(사고ID)  (고객ID)  (사고 종류)  (사고 일시)  (사고 장소)  (사고 규모)  (사고 내용)  (가해 여부)  (담당 손해사정업체)  (면부책 여부)  (현장 출동 여부)");
        accidentList.printAllList();
        return true;
    }

    public void receiveAccident() {
        Accident accident=new Accident();
        ContractListImpl contractList=this.cContract.getAllContractList();
        Optional<Customer> customer;
        Customer existingCustomer;

        System.out.println("----------------------------사고 접수----------------------------");
        System.out.print("고객 ID : ");
        String customerID = scn.next();
        customer= customerList.getByCustomerId(customerID);

        // 입력받은 customerID를 가진 customer 가 있는 경우
        if(customer.isPresent()){
            existingCustomer = customer.get();
        }

        // 입력받은 customerID를 가진 customer 가 없는 경우
        else{

            System.out.println("정보와 일치하는 고객이 없습니다. 다시 입력해주세요.");

            while(customer.isPresent()){
                customerID = scn.next();
                customer= customerList.getByCustomerId(customerID);
            }
        }

        accident.setAccidentID(accident.getAccidentID());
        accident.setCustomerID(String.valueOf(customer));


        System.out.println("사고 종류를 선택하세요.");
        System.out.println("(1)자동차사고 (2)화재사고 (3)질병");
        System.out.println("사고 종류 : ");

        int accidentType=scn.nextInt();

        while (accidentType != 1 && accidentType != 2 && accidentType != 3){
            accidentType = scn.nextInt();
        }

        switch (accidentType){
            case 1:
                accident.setAccidentType(AccidentType.car);
                break;

            case 2:
                accident.setAccidentType(AccidentType.fire);
                break;

            case 3:
                accident.setAccidentType(AccidentType.health);
                break;

            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                break;
        }

        System.out.println("사고 일자를 입력하세요 : ");
        String accidentDate=scn.next();
        accident.setAccidentDate(accidentDate);

        System.out.println("사고 장소를 입력하세요 : ");
        String accidentLocation=scn.next();
        accident.setAccidentLocation(accidentLocation);

        System.out.println("사고 내용을 입력하세요 : ");
        String accidentContent=scn.next();
        accident.setAccidentContent(accidentContent);

        System.out.println("사고 접수를 완료하였습니다.");
    }

    public void surveyAccident() {
        Accident accident=new Accident();

        System.out.println("----------------------------사고 조사----------------------------");
        System.out.print("사고 조사를 할 고객을 선택해주세요");
        System.out.print("고객 ID : ");
        String customerID = scn.next();
        Optional<Customer> customer = customerList.getByCustomerId(customerID);

        while (customer.isEmpty()) {
            System.out.print("정보가 일치하는 고객이 존재하지 않습니다.");
            System.out.print("고객 ID를 다시 입력해주세요.");
            System.out.print("=============================================================");
            System.out.print("고객 ID : ");
            customerID = scn.next();
            customer = customerList.getByCustomerId(customerID);

        }

        Customer existingCustomer = customer.get();

        Optional<Accident> opAccident = accidentList.getOptionalAccidentByCustomerId(customerID);
        if (opAccident.isEmpty()) {
            System.out.println("고객 ID가 " + customerID + "인 고객의 조사할 사고 접수 내역이 존재하지 않습니다.");

        } else {

//          String cusName=this.customerList.getByCustomerId(customerID).getByCustomerName(customerName);
            System.out.println("-----------------고객 ID "+customerID+"님의 사고 접수 내역-----------------");
            inquireAllAccident();
            System.out.print("조사할 사고 ID를 입력해주세요");
            System.out.print("사고 ID : ");
            String accidentID = scn.next();
            Accident accidentList = this.accidentList.getAccidentID(accidentID);

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
    }

    public void signUpExemption() {
        Accident accident=new Accident();

        System.out.println("----------------------------면/부책 등록----------------------------");
        System.out.print("면/부책을 등록할 고객을 선택해주세요");
        System.out.print("고객 ID : ");
        String customerID = scn.next();
        Optional<Customer> customer = customerList.getByCustomerId(customerID);

        while (customer.isEmpty()) {
            System.out.print("정보와 일치하는 고객이 존재하지 않습니다.");
            System.out.print("고객 ID를 다시 입력해주세요.");
            System.out.print("=============================================================");
            System.out.print("고객 ID : ");
            customerID = scn.next();
            customer = customerList.getByCustomerId(customerID);

        }

        Customer existingCustomer = customer.get();

        Optional<Accident> opAccident = accidentList.getOptionalAccidentByCustomerId(customerID);

        if (opAccident.isEmpty()) {
            System.out.println("고객 ID가 " + customerID + "인 고객의 면/부책을 등록할 사고 접수 내역이 존재하지 않습니다.");

        } else {
            System.out.println("-----------------"+customer+"님의 사고 접수 내역-----------------");
            inquireAllAccident();
            System.out.print("등록할 면/부책에 해당하는 사고ID를 입력해주세요");
            System.out.print("사고 ID : ");
            String accidentID = scn.next();

            accident.registerExemptionInfo(accidentID);
            System.out.println("사고 ID "+accidentID+"의 면/부책이 등록되었습니다.");
        }
    }
}
