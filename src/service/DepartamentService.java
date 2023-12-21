package service;

import models.Departament;

import java.util.List;

public interface DepartamentService {
    List<Departament> getAllDepartmentByHospital(Long id);
    Departament findDepartmentByName(String name);
}
