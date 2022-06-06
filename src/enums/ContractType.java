package Practice.InsuranceCompany.Design.src.enums;

public enum ContractType {
	mainContract("주계약"),
	specialContract("특약");

	String detail;
	ContractType(String detail) {
		this.detail=detail;
	}

	public static ContractType makeContractType(String detail){
		if (detail.equals(mainContract.getDetail())) return mainContract;
		if (detail.equals(specialContract.getDetail())) return specialContract;
		else return null;
	}
	public String getDetail(){
		return this.detail;
	}
}