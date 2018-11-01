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
public class CustomerOperations {
    Connection conn;
    CustomerOperations()throws SQLException{
       String username="project ";
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
        int project_id=rs.getInt("project_id");
        int flatNo=rs.getInt("flat_no");
        int dues=rs.getInt("pendingdue");
        query="select name from builder where project_id=?";
        stmt=conn.prepareStatement(query);
        stmt.setInt(1, project_id);
        rs=stmt.executeQuery();
        rs.next();
        String builderName=rs.getString(1);
        query="select etd from project where project_id=?";
        stmt=conn.prepareStatement(query);
        
        stmt.setInt(1, project_id);
        rs=stmt.executeQuery();
        rs.next();
        int etd=rs.getInt("etd");
        
        String[] details={name,Integer.toString(customerId),Integer.toString(flatNo),Integer.toString(project_id),email,Integer.toString(etd),builderName};
        return details;
        
    }
    public static void main(String[] args) throws SQLException{
        CustomerOperations cust=new CustomerOperations();
        String arr[]=cust.getdetails("thud");
        for(String s:arr){
            System.out.println(s);
        }
    }
}
