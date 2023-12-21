package dao.impl;

import dao.GenericDao;
import dao.PatientDaoService;
import db.DataBase;
import models.Hospital;
import models.Patient;

import java.util.*;

public class PatientDaoImpl implements GenericDao<Patient> , PatientDaoService {
    private final DataBase dataBase;

    public PatientDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        for (Hospital hospital : dataBase.hospitalList()) {
            if (hospital.getId().equals(hospitalId)){
                hospital.getPattients().add(patient);
            }
        }
        return "Success added ! ";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : dataBase.hospitalList()) {
            for (int i = 0; i < hospital.getPattients().size(); i++) {
                if (hospital.getPattients().get(i).getId().equals(id)){
                    hospital.getPattients().remove(i);
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Patient patient) {
        Patient patientById = getPatientById(id);
        patientById.setFirstNamePatient(patient.getFirstNamePatient());
        return "Success update ! ";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital : dataBase.hospitalList()) {
            if (hospital.getId().equals(id)){
                hospital.getPattients().addAll(patients);
            }
        }
        return "Success added !";
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : dataBase.hospitalList()) {
            for (Patient pattient : hospital.getPattients()) {
                if (pattient.getId().equals(id)){
                    return pattient;
                }
            }
        }
        throw new RuntimeException("Not found Patient");
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        Map<Integer ,Patient> patientMap = new HashMap<>();
        for (Hospital hospital : dataBase.hospitalList()) {
            for (Patient pattient : hospital.getPattients()) {
                if (!patientMap.containsKey(age)){
                    patientMap.put(age,pattient);
                }
            }
        }
        return patientMap;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = new ArrayList<>();
        for (Hospital hospital : dataBase.hospitalList()) {
            patients.addAll(hospital.getPattients());

            if (ascOrDesc.equals("asc")){
                Comparator<Patient> comparator = Comparator.comparing(Patient ::getAge);
                patients.sort(comparator);
                return patients;
            } else if (ascOrDesc.equals("desc")) {
                Comparator<Patient> comparator = Comparator.comparing(Patient :: getAge).reversed();
                patients.sort(comparator);
                return patients;
            }
        }
        throw new RuntimeException("asc or desc write !!!");
    }
}
