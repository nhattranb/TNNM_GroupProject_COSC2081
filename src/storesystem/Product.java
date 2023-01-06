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

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private String productID;
    private String productName; // unique and cannot be modified after initialization -> no setter method
    private double productPrice;
    private String productCategory = "None";
    private static int counter = 0;  // count every product object created to create unique ID
    private String currency = "VND";

    public Product(String productName, double productPrice, String productCategory) throws IOException {
        try (Scanner fileScanner = new Scanner(new File("src/storesystem/product.txt"))) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.next();
                while (!fileScanner.hasNext()) {
                    String lastLine = line;
                    String[] values = lastLine.split(",");
                    String[] part = values[0].split("(?<=\\D)(?=\\d)");
                    int number = Integer.parseInt(part[1]);
                    this.productID = "PRO" + ++number;
                    break;
                } // need to create a method to write new info to the txt file
            }
        } catch (IOException e) {}
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory='" + productCategory + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}