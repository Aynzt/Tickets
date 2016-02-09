/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Requete;

/**
 *
 * @author PCPRO
 */
public interface RequeteService {
    
    public void ajouter(Requete r);
    
    public void modifier(Requete r);
    
    public void supprimer(Requete r);
    
    public List<Requete> lister();
    
    public List<Requete> newRequest();
    
    public List<Requete> ValidatedRequest();
            
    public List<Requete> AssignedRequest();
    
    public List<Requete> DoneRequest();
}
