package Practice.InsuranceCompany.Design.src.enums;

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

	public static Department makeDepartment(String detail){
		if (detail.equals(contractManagement.getDetail())) return contractManagement;
		if (detail.equals(sales.getDetail())) return sales;
		if (detail.equals(UW.getDetail())) return UW;
		if (detail.equals(development.getDetail())) return development;
		if (detail.equals(indemnification.getDetail())) return indemnification;
		else return null;
	}

	public String getDetail(){
		return this.detail;
	}
}