/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetBDD;

/**
 *
 * @author Julien
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Julien
 */
public class Main {
    public static void main (String[] args){
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
            cnx = DriverManager.getConnection(url_BD);
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
        
        String requestSansSelect = "INSERT INTO LIVRES VALUES('Bob','lol','2019-11-21', 'mdr', 'blabla', 7)";
        //String requestSansSelect = "DELETE FROM UTILISATEUR";
        try {
            int r = stmt.executeUpdate(requestSansSelect);
            System.out.println(r);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-4);
        }
        
//        String requestAvecSelect = "SELECT * FROM LIVRES";
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
//                String noms = rs.getString(1);
//                float poids = rs.getFloat("POIDS");
//                Date date = rs.getDate(3); 
//                System.out.println("nom : "+noms+" poids : "+poids+" date : "+date);      
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
