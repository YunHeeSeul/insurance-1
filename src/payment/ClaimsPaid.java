package Practice.InsuranceCompany.Design.src.payment;


import Practice.InsuranceCompany.Design.src.etcEnum.ClaimType;
import Practice.InsuranceCompany.Design.src.accident.AccidentType;

import java.util.Date;

public class ClaimsPaid extends Payment {

	private String accidentCircumstance;
	private Date accidentDateTime;
	private String accidentPlace;
	private AccidentType accidentType;
	private ClaimType claimReason;
	private String diseaseName;

	public ClaimsPaid(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public boolean setPaymentInfo() {
		System.out.println("사고 일시 : ");
		return false;
	}

	@Override
	public int calculatePayment() {
		return 0;
	}

	@Override
	public boolean sendPaymentGuide(String customerID) {
		System.out.println("지급안내서를 전송할 고객 정보를 입력해주세요.");
		int result=(int)(Math.random()*10);
		if(result>0.2){

		}
		return false;
	}
}//end ClaimsPaid