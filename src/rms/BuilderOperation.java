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
        String username="projectDatabase ";
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
    String[] getDetails(String email)throws SQLException{
        String query="select * from builder where email=?";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs=stmt.executeQuery();
        String name,address,contact;
        int builder_id,customer_id,manager_id,project_id;
        rs.next();
        name=rs.getString("name");
        address=rs.getString("address");
        contact=rs.getString("contact");
        builder_id=rs.getInt("builder_id");
        project_id=rs.getInt("project_id");
        manager_id=rs.getInt("MANAGER_ID");
        query="select name from project where project_id=?";
        stmt=conn.prepareStatement(query);
        stmt.setInt(1,project_id);
        rs=stmt.executeQuery();
        rs.next();
        String projectName=rs.getString("name");
        query="select name from manager where manager_id=?";
        stmt=conn.prepareStatement(query);
        stmt.setInt(1,manager_id);
        rs=stmt.executeQuery();
        rs.next();
        String manager=rs.getString("name");
        query="select customer.name from customer where customer_id=(select customer_id from project where project_id=?)";
        stmt=conn.prepareStatement(query);
        stmt.setInt(1, project_id);
        rs=stmt.executeQuery();
        rs.next();
        String customer=rs.getString(1);
        String[] details={name,Integer.toString(builder_id),projectName,email,address,contact,manager,customer};
        return details;
        
    }
    String[] getProjectDetais(String email)throws SQLException{
        String query="select * from project where project_id=(select project_id from builder where email=?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs=stmt.executeQuery();
        rs.next();
        String project_id=Integer.toString(rs.getInt("project_id"));
        String project_name=rs.getString("name");
        int customer_id=rs.getInt("customer_id");
        String budget=Integer.toString(rs.getInt("budget"));
        String manager_id=Integer.toString(rs.getInt("manager_id"));
        String etd=Integer.toString(rs.getInt("etd"));
        query="select name from manager where manager_id=?";
        stmt=conn.prepareStatement(query);
        stmt.setInt(1, Integer.parseInt(manager_id));
        rs=stmt.executeQuery();
        rs.next();
        String managerName=rs.getString("name");
        System.out.println(customer_id);
        query="select name,email from customer where customer_id=?";
        stmt=conn.prepareStatement(query);
        stmt.setInt(1,804);
        rs=stmt.executeQuery();
        rs.next();
        String customerName=rs.getString("name");
        String customerEmail=rs.getString("email");
        String projectDetails[]={project_name,project_id,etd,budget,managerName,customerName,customerEmail};
        return projectDetails;        
    }
    int updateBudget(int project_id,int newBudget)throws SQLException{
        String query="update project set budget=? where project_id=?";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setInt(1, newBudget);
        stmt.setInt(2, project_id);
        int rowUpdated=stmt.executeUpdate();
        return rowUpdated;
    }
    
    
    
    
//    boolean updatePayment(String email)throws SQLException{
//        String query="select builder_id";
//        
//    }
//    
    public static void main(String[] args)throws SQLException {
        BuilderOperation build=new BuilderOperation();
        build.updateBudget(4, 5000000);
        String details[]=build.getProjectDetais("builder_1@gmail.com");
        for(String s:details){
            System.out.println(s);
        }
    }
}
