package Practice.InsuranceCompany.Design.src.etcEnum;

public enum Responsibility {
	notResponsible("면책"),
	responsible("부책");

	String detail;
	Responsibility(String detail) {
		this.detail=detail;
	}

	public static Responsibility makeResponsibility(String detail){
		if (detail.equals(notResponsible.getDetail())) return notResponsible;
		if (detail.equals(responsible.getDetail())) return responsible;
		else return null;
	}

	public String getDetail(){
		return this.detail;
	}
}