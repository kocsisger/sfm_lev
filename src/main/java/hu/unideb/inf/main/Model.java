package hu.unideb.inf.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Model {
    private Student student;

    public Student getStudent() {
        return student;
    }

    public Model() {
        this.student = new Student("Rob Smith",
                                    55,
                                    LocalDate.of(1991,12,03));
    }

    public void saveStudent() {
        try {
            FileOutputStream fos = new FileOutputStream("student.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(student);

            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
