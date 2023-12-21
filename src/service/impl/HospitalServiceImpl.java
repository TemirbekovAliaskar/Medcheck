package service.impl;

import dao.impl.HospitalDaoImpl;
import models.Hospital;
import models.Patient;
import service.GenericService;
import service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements  HospitalService {
    private final HospitalDaoImpl hospitalDao;
    public HospitalServiceImpl(HospitalDaoImpl hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        return hospitalDao.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return hospitalDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        hospitalDao.deleteHospitalById(id);
        return "Success !";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return hospitalDao.getAllHospitalByAddress(address);
    }
}
