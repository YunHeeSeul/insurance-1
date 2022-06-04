package Practice.InsuranceCompany.Design.src.model.customer;

public enum CustomerType {
	subscriber("가입자"),
	interested("관심자");

	String detail;
	CustomerType(String detail) {
		this.detail=detail;
	}

	public String getDetail(){
		return this.detail;
	}
}