package Practice.InsuranceCompany.Design.src.etcEnum;

public enum Gender {
	male("남성"),
	female("여성");

	String detail;
	Gender(String detail) {
		this.detail=detail;
	}

	public static Gender makeGender(String detail){
		if (detail.equals(male.getDetail())) return male;
		if (detail.equals(female.getDetail())) return female;
		else return null;
	}

	public String getDetail(){
		return this.detail;
	}
}