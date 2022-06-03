package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CAcquisitionPolicy;
import Practice.InsuranceCompany.Design.src.controller.CInsurance;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.model.insurance.AcquisitionPolicy;
import Practice.InsuranceCompany.Design.src.model.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.model.insurance.InsuranceListImpl;

import java.util.Scanner;

public class VUnderwriting extends View {

//    private InsuranceListImpl insuranceList;
//    private CustomerListImpl customerList;
    private Scanner scanner;
    private CAcquisitionPolicy cAcquisitionPolicy;
    private CInsurance cInsurance;

    public VUnderwriting(Scanner scanner){
//        this.insuranceList = new InsuranceListImpl();
//        this.customerList = new CustomerListImpl();
        this.scanner = scanner;
        this.cAcquisitionPolicy = new CAcquisitionPolicy();
        this.cInsurance = new CInsurance();
    }

    public void run(){
        System.out.println("----------------------UnderWriting-----------------------");
        System.out.println("(1). 인수정책 추가 (2). 고객 인수심사 신청 (0) 뒤로가기");
        String selectedMenu = scanner.next();

        switch (selectedMenu){
            case "1":
                this.registerPolicy();
                break;
            case "2":
                this.signupUnderwriting();
                break;
            case "0":
                return;
        }
    }

    private String generateID(String keyword){ return keyword + Integer.toString(this.cAcquisitionPolicy.getMaxID() + 1); }

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
        // 계약 인수심사 신청하기
        System.out.println("인수심사를 신청하려는 고객의 ID를 입력하세요.");
        String id = this.scanner.next();

//        if(this.customerList.getCustomerList() == null)
//            System.out.println("고객 목록이 비어있으므로 인수심사를 신청할 수 없습니다.");
//        else{
            // 고객 찾기
//            for(Customer customer : this.customerList.getCustomerList()){
//                if(id.equals(customer.getCustomerID())) {
                    // 해당 고객의 청약서 중 인수심사 신청할 보험 선택
//                    System.out.println(customer.getName() + " 고객님의 가입 청약서는 아래와 같습니다. 인수심사를 신청할 보험의 아이디를 입력해주세요(청약서 참조)");

//                    for(Subscription subscription : ((PotentialCustomer) customer).getSubscriptionList()){
//                        subscription.printInfo();
//                    }
//
//                    String inputID = this.scanner.next();
//                    for(Subscription subscription : ((PotentialCustomer) customer).getSubscriptionList()){
//                        if(inputID.equals(subscription.getInsuranceID())) {
//                            subscription.updateUnderwritingStatus(UnderwritingStatus.applied);  // 청약서의 인수심사 신청 상태를 '신청'으로 변경
//                            if(subscription.signUpUnderwriting(this.customerList, this.insuranceList))
//                                subscription.updateUnderwritingStatus(UnderwritingStatus.concluded);
//                            else
//                                subscription.updateUnderwritingStatus(UnderwritingStatus.rejected);
//                        }
//                    }
                    return;
                }
//            }
//            System.out.println("입력한 ID의 고객이 존재하지 않습니다.");
//        }
//    }



}
