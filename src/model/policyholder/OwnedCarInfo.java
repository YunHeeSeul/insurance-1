package Practice.InsuranceCompany.Design.src.model.policyholder;


import Practice.InsuranceCompany.Design.src.etcEnum.CarPurpose;
import Practice.InsuranceCompany.Design.src.etcEnum.CarType;

import java.util.ArrayList;
import java.util.Scanner;

public class OwnedCarInfo {

	private String id;
	private int accidentNumber;
	private CarType carType;
	private CarPurpose carPurpose;
	private int displacement;
	private ArrayList<violationInfo> violationHistory;
	private int availableNumOfViolation;	// 허용 가능한 법규 위반 횟수
	public violationInfo m_violationInfo;

	public OwnedCarInfo(){}

	public String getId() { return this.id; }
	public int getAccidentNumber(){ return this.accidentNumber; }

	public void setId(String id) {
		this.id = id;
	}

	public void setAccidentNumber(int accidentNumber) {
		this.accidentNumber = accidentNumber;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public void setCarPurpose(CarPurpose carPurpose) {
		this.carPurpose = carPurpose;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public void setViolationHistory(ArrayList<violationInfo> violationHistory) {
		this.violationHistory = violationHistory;
	}

	public void setAvailableNumOfViolation(int availableNumOfViolation) {
		this.availableNumOfViolation = availableNumOfViolation;
	}

	public CarType getCarType(){ return this.carType; }
	public CarPurpose getCarPurpose(){ return this.carPurpose; }
	public int getDisplacement(){ return this.displacement; }
	public int getAvailableNumOfViolation(){ return this.availableNumOfViolation; }
	public ArrayList<violationInfo> getViolationHistory(){ return this.violationHistory; }

	public void inputCarInfo(Scanner scanner){
		System.out.println("사고 발생 횟수 : ");
		this.accidentNumber = scanner.nextInt();

		System.out.println("차종(승용차/화물차/승합차) : ");
		this.inputAvailableCarType(scanner.next());

		System.out.println("차량 용도(사업용/비사업용) : ");
		this.inputAvailableCarUse(scanner.next());

		System.out.println("배기량(단위:CC) : ");
		this.displacement = scanner.nextInt();

		System.out.println("법규 위반 횟수 : ");
		this.availableNumOfViolation = scanner.nextInt();

	}



	private void inputAvailableCarType(String input) {
			if (input.equals(CarType.passenger.getDetail()))
				this.carType = CarType.passenger;
			else if (input.equals(CarType.van.getDetail()))
				this.carType = CarType.van;
			else if (input.equals(CarType.lorry.getDetail()))
				this.carType = CarType.lorry;
			else {
				System.out.println("잘못 입력했습니다.");
			}
	}


	private void inputAvailableCarUse(String input) {
			if (input.equals(CarPurpose.business.getDetail()))
				this.carPurpose = CarPurpose.business;
			else if (input.equals(CarPurpose.notBusiness.getDetail()))
				this.carPurpose = CarPurpose.notBusiness;
			else {
				System.out.println("잘못 입력했습니다.");
			}
	}
}//end OwnedCarInfo