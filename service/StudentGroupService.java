package service;

import java.util.List;
import model.Student;
import model.StudentGroup;
import model.Teacher;

public class StudentGroupService {
    public StudentGroup createStudentGroup(Teacher teacher, List<Student> students) {
        return new StudentGroup(teacher, students);
    }
    
}
