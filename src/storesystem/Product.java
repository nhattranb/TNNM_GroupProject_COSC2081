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

public class Product {
    private String productID;
    private String productTitle;

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    private String productPrice;
    private String productCategory;

    public Product (String username, String password, String productID, String productTitle) {
        this.productID = productID;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
    }

    public String getProductID() {
        return productID;
    }
}