/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.Connexion;
import DAO.ValidationService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Validation;

/**
 *
 * @author william
 */
public class ValidationImpl implements ValidationService{

    Connection conn;
    PreparedStatement prep;
    ResultSet result;
    String query;

    public ValidationImpl() {
        conn = Connexion.getInstance();
    }        
    
    @Override
    public void ajouter(Validation v) {
        try { 
            query = "insert into Validation values(?,?,?)";
            
            prep = conn.prepareStatement(query);
            
            prep.setString(1, v.getReqcode());
            prep.setString(2, v.getUsrcode());
            prep.setDate(3, v.getDatevalidation());
             
            prep.executeUpdate();
            
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(ValidationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierStatut(Validation v) {

        try {
            query = "update Requests set reqstatut = 'Validé' WHERE reqcode = ?";
            
            prep = conn.prepareStatement(query);
            
            prep.setString(1, v.getReqcode());
             
            prep.executeUpdate();
            
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(ValidationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Validation> lister() {
        List<Validation> liste = new ArrayList<Validation>();
        Validation a;
        try {
            query = "select * from Validation";
            prep = conn.prepareStatement(query);
            
            result = prep.executeQuery();
            
            while(result.next()){
                a = new Validation();
                
                a.setReqcode(result.getString(1));
                a.setUsrcode(result.getString(2));
                a.setDatevalidation(result.getDate(3));
            }
            
            prep.close();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(ValidationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
    }
    
}
