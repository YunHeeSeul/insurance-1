package Practice.InsuranceCompany.Design.src.etcEnum;


/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
public enum UnderwritingStatus {
	applied("신청"),
	notApplied("미신청"),
	concluded("체결"),
	rejected("반려");

	private String detail;
	UnderwritingStatus(String detail){ this.detail = detail; }
	public String getDetail(){ return this.detail; }
}