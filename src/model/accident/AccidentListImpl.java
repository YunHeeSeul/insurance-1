package Practice.InsuranceCompany.Design.src.model.accident;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;

import java.util.ArrayList;
import java.util.Optional;

public class AccidentListImpl implements AccidentList {

	public ArrayList<Accident> accidentList;

	public AccidentListImpl(){
		this.accidentList = new ArrayList<>();
	}

	@Override
	public boolean add(Accident accident){
		this.accidentList.add(accident);
		return true;
	}

	@Override
	public boolean delete(String accidentID){
		for(Accident accident : this.accidentList) {
			if (accident.getAccidentID().equals(accidentID))
				return this.accidentList.remove(accident);
		}
		return false;
	}

	@Override
	public Accident getAccidentID(String accidentID){
		for(Accident accident : this.accidentList) {
			if (accident.getAccidentID().equals(accidentID))
				return accident;
		}
		return null;
	}
	@Override
	public Accident getCustomerID(String customerID){
		for(Accident accident : this.accidentList) {
			if (accident.getCustomerID().equals(customerID))
				return accident;
		}
		return null;
	}



	@Override
	public boolean updateAccidentScale(String accidentID, Level accidentScale){
		for(Accident accident : this.accidentList) {
			if (accident.getAccidentID().equals(accidentID)){
				accident.setAccidentScale(accidentScale);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateDoingHarm(String accidentID, boolean doingHarm){
		for(Accident accident : this.accidentList) {
			if (accident.getAccidentID().equals(accidentID)){
				accident.setDoingHarm(doingHarm);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateExemptionInfo(String exemptionInfoID, ArrayList exemptionContent){
		for(Accident accident : this.accidentList) {
			if (accident.getExemptionInfoID().equals(exemptionInfoID)){
				accident.setExemptionContent(exemptionContent);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Accident> getAllList() {
		return this.accidentList;
	}

	@Override
	public Optional<Accident> getOptionalAccidentByCustomerId(String customerID) {

		return Optional.empty();
	}

	@Override
	public Optional<Accident> getOptionalAccidentByAccidentId(String accidentID) {
		return Optional.empty();
	}
}//end AccidentListImpl