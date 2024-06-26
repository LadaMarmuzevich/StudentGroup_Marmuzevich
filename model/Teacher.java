package model;

public class Teacher extends User {
    
    private int teacherid;
    public Teacher(String firstName, String lastName, String middleName, int teacherid) {
        super(firstName, lastName, middleName);
        this.teacherid = teacherid;
    }
    public int getTeacherid() {
        return teacherid;
    }
    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }
    
}
