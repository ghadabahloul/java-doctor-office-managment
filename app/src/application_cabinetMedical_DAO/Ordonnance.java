/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_cabinetMedical_DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Date;


public class Ordonnance {
    
    private Connection conn = null; 
    
    private int codeOrdonnance;
    private Date dateOrdonnance;
    private String contenuOrdonnance;

    public Ordonnance(int codeOrdonnance, Date dateOrdonnance, String contenuOrdonnance) {
        this.codeOrdonnance = codeOrdonnance;
        this.dateOrdonnance = dateOrdonnance;
        this.contenuOrdonnance = contenuOrdonnance;
    }

    public int getCodeOrdonnance() {
        return codeOrdonnance;
    }
    public Date getDateOrdonnance() {
        return dateOrdonnance;
    }
    public String getContenuOrdonnance() {
        return contenuOrdonnance;
    }

    public void setCodeOrdonnance(int codeOrdonnance) {
        this.codeOrdonnance = codeOrdonnance;
    }
    public void setDateOrdonnance(Date dateOrdonnance) {
        this.dateOrdonnance = dateOrdonnance;
    }
    public void setContenuOrdonnance(String contenuOrdonnance) {
        this.contenuOrdonnance = contenuOrdonnance;
    }
    
    private void getconnection() throws SQLException
    {
	try {
		  Class.forName("com.mysql.jdbc.Driver");		
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("erreur");
	}
	String DBurl = "jdbc:mysql://127.0.0.1/cabinetmedicale";
	conn = DriverManager.getConnection(DBurl, "root", "000000");
    }
}
