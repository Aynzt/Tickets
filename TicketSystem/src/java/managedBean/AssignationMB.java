/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import DAOImpl.AssignationImpl;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import model.Assignation;

/**
 *
 * @author william
 */
@Named(value = "assignationMB")
@ViewScoped
public class AssignationMB {
    Assignation a;
    Assignation a2;
    List<Assignation> liste;
    AssignationImpl impl = new AssignationImpl();
    /**
     * Creates a new instance of AssignationMB
     */
    public AssignationMB() {
        a = new Assignation();
        a2 = new Assignation();
        liste = new ArrayList<Assignation>();
    }

    public Assignation getA() {
        return a;
    }

    public void setA(Assignation a) {
        this.a = a;
    }

    public Assignation getA2() {
        return a2;
    }

    public void setA2(Assignation a2) {
        this.a2 = a2;
    }

    public List<Assignation> getListe() {
        return impl.lister();
    }

    public void setListe(List<Assignation> liste) {
        this.liste = liste;
    }
    
    
    public void add(){
        a.setDateAssignation(new Date(System.currentTimeMillis()));
        impl.Ajouter(a);
        impl.ModifierStatut(a);
        
        FacesMessage msg = new FacesMessage("Saved Completed");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
