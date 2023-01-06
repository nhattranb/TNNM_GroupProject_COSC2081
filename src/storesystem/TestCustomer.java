package storesystem;

import java.io.IOException;
import java.util.Scanner;

// This is the test file of Customer.java file
public class TestCustomer {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! Do you already have an account? (yes/no)");
        String isMember = sc.nextLine();

        if (isMember.equals("no")){
            System.out.println("Welcome! Please enter your: username, password, full name, phone number, email, address");
            String username = sc.nextLine();
            String password = sc.nextLine();
            String fullName = sc.nextLine();
            String phoneNumber = sc.nextLine();
            String email = sc.nextLine();
            String address = sc.nextLine();
            Customer regisUser = new Customer(username,password,fullName,phoneNumber,email,address);
        }
        System.out.println("Please enter your username and password to login:");
        String userName = sc.nextLine();
        String pass = sc.nextLine();
        Customer loginUser = new Customer(userName, pass);

        // after logging in, let the user choose what they want to do
        loginUser.showFunctionsMenu();
        int chosenNum = sc.nextInt();
        while (chosenNum != 0){   // if not exit
            if (chosenNum == 1){
                loginUser.updateInformation();
            } else if (chosenNum ==2) {
                System.out.println();
            }
            loginUser.showFunctionsMenu();
            chosenNum = sc.nextInt();   //keep updating the chosen function
        }
        System.out.println("Goodbye!");
    }
}
