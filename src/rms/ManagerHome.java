/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;
import java.sql.*; 

import java.awt.Color;
import java.net.ConnectException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.*;
import java.util.Vector;
/**
 *
 * @author vedant
 */
public class ManagerHome extends javax.swing.JFrame {

    
    Connection conn;
    int managerId;
    String email;
    String name;
    public ManagerHome(String email) {
        this.email=email;
        String username="vedant ";
        String password="pepsin212";
        String address="jdbc:oracle:thin:@192.168.56.101:1521:xe";
        try{
            conn=DriverManager.getConnection(address,username,password);  
        }
        catch(SQLException e){
            System.out.println(e);
        }
        initComponents();
        try{
            ManagerOperations obj=new ManagerOperations();
            String details[]=obj.getManagerDetails(email);
            this.managerId=Integer.parseInt(details[1]);
            this.name=details[0];
            lblName.setText(name);
            lblEmail.setText(email);
            lblId.setText(Integer.toString(managerId));
        }
        catch (Exception e){
        }
        
        
        /*******************************************************
         * Initial button settings
         *******************************************************/
        button1.setBackground(Color.white);
        button2.setBackground(Color.white);
        button3.setBackground(Color.white);
        button4.setBackground(Color.white);
        button5.setBackground(Color.white);
        
        indicator2.setBackground(Color.white);
        indicator3.setBackground(Color.white);
        indicator4.setBackground(Color.white);
        indicator5.setBackground(Color.white);
        
        
        /***************************************************************/
        
        /*****************************************************
         * add values to the table
         * 
         *****************************************************/
        //add values to builder table
        ManagerOperations obj=new ManagerOperations();
            try{
                Vector<Builder> arr=obj.getBuilders(email);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                for(Builder b:arr){
                    model.addRow(new Object[]{b.name,b.builder_id,b.project_id,b.email,b.contact});
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
            
        //add values to engineer table
        try{
             Vector<Engineer> arr=obj.getEngineer(email);
                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                for(Engineer e:arr){
                    model.addRow(new Object[]{e.name,e.engineer_id,e.project_id,e.email,e.salary});
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);

        }
        
        //add values to customer table
        try{
             Vector<Customer> arr=obj.getCustomer();
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                for(Customer c:arr){
                    model.addRow(new Object[]{c.name,c.customer_id,c.contact,c.email,c.pendingDues});
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);

        }
        
        
        // add vlaues to labour table
        try{
             Vector<Labour> arr=obj.getLabour();
                DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
                for(Labour l:arr){
                    model.addRow(new Object[]{l.labour_id,l.unit_number});
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);

        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        button1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        indicator1 = new javax.swing.JPanel();
        buttonHome1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        button2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        indicator2 = new javax.swing.JPanel();
        button5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        indicator5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        button3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        indicator3 = new javax.swing.JPanel();
        button4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        indicator4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cardParent = new javax.swing.JPanel();
        homeCard = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ViewProjectCArd = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ProjectTable = new javax.swing.JTable();
        addEmployeeCard = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        addEmpParent = new javax.swing.JPanel();
        Customer = new javax.swing.JPanel();
        cust_name_txt = new javax.swing.JTextField();
        cust_email_txt = new javax.swing.JTextField();
        cust_phone_TXT = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jSeparator37 = new javax.swing.JSeparator();
        cust_id_txt = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jSeparator38 = new javax.swing.JSeparator();
        jSeparator39 = new javax.swing.JSeparator();
        jSeparator40 = new javax.swing.JSeparator();
        jLabel55 = new javax.swing.JLabel();
        cust_address_txt = new javax.swing.JTextField();
        confirm6 = new javax.swing.JButton();
        jSeparator42 = new javax.swing.JSeparator();
        Labour = new javax.swing.JPanel();
        Builder1 = new javax.swing.JPanel();
        lab_unit_txt = new javax.swing.JTextField();
        jSeparator43 = new javax.swing.JSeparator();
        lab_id_txt = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jSeparator44 = new javax.swing.JSeparator();
        confirm7 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        Builder = new javax.swing.JPanel();
        buil_name_txt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        contact_txt = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jSeparator31 = new javax.swing.JSeparator();
        buil_id_text = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jSeparator32 = new javax.swing.JSeparator();
        jSeparator33 = new javax.swing.JSeparator();
        addressTxt4 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jSeparator34 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        buil_projID = new javax.swing.JTextField();
        jSeparator35 = new javax.swing.JSeparator();
        confirm5 = new javax.swing.JButton();
        jSeparator36 = new javax.swing.JSeparator();
        jLabel57 = new javax.swing.JLabel();
        qualification = new javax.swing.JTextField();
        jSeparator45 = new javax.swing.JSeparator();
        jLabel58 = new javax.swing.JLabel();
        managerIDtxt = new javax.swing.JTextField();
        jSeparator46 = new javax.swing.JSeparator();
        jLabel61 = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();
        jSeparator49 = new javax.swing.JSeparator();
        Engineer = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        engg_name_txt = new javax.swing.JTextField();
        jSeparator25 = new javax.swing.JSeparator();
        engg_id_txt = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        engg_email_txt = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        engg_salary_txt = new javax.swing.JTextField();
        jSeparator27 = new javax.swing.JSeparator();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        engg_projId_txt = new javax.swing.JTextField();
        confirm4 = new javax.swing.JButton();
        jSeparator30 = new javax.swing.JSeparator();
        jLabel43 = new javax.swing.JLabel();
        engg_qualification_txt = new javax.swing.JTextField();
        jSeparator41 = new javax.swing.JSeparator();
        jLabel54 = new javax.swing.JLabel();
        engg_managerID_txt = new javax.swing.JTextField();
        jSeparator47 = new javax.swing.JSeparator();
        jLabel56 = new javax.swing.JLabel();
        engg_contact_txt = new javax.swing.JTextField();
        jSeparator48 = new javax.swing.JSeparator();
        editEmployeeCard = new javax.swing.JPanel();
        addProjectCard = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        proj_name_txt = new javax.swing.JTextField();
        jSeparator50 = new javax.swing.JSeparator();
        jLabel63 = new javax.swing.JLabel();
        ProjId_txt = new javax.swing.JTextField();
        jSeparator51 = new javax.swing.JSeparator();
        jLabel64 = new javax.swing.JLabel();
        etd_txt = new javax.swing.JTextField();
        jSeparator52 = new javax.swing.JSeparator();
        jLabel66 = new javax.swing.JLabel();
        budget_txt = new javax.swing.JTextField();
        jSeparator54 = new javax.swing.JSeparator();
        confirm8 = new javax.swing.JButton();
        viewInfoCard = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        viewBuilders = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        viewCustomers = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        viewEngineers = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        viewLabours = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RMS-Manger");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(java.awt.Color.white);
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setBackground(java.awt.Color.white);
        button1.setForeground(java.awt.Color.white);
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button1MouseEntered(evt);
            }
        });
        button1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(33, 21, 21));
        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Home");
        button1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 210, 37));

        indicator1.setBackground(new java.awt.Color(119, 119, 119));

        javax.swing.GroupLayout indicator1Layout = new javax.swing.GroupLayout(indicator1);
        indicator1.setLayout(indicator1Layout);
        indicator1Layout.setHorizontalGroup(
            indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        indicator1Layout.setVerticalGroup(
            indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        button1.add(indicator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        sidePanel.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 270, -1));

        buttonHome1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(119, 119, 119));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        buttonHome1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        sidePanel.add(buttonHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 197, -1, -1));

        button2.setForeground(java.awt.Color.white);
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button2MouseEntered(evt);
            }
        });
        button2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add Employee");
        button2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 0, 220, 37));

        indicator2.setBackground(new java.awt.Color(119, 119, 119));

        javax.swing.GroupLayout indicator2Layout = new javax.swing.GroupLayout(indicator2);
        indicator2.setLayout(indicator2Layout);
        indicator2Layout.setHorizontalGroup(
            indicator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        indicator2Layout.setVerticalGroup(
            indicator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        button2.add(indicator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        sidePanel.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 270, -1));

        button5.setForeground(java.awt.Color.white);
        button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button5MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button5MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button5MouseEntered(evt);
            }
        });
        button5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("View Employee");
        button5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 0, 230, 37));

        indicator5.setBackground(new java.awt.Color(119, 119, 119));

        javax.swing.GroupLayout indicator5Layout = new javax.swing.GroupLayout(indicator5);
        indicator5.setLayout(indicator5Layout);
        indicator5Layout.setHorizontalGroup(
            indicator5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        indicator5Layout.setVerticalGroup(
            indicator5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        button5.add(indicator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        sidePanel.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 270, -1));

        jPanel1.setBackground(new java.awt.Color(119, 119, 119));

        jLabel6.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Manager Portal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        sidePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 110));

        button3.setForeground(java.awt.Color.white);
        button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button3MouseEntered(evt);
            }
        });
        button3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(java.awt.Color.white);
        jLabel11.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("View Project Details");
        button3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 0, 230, 37));

        indicator3.setBackground(new java.awt.Color(119, 119, 119));

        javax.swing.GroupLayout indicator3Layout = new javax.swing.GroupLayout(indicator3);
        indicator3.setLayout(indicator3Layout);
        indicator3Layout.setHorizontalGroup(
            indicator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        indicator3Layout.setVerticalGroup(
            indicator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        button3.add(indicator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        sidePanel.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 270, -1));

        button4.setForeground(java.awt.Color.white);
        button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button4MouseEntered(evt);
            }
        });
        button4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(java.awt.Color.white);
        jLabel12.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Add project");
        button4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 0, 230, 37));

        indicator4.setBackground(new java.awt.Color(119, 119, 119));

        javax.swing.GroupLayout indicator4Layout = new javax.swing.GroupLayout(indicator4);
        indicator4.setLayout(indicator4Layout);
        indicator4Layout.setHorizontalGroup(
            indicator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        indicator4Layout.setVerticalGroup(
            indicator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        button4.add(indicator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        sidePanel.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 270, -1));

        getContentPane().add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 507));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(115, 115, 115));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 20)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Welcome");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 172, 45));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rms/icons/icons8-apartment-96.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 70));

        jLabel9.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 20)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Real Estate Management System");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 400, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rms/icons/icons8-shutdown-24.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 30, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 110));

        cardParent.setLayout(new java.awt.CardLayout());

        homeCard.setAlignmentX(1.0F);

        jLabel7.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 24)); // NOI18N
        jLabel7.setText("Personal Information");

        jSeparator1.setBackground(new java.awt.Color(1, 1, 1));
        jSeparator1.setForeground(java.awt.Color.black);
        jSeparator1.setAlignmentY(1.0F);
        jSeparator1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel5.setBackground(new java.awt.Color(216, 216, 216));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("Name");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 76, 67, -1));

        jLabel13.setText("ID");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 111, 67, -1));

        jPanel6.setBackground(new java.awt.Color(56, 56, 56));
        jPanel6.setForeground(new java.awt.Color(254, 254, 254));

        lblName.setForeground(new java.awt.Color(254, 254, 254));
        lblName.setText("NAme");

        lblId.setForeground(new java.awt.Color(254, 254, 254));
        lblId.setText("ID");

        lblEmail.setForeground(new java.awt.Color(254, 254, 254));
        lblEmail.setText("Email");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblName)
                .addGap(18, 18, 18)
                .addComponent(lblId)
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 57, -1, 180));

        jLabel14.setText("Email");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jButton1.setText("Provide Discount");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 160, -1));

        javax.swing.GroupLayout homeCardLayout = new javax.swing.GroupLayout(homeCard);
        homeCard.setLayout(homeCardLayout);
        homeCardLayout.setHorizontalGroup(
            homeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeCardLayout.createSequentialGroup()
                .addGroup(homeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(homeCardLayout.createSequentialGroup()
                        .addGroup(homeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        homeCardLayout.setVerticalGroup(
            homeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeCardLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
        );

        cardParent.add(homeCard, "card2");

        ViewProjectCArd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project Name", "Project ID ", "ETD(months)", "Customer ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(ProjectTable);

        ViewProjectCArd.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 700, 390));

        cardParent.add(ViewProjectCArd, "card6");

        addEmployeeCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 24)); // NOI18N
        jLabel15.setText("ADD EMPLOYEE");
        addEmployeeCard.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 39, 221, 40));
        addEmployeeCard.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 220, 10));

        jLabel16.setText("Employee type");
        addEmployeeCard.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select--", "Builder", "Engineer", "Customer", "Labour" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        addEmployeeCard.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        addEmpParent.setLayout(new java.awt.CardLayout());

        Customer.setBackground(new java.awt.Color(115, 115, 115));
        Customer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cust_name_txt.setBackground(new java.awt.Color(115, 115, 115));
        cust_name_txt.setForeground(new java.awt.Color(254, 254, 254));
        cust_name_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cust_name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_name_txtActionPerformed(evt);
            }
        });
        Customer.add(cust_name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 210, 30));

        cust_email_txt.setBackground(new java.awt.Color(115, 115, 115));
        cust_email_txt.setForeground(new java.awt.Color(254, 254, 254));
        cust_email_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cust_email_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_email_txtActionPerformed(evt);
            }
        });
        Customer.add(cust_email_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 210, 30));

        cust_phone_TXT.setBackground(new java.awt.Color(115, 115, 115));
        cust_phone_TXT.setForeground(new java.awt.Color(254, 254, 254));
        cust_phone_TXT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cust_phone_TXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_phone_TXTActionPerformed(evt);
            }
        });
        Customer.add(cust_phone_TXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 210, 30));

        jLabel50.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(254, 254, 254));
        jLabel50.setText("Phone");
        Customer.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel51.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(254, 254, 254));
        jLabel51.setText("Email");
        Customer.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel52.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(254, 254, 254));
        jLabel52.setText("Name");
        Customer.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));
        Customer.add(jSeparator37, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 210, -1));

        cust_id_txt.setBackground(new java.awt.Color(115, 115, 115));
        cust_id_txt.setForeground(new java.awt.Color(254, 254, 254));
        cust_id_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cust_id_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_id_txtActionPerformed(evt);
            }
        });
        cust_id_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cust_id_txtKeyPressed(evt);
            }
        });
        Customer.add(cust_id_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 210, 30));

        jLabel53.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(254, 254, 254));
        jLabel53.setText("Customer ID");
        Customer.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));
        Customer.add(jSeparator38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, -1));
        Customer.add(jSeparator39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 210, 10));
        Customer.add(jSeparator40, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 210, 10));

        jLabel55.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(254, 254, 254));
        jLabel55.setText("Address");
        Customer.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        cust_address_txt.setBackground(new java.awt.Color(115, 115, 115));
        cust_address_txt.setForeground(new java.awt.Color(254, 254, 254));
        cust_address_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cust_address_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_address_txtActionPerformed(evt);
            }
        });
        Customer.add(cust_address_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 210, 30));

        confirm6.setBackground(new java.awt.Color(0, 128, 255));
        confirm6.setForeground(java.awt.Color.white);
        confirm6.setText("Confirm");
        confirm6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm6ActionPerformed(evt);
            }
        });
        Customer.add(confirm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 130, -1));
        Customer.add(jSeparator42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 210, 10));

        addEmpParent.add(Customer, "card4");

        Labour.setBackground(new java.awt.Color(115, 115, 115));
        Labour.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Builder1.setBackground(new java.awt.Color(115, 115, 115));
        Builder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_unit_txt.setBackground(new java.awt.Color(115, 115, 115));
        lab_unit_txt.setForeground(new java.awt.Color(254, 254, 254));
        lab_unit_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lab_unit_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lab_unit_txtActionPerformed(evt);
            }
        });
        Builder1.add(lab_unit_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 210, 30));
        Builder1.add(jSeparator43, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 210, 10));

        lab_id_txt.setBackground(new java.awt.Color(115, 115, 115));
        lab_id_txt.setForeground(new java.awt.Color(254, 254, 254));
        lab_id_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lab_id_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lab_id_txtActionPerformed(evt);
            }
        });
        Builder1.add(lab_id_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 210, 30));

        jLabel59.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(254, 254, 254));
        jLabel59.setText("Labour ID");
        Builder1.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));
        Builder1.add(jSeparator44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 210, -1));

        confirm7.setBackground(new java.awt.Color(0, 128, 255));
        confirm7.setForeground(java.awt.Color.white);
        confirm7.setText("Confirm");
        confirm7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm7ActionPerformed(evt);
            }
        });
        Builder1.add(confirm7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 130, -1));

        jLabel60.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(254, 254, 254));
        jLabel60.setText("Unit Number");
        Builder1.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        Labour.add(Builder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        addEmpParent.add(Labour, "card5");

        Builder.setBackground(new java.awt.Color(115, 115, 115));
        Builder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buil_name_txt.setBackground(new java.awt.Color(115, 115, 115));
        buil_name_txt.setForeground(new java.awt.Color(254, 254, 254));
        buil_name_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buil_name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buil_name_txtActionPerformed(evt);
            }
        });
        Builder.add(buil_name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 30));

        emailTxt.setBackground(new java.awt.Color(115, 115, 115));
        emailTxt.setForeground(new java.awt.Color(254, 254, 254));
        emailTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });
        Builder.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 210, 30));

        contact_txt.setBackground(new java.awt.Color(115, 115, 115));
        contact_txt.setForeground(new java.awt.Color(254, 254, 254));
        contact_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contact_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_txtActionPerformed(evt);
            }
        });
        Builder.add(contact_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 210, 30));

        jLabel45.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(254, 254, 254));
        jLabel45.setText("Contact");
        Builder.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        jLabel46.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(254, 254, 254));
        jLabel46.setText("Email");
        Builder.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel40.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(254, 254, 254));
        jLabel40.setText("Name");
        Builder.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));
        Builder.add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 210, -1));

        buil_id_text.setBackground(new java.awt.Color(115, 115, 115));
        buil_id_text.setForeground(new java.awt.Color(254, 254, 254));
        buil_id_text.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buil_id_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buil_id_textActionPerformed(evt);
            }
        });
        Builder.add(buil_id_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 210, 30));

        jLabel47.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(254, 254, 254));
        jLabel47.setText("Builder ID");
        Builder.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));
        Builder.add(jSeparator32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 210, -1));
        Builder.add(jSeparator33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 210, 10));

        addressTxt4.setBackground(new java.awt.Color(115, 115, 115));
        addressTxt4.setForeground(new java.awt.Color(254, 254, 254));
        addressTxt4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addressTxt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTxt4ActionPerformed(evt);
            }
        });
        Builder.add(addressTxt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 210, 30));

        jLabel48.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(254, 254, 254));
        jLabel48.setText("Address");
        Builder.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));
        Builder.add(jSeparator34, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 210, 10));

        jLabel49.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(254, 254, 254));
        jLabel49.setText("Project ID");
        Builder.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        buil_projID.setBackground(new java.awt.Color(115, 115, 115));
        buil_projID.setForeground(new java.awt.Color(254, 254, 254));
        buil_projID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buil_projID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buil_projIDActionPerformed(evt);
            }
        });
        Builder.add(buil_projID, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 210, 30));
        Builder.add(jSeparator35, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 210, -1));

        confirm5.setBackground(new java.awt.Color(0, 128, 255));
        confirm5.setForeground(java.awt.Color.white);
        confirm5.setText("Confirm");
        confirm5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm5ActionPerformed(evt);
            }
        });
        Builder.add(confirm5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 130, -1));
        Builder.add(jSeparator36, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 210, 10));

        jLabel57.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(254, 254, 254));
        jLabel57.setText("Qualification");
        Builder.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        qualification.setBackground(new java.awt.Color(115, 115, 115));
        qualification.setForeground(new java.awt.Color(254, 254, 254));
        qualification.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        qualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualificationActionPerformed(evt);
            }
        });
        Builder.add(qualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 30));
        Builder.add(jSeparator45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 210, 10));

        jLabel58.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(254, 254, 254));
        jLabel58.setText("Manager ID");
        Builder.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        managerIDtxt.setBackground(new java.awt.Color(115, 115, 115));
        managerIDtxt.setForeground(new java.awt.Color(254, 254, 254));
        managerIDtxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        managerIDtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerIDtxtActionPerformed(evt);
            }
        });
        Builder.add(managerIDtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 210, 30));
        Builder.add(jSeparator46, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 210, 10));

        jLabel61.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(254, 254, 254));
        jLabel61.setText("Salary");
        Builder.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));

        salary.setBackground(new java.awt.Color(115, 115, 115));
        salary.setForeground(new java.awt.Color(254, 254, 254));
        salary.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryActionPerformed(evt);
            }
        });
        Builder.add(salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 210, 30));
        Builder.add(jSeparator49, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 210, 10));

        addEmpParent.add(Builder, "card3");

        Engineer.setBackground(new java.awt.Color(115, 115, 115));
        Engineer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(254, 254, 254));
        jLabel38.setText("Name");
        Engineer.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        engg_name_txt.setBackground(new java.awt.Color(115, 115, 115));
        engg_name_txt.setForeground(new java.awt.Color(254, 254, 254));
        engg_name_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        engg_name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engg_name_txtActionPerformed(evt);
            }
        });
        Engineer.add(engg_name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 210, 30));
        Engineer.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 210, -1));

        engg_id_txt.setBackground(new java.awt.Color(115, 115, 115));
        engg_id_txt.setForeground(new java.awt.Color(254, 254, 254));
        engg_id_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        engg_id_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engg_id_txtActionPerformed(evt);
            }
        });
        Engineer.add(engg_id_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 210, 30));

        jLabel39.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(254, 254, 254));
        jLabel39.setText("Engineer ID");
        Engineer.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, -1));
        Engineer.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 210, 10));

        engg_email_txt.setBackground(new java.awt.Color(115, 115, 115));
        engg_email_txt.setForeground(new java.awt.Color(254, 254, 254));
        engg_email_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        engg_email_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engg_email_txtActionPerformed(evt);
            }
        });
        Engineer.add(engg_email_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 210, 30));

        jLabel41.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(254, 254, 254));
        jLabel41.setText("Email");
        Engineer.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel42.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(254, 254, 254));
        jLabel42.setText("Salary");
        Engineer.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        engg_salary_txt.setBackground(new java.awt.Color(115, 115, 115));
        engg_salary_txt.setForeground(new java.awt.Color(254, 254, 254));
        engg_salary_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        engg_salary_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engg_salary_txtActionPerformed(evt);
            }
        });
        Engineer.add(engg_salary_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 210, 30));
        Engineer.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 210, 10));
        Engineer.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 210, 10));

        jLabel44.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(254, 254, 254));
        jLabel44.setText("Project ID");
        Engineer.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, -1, -1));

        engg_projId_txt.setBackground(new java.awt.Color(115, 115, 115));
        engg_projId_txt.setForeground(new java.awt.Color(254, 254, 254));
        engg_projId_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        engg_projId_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engg_projId_txtActionPerformed(evt);
            }
        });
        Engineer.add(engg_projId_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 210, 30));

        confirm4.setBackground(new java.awt.Color(0, 128, 255));
        confirm4.setForeground(java.awt.Color.white);
        confirm4.setText("Confirm");
        confirm4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm4ActionPerformed(evt);
            }
        });
        Engineer.add(confirm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 130, -1));
        Engineer.add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 210, 10));

        jLabel43.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(254, 254, 254));
        jLabel43.setText("Qualification");
        Engineer.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

        engg_qualification_txt.setBackground(new java.awt.Color(115, 115, 115));
        engg_qualification_txt.setForeground(new java.awt.Color(254, 254, 254));
        engg_qualification_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        engg_qualification_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engg_qualification_txtActionPerformed(evt);
            }
        });
        Engineer.add(engg_qualification_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 210, 30));
        Engineer.add(jSeparator41, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 210, 10));

        jLabel54.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(254, 254, 254));
        jLabel54.setText("Manager ID");
        Engineer.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        engg_managerID_txt.setBackground(new java.awt.Color(115, 115, 115));
        engg_managerID_txt.setForeground(new java.awt.Color(254, 254, 254));
        engg_managerID_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        engg_managerID_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engg_managerID_txtActionPerformed(evt);
            }
        });
        Engineer.add(engg_managerID_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 210, 30));
        Engineer.add(jSeparator47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 210, 10));

        jLabel56.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(254, 254, 254));
        jLabel56.setText("Contact Number");
        Engineer.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        engg_contact_txt.setBackground(new java.awt.Color(115, 115, 115));
        engg_contact_txt.setForeground(new java.awt.Color(254, 254, 254));
        engg_contact_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        engg_contact_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engg_contact_txtActionPerformed(evt);
            }
        });
        Engineer.add(engg_contact_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 210, 30));
        Engineer.add(jSeparator48, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 210, 10));

        addEmpParent.add(Engineer, "card2");

        addEmployeeCard.add(addEmpParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 710, 250));

        cardParent.add(addEmployeeCard, "card3");

        javax.swing.GroupLayout editEmployeeCardLayout = new javax.swing.GroupLayout(editEmployeeCard);
        editEmployeeCard.setLayout(editEmployeeCardLayout);
        editEmployeeCardLayout.setHorizontalGroup(
            editEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        editEmployeeCardLayout.setVerticalGroup(
            editEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        cardParent.add(editEmployeeCard, "card5");

        addProjectCard.setBackground(java.awt.Color.white);
        addProjectCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 24)); // NOI18N
        jLabel3.setText("Add Project");
        addProjectCard.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 31, 195, 51));
        addProjectCard.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, -1));

        jPanel10.setBackground(new java.awt.Color(115, 115, 115));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(254, 254, 254));
        jLabel62.setText("Name");
        jPanel10.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        proj_name_txt.setBackground(new java.awt.Color(115, 115, 115));
        proj_name_txt.setForeground(new java.awt.Color(254, 254, 254));
        proj_name_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        proj_name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proj_name_txtActionPerformed(evt);
            }
        });
        jPanel10.add(proj_name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 210, 30));
        jPanel10.add(jSeparator50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 210, 10));

        jLabel63.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(254, 254, 254));
        jLabel63.setText("Project ID");
        jPanel10.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        ProjId_txt.setBackground(new java.awt.Color(115, 115, 115));
        ProjId_txt.setForeground(new java.awt.Color(254, 254, 254));
        ProjId_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ProjId_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProjId_txtActionPerformed(evt);
            }
        });
        jPanel10.add(ProjId_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 210, 30));
        jPanel10.add(jSeparator51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 10));

        jLabel64.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(254, 254, 254));
        jLabel64.setText("ETD");
        jPanel10.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        etd_txt.setBackground(new java.awt.Color(115, 115, 115));
        etd_txt.setForeground(new java.awt.Color(254, 254, 254));
        etd_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        etd_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etd_txtActionPerformed(evt);
            }
        });
        jPanel10.add(etd_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 210, 30));
        jPanel10.add(jSeparator52, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 210, 10));

        jLabel66.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(254, 254, 254));
        jLabel66.setText("Budget");
        jPanel10.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        budget_txt.setBackground(new java.awt.Color(115, 115, 115));
        budget_txt.setForeground(new java.awt.Color(254, 254, 254));
        budget_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        budget_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        budget_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budget_txtActionPerformed(evt);
            }
        });
        jPanel10.add(budget_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 210, 30));
        jPanel10.add(jSeparator54, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 210, 10));

        confirm8.setBackground(new java.awt.Color(0, 128, 255));
        confirm8.setForeground(java.awt.Color.white);
        confirm8.setText("Confirm");
        confirm8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm8ActionPerformed(evt);
            }
        });
        jPanel10.add(confirm8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 130, -1));

        addProjectCard.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 710, 320));

        cardParent.add(addProjectCard, "card7");

        viewInfoCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 24)); // NOI18N
        jLabel17.setText("VIEW INFORMATION");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Builder", "Customer", "Engineers", "Labours" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel18.setText("Employee type");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel17))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(23, 23, 23))
        );

        viewInfoCard.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 710, 100));

        jPanel8.setLayout(new java.awt.CardLayout());

        viewBuilders.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(null);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Builder ID", "Project ID", "Email ID", "Contact No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        viewBuilders.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 12, 690, 268));

        jPanel8.add(viewBuilders, "card3");

        jTable2.setBorder(null);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Customer ID", "Contact number", "Email", "Dues"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout viewCustomersLayout = new javax.swing.GroupLayout(viewCustomers);
        viewCustomers.setLayout(viewCustomersLayout);
        viewCustomersLayout.setHorizontalGroup(
            viewCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(viewCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(viewCustomersLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        viewCustomersLayout.setVerticalGroup(
            viewCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(viewCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(viewCustomersLayout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        jPanel8.add(viewCustomers, "card4");

        jTable3.setBorder(null);
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Engineer ID", "Project ID", "Email ID", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout viewEngineersLayout = new javax.swing.GroupLayout(viewEngineers);
        viewEngineers.setLayout(viewEngineersLayout);
        viewEngineersLayout.setHorizontalGroup(
            viewEngineersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(viewEngineersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(viewEngineersLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        viewEngineersLayout.setVerticalGroup(
            viewEngineersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(viewEngineersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(viewEngineersLayout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        jPanel8.add(viewEngineers, "card5");

        jTable4.setBorder(null);
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Labour ID", "Unit Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout viewLaboursLayout = new javax.swing.GroupLayout(viewLabours);
        viewLabours.setLayout(viewLaboursLayout);
        viewLaboursLayout.setHorizontalGroup(
            viewLaboursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(viewLaboursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(viewLaboursLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        viewLaboursLayout.setVerticalGroup(
            viewLaboursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(viewLaboursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(viewLaboursLayout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        jPanel8.add(viewLabours, "card2");

        viewInfoCard.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 700, 280));

        cardParent.add(viewInfoCard, "card4");

        jPanel3.add(cardParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 710, 400));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 710, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void updateTable(){
       
        
        
        
        
        //add values to builder table
        
        ManagerOperations obj=new ManagerOperations();
            try{
                Vector<Builder> arr=obj.getBuilders(email);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                        model.removeRow(i);
}
                for(Builder b:arr){
                    model.addRow(new Object[]{b.name,b.builder_id,b.project_id,b.email,b.contact});
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
            
        //add values to engineer table
        try{
            
             Vector<Engineer> arr=obj.getEngineer(email);
                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                        model.removeRow(i);
}
                for(Engineer e:arr){
                    model.addRow(new Object[]{e.name,e.engineer_id,e.project_id,e.email,e.salary});
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);

        }
        
        //add values to customer table
        try{
             Vector<Customer> arr=obj.getCustomer();
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                        model.removeRow(i);
}
                for(Customer c:arr){
                    model.addRow(new Object[]{c.name,c.customer_id,c.contact,c.email,c.pendingDues});
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);

        }
        
        
        // add vlaues to labour table
        try{
             Vector<Labour> arr=obj.getLabour();
                DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                        model.removeRow(i);
}
                for(Labour l:arr){
                    model.addRow(new Object[]{l.labour_id,l.unit_number});
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);

        }
        
        
        
         //add values to project table
         try{
             Vector<Project> arr=obj.getProject(email);
                DefaultTableModel model = (DefaultTableModel) ProjectTable.getModel();
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                        model.removeRow(i);
}
                for(Project p:arr){
                    model.addRow(new Object[]{p.name,p.project_id,p.etd,p.customerId});
                }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);

        }
         
         
    }
    
    private void button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseEntered
        // TODO add your handling code here:
        onHover(button2);
        onLeaveHover(button1);
        onLeaveHover(button3);
        onLeaveHover(button4);
        onLeaveHover(button5);
        
    }//GEN-LAST:event_button2MouseEntered

    private void button5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button5MouseExited
        // TODO add your handling code here:
        onLeaveHover(button5);
    }//GEN-LAST:event_button5MouseExited

    private void button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseEntered
        // TODO add your handling code here:
        onHover(button1);
        onLeaveHover(button2);
        onLeaveHover(button3);
        onLeaveHover(button4);
        onLeaveHover(button5);
       
        
    }//GEN-LAST:event_button1MouseEntered

    private void button5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button5MouseEntered

        onHover(button5);
        onLeaveHover(button3);
        onLeaveHover(button1);
        onLeaveHover(button2);
        onLeaveHover(button4);

    }//GEN-LAST:event_button5MouseEntered

    private void button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseExited
        // TODO add your handling code here:
        onLeaveHover(button2);
    }//GEN-LAST:event_button2MouseExited

    private void button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseExited
        // TODO add your handling code here:
        onLeaveHover(button1);
    }//GEN-LAST:event_button1MouseExited

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        // TODO add your handling code here:
        viewInfoCard.setVisible(false);
        addEmployeeCard.setVisible(false);
        homeCard.setVisible(true);
        addProjectCard.setVisible(false);
        onClick(indicator1,new JPanel[]{indicator2,indicator3,indicator4,indicator5});
            
    }//GEN-LAST:event_button1MouseClicked

    private void engg_name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engg_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engg_name_txtActionPerformed

    private void engg_id_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engg_id_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engg_id_txtActionPerformed

    private void engg_email_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engg_email_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engg_email_txtActionPerformed

    private void engg_salary_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engg_salary_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engg_salary_txtActionPerformed

    private void engg_projId_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engg_projId_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engg_projId_txtActionPerformed

    private void confirm4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm4ActionPerformed
        // TODO add your handling code here:
        String name=engg_name_txt.getText();
        String email=engg_email_txt.getText();
        int engineer_id=Integer.parseInt(engg_id_txt.getText());
        int salary=Integer.parseInt(engg_salary_txt.getText());
        int project_id=Integer.parseInt(engg_projId_txt.getText());
        int manager_id=Integer.parseInt(engg_managerID_txt.getText());
        String qualification=(engg_qualification_txt.getText());
        String contact=engg_contact_txt.getText();
        try{
            ManagerOperations man=new ManagerOperations();
            String password=man.addEngineersToDatabase(name, engineer_id, project_id, salary, email, contact, manager_id, qualification);
            if(password!=null)
                JOptionPane.showMessageDialog(this, "Scan the QR code for password");
            try {
                       Process p;
                        String command="qrencode "+password+" -s 10 -o password.png";
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
                        command ="feh password.png";
                        p=Runtime.getRuntime().exec(command);
			}

		 catch (Exception e) {
			e.printStackTrace();
		}
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_confirm4ActionPerformed

    private void buil_name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buil_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buil_name_txtActionPerformed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void contact_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_txtActionPerformed

    private void buil_id_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buil_id_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buil_id_textActionPerformed

    private void addressTxt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTxt4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTxt4ActionPerformed

    private void buil_projIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buil_projIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buil_projIDActionPerformed

    private void confirm5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm5ActionPerformed
        // TODO add your handling code here:
        String name=buil_name_txt.getText();
        String address=addressTxt4.getText();
        String contact=contact_txt.getText();
        String email=emailTxt.getText();
        String qualification=this.qualification.getText();
        int builderId=Integer.parseInt(buil_id_text.getText());
        int projectId=Integer.parseInt(buil_projID.getText());
        int managerID=Integer.parseInt(managerIDtxt.getText());
        int salary=Integer.parseInt(this.salary.getText());
        String password;
        ManagerOperations man=new ManagerOperations();
        try{
            password=man.addBiuilderToDatabase(name, builderId, address, projectId, email,qualification, salary, contact, managerID);
            JOptionPane.showMessageDialog(this, "Scan the QR Code for password");
            try {
                        Process p;
                        String command="qrencode "+password+" -s 10 -o password.png";
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
                        command ="feh password.png";
                        p=Runtime.getRuntime().exec(command);		
			}

		 catch (Exception e) {
			e.printStackTrace();
		}
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_confirm5ActionPerformed

    private void cust_name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cust_name_txtActionPerformed

    private void cust_email_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_email_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cust_email_txtActionPerformed

    private void cust_phone_TXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_phone_TXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cust_phone_TXTActionPerformed

    private void cust_id_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_id_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cust_id_txtActionPerformed

    private void cust_address_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_address_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cust_address_txtActionPerformed

    private void confirm6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm6ActionPerformed
        // TODO add your handling code here:
        try{
            String name=cust_name_txt.getText();
            String email=cust_email_txt.getText();
            int customer_id=Integer.parseInt(cust_id_txt.getText());
            String phone=cust_phone_TXT.getText();
            String address=cust_address_txt.getText();
            ManagerOperations obj=new ManagerOperations();
            String password;
            password = obj.addCustomerToDatabase(name, customer_id, email, address, phone);
            JOptionPane.showMessageDialog(this, "Scan the QR code for password");
            
            try {
                        Process p;
                        String command="qrencode "+password+" -s 10  -o password.png";
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
                        command ="feh password.png";
                        p=Runtime.getRuntime().exec(command);		
			}

		 catch (Exception e) {
			e.printStackTrace();
		}
            
        }
        catch (SQLException E){
            JOptionPane.showMessageDialog(this, E);
        }
        
    }//GEN-LAST:event_confirm6ActionPerformed

    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
        // TODO add your handling code here:
        homeCard.setVisible(false);
        addEmployeeCard.setVisible(true);
        viewInfoCard.setVisible(false);
        ViewProjectCArd.setVisible(false);
        addProjectCard.setVisible(false);
        onClick(indicator2,new JPanel[]{indicator1,indicator3,indicator5,indicator4} );
        
        
    }//GEN-LAST:event_button2MouseClicked

    private void button5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button5MouseClicked
        // TODO add your handling code here:
        homeCard.setVisible(false);
        addEmployeeCard.setVisible(false);
        viewInfoCard.setVisible(true);
        ViewProjectCArd.setVisible(false);
        addProjectCard.setVisible(false);
        onClick(indicator5,new JPanel[]{indicator1,indicator3,indicator2,indicator4} );
    }//GEN-LAST:event_button5MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        int index=jComboBox1.getSelectedIndex();
        if(index==1){
            Builder.setVisible(true);
            Engineer.setVisible(false);
            Customer.setVisible(false);
            Labour.setVisible(false);
        }
        else if(index==2){
            Builder.setVisible(false);
            Engineer.setVisible(true);
            Customer.setVisible(false);
            Labour.setVisible(false);

        }
        else if(index==3){
             Builder.setVisible(false);
            Engineer.setVisible(false);
            Customer.setVisible(true);
            Labour.setVisible(false);
        }
        else if(index==4){
            Builder.setVisible(false);
            Engineer.setVisible(false);
            Customer.setVisible(false);
            Labour.setVisible(true);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void lab_unit_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lab_unit_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lab_unit_txtActionPerformed

    private void lab_id_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lab_id_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lab_id_txtActionPerformed

    private void confirm7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm7ActionPerformed
        // TODO add your handling code here:
        int labourId=Integer.parseInt(lab_id_txt.getText());
        int unitNo=Integer.parseInt(lab_unit_txt.getText());
        try{
            ManagerOperations man=new ManagerOperations();
            man.addLabourToDatabase(labourId, unitNo);
            JOptionPane.showMessageDialog(this, "Labour added");
        }
        catch(SQLException e){
            JOptionPane.showInternalMessageDialog(this, e);
        }
    }//GEN-LAST:event_confirm7ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
         int index=jComboBox2.getSelectedIndex();
        if(index==0){
            updateTable();
            viewCustomers.setVisible(false);
            viewBuilders.setVisible(true);
            viewEngineers.setVisible(false);
            viewLabours.setVisible(false);
            
            
            
            
        }
        else if(index==1){
            updateTable();
            viewCustomers.setVisible(true);
            viewBuilders.setVisible(false);
            viewEngineers.setVisible(false);
            viewLabours.setVisible(false);
        }
        else if(index==2){
            updateTable();
            viewCustomers.setVisible(false);
            viewBuilders.setVisible(false);
            viewEngineers.setVisible(true);
            viewLabours.setVisible(false);
        }
        else if(index==3){
            updateTable();
            viewCustomers.setVisible(false);
            viewBuilders.setVisible(false);
            viewEngineers.setVisible(false);
            viewLabours.setVisible(true);
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void engg_qualification_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engg_qualification_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engg_qualification_txtActionPerformed

    private void engg_managerID_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engg_managerID_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engg_managerID_txtActionPerformed

    private void engg_contact_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engg_contact_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engg_contact_txtActionPerformed

    private void qualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qualificationActionPerformed

    private void managerIDtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerIDtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managerIDtxtActionPerformed

    private void salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryActionPerformed

    private void button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button3MouseClicked
        // TODO add your handling code here:
        onClick(indicator3,new JPanel[]{indicator1,indicator2,indicator4,indicator5} );
        homeCard.setVisible(false);
        addEmployeeCard.setVisible(false);
        viewInfoCard.setVisible(false);
        ViewProjectCArd.setVisible(true);
        updateTable();
        
    }//GEN-LAST:event_button3MouseClicked

    private void button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button3MouseExited
        // TODO add your handling code here:
        onLeaveHover(button3);
    }//GEN-LAST:event_button3MouseExited

    private void button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button3MouseEntered
        // TODO add your handling code here:
        onHover(button3);
        onLeaveHover(button1);
        onLeaveHover(button2);
        onLeaveHover(button4);
        onLeaveHover(button5);
    }//GEN-LAST:event_button3MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ManagerOperations obj=new ManagerOperations();
        try{
            obj.callProcedure();
            JOptionPane.showMessageDialog(this, "Successfully provided");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button4MouseClicked
        // TODO add your handling code here:
        addProjectCard.setVisible(true);
        homeCard.setVisible(false);
        addEmployeeCard.setVisible(false);
        ViewProjectCArd.setVisible(false);
        viewInfoCard.setVisible(false);
        onClick(indicator4, new JPanel[]{indicator1,indicator2,indicator3,indicator5});
        
    }//GEN-LAST:event_button4MouseClicked

    private void button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button4MouseExited
        // TODO add your handling code here:
        onLeaveHover(button4);
    }//GEN-LAST:event_button4MouseExited

    private void button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button4MouseEntered
        // TODO add your handling code here:
          onHover(button4);
        onLeaveHover(button1);
        onLeaveHover(button2);
        onLeaveHover(button3);
        onLeaveHover(button5);
        
    }//GEN-LAST:event_button4MouseEntered

    private void proj_name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proj_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proj_name_txtActionPerformed

    private void ProjId_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProjId_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProjId_txtActionPerformed

    private void etd_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etd_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etd_txtActionPerformed

    private void budget_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budget_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_budget_txtActionPerformed

    private void confirm8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm8ActionPerformed
        try{
            ManagerOperations obj=new ManagerOperations();
            boolean success=obj.addProjectToDatabase(Integer.parseInt(ProjId_txt.getText()), proj_name_txt.getText(), Integer.parseInt(etd_txt.getText()), Integer.parseInt(budget_txt.getText()), this.managerId);
            if(success){
                JOptionPane.showMessageDialog(this, "Project Added Succesfully");
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_confirm8ActionPerformed

    private void cust_id_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cust_id_txtKeyPressed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_cust_id_txtKeyPressed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        int opt=JOptionPane.showConfirmDialog(this, "Are you sure you wish to logout?");
        if(opt==0){
            Login lgn=new Login();
            this.setVisible(false);
            lgn.setVisible(true);
        }
    }//GEN-LAST:event_jLabel19MouseClicked

    
    void onHover(JPanel jp){
        jp.setBackground(new Color(220,220,220));
    }
    void onLeaveHover(JPanel jp){
        jp.setBackground(Color.white);
    }
    void onClick(JPanel b1,JPanel normalise[]){
        b1.setBackground(new Color(119, 119, 119));
        for(int i=0;i<normalise.length;i++)
            normalise[i].setBackground(Color.white);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerHome("manager_1@gmail.com").setVisible(true);
                
            }
        });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Builder;
    private javax.swing.JPanel Builder1;
    private javax.swing.JPanel Customer;
    private javax.swing.JPanel Engineer;
    private javax.swing.JPanel Labour;
    private javax.swing.JTextField ProjId_txt;
    private javax.swing.JTable ProjectTable;
    private javax.swing.JPanel ViewProjectCArd;
    private javax.swing.JPanel addEmpParent;
    private javax.swing.JPanel addEmployeeCard;
    private javax.swing.JPanel addProjectCard;
    private javax.swing.JTextField addressTxt4;
    private javax.swing.JTextField budget_txt;
    private javax.swing.JTextField buil_id_text;
    private javax.swing.JTextField buil_name_txt;
    private javax.swing.JTextField buil_projID;
    private javax.swing.JPanel button1;
    private javax.swing.JPanel button2;
    private javax.swing.JPanel button3;
    private javax.swing.JPanel button4;
    private javax.swing.JPanel button5;
    private javax.swing.JPanel buttonHome1;
    private javax.swing.JPanel cardParent;
    private javax.swing.JButton confirm4;
    private javax.swing.JButton confirm5;
    private javax.swing.JButton confirm6;
    private javax.swing.JButton confirm7;
    private javax.swing.JButton confirm8;
    private javax.swing.JTextField contact_txt;
    private javax.swing.JTextField cust_address_txt;
    private javax.swing.JTextField cust_email_txt;
    private javax.swing.JTextField cust_id_txt;
    private javax.swing.JTextField cust_name_txt;
    private javax.swing.JTextField cust_phone_TXT;
    private javax.swing.JPanel editEmployeeCard;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField engg_contact_txt;
    private javax.swing.JTextField engg_email_txt;
    private javax.swing.JTextField engg_id_txt;
    private javax.swing.JTextField engg_managerID_txt;
    private javax.swing.JTextField engg_name_txt;
    private javax.swing.JTextField engg_projId_txt;
    private javax.swing.JTextField engg_qualification_txt;
    private javax.swing.JTextField engg_salary_txt;
    private javax.swing.JTextField etd_txt;
    private javax.swing.JPanel homeCard;
    private javax.swing.JPanel indicator1;
    private javax.swing.JPanel indicator2;
    private javax.swing.JPanel indicator3;
    private javax.swing.JPanel indicator4;
    private javax.swing.JPanel indicator5;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator44;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JSeparator jSeparator47;
    private javax.swing.JSeparator jSeparator48;
    private javax.swing.JSeparator jSeparator49;
    private javax.swing.JSeparator jSeparator50;
    private javax.swing.JSeparator jSeparator51;
    private javax.swing.JSeparator jSeparator52;
    private javax.swing.JSeparator jSeparator54;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField lab_id_txt;
    private javax.swing.JTextField lab_unit_txt;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField managerIDtxt;
    private javax.swing.JTextField proj_name_txt;
    private javax.swing.JTextField qualification;
    private javax.swing.JTextField salary;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel viewBuilders;
    private javax.swing.JPanel viewCustomers;
    private javax.swing.JPanel viewEngineers;
    private javax.swing.JPanel viewInfoCard;
    private javax.swing.JPanel viewLabours;
    // End of variables declaration//GEN-END:variables
}
