package Practice.InsuranceCompany.Design.Domain.src.insurance;

public interface InsuranceList {

	boolean add(Insurance Insurance);

	boolean delete(String insuranceID);

	Insurance get(String insuranceID);

}