package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CCustomer;
import Practice.InsuranceCompany.Design.src.controller.CExemptionInfo;
import Practice.InsuranceCompany.Design.src.controller.CSurveyCompany;
import Practice.InsuranceCompany.Design.src.etcEnum.Responsibility;
import Practice.InsuranceCompany.Design.src.model.accident.Accident;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentListImpl;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentType;
import Practice.InsuranceCompany.Design.src.controller.CAccident;
import Practice.InsuranceCompany.Design.src.model.accident.ExemptionInfo;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.etcEnum.Level;
import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompany;
import Practice.InsuranceCompany.Design.src.model.survey.SurveyCompanyListImpl;

import java.util.Locale;
import java.util.Scanner;

public class VAccident extends View {
    private Scanner scn;
    private Accident accident;
    private CAccident cAccident;
    private CSurveyCompany cSurveyCompany;
    private CCustomer cCustomer;
    private CExemptionInfo cExemptionInfo;

    public VAccident(Scanner scn) {
        this.scn = scn;
        this.cAccident = new CAccident();
        this.cSurveyCompany = new CSurveyCompany();
        this.cCustomer = new CCustomer();
        this.cExemptionInfo=new CExemptionInfo();
    }

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

    private void inquireAllAccidentDetails(CAccident cAccident) {
        AccidentListImpl accidentList = this.cAccident.getAllAccidentList();
        if(accidentList.getAllList().size()==0){
            System.out.println("사고 목록이 없습니다.");
        }
        for(Accident accident : accidentList.getAllList()) {
            printAccidentDetails(accident);
            System.out.println("\n");
        }
    }

    private void printAccidentDetails(Accident accident){
        ExemptionInfo exemptionInfo = this.cExemptionInfo.getByID(accident.getExemptionInfoID());
        System.out.println("사고 ID : " + accident.getAccidentID());
        System.out.println("고객 ID : " + accident.getCustomerID());
        System.out.println("사고 종류 : " + accident.getAccidentType());
        System.out.println("사고 일시 : " + accident.getAccidentDate());
        System.out.println("사고 장소 : " + accident.getAccidentLocation());
        System.out.println("사고 규모 : " + accident.getAccidentScale());
        System.out.println("사고 내용 : " + accident.getAccidentContent());
        if(accident.isDoingHarm()==true)
            System.out.println("가해 여부 : 가해");
        else
            System.out.println("가해 여부 : x");
        System.out.println("담당 손해사정업체 : " + accident.getRepSurveyCompanyID());
        System.out.println("["+accident.getExemptionInfoID()+"]_면/부책 정보 : ");
        System.out.println("책임 여부 : " + exemptionInfo.getResponsibility().getDetail());
        System.out.println("판단 사유 : " + exemptionInfo.getJudgementReason());
        System.out.println("보험금 지급 비율 : " + exemptionInfo.getPaymentRatio());

        if(accident.isOnsite()==true)
            System.out.println("현장 조사 여부 : 조사함");
        else
            System.out.println("현장 조사 여부 : 조사하지 않음");
    }
    private void inquireAllAccident(CAccident cAccident) {
        AccidentListImpl accidentList = this.cAccident.getAccidentList();
        if(accidentList.getAllList().size()==0){
            System.out.println("사고 목록이 없습니다.");
        }
        for(Accident accident : accidentList.getAllList()) {
            printAccident(accident);
            System.out.println("\n");
        }
    }

    private void printAccident(Accident accident){

        System.out.println("사고 ID : " + accident.getAccidentID());
        System.out.println("고객 ID : " + accident.getCustomerID());
        System.out.println("사고 종류 : " + accident.getAccidentType());
        System.out.println("사고 일시 : " + accident.getAccidentDate());
        System.out.println("사고 장소 : " + accident.getAccidentLocation());
        //   System.out.println("사고 규모 : " + accident.getAccidentScale());
        System.out.println("사고 내용 : " + accident.getAccidentContent());

    }

    private void printAllSurveyCompany() {

        SurveyCompanyListImpl surveyCompanyList = this.cSurveyCompany.getAllSurveyCompany();
        if(surveyCompanyList.getAllList().size()==0){
            System.out.println("손해사정업체 목록이 없습니다.");
        }
        for(SurveyCompany surveyCompany : surveyCompanyList.getAllList()) {
            showSurveyCompany(surveyCompany);
            System.out.println("\n");
        }
    }

    private void showSurveyCompany(SurveyCompany surveyCompany) {
        System.out.println("손해사정업체 ID : " + surveyCompany.getSurveyCompanyID());
        System.out.println("손해사정업체명 : " + surveyCompany.getSurveyCompanyName());
        System.out.println("업체 주소 : " + surveyCompany.getAddress());
        System.out.println("업체 번호 : " + surveyCompany.getPhoneNum());
        if(surveyCompany.isSurveyAbility())
            System.out.println("현장 조사 가능 여부 : 가능");
        else
            System.out.println("현장 조사 가능 여부 : 불가능");
    }


    public void receiveAccident() {
        Accident accident=new Accident();

        System.out.println("----------------------------사고 접수----------------------------");
        System.out.println("목록을 참고하여 사고 접수를 할 고객을 선택해주세요");
        this.printAllCustomer(this.cCustomer);
        System.out.println("고객 ID : ");
        accident.setCustomerID(scn.next());

        addAccident(accident);
    }
    private String generateID(String keyword){
        if(keyword.equals("EX")) return keyword + (this.cExemptionInfo.getMaxID() + 1);
        else if(keyword.equals("AC")) return keyword + (this.cAccident.getMaxID() + 1);
        else return null;
    }

    public void addAccident(Accident accident){
        accident.setAccidentID(generateID("AC"));

        System.out.println("사고 종류를 선택하세요.");
        System.out.println("사고 종류 [ 자동차 | 화재 ]");
        String accidentType=scn.next();
        if(accidentType.equals("자동차"))
            accident.setAccidentType(AccidentType.car);
        else if(accidentType.equals("화재"))
            accident.setAccidentType(AccidentType.fire);
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
        boolean result = this.cAccident.create(accident);
    }
    private void surveyAccident() {
        SurveyCompany surveyCompany = new SurveyCompany();
        System.out.println("----------------------------사고 조사----------------------------");
        System.out.println("목록을 참고하여 사고 조사 할 사고를 선택해주세요");
        this.inquireAllAccident(this.cAccident);
        System.out.println("사고 ID : ");
        String accidentID = this.scn.next();
        Accident accident = cAccident.getByAccidentID(accidentID);

        if (accident==null) {
            System.out.println("*사고 내역을 불러올 수 없습니다.*");
        }
        else{
            System.out.println("현장 출동을 지시하시겠습니까?");
            System.out.println("(y)예 (n)아니오");
            String response = scn.next();
            if (response.equals("y")){
                accident.setOnsite(true);
                System.out.println("목록을 보고 현장 출동을 지시할 손해사정업체ID를 입력하세요.");
                this.printAllSurveyCompany();
                System.out.println("손해사정업체 ID : ");
                accident.setRepSurveyCompanyID(scn.next());
            }
            else if (response.equals("n")){
                accident.setOnsite(false);
                accident.setRepSurveyCompany(null);
            }
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
            System.out.println("사고 조사를 완료했습니다.");
        }
        this.cAccident.update(accidentID,accident);

    }


    public void signUpExemption() {
        ExemptionInfo exemptionInfo = new ExemptionInfo();
        exemptionInfo.setExemptionInfoID(generateID("EX"));

        System.out.println("----------------------------면/부책 등록----------------------------");
        System.out.println("목록을 보고 면/부책을 등록할 사고를 선택해주세요");
        this.inquireAllAccident(this.cAccident);
        System.out.println("사고 ID : ");
        String accidentID = this.scn.next();

        registerExemptionInfo(exemptionInfo);
        System.out.println("면/부책이 등록되었습니다.");
        this.cExemptionInfo.create(exemptionInfo);
        this.cAccident.updateExemptionInfoID(accidentID,exemptionInfo.getExemptionInfoID());

        System.out.println("면/부책이 등록이 완료된 사고 목록입니다.");
        accident = cAccident.getByAccidentID(accidentID);
        this.printAccidentDetails(accident);

    }

    private void registerExemptionInfo(ExemptionInfo exemptionInfo){
        System.out.println("책임 여부를 입력하세요.");
        System.out.println("(y)부책 (n)면책");
        String response = scn.next();
        if (response.equals("y"))
            exemptionInfo.setResponsibility(Responsibility.responsible);
        else if (response.equals("n"))
            exemptionInfo.setResponsibility(Responsibility.notResponsible);

        System.out.println("판단 사유를 입력하세요 : ");
        String judgementReason=scn.next();
        exemptionInfo.setJudgementReason(judgementReason);

        System.out.println("보험금 지급 비율을 입력하세요 : ");
        Double paymentRatio=scn.nextDouble();
        exemptionInfo.setPaymentRatio(paymentRatio);

    }


}
