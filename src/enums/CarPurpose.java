package Practice.InsuranceCompany.Design.src.enums;

public enum CarPurpose {
	business("사업용"),
	notBusiness("비사업용");

	String detail;
	CarPurpose(String detail) {
		this.detail=detail;
	}

	public static CarPurpose makeCarPurpose(String detail){
		if (detail.equals(business.getDetail())) return business;
		if (detail.equals(notBusiness.getDetail())) return notBusiness;
		else return null;
	}

	public String getDetail(){
		return this.detail;
	}
}