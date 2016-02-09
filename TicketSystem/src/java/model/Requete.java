/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author PCPRO
 */
public class Requete {
    
    private String reqcode;
    private String reqobj;
    private String reqmotif;
    private String reqtype;
    private String reqstatut;
    private String usrcode;
    private String appcode;
    private Date reqdate;

    public Requete() {
    }

    public Requete(String reqcode, String reqobj, String reqmotif, String reqtype, String reqstatut, String usrcode, String appcode, Date reqdate) {
        this.reqcode = reqcode;
        this.reqobj = reqobj;
        this.reqmotif = reqmotif;
        this.reqtype = reqtype;
        this.reqstatut = reqstatut;
        this.usrcode = usrcode;
        this.appcode = appcode;
        this.reqdate = reqdate;
    }

    public String getReqcode() {
        return reqcode;
    }

    public void setReqcode(String reqcode) {
        this.reqcode = reqcode;
    }

    public String getReqobj() {
        return reqobj;
    }

    public void setReqobj(String reqobj) {
        this.reqobj = reqobj;
    }

    public String getReqmotif() {
        return reqmotif;
    }

    public void setReqmotif(String reqmotif) {
        this.reqmotif = reqmotif;
    }

    public String getReqtype() {
        return reqtype;
    }

    public void setReqtype(String reqtype) {
        this.reqtype = reqtype;
    }

    public String getReqstatut() {
        return reqstatut;
    }

    public void setReqstatut(String reqstatut) {
        this.reqstatut = reqstatut;
    }

    public String getUsrcode() {
        return usrcode;
    }

    public void setUsrcode(String usrcode) {
        this.usrcode = usrcode;
    }

    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode;
    }

    public Date getReqdate() {
        return reqdate;
    }

    public void setReqdate(Date reqdate) {
        this.reqdate = reqdate;
    }

   

    
        
}
