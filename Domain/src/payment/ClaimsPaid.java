package Practice.InsuranceCompany.Design.Domain.src.payment;


import Practice.InsuranceCompany.Design.Domain.src.etcEnum.ClaimType;
import Practice.InsuranceCompany.Design.Domain.src.accident.AccidentType;

import java.util.Date;

/**
 * @author ����
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
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
}//end ClaimsPaid