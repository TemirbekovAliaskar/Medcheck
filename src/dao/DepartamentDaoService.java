package dao;

import models.Departament;

import java.util.List;

public interface DepartamentDaoService {

    List<Departament> getAllDepartmentByHospital(Long id);
    Departament findDepartmentByName(String name);
}
