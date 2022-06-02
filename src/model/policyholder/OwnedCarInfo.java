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

	private int accidentNumber;
	private CarType carType;
	private CarPurpose carUse;
	private int displacement;
	private ArrayList<violationInfo> violationHistory;
	private int availableNumOfViolation;	// 허용 가능한 법규 위반 횟수
	public violationInfo m_violationInfo;

	public OwnedCarInfo(){

	}

	public int getAccidentNumber(){ return this.accidentNumber; }
	public int getAvailableNumOfViolation(){ return this.availableNumOfViolation; }
	public ArrayList<violationInfo> getViolationHistory(){ return this.violationHistory; }

	public void setCarInfoForAcquisitionPolicy(Scanner scanner){
		System.out.println("허용 가능한 최대 사고 발생 횟수 : ");
		this.accidentNumber = scanner.nextInt();

		System.out.println("허용 가능한 차종(승용차/화물차/승합차) : ");
		this.inputAvailableCarType(scanner);

		System.out.println("허용 가능한 차량 용도(사업용/비사업용/무관) : ");
		this.inputAvailableCarUse(scanner);

		System.out.println("적정 배기량(단위:CC) : ");
		this.displacement = scanner.nextInt();

		System.out.println("허용 가능한 법규 위반 횟수 : ");
		this.availableNumOfViolation = scanner.nextInt();

	}



	private void inputAvailableCarType(Scanner scanner) {
		String input = scanner.next();
		while (input != "승용차" || input != "화물차" || input != "승합차") {
			if (input.equals("승용차"))
				this.carType = CarType.passenger;
			else if (input.equals("승합차"))
				this.carType = CarType.van;
			else if (input.equals("화물차"))
				this.carType = CarType.lorry;
			else {
				System.out.println("승용차/화물차/승합차 중 하나로 다시 입력해주세요 : ");
				input = scanner.next();
			}
		}
	}


	private void inputAvailableCarUse(Scanner scanner) {
		String input = scanner.next();
		while (input != "승용차" || input != "화물차" || input != "승합차") {
			if (input.equals("승용차"))
				this.carType = CarType.passenger;
			else if (input.equals("승합차"))
				this.carType = CarType.van;
			else if (input.equals("화물차"))
				this.carType = CarType.lorry;
			else {
				System.out.println("승용차/화물차/승합차 중 하나로 다시 입력해주세요 : ");
				input = scanner.next();
			}
		}
	}


	public void finalize() throws Throwable {

	}
}//end OwnedCarInfo