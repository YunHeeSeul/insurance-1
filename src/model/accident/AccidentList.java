package Practice.InsuranceCompany.Design.src.model.accident;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;

import java.util.ArrayList;

public interface AccidentList {

	boolean add(Accident accident);

	boolean delete(String accidentID);

	ArrayList<Accident> getAllList();

	boolean updateAccidentScale(String accidentID, Level accidentScale);

	boolean updateDoingHarm(String accidentID, boolean doingHarm);

	boolean updateExemptionInfo(String exemptionInfoID, ArrayList exemptionContent);

	public Accident getByAccidentId(String accidentID);

	public Accident getByCustomerId(String customerID);


}