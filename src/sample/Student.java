package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.UUID;

//Student Class with required Attributes:
public class Student {
    private final SimpleStringProperty Name;
    public UUID id;
    private final SimpleIntegerProperty ID;
    private final SimpleIntegerProperty Age;
    private final SimpleStringProperty Major;
    private final SimpleDoubleProperty GPA;

    //Constructor for student class:
    Student(String Name, int ID, int Age, String Major, double GPA){
        this.Name = new SimpleStringProperty(Name);
        this.ID = new SimpleIntegerProperty(ID);
        this.Age = new SimpleIntegerProperty(Age);
        this.Major = new SimpleStringProperty(Major);
        this.GPA = new SimpleDoubleProperty(GPA);

    }

    //Getter and Setter Method for Name:
    public String getName(){
        return Name.get();
    }
    public void setName(String Name){
        this.Name.set(Name);
    }

    //Getter and Setter Method for ID:
    public int getID(){
        return ID.get();
    }
    public void setID(int ID){
        this.ID.set(ID);
    }

    //Getter and Setter Method for Age:
    public int getAge(){
        return Age.get();
    }
    public void setAge(int Age){
        this.Age.set(Age);
    }

    //Getter and Setter for Method Major:
    public String getMajor(){
        return Major.get();
    }
    public void setMajor(String Major){
        this.Major.set(Major);
    }

    //Getter and Setter Method for GPA:
    public double getGPA(){
        return GPA.get();
    }
    public void setGPA(double GPA){
        this.GPA.set(GPA);
    }




}
