package Practice.InsuranceCompany.Design.src.model.insurance;

public enum InsuranceType {
	car("자동차"),
	personalHealth("실손"),
	fire("화재");

	public static InsuranceType makeInsuranceType(String info){
		if(info.equals(InsuranceType.car.detail)) return InsuranceType.car;
		else if(info.equals(InsuranceType.personalHealth.detail)) return InsuranceType.personalHealth;
		else if(info.equals(InsuranceType.fire.detail)) return InsuranceType.fire;
		else return null;
	}

	private String detail;
	InsuranceType(String detail) {
		this.detail=detail;
	}

	public String getDetail(){
		return this.detail;
	}
}