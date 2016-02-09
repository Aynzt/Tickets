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
public class Assignation {
    private String reqcode;
    private String usrcode;
    private Date dateAssignation;

    public Assignation() {
    }

    public Assignation(String reqcode, String usrcode, Date dateAssignation) {
        this.reqcode = reqcode;
        this.usrcode = usrcode;
        this.dateAssignation = dateAssignation;
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

    public Date getDateAssignation() {
        return dateAssignation;
    }

    public void setDateAssignation(Date dateAssignation) {
        this.dateAssignation = dateAssignation;
    }
    
    
}
