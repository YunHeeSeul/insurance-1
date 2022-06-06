package Practice.InsuranceCompany.Design.src.enums;

public enum ClaimType {
	visitHospital("내원"),
	dead("사망"),
	hospitalization("입원"),
	repair("수리");

	String detail;
	ClaimType(String detail) {
		this.detail=detail;
	}

	public static ClaimType makeClaimType(String detail){
		if (detail.equals(visitHospital.getDetail())) return visitHospital;
		if (detail.equals(dead.getDetail())) return dead;
		if (detail.equals(hospitalization.getDetail())) return hospitalization;
		if (detail.equals(repair.getDetail())) return repair;
		else return null;
	}

	public String getDetail(){
		return this.detail;
	}
}