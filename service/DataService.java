package service;

import java.util.ArrayList;
import java.util.List;
import model.Student;
import model.Teacher;
import model.Type;
import model.User;

public class DataService {

    private List<User> userlist;

    public void create(String firstName, String lastName, String middleName, Type type){
        int id = getFreeid(type);
        if (Type.STUDENT == type) {
            Student student = new Student(firstName, lastName, middleName, id);
            userlist.add(student);
        }
        if (Type.TEACHER == type) {
            Teacher teacher = new Teacher(firstName, lastName, middleName, id);
            userlist.add(teacher);
        }
    }

    public User getUserById(Type type, int id) {
        boolean itsStudent = Type.STUDENT == type;
        User currentUser = null;
        for (User user: userlist){
            if (user instanceof Teacher && !itsStudent && ((Teacher) user).getTeacherid() == id) {
                currentUser = user;
            }
            if (user instanceof Student && itsStudent && ((Student) user).getStudentid() == id) {
                currentUser = user;
            }
        }
        return currentUser;
    }

    public List<User> getAllUsers(){
        return userlist;
    }

    public List<User> getAllStudent() {
        List<User> students = new ArrayList<>();
        for (User user: userlist){
            if (user instanceof Student) {
                students.add(user);
            }
        }
        return students;
    }


    private int getFreeid(Type type) {
        boolean itsStudent = Type.STUDENT == type;
        int lastid = 1;
        for (User user: userlist){
            if (user instanceof Teacher && !itsStudent) {
                lastid = ((Teacher) user).getTeacherid() + 1;  
            }
            if (user instanceof Student && itsStudent) {
                lastid = ((Student) user).getStudentid() + 1;
            }
        }
        return lastid;
        
    }
    
}
