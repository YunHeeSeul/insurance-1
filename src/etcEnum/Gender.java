package Practice.InsuranceCompany.Design.src.etcEnum;

public enum Gender {
	male("남성"),
	female("여성");

	String detail;
	Gender(String detail) {
		this.detail=detail;
	}

	public String getDetail(){
		return this.detail;
	}
}