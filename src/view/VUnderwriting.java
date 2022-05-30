package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.customer.Customer;
import Practice.InsuranceCompany.Design.src.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.customer.PotentialCustomer;
import Practice.InsuranceCompany.Design.src.etcEnum.UnderwritingStatus;
import Practice.InsuranceCompany.Design.src.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.insurance.InsuranceListImpl;
import Practice.InsuranceCompany.Design.src.subscription.Subscription;

import java.util.Scanner;

public class VUnderwriting {

    private InsuranceListImpl insuranceList;
    private CustomerListImpl customerList;
    private Scanner scanner;

    public VUnderwriting(){
        this.insuranceList = new InsuranceListImpl();
        this.customerList = new CustomerListImpl();
        this.scanner = new Scanner(System.in);
    }

    public void run(String selectedMenu){

        switch (selectedMenu){
            case "1":
                this.registerPolicy();
                break;
            case "2":
                this.signupUnderwriting();
                break;
        }
    }

    private void registerPolicy() {
        // 인수정책 수립하기
        System.out.println("<---- 인수정책 수립 ---->");

        System.out.println("인수정책을 등록할 보험 상품 아이디를 입력해주세요.(보험 상품 목록을 확인하려면 F 또는 f 입력)");
        String input = this.scanner.next();
        if(input.equals('F') || input.equals('f')) {
            this.insuranceList.printAllInsuranceInfo();
            System.out.println("보험 아이디 입력 : ");
            input = this.scanner.next();
        }

        if(this.insuranceList.getInsuranceList() != null){
            for(Insurance insurance : this.insuranceList.getInsuranceList()){
                if(insurance.getInsuranceID().equals(input)){
                    insurance.addAcquisitionPolicy();
                    //  인수정책 심사 신청 내용 추가(할건지 말건지 묻고 출력문 실행)
                }
            }
        } else
            System.out.println("등록된 보험 상품이 없으므로 인수정책을 등록할 수 없습니다.");

    }

    private void signupUnderwriting() {
        // 계약 인수심사 신청하기
        System.out.println("인수심사를 신청하려는 고객의 ID를 입력하세요.");
        String id = this.scanner.next();

        if(this.customerList.getCustomerList() == null)
            System.out.println("고객 목록이 비어있으므로 인수심사를 신청할 수 없습니다.");
        else{
            // 고객 찾기
            for(Customer customer : this.customerList.getCustomerList()){
                if(id.equals(customer.getCustomerID())) {
                    // 해당 고객의 청약서 중 인수심사 신청할 보험 선택
                    System.out.println(customer.getName() + " 고객님의 가입 청약서는 아래와 같습니다. 인수심사를 신청할 보험의 아이디를 입력해주세요(청약서 참조)");

                    for(Subscription subscription : ((PotentialCustomer) customer).getSubscriptionList()){
                        subscription.printInfo();
                    }

                    String inputID = this.scanner.next();
                    for(Subscription subscription : ((PotentialCustomer) customer).getSubscriptionList()){
                        if(inputID.equals(subscription.getInsuranceID())) {
                            subscription.updateUnderwritingStatus(UnderwritingStatus.applied);  // 청약서의 인수심사 신청 상태를 '신청'으로 변경
                            if(subscription.signUpUnderwriting(this.customerList, this.insuranceList))
                                subscription.updateUnderwritingStatus(UnderwritingStatus.concluded);
                            else
                                subscription.updateUnderwritingStatus(UnderwritingStatus.rejected);
                        }
                    }
                    return;
                }
            }
            System.out.println("입력한 ID의 고객이 존재하지 않습니다.");
        }
    }


}
