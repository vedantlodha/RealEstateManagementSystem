/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vedant
 */
public class BuilderOperation {
        Connection conn;
    public BuilderOperation() {
        String username="project ";
       String password="project";
       String address="jdbc:oracle:thin:@192.168.56.101:1521:xe";
       try{
            conn=DriverManager.getConnection(address,username,password);  

       }
       catch (SQLException e){
           System.out.println(e);
       }
    }
    boolean authenticate(String email,String enteredPassword)throws SQLException{
        String query="select password from builder where email=?";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs=stmt.executeQuery();
        if(!rs.next())
            return false;
        String password=rs.getString(1);
        if(enteredPassword.equals(password))
            return true;
        return false;
    }
    
}
