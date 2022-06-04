package Practice.InsuranceCompany.Design.src.model.accident;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;

import java.util.ArrayList;
import java.util.Optional;

public interface AccidentList {

	boolean add(Accident Accident);

	boolean delete(String accidentID);

	Accident getAccidentID(String accidentID);

	Accident getCustomerID(String customerID);

	ArrayList<Accident> getAllList();

	boolean updateAccidentScale(String accidentID, Level accidentScale);

	boolean updateDoingHarm(String accidentID, boolean doingHarm);

	boolean updateExemptionInfo(String exemptionInfoID, ArrayList exemptionContent);

	Optional<Accident> getOptionalAccidentByCustomerId(String customerID);
	Optional<Accident> getOptionalAccidentByAccidentId(String accidentID);
=======
	public boolean add(Accident Accident);

	public boolean delete(String accidentID);

	public Accident getByAccidentId(String accidentID);

	public Accident getByCustomerId(String customerID);

	public boolean updateAccidentScale(String accidentID, Level accidentScale);

	public boolean updateDoingHarm(String accidentID, boolean doingHarm);

	public boolean updateExemptionInfo(String accidentID, ExemptionInfo ExemptionInfo);

	ArrayList<Accident> getAllList();
	Optional<Accident> getOptionalAccidentByCustomerId(String customerID);


}