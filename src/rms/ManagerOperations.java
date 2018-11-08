/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;
import java.sql.*; 
import java.util.Vector;
import java.util.Random;
/**
 *
 * @author vedant,sushant,divyansh
 */
public class ManagerOperations {
    
    Connection conn;
    
    
    ManagerOperations(){
        String username="projectDatabase ";
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
        
        String query="select password from manager where email=?";
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
            
    String passwordGenerator(int length){
        String master="QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        String password="";
        Random random=new Random();
        for(int i=0;i<length;i++){
            password+=master.charAt(random.nextInt(master.length()));
        }
        return password;
    }
    void callProcedure()throws SQLException{
          CallableStatement cStmt = conn.prepareCall("{call discount}");
          cStmt.execute();
    }
    
    
    
    String addEngineersToDatabase(String name,int engineerId,int projectId,int salary,String email,String contact,int manager_id,String qualification)throws SQLException{
        String password=passwordGenerator(8);
        String query="insert into engineer values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1,name);
        stmt.setInt(2, engineerId);
        stmt.setInt(3, projectId);
        stmt.setInt(4, salary);
        stmt.setString(5, email);
        stmt.setString(6, password);
        stmt.setString(7, "");
        stmt.setString(8,qualification);
        stmt.setString(9,contact);
        stmt.setInt(10,manager_id);
        int rowAffected=stmt.executeUpdate();
        if(rowAffected>0)
            return password;
        else 
            return null;
    }
    String addBiuilderToDatabase(String name,int builder_id,String address,int project_id,String email,String qualification,int salary, String contact,int managerId)throws SQLException{
        String password=passwordGenerator(8);
        String query="Insert into Builder values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1,name);
        stmt.setInt(2, builder_id);
        stmt.setString(3, address);
        stmt.setInt(4, project_id);
        stmt.setString(5, email);
        stmt.setString(6, "");
        stmt.setString(7, password);
        stmt.setString(8, qualification);
        stmt.setInt(9, salary);
        stmt.setString(10,contact);
        stmt.setInt(11, managerId);
        int rowUpdated=stmt.executeUpdate();
        if(rowUpdated==0)
            return null;
        return password;
    }   
    
    boolean addProjectToDatabase(int project_id,String name,int etd,int budget,int manager_id)throws SQLException{
        boolean success=false;
        String query="insert into project values(?,?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(2,name);
        stmt.setInt(1,project_id);
        stmt.setInt(3,etd);
        stmt.setInt(4,budget);
        stmt.setNull(5, java.sql.Types.NULL);
        stmt.setInt(6,manager_id);
        int rowUpdated=stmt.executeUpdate();
        if(rowUpdated==1)
            return true;
        else return false;
        
    }
    
    
    //add a trigger to set dues to flat price
    String addCustomerToDatabase(String name,int customer_id,String email,String address,String phone )throws SQLException{
        String password=passwordGenerator(8);
        
        String query="insert into customer values(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt=conn.prepareStatement(query);
        stmt.setString(1,name);
        stmt.setInt(2, customer_id);
        stmt.setInt(3, 0);
        stmt.setString(4, email);
        stmt.setString(5,"");
        stmt.setString(6, password);
        stmt.setString(7, address);
        stmt.setString(8,phone);
        int rowUpdated=stmt.executeUpdate();
        if(rowUpdated==0)
            return null;
        return password;
        
    }
    void addLabourToDatabase(int labourId,int unitNo)throws SQLException{
        String query="Insert into labour values(?,?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setInt(1,labourId);
        stmt.setInt(2,unitNo);
        stmt.execute();
    }
    
    
    String[] getManagerDetails(String email)throws SQLException{
        String details[]=new String[2];
        String query="select name,Manager_id from manager where email=?";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs=stmt.executeQuery();
        rs.next();
        details[0]=rs.getString(1);//name
        details[1]=Integer.toString((rs.getInt(2)));//manager id
        return details;
    }
    
    Vector<Builder> getBuilders(String email)throws SQLException{
        String query="select * from builder where manager_id=(select manager_id from manager where email=?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs=stmt.executeQuery();
        Vector<Builder> builderArray=new Vector<Builder>();
        int i=0;
        while(rs.next()){
            Builder obj=new Builder();
            obj=new Builder();
            obj.name=rs.getString("name");
            obj.builder_id=rs.getInt("builder_id");
            obj.email=rs.getString("email");
            obj.contact=rs.getString("contact");
            obj.project_id=rs.getInt("project_id");
            builderArray.add(obj);
            i++;
        }
        return builderArray;
    }
    
    
    Vector<Engineer> getEngineer(String email)throws SQLException{
        String query="select * from engineer where manager_id=(select manager_id from manager where email=?)";
        PreparedStatement stmt=conn.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs=stmt.executeQuery();
        Vector<Engineer> engineerArray=new Vector<Engineer>();
        int i=0;
        while(rs.next()){
            Engineer obj=new Engineer();
            obj=new Engineer();
            obj.name=rs.getString("name");
            obj.engineer_id=rs.getInt("engineer_id");
            obj.email=rs.getString("email");
            obj.project_id=rs.getInt("project_id");
            obj.salary=rs.getInt("salary");
            engineerArray.add(obj);
            i++;
        }
        return engineerArray;
    }
    
     Vector<Customer> getCustomer()throws SQLException{
        String query="select * from customer";
        PreparedStatement stmt=conn.prepareStatement(query);
        ResultSet rs=stmt.executeQuery();
        Vector<Customer> customerArray=new Vector<Customer>();
        int i=0;
        while(rs.next()){
            Customer obj=new Customer();
            obj=new Customer();
            obj.name=rs.getString("name");
            obj.customer_id=rs.getInt("customer_id");
            obj.email=rs.getString("email");
            obj.pendingDues=rs.getInt("pendingdue");
            obj.contact=rs.getString("phone");
            
            customerArray.add(obj);
            i++;
        }
        return customerArray;
    }
     
     Vector<Labour> getLabour()throws SQLException{
        String query="select * from Labour";
        PreparedStatement stmt=conn.prepareStatement(query);
        ResultSet rs=stmt.executeQuery();
        Vector<Labour> labourArray=new Vector<Labour>();
        int i=0;
        while(rs.next()){
            Labour obj=new Labour();
            obj=new Labour();
            obj.labour_id=rs.getInt("labour_id");
            obj.unit_number=rs.getInt("unit_no");
            labourArray.add(obj);
            i++;
        }
        return labourArray;
    }
     Vector<Project> getProject(String email)throws SQLException{
        String query="select * from project where manager_id=(select manager_id from manager where email=?)";
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
            obj.customerId=rs.getInt("customer_id");
            obj.etd=rs.getInt("etd");
            projArray.add(obj);
            i++;
        }
        return projArray;
    }
     
   
    protected void finalize() throws Throwable {
       conn.close();
    }
    public static void main(String[] args)throws SQLException {
       ManagerOperations man=new ManagerOperations();
//       Vector<Project> vect=man.getProject("manager_3@gmail.com");
//        System.out.println(vect.size());
          man.callProcedure();
          System.out.println("called");
    }
}