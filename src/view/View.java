package Practice.InsuranceCompany.Design.src.view;

import Practice.InsuranceCompany.Design.src.controller.CCustomer;
import Practice.InsuranceCompany.Design.src.controller.CInsurance;
import Practice.InsuranceCompany.Design.src.controller.CSubscription;
import Practice.InsuranceCompany.Design.src.etcEnum.Gender;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.model.customer.CustomerListImpl;
import Practice.InsuranceCompany.Design.src.model.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.model.insurance.InsuranceListImpl;
import Practice.InsuranceCompany.Design.src.model.insurance.InsuranceType;
import Practice.InsuranceCompany.Design.src.model.subscription.Subscription;
import Practice.InsuranceCompany.Design.src.model.subscription.SubscriptionListImpl;

public class View {

    public void run(String menuStr, String subMenuList) {}

    /*** methods for Insurance ***/
    public void printAllInsurance(CInsurance cInsurance) {
        System.out.println("<---- 상품 조회 ---->");
        InsuranceListImpl insuranceList = cInsurance.retrieveAll();
        if (insuranceList.getInsuranceList().size() == 0)
            System.out.println("보험 상품 목록이 비어있습니다.");
        else {
            for (Insurance insurance : insuranceList.getInsuranceList()) {
                printInsuranceDetails(insurance);
                System.out.println("\n");
            }
        }
    }

    public void printInsuranceDetails(Insurance insurance) {
        System.out.println("ID : " + insurance.getInsuranceID());
        System.out.println("보험명 : " + insurance.getInsuranceName());
        System.out.println("보험 종류 : " + insurance.getInsuranceType().name());
        System.out.println("가입제한연령 : " + insurance.getJoinAge() + "세");
        System.out.println("기본 위험률 : " + insurance.getPeril());
        System.out.println("기본 요율 : " + insurance.getRate());
        System.out.println("보험 인가 여부 : " + insurance.isPermission());
        System.out.println("기본 보험료 : " + insurance.getPremium() + "원");
        System.out.println("<보장 정보>");
        for (int i = 0; i < insurance.getWarrantyContent().size(); i++) {
            System.out.println("* 항목" + (i + 1));
            System.out.println("- 보장 정보 : " + insurance.getWarrantyContent().get(i).getWarrantyInfo());
            System.out.println("- 보장 금액 : " + insurance.getWarrantyContent().get(i).getWarrantyAmount());
            System.out.println("- 보장 내용 : " + insurance.getWarrantyContent().get(i).getWarrantyContent());
            System.out.println("- 보장 조건 : " + insurance.getWarrantyContent().get(i).getWarrantyConditions());
        }
        System.out.println("<인수 정책 세부정보>");
        if (insurance.getAcquisitionPolicy() == null)
            System.out.println("인수 정책 정보가 비어있습니다.");
        else {
            System.out.println("- ID : " + insurance.getAcquisitionPolicy().getID());
            if (insurance.getInsuranceType() == InsuranceType.car) {
                System.out.println("- 계약 인수가 가능한 차 정보");
                System.out.println("--- 차 정보 ID : " + insurance.getAcquisitionPolicy().getCarInfoPolicy().getId());
                System.out.println("--- 허용 가능한 최대 사고 횟수 : " + insurance.getAcquisitionPolicy().getCarInfoPolicy().getAccidentNumber());
                System.out.println("--- 허용 가능한 최대 법규 위반 횟수 : " + insurance.getAcquisitionPolicy().getCarInfoPolicy().getAvailableNumOfViolation());
                System.out.println("--- 적합한 차종 : " + insurance.getAcquisitionPolicy().getCarInfoPolicy().getCarType());
                System.out.println("--- 적합한 차 용도 : " + insurance.getAcquisitionPolicy().getCarInfoPolicy().getCarPurpose());
                System.out.println("--- 허용 가능한 최대 배기량(단위:cc) : " + insurance.getAcquisitionPolicy().getCarInfoPolicy().getDisplacement());

            } else if (insurance.getInsuranceType() == InsuranceType.fire) {
                System.out.println("- 계약 인수가 가능한 건물 정보");


            } else if (insurance.getInsuranceType() == InsuranceType.personalHealth) {
                System.out.println("- 계약 인수가 가능한 질환 이력 정보");

            } else {
                System.out.println("보험 종류가 설정되어 있지 않습니다.");
            }
        }
    }

    /*** methods for Customer ***/
    public void printAllCustomer(CCustomer cCustomer) {
        System.out.println("<---- 고객 정보 조회 ---->");
        CustomerListImpl customerList = cCustomer.retrieveAll();
        if (customerList.getCustomerList().size() == 0)
            System.out.println("고객 정보 목록이 비어있습니다.");
        else {
            for (Customer customer : customerList.getCustomerList()) {
                printCustomerDetails(customer);
                System.out.println("\n");
            }
        }
    }

    public void printCustomerDetails(Customer customer) {
        System.out.println("- ID : " + customer.getCustomerID());
        System.out.println("- 성함 : " + customer.getName());
        System.out.println("- 주민등록번호 : " + customer.getResidentRegistrationNumber());
        System.out.println("- 성별 : " + (customer.getGender()== Gender.female?"여성":"남성"));
        System.out.println("- 생년월일 : " + customer.getDateOfBirth());
        System.out.println("- 휴대전화번호 : " + customer.getPhoneNumber());
        System.out.println("- 이메일 : " + customer.getEmailAddress());
        System.out.println("- 자택/회사 주소 : " + customer.getAddress());

        if(customer.getDiseaseHistory() == null) System.out.println("* 고객의 질환 이력 정보가 등록되어 있지 않습니다. *");
        else {
            System.out.println("-- 질환 이력 정보 ID : " + customer.getDiseaseHistory().getId());
            System.out.println("-- 질환명 : " + customer.getDiseaseHistory().getName());
            System.out.println("-- 중증도 : " + customer.getDiseaseHistory().getSeverity().name());
            System.out.println("-- 투병 기간 : " + customer.getDiseaseHistory().getStrugglePeriod() + "개월");
        }

        if(customer.getOwnedBuildingInfo() == null) System.out.println("* 고객소유의 건물 정보가 등록되어 있지 않습니다. *");
        else {
            System.out.println("-- 소유 건물 정보 ID : " + customer.getOwnedBuildingInfo().getId());
            System.out.println("-- 건물 층 수 : " + customer.getOwnedBuildingInfo().getFloorNumber());
            System.out.println("-- 특수 건물 여부 : " + customer.getOwnedBuildingInfo().getSpecializedBuilding());
        }

        if(customer.getOwnedCarInfo() == null) System.out.println("* 고객소유의 차량 정보가 등록되어 있지 않습니다. *");
        else {
            // 구현해야함
        }
    }

    /*** methods for Subscription ***/
    public void printAllSubscription(CSubscription cSubscription) {
        System.out.println("<---- 청약서 정보 조회 ---->");
        SubscriptionListImpl subscriptionList = cSubscription.retrieveAll();
        if (subscriptionList.getSubscriptionList().size() == 0)
            System.out.println("청약서 정보 목록이 비어있습니다.");
        else {
            for (Subscription subscription : subscriptionList.getSubscriptionList()) {
                printSubscriptionDetails(subscription);
                System.out.println("\n");
            }
        }
    }

    public void printSubscriptionDetails(Subscription subscription) {
        System.out.println("- ID : " + subscription.getSubscriptionID());
        System.out.println("- 인수심사 신청 상태 : " + subscription.getUnderwritingStatus().getDetail());
        System.out.println("- 청약서 생성일자 : " + subscription.getDateCreated());
        System.out.println("- 보험 계약 기간 : " + subscription.getInsurancePeriod() + "년");
        System.out.println("- 보험료 : " + subscription.getPremium() + "원");
        System.out.println("- 가입 고객 ID : " + subscription.getCustomerID());
        System.out.println("- 가입 보험 ID : " + subscription.getInsuranceID());
        System.out.println("- 담당 설계사 ID : " + subscription.getInsuranceAgentID());
    }
}