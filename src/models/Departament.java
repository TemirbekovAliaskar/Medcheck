package models;

import java.util.List;

public class Departament {

    private Long id;
    private String departmentsName;
    private List<Doctor> doctors;

    public Departament(Long id, String departmentsName, List<Doctor> doctors) {
        this.id = id;
        this.departmentsName = departmentsName;
        this.doctors = doctors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentsName() {
        return departmentsName;
    }

    public void setDepartmentsName(String departmentsName) {
        this.departmentsName = departmentsName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "id=" + id +
                ", departmentsName='" + departmentsName + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
