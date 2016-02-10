package DAOImpl;

import DAO.Connexion;
import DAO.UtilisateurService;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Utilisateur;

/**
 *
 * @author Lionel
 */
public class UtilisateurImpl implements UtilisateurService{

    Connection conn ;
    PreparedStatement prep;
    Statement st;
    ResultSet result;
    String query;
    private String url = "jdbc:mysql://localhost:3306/Ticket";
    private String usr = "root";
    private String pwd = "";
    private String driver="com.mysql.jdbc.Driver";

    public UtilisateurImpl() {
        
    }
    
    public Connection connecter(){
            try {
                Driver pilote=(Driver)Class.forName(driver).newInstance();
                DriverManager.registerDriver(pilote);
                conn= DriverManager.getConnection(url, usr, pwd);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        return conn;
    }
    
    public void deconnecter(){
        try {
            if(!conn.isClosed())
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public boolean ajouterUtilisateur(Utilisateur u) {
        connecter();
        boolean bo=false;
        try {
            prep=conn.prepareStatement("insert into Utilisateur values(?,?,?,?,?,?,?,?)");
            prep.setString(1, u.getUsrcode());
            prep.setString(2, u.getUsrname());
            prep.setString(3, u.getUsrsubname());
            prep.setString(4, u.getUsrtype());
            prep.setString(5, u.getUsrmail());
            prep.setString(6, u.getUsrpwd());
            prep.setString(7, u.getAppcode());
            prep.setString(8, u.getServcode());
            prep.executeUpdate();
            deconnecter();
            bo=true;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImpl.class.getName()).log(Level.SEVERE, null, ex);
            deconnecter();
        }
        return bo;
    }

    @Override
    public boolean modifierUtilisateur(Utilisateur u) {
        connecter();
        boolean bol=false;
        Utilisateur ut=connecter(u.getUsrmail(), u.getUsrpwd());
        if(ut==null)
            ;
        else{
            try {
                prep=conn.prepareStatement("update Utilisateur set usrname=?, usrsubname=?, usrtype=?, usrmail=?, usrpwd=?, appcode=?, servcode=? where usrcode=?");
                prep.setString(1, u.getUsrname());
                prep.setString(2, u.getUsrsubname());
                prep.setString(3, u.getUsrtype());
                prep.setString(4, u.getUsrmail());
                prep.setString(5, u.getUsrpwd());
                prep.setString(6, u.getAppcode());
                prep.setString(7, u.getServcode());
                prep.setString(8, u.getUsrcode());
                prep.executeUpdate();
                deconnecter();
                bol=true;
            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurImpl.class.getName()).log(Level.SEVERE, null, ex);
                deconnecter();
            }
        }
        return bol;
        
    }

    @Override
    public boolean supprimerUtilisateur(Utilisateur u) {
        connecter();
        boolean bol=false;
        Utilisateur ut=connecter(u.getUsrmail(), u.getUsrpwd());
        if(ut==null)
            ;
        else{
            try {
                prep=conn.prepareStatement("delete from Utilisateur where usrcode=?");
                prep.setString(1, u.getUsrcode());
                prep.executeUpdate();
                deconnecter();
                bol=true;
            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurImpl.class.getName()).log(Level.SEVERE, null, ex);
                deconnecter();
            }
        }
        return bol;
    }

    @Override
    public List<Utilisateur> listerUtilisateur() {
        connecter();
        List<Utilisateur> li=new LinkedList<Utilisateur>();
        try {
            prep=conn.prepareStatement("select * from Utilisateur");
            result=prep.executeQuery();
            Utilisateur ut=new Utilisateur();
            while(result.next()){
                ut.setUsrcode(result.getString("usrcode"));
                ut.setUsrname(result.getString("usrname"));
                ut.setUsrsubname(result.getString("usrsubname"));
                ut.setUsrtype(result.getString("usrtype"));
                ut.setUsrmail(result.getString("usrmail"));
                ut.setUsrpwd(result.getString("usrpwd"));
                ut.setAppcode(result.getString("appcode"));
                ut.setServcode(result.getString("servcode"));
                li.add(ut);
                ut=new Utilisateur();
            }
            deconnecter();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImpl.class.getName()).log(Level.SEVERE, null, ex);
            deconnecter();
        }
        return li;
    }

    @Override
    public Utilisateur connecter(String login, String pwd) {
        connecter();
        Utilisateur ut = new Utilisateur();
        try {
            prep = conn.prepareStatement("select * from Utilisateur where usrmail=? and usrpwd=?");
            prep.setString(1, login);
            prep.setString(2, pwd);
            result=prep.executeQuery();
            result.next();
            ut.setUsrcode(result.getString("usrcode"));
            ut.setUsrname(result.getString("usrname"));
            ut.setUsrsubname(result.getString("usrsubname"));
            ut.setUsrtype(result.getString("usrtype"));
            ut.setUsrmail(result.getString("usrmail"));
            ut.setUsrpwd(result.getString("usrpwd"));
            ut.setAppcode(result.getString("appcode"));
            ut.setServcode(result.getString("servcode"));
            deconnecter();
        } catch (SQLException ex) {
            ut=null;
            deconnecter();
        }
        return ut;
    }
    
    public List<String> listerAppcode(){
        connecter();
        List<String> li= new LinkedList<String>();
        try {
            prep=conn.prepareStatement("select appcode from Application");
            result=prep.executeQuery();
            while(result.next()){
                li.add(result.getString("appcode"));
            }
            deconnecter();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImpl.class.getName()).log(Level.SEVERE, null, ex);
            deconnecter();
        }
        return li;
    }
    public List<String> listerServcode(){
        connecter();
        List<String> li= new LinkedList<String>();
        try {
            prep=conn.prepareStatement("select servcode from Service");
            result=prep.executeQuery();
            while(result.next()){
                li.add(result.getString("servcode"));
            }
            deconnecter();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurImpl.class.getName()).log(Level.SEVERE, null, ex);
            deconnecter();
        }
        return li;
    }
}
