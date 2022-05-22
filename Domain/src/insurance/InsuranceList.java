package Practice.InsuranceCompany.Design.Domain.src.insurance;


/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:49
 */
public interface InsuranceList {

	/**
	 * 
	 * @param Insurance
	 */
	public boolean add(Insurance Insurance);

	/**
	 * 
	 * @param insuranceID
	 */
	public boolean delete(String insuranceID);

	/**
	 * 
	 * @param insuranceID
	 */
	public Insurance get(String insuranceID);

	/**
	 * 
	 * @param insuranceName
	 */
	public Insurance get(String insuranceName);

	/**
	 * 
	 * @param insuranceType
	 */
	public Insurance get(InsuranceType insuranceType);

}