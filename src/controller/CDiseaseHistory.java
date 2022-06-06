package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.DiseaseHistoryDao;
import Practice.InsuranceCompany.Design.src.model.customer.DiseaseHistory;

public class CDiseaseHistory {
    private DiseaseHistoryDao diseaseHistoryDao;

    public CDiseaseHistory(){
        this.diseaseHistoryDao = new DiseaseHistoryDao();
    }

    public boolean addDiseaseHistory(DiseaseHistory diseaseHistory) {
        return this.diseaseHistoryDao.create(diseaseHistory);
    }

    public int getMaxID() { return this.diseaseHistoryDao.retrieveMaxID(); }

}
