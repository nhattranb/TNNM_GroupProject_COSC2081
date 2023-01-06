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
import java.util.StringTokenizer;

public class Admin {
    // Admin variables
    private String adUsername, adPassword;
    // Customer variables
    private String id, name, email, address, phone, membership, cusUsername, cusPassword;
    // Product variables
    private String proID, title, category;
    private float price;

    // Getters and setters
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getCusUsername() {
        return cusUsername;
    }

    public void setCusUsername(String cusUsername) {
        this.cusUsername = cusUsername;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public Admin(String username, String password) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        while (!login(username, password)) {
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
        Scanner fileScanner = new Scanner(new File("src/storesystem/admin.txt"));
        while (fileScanner.hasNext()) {
            line = fileScanner.nextLine();  // assign the next line as a string in 'line'
            String[] values = line.split(",");   // store split values inside an array

            String fileUsername = values[0];
            String filePass = values[1];
            if (username.equals(fileUsername) && password.equals(filePass)) {
                System.out.println("Welcome!");
                this.adUsername = values[0];
                this.adPassword = values[1];
                return true;
            }
        }
        return false;
    }

    public void displayAllCustomers() throws IOException {
        Scanner fileCusScanner = new Scanner(new File("src/storesystem/customers.txt"));
        System.out.println("ID, Name, Email, Address, Phone, Membership, Username, Password");

        while (fileCusScanner.hasNext()) {
            String line = fileCusScanner.nextLine();
            StringTokenizer inReader = new StringTokenizer(line, ",");
            if (inReader.countTokens() != 8)
                throw new IOException("Invalid Input Format");
            else {
                this.id = inReader.nextToken();
                this.name = inReader.nextToken();
                this.email = inReader.nextToken();
                this.address = inReader.nextToken();
                this.phone = inReader.nextToken();
                this.membership = inReader.nextToken();
                this.cusUsername = inReader.nextToken();
                this.cusPassword = inReader.nextToken();
            }
            System.out.printf("%s, %s, %s, %s, %s, %s, %s, %s \n",
                    id, name, email, address, phone, membership, cusUsername, cusPassword);
        }
        fileCusScanner.close();
    }
    public void displayAllProducts() throws IOException {
        Scanner fileProScanner = new Scanner(new File("src/storesystem/items.txt"));
        System.out.println("ID, Title, Price, Category");

        while (fileProScanner.hasNext()) {
            String line = fileProScanner.nextLine();
            StringTokenizer inReader = new StringTokenizer(line, ",");
            if (inReader.countTokens() != 4)
                throw new IOException("Invalid Input Format");
            else {
                this.proID = inReader.nextToken();
                this.title = inReader.nextToken();
                this.price = Float.parseFloat(inReader.nextToken());
                this.category = inReader.nextToken();
            }
            System.out.printf("%s %s %.1f %s \n",
                    proID, title, price, category);
        }
        fileProScanner.close();
    }
    public void displayAllOrders() {
        //
    }
    public void addProduct() throws IOException {
        String title, category;
        float price;
        int count = 11;
        int ranNum = (int) (Math.random() * 10000);

        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new FileWriter("src/storesystem/items.txt", true));

        System.out.println("Enter title:");
        title = scanner.nextLine();

        System.out.println("Enter price: ");
        price = Float.parseFloat(scanner.nextLine());

        System.out.println("Enter category: ");
        category = scanner.nextLine();

        // Write a string to a file
        pw.println("I0"+(count+1)+"-"+ranNum + "," + title + "," + price + "," + category);

        pw.flush();
        pw.close();
    }
    public void AccessTheProduct(String proID) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        while (!getItemsID(proID)){
            System.out.println("Wrong product ID, please enter again");
            proID = sc.nextLine();
        }
        System.out.println(this);
    }
    public boolean getItemsID(String proID) throws FileNotFoundException {
        String line;
        Scanner fileScanner = new Scanner(new File("src/storesystem/items.txt"));
        while (fileScanner.hasNext()){
            line = fileScanner.nextLine();  // assign the next line as a string in 'line'
            String[] values = line.split(",");   // store split values inside an array

            String fileProID = values[0];
            if (proID.equals(fileProID)){
                this.proID = values[0];
                this.title = values[1];
                this.price = Float.parseFloat(values[2]);
                this.category = values[3];
                return true;
            }
        } fileScanner.close();
        return false;
    }
    public void removeProduct() {
        try {
            File oldFile = new File("src/storesystem/items.txt");
            File tempFile = new File("src/storesystem/itemsTemp.txt");   // create a temporary text file to store new data
            PrintWriter pw = new PrintWriter(tempFile);   // write into the temporary file
            Scanner fileScanner = new Scanner(oldFile);
            String line;
            while (fileScanner.hasNext()){
                line = fileScanner.nextLine();
                String[] values = line.split(",");
                if (values[0].equals(proID)){
                    pw.print("");
                } else {
                    pw.printf("%s,%s,%s,%s\n",values[0],values[1],values[2],values[3]);
                }
            }
            pw.flush();
            pw.close();
            fileScanner.close();

            // copy back to the items.txt file
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
            System.out.println("The product was deleted");
        }
    }
    public void updatePrice() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your new price:");
        float newValue = sc.nextFloat();
        setPrice(newValue);

        try {
            File oldFile = new File("src/storesystem/items.txt");
            File tempFile = new File("src/storesystem/itemsTemp.txt");   // create a temporary text file to store new data
            PrintWriter pw = new PrintWriter(tempFile);   // write into the temporary file
            Scanner fileScanner = new Scanner(oldFile);
            String line;
            while (fileScanner.hasNext()){
                line = fileScanner.nextLine();
                String[] values = line.split(",");
                if (values[0].equals(proID)){
                    pw.printf("%s,%s,%s,%s\n",proID,getTitle(),getPrice(),getCategory());
                } else {
                    pw.printf("%s,%s,%s,%s\n",values[0],values[1],values[2],values[3]);
                }
            }
            pw.flush();
            pw.close();
            fileScanner.close();

            // copy back to the items.txt file
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
            System.out.println("Your price has been changed.");
        }
    }

    // public void getInfoAllOrder() {}

    // public void changeStatusOrder() {}

    public void AccessTheCustomer(String id) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        while (!getCustomersID(id)){
            System.out.println("Wrong customer ID, please enter again");
            id = sc.nextLine();
        }
        System.out.println(this);
    }
    public boolean getCustomersID(String id) throws FileNotFoundException {
        String line;
        Scanner fileScanner = new Scanner(new File("src/storesystem/customers.txt"));
        while (fileScanner.hasNext()){
            line = fileScanner.nextLine();  // assign the next line as a string in 'line'
            String[] values = line.split(",");   // store split values inside an array

            String fileCusID = values[0];
            if (id.equals(fileCusID)){
                this.id = values[0];
                this.name = values[1];
                this.email = values[2];
                this.address = values[3];
                this.phone = values[4];
                this.membership = values[5];
                this.cusUsername = values[6];
                this.cusPassword = values[7];
                return true;
            }
        } fileScanner.close();
        return false;
    }
    public void removeCustomer() {
        try {
            File oldFile = new File("src/storesystem/customers.txt");
            File tempFile = new File("src/storesystem/customersTemp.txt");   // create a temporary text file to store new data
            PrintWriter pw = new PrintWriter(tempFile);   // write into the temporary file
            Scanner fileScanner = new Scanner(oldFile);
            String line;
            while (fileScanner.hasNext()){
                line = fileScanner.nextLine();
                String[] values = line.split(",");
                if (values[0].equals(id)){
                    pw.print("");
                } else {
                    pw.printf("%s,%s,%s,%s,%s,%s,%s,%s\n",values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7]);
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
            System.out.println("The customer was deleted");
        }
    }

    // public void statisticOperators() {}

    // public void checkOrdersInfo() {}

    // public void addCategory() {}

    public void removeCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter category you wanna delete");
        String newValue = sc.nextLine();
        setCategory(newValue);

        try {
            File oldFile = new File("src/storesystem/items.txt");
            File tempFile = new File("src/storesystem/itemsTemp.txt");   // create a temporary text file to store new data
            PrintWriter pw = new PrintWriter(tempFile);   // write into the temporary file
            Scanner fileScanner = new Scanner(oldFile);
            String line;
            while (fileScanner.hasNext()){
                line = fileScanner.nextLine();
                String[] values = line.split(",");
                if (values[3].equals(category)){
                    pw.printf("%s,%s,%s\n",getProID(),getTitle(),getPrice());
                } else {
                    pw.printf("%s,%s,%s,%s\n",values[0],values[1],values[2],values[3]);
                }
            }
            pw.flush();
            pw.close();
            fileScanner.close();

            // copy back to the items.txt file
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
            System.out.println("Your category was removed");
        }
    }
}
