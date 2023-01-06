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
  Acknowledgement 1: https://stackoverflow.com/questions/59343388/total-profit-calculation-java-using-arrays-and-various-classes
  Acknowledgement 2: https://stackoverflow.com/questions/26790685/trying-to-print-out-the-best-customer-who-has-the-largest-amount-spent
*/

package storesystem;

import java.util.*;
public class Statistics extends Product {
    private double totalSpending;
    private String mostPopular;

    public String getLeastPopular() {
        return leastPopular;
    }

    public void setLeastPopular(String leastPopular) {
        this.leastPopular = leastPopular;
    }

    private String leastPopular;
    private double totalProfit;

    public double getSpending() {
        return totalSpending;
    }

    public void setTotalSpending(double totalSpending) {
        this.totalSpending = totalSpending;
    }

    public String getMostPopular() {
        return mostPopular;
    }

    public void setMostPopular(String mostPopular) {
        this.mostPopular = mostPopular;
    }

    public Product(String productID, String productTitle, String productPrice, String productCategory) {
        super(productID, productTitle, productPrice, productCategory);
    }

    public Customer(String username, String password, String fullName, String phoneNumber,
                    String email, String address) {
        super(username, password, fullName, phoneNumber, email, address);
    }
    public double totalProfit() {
        System.out.printf("%-15s%-15s", "Products:   ", getProductID());
        System.out.printf("%-15s%-10s", "Selling Price:", getProductPrice());
        System.out.printf("%-15s%-10s", "Stock Ordered Today:   ", getTotalOrder());
    }

    public void getAllCustomerMembership() {
        for (int i = 0; ...) {

        }
    }

    public void nameOfBestCustomer() {
        ArrayList<Double> sales = new ArrayList<Double>();
        ArrayList<String> customer = new ArrayList<String>();
        int[][] BestCustomer = new int[1][10];

        Scanner in = new Scanner(System.in);
        System.out.print("Total Number of Customers in today's store: ");
        int num = in.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print("Enter name of customer " + (i + 1) + ": \n");
            customer.add(in.next());

            System.out.print("Total amount for customer " + (i + 1) + ": \n");
            sales.add(in.nextDouble());
        }

        double maximum = Collections.max(sales);
        System.out.println("The Best Customer is " + customer
                + "with a purchase of ");
        System.out.println(String.format("$%.2f", maximum));
    }
}
