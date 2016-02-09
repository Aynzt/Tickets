/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import DAOImpl.RequeteImpl;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import model.Requete;

/**
 *
 * @author william
 */
@Named(value = "homeMB")
@ViewScoped
public class HomeMB {

    Requete r;
    Requete r2;
    List<Requete> liste;
    RequeteImpl impl;
    /**
     * Creates a new instance of HomeMB
     */
    public HomeMB() {
        
        r = new Requete();
        r2 = new Requete();
        liste = new ArrayList<Requete>();
        impl = new RequeteImpl();        
    }

    public Requete getR() {
        return r;
    }

    public void setR(Requete r) {
        this.r = r;
    }

    public Requete getR2() {
        return r2;
    }

    public void setR2(Requete r2) {
        this.r2 = r2;
    }

    public List<Requete> getListe() {
        return impl.lister();
    }

    public void setListe(List<Requete> liste) {
        this.liste = liste;
    }
    
    public void ajouter(){
        
        r.setReqdate(new Date(System.currentTimeMillis()));
        impl.ajouter(r);
        
        FacesMessage msg = new FacesMessage("Save Completed");
        FacesContext.getCurrentInstance().addMessage(null, msg);
                        
    }
    
    public void modifier(){
        
        impl.ajouter(r);
        
        FacesMessage msg = new FacesMessage("Save Completed");
        FacesContext.getCurrentInstance().addMessage(null, msg);
                        
    }
    
    public void supprimer(){
        
        impl.ajouter(r);
        
        FacesMessage msg = new FacesMessage("Save Completed");
        FacesContext.getCurrentInstance().addMessage(null, msg);
                        
    }
}
