package Java_Advanced_Exam_25_October_2020.Third.classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private int capacity;
    private List<Student> students;

    public Classroom(List<Student> students) {
        this.students = new ArrayList<>();
    }

    public Classroom(int capacity) {
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }


    public String registerStudent(Student student) {
        return null;
    }

    public String dismissStudent(Student student) {
        return null;
    }

    public String getSubjectInfo(String art) {
        return null;
    }

    public boolean getStudent(String dean, String winchester) {
        return false;
    }
}
