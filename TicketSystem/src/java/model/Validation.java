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
public class Validation {
    
    private String reqcode;
    private String usrcode;
    private Date datevalidation;

    public Validation() {
    }

    public Validation(String reqcode, String usrcode, Date datevalidation) {
        this.reqcode = reqcode;
        this.usrcode = usrcode;
        this.datevalidation = datevalidation;
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

    public Date getDatevalidation() {
        return datevalidation;
    }

    public void setDatevalidation(Date datevalidation) {
        this.datevalidation = datevalidation;
    }
        
}
