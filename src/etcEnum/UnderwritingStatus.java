package Practice.InsuranceCompany.Design.src.etcEnum;

import Practice.InsuranceCompany.Design.src.model.contract.ContractType;

public enum UnderwritingStatus {
	applied("신청"),
	notApplied("미신청"),
	concluded("체결"),
	rejected("반려"),
	completed("완료");

	private String detail;
	UnderwritingStatus(String detail){ this.detail = detail; }

	public static UnderwritingStatus makeUnderwritingStatus(String detail){
		if (detail.equals(applied.getDetail())) return applied;
		if (detail.equals(notApplied.getDetail())) return notApplied;
		if (detail.equals(concluded.getDetail())) return concluded;
		if (detail.equals(rejected.getDetail())) return rejected;
		if (detail.equals(completed.getDetail())) return completed;
		else return null;
	}

	public String getDetail(){ return this.detail; }
}