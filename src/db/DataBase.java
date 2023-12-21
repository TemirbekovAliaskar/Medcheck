package db;
import models.Hospital;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private List<Hospital> hospitals = new ArrayList<>();

    public <T> Boolean add (T type){
        if (type instanceof Hospital) return hospitals.add((Hospital) type);
        throw new RuntimeException("Not Found !");
    }

    public <T> Boolean remove (T type){
        if (type instanceof Hospital) return hospitals.remove((Hospital) type);
        throw new RuntimeException("Not Found !");
    }



    public List<Hospital> hospitalList (){
        return hospitals;
    }
}
