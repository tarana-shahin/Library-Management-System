/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryserver;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tarana
 */
public class Connect {
    
     Connection conn=null;
     Connection getConnection(){
     try{
         Class.forName("com.mysql.jdbc.Driver");
         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/slibrary","root","");
         
         if (conn == null ) {
             throw new Exception();
         }
        }
     catch(Exception e){ 
         
         e.printStackTrace();
     }
     return conn;
     }
     
 
}
