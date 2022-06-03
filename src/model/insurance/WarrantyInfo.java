package Practice.InsuranceCompany.Design.src.model.insurance;


//import Practice.InsuranceCompany.Design.src.model.contract.ContractType;

import Practice.InsuranceCompany.Design.src.model.contract.ContractType;

public class WarrantyInfo {

	private ContractType contractType;
	private int warrantyAmount;
	private String warrantyConditions;
	private String warrantyContent;
	private String warrantyInfo;

	public WarrantyInfo(){

	}

	public ContractType getContractType() {
		return contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	public int getWarrantyAmount() {
		return warrantyAmount;
	}

	public void setWarrantyAmount(int warrantyAmount) {
		this.warrantyAmount = warrantyAmount;
	}

	public String getWarrantyConditions() {
		return warrantyConditions;
	}

	public void setWarrantyConditions(String warrantyConditions) {
		this.warrantyConditions = warrantyConditions;
	}

	public String getWarrantyContent() {
		return warrantyContent;
	}

	public void setWarrantyContent(String warrantyContent) {
		this.warrantyContent = warrantyContent;
	}

	public String getWarrantyInfo() {
		return warrantyInfo;
	}

	public void setWarrantyInfo(String warrantyInfo) {
		this.warrantyInfo = warrantyInfo;
	}
}//end WarrantyInfo