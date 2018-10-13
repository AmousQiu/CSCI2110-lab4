import java.util.Scanner;
import java.io.*;

public class StudentListDemo {
    public static void main(String args[]) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        Scanner input = new Scanner(System.in);
        StudentList sList = new StudentList();
        int sID;
        String fName;
        String lName;
        String email;
        String faculty;
        String major;
        Student stu = null;
        boolean flag=true;
        while (inputFile.hasNext()) {
            sID = inputFile.nextInt();
            fName = inputFile.next();
            lName = inputFile.next();
            email = inputFile.next();
            faculty = inputFile.next();
            major = inputFile.next();
            stu = new Student(sID, fName, lName, email, faculty, major);
            sList.addRecord(stu);
        }
        inputFile.close();
        while (flag) {
            System.out.println("What would you like to do? (add,delete,display,search,quit): ");
            String in = input.next();
            if (in.equals("add")) {
                System.out.println("Enter the record: ");
                sID = input.nextInt();
                fName = input.next();
                lName = input.next();
                email = input.next();
                faculty = input.next();
                major = input.next();
                stu = new Student(sID, fName, lName, email, faculty, major);
                sList.addRecord(stu);
                System.out.println("Record added");
            } else if (in.equals("delete")) {
                System.out.println("Enter the ID number to be deleted: ");
                int id = input.nextInt();
                sList.deleteRecord(id);
                System.out.println(id+" deleted.");
            } else if (in.equals("display")) {
                System.out.println("Display what(major ,faculty ,student): ");
                String dis = input.next();
                if (dis.equals("major")) {
                    System.out.println("Enter the major:");
                    sList.displayMajors(input.next());
                } else if (dis.equals("faculty")) {
                    System.out.println("Enter the faculty: ");
                    sList.displayFaculty(input.next());
                } else if (dis.equals("student")) {
                    System.out.println("Enter the last name: ");
                    sList.displayName(input.next());
                }
            } else if (in.equals("search")){
                System.out.println("Enter the ID Number:");
                int id=input.nextInt();
                if(sList.searchID(id)==null){
                    System.out.println(id+" not found. ");
                }else{
                    System.out.println(sList.searchID(id));
                }
            }
            else if(in.equals("quit")){
                System.out.println("Program ended");
                flag=false;
            }
        }
    }
}
