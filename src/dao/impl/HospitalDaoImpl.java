package dao.impl;

import dao.GenericDao;
import dao.HospitalDaoService;
import db.DataBase;
import models.Hospital;
import models.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDaoService {
    private final DataBase dataBase;

    public HospitalDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String addHospital(Hospital hospital) {
        dataBase.add(hospital);
        return "Successful !";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        List<Hospital> hospitals = dataBase.hospitalList();
        for (Hospital hospital : hospitals) {
            if (hospital.getId().equals(id)){
                return hospital;
            }
        }throw new RuntimeException("Not found ID !");
    }

    @Override
    public List<Hospital> getAllHospital() {
        return dataBase.hospitalList();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        List<Hospital> hospitals = dataBase.hospitalList();
        for (Hospital hospital : hospitals) {
           if (hospital.getId().equals(id)){
              return hospital.getPattients();
            }
        }
        throw new RuntimeException("Not found hospital ID !");
    }

    @Override
    public String deleteHospitalById(Long id) {
        List<Hospital> hospitals = dataBase.hospitalList();
        for (int i = 0; i < hospitals.size(); i++) {
            Hospital hospital = hospitals.get(i);
            if (hospital.getId().equals(id)) {
                hospitals.remove(i);
                return "Successfully deleted!";
            }
        }
        return "Successful deleted !";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String,Hospital> hospitalMap = new HashMap<>();
        for (Hospital hospital : dataBase.hospitalList()) {
            if (hospital.getAddress().equals(address)){
                hospitalMap.put(address,hospital);
                return hospitalMap;
            }
        }
        throw new RuntimeException("This with" + address + "not found !");
    }
}
