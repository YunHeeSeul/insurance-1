package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.AccidentDao;
import Practice.InsuranceCompany.Design.src.model.accident.Accident;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentListImpl;

public class CAccident {
    private AccidentDao accidentDao;

    public CAccident(){
        this.accidentDao = new AccidentDao();
    }

    public AccidentListImpl getAllAccidentList() {
        return this.accidentDao.retrieveAll();
    }

    public Accident getByAccidentID (String accidentID) {
        return this.accidentDao.retrieveById(accidentID);
    }
    public boolean addAccident(Accident accident) {
        return this.accidentDao.create(accident);
    }

    public boolean updateAccidentSurvey(String accidentID, boolean doingHarm, String exemptionInfoID, String accidentScale) {
        return this.accidentDao.update(accidentID,doingHarm,exemptionInfoID,accidentScale);
    }

//  public boolean deleteAccidentById(String accidentID) {
 //       return this.accidentDao.delete(accidentID);
 //   }

    public int getMaxID() { return this.accidentDao.retrieveMaxID(); }

}
