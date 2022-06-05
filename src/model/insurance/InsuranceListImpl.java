package Practice.InsuranceCompany.Design.src.model.insurance;


import java.util.ArrayList;

public class InsuranceListImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;

	public InsuranceListImpl(){
		this.insuranceList = new ArrayList<>();
	}

	@Override
	public ArrayList<Insurance> getInsuranceList(){ return this.insuranceList; }

	@Override
	public boolean add(Insurance insurance){
		if(this.insuranceList != null) {
			this.insuranceList.add(insurance);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String insuranceID){
		if(this.insuranceList != null) {
			for (Insurance insurance : this.insuranceList) {
				if (insuranceID.equals(insurance.getInsuranceID())) { this.insuranceList.remove(insurance); }
				return true;
			}
		}
		return false;
	}

	@Override
	public Insurance get(String insuranceID){
		if(this.insuranceList != null) {
			for (Insurance insurance : this.insuranceList)
				if (insuranceID.equals(insurance.getInsuranceID())) return insurance;
		}
		return null;
	}

	@Override
	public boolean update(String insuranceID) {
		return false;
	}

}//end InsuranceListImpl