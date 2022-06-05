package Practice.InsuranceCompany.Design.src.model.payment;
import java.util.ArrayList;

public class PaymentFormListImpl implements PaymentFormList {

	private ArrayList<PaymentForm> paymentFormList;

	public PaymentFormListImpl(){
		this.paymentFormList=new ArrayList<>();
	}

	@Override
	public boolean add(PaymentForm paymentForm){
		this.paymentFormList.add(paymentForm);
		return true;
	}

	@Override
	public boolean delete(String paymentFormId){
		for(PaymentForm paymentForm : this.paymentFormList) {
			if (paymentForm.getPaymentFormId().equals(paymentFormId))
				return this.paymentFormList.remove(paymentForm);
		}
		return false;
	}

}//end PaymentFormListImpl