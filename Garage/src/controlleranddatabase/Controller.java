/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleranddatabase;

import java.sql.SQLException;

/**
 *
 * @author Alek
 */
public class Controller {
    
    private DB db;
    private static Controller k;
    
    private Controller() {
        db = new DB();
    }
    
    public static Controller returnObject() {
        if (k == null) {
            k = new Controller();
        }
        return k;
    }
    
}
