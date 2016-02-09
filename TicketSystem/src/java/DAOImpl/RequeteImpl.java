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

    Connection conn;
    PreparedStatement prep;
    ResultSet result;
    String query;

    public RequeteImpl() {
        conn = Connexion.getInstance();
    }
    
        
    @Override
    public void ajouter(Requete r) {

        try {
            query = "insert into Requests values(?.?.?.?.?.?.?.?)"; 
            
            prep = conn.prepareStatement(query);
            
            prep.setString(1, r.getReqcode());
            prep.setString(2, r.getReqobj());
            prep.setString(3, r.getReqmotif());
            prep.setString(4, r.getReqtype());
            prep.setString(5, r.getReqstatut());
            prep.setDate(6, r.getReqdate());
            prep.setString(7, r.getUsrcode());
            prep.setString(8, r.getAppcode());
            
            prep.executeUpdate();
            
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(RequeteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @Override
    public void modifier(Requete r) {

        try {
            query = "update Requests set reqobj = ?, reqmotif = ?, reqtype = ?, reqstatut = ?, usrcode = ?, appcode = ? where reqcode = ?";
                       
            prep = conn.prepareStatement(query);
            
            
            prep.setString(1, r.getReqobj());
            prep.setString(2, r.getReqmotif());
            prep.setString(3, r.getReqtype());
            prep.setString(4, r.getReqstatut());
            
            //prep.setDate(6, r.getReqdate());
           
            prep.setString(5, r.getUsrcode());
            prep.setString(6, r.getAppcode()); 
            
            prep.setString(7, r.getReqcode());
                    
            prep.executeUpdate();
            
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(RequeteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimer(Requete r) {
        
        try {
            query = "DELETE Requests WHERE reqcode = ?";
            
            prep = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            prep.setString(1, r.getReqcode());
                       
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
        
        query = "select *  from requests";
            
        try {
            prep = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            result = prep.executeQuery();
            
            while(result.next()){
                
                r = new Requete();
                
                r.setReqcode(result.getString(1));
                r.setReqobj(result.getString(2));
                r.setReqmotif(result.getString(3));
                r.setReqtype(result.getString(4));
                r.setReqstatut(result.getString(5));
                r.setReqdate(result.getDate(6));
                r.setUsrcode(result.getString(7));
                r.setAppcode(result.getString(8));
                
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
