/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Validation;

/**
 *
 * @author william
 */
public interface ValidationService {
    
    public void ajouter(Validation v);
    public void modifierStatut(Validation v);
    public List<Validation> lister();
    
}
