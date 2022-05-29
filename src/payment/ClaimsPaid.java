package Practice.InsuranceCompany.Design.src.payment;


import Practice.InsuranceCompany.Design.src.customer.Customer;
import Practice.InsuranceCompany.Design.src.etcEnum.ClaimType;
import Practice.InsuranceCompany.Design.src.accident.AccidentType;

import java.util.Date;

public class ClaimsPaid extends Payment {

	private String accidentCircumstance;
	private String accidentDateTime;
	private String accidentPlace;
	private AccidentType accidentType;
	private ClaimType claimReason;
	private String diseaseName;

	// 보험금
	public ClaimsPaid(){

	}

	public String getAccidentDateTime() {
		return accidentDateTime;
	}

	public void setAccidentDateTime(String accidentDateTime) {
		this.accidentDateTime = accidentDateTime;
	}

	public String getAccidentPlace() {
		return accidentPlace;
	}

	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}

	public AccidentType getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(AccidentType accidentType) {
		this.accidentType = accidentType;
	}

	public ClaimType getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(ClaimType claimReason) {
		this.claimReason = claimReason;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getAccidentCircumstance() {
		return accidentCircumstance;
	}

	public void setAccidentCircumstance(String accidentCircumstance) {
		this.accidentCircumstance = accidentCircumstance;
	}

	@Override
	public boolean setPaymentInfo() {
		System.out.println("사고 일시 : ");
		return false;
	}

	@Override
	public int calculatePayment() {
		int condition = (int)(Math.random() * 100) + 1;
		int basePayment = 10000;

		if(this.accidentType == AccidentType.car){
			basePayment = 15000;
		}
		else if(this.accidentType == AccidentType.fire){
			basePayment = 3000000;
		}

		if(condition < 20){
			return 0;
		}
		else if(20 <= condition  && condition < 60){
			return (int) (basePayment * condition * 0.8);
		}
		else{
			return basePayment * condition;
		}
	}

	@Override
	public void sendPaymentGuide(Customer customer) {
		System.out.println("=========== 보험금 지급 안내서 =================");

		System.out.println("--------------------------------------------------");
		System.out.println("고객 정보");
		System.out.println("--------------------------------------------------");

		System.out.println("고객 주소: " + customer.getAddress());
		System.out.println("고객 주민등록번호"+ customer.getResidentRegistrationNumber());
		System.out.println("고객 전화번호: " + customer.getPhoneNumber());
		System.out.println("고객 이메일: " + customer.getEmailAddress());
		System.out.println("고객 생년월일: " + customer.getDateOfBirth());
		System.out.println("고객 이름: " + customer.getName());
		System.out.println("고객 성별: " + customer.getGender());

		System.out.println("--------------------------------------------------");
		System.out.println("지급금(보험금) 신청 정보");
		System.out.println("--------------------------------------------------");
		System.out.println("사고 상황: " + this.getAccidentCircumstance());
		System.out.println("사고 일자: " + this.getAccidentDateTime());
		System.out.println("사고 장소: "+ this.getAccidentPlace());
		System.out.println("병명: " + this.getDiseaseName());
		System.out.println("지급 신청 사유" +this.getClaimReason());
		System.out.println("사고 타입: " + this.getAccidentType());

		System.out.println("--------------------------------------------------");
		System.out.println("지급금(보험금) 신청 결과");
		System.out.println("--------------------------------------------------");

		if(calculatePayment() == 0){
			System.out.println("보험금이 지급되지 않습니다.");
		}
		else{
			System.out.println(this.calculatePayment() + "원 지급 예정입니다.");
		}
		System.out.println("--------------------------------------------------");
	}
}//end ClaimsPaid