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
        
    }
    Engineer(){
        
    }
    
    
    
    
}

class Customer{
    int customer_id,pendingDues;
    String name,email,contact;
    Customer(){        
    }
}

 class Project {
    String name;
    int project_id,etd,budget,customerId,managerId;
    Project(){}
}



class Labour{
    int labour_id,unit_number;
    Labour(){
    }
}


class Builder{
    String name,contact,email;
    int builder_id,project_id;
    Builder(String name,int builder_id,int project_id,String contact,String email){
        this.contact=contact;
        this.email=email;
        this.project_id =project_id;
        this.builder_id=builder_id;
        this.name=name;
        
    }
    Builder(){
    }
}