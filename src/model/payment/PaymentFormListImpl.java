package Practice.InsuranceCompany.Design.src.model.payment;
import Practice.InsuranceCompany.Design.src.controller.CContract;
import Practice.InsuranceCompany.Design.src.model.contract.Contract;

import java.util.ArrayList;

public class PaymentFormListImpl implements PaymentFormList {

	private CContract cContract = new CContract();
	private ArrayList<PaymentForm> paymentFormList;

	public PaymentFormListImpl(){
		this.paymentFormList=new ArrayList<>();
	}

	public boolean add(PaymentForm paymentForm){
		this.paymentFormList.add(paymentForm);
		return true;
	}

	public boolean delete(String paymentFormId){
		for(PaymentForm paymentForm : this.paymentFormList) {
			if (paymentForm.getPaymentFormId().equals(paymentFormId))
				return this.paymentFormList.remove(paymentForm);
		}
		return false;
	}

	public void printAllPaymentForm() {
		System.out.println("(제지급금 신청서 고유번호) (제지급금 신청 유형) (고객 고유번호) (보험 고유번호) (보험료)");
		for(PaymentForm paymentForm: this.paymentFormList){

			Contract contract = cContract.getContractById(paymentForm.getContractID());
			System.out.println(paymentForm.getPaymentFormInfo(contract));
		}
	}

	public int getSize() {
		return this.paymentFormList.size();
	}
}//end PaymentFormListImpl