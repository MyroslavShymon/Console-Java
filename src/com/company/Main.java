package com.company;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Student.writeFile;

public class Main {

    public static void print(ArrayList<Student> studentArray){
        ArrayList<Student> newPeople= new ArrayList<Student>();
        try
        {
            FileInputStream fis = new FileInputStream("employeeData");
            ObjectInputStream ois = new ObjectInputStream(fis);

            newPeople = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        for(Student p : newPeople)
            System.out.printf("\n"+
                        "First name is " + p.getFirstName() + "\n" +
                        "Last name is " + p.getLastName() + "\n" +
                        "Surname is " + p.getSurname() + "\n" +
                        "City is " + p.getCity() + "\n" +
                        "PIB is " + p.getPIB() + "\n" +
                        "Faculty is " + p.getFaculty() + "\n" +
                        "Number of room is " + p.getNumberOfRoom() + "\n"
                );
    }

    public static void in(String fN, String lN, String sN, String c, String f, int  rN, ArrayList<Student> students) throws IOException {
        students.add(new Student(fN, lN, sN, c, f, rN));
        writeFile(students);
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ArrayList<Student> students = new ArrayList<Student>();
        System.out.println("Enter number: ");

        Scanner myInput = new Scanner(System.in);
        loop:
        while (myInput.hasNextInt()) {
            int typing = myInput.nextInt();
                switch (typing) {
                    case 0:
                        break loop;
                    case 1:
                        Scanner inputStr = new Scanner(System.in);
                        System.out.println("1 - Enter firstName, 2 - Enter lastName, 3 - Enter surname, 4 - Enter city, 5 - Enter faculty, 6 - Enter number of room\n");
                        try {
                            in(inputStr.nextLine(), inputStr.nextLine(), inputStr.nextLine(), inputStr.nextLine(), inputStr.nextLine(), inputStr.nextInt(), students);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Enter number: ");
                        break;
                    case 2:
                        print(students);
                        break;
                    case 3:
                        System.out.println("Enter number to delete: ");
                        Student.deleteStudents(new Scanner(System.in).nextInt(), students);
                        System.out.println("Enter number: ");
                        break;
                    case 4:
                        System.out.println("Enter faculty: ");
                        Student.searchInStudents(new Scanner(System.in).nextLine(), students);
                        break;
                    case 5:
                        System.out.println("Enter PIB to change the student: ");
                        Scanner changeStr = new Scanner(System.in);
                        String PIB = new Scanner(System.in).nextLine();
                        for (int i = 0; i < students.size(); i++) {
                            if (students.get(i).getPIB().equals(PIB) == true) {
                                String changeStr1 = changeStr.nextLine();
                                if (changeStr1.equals("")) students.get(i).setFirstName(students.get(i).getFirstName());
                                else {
                                    students.get(i).setFirstName(changeStr1);
                                }
                                String changeStr2 = changeStr.nextLine();
                                if (changeStr2.equals("")) students.get(i).setLastName(students.get(i).getLastName());
                                else {
                                    students.get(i).setLastName(changeStr2);
                                }
                                String changeStr3 = changeStr.nextLine();
                                if (changeStr3.equals("")) students.get(i).setSurname(students.get(i).getSurname());
                                else {
                                    students.get(i).setSurname(changeStr3);
                                }
                                String changeStr4 = changeStr.nextLine();
                                if (changeStr4.equals("")) students.get(i).setCity(students.get(i).getCity());
                                else {
                                    students.get(i).setCity(changeStr4);
                                }
                                String changeStr5 = changeStr.nextLine();
                                if (changeStr5.equals("")) students.get(i).setPIB(students.get(i).getPIB());
                                else {
                                    students.get(i).setPIB(changeStr5);
                                }
                                String changeStr6 = changeStr.nextLine();
                                if (changeStr6.equals("")) students.get(i).setFaculty(students.get(i).getFaculty());
                                else {
                                    students.get(i).setFaculty(changeStr6);
                                }
                                String changeStr7 = changeStr.nextLine();
                                if (changeStr7.equals(""))
                                    students.get(i).setNumberOfRoom(students.get(i).getNumberOfRoom());
                                else {
                                    students.get(i).setNumberOfRoom(Integer.parseInt(changeStr7));
                                }
                                writeFile(students);
                            }
                        }
                        break;
                    default:
                        System.out.println("No such choice");
                }
        }
    }
}
