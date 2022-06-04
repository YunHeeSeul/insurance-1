package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.DiseaseHistoryDao;
import Practice.InsuranceCompany.Design.src.model.policyholder.DiseaseHistory;

public class CDiseaseHistory {
    private DiseaseHistoryDao diseaseHistoryDao;

    public CDiseaseHistory(){
        this.diseaseHistoryDao = new DiseaseHistoryDao();
    }

    public boolean addDiseaseHistory(DiseaseHistory diseaseHistory) {
        return this.diseaseHistoryDao.create(diseaseHistory);
    }
}
