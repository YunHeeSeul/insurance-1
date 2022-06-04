package Practice.InsuranceCompany.Design.src.model.accident;

import Practice.InsuranceCompany.Design.src.etcEnum.CarType;

public enum AccidentType {
	car("자동차"),
	fire("화재"),
	health("상해");

	String detail;
	AccidentType(String detail) {
		this.detail=detail;
	}

	public static AccidentType makeAccidentType(String detail){
		if (detail.equals(car.getDetail())) return car;
		if (detail.equals(fire.getDetail())) return fire;
		if (detail.equals(health.getDetail())) return health;
		else return null;
	}
	public String getDetail(){
		return this.detail;
	}
}