/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PCPRO
 */
public class Connexion {
    
    private static Connection conn;
    
    private String url = "jdbc:mysql://localhost:3306/Ticket";
    private String usr = "root";
    private String pwd = "root";
    
    private Connexion(){
        try {
            conn = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Connexion Ok");
            
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getInstance(){
        if(conn == null){
            new Connexion();
        }        
        return conn;
    }
    
}
