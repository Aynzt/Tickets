/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author PCPRO
 */
@Named(value = "homeMB")
@Dependent
public class HomeMB {

    /**
     * Creates a new instance of HomeMB
     */
    public HomeMB() {
    }
    
}
