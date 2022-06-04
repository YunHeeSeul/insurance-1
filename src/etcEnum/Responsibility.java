package Practice.InsuranceCompany.Design.src.etcEnum;

public enum Responsibility {
	notResponsible("면책"),
	responsible("부책");

	String detail;
	Responsibility(String detail) {
		this.detail=detail;
	}

	public String getDetail(){
		return this.detail;
	}
}