/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.AssignationService;
import DAO.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assignation;
import model.Validation;

/**
 *
 * @author william
 */
public class AssignationImpl implements AssignationService {
    Connection conn;
    PreparedStatement prep;
    ResultSet result;
    String query;

    public AssignationImpl() {
        conn = Connexion.getInstance();
    }
    
    
    @Override
    public void Ajouter(Assignation a) {

        try {
            query = "insert into Assignation values(?,?,?)";
            
            prep = conn.prepareStatement(query);
            
            prep.setString(1, a.getReqcode());
            prep.setString(2, a.getUsrcode());
            prep.setDate(3, a.getDateAssignation());
             
            prep.executeUpdate();
            
            prep.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(AssignationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ModifierStatut(Assignation a) {
        try {
            query = "update Requests set reqstatut = 'Traité' WHERE reqcode = ?";
            
            prep = conn.prepareStatement(query);
            
            prep.setString(1, a.getReqcode());
             
            prep.executeUpdate();
            
            prep.close();
        } catch (SQLException ex) {
            Logger.getLogger(AssignationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Assignation> lister() {
        List<Assignation> liste = new ArrayList<Assignation>();
        Assignation a;
        
        try {
            query = "select * from Assignation";
            prep = conn.prepareStatement(query);
            
            result = prep.executeQuery();
            
            while(result.next()){
                a = new Assignation();
                
                a.setReqcode(result.getString(1));
                a.setUsrcode(result.getString(2));
                a.setDateAssignation(result.getDate(3));
            }
            
            prep.close();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(AssignationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
    }
    
}
