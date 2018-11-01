/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

/**
 *
 * @author 
 */
    import java.sql.*;  
import javax.swing.JOptionPane;

public class User{
    
}
 class Manager {
    String name,email;
    int id,salary;
    Manager(String name,int id,String email,int salary){
        this.name=name;
        this.email=email;
        this.id=id;
        this.salary=salary;
    }
    
}

class Engineer{
    
                
                
    String name,email;
    int engineer_id,project_id,salary;
    Connection conn;
    Engineer(String name,String email,int Engineer_id,int project_id,int salary ){
        this.name=name;
        this.salary=salary;
        this.project_id=project_id;
        this.engineer_id=Engineer_id;
        this.email=email;
        String username="vedant ";
        String password="pepsin212";
        String address="jdbc:oracle:thin:@192.168.56.101:1521:xe";
        try{
            conn=DriverManager.getConnection(address,username,password);  
        }
        catch(SQLException e){
           
        }
    }
    
     void getDetails(String email){
         
     }
    
    
}

class Customer{
    int customer_id,pendingDues,project_id,flat_no;
    String name,email;
    Customer(){
        
    }
}