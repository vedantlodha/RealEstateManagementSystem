/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

/**
 *
 * @author vedant
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
public class CustomerOperations {
    Connection conn;
    CustomerOperations()throws SQLException{
       String username="projectDatabase ";
       String password="project";
       String address="jdbc:oracle:thin:@192.168.56.101:1521:xe";
       try{
            conn=DriverManager.getConnection(address,username,password);  

       }
       catch (SQLException e){
           throw new SQLException();
       }
    }
    boolean authenticate(String email,String enteredPassword)throws SQLException{
        String query="select password from customer where email=?";
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
    String[] getdetails(String email)throws SQLException{
        String query="select * from customer where email=?";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs=stmt.executeQuery();
        rs.next();
        String name=rs.getString("name");
        int customerId=rs.getInt("customer_id");
        String address=rs.getString("address");
        String contact=rs.getString("phone");
       
 
        
        
        String[] details={name,Integer.toString(customerId),contact,email,address};
        return details;
        
    }
    
     Vector<Project> getProject(String email)throws SQLException{
        String query="select * from project where customer_id=(select customer_id from customer where email=?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs=stmt.executeQuery();
        Vector<Project> projArray=new Vector<Project>();
        int i=0;
        while(rs.next()){
            Project obj=new Project();
            obj=new Project();
            obj.name=rs.getString("name");
            obj.project_id=rs.getInt("project_id");
            obj.budget=rs.getInt("budget");
            obj.etd=rs.getInt("etd");
            projArray.add(obj);
            i++;
        }
        return projArray;
    }
  
    public static void main(String[] args) throws SQLException{
        CustomerOperations cust=new CustomerOperations();
        Vector<Project> arr=cust.getProject("customer_1@gmail.com");
        System.out.println(arr.size());
         
        }
    }
}
