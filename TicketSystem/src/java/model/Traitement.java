/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author william
 */
public class Traitement {
    private String reqcode;
    private String usrcode;
    private Date datetraitement;

    public Traitement() {
    }

    public Traitement(String reqcode, String usrcode, Date datetraitement) {
        this.reqcode = reqcode;
        this.usrcode = usrcode;
        this.datetraitement = datetraitement;
    }

    public String getReqcode() {
        return reqcode;
    }

    public void setReqcode(String reqcode) {
        this.reqcode = reqcode;
    }

    public String getUsrcode() {
        return usrcode;
    }

    public void setUsrcode(String usrcode) {
        this.usrcode = usrcode;
    }

    public Date getDatetraitement() {
        return datetraitement;
    }

    public void setDatetraitement(Date datetraitement) {
        this.datetraitement = datetraitement;
    }   
        
}
