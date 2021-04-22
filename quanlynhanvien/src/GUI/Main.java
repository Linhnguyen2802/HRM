
package GUI;
import DAL.DepartmentDAL;
import DLL.DeparmentDLL;
import DLL.EmployeesDLL;
import DLL.ProjectDLL;
import Entily.Deperment;
import Entily.Employees;
import Entily.Project;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {
    
    EmployeesDLL empDll = new EmployeesDLL();
        ArrayList<Employees> listEMP = new ArrayList<>();
    
    DeparmentDLL depDLL = new DeparmentDLL();
        ArrayList<Deperment> listDep = new ArrayList<>();
    
    ProjectDLL   prDll = new ProjectDLL();
        ArrayList<Project> listPr = new ArrayList<>();
            
    public Main() {
        initComponents();
        String laf="";
        laf="com.sun.java.swing.play.windows.WindowsLooAndfeel";
        try {
            UIManager.setLookAndFeel(laf);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
        }
        this.setLocation(450, 50);
        Biding();
        bindingDep();
        bindingPr();
    }
    public  void bindingDep(){
        listDep = depDLL.getAll();
        for (Deperment d : listDep) {
            cbxDep.addItem(d.getdepName());
        }   
    }
    public  void bindingPr(){
        listPr = prDll.getAll();
        for (Project d : listPr) {
            cbxPr.addItem(d.getPrName());
        }
    }
    //add dữ liêu nv
    public void Biding(){
        listEMP = empDll.getAll();
        Vector clums = new Vector();
        clums.add("Tài Khoản");
        clums.add("Mật Khẩu");
        clums.add("Họ Tên");
        clums.add("Tuổi");
        clums.add("Địa Chỉ");
        clums.add("Diện Thoại");
        clums.add("Phòng Ban");
        clums.add("Công Việc");
        
        Vector data = new Vector();
        
        for (Employees emp : listEMP){
            Vector row = new Vector();
            
            row.add(emp.getUsername());
            row.add(emp.getPassword());
            row.add(emp.getFullName());
            row.add(emp.getAge());
            row.add(emp.getAddress());
            row.add(emp.getPhone());
            listDep = depDLL.getByID(emp.getdepID());
            if(listDep.size()>0){
                row.add(listDep.get(0).getdepName());
            }else{
                row.add("isEmpty");
            }
            listPr = prDll.getByID(emp.getprID());
              if(listPr.size()>0){
                row.add(listPr.get(0).getPrName());
            }else{
                row.add("isEmpty");
            }
              data.add(row);
        }   
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
            tblEmp.setModel(dtm);
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmp = new javax.swing.JTable();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        cbxDep = new javax.swing.JComboBox<>();
        cbxPr = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        tblEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmp);

        cbxDep.setName("cbxDep"); // NOI18N
        cbxDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDepActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên tài khoản:");

        jLabel3.setText("Mật khẩu:");

        jLabel4.setText("Họ & Tên:");

        jLabel5.setText("Tuổi:");

        jLabel6.setText("Địa chỉ:");

        jLabel7.setText("Phone:");

        jLabel8.setText("Phòng ban:");

        jLabel9.setText("Chức vụ:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-add-new-22.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-edit-22_1.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-delete-22_1.png"))); // NOI18N
        jButton3.setText("Xoá");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxDep, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxPr, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addGap(254, 254, 254)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(cbxDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(cbxPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtUser.enableInputMethods(true);
        listPr = prDll.getAll();
        listDep = depDLL.getAll();
        String User = txtUser.getText();
        String pass = txtPass.getText();
        String Fname = txtFname.getText();
        String Age = txtAge.getText();
        String Addrss = txtAddress.getText() ;
        String Phone = txtPhone.getText();

        int rowDep = cbxDep.getSelectedIndex();
        int rowPr = cbxPr.getSelectedIndex();
        int idDep = listDep.get(rowDep).getdepID();
        int idPr = listPr.get(rowPr).getprID();

        Employees emp = new Employees();
        emp.setUsername(User);
        emp.setPassword(pass);
        emp.setFullName(Fname);
        emp.setAge(Age);
        emp.setAddress(Addrss);
        emp.setPhone(Phone);

        emp.setdepID(idDep);
        emp.setprID(idPr);
        if(empDll.AddData(emp)){
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
            Biding();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpMouseClicked
        if(tblEmp.getSelectedRow()!= -1){
            // TODO add your handling code here:
            int row = tblEmp.getSelectedRow();
            listDep = depDLL.getAll();
            listPr = prDll.getAll();

            listEMP =empDll.getAll();
            txtUser.setText(listEMP.get(row).getUsername());
            txtPass.setText(listEMP.get(row).getPassword());
            txtFname.setText(listEMP.get(row).getFullName());
            txtAge.setText(listEMP.get(row).getAge());
            txtAddress.setText(listEMP.get(row).getAddress());
            txtPhone.setText(listEMP.get(row).getPhone());

            listDep = depDLL.getByID(listEMP.get(row).getdepID());
            if(listDep.size()>0){
                cbxDep.setSelectedItem(listDep.get(0).getdepName());
            }else
            {
                cbxDep.setSelectedIndex(0);
            }
            listPr = prDll.getByID(listEMP.get(row).getprID());
            if(listPr.size()>0){
                cbxPr.setSelectedItem(listPr.get(0).getPrName());
            }else
            {
                cbxPr.setSelectedIndex(0);
            }
    }//GEN-LAST:event_tblEmpMouseClicked
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(tblEmp.getSelectedRow()!= -1){
            int row = tblEmp.getSelectedRow();
            listEMP =empDll.getAll();

            if(empDll.delete(listEMP.get(row).getUsername())){
                JOptionPane.showMessageDialog(this, "Xoá nhân viên thành công!");
                Biding();
            }else{
                JOptionPane.showMessageDialog(this, "Không thể xoá");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listPr = prDll.getAll();
        listDep = depDLL.getAll();
        listEMP = empDll.getAll();
        String User = txtUser.getText();
        String pass = txtPass.getText();
        String Fname = txtFname.getText();
        String Age = txtAge.getText();
        String Addrss = txtAddress.getText();
        String Phone = txtPhone.getText();
        int rowDep = cbxDep.getSelectedIndex();
        int rowPr = cbxPr.getSelectedIndex();
        int row = tblEmp.getSelectedRow();
        int idDep = listDep.get(rowDep).getdepID();
        int idPr = listPr.get(rowPr).getprID();

        Employees emp= new Employees();
        emp.setUsername(listEMP.get(row).getUsername());
        emp.setPassword(pass);
        emp.setFullName(Fname);
        emp.setAge(Age);
        emp.setAddress(Addrss);
        emp.setPhone(Phone);
        emp.setdepID(idDep);
        emp.setprID(idPr);
        if(empDll.update(emp)){
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            Biding();
        }else{
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDepActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxDep;
    private javax.swing.JComboBox<String> cbxPr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmp;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtPhone;
    public javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}