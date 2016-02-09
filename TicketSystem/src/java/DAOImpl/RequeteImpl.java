/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.Connexion;
import DAO.RequeteService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Requete;

/**
 *
 * @author PCPRO
 */
public class RequeteImpl implements RequeteService{

    Connection conn = Connexion.getInstance();
    PreparedStatement prep;
    ResultSet result;
    String query;
    
    @Override
    public void ajouter(Requete r) {

        try {
            query = "INSERT INTO requête VALUES(?,?,?,?,?,?)";
            
            prep = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            prep.setString(1, r.getCode());
            prep.setString(2, r.getMat());
            prep.setString(3, r.getObj());
            prep.setString(4, r.getMot());
            prep.setString(5, r.getType());
            prep.setDate(6, r.getDcreation());
            
            prep.executeUpdate();
            
            prep.close();            
        } catch (SQLException ex) {
            Logger.getLogger(RequeteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Requete r) {

        try {
            query = "UPDATE Requests SET MAT = ?, OBJ = ?, MOT = ? WHERE CODE = ?";
            
            prep = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            prep.setString(1, r.getMat());
            prep.setString(2, r.getObj());
            prep.setString(3, r.getMot());
            prep.setString(4, r.getType());
            prep.setString(5, r.getCode());
                       
            prep.executeUpdate();
            
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(RequeteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimer(Requete r) {
        
        try {
            query = "DELETE requête WHERE CODE = ?";
            
            prep = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            prep.setString(1, r.getCode());
                       
            prep.executeUpdate();
            
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(RequeteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Requete> lister() {

        List<Requete> liste = new ArrayList();
        Requete r;
        
        query = "SELECT * FROM requête";
            
        try {
            prep = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            result = prep.executeQuery();
            
            while(result.next()){
                
                r = new Requete();
                
                r.setCode(result.getString(1));
                r.setMat(result.getString(2));
                r.setObj(result.getString(3));
                r.setMot(result.getString(4));
                r.setType(result.getString(5));
                r.setDcreation(result.getDate(6));                
                
                liste.add(r);
            }
                        
            prep.close();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(RequeteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return liste;
    }
    
}
