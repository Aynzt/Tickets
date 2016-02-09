/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.Connexion;
import DAO.TraitementService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Traitement;
import model.Validation;

/**
 *
 * @author william
 */
public class TraitementImpl implements TraitementService{
    Connection conn;
    PreparedStatement prep;
    ResultSet result;
    String query;

    public TraitementImpl() {
        conn = Connexion.getInstance();
    }

    
    
    @Override
    public void ajouter(Traitement t) {
        try {
            query = "insert into Traitement values(?,?,?)";
            
            prep = conn.prepareStatement(query);
            
            prep.setString(1, t.getReqcode());
            prep.setString(2, t.getUsrcode());
            prep.setDate(3, t.getDatetraitement());
             
            prep.executeUpdate();
            
            prep.close();       
        } catch (SQLException ex) {
            Logger.getLogger(TraitementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierStatut(Traitement t) {
        try {
            query = "update Requests set reqstatut = 'Traité' WHERE reqcode = ?";
            
            prep = conn.prepareStatement(query);
            
            prep.setString(1, t.getReqcode());
             
            prep.executeUpdate();
            
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(TraitementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Traitement> lister() {
        
        List<Traitement> liste = new ArrayList<Traitement>();
        Traitement a;
        
        try {            
        
            query = "select * from Traitement";
            prep = conn.prepareStatement(query);
            
            result = prep.executeQuery();
            
            while(result.next()){
                a = new Traitement();
                
                a.setReqcode(result.getString(1));
                a.setUsrcode(result.getString(2));
                a.setDatetraitement(result.getDate(3));
            }
            
            prep.close();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(TraitementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
    }
}
