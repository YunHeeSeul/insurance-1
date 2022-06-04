package Practice.InsuranceCompany.Design.src.model.policyholder;
import Practice.InsuranceCompany.Design.src.model.customer.Customer;

import java.util.ArrayList;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:50
 */
public class Policyholder extends Customer {

	private boolean acceptedAccidentExistence;
	private AccountInfo accountInfo;
	private ArrayList<DiseaseHistory> diseaseHistory;
	private int ownedBuildingNumber;
	private boolean paymentState;
	private int totalPremiumOfMonth;
	public AccountInfo m_AccountInfo;
	/*** 아래 정보는 잠재 고객 및 가입자 모두에게 필요 ***/
	public DiseaseHistory m_DiseaseHistory;
	public OwnedBuildingInfo m_OwnedBuildingInfo;
	public OwnedCarInfo m_OwnedCarInfo;

	public Policyholder(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param paymentState
	 */
	public void changePaymentState(boolean paymentState){ this.paymentState = paymentState; }

	public boolean getPaymentState(){
		return this.paymentState;
	}
	public int getTotalPremiumOfMonth(){
		return this.totalPremiumOfMonth;
	}

	public void setTotalPremiumOfMonth(int totalPremiumOfMonth) {
		this.totalPremiumOfMonth = totalPremiumOfMonth;
	}

}//end Policyholder