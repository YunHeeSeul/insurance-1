package Practice.InsuranceCompany.Design.src.etcEnum;

public enum Department {
	contractManagement("상품계약관리"),
	sales("영업"),
	UW("UW"),
	development("상품개발"),
	indemnification("보상");

	String detail;
	Department(String detail) {
		this.detail=detail;
	}

	public String getDetail(){
		return this.detail;
	}
}