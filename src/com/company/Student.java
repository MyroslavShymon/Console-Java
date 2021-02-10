package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Student {
    private String firstName;
    private String lastName;
    private String surname;
    private String city;
    private String PIB;
    private String faculty;
    private int numberOfRoom;

    public Student(String setFirstName, String setLastName, String setSurname, String setCity, String setFaculty, int setNumberOfRoom) {
        firstName = setFirstName;
        lastName = setLastName;
        surname = setSurname;
        city = setCity;
        PIB = String.valueOf(
                firstName.toUpperCase().toCharArray()[0] + "." +
                lastName.toUpperCase().toCharArray()[0] + "." +
                surname.toUpperCase().toCharArray()[0]
        );
        faculty = setFaculty;
        numberOfRoom = setNumberOfRoom;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public String getPIB() {
        return PIB;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public static void deleteStudents(int num, ArrayList studentArray){
        studentArray.remove(num - 1);
    }

    public static Comparator<Student> sortRoom = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            int StudentNumberOfRoom1 = s1.getNumberOfRoom();
            int StudentNumberOfRoom2 = s2.getNumberOfRoom();
            return StudentNumberOfRoom1-StudentNumberOfRoom2;
    }};

    public static Comparator<Student> sortCity = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            String StudentCity1 = s1.getCity();
            String StudentCity2 = s2.getCity();
            return StudentCity1.compareTo(StudentCity2);
    }};
}
