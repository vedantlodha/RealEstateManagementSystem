/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;
import java.sql.*; 
import java.util.Random;
/**
 *
 * @author vedant,sushant,divyansh
 */
public class ManagerDB {
    
    Connection conn;
    
    
    ManagerDB(){
        String username="vedant ";
        String password="pepsin212";
        String address="jdbc:oracle:thin:@192.168.56.101:1521:xe";
    }
    
    
    String passwordGenerator(int length){
        String master="QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        String password="";
        Random random=new Random();
        for(int i=0;i<length;i++){
            password+=master.charAt(random.nextInt(master.length()));
        }
        return password;
    }
    
    
    
    String addEngineersToDatabase(String name,int engineerId,int projectId,int builderId,int salary,String email)throws SQLException{
        String password=passwordGenerator(8);
        String query="insert into engineer values (?,?,?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1,name);
        stmt.setInt(2, engineerId);
        stmt.setInt(3, projectId);
        stmt.setInt(4, builderId);
        stmt.setInt(5, salary);
        stmt.setString(6, email);
        stmt.setString(7, password);
        int rowAffected=stmt.executeUpdate();
        if(rowAffected>0)
            return password;
        else 
            return null;
    }
    String addBiuilderToDatabase(String name,int builder_id,String address,int project_id,String contact,String email)throws SQLException{
        String password=passwordGenerator(8);
        String query="Insert into Builder values(?,?,?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1,name);
        stmt.setInt(2, builder_id);
        stmt.setString(3, address);
        stmt.setInt(4, project_id);
        stmt.setString(5, contact);
        stmt.setString(6, email);
        stmt.setString(7, password);
        int rowUpdated=stmt.executeUpdate();
        if(rowUpdated==0)
            return null;
        return password;
    }   
    
    int getDues(int customer_id)throws SQLException{
        int dues=0;
            
            Statement stmt=conn.createStatement();
            String query="Select PendingDues from customer where customer_id="+customer_id;
            ResultSet rs=stmt.executeQuery(query);
            rs.next();
            dues=rs.getInt(1);
            return dues;
    }
    
    
    
    //add a trigger to set dues to flat price
    String addCustomerToDatabase(String name,int customer_id,int project_id,int flatNo,String email )throws SQLException{
        String password=passwordGenerator(8);
        int dues;
        String query="select price from flat where project_id=? and flat_no=?";
        PreparedStatement stmt= conn.prepareStatement(query);
        stmt.setInt(1,flatNo);
        stmt.setInt(2, project_id);
        ResultSet rs=stmt.executeQuery();
        rs.next();
        dues=rs.getInt(1);
        query="insert into customer values(?,?,?,?,?,?)";
        stmt=conn.prepareStatement(query);
        stmt.setString(1,name);
        stmt.setInt(2, customer_id);
        stmt.setInt(3, project_id);
        stmt.setInt(4, flatNo);
        stmt.setInt(5,dues);
        stmt.setString(6, email);
        stmt.setString(7, password);
        int rowUpdated=stmt.executeUpdate();
        if(rowUpdated==0)
            return null;
        return password;
        
    }
}
