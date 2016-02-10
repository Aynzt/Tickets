package model;

import java.sql.Date;

/**
 *
 * @author Lionel
 */
public class Utilisateur {
    
    private String usrcode;
    private String usrname;
    private String usrsubname;
    private String usrtype;
    private String usrmail;
    private String usrpwd;
    private String appcode;
    private String servcode;

    public Utilisateur() {
    }

    
    public Utilisateur(String usrcode, String usrname, String usrsubname, String usrtype, String usrmail, String usrpwd, String appcode, String servcode) {
        this.usrcode = usrcode;
        this.usrname = usrname;
        this.usrsubname = usrsubname;
        this.usrtype = usrtype;
        this.usrmail = usrmail;
        this.usrpwd = usrpwd;
        this.appcode = appcode;
        this.servcode = servcode;
    }

    public String getUsrcode() {
        return usrcode;
    }

    public void setUsrcode(String usrcode) {
        this.usrcode = usrcode;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getUsrsubname() {
        return usrsubname;
    }

    public void setUsrsubname(String usrsubname) {
        this.usrsubname = usrsubname;
    }

    public String getUsrtype() {
        return usrtype;
    }

    public void setUsrtype(String usrtype) {
        this.usrtype = usrtype;
    }

    public String getUsrmail() {
        return usrmail;
    }

    public void setUsrmail(String usrmail) {
        this.usrmail = usrmail;
    }

    public String getUsrpwd() {
        return usrpwd;
    }

    public void setUsrpwd(String usrpwd) {
        this.usrpwd = usrpwd;
    }

    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode;
    }

    public String getServcode() {
        return servcode;
    }

    public void setServcode(String servcode) {
        this.servcode = servcode;
    }
   
    

    
}
