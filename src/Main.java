import dao.GenericDao;
import dao.impl.DepartamentDaoImpl;
import dao.impl.DoctorDaoImpl;
import dao.impl.HospitalDaoImpl;
import dao.impl.PatientDaoImpl;
import db.DataBase;
import models.*;
import service.*;
import service.impl.DepartamentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.HospitalServiceImpl;
import service.impl.PatientServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();

        PatientServiceImpl patientService = new PatientServiceImpl(new PatientDaoImpl(dataBase));
        DoctorServiceImpl doctorService = new DoctorServiceImpl(new DoctorDaoImpl(dataBase));
        DepartamentServiceImpl departamentService = new DepartamentServiceImpl(new DepartamentDaoImpl(dataBase));
        HospitalService hospitalService = new HospitalServiceImpl(new HospitalDaoImpl(dataBase));


        List<Patient> patients = new ArrayList<>(Arrays.asList(
                new Patient(1L,"Argen","Urumov",25, Gender.MALE),
                new Patient(2L,"Adis","Kazybekov",23, Gender.MALE),
                new Patient(3L,"Shahzad","Alimova",15, Gender.FEMALE),
                new Patient(4L,"Azem","Emirbekova",19, Gender.FEMALE)

        ));
        List<Patient> patients2 = new ArrayList<>(Arrays.asList(
                new Patient(5L,"Aslan","Sadiev",25, Gender.MALE),
                new Patient(6L,"Bem","Gromova",19, Gender.FEMALE)

        ));

        List<Doctor> doctors = new ArrayList<>(Arrays.asList(
                new Doctor(1L,"Ali","Askarov",Gender.MALE,2003),
                new Doctor(2L,"Duulat","Temirbekov",Gender.MALE,1997),
                new Doctor(3L,"Lia","Bekova",Gender.FEMALE,2000)
        ));
        List<Doctor> doctors2 = new ArrayList<>(Arrays.asList(
                new Doctor(4L,"Askar","Asov",Gender.MALE,2003),
                new Doctor(5L,"Budur","Mirbekov",Gender.MALE,1987),
                new Doctor(6L,"Lia","Bekova",Gender.FEMALE,1950)
        ));

        List<Departament> departaments = new ArrayList<>(Arrays.asList(
                new Departament(1L,"Alai-Kuu",doctors)
        ));

        Hospital hospital = new Hospital(1L,"Naryn","Bishkek",departaments,doctors,patients);
//        Hospital hospital2 = new Hospital(2L,"Buguchu","Kochkor",departaments,doctors2,patients2);

        Departament departament = new Departament(2L,"SaryOi",doctors2);
        Departament departament2 = new Departament(2L,"Salam",doctors2);

        Doctor doctor = new Doctor(7L,"Zarina","Avtandilova",Gender.FEMALE,2002);
        Doctor doctor2 = new Doctor(2L,"ASAS","SASA",Gender.MALE,1889);

        Patient newPatient = new Patient(7L,"Muha","Voinov",23,Gender.MALE);
        Patient updatePatient2 = new Patient(7L,"GGG","Oinov",39,Gender.MALE);

        List<Patient> newPatients = new ArrayList<>(List.of(
                new Patient(8L,"Mike","Tyson",50,Gender.MALE),
                new Patient(9L,"Mukhamed","Ali",70,Gender.MALE)
        )) ;

        // hospital add to database
        dataBase.hospitalList().add(hospital);

        while (true){
            System.out.println("""
                           
             Hospital                           
     1.add Hospital            
     2.Find Hospital By ID  
     3.Get All Hospitals
     4.Get All Patients
     5.Delete Hospital by ID
     6.Get All Hospital by Address 
                   
                      Department
                   7.add 
                   8.remove
                   9.Update by ID
                   10.GetAll Departments by Hospital
                   11.Find Departments By Name
                  
                                      Doctor
                                 12.add
                                 13.remove
                                 14.Update by ID
                                 15.Find Doctor byID
                                 16.As Sign Doctor to Department
                                 17.Get All Doctors by Hospital Id
                                 18.Get All Doctor by Department ID     
                   
                                                  Patient
                                              19.add
                                              20.remove
                                              21.Update by ID
                                              22.add Patients to Hospital
                                              23.get Patients by ID
                                              24.get Patient by AGE
                                              25.sort Patient by AGE    
                        
                    """);
            System.out.println("Select : ");
            switch (new Scanner(System.in).nextInt()){
                case 1 -> hospitalService.addHospital(hospital);
                case 2 -> System.out.println(hospitalService.findHospitalById(1L));
                case 3 -> System.out.println(hospitalService.getAllHospital());
                case 4 -> System.out.println(hospitalService.getAllPatientFromHospital(1L));
                case 5 -> hospitalService.deleteHospitalById(1L);
                case 6 -> System.out.println(hospitalService.getAllHospitalByAddress("Bishkek"));
                case 7 -> departamentService.add(1L,departament);
                case 8 -> departamentService.removeById(2L);
                case 9 -> departamentService.updateById(2L,departament2);
                case 10-> System.out.println(departamentService.getAllDepartmentByHospital(1L));
                case 11-> System.out.println(departamentService.findDepartmentByName("Salam"));
                case 12-> doctorService.add(1L,doctor);  //
                case 13-> doctorService.removeById(7L);
                case 14-> doctorService.updateById(2L,doctor2);
                case 15-> System.out.println(doctorService.findDoctorById(7L));
                case 16-> doctorService.assignDoctorToDepartment(2L,ids());
                case 17-> System.out.println(doctorService.getAllDoctorsByHospitalId(1L));
                case 18-> System.out.println(doctorService.getAllDoctorsByDepartmentId(2L));
                case 19-> patientService.add(1L,newPatient);
                case 20-> patientService.removeById(7L);
                case 21-> patientService.updateById(7L,updatePatient2);
                case 22-> patientService.addPatientsToHospital(1L,newPatients);
                case 23-> System.out.println(patientService.getPatientById(8L));
                case 24-> System.out.println(patientService.getPatientByAge(70));
                case 25-> System.out.println(patientService.sortPatientsByAge("asc"));
            }
        }
    }

    private static List<Long> ids (){
        List<Long> longs = new ArrayList<>(List.of(1L));
        return longs;
    }
}