package managedBean;

import DAOImpl.UtilisateurImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Utilisateur;

/**
 *
 * @author PCPRO
 */
@ManagedBean
@SessionScoped
public class IndexMB {

    /**
     * Creates a new instance of IndexMB
     */
    private UtilisateurImpl ui;
    private Utilisateur user;
    private List<Utilisateur> usrlist;
    private Utilisateur us;
    private Utilisateur usm;
            
    public IndexMB() {
        user=new Utilisateur();
        ui=new UtilisateurImpl();
        usrlist=new ArrayList<Utilisateur>();
        us=new Utilisateur();
        usm=new Utilisateur();
    }

    public String connecter(){
        Utilisateur ut = ui.connecter(user.getUsrmail(), user.getUsrpwd());
        String nextpage;
        if(ut==null){
            FacesMessage fm=new FacesMessage("Connexion impossible !!!");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            nextpage="index.xhtml";
        }else{
            FacesMessage fm=new FacesMessage("Connexion rÃ©ussie !!!");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            nextpage="Utilisateur.xhtml";
        }
        return nextpage;
    }
    
    public List<Utilisateur> lister(){
        return ui.listerUtilisateur();
    }
    
    public List<String> listerAppcode(){
        return ui.listerAppcode();
    }
    
    public List<String> listerServcode(){
        return ui.listerServcode();
    }
    
    public String ajouter(){
        boolean bol = ui.ajouterUtilisateur(us);
        if(bol){
            FacesMessage fm=new FacesMessage("Utilisateur ajoutÃ© avec succÃ¨s !!!");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else{
            FacesMessage fm=new FacesMessage("Erreur !!! L'utilisateur n'a pas Ã©tÃ© ajoutÃ©.");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        us = new Utilisateur();
        return "Utilisateur.xhtml";
    }
    
    public String modifier(){
        boolean bol = ui.modifierUtilisateur(usm);
        if(bol){
            FacesMessage fm=new FacesMessage("Utilisateur modifiÃ© avec succÃ¨s !!!");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }else{
            FacesMessage fm=new FacesMessage("Erreur !!! L'utilisateur n'a pas Ã©tÃ© modifiÃ©.");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        usm = new Utilisateur();
        return "Utilisateur.xhtml";
    }
    
    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public List<Utilisateur> getUsrlist() {
        return usrlist;
    }

    public void setUsrlist(List<Utilisateur> usrlist) {
        this.usrlist = usrlist;
    }

    public Utilisateur getUs() {
        return us;
    }

    public void setUs(Utilisateur us) {
        this.us = us;
    }

    public Utilisateur getUsm() {
        return usm;
    }

    public void setUsm(Utilisateur usm) {
        this.usm = usm;
    }       
    
}
