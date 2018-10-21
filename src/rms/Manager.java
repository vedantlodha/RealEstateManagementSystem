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
public class Manager {
    String name,email;
    int id,salary;
    Manager(String name,int id,String email,int salary){
        this.name=name;
        this.email=email;
        this.id=id;
        this.salary=salary;
    }
    void addBuilder(String name,int builder_id,String address,int project_id,String contact,String email){
        //create database object;
        OracleCon obj=new OracleCon();

        obj.addBiuilderToDatabase(name,builder_id,address,project_id,contact,email);
    }
    void addEngineer(String name,String Enginner_id,int project_id,int builder_id,int salary,string email){
        
    }
}
