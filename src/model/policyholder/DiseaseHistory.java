package Practice.InsuranceCompany.Design.src.model.policyholder;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;

import java.util.Scanner;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public class DiseaseHistory {

	private static int IDNum = 0;

	private String id;
	private String name;
	private Level severity;
	private int strugglePeriod;

	public DiseaseHistory(){
		this.id = "DH" + Integer.toString(IDNum++);
	}

	public String getId(){ return this.id; }
	public String getName() { return this.name;}
	public Level getSeverity(){ return this.severity; }
	public int getStrugglePeriod(){ return this.strugglePeriod; }

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSeverity(Level severity) {
		this.severity = severity;
	}

	public void setStrugglePeriod(int strugglePeriod) {
		this.strugglePeriod = strugglePeriod;
	}

	public void inputDiseaseHistory(Scanner scanner){
		System.out.println("질환명 : ");
		this.name = scanner.next();

		System.out.println("질환의 중즘도(고/중/저) : ");
		String input = scanner.next();
		if(input.equals(Level.high.getDetail())) this.severity = Level.high;
		else if(input.equals(Level.middle.getDetail())) this.severity = Level.middle;
		else if(input.equals(Level.low.getDetail())) this.severity = Level.low;
		else System.out.println("잘못된 중증도입니다.");

		System.out.println("투병 기간(단위:개월) : ");
		this.strugglePeriod = scanner.nextInt();
	}

	public void finalize() throws Throwable {

	}

}//end DeseaseHistory