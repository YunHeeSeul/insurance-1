package Practice.InsuranceCompany.Design.src.model.insurance;

public enum InsuranceType {
	car,
	personalHealth,
	fire;

	public InsuranceType makeInsuranceType(String info){
		if(info.equals(InsuranceType.car)) return InsuranceType.car;
		else if(info.equals(InsuranceType.personalHealth)) return InsuranceType.personalHealth;
		else if(info.equals(InsuranceType.fire)) return InsuranceType.fire;
		else return null;
	}
}