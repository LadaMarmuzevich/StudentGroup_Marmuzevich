package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Student;
import model.StudentGroup;
import model.Teacher;
import model.Type;
import model.User;
import service.DataService;
import service.StudentGroupService;
import view.StudentView;

public class Controller {

    private final StudentGroupService groupService = new StudentGroupService();
    private final Map<Integer, Teacher> teachers = new HashMap<>();
    private final Map<Integer, Student> students = new HashMap<>();
    private final  DataService service = new DataService();
    private final StudentView view = new StudentView();

    public void  createStudent(String firstName, String lastName, String middleName){
        service.create(firstName, lastName, middleName, Type.STUDENT);
    }
    public void getAllStudent(){
        List<User> userList = service.getAllStudent();
        for (User user: userList){
            Student student =(Student) user;
           view.printOnConsole(student); 
        }
    }

    private List<Student> getStudentsByIds(List<Integer> studentIds) {
        List<Student> result = new ArrayList<>();
        for (Integer studentId : studentIds) {
            if (students.containsKey(studentId)) {
                result.add(students.get(studentId));
            }
        }
        return result;
    }
    private Teacher getTeacherById(Integer teacherId) {
        if (teachers.containsKey(teacherId)) {
            return teachers.get(teacherId);
        }
        return null; 
    }

    public StudentGroup createStudentGroup(int teacherid, List<Integer> studentsid ) {
        List<Student> students = getStudentsByIds(studentsid);
        Teacher teacher = getTeacherById(teacherid);
        StudentGroup group = groupService.createStudentGroup(teacher, students);
        return group;
    }


}
