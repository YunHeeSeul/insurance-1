package Practice.InsuranceCompany.Design.src.model.customer;

import Practice.InsuranceCompany.Design.src.etcEnum.Gender;

public enum CustomerType {
	subscriber("가입자"),
	interested("관심자");

	String detail;
	CustomerType(String detail) {
		this.detail=detail;
	}

	public static CustomerType makeCustomerType(String detail){
		if (detail.equals(subscriber.getDetail())) return subscriber;
		if (detail.equals(interested.getDetail())) return interested;
		else return null;
	}

	public String getDetail(){
		return this.detail;
	}
}