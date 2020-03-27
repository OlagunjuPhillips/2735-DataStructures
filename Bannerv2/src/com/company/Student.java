package com.company;

public class Student {
    private int ID;
    private String name;
    private double GPA;
    public Student(int ID, String name, double GPA){
        this.ID = ID;
        this.name = name;
        this.GPA = GPA;
    }

    @Override
    public String toString(){
        return String.format("Student ID: %d, Student name: %s, Student gpa: %f\n",ID,name,GPA);
    }

    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public double getGPA(){
        return GPA;
    }
    public int compareTo(Student otherStudent){
        return ID - otherStudent.getID();
    }
}
