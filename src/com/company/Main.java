package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    public static void print(ArrayList<Student> studentArray){
        for (int i = 0; i < studentArray.toArray().length; i++){
            System.out.println("Student " + (i + 1) + "\n" +
                    "First name is " + studentArray.get(i).getFirstName() + "\n" +
                    "Last name is " + studentArray.get(i).getLastName() + "\n" +
                    "Surname is " + studentArray.get(i).getSurname() + "\n" +
                    "City is " + studentArray.get(i).getCity() + "\n" +
                    "PIB is " + studentArray.get(i).getPIB() + "\n" +
                    "Faculty is " + studentArray.get(i).getFaculty() + "\n" +
                    "Number of room is " + studentArray.get(i).getNumberOfRoom() + "\n"
            );
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        System.out.println("Enter number: ");

        Scanner myInput = new Scanner( System.in );
        loop: while(myInput.hasNextInt()) {
            int typing = myInput.nextInt();
            switch (typing) {
                case 0:
                    break loop;
                case 1:
                    Scanner inputStr = new Scanner( System.in );
                    System.out.println("1 - Enter firstName, 2 - Enter lastName, 3 - Enter surname, 4 - Enter city, 5 - Enter faculty, 6 - Enter number of room\n");
                    students.add(new Student(
                            inputStr.nextLine(),
                            inputStr.nextLine(),
                            inputStr.nextLine(),
                            inputStr.nextLine(),
                            inputStr.nextLine(),
                            inputStr.nextInt()
                    ));
                    System.out.println("Enter number: ");
                    break;
                case 2:
                    print(students);
                    break;
                case 3:
                    System.out.println("Enter number to delete: ");
                    Student.deleteStudents(new Scanner( System.in ).nextInt(), students);
                    System.out.println("Enter number: ");
                    break;
                case 4:
                    System.out.println("Enter faculty: ");

                    String enteringFaculty = new Scanner( System.in ).nextLine();

                    var result = students.stream().filter(
                            person -> person.getFaculty().equals(enteringFaculty) == true)
                            .collect(Collectors.toList());

                    if(result.size() == 0)System.out.println("Not found");
                    else {
                        Collections.sort(result, Student.sortRoom);
                        Collections.sort(result, Student.sortCity);
                        print((ArrayList<Student>) result);
                    }

                    break;
                default:
                    System.out.println("No such choice");
            }
        }

    }
}
