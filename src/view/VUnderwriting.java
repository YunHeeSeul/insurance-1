package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CAcquisitionPolicy;
import Practice.InsuranceCompany.Design.src.controller.CCustomer;
import Practice.InsuranceCompany.Design.src.controller.CInsurance;
import Practice.InsuranceCompany.Design.src.controller.CSubscription;
import Practice.InsuranceCompany.Design.src.etcEnum.UnderwritingStatus;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.model.insurance.AcquisitionPolicy;
import Practice.InsuranceCompany.Design.src.model.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.model.subscription.Subscription;

import java.util.ArrayList;
import java.util.Scanner;

public class VUnderwriting extends View {

    private Scanner scanner;
    private CAcquisitionPolicy cAcquisitionPolicy;
    private CInsurance cInsurance;
    private CCustomer cCustomer;
    private CSubscription cSubscription;

    public VUnderwriting(Scanner scanner){
        this.scanner = scanner;
        this.cAcquisitionPolicy = new CAcquisitionPolicy();
        this.cInsurance = new CInsurance();
        this.cCustomer = new CCustomer();
        this.cSubscription = new CSubscription();
    }

    public void run(){
        System.out.println("---------------------- UnderWriting -----------------------");
        System.out.println("(1). 인수정책 추가 (2). 고객 인수심사 신청 (3). 고객 인수심사 수행  (0) 뒤로가기");
        String selectedMenu = scanner.next();

        switch (selectedMenu){
            case "1":
                this.registerPolicy();
                break;
            case "2":
                this.signupUnderwriting();
                break;
            case "3":
                this.executeUnderwriting();
                break;
            case "0":
                return;
        }
    }

    private String generateID(String keyword){ return keyword + (this.cAcquisitionPolicy.getMaxID() + 1); }

    private void registerPolicy() {
        System.out.println("인수정책을 등록할 보험 상품 아이디를 입력해주세요.(보험 상품 목록을 확인하려면 0 입력)");
        String input = "";
        if (scanner.next().equals("0")) printAllInsurance(this.cInsurance);

        System.out.println("보험 아이디 입력 : ");
        input = this.scanner.next();
        Insurance insurance = cInsurance.retrieveById(input);

        if(insurance.getAcquisitionPolicy() == null) {

            AcquisitionPolicy acquisitionPolicy = new AcquisitionPolicy();
            acquisitionPolicy.setAcquisitionPolicyId(generateID("AP"));

            System.out.println("보험 인수에 적용되는 허용 가능한 최댓값을 입력하세요");
            acquisitionPolicy.inputPolicyInfo(insurance.getInsuranceType());
            insurance.setAcquisitionPolicy(acquisitionPolicy);

            if(insurance.getAcquisitionPolicy() != null)
                cAcquisitionPolicy.addAcquisitionPolicy(insurance.getAcquisitionPolicy());
            insurance.setAcquisitionPolicy(acquisitionPolicy);
            cInsurance.updateById(input, insurance);
        } else {
            System.out.println("보험에 인수 정책이 존재하므로, 인수 정책 등록이 불가능합니다.");
        }
    }

    private void signupUnderwriting() {
        System.out.println("고객 목록을 확인한 후, 인수심사를 신청하려면 0을, 고객 ID 입력을 통해 즉시 신청하려면 1을 입력해주세요.");
        String input = this.scanner.next();

        if (input.equals("0")) printAllCustomer(this.cCustomer);
        System.out.println("인수심사를 신청하려는 고객의 ID를 입력해주세요. (종료하려면 x 입력)");
        input = this.scanner.next();

        if(input.equals("x")){
            System.out.println("인수심사 신청을 하지 않고 종료합니다.");
            return;
        }
        Customer customer = this.cCustomer.retrieveById(input);
        if (customer == null) System.out.println("입력하신 ID의 고객이 존재하지 않습니다.");
        else {
            System.out.println(customer.getName() + " 고객님의 가입 청약서는 아래와 같습니다. 인수심사를 신청할 청약서의 ID를 입력해주세요. (종료하려면 x 입력)");
            if(input.equals("x")){
                System.out.println("인수심사 신청을 하지 않고 종료합니다.");
                return;
            }
            ArrayList<Subscription> subscriptions = this.cSubscription.getAllSubscriptionOfCustomerByID(customer.getCustomerID());
            for (Subscription subscription : subscriptions) {
                printSubscriptionDetails(subscription);
            }

            input = this.scanner.next();
            Subscription subscription = this.cSubscription.retrieveById(input);
            if (subscription == null) System.out.println("입력하신 ID의 청약서가 존재하지 않습니다.");
            else {
                subscription.setUnderwritingStatus(UnderwritingStatus.applied);
                if (this.cSubscription.updateById(input, subscription)) {
                    System.out.println("입력하신 ID의 청약서 인수심사 신청이 완료되었습니다. 청약서의 정보는 아래와 같습니다.");
                    this.cSubscription.retrieveById(input).printInfo();
                } else System.out.println("인수심사 신청에 실패하였습니다.");
            }
        }
    }

    private void executeUnderwriting() {
        System.out.println("아래 목록을 참고하여 인수심사를 수행할 청약서의 ID를 입력하세요");
        this.printAllSubscription(this.cSubscription);
        String id = scanner.next();
        Subscription subscription = this.cSubscription.retrieveById(id);

        if(subscription == null){
            System.out.println("해당 ID의 청약서가 존재하지 않습니다.");
            return;
        } else {
            System.out.println("선택된 청약서의 정보는 아래와 같습니다. 인수심사를 진행할까요?(y/n)");
            printSubscriptionDetails(subscription);

            String input = scanner.next();
            if (input.equals("y")) {
                subscription.setUnderwritingStatus(UnderwritingStatus.concluded);
                this.cSubscription.updateById(id, subscription);
                System.out.println("인수를 허가합니다. 변경된 청약서 정보는 다음과 같습니다.");
                printSubscriptionDetails(this.cSubscription.retrieveById(id));
            } else {
                subscription.setUnderwritingStatus(UnderwritingStatus.rejected);
                this.cSubscription.updateById(id, subscription);
                System.out.println("인수를 불허가합니다. 변경된 청약서 정보는 다음과 같습니다.");
                printSubscriptionDetails(this.cSubscription.retrieveById(id));
            }
        }
    }


}
