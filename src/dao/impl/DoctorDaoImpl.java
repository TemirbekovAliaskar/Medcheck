package dao.impl;

import dao.DoctorDaoService;
import dao.GenericDao;
import db.DataBase;
import models.Departament;
import models.Doctor;
import models.Hospital;

import java.util.List;

public class DoctorDaoImpl implements GenericDao<Doctor> , DoctorDaoService {
    private final DataBase dataBase;

    public DoctorDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital hospital : dataBase.hospitalList()) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (doctor.getId().equals(id)){
                    return doctor;
                }
            }
        }
        throw new RuntimeException("Not found Doctor id !");
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital : dataBase.hospitalList()) {
            for (Departament departament : hospital.getDepartaments()) {
                if (departament.getId().equals(departmentId)){
                    for (Doctor doctor : hospital.getDoctors()) {
                        if (doctorsId.contains(doctor.getId())){
                            departament.getDoctors().add(doctor);
                            return "Successful !";
                        }
                    }throw new RuntimeException("Doctors not found !");
                }
            }throw new RuntimeException("Departments not found !");
        }

        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital hospital : dataBase.hospitalList()) {
          return   hospital.getDoctors();
        }
        throw new RuntimeException("Not founds Doctors !");
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital hospital : dataBase.hospitalList()) {
            for (Departament departament : hospital.getDepartaments()) {
               return departament.getDoctors();
            }
        }
        throw new RuntimeException("Not founds Doctors Departments !");
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        try {
            for (Hospital hospital : dataBase.hospitalList()) {
                if (hospital.getId().equals(hospitalId)) {
                    hospital.getDoctors().add(doctor);
                    return "Doctor is added";
                }
            }
            throw new RuntimeException("Not found id hospital !");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "error";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : dataBase.hospitalList()) {
            for (int i = 0; i < hospital.getDoctors().size(); i++) {
                if (hospital.getDoctors().get(i).getId().equals(id)){
                    hospital.getDoctors().remove(i);
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        Doctor foundDoctor = findDoctorById(id);
        foundDoctor.setFirstName(doctor.getFirstName());
        return "Success";
    }
}
