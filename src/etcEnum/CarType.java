package Practice.InsuranceCompany.Design.src.etcEnum;

public enum CarType {
	passenger("승용차"),
	lorry("화물차"),
	van("승합차");

	String detail;
	CarType(String detail) {
		this.detail=detail;
	}

	public static CarType makeCarType(String detail){
		if (detail.equals(passenger.getDetail())) return passenger;
		if (detail.equals(lorry.getDetail())) return lorry;
		if (detail.equals(van.getDetail())) return van;
		else return null;
	}

	public String getDetail(){
		return this.detail;
	}
}