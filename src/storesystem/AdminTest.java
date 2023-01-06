package storesystem;

import java.io.IOException;
import java.util.Scanner;

public class AdminTest {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String us = sc.nextLine();
        System.out.println("Enter password: ");
        String pa = sc.nextLine();

        Admin adminLogin = new Admin(us,pa);
        adminLogin.displayAllCustomers();
        adminLogin.displayAllProducts();
        adminLogin.displayAllOrders();

        adminLogin.displayMenu();
        System.out.println("What do you wanna do: ");
        int num = sc.nextInt();
        while (num != 0) {
            if (num == 1) {
                adminLogin.addProduct();
                System.out.println("Product was added successfully");
                adminLogin.displayMenu();
            }
            if (num == 2) {
                System.out.println("Enter product ID: ");
                String productID = sc.nextLine();
                adminLogin.AccessTheProduct(productID);
                adminLogin.removeProduct();
                adminLogin.displayMenu();
            }
            if (num == 3) {
                System.out.println("Enter product ID: ");
                String productID = sc.nextLine();
                adminLogin.AccessTheProduct(productID);
                adminLogin.updatePrice();
                adminLogin.displayMenu();
            }
            if (num == 6) {
                System.out.println("Enter customer ID: ");
                String customerID = sc.nextLine();
                adminLogin.AccessTheCustomer(customerID);
                adminLogin.removeCustomer();
                adminLogin.displayMenu();
            }
            if (num == 10) {
                adminLogin.removeCategory();
                adminLogin.displayMenu();
            }


            System.out.println("Please enter a number: ");
            num = sc.nextInt();
        }
    }
}
