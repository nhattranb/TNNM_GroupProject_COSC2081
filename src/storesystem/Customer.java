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
import java.text.DecimalFormat;
import java.util.Scanner;
public class Customer {
    private String username;
    private String fullName;
    private String password;
    private String phoneNumber;
    private String email;
    private String address;
    private String customerID;
    // private static int counter = 1;
    private String customerType;


    public Customer(String username, String password, String fullName, String phoneNumber,
                    String email, String address) throws IOException {
        // generate a unique random ID for each customer
        int idNum = 0;
        File customerFile = new File("src/storesystem/customers.txt");
        Scanner fileScanner = new Scanner(customerFile);

        fileScanner.nextLine();    // skip the first line
        if (!fileScanner.hasNext()){
            idNum = 1;
        } else {
            while (fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                if (!fileScanner.hasNext()){
                    String[] splitLine = line.split(",");
                    String[] testNum = splitLine[0].split("(?<=\\D)(?=\\d)");
                    int numPart = Integer.parseInt(testNum[1]);
                    idNum = ++numPart;
                    break;
                }
            }
        }
        this.customerID = new DecimalFormat("C0000").format(idNum);
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
        System.out.println(toString());
    }

    public void registration(String username, String password) throws IOException {
       /* this method will read Customer file to find out
        similarities of values for registering conditions,
        then will write information of a new customer into that file. */

        Scanner sc = new Scanner(System.in);
        String line;   // to contain each line
        try (Scanner fileScanner = new Scanner(new File("src/storesystem/customers.txt"))) {
            while (fileScanner.hasNext()){
                line = fileScanner.nextLine();  // assign the next line as a string in 'line'
                String[] values = line.split(",");   // store split values inside an array
                while (username.equals(values[0])){
                    System.out.println("Username existed. Please use another username:");
                    username = sc.nextLine();
                }
            }
        }
        // after meeting the conditions, initialize values
        this.username = username;
        this.password = password;
        // write into the file
        PrintWriter pw = new PrintWriter(new FileWriter("src/storesystem/customers.txt", true));
        pw.printf("%s,%s,%s,%s,%s,%s,%s\n",this.customerID,this.username,this.password,fullName,phoneNumber,email,address);
        pw.flush();
        pw.close();
        System.out.println("Account registered!");
    }

    public boolean login(String username, String password) throws FileNotFoundException {
        // check if the user enter the right login values
        // read username and password from Customer file
        Scanner sc = new Scanner(System.in);
        String line;
        Scanner fileScanner = new Scanner(new File("src/customers.txt"));
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
        } fileScanner.close();
        return false;
    }

    public void showFunctionsMenu(){
        System.out.println("\nHere are some instruction for you. What do you want to do next?");
        System.out.println("0. Exit");
        System.out.println("1. Update your information.");
        System.out.println("2. Check your current membership status.");
        System.out.println("3. List all products");
        System.out.println("4. Search for available products.");
        System.out.println("5. Sort all products.");
        System.out.println("6. Create a new order.");
        System.out.println("7. Get order information.");
        System.out.println("8. Get all orders you have made.");
        System.out.println("Please enter a number to navigate your next move:");
    }

    public void updateInformation() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which information do you want to update? (1.username, 2.password," +
                " 3.fullName, 4.phoneNumber, 5.email, 6.address)");
        System.out.println("Please enter an appropriate number:");
        int type = sc.nextInt();    // take information type that user want to change
        sc.nextLine();
        System.out.println("Enter your new information:");
        String newValue = sc.nextLine();
        switch (type){
            case 1:
                setUsername(newValue);
                break;
            case 2:
                setPassword(newValue);
                break;
            case 3:
                setFullName(newValue);
                break;
            case 4:
                setPhoneNumber(newValue);
                break;
            case 5:
                setEmail(newValue);
                break;
            case 6:
                setAddress(newValue);
                break;
        }

        try {
            File oldFile = new File("src/customers.txt");
            File tempFile = new File("src/temp.txt");   // create a temporary text file to store new data
            PrintWriter pw = new PrintWriter(tempFile);   // write into the temporary file
            Scanner fileScanner = new Scanner(oldFile);
            String line;
            while (fileScanner.hasNext()){
                line = fileScanner.nextLine();
                String[] values = line.split(",");
                if (values[0].equals(customerID)){
                    pw.printf("%s,%s,%s,%s,%s,%s,%s\n",customerID,getUsername(),getPassword(),getFullName(),getPhoneNumber(),getEmail(),getAddress());
                } else {
                    pw.printf("%s,%s,%s,%s,%s,%s,%s\n",values[0],values[1],values[2],values[3],values[4],values[5],values[6]);
                }
            }
            pw.flush();
            pw.close();
            fileScanner.close();

            // copy back to the customers.txt file
            Scanner readFile = new Scanner(tempFile);
            PrintWriter writeNewData = new PrintWriter(oldFile);
            while (readFile.hasNext()){
                writeNewData.println(readFile.nextLine());
            }
            readFile.close();
            writeNewData.close();
            tempFile.delete();  // delete the temporary file after use

        } catch (Exception e){
            System.out.println("Something was wrong!");
            e.printStackTrace();    // print out the exception occur
        } finally {
            System.out.println("Your information has been changed.");
        }
    }

    public static void listAllProduct() throws IOException{
        try (Scanner fileScanner = new Scanner(new File("src/storesystem/product.txt"))) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                if (line.startsWith("PRO")) {
                    String[] values = line.split(",");
                    System.out.println(values[1]);
                }
            }
            fileScanner.close();
        } catch (Exception E) {}
    }

    public static void viewProductDetail(String productName) throws IOException{
        try (Scanner fileScanner = new Scanner(new File("src/storesystem/product.txt"))) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] values = line.split(",");
                if (productName.equalsIgnoreCase(values[1])) {
                    System.out.println("Product: " + values[1]);
                    System.out.println("ID: " + values[0]);
                    System.out.println("Price: " + values[3]);
                } else if (!fileScanner.hasNext()) {
                    System.out.println("No product available!");
                }
            } fileScanner.close();
        } catch (Exception e) {}
    }


    @Override
    public String toString() {
        return "The Customer information are as follow[" +
                "\ncustomer ID='"+ customerID+ '\'' +
                "\nusername='" + username + '\'' +
                "\nfull name='" + fullName + '\'' +
                "\npassword='" + password + '\'' +
                "\nphone number='" + phoneNumber + '\'' +
                "\naddress='" + address + '\'' +
                "\ncustomerType='" + customerType + '\'' +
                ']';
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

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

}
