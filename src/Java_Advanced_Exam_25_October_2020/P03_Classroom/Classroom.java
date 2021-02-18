package Java_Advanced_Exam_25_October_2020.P03_Classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private int capacity;
    private List<Student> data;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }


    public boolean getStudent(String dean, String winchester) {
        return false;
    }

    public String registerStudent(Student student) {
        return null;
    }

    public String dismissStudent(Student student) {
        return null;
    }

    public String getSubjectInfo(String algebra) {
        return null;
    }
}
