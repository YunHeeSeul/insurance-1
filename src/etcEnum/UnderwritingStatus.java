package Practice.InsuranceCompany.Design.src.etcEnum;

public enum UnderwritingStatus {
	applied("신청"),
	notApplied("미신청"),
	concluded("체결"),
	rejected("반려"),
	completed("완료");

	private String detail;
	UnderwritingStatus(String detail){ this.detail = detail; }
	public String getDetail(){ return this.detail; }
}