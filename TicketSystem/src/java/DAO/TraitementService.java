/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Traitement;
import model.Validation;

/**
 *
 * @author william
 */
public interface TraitementService {
    
    public void ajouter(Traitement t);
    public void modifierStatut(Traitement t);
    //public void supprimer(Validation v);
    public List<Traitement> lister();
    
}
