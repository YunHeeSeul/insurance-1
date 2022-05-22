package Practice.InsuranceCompany.Design.Domain.src.insurance;


/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:49
 */
public class InsuranceListImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;
	public Insurance m_Insurance;

	public InsuranceListImpl(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param Insurance
	 */
	public boolean add(Insurance Insurance){
		return false;
	}

	/**
	 * 
	 * @param insuranceID
	 */
	public boolean delete(String insuranceID){
		return false;
	}

	/**
	 * 
	 * @param insuranceID
	 */
	public Insurance get(String insuranceID){
		return null;
	}

	/**
	 * 
	 * @param insuranceName
	 */
	public Insurance get(String insuranceName){
		return null;
	}

	/**
	 * 
	 * @param insuranceType
	 */
	public Insurance get(insuranceType insuranceType){
		return null;
	}
}//end InsuranceListImpl