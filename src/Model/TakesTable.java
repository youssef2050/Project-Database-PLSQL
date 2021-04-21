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
public class TakesTable {

    private String ID;
    private String COURSE_ID;
    private String SEC_ID;
    private String SEMESTER;
    private String YEAR;
    private String GRADE;

    public TakesTable(String ID, String COURSE_ID, String SEC_ID, String SEMESTER, String YEAR, String GRADE) {
        this.ID = ID;
        this.COURSE_ID = COURSE_ID;
        this.SEC_ID = SEC_ID;
        this.SEMESTER = SEMESTER;
        this.YEAR = YEAR;
        this.GRADE = GRADE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(String COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

    public String getSEC_ID() {
        return SEC_ID;
    }

    public void setSEC_ID(String SEC_ID) {
        this.SEC_ID = SEC_ID;
    }

    public String getSEMESTER() {
        return SEMESTER;
    }

    public void setSEMESTER(String SEMESTER) {
        this.SEMESTER = SEMESTER;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public String getGRADE() {
        return GRADE;
    }

    public void setGRADE(String GRADE) {
        this.GRADE = GRADE;
    }

}
