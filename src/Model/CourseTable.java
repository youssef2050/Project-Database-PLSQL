/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Youssef Ezz-Eldeen
 */
public class CourseTable {

   private String CourseID;
   private String Title;
   private String DeptName;
    private double Credits;

    public CourseTable(String CourseID, String Title, String DeptName, double Credits) {
        this.CourseID = CourseID;
        this.Title = Title;
        this.DeptName = DeptName;
        this.Credits = Credits;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String DeptName) {
        this.DeptName = DeptName;
    }

    public double getCredits() {
        return Credits;
    }

    public void setCredits(double Credits) {
        this.Credits = Credits;
    }
}
