package Practice.InsuranceCompany.Design.src.model.policyholder;


import java.util.Scanner;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:49
 */
public class OwnedBuildingInfo {

	private int floorNumber;
	private boolean specializedBuilding;

	public OwnedBuildingInfo(){
		this.floorNumber = -1;
		this.specializedBuilding = false;
	}

	public int getFloorNumber(){ return this.floorNumber; }
	public boolean getSpecializedBuilding(){ return this.specializedBuilding; }

	public void setBuildingInfoForAcquisitionPolicy(Scanner scanner){
		System.out.println("건물의 층 수 : ");
		this.floorNumber = scanner.nextInt();

		System.out.println("특수건물 여부(O/X) : ");
		String input = scanner.next();
		while (input != "O" || input != "X") {
			if (input.equals("O"))
				this.specializedBuilding = true;
			else if (input.equals("X"))
				this.specializedBuilding = false;
			else {
				System.out.println("O 또는 X로 다시 입력해주세요 : ");
				input = scanner.next();
			}
		}
	}

	public void finalize() throws Throwable {

	}
}//end OwnedBuildingInfo