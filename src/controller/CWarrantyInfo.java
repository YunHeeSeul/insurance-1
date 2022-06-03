package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.WarrantyInfoDao;
import Practice.InsuranceCompany.Design.src.model.insurance.WarrantyInfo;

import java.util.ArrayList;

public class CWarrantyInfo {
    private WarrantyInfoDao warrantyInfoDao;

    public CWarrantyInfo(){ this.warrantyInfoDao = new WarrantyInfoDao(); }

    public boolean create(WarrantyInfo warrantyInfo, String insuranceID){ return this.warrantyInfoDao.create(warrantyInfo, insuranceID); }
    public ArrayList<WarrantyInfo> retrieveAllByInsuranceId(String insuranceID){ return this.warrantyInfoDao.retrieveAllByInsuranceId(insuranceID); }
}
