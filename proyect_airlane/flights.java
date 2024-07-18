/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyect_airlane;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class flights extends javax.swing.JFrame {
 DefaultTableModel dtm = new DefaultTableModel();
    /**
     * Creates new form flights
     */
    public flights() {
        
        initComponents();
         this.setLocationRelativeTo(null);
        String [] titulo = new String[]{"Code Fly","Source","Destination", "Date", "Number Seats"};
        dtm.setColumnIdentifiers(titulo);
        FlightTable.setModel(dtm);
        initializeTableModel();
        
    }
    
     private void Clear(){
        
        PCodeTb.setText("");
        PSourceCb.setSelectedIndex(-1);
        PDestCb.setSelectedIndex(-1);
        PDate.setDate(null);
        SeatsTb.setText("");
        
    } 
     
    private void initializeTableModel() {
        dtm = new DefaultTableModel();
        String[] titulo = new String[] {"Code Fly", "Source", "Destination", "Date", "Number Seats"};
        dtm.setColumnIdentifiers(titulo);
        FlightTable.setModel(dtm);
    }
    
     void save(){
         if (PCodeTb.getText().isEmpty() || SeatsTb.getText().isEmpty() || PSourceCb.getSelectedIndex() == -1 || PDestCb.getSelectedIndex() == -1){
             JOptionPane.showMessageDialog(this, "Missing information");
         }else {
            dtm.addRow(new Object[]{
            PCodeTb.getText(),PSourceCb.getSelectedItem(),PDestCb.getSelectedItem(),PDate.getDate() , SeatsTb.getText()
        }); 
         }
        
    }
     
    void edit() {
    int fila = FlightTable.getSelectedRow();
    
    if (fila < 0) {
        JOptionPane.showMessageDialog(this, "Select a record to edit");
        return;
    }

    
    dtm.setValueAt(PCodeTb.getText(), fila, 0);
    dtm.setValueAt(PSourceCb.getSelectedItem(), fila, 1);
    dtm.setValueAt(PDestCb.getSelectedItem(), fila, 2);
    dtm.setValueAt(PDate.getDate(), fila, 3);
    dtm.setValueAt(SeatsTb.getText(), fila, 4);

   
    String code = (String) dtm.getValueAt(fila, 0);
    
    try {
        ConectionDB conDB = new ConectionDB();
        Connection cn = conDB.getConnection();

        String sql = "UPDATE flighttbl SET FICode = ?, FISource = ?, FIDest = ?, FIDate = ?, FISeats = ? WHERE FICode = ?";
        java.sql.PreparedStatement update = cn.prepareStatement(sql);
        
        update.setString(1, PCodeTb.getText());
        update.setString(2, PSourceCb.getSelectedItem().toString());
        update.setString(3, PDestCb.getSelectedItem().toString());
        update.setString(4, PDate.getDate().toString());
        update.setInt(5, Integer.valueOf(SeatsTb.getText()));
        update.setString(6, code); 
        
        update.executeUpdate();
        JOptionPane.showMessageDialog(this, "Flight has been successfully updated");
        Clear();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating flight");
    }

}

    
     void delete(){
        
        int fila = FlightTable.getSelectedRow();
        dtm.removeRow(fila);
        
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PCodeTb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PSourceCb = new javax.swing.JComboBox<>();
        PDestCb = new javax.swing.JComboBox<>();
        SeatsTb = new javax.swing.JTextField();
        SaveDtn = new javax.swing.JButton();
        EditDtn = new javax.swing.JButton();
        DeleteDtn = new javax.swing.JButton();
        BackDtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FlightTable = new javax.swing.JTable();
        PDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("MANAGE FLIGTHS");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("A E R O  S K Y");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Fligth code:");

        PCodeTb.setBackground(new java.awt.Color(204, 204, 204));
        PCodeTb.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Source");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Destination");

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Take of Date");

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Numbers of Seats");

        PSourceCb.setBackground(new java.awt.Color(204, 204, 204));
        PSourceCb.setFont(new java.awt.Font("Super Dream", 0, 20)); // NOI18N
        PSourceCb.setForeground(new java.awt.Color(0, 0, 0));
        PSourceCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quito", "Guayaquil", "Cuenca", "Latacunga", "Manabí", "Galápagos", "El Oro", " " }));

        PDestCb.setBackground(new java.awt.Color(204, 204, 204));
        PDestCb.setFont(new java.awt.Font("Super Dream", 0, 20)); // NOI18N
        PDestCb.setForeground(new java.awt.Color(0, 0, 0));
        PDestCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quito", "Guayaquil", "Cuenca", "Latacunga", "Manabí", "Galápagos", "El Oro", " " }));

        SeatsTb.setBackground(new java.awt.Color(204, 204, 204));
        SeatsTb.setForeground(new java.awt.Color(0, 0, 0));

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

        FlightTable.setModel(new javax.swing.table.DefaultTableModel(
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
        FlightTable.setRowHeight(29);
        FlightTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        FlightTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(FlightTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PCodeTb, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PSourceCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(PDestCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PDate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SeatsTb, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SaveDtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EditDtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DeleteDtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BackDtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PCodeTb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PSourceCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PDestCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(SeatsTb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveDtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditDtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteDtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackDtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jLabel9)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditDtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDtnActionPerformed
       JOptionPane.showMessageDialog(this, "To edit a record you must select it, and fill in the data again.");
       edit();
       
    }//GEN-LAST:event_EditDtnActionPerformed

    private void BackDtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackDtnActionPerformed
        
        options newframe = new options(); 
        newframe.setVisible(true);
        
        this.dispose();

    }//GEN-LAST:event_BackDtnActionPerformed

    private void SaveDtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveDtnActionPerformed
    save();
    }//GEN-LAST:event_SaveDtnActionPerformed
    
    connection Cn = null;
    java.sql.PreparedStatement put = null;
    java.sql.ResultSet Rs = null;
    Statement St = null;   
    
    private void SaveDtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveDtnMouseClicked
      if (PCodeTb.getText().isEmpty() || SeatsTb.getText().isEmpty() || PSourceCb.getSelectedIndex() == -1 || PDestCb.getSelectedIndex() == -1 ) {
            JOptionPane.showMessageDialog(this, "Missing information");
        } else {
            try {
                ConectionDB conDB = new ConectionDB();
                Connection cn = conDB.getConnection();
                
                
                String sql = "INSERT INTO flighttbl (FICode, FISource, FIDest, FIDate, FISeats) VALUES (?, ?, ?, ?, ?)";
                java.sql.PreparedStatement add = cn.prepareStatement(sql);
                add.setString(1, PCodeTb.getText()); 
                add.setString(2, PSourceCb.getSelectedItem().toString());
                add.setString(3, PDestCb.getSelectedItem().toString()); 
                add.setString(4, PDate.getDate().toString());
                add.setInt(5,Integer.valueOf(SeatsTb.getText())); 
              
                add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Flight has been successfully added");
                Clear();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
        }
    }//GEN-LAST:event_SaveDtnMouseClicked

    private void DeleteDtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDtnActionPerformed
    JOptionPane.showMessageDialog(this, "To delete a record you must select it");
        delete();
    }//GEN-LAST:event_DeleteDtnActionPerformed

    private void FlightTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightTableMouseClicked
        
        int fila = FlightTable.getSelectedRow();
        if (fila == -1) {
            
            JOptionPane.showMessageDialog(this, "Select a Row");
            
        }else {
            
            String code = (String) FlightTable.getValueAt(fila, 0);
            String sour = (String) FlightTable.getValueAt(fila, 1);
            String dest = (String) FlightTable.getValueAt(fila, 2);
            Date date = (Date) FlightTable.getValueAt(fila, 3);
            String seat = (String) FlightTable.getValueAt(fila, 4);
            
             PCodeTb.setText(code);
             PSourceCb.setSelectedItem(sour);
             PDestCb.setSelectedItem(dest);
             PDate.setDate(date); 
             SeatsTb.setText(seat);
             
 
        }
        
    }//GEN-LAST:event_FlightTableMouseClicked

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
            java.util.logging.Logger.getLogger(flights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(flights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(flights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(flights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new flights().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackDtn;
    private javax.swing.JButton DeleteDtn;
    private javax.swing.JButton EditDtn;
    private javax.swing.JTable FlightTable;
    private javax.swing.JTextField PCodeTb;
    private com.toedter.calendar.JDateChooser PDate;
    private javax.swing.JComboBox<String> PDestCb;
    private javax.swing.JComboBox<String> PSourceCb;
    private javax.swing.JButton SaveDtn;
    private javax.swing.JTextField SeatsTb;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void initializeDefaultTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
