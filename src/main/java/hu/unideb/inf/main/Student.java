package hu.unideb.inf.main;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
    private StringProperty name = new SimpleStringProperty();
    private int credits;
    private LocalDate dateOfBirth;

    public Student(String name, int credits, LocalDate dateOfBirth) {
        this.name.setValue(name);
        this.credits = credits;
        this.dateOfBirth = dateOfBirth;
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        out.writeObject(name.getValue());
        out.writeInt(credits);
        out.writeObject(dateOfBirth);
    }


    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        name.setValue((String) in.readObject());
        credits=in.readInt();
        dateOfBirth = (LocalDate) in.readObject();
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", credits=" + credits +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public StringProperty nameProperty(){
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
