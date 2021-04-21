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
public class DeptStudentTable {

    private int numberStudent;
    private String NameDepartment;

    public DeptStudentTable(int numberStudent, String NameDepartment) {
        this.numberStudent = numberStudent;
        this.NameDepartment = NameDepartment;
    }

    public int getNumberStudent() {
        return numberStudent;
    }

    public void setNumberStudent(int numberStudent) {
        this.numberStudent = numberStudent;
    }

    public String getNameDepartment() {
        return NameDepartment;
    }

    public void setNameDepartment(String NameDepartment) {
        this.NameDepartment = NameDepartment;
    }

}
