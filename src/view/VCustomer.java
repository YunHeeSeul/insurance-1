package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CCustomer;
import Practice.InsuranceCompany.Design.src.etcEnum.Gender;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;

import java.util.Scanner;

public class VCustomer extends View {
    private Scanner scanner;
    private CCustomer cCustomer;

    public VCustomer(Scanner scanner) {
        this.scanner = scanner;
        this.cCustomer = new CCustomer();
    }

    public void run() {
        while (true) {
            System.out.println("----------------------------- 고객 관리 ----------------------------");
            System.out.println("(1). 고객 정보 조회 (2). 신규 고객 등록 (3). 고객 정보 수정 (4). 고객 정보 삭제 (0) 뒤로가기");
            String selectedMenu = scanner.next();

            switch (selectedMenu) {
                case "1":
                    this.printAllCustomer(this.cCustomer);
                    break;
                case "2":
                    this.addCustomer();
                    break;
                case "3":
                    this.updateCustomer();
                    break;
                case "4":
                    this.deleteCustomer();
                    break;
                case "0":
                    return;
            }
        }
    }


    private String generateID(String keyword){ return keyword + (this.cCustomer.getMaxID() + 1); }

    private void addCustomer() {
        System.out.println("<---- 신규 고객 등록 ---->");
        Customer customer = new Customer();
        setCustomerAttr(customer);
        if(this.cCustomer.create(customer)){
            System.out.println("새로 등록되는 고객 정보는 아래와 같습니다.");
            printCustomerDetails(customer);
        }
    }

    private void updateCustomer() {
        System.out.println("<---- 고객 정보 수정 ---->");
        System.out.println("고객 정보 목록을 확인한 후 수정할 고객을 선택하려면 0, 즉시 고객 정보 아이디 입력을 통해 선택하려면 1을 입력하세요");

        if (scanner.next().equals("0")) printAllCustomer(this.cCustomer);
        System.out.println("\n수정하고자 하는 고객 정보의 아이디를 입력해주세요 : ");
        String inputID = this.scanner.next();
        Customer customer = cCustomer.retrieveById(inputID);

        if(customer == null) {
            System.out.println("* 고객 정보를 불러올 수 없습니다. *");
        } else {
            String input = "y";
            while(!input.equals("n")) {
                System.out.println("수정하실 고객 정보의 세부 항목의 번호를 입력해주세요.");
                System.out.println("1. 성함 | 2. 주민등록번호 | 3. 성별 | 4. 생년월일 | 5. 전화번호 | 6. 이메일 | 7. 자택/회사 주소 ");
                customer = inputNewCustomerInfo(scanner.nextInt(), customer);

                if (cCustomer.updateById(inputID, customer)) {
                    System.out.println("보험 상품의 수정이 완료되었습니다. 수정된 보헝 상품 정보는 아래와 같습니다.");
                    customer = cCustomer.retrieveById(inputID);
                    printCustomerDetails(customer);
                } else System.out.println("* 고객 정보 수정에 실패하였습니다. *");

                System.out.println("계속 수정하려면 y, 수정을 종료하려면 n를 입력하세요.");
                input = scanner.next();
            }
        }
    }

    private Customer inputNewCustomerInfo(int selectedDetail, Customer customer) {
        String input = null;
        switch (selectedDetail){
            case 1:
                System.out.println("새로운 고객 성함 : ");
                input = scanner.next();
                customer.setName(input);
                break;
            case 2:
                System.out.println("새로운 고객 주민등록번호 : ");
                input = scanner.next();
                customer.setResidentRegistrationNumber(input);
                break;
            case 3:
                System.out.println("새로운 고객 성별 : ");
                input = scanner.next();
                customer.setGender(input.equals(Gender.female.getDetail())?Gender.female:Gender.male);
                break;
            case 4:
                System.out.println("새로운 고객 생년월일 : ");
                input = scanner.next();
                customer.setDateOfBirth(input);
                break;
            case 5:
                System.out.println("새로운 고객 전화번호 : ");
                input = scanner.next();
                customer.setPhoneNumber(input);
                break;
            case 6:
                System.out.println("새로운 고객 이메일 : ");
                input = scanner.next();
                customer.setEmailAddress(input);
                break;
            case 7:
                scanner.nextLine();
                System.out.println("새로운 고객 자택/회사 주소 : ");
                input = scanner.nextLine();
                customer.setAddress(input);
                break;
            default:
                System.out.println("잘못 입력하였습니다.");
        }
        return customer;
    }

    private void deleteCustomer() {
        System.out.println("<---- 고객 정보 삭제 ---->");
        System.out.println("고객 정보 목록을 확인한 후 삭제하려면 0, 고객 아이디 입력을 통해 즉시 삭제하려면 1을 입력하세요");
        if (scanner.next().equals("0")) printAllCustomer(this.cCustomer);
        System.out.println("\n삭제하고자 하는 고객 정보의 아이디를 입력해주세요 : ");
        String inputID = new Scanner(System.in).next();
        this.cCustomer.deleteById(inputID);
    }

    private void setCustomerAttr(Customer customer) {
        customer.setCustomerID(generateID("CU"));

        System.out.println("고객 성함 : ");
        customer.setName(scanner.next());

        System.out.println("고객 주민등록번호 (입력 예시 => 950231-123456) : ");
        customer.setResidentRegistrationNumber(scanner.next());

        System.out.println("성별 (여성, 남성) : ");
        customer.setGender(scanner.next().equals(Gender.female.getDetail())? Gender.female:Gender.male);

        System.out.println("고객의 생년월일 (입력 예시 => 1995-02-31) : ");
        customer.setDateOfBirth(scanner.next());

        System.out.println("고객의 휴대전화번호 (입력 예시 => 010-1111-2222) : ");
        customer.setPhoneNumber(scanner.next());

        System.out.println("고객의 이메일 (입력 예시 => abc1234@gmail.com): ");
        customer.setEmailAddress(scanner.next());

        scanner.nextLine();
        System.out.println("고객의 자택/회사 주소 (도/시/구/동/지번/호수 모두 포함하여 입력 필수): ");
        customer.setAddress(scanner.nextLine());

        // 질환이력, 건물, 차량 정보는 이후에 입력 받음
        customer.setDiseaseHistory(null);
        customer.setOwnedBuildingInfo(null);
        customer.setOwnedCarInfo(null);
    }


}
