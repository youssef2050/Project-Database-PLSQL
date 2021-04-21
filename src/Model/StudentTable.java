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
public class StudentTable {

    private String id;
    private String name;
    private String DeptID;
    private double Tot_cred;

    public StudentTable(String id, String name, String DeptID, double Tot_cred) {
        this.id = id;
        this.name = name;
        this.DeptID = DeptID;
        this.Tot_cred = Tot_cred;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptID() {
        return DeptID;
    }

    public void setDeptID(String DeptID) {
        this.DeptID = DeptID;
    }

    public double getTot_cred() {
        return Tot_cred;
    }

    public void setTot_cred(double Tot_cred) {
        this.Tot_cred = Tot_cred;
    }

}
