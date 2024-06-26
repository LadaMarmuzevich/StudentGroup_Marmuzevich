package model;

public class Student extends User {

    private int studentid;
    public Student(String firstName, String lastName, String middleName, int studentid) {
        super(firstName, lastName, middleName);
        this.studentid = studentid;
    }
    public int getStudentid() {
        return studentid;
    }
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
    @Override
    public String toString() {
        return "Student [studentid=" + studentid + "]";
    }
     
    
}
    
    

