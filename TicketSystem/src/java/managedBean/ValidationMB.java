/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import DAOImpl.ValidationImpl;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import model.Validation;

/**
 *
 * @author william
 */
@Named(value = "validationMB")
@ViewScoped
public class ValidationMB {
    
    Validation v;
    Validation v2;
    List<Validation> liste;
    ValidationImpl impl = new ValidationImpl();
    
    /**
     * Creates a new instance of ValidationMB
     */
    public ValidationMB() {        
        v = new Validation();
        v2 = new Validation();
        liste = new ArrayList<Validation>();        
    }

    public Validation getV() {
        return v;
    }

    public void setV(Validation v) {
        this.v = v;
    }

    public Validation getV2() {
        return v2;
    }

    public void setV2(Validation v2) {
        this.v2 = v2;
    }

    public List<Validation> getListe() {
        return impl.lister();
    }

    public void setListe(List<Validation> liste) {
        this.liste = liste;
    }
    
    public void add(){
        v.setDatevalidation(new Date(System.currentTimeMillis()));
        impl.ajouter(v);
        impl.modifierStatut(v);
        
        FacesMessage msg = new FacesMessage("Saved Completed");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
