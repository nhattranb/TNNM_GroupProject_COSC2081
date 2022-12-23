package storesystem;

public class Customer {
    private String username;
    private String fullName;
    private String password;
    private String phoneNumber;
    private String address;
    private String customerID;
    private String customerType;

    public void login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


}
