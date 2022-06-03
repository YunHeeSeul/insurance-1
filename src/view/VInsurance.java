
package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CAcquisitionPolicy;
import Practice.InsuranceCompany.Design.src.controller.CInsurance;
import Practice.InsuranceCompany.Design.src.controller.CWarrantyInfo;
import Practice.InsuranceCompany.Design.src.model.contract.ContractType;
import Practice.InsuranceCompany.Design.src.model.insurance.*;

import java.util.Scanner;

public class VInsurance extends View {

    private Scanner scanner;

    private CInsurance cInsurance;
    private CWarrantyInfo cWarrantyInfo;
    private CAcquisitionPolicy cAcquisitionPolicy;


    public VInsurance(Scanner scanner){
        this.scanner = scanner;
        this.cInsurance = new CInsurance();
        this.cWarrantyInfo = new CWarrantyInfo();
        this.cAcquisitionPolicy = new CAcquisitionPolicy();
    }

    public void run(){
        while(true) {
//            super.run("상품 관리", "(1). 상품 조회 (2). 상품 등록 (3). 상품 수정 (4). 상품 삭제 (0) 뒤로가기");
            System.out.println("----------------------------- 상품 관리 ----------------------------");
            System.out.println("(1). 상품 조회 (2). 상품 등록 (3). 상품 수정 (4). 상품 삭제 (0) 뒤로가기");
            String selectedMenu = scanner.next();

            switch (selectedMenu) {
                case "1":
                    this.printAllInsurance(this.cInsurance);
                    break;
                case "2":
                    this.addInsurance();
                    break;
                case "3":
                    this.updateInsurance();
                    break;
                case "4":
                    this.deleteInsurance();
                    break;
                case "0":
                    return;
            }
        }
    }

    public void addInsurance(){
        System.out.println("<---- 상품 등록 ---->");
        Insurance insurance = new Insurance();
        setInsuranceAttr(insurance);

        if(insurance.getAcquisitionPolicy() != null)
            cAcquisitionPolicy.addAcquisitionPolicy(insurance.getAcquisitionPolicy());

        boolean result = this.cInsurance.create(insurance);
        for (WarrantyInfo warrantyInfo : insurance.getWarrantyContent())
            cWarrantyInfo.create(warrantyInfo, insurance.getInsuranceID());
        if(result){
            System.out.println("새로 추가되는 보험 정보는 아래와 같습니다.");
            printInsuranceDetails(insurance);
        }
    }

    public void updateInsurance () {
        System.out.println("<---- 상품 수정 ---->");
        System.out.println("보험 상품 목록을 확인한 후 수정할 상품을 선택하려면 0, 즉시 보험 아이디 입력을 통해 선택하려면 1을 입력하세요");

        if (scanner.next().equals("0")) printAllInsurance(this.cInsurance);
        System.out.println("\n수정하고자 하는 보험 상품의 아이디를 입력해주세요 : ");
        String inputID = this.scanner.next();
        Insurance insurance = cInsurance.retrieveById(inputID);

        if(insurance == null) {
            System.out.println("* 보험 상품 정보를 불러올 수 없습니다. *");
        } else {
            String input = "y";
            while(!input.equals("n")) {
                System.out.println("수정하실 보험의 세부 항목의 번호를 입력해주세요.");
                System.out.println("1. 보험명 | 2. 보험 설명 | 3. 보험 분류 | 4. 가입연령제한 | 5. 기본 위험률 | 6. 기본 보험료 | 7. 기본 요율");
                insurance = inputNewInsuranceInfo(scanner.nextInt(), insurance);

                if (cInsurance.updateById(inputID, insurance)) {
                    System.out.println("보험 상품의 수정이 완료되었습니다. 수정된 보헝 상품 정보는 아래와 같습니다.");
                    insurance = cInsurance.retrieveById(inputID);
                    printInsuranceDetails(insurance);
                } else System.out.println("* 보험 상품의 수정에 실패하였습니다. *");

                System.out.println("계속 수정하려면 y, 수정을 종료하려면 n를 입력하세요.");
                input = scanner.next();
            }
        }
    }

    public void deleteInsurance() {
        System.out.println("<---- 상품 삭제 ---->");
        System.out.println("보험 상품 목록을 확인한 후 삭제하려면 0, 보험 아이디 입력을 통해 즉시 삭제하려면 1을 입력하세요");
        if (scanner.next().equals("0")) printAllInsurance(this.cInsurance);
        System.out.println("\n삭제하고자 하는 보험 상품의 아이디를 입력해주세요 : ");
        String inputID = new Scanner(System.in).next();
        this.cInsurance.deleteById(inputID);
    }

    private String generateID(String keyword){ return keyword + Integer.toString(this.cInsurance.getMaxID() + 1); }

    private void setInsuranceAttr(Insurance insurance) {

        insurance.setInsuranceID(generateID("IN"));

        scanner.nextLine();
        System.out.println("보험 이름 : ");
        insurance.setInsuranceName(scanner.nextLine());

        System.out.println("보험 종류(차/화재/실손) : ");
        String input = scanner.next();
        if (input.equals("차"))
            insurance.setInsuranceType(InsuranceType.car);
        else if (input.equals("화재"))
            insurance.setInsuranceType(InsuranceType.fire);
        else if (input.equals("실손"))
            insurance.setInsuranceType(InsuranceType.personalHealth);
        else {
            System.out.println("잘못 입력하였습니다.");
            return;
        }

        scanner.nextLine();
        System.out.println("보험 설명 : ");
        insurance.setInsuranceEx(scanner.nextLine());

        System.out.println("가입 제한 연령 : ");
        insurance.setJoinAge(scanner.nextInt());

        System.out.println("기본 보험료 : ");
        insurance.setPremium(scanner.nextInt());

        System.out.println("보장 세부 항목(최대 10개 항목 입력 가능) : ");
        input = "y";
        while (!input.equals("n")) {
            WarrantyInfo warrantyInfo = new WarrantyInfo();
            System.out.println("계약형태(주계약/특약) : ");
            input = scanner.next();
            if (input.equals("주계약")) warrantyInfo.setContractType(ContractType.mainContract);
            else if (input.equals("특약")) warrantyInfo.setContractType(ContractType.specialContract);
            else {
                System.out.println("잘못된 계약형태 정보입니다.");
                return;
            }

            System.out.println("보장 금액(단위:원) : ");
            warrantyInfo.setWarrantyAmount(scanner.nextInt());

            scanner.nextLine();
            System.out.println("보장 조건 : ");
            warrantyInfo.setWarrantyConditions(scanner.nextLine());

            System.out.println("보장 정보");
            warrantyInfo.setWarrantyInfo(scanner.nextLine());

            System.out.println("보장 내용 ");
            warrantyInfo.setWarrantyContent(scanner.nextLine());
            insurance.getWarrantyContent().add(warrantyInfo);

            System.out.println("보장 세부 항목을 더 입력하려면 y, 입력을 끝내려면 n을 입력해주세요");
            input = scanner.next();
        }

        System.out.println("*--- 보험에 적용되는 인수 정책 등록하려면 y, 이후에 하려면 n ---*");
        input = scanner.next();
        if(input.equals("y")){
            AcquisitionPolicy acquisitionPolicy = new AcquisitionPolicy();
            acquisitionPolicy.setAcquisitionPolicyId(generateID("AP"));
            acquisitionPolicy.inputPolicyInfo(insurance.getInsuranceType());
            insurance.setAcquisitionPolicy(acquisitionPolicy);

        } else if(input.equals("n")){
            insurance.setAcquisitionPolicy(null);
        }
    }

    public Insurance inputNewInsuranceInfo(int selectedDetail, Insurance insurance) {
        String input = null;
        switch (selectedDetail) {
            case 1:
                System.out.println("새로운 보험명 : ");
                input = scanner.next();
                insurance.setInsuranceName(input);
                break;
            case 2:
                System.out.println("새로운 보험 설명 : ");
                input = scanner.nextLine();
                insurance.setInsuranceEx(input);
                break;
            case 3:
                System.out.println("새로운 보험 분류(차/화재/실손) : ");
                input = scanner.next();
                if(input.equals("차")) insurance.setInsuranceType(InsuranceType.car);
                else if(input.equals("화재")) insurance.setInsuranceType(InsuranceType.fire);
                else if(input.equals("실손")) insurance.setInsuranceType(InsuranceType.personalHealth);
                break;
            case 4:
                System.out.println("새로운 가입제한연령 : ");
                int newAge = scanner.nextInt();
                insurance.setJoinAge(newAge);
                break;
            case 5:
                System.out.println("새로운 기본 위험률 :");
                double newPeril = scanner.nextDouble();
                insurance.setPeril(newPeril);
                break;
            case 6:
                System.out.println("새로운 기본 보험료 :");
                int newPremium = scanner.nextInt();
                insurance.setPremium(newPremium);
                break;
            case 7:
                System.out.println("새로운 기본 요율 :");
                double newRate = scanner.nextDouble();
                insurance.setRate(newRate);
                break;
        }
        return insurance;
    }

}

