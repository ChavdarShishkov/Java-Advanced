package Java_Advanced_Exam_25_October_2020.P03_Classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private int capacity;
    private List<Student> student;

    public Classroom(int capacity) {
        this.capacity = capacity;
    }

    public Classroom(List<Student> student) {
        this.student = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return student;
    }

    public int getStudentCount() {
        return this.student.size();
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
