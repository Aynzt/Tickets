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
    
    private String code;
    private String mat;
    private String obj;
    private String mot;
    private String type;
    private Date dcreation;

    public Requete() {
    }

    public Requete(String code, String mat, String obj, String mot, String type, Date dcreation) {
        this.code = code;
        this.mat = mat;
        this.obj = obj;
        this.mot = mot;
        this.type = type;
        this.dcreation = dcreation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDcreation() {
        return dcreation;
    }

    public void setDcreation(Date dcreation) {
        this.dcreation = dcreation;
    }
        
}
