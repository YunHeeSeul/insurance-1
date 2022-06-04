package Practice.InsuranceCompany.Design.src.model.policyholder;


import Practice.InsuranceCompany.Design.src.controller.COwnedBuildingInfo;

import java.util.Scanner;

/**
 * @author SeoyeonPark
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:49
 */
public class OwnedBuildingInfo {

	private static int IDNum = 0;

	private COwnedBuildingInfo cOwnedBuildingInfo;

	private String id;
	private int floorNumber;
	private boolean specializedBuilding;

	public void setId(String id) {
		this.id = id;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public void setSpecializedBuilding(boolean specializedBuilding) {
		this.specializedBuilding = specializedBuilding;
	}

	public OwnedBuildingInfo(){
		this.cOwnedBuildingInfo = new COwnedBuildingInfo();
		this.id = "BI" + Integer.toString(IDNum++);
		this.floorNumber = -1;
		this.specializedBuilding = false;
	}

	public String getId(){ return this.id; }
	public int getFloorNumber(){ return this.floorNumber; }
	public boolean getSpecializedBuilding(){ return this.specializedBuilding; }

	public void inputBuildingInfo(Scanner scanner){
		System.out.println("----- 인수 정책 등록을 위한 건물 정보를 입력해주세요 -----");
		System.out.println("1. 건물의 층 수 : ");
		this.floorNumber = scanner.nextInt();

		System.out.println("2. 특수건물 여부(O/X) : ");
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
		this.cOwnedBuildingInfo.addBuildingInfo(this);
	}

	public void finalize() throws Throwable {

	}
}//end OwnedBuildingInfo