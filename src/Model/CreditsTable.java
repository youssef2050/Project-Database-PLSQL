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
public class CreditsTable {

    private String Credit;
    private String Title;
    private String Name;

    public CreditsTable(String Credit, String Title, String Name) {
        this.Credit = Credit;
        this.Title = Title;
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public CreditsTable(String Credit, String Title) {
        this.Credit = Credit;
        this.Title = Title;
    }

    public String getCredit() {
        return Credit;
    }

    public void setCredit(String Credit) {
        this.Credit = Credit;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

}
