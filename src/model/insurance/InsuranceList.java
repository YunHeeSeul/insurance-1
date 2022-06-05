package Practice.InsuranceCompany.Design.src.model.insurance;

import java.util.ArrayList;

public interface InsuranceList {

	ArrayList<Insurance> getInsuranceList();

	boolean add(Insurance Insurance);

	boolean delete(String insuranceID);

	Insurance get(String insuranceID);

	boolean update(String insuranceID);

}