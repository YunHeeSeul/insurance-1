
// 보험 상품 관리 메뉴에 관한 View 정의

package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.contract.ContractType;
import Practice.InsuranceCompany.Design.src.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.insurance.InsuranceListImpl;
import Practice.InsuranceCompany.Design.src.insurance.InsuranceType;
import Practice.InsuranceCompany.Design.src.insurance.WarrantyInfo;

import java.util.Scanner;

public class VInsurance {

    private InsuranceListImpl insuranceList;

    public VInsurance(){
        this.insuranceList = new InsuranceListImpl();
    }

    public void run(String selectedMenu){
        switch (selectedMenu){
            case "1":
                this.getInsuranceInfo();
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
        }
    }

    public void getInsuranceInfo(){
        System.out.println("<---- 상품 조회 ---->");
        if(this.insuranceList.getInsuranceList() == null ||
            this.insuranceList.getInsuranceList().size() == 0) {
            System.out.println("보험 상품 목록이 비어있으므로 조회가 불가능합니다. 메뉴로 돌아갑니다.");
        } else
            this.insuranceList.printAllInsuranceInfo();
    }
    public void addInsurance(){
        System.out.println("<---- 상품 등록 ---->");
        Insurance insurance = new Insurance();
        setInsuranceAttr(insurance);
        this.insuranceList.add(insurance);

        System.out.println("새로 추가되는 보험 정보는 아래와 같습니다.");
        insurance.printInsuranceDetails();
    }
    public void updateInsurance(){
        System.out.println("<---- 상품 수정 ---->");
        System.out.println("보험 상품 목록을 확인한 후 수정할 상품을 선택하려면 0, 즉시 보험 아이디 입력을 통해 선택하려면 1을 입력하세요");

        if(this.insuranceList != null) {
            if(new Scanner(System.in).nextInt() == 0)
                this.insuranceList.printAllInsuranceInfo();
            System.out.println("\n수정하고자 하는 보험 상품의 아이디를 입력해주세요 : ");
            String inputID = new Scanner(System.in).next();
            if (this.insuranceList.checkValidationID(inputID)) {
                if (this.insuranceList.update(inputID)) {
                    System.out.println("보험 상품의 수정이 완료되었습니다. 수정된 보헝 상품 정보는 아래와 같습니다.");
                    this.insuranceList.get(inputID).printInsuranceDetails();
                } else
                    System.out.println("보험 상품의 수정에 실패하였습니다.");
            } else
                System.out.println("입력하신 아이디의 보험 상품이 존재하지 않습니다.");
        } else System.out.println("보험 상품 목록이 비어있습니다.");
    }
    public void deleteInsurance(){
        System.out.println("<---- 상품 삭제 ---->");
        System.out.println("보험 상품 목록을 확인한 후 삭제하려면 0, 보험 아이디 입력을 통해 즉시 삭제하려면 1을 입력하세요");
        if(new Scanner(System.in).nextInt() == 0)
            this.insuranceList.printAllInsuranceInfo();
        System.out.println("\n삭제하고자 하는 보험 상품의 아이디를 입력해주세요 : ");
        String inputID = new Scanner(System.in).next();
        if(this.insuranceList.checkValidationID(inputID))
            this.insuranceList.delete(inputID);
        else
            System.out.println("입력하신 아이디의 보험 상품이 존재하지 않습니다.");

    }

    private void setInsuranceAttr(Insurance insurance){
        Scanner scanner = new Scanner(System.in);

        System.out.println("보험 이름 : ");
        insurance.setInsuranceName(scanner.nextLine());

        System.out.println("보험 종류(차/화재/실손) : ");
        String input = scanner.next();
        if(input.equals("차"))
            insurance.setInsuranceType(InsuranceType.car);
        else if(input.equals("화재"))
            insurance.setInsuranceType(InsuranceType.fire);
        else if(input.equals("실손"))
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
        while(!input.equals("n")){
            WarrantyInfo warrantyInfo = new WarrantyInfo();

            System.out.println("계약형태(주계약/특약) : ");
            input = scanner.next();
            if(input.equals("주계약")) warrantyInfo.setContractType(ContractType.mainContract);
            else if(input.equals("특약")) warrantyInfo.setContractType(ContractType.specialContract);
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

            System.out.println("보장 내용 : ");
            warrantyInfo.setWarrantyContent(scanner.nextLine());

            insurance.getWarrantyContent().add(warrantyInfo);

            System.out.println("보장 세부 항목을 더 입력하려면 y, 입력을 끝내려면 n을 입력해주세요");
            input = scanner.next();
        }
    }

}
