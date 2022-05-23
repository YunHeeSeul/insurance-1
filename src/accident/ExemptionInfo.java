package Practice.InsuranceCompany.Design.src.accident;


import Practice.InsuranceCompany.Design.src.etcEnum.Responsibility;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:49
 */
public class ExemptionInfo {

	private String judgementData;
	private String judgementReason;
	private double paymentRatio;
	private Responsibility responsibility;

	public ExemptionInfo(){

	}

	public void finalize() throws Throwable {

	}
}//end ExemptionInfo