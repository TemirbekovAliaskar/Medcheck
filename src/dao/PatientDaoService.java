package dao;

import models.Patient;

import java.util.List;
import java.util.Map;

public interface PatientDaoService {

    String addPatientsToHospital(Long id, List<Patient> patients);
    Patient getPatientById(Long id);
    Map<Integer, Patient> getPatientByAge(int age);
    List<Patient> sortPatientsByAge(String ascOrDesc);
}
