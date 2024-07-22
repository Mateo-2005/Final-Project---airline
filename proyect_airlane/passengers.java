/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyect_airlane;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author LENOVO
 */
public class passangers extends javax.swing.JFrame{
  DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new form passengers
     */
    public passengers() {
        initComponents();
         this.setLocationRelativeTo(null);
        String [] titulo = new String[]{"Name Passenger","Number Passenger","Addres Passenger", "Phone Number"};
        dtm.setColumnIdentifiers(titulo);
        PassengersTable.setModel(dtm);
    }
    
    
    
    void save(){
        dtm.addRow(new Object[]{
            PNameTb.getText(),PassNumberTb.getText(),PAddressTb.getText(),PPhoneTb.getText()
        });
    }
    
    private void Clear(){
        
        PNameTb.setText("");
        PassNumberTb.setText("");
        PAddressTb.setText("");
        PPhoneTb.setText("");
        
    } 
    
    void delete(){
        
        int fila = PassengersTable.getSelectedRow();
        dtm.removeRow(fila);
        
    } 
    
  void edit() {
    int fila = PassengersTable.getSelectedRow();
    
    if (fila < 0) {
        JOptionPane.showMessageDialog(this, "Select a record to edit");
        return;
    }

    
    String originalCode = (String) dtm.getValueAt(fila, 0);

    
    dtm.setValueAt(PNameTb.getText(), fila, 0);
    dtm.setValueAt(PassNumberTb.getText(), fila, 1);
    dtm.setValueAt(PAddressTb.getText(), fila, 2);
    dtm.setValueAt(PPhoneTb.getText(), fila, 3);

    try {
        ConectionDB conDB = new ConectionDB();
        Connection cn = conDB.getConnection();

        
        String sql = "UPDATE passengerstbl SET PName = ?, PPass = ?, PAdd = ?, PPhone = ? WHERE PName = ?";
        java.sql.PreparedStatement update = cn.prepareStatement(sql);
        
        update.setString(1, PNameTb.getText());
        update.setString(2, PassNumberTb.getText());
        update.setString(3, PAddressTb.getText());
        update.setString(4, PPhoneTb.getText());
        update.setString(5, originalCode); 
        
        update.executeUpdate();
        JOptionPane.showMessageDialog(this, "Passenger has been successfully updated");
        Clear();
        
       
        loadPassengersData();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating passenger");
    }
}



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PNameTb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NatCb = new javax.swing.JComboBox<>();
        GenCb = new javax.swing.JComboBox<>();
        PAddressTb = new javax.swing.JTextField();
        SaveDtn = new javax.swing.JButton();
        EditDtn = new javax.swing.JButton();
        DeleteDtn = new javax.swing.JButton();
        BackDtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PassengersTable = new javax.swing.JTable();
        PassNumberTb = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        PPhoneTb = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("MANAGE PASSENGERS");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("A E R O  S K Y");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Passenger Name");

        PNameTb.setBackground(new java.awt.Color(204, 204, 204));
        PNameTb.setForeground(new java.awt.Color(0, 0, 0));
        PNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PNameTbActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Nationality");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Gender");

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Passport Number");

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Address");

        NatCb.setBackground(new java.awt.Color(204, 204, 204));
        NatCb.setFont(new java.awt.Font("Super Dream", 0, 20)); // NOI18N
        NatCb.setForeground(new java.awt.Color(0, 0, 0));
        NatCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ecuador ", "Colombia", "Perú", "Argentina", "Brasil", "Venezuela", "Uruguay", "Paraguay" }));

        GenCb.setBackground(new java.awt.Color(204, 204, 204));
        GenCb.setFont(new java.awt.Font("Super Dream", 0, 20)); // NOI18N
        GenCb.setForeground(new java.awt.Color(0, 0, 0));
        GenCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Man", "Woman", "Other..." }));

        PAddressTb.setBackground(new java.awt.Color(204, 204, 204));
        PAddressTb.setForeground(new java.awt.Color(0, 0, 0));

        SaveDtn.setBackground(new java.awt.Color(153, 153, 153));
        SaveDtn.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 14)); // NOI18N
        SaveDtn.setForeground(new java.awt.Color(0, 0, 0));
        SaveDtn.setText("SAVE");
        SaveDtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveDtnMouseClicked(evt);
            }
        });
        SaveDtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveDtnActionPerformed(evt);
            }
        });

        EditDtn.setBackground(new java.awt.Color(153, 153, 153));
        EditDtn.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 14)); // NOI18N
        EditDtn.setForeground(new java.awt.Color(0, 0, 0));
        EditDtn.setText("EDIT");
        EditDtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditDtnActionPerformed(evt);
            }
        });

        DeleteDtn.setBackground(new java.awt.Color(153, 153, 153));
        DeleteDtn.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 14)); // NOI18N
        DeleteDtn.setForeground(new java.awt.Color(0, 0, 0));
        DeleteDtn.setText("DELETE");
        DeleteDtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteDtnActionPerformed(evt);
            }
        });

        BackDtn.setBackground(new java.awt.Color(153, 153, 153));
        BackDtn.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 14)); // NOI18N
        BackDtn.setForeground(new java.awt.Color(0, 0, 0));
        BackDtn.setText("BACK");
        BackDtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackDtnActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("FLIGTHS LIST");

        PassengersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        PassengersTable.setRowHeight(27);
        PassengersTable.setSelectionBackground(new java.awt.Color(0, 0, 153));
        PassengersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PassengersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PassengersTable);

        PassNumberTb.setBackground(new java.awt.Color(204, 204, 204));
        PassNumberTb.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Phone Number");

        PPhoneTb.setBackground(new java.awt.Color(204, 204, 204));
        PPhoneTb.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(SaveDtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditDtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteDtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BackDtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(PNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NatCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(GenCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PassNumberTb, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(PAddressTb, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(PPhoneTb)
                                .addGap(32, 32, 32))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(337, 337, 337))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NatCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PassNumberTb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PAddressTb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(GenCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PPhoneTb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveDtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditDtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteDtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackDtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jLabel9)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    connection Cn = null;
    PreparedStatement put = null;
    ResultSet Rs = null;
    Statement St = null;    
    
   
    private void SaveDtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveDtnMouseClicked
       
         if (PNameTb.getText().isEmpty() || PassNumberTb.getText().isEmpty() || PAddressTb.getText().isEmpty() || PPhoneTb.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing information");
        } else {
            try {
                ConectionDB conDB = new ConectionDB();
                Connection cn = conDB.getConnection();
                
                
                String sql = "INSERT INTO passengerstbl (PName, PNat, PGen, PPass, PAdd, PPhone) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement add = cn.prepareStatement(sql);
                add.setString(1, PNameTb.getText()); 
                add.setString(2, NatCb.getSelectedItem().toString());
                add.setString(3, GenCb.getSelectedItem().toString()); 
                add.setString(4, PassNumberTb.getText());
                add.setString(5, PAddressTb.getText()); 
                add.setString(6, PPhoneTb.getText()); 

                add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passenger has been successfully added");
                Clear();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
        }
    }//GEN-LAST:event_SaveDtnMouseClicked

    private void SaveDtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveDtnActionPerformed
        save();
        
    }//GEN-LAST:event_SaveDtnActionPerformed

    private void EditDtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDtnActionPerformed
       JOptionPane.showMessageDialog(this, "To edit a record you must select it, and fill in the data again.");
       edit();
    }//GEN-LAST:event_EditDtnActionPerformed

    private void BackDtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackDtnActionPerformed
        
        options newframe = new options(); 
        newframe.setVisible(true);
        
        this.dispose();

    }//GEN-LAST:event_BackDtnActionPerformed

    private void PNameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PNameTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PNameTbActionPerformed

    private void DeleteDtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDtnActionPerformed
       
        JOptionPane.showMessageDialog(this, "To delete a record you must select it");
        delete();
        
    }//GEN-LAST:event_DeleteDtnActionPerformed

    private void PassengersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PassengersTableMouseClicked
        
         int fila = PassengersTable.getSelectedRow();
        if (fila == -1) {
            
            JOptionPane.showMessageDialog(this, "Select a Row");
            
        }else {
            
            String name = (String) PassengersTable.getValueAt(fila, 0);
            String num = (String) PassengersTable.getValueAt(fila, 1);
            String address = (String) PassengersTable.getValueAt(fila, 2);
            String phone = (String) PassengersTable.getValueAt(fila, 3);
            
             PNameTb.setText(name);
             PassNumberTb.setText(num);
             PAddressTb.setText(address);
             PPhoneTb.setText(phone); 
             
            
        }
        
    }//GEN-LAST:event_PassengersTableMouseClicked

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
            java.util.logging.Logger.getLogger(passengers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(passengers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(passengers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(passengers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new passengers().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackDtn;
    private javax.swing.JButton DeleteDtn;
    private javax.swing.JButton EditDtn;
    private javax.swing.JComboBox<String> GenCb;
    private javax.swing.JComboBox<String> NatCb;
    private javax.swing.JTextField PAddressTb;
    private javax.swing.JTextField PNameTb;
    private javax.swing.JTextField PPhoneTb;
    private javax.swing.JTextField PassNumberTb;
    private javax.swing.JTable PassengersTable;
    private javax.swing.JButton SaveDtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void limpiarTabla() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void loadPassengersData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
