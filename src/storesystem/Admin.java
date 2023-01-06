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

public class Admin {
    private int Revenue;
    private String Membership;

    public int getRevenue() {
        return Revenue;
    }

    public void setRevenue(int revenue) {
        this.Revenue = revenue;
    }

    public String getMembership() {
        return Membership;
    }

    public void setMembership(String membership) {
        this.Membership = membership;
    }
}
