package Practice.InsuranceCompany.Design.src.model.policyholder;


import Practice.InsuranceCompany.Design.src.etcEnum.CarPurpose;
import Practice.InsuranceCompany.Design.src.etcEnum.CarType;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:49
 */
public class OwnedCarInfo {

	private static int IDNum = 1;

	private String id;
	private int accidentNumber;
	private CarType carType;
	private CarPurpose carPurpose;
	private int displacement;
	private ArrayList<violationInfo> violationHistory;
	private int availableNumOfViolation;	// 허용 가능한 법규 위반 횟수
	public violationInfo m_violationInfo;

	public OwnedCarInfo(){
		this.id = "CI" + Integer.toString(IDNum++);
	}

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

	public String getCarType(){ return this.carType.toString(); }
	public String getCarPurpose(){ return this.carPurpose.toString(); }
	public int getDisplacement(){ return this.displacement; }
	public int getAvailableNumOfViolation(){ return this.availableNumOfViolation; }
	public ArrayList<violationInfo> getViolationHistory(){ return this.violationHistory; }

	public void inputCarInfo(Scanner scanner){
		System.out.println("허용 가능한 최대 사고 발생 횟수 : ");
		this.accidentNumber = scanner.nextInt();

		System.out.println("허용 가능한 차종(승용차/화물차/승합차) : ");
		this.inputAvailableCarType(scanner.next());

		System.out.println("허용 가능한 차량 용도(사업용/비사업용) : ");
		this.inputAvailableCarUse(scanner.next());

		System.out.println("적정 배기량(단위:CC) : ");
		this.displacement = scanner.nextInt();

		System.out.println("허용 가능한 법규 위반 횟수 : ");
		this.availableNumOfViolation = scanner.nextInt();

	}



	private void inputAvailableCarType(String input) {
			if (input.equals("승용차"))
				this.carType = CarType.passenger;
			else if (input.equals("승합차"))
				this.carType = CarType.van;
			else if (input.equals("화물차"))
				this.carType = CarType.lorry;
			else {
				System.out.println("잘못 입력했습니다.");
			}
	}


	private void inputAvailableCarUse(String input) {
			if (input.equals("사업용"))
				this.carPurpose = CarPurpose.business;
			else if (input.equals("비사업용"))
				this.carPurpose = CarPurpose.notBusiness;
			else {
				System.out.println("잘못 입력했습니다.");
			}
	}


	public void finalize() throws Throwable {

	}
}//end OwnedCarInfo