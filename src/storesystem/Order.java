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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderID;
    private String orderDate;
    private String orderStatus;
    private String customerID;
    private String customerName;

    public String getOrderHistoryID() {
        return orderHistoryID;
    }

    public void setOrderHistoryID(String orderHistoryID) {
        this.orderHistoryID = orderHistoryID;
    }

    private String orderHistoryID;


    public double getnumberOfAllOrders() {
        return numberOfAllOrders;
    }

    public void setnumberOfAllOrders(double numberOfAllOrders) {
        this.numberOfAllOrders = numberOfAllOrders;
    }

    private double numberOfAllOrders;

    public void numberOfAllOrders (double numberOfAllOrders) {
        return (getOrderHistoryID());
    }

    public Order() {
        this.orderID = orderID;
        this.orderStatus = orderStatus;
    }

    public orderStatus (String orderStatus) {
        System.out.println("your order has been set...");
        String orderStatus = "PAID";
    }

    public getOrder(String orderID, String orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
    }
}
