package models;

import java.util.List;

public class Hospital {
    private Long id;
    private String HospitalName;
    private String address;
    private List<Departament> departaments;
    private List<Doctor> doctors;
    private List<Patient> pattients;

    public Hospital(Long id, String hospitalName, String address, List<Departament> departaments, List<Doctor> doctors, List<Patient> pattients) {
        this.id = id;
        HospitalName = hospitalName;
        this.address = address;
        this.departaments = departaments;
        this.doctors = doctors;
        this.pattients = pattients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Departament> getDepartaments() {
        return departaments;
    }

    public void setDepartaments(List<Departament> departaments) {
        this.departaments = departaments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPattients() {
        return pattients;
    }

    public void setPattients(List<Patient> pattients) {
        this.pattients = pattients;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", HospitalName='" + HospitalName + '\'' +
                ", address='" + address + '\'' +
                ", departaments=" + departaments +
                ", doctors=" + doctors +
                ", pattients=" + pattients +
                '}';
    }
}
