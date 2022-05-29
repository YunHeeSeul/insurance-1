package Practice.InsuranceCompany.Design.src.payment;

import Practice.InsuranceCompany.Design.src.customer.Customer;

public class CancellationReturn extends Payment {

	private String cancellationReason;

	public String getCancellationReason() {
		return cancellationReason;
	}

	// 해약 환급금
	public CancellationReturn(){


	}

	@Override
	public boolean setPaymentInfo() {
		return false;
	}

	@Override
	public int calculatePayment() {
		int condition = (int)(Math.random() * 100) + 1;
		int basePayment = 10000;

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
		System.out.println("=========== 해약환급금 지급 안내서 =================");

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
		System.out.println("지급금(해약환급금) 신청 정보");
		System.out.println("--------------------------------------------------");
		System.out.println("해약 사유: " + this.getCancellationReason() +"\n");

		System.out.println("--------------------------------------------------");
		System.out.println("지급금(해약환급금) 신청 결과");
		System.out.println("--------------------------------------------------");

		if(calculatePayment() == 0){
			System.out.println("해약환급금 지급되지 않습니다.");
		}
		else{
			System.out.println(this.calculatePayment() + "원 지급 예정입니다.");
		}
		System.out.println("--------------------------------------------------");

	}
}//end CancellationReturn