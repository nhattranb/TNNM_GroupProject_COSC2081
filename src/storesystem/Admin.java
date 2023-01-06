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
  Acknowledgement: https://stackoverflow.com/questions/10168066/how-to-print-out-all-the-elements-of-a-list-in-java
*/


package storesystem;

import java.util.*;

public class Admin {
    private double numberOfAllOrders;
    private String username;

    public double getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(double orderNumber) {
        this.orderNumber = orderNumber;
    }

    private double orderNumber;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    private String customerID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void getAllOrder(double orderNumber) extends Order() {
        for (int i = 0; i < numberOfAllOrders; i++) {
            System.out.println(Order.get(i));
        }
    }

    public void CategoryAdding(String productCategory) {
        List<String> prodcat = new ArrayList<String>(Arrays.asList(productCategory.split(",")));
        prodcat.add(3);
    }

    public void CategoryRemoval(String productCategory) {
        List<String> prodcat = new ArrayList<String>(Arrays.asList(productCategory.split(",")));
        prodcat.remove(4);
}
