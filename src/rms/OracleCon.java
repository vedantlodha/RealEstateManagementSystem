/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;
    import java.sql.*;  
    class OracleCon{  
    Connection con;
    OracleCon(){
    try{  
    Class.forName("oracle.jdbc.driver.OracleDriver");  
     
    
    /***************************************************
     *********change username password and address******
    *****************************************************/
     String username="";
     String password="";
     String address="";
    Connection con=DriverManager.getConnection(address,username,password);  
          
    }
    catch(Exception e){ 
        System.out.println(e);
    }  
      
    }

   



void addBiuilderToDatabase(String name,int builder_id,String address,int project_id,String contact,String email){
    try{    
        Statement stmt=con.createStatement();
        String query="Insert into builder values ('"+name+"',"+builder_id+","+project_id+",'"+contact+"','"+email+"')";
        stmt.executeUpdate(query);
    }
    catch(Exception e){
        System.out.println(e);
    }
}

void addEngineerToDatabase(String name,int engineer_id,int project_id,int builder_id,int salary,String email ){
    try{    
        Statement stmt=con.createStatement();
        String query="Insert into Engineer values ('"+name+"',"+engineer_id+","+project_id+","+builder_id+","+salary+",'"+email+"')";
        stmt.executeUpdate(query);

    }
    catch(Exception e){
        System.out.println(e);
    }
}
void addCustomerToDatabase(String name,int cust_id,int project_id,int flat_no,String email){
    int pendingDues;
    try{
        Statement getPrice=con.createStatement();
        String query="Select price from flat where (project_id="+project_id+"and flat_no="+flat_no;
        ResultSet rs=getPrice.executeQuery(query);
        pendingDues=rs.getInt("price");
        Statement insertCustomer=con.createStatement();
        query="insert into customer values('"+name+","+cust_id+","+project_id+","+flat_no+","+pendingDues+",'"+email+"'";
        insertCustomer.executeUpdate(query);

        
    }
    catch(Exception e){
        System.out.println(e);
    }
}

protected void finalize() throws Throwable {
        con.close();
    }
    void updatePayment(){}
    void updateSalary(){}
    void remove(){}
}


    
            
            
            
            
