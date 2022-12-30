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
import java.util.Scanner;
public class Customer {
    private String username;
    private String fullName;
    private String password;
    private String phoneNumber;
    private String email;
    private String address;
    private String customerID;
    private static int counter = 1;
    private String customerType;

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
        } else if (isMember.equals("yes")) {
            System.out.println("Please enter your username and password to login:");
            String userName = sc.nextLine();
            String pass = sc.nextLine();
            Customer loginUser = new Customer(userName, pass);
        }

    }
    public Customer(String username, String password, String fullName, String phoneNumber,
                    String email, String address) throws IOException {
        Customer.counter++;
        this.customerID = "C00" + counter;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        registration(username, password);
    }

    public Customer(String username, String password) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        while (!login(username, password)){
            System.out.println("Wrong username or password! Please enter again:");
            username = sc.nextLine();
            password = sc.nextLine();
        }
    }

    public void registration(String username, String password) throws IOException {
       /* this method will read Customer file to find out
        similarities of values for registering conditions,
        then will write information of a new customer into that file. */

        Scanner sc = new Scanner(System.in);
        String line;   // to contain each line
        Scanner fileScanner = new Scanner("src/customers1.txt");  // create a file scanner to read from the Customer file
        while (fileScanner.hasNext()){
            line = fileScanner.nextLine();  // assign the next line as a string in 'line'
            String[] values = line.split(",");   // store split values inside an array
            while (username.equals(values[0])){
                System.out.println("Username existed. Please use another username:");
                username = sc.nextLine();
            }
        } fileScanner.close();
        // after meeting the conditions, initialize values
        this.username = username;
        this.password = password;
        // write into the file
        PrintWriter pw = new PrintWriter(new FileWriter("src/customers1.txt", true));
        pw.printf("%s,%s,%s,%s,%s,%s,%s\n",this.customerID,this.username,this.password,fullName,phoneNumber,email,address);
        pw.close();
        System.out.println("Account registered!");
    }

    public boolean login(String username, String password) throws FileNotFoundException {
        // check if the user enter the right login values
        // read username and password from Customer file
        Scanner sc = new Scanner(System.in);
        String line;
        Scanner fileScanner = new Scanner(new File("src/customers1.txt"));
        while (fileScanner.hasNext()){
            line = fileScanner.nextLine();  // assign the next line as a string in 'line'
            String[] values = line.split(",");   // store split values inside an array

            String fileUsername = values[1];
            String filePass = values[2];
            if (username.equals(fileUsername) && password.equals(filePass)){
                System.out.println("Welcome!");
                this.customerID = values[0];
                this.username = values[1];
                this.password = values[2];
                this.fullName = values[3];
                this.phoneNumber = values[4];
                this.email = values[5];
                this.address = values[6];
                return true;
            }
        }
        return false;
    }

    public void updateInformation(){
        System.out.println("Which information do you want to update? (username, password," +
                " fullName, phoneNumber, email, address)");
        Scanner sc = new Scanner(System.in);
        String type = sc.next();    // take information type that user want to change
        System.out.printf("Enter your new %s: \n", type);
        String newValue = sc.nextLine();
        switch (type){
            case "username":
                setUsername(newValue);
                break;
            case "password":
                setPassword(newValue);
                break;
            case "fullName":
                setFullName(newValue);
                break;
            case "phoneNumber":
                setPhoneNumber(newValue);
                break;
            case "email":
                setEmail(newValue);
                break;
            case "address":
                setAddress(newValue);
                break;
        }
        System.out.printf("Your %s has been changed.\n", type);
    }



    // public int getAllOrder() {}

    // public checkMembership (String customerID) {}

    // public allProduct() {}

    @Override
    public String toString() {
        return "The Customer information are as follow{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", customerID='" + customerID + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }

    public void setUsername(String username) {
        // setting a new username
        this.username = username;
    }

    public void setPassword(String password) {
        // setting a new password
        this.password = password;
    }

    public void setFullName(String fullName) {
        // setting a new full name
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        // setting a new phone number
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email){
        // setting a new email
        this.email = email;
    }

    public void setAddress(String address){
        // setting a new address
        this.address = address;
    }

}
