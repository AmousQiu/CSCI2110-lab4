import java.io.File;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String args[]) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        Scanner input = new Scanner(System.in);
        LinkedList<String> aList = new LinkedList<>();
        boolean flag = true;
        String country;
        double game = 0;
        double cGame = 0;
        while (inputFile.hasNext()) {
            country = inputFile.nextLine();
            aList.add(country);
        }
        inputFile.close();
        int countryOrCapital;
        Random ran = new Random();

        System.out.println("Welcome to the Country-Capital Quiz!");
        while (flag) {
            System.out.println("Play?");
            String choose=input.next();
            if (choose.equals("No")) {
                System.out.println("Game Over!");
                System.out.println("Game Stats:");
                System.out.println("Question played: " + game + "; Correct answers: " + cGame + "; Score:" + (cGame / game * 100) + "%");
                break;
            }
            else if (choose.equals("Yes")) {
                game++;
                countryOrCapital = ran.nextInt(2);
                if (countryOrCapital == 0) {
                    int countryNum = ran.nextInt(aList.size());
                    if (countryNum % 2 == 0) {
                        countryNum--;
                    }
                    System.out.println("What is the Capital of " + aList.getAt(countryNum));
                    if (input.next().equals(aList.getAt(countryNum - 1))) {
                        System.out.print("Correct! ");
                        cGame++;
                    } else {
                        System.out.print("Incorrect. The correct answer is " + aList.getAt(countryNum - 1) + " ");
                    }
                }
                if (countryOrCapital == 1) {
                    int capitalNum = ran.nextInt(aList.size());
                    if (capitalNum % 2 == 1) {
                        capitalNum++;
                    }
                    System.out.println("What country has " + aList.getAt(capitalNum) + " as its capital?");
                    if (input.next().equals(aList.getAt(capitalNum + 1))) {
                        System.out.print("Correct! ");
                        cGame++;
                    } else {
                        System.out.print("Incorrect. The correct answer is " + aList.getAt(capitalNum + 1) + " ");
                    }
                }
            }
        }
    }
}
