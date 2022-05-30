package Practice.InsuranceCompany.Design.src.insurance;


import java.util.ArrayList;
import java.util.Scanner;

public class InsuranceListImpl implements InsuranceList {

	private ArrayList<Insurance> insuranceList;
	public Insurance m_Insurance;

	public InsuranceListImpl(){
		this.insuranceList = new ArrayList<>();
	}

	public ArrayList<Insurance> getInsuranceList(){ return this.insuranceList; }

	public boolean add(Insurance insurance){
		if(this.insuranceList != null) {
			this.insuranceList.add(insurance);
			return true;
		}
		return false;
	}

	public boolean delete(String insuranceID){
		if(this.insuranceList != null) {
			for (Insurance insurance : this.insuranceList) {
				if (insuranceID.equals(insurance.getInsuranceID())) { this.insuranceList.remove(insurance); }
				return true;
			}
		}
		return false;
	}

	public Insurance get(String insuranceID){
		if(this.insuranceList != null) {
			for (Insurance insurance : this.insuranceList)
				if (insuranceID.equals(insurance.getInsuranceID())) return insurance;
		}
		return null;
	}

	@Override
	public boolean update(String insuranceID) {
		Insurance insurance = this.get(insuranceID);
		if(insurance != null) {
			System.out.println("수정하실 보험의 세부 항목의 번호를 입력해주세요.");
			System.out.println("1. 보험명 | 2. 보험 설명 | 3. 보험 분류 | 4. 가입연령제한 | 5. 기본 보험료 | 6. 기본 요율");
			Scanner scanner = new Scanner(System.in);
			switch (scanner.nextInt()) {
				case 1:
					scanner.nextLine();
					System.out.println("새로운 보험명 : ");
					insurance.setInsuranceName(scanner.nextLine());
					break;
				case 2:
					scanner.nextLine();
					System.out.println("새로운 보험 설명 : ");
					insurance.setInsuranceEx(scanner.nextLine());
					break;
				case 3:
					System.out.println("새로운 보험 분류(차/화재/실손) : ");
					String input = scanner.next();
					if(input.equals("차"))
						insurance.setInsuranceType(InsuranceType.car);
					else if(input.equals("화재"))
						insurance.setInsuranceType(InsuranceType.fire);
					else if(input.equals("실손"))
						insurance.setInsuranceType(InsuranceType.personalHealth);
					break;
				case 4:
					System.out.println("새로운 가입제한연령 : ");
					insurance.setJoinAge(scanner.nextInt());
					break;
				case 5:
					System.out.println("새로운 기본 보험료 :");
					insurance.setPremium(scanner.nextInt());
					break;
				case 6:
					System.out.println("새로운 기본 요율 :");
					insurance.setRate(scanner.nextDouble());
					break;
			}
			return true;
		} else return false;
	}


	public boolean checkValidationID(String inputID) {
		if(this.insuranceList != null) {
			for (Insurance insurance : this.insuranceList)
				if (inputID.equals(insurance.getInsuranceID())) { return true; }
		}
		return false;
	}

	public void printAllInsuranceInfo(){
		for(Insurance insurance : this.insuranceList){
			insurance.printInsuranceDetails();
			System.out.println("\n");
		}
	}
}//end InsuranceListImpl