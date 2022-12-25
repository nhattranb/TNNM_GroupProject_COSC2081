package storesystem;

public class Product {
    private String productID;
    private String productTitle;
    private String productPrice;
    private String productCategory;

    public Product (String productID, String productTitle, String productPrice, String productCategory) {
        this.productID = productID;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
    }

    public String getProductID() {
        return productID;
    }
}