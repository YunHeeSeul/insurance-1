package Practice.InsuranceCompany.Design.src.accident;

import Practice.InsuranceCompany.Design.src.dao.AccidentDao;

public class CAccident {
    private AccidentDao accidentDao;

    public CAccident(){
        this.accidentDao = new AccidentDao();
    }

    public AccidentListImpl getAllAccidentList() {
        return this.accidentDao.retrieveAll();
    }

    public Accident getAccidentById(String accidentID) {
        return this.accidentDao.retrieveById(accidentID);
    }

    public boolean addAccident(Accident accident) {
        return this.accidentDao.create(accident);
    }

    public boolean updateAccidentSurvey(String accidentID, String doingHarm, String exemptionInfo, String accidentScale) {
        return this.accidentDao.update(accidentID,doingHarm,exemptionInfo,accidentScale);
    }

    public boolean deleteAccidentById(String accidentID) {
        return this.accidentDao.delete(accidentID);
    }
/*
    public AccidentListImpl getMaintenanceTargetList(){
        return this.contractDao.retrieveMaintenanceTargetList();
    }
 */

}

