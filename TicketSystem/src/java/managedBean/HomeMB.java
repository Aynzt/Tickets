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
    List<Requete> oliste;
    List<Requete> newR;
    List<Requete> valideR;
    List<Requete> traiteR;
    List<Requete> assigneR;
    
    RequeteImpl impl = new RequeteImpl();
    /**
     * Creates a new instance of HomeMB
     */
    public HomeMB() {
        
        r = new Requete();
        r2 = new Requete();
        liste = new ArrayList<Requete>();         
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

    public List<Requete> getNewR() {
        return impl.newRequest();
    }

    public void setNewR(List<Requete> newR) {
        this.newR = newR;
    }

    public List<Requete> getValideR() {
        return impl.ValidatedRequest();
    }

    public void setValideR(List<Requete> valideR) {
        this.valideR = valideR;
    }

    public List<Requete> getTraiteR() {
        return impl.DoneRequest();
    }

    public void setTraiteR(List<Requete> traiteR) {
        this.traiteR = traiteR;
    }

    public List<Requete> getAssigneR() {
        return impl.AssignedRequest();
    }

    public void setAssigneR(List<Requete> assigneR) {
        this.assigneR = assigneR;
    }

    public List<Requete> getOliste() {
        return oliste;
    }

    public void setOliste(List<Requete> oliste) {
        this.oliste = oliste;
    }
    
    
    
    public void ajouterRFA(){
        
        r.setReqdate(new Date(System.currentTimeMillis()));
        r.setReqtype("RFA");
        r.setReqstatut("Nouveau");
        impl.ajouter(r);
        
        FacesMessage msg = new FacesMessage("Save Completed");
        FacesContext.getCurrentInstance().addMessage(null, msg);
                        
    }
    
    public void ajouterRFC(){
        
        r.setReqdate(new Date(System.currentTimeMillis()));
        r.setReqtype("RFC");
        r.setReqstatut("Nouveau");
        impl.ajouter(r);
        
        FacesMessage msg = new FacesMessage("Save Completed");
        FacesContext.getCurrentInstance().addMessage(null, msg);
                        
    }
    
    public void edit(){
        
        impl.modifier(r);
        
        FacesMessage msg = new FacesMessage("Update Completed");
        FacesContext.getCurrentInstance().addMessage(null, msg);
                        
    }
    
    public void delete(){
        
        impl.supprimer(r);
        
        FacesMessage msg = new FacesMessage("Delete Completed");
        FacesContext.getCurrentInstance().addMessage(null, msg);
                        
    }
}
