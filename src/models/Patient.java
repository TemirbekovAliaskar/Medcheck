package models;

public class Patient {

    private Long id;
    private String firstNamePatient;
    private String lastNamePatient;
    private int age;
     Gender gender;

    public Patient(Long id, String firstNamePatient, String lastNamePatient, int age, Gender gender) {
        this.id = id;
        this.firstNamePatient = firstNamePatient;
        this.lastNamePatient = lastNamePatient;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNamePatient() {
        return firstNamePatient;
    }

    public void setFirstNamePatient(String firstNamePatient) {
        this.firstNamePatient = firstNamePatient;
    }

    public String getLastNamePatient() {
        return lastNamePatient;
    }

    public void setLastNamePatient(String lastNamePatient) {
        this.lastNamePatient = lastNamePatient;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstNamePatient='" + firstNamePatient + '\'' +
                ", lastNamePatient='" + lastNamePatient + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
