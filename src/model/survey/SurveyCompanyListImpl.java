package Practice.InsuranceCompany.Design.src.model.survey;


import java.util.ArrayList;
import java.util.Scanner;


public class SurveyCompanyListImpl implements SurveyCompanyList {

	private ArrayList<SurveyCompany> surveyCompanyList;
	public SurveyCompanyListImpl(){
		this.surveyCompanyList = new ArrayList<>();
	}
	public boolean add(SurveyCompany surveyCompany){
		this.surveyCompanyList.add(surveyCompany);
		return true;
	}

	public boolean delete(String surveyCompanyID){
		if(this.surveyCompanyList != null){
			for(SurveyCompany surveyCompany : this.surveyCompanyList) {
				if (surveyCompany.getSurveyCompanyID().equals(surveyCompanyID)) {
					return this.surveyCompanyList.remove(surveyCompany);
				}
			}
		}
		return false;
	}

	public SurveyCompany get(String surveyCompanyID){
		if(this.surveyCompanyList != null) {
			for (SurveyCompany surveyCompany : this.surveyCompanyList)
				if (surveyCompany.getSurveyCompanyID().equals(surveyCompanyID))
					return surveyCompany;
		}
		return null;
	}

	@Override
	public boolean updateSurveyAbility(String surveyCompanyID, boolean surveyAbility){
		SurveyCompany surveyCompany = this.get(surveyCompanyID);
		if(surveyCompany != null) {
			System.out.println("담당 손해사정업체의 현장 조사 가능 상태를 수정해주세요.");
			System.out.println("1. 가능 | 2. 불가능 ");
			Scanner scanner = new Scanner(System.in);
			switch (scanner.nextInt()) {
				case 1:
					scanner.nextLine();
					System.out.println("현장 조사가 가능한 상태로 수정되었습니다!");
					surveyCompany.setSurveyAbility(true);
					break;
				case 2:
					scanner.nextLine();
					System.out.println("현장 조사가 불가능한 상태로 수정되었습니다!");
					surveyCompany.setSurveyAbility(false);
					break;

			}
			return true;
		} else return false;
	}

	@Override
	public ArrayList<SurveyCompany> getAllList() {
		return this.surveyCompanyList;
	}

	public void printAllList(){
		for(SurveyCompany surveyCompany:this.surveyCompanyList){
			System.out.println(surveyCompany.getSurveyCompanyInfo());
		}
	}

}//end SurveyCompanyListImpl