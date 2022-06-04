package Practice.InsuranceCompany.Design.src.model.insurance;


import java.util.ArrayList;
import java.util.Scanner;

public class InsuranceListImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;
	public Insurance m_Insurance;

	public InsuranceListImpl(){
		this.insuranceList = new ArrayList<>();
	}

	public ArrayList<Insurance> getInsuranceList(){ return this.insuranceList; }

	public boolean add(Insurance insurance){
		if(this.insuranceList != null) {
			this.insuranceList.add(insurance);
			return true;
		}
		return false;
	}

	public boolean delete(String insuranceID){
		if(this.insuranceList != null) {
			for (Insurance insurance : this.insuranceList) {
				if (insuranceID.equals(insurance.getInsuranceID())) { this.insuranceList.remove(insurance); }
				return true;
			}
		}
		return false;
	}

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