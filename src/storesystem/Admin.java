/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author 1: Ong Gia Man (s3938231)
  Author 2: Nguyen Le Thu Nhan (s3932151)
  Author 3: Tran Minh Nhat (s3926629)
  Author 4: Nguyen Ngoc Minh Thu (s3941327)
  Date: 01/2023
  Acknowledgement: Acknowledge the resources that you use here.
*/


package storesystem;

import java.io.*;
import java.util.*;

public class Admin {
    private String adUsername, adPassword;

    public String getAdUsername() {
        return adUsername;
    }

    public void setAdUsername(String adUsername) {
        this.adUsername = adUsername;
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
    }

    public Admin(String username, String password) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        while (!login(username, password)){
            System.out.println("Wrong username or password! Please enter again:");
            System.out.println("Enter username: ");
            username = sc.nextLine();
            System.out.println("Enter password: ");
            password = sc.nextLine();
        }
    }
    public boolean login(String username, String password) throws FileNotFoundException {
        // check if the admin enter the right login values
        // read username and password from admin.txt file
        Scanner sc = new Scanner(System.in);
        String line;
        Scanner fileScanner = new Scanner(new File("src/admin.txt"));
        while (fileScanner.hasNext()){
            line = fileScanner.nextLine();  // assign the next line as a string in 'line'
            String[] values = line.split(",");   // store split values inside an array

            String fileUsername = values[0];
            String filePass = values[1];
            if (username.equals(fileUsername) && password.equals(filePass)){
                System.out.println("Welcome!");
                this.adUsername = values[0];
                this.adPassword = values[1];
                return true;
            }
        }
        return false;
    }
    public void displayMenu() {
        System.out.println("\nMENU ");
        System.out.println("0. Exit");
        System.out.println("1. Add product");
        System.out.println("2. Remove product");
        System.out.println("3. Update price");
        System.out.println("4. Get information of all orders by customer ID");
        System.out.println("5. Change status of order");
        System.out.println("6. Remove customer");
        System.out.println("7. Statistic operators");
        System.out.println("8. Check information of all orders executed on a particular day");
        System.out.println("9. Add category");
        System.out.println("10. Remove category");
    }
    public void displayCustomersInfo() {
        System.out.println("hello");
    }
    public void displayItemsInfo() {

    }
    public void displayOrdersInfo() {

    }
}
