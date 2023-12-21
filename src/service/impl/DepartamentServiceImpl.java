package service.impl;

import dao.impl.DepartamentDaoImpl;
import models.Departament;
import service.DepartamentService;
import service.GenericService;

import java.util.List;

public class DepartamentServiceImpl implements GenericService<Departament>, DepartamentService {
    private final DepartamentDaoImpl departamentDao;

    public DepartamentServiceImpl(DepartamentDaoImpl departamentDao) {
        this.departamentDao = departamentDao;
    }

    @Override
    public List<Departament> getAllDepartmentByHospital(Long id) {
        return departamentDao.getAllDepartmentByHospital(id);
    }

    @Override
    public Departament findDepartmentByName(String name) {
        return departamentDao.findDepartmentByName(name);
    }

    @Override
    public String add(Long hospitalId, Departament departament) {
        return departamentDao.add(hospitalId, departament);

    }

    @Override
    public void removeById(Long id) {
        departamentDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Departament departament) {
        return departamentDao.updateById(id,departament);
    }
}
