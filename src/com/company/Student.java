package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import static com.company.Main.print;

public class Student implements Serializable {
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
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

    public static void searchInStudents(String str, ArrayList<Student> students){
        var result = students.stream().filter(
                person -> person.getFaculty().equals(str) == true)
                .collect(Collectors.toList());

        if(result.size() == 0)System.out.println("Not found");
        else {
            Collections.sort(result, Student.sortRoom);
            Collections.sort(result, Student.sortCity);
            print((ArrayList<Student>) result);
        }
    }

    public static void writeFile(ArrayList<Student> studentArray){
        try
        {
            FileOutputStream fos = new FileOutputStream("employeeData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentArray);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
