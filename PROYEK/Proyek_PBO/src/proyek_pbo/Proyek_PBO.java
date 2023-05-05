/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyek_pbo;

import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WIN10
 */
public class Proyek_PBO {

    /**
     * @param args the command line arguments
     */
    public static Connection conn;
    
    public static void main(String[] args) 
    {
        try {
            // TODO code application logic here
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newproyek","root","");
            System.out.println("Berhasil");
            
        } catch (Exception ex) {
            System.out.println("Error karena " + ex.getMessage());
            //Logger.getLogger(Proyek_PBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoginForm f = new LoginForm();
        f.setVisible(true);
    }
    
}
