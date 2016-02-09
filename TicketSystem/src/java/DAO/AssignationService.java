/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Assignation;

/**
 *
 * @author william
 */
public interface AssignationService {
    
    public void Ajouter(Assignation a);
    public void ModifierStatut(Assignation a);
    public List<Assignation> lister();
    
}
