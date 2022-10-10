import student_manager.ConnectionProvider;
import student_manager.Student;
import student_manager.StudentDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Student Management Application\n\n");
        Scanner sc = new Scanner(System.in);
        while(true){

            System.out.println("Choose 1 to Fetch data from DATABASE");
            System.out.println("Choose 2 to Add data into DATABASE");
            System.out.println("Choose 3 to Remove data from DATABASE");
            System.out.println("Choose 4 to Update data into DATABASE");
            System.out.println("Choose 5 to close the app");

            System.out.printf("Enter Your Choice : ");
            int choice = 0;
            int userID = 0;
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    StudentDao.fetchDataFromDB();
                    break;
                case 2:
                    System.out.printf("Enter the Student Name : ");
                    String name = sc.nextLine();
                    System.out.printf("Enter the Student Number : ");
                    String number = sc.nextLine();
                    Student student = new Student(name,number);
                    if(StudentDao.insertDataIntoDB(student)) System.out.println("Student data added into Database Successfully\n");
                    else System.out.println("Something went wrong please try again.....\n");
                    break;
                case 3:
                    userID = Integer.parseInt(sc.nextLine());
                    if(StudentDao.removeDataFromDB(userID)) System.out.println("Data Successfully remover from DB for user "+userID+"\n");
                    else System.out.println("Something went wrong please try again.....\n");
                    break;
                case 4:
                    System.out.printf("Enter the Student ID which respect to data need to update : ");
                    userID = Integer.parseInt(sc.nextLine());
                    System.out.printf("Enter the Student Name : ");
                    String name1 = sc.nextLine();
                    System.out.printf("Enter the Student Number : ");
                    String number1 = sc.nextLine();
                    Student student1 = new Student(userID,name1,number1);
                    if(StudentDao.updateDataIntoDB(student1,userID)) System.out.println("Data Successfully Update for UserID : "+userID+"\n");
                    else System.out.println("Something went wrong please try again.....\n");
                    break;
                default:
                    break;
            }
            if(choice == 5){
                System.out.println("Thanks for using the application By By.....");
                break;
            }
        }
    }
}
