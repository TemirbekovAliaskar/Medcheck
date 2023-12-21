package dao.impl;

import dao.DepartamentDaoService;
import dao.GenericDao;
import db.DataBase;
import models.Departament;
import models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DepartamentDaoImpl implements  GenericDao<Departament> ,DepartamentDaoService{

    private final DataBase dataBase;

    public DepartamentDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    private List<Departament> findAll(){
        List<Departament> departaments = new ArrayList<>();
        for (Hospital hospital : dataBase.hospitalList()) {
            departaments.addAll(hospital.getDepartaments());
        };
        return departaments;
    }

    @Override
    public List<Departament> getAllDepartmentByHospital(Long id) {
        List<Hospital> hospitals= dataBase.hospitalList();
        for (Hospital hospital : hospitals) {
            if (hospital.getId().equals(id)){
                return hospital.getDepartaments();
            }
        }
        throw new RuntimeException("Not this ID Hospital !");
    }

    @Override
    public Departament findDepartmentByName(String name) {
        for (Departament departament : findAll()) {
            if (departament.getDepartmentsName().equals(name)){
                return departament;
            }
        }
        throw new RuntimeException("Not found this name !");
    }

    @Override
    public String add(Long hospitalId, Departament departament) {
        List<Hospital> hospitals = dataBase.hospitalList();
        for (Hospital hospital : hospitals) {
           if (hospital.getId().equals(hospitalId)){
               hospital.getDepartaments().add(departament);
           }
        }
        return "Not found Hospital ID !";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : dataBase.hospitalList()) {
            for (int i = 0; i < hospital.getDepartaments().size(); i++) {
                if (hospital.getDepartaments().get(i).getId().equals(id)){
                    hospital.getDepartaments().remove(i);
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Departament departament) {
        for (Hospital hospital : dataBase.hospitalList()) {
            for (Departament hospitalDepartament : hospital.getDepartaments()) {
                if (hospitalDepartament.getId().equals(id)){
                    hospitalDepartament.setDepartmentsName(departament.getDepartmentsName());
                }
            }
        }
        return "Success !";
    }
}
