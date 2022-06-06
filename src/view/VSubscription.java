package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CCustomer;
import Practice.InsuranceCompany.Design.src.controller.CEmployee;
import Practice.InsuranceCompany.Design.src.controller.CInsurance;
import Practice.InsuranceCompany.Design.src.controller.CSubscription;
import Practice.InsuranceCompany.Design.src.etcEnum.UnderwritingStatus;
import Practice.InsuranceCompany.Design.src.model.employee.Employee;
import Practice.InsuranceCompany.Design.src.model.employee.EmployeeListImpl;
import Practice.InsuranceCompany.Design.src.model.subscription.Subscription;

import java.util.Scanner;

public class VSubscription extends View {

    private Scanner scanner;
    private CSubscription cSubscription;
    private CCustomer cCustomer;
    private CInsurance cInsurance;
    private CEmployee cEmployee;


    public VSubscription(Scanner scanner) {
        this.scanner = scanner;
        this.cSubscription = new CSubscription();
        this.cCustomer = new CCustomer();
        this.cInsurance = new CInsurance();
        this.cEmployee = new CEmployee();
    }

    public void run(){
        while(true) {
            System.out.println("----------------------------- 청약서 관리 ----------------------------");
            System.out.println("(1). 청약서 조회 (2). 청약서 등록 (3). 청약서 수정 (4). 청약서 삭제 (0) 뒤로가기");
            String selectedMenu = scanner.next();

            switch (selectedMenu) {
                case "1":
                    this.printAllSubscription(this.cSubscription);
                    break;
                case "2":
                    this.addSubscription();
                    break;
                case "3":
                    this.updateSubscription();
                    break;
                case "4":
                    this.deleteSubscription();
                    break;
                case "0":
                    return;
            }
        }
    }

    private void addSubscription() {
        System.out.println("<---- 청약서 등록 ---->");

        Subscription subscription = new Subscription();

        // 청약서를 등록할 고객 선택
        System.out.println("# 아래 목록을 참고하여 청약서를 작성할 고객을 선택하여 해당 고객의 ID를 입력하세요. #");
        this.printAllCustomer(this.cCustomer);
        subscription.setCustomerID(scanner.next());

        // 청약서를 등록할 보험 선택
        System.out.println("# 아래 목록을 참고하여 청약서를 작성할 보험을 선택하여 해당 보험의 ID를 입력하세요. #");
        this.printAllInsurance(this.cInsurance);
        subscription.setInsuranceID(scanner.next());

        // 청약서를 등록할 보험설계사 선택 ====> 구현 필요
        System.out.println("# 아래 목록을 참고하여 청약서를 작성할 보험 설계사 직원을 선택하여 해당 직원의 ID를 입력하세요. #");
        this.printAllInsuranceAgent(this.cEmployee);
        subscription.setInsuranceAgentID(scanner.next());

        // 그 외의 속성값 설정
        setSubscriptionAttr(subscription);

        if(this.cSubscription.create(subscription)){
            System.out.println("새로 추가되는 청약서 정보는 아래와 같습니다.");
            printSubscriptionDetails(subscription);
        }
    }

    private void printAllInsuranceAgent(CEmployee cEmployee) {
        EmployeeListImpl employeeList = cEmployee.retrieveAll();
        if (employeeList.getEmployeeList().size() == 0)
            System.out.println("직원 정보 목록이 비어있습니다.");
        else {
            for (Employee employee : employeeList.getEmployeeList()) {
                printEmployeeDetails(employee);
                System.out.println("\n");
            }
        }
    }

    private void printEmployeeDetails(Employee employee) {
        System.out.println("- ID : " + employee.getEmployeeId());
        System.out.println("- 이름 : " + employee.getName());
        System.out.println("- 소속 부서명 : " + employee.getDepartment().getDetail());
        System.out.println("- 전화번호 : " + employee.getPhoneNum());

    }


    private void updateSubscription() {
        System.out.println("<---- 청약서 수정 ---->");
        System.out.println("청약서 목록을 확인한 후 수정할 청약서를 선택하려면 0, 즉시 청약서 아이디 입력을 통해 선택하려면 1을 입력하세요");

        if (scanner.next().equals("0")) printAllSubscription(this.cSubscription);
        System.out.println("\n수정하고자 하는 청약서의 아이디를 입력해주세요 : ");
        String inputID = this.scanner.next();
        Subscription subscription = cSubscription.retrieveById(inputID);

        if(subscription == null) {
            System.out.println("* 청약서 정보를 불러올 수 없습니다. *");
        } else {
            String input = "y";
            while(!input.equals("n")) {
                System.out.println("수정하실 청약서의 세부 항목의 번호를 입력해주세요.");
                System.out.println("1. 청약서 생성일자 | 2. 보험 계약 기간 | 3. 보험료");

                subscription = inputNewSubscriptionInfo(scanner.nextInt(), subscription);

                if (cSubscription.updateById(inputID, subscription)) {
                    System.out.println("청약서의 수정이 완료되었습니다. 수정된 청약서 정보는 아래와 같습니다.");
                    subscription = cSubscription.retrieveById(inputID);
                    printSubscriptionDetails(subscription);
                } else System.out.println("* 청약서의 수정에 실패하였습니다. *");

                System.out.println("계속 수정하려면 y, 수정을 종료하려면 n를 입력하세요.");
                input = scanner.next();
            }
        }

    }

    private void deleteSubscription() {
        System.out.println("<---- 청약서 삭제 ---->");
        System.out.println("청약서 목록을 확인한 후 삭제하려면 0, 청약서 아이디 입력을 통해 즉시 삭제하려면 1을 입력하세요");
        if (scanner.next().equals("0")) printAllSubscription(this.cSubscription);
        System.out.println("\n삭제하고자 하는 청약서 상품의 아이디를 입력해주세요 : ");
        String inputID = new Scanner(System.in).next();
        if(this.cSubscription.deleteById(inputID)) System.out.println("입력하신 ID의 청약서가 삭제되었습니다.");
        else System.out.println("청약서 삭제에 실패하였습니다.");
    }

    private String generateID(String keyword){ return keyword + (this.cSubscription.getMaxID() + 1); }

    private void setSubscriptionAttr(Subscription subscription) {
        subscription.setSubscriptionID(generateID("SC"));

        subscription.setUnderwritingStatus(UnderwritingStatus.notApplied);  // 신규 청약서 UW status - 미신청 기본값
        scanner.nextLine();
        System.out.println("청약서 생성일자 (입력 예시 => 2022.05.23) : ");
        subscription.setDateCreated(scanner.nextLine());

        System.out.println("보험 계약 기간 (단위:년) : ");
        subscription.setInsurancePeriod(scanner.nextInt());

        System.out.println("보험료 : ");
        subscription.setPremium(scanner.nextInt());
    }

    private Subscription inputNewSubscriptionInfo(int selectedDetail, Subscription subscription) {
        String input = null;
        switch (selectedDetail) {
            case 1:
                System.out.println("새로운 생성일자 : ");
                input = scanner.next();
                subscription.setDateCreated(input);
                break;
            case 2:
                System.out.println("새로운 보험 계약 기간 (단위:개월) : ");
                input = scanner.next();
                subscription.setInsurancePeriod(Integer.parseInt(input));
                break;
            case 3:
                System.out.println("새로운 보험료 : ");
                input = scanner.next();
                subscription.setPremium(Integer.parseInt(input));
                break;
        }
        return subscription;
    }
}
