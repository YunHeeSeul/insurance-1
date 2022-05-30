package Practice.InsuranceCompany.Design.src.insurance;

public interface InsuranceList {

	boolean add(Insurance Insurance);

	boolean delete(String insuranceID);

	Insurance get(String insuranceID);

	boolean update(String insuranceID);

}