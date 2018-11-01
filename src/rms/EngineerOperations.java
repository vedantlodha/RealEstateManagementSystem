package rms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EngineerOperations{

    Connection conn;
    public EngineerOperations() {
        String username="vedant ";
        String password="pepsin212";
        String address="jdbc:oracle:thin:@192.168.56.101:1521:xe";
        try{
            conn=DriverManager.getConnection(address,username,password);  
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    boolean authenticate(String email,String enteredPassword)throws SQLException{
        String query="select password from engineer where email=?";
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
    int leaveProject(String email)throws SQLException{
        String query="delete from engineer where email=?";
        
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1, email);
        int success=stmt.executeUpdate();
        return success;
    }
//    String[] getDetails(String email){
////        query="select name,Engineer_Id,project_id"
////        PreparedStatement stmt=
//    }
    public static void main(String[] args) throws SQLException{
//        EngineerOperations eng=new EngineerOperations();
//        System.out.println(eng.authenticate("qwert", "1234567890"));
    }
}