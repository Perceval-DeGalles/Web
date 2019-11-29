/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet_bdd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien
 */
public class Projet_BDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String monDriver = "org.apache.derby.jdbc.ClientDriver";
        String  url_BD = "jdbc:derby://localhost:1527/LIVRE";

        try {
           Class.forName(monDriver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
        Connection cnx = null;
        
        try {
            cnx = DriverManager.getConnection(url_BD, "julien", "julien");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-2);
        }
        
        Statement stmt = null;
        
        try {
            stmt = cnx.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-3);
        }
        
        String requestSansSelect = "INSERT INTO APP.LIVRES(TITRE, AUTEUR, DATE, GENRE, SYNOPSIS, QTE) VALUES('Bob','lol','2019-11-21', 'mdr', 'blabla', 7)";
        try {
            int r = stmt.executeUpdate(requestSansSelect);
            System.out.println(r);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-4);
        }
        
//        String requestAvecSelect = "SELECT * FROM APP.LIVRES";
//        ResultSet rs = null;
//        
//        try {
//            rs = stmt.executeQuery(requestAvecSelect);
//                        
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.exit(-4);
//        }
//        try {
//            while (rs.next()){
//                String titre = rs.getString(1);
//                String auteur = rs.getString(2);             
//                Date date = rs.getDate(3); 
//                System.out.println("nom : "+titre+" poids : "+auteur+" date : "+date);      
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.exit(-5);
//        }
//        try {
//            rs.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.exit(-5);
//        }
        
        try {
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-5);
        }
        
        try {
            cnx.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-6);
        }



    }

}
