package rms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EngineerOperations{

    Connection conn;
    public EngineerOperations() {
        String username="projectDatabase";
        String password="project";
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
    String[] getDetails(String email)throws SQLException{
        String query="select * from engineer where email=?";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1,email);
        ResultSet rs=stmt.executeQuery();
        rs.next();
        String name=rs.getString("name");
        String pid=rs.getString("project_id");
        String eid=rs.getString("engineer_id");
        String qualification=rs.getString("qualification");
        String salary=rs.getString("salary");
        String mid=rs.getString("Manager_id");
        String contact=rs.getString("contact");
        String arr[]={name,eid,pid,qualification,email,salary,mid,contact};
        return arr;
    }
    public static void main(String[] args) throws SQLException{
        EngineerOperations eng=new EngineerOperations();
//        System.out.println(eng.authenticate("engineer_1@gmail.com", "YZA@1234"));
        String arr[]=eng.getDetails("engineer_1@gmail.com");
        for(String s:arr){
            System.out.println(s);
        }
    }
}