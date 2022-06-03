package Practice.InsuranceCompany.Design.src.model.payment;

import Practice.InsuranceCompany.Design.src.etcEnum.ClaimType;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentType;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;

import java.util.Scanner;

// 보험금
public class ClaimsPaid extends Payment {

	@Override
	public void setPaymentInfo(Scanner scn) {

		System.out.println("사고 일시를 입력하세요 : ");
		String accidentDateTime = scn.nextLine();

		while(accidentDateTime.isEmpty()){
			System.out.println("사고 일시를 다시 입력하세요 : ");
		}

		this.accidentDateTime = accidentDateTime;

		///////////////////////////////////////////////////////

		System.out.println("사고 상황을 입력하세요 : ");
		String accidentCircumstance = scn.nextLine();

		while(accidentCircumstance.isEmpty()){
			System.out.println("사고 상황을 다시 입력하세요 : ");
		}

		this.accidentCircumstance = accidentCircumstance;

		///////////////////////////////////////////////////////
		System.out.println("사고 타입을 선택하세요 : ");
		System.out.println("(1) 자동차 사고 (2) 화재 사고 (3) 질병 사고");
		int select = scn.nextInt();

		while(select == 0){
			System.out.println("사고 타입을 다시 선택하세요 : ");
		}

		switch (select){
			case 1:
				this.accidentType = AccidentType.car;
				break;
			case 2:
				this.accidentType = AccidentType.fire;
				break;
			case 3:
				this.accidentType = AccidentType.health;

		}

		//////////////////////////////////////////////////

		System.out.println("사고 장소를 입력하세요 : ");
		String accidentPlace = scn.nextLine();

		while(accidentPlace.isEmpty()){
			System.out.println("사고 장소를 다시 입력하세요 : ");
		}

		this.accidentPlace = accidentPlace;

		////////////////////////////////////////////////////

		System.out.println("상해 혹은 질병명을 입력하세요 : ");
		String diseaseName = scn.nextLine();

		while(diseaseName.isEmpty()){
			System.out.println("상해 혹은 질병명을 다시 입력하세요 : ");
		}

		this.diseaseName = diseaseName;

		//////////////////////////////////////////////////////

		System.out.println("청구 사유를 선택하세요 : ");
		System.out.println("(1) 사망 (2) 입원 (3) 수리 (4) 검진 / 진료");
		int selectClaimReason = scn.nextInt();

		while(selectClaimReason == 0){
			System.out.println("청구 사유를 다시 선택하세요 : ");
		}

		switch (selectClaimReason){
			case 1:
				this.claimReason = ClaimType.dead;
				break;
			case 2:
				this.claimReason = ClaimType.hospitalization;
				break;
			case 3:
				this.claimReason = ClaimType.repair;
				break;
			case 4:
				this.claimReason = ClaimType.visitHospital;
				break;
		}
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




}