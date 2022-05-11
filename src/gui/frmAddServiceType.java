/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.ServiceTypeDAO;
import entity.ServiceType;
import javax.swing.JOptionPane;

/**
 *
 * @author vomin
 */
public class frmAddServiceType extends javax.swing.JFrame {

    /**
     * Creates new form frame1
     */
    private ServiceTypeDAO serviceTypeDAO;
    public frmAddServiceType() {
        this.setAlwaysOnTop(true);
        initComponents();
        serviceTypeDAO = new ServiceTypeDAO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenLoaiDichVu = new javax.swing.JTextField();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên dịch vụ: ");

        txtTenLoaiDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenLoaiDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenLoaiDichVuActionPerformed(evt);
            }
        });

        kButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons-create.png"))); // NOI18N
        kButton1.setText("Thêm");
        kButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        kButton1.setkEndColor(new java.awt.Color(51, 255, 255));
        kButton1.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        kButton1.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        kButton1.setkPressedColor(new java.awt.Color(0, 153, 153));
        kButton1.setkStartColor(new java.awt.Color(51, 51, 255));
        kButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kButton1MouseClicked(evt);
            }
        });

        kButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon-16.png"))); // NOI18N
        kButton2.setText("Thoát");
        kButton2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        kButton2.setkEndColor(new java.awt.Color(51, 255, 255));
        kButton2.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        kButton2.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        kButton2.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        kButton2.setkPressedColor(new java.awt.Color(0, 153, 153));
        kButton2.setkStartColor(new java.awt.Color(51, 51, 255));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Thêm loại dịch vụ");
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTenLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txtTenLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenLoaiDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenLoaiDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenLoaiDichVuActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton1MouseClicked
        String id = idTypeService();
        String name = txtTenLoaiDichVu.getText().trim();
       if(name.equals(""))
       {
           JOptionPane.showConfirmDialog(this,"Vui lòng nhập dữ liệu đầy đủ!","Thông báo",JOptionPane.CLOSED_OPTION);
           return;
       }
       ServiceType  serviceType = new ServiceType(id, name);
       if(serviceTypeDAO.addTypeService(serviceType))
       {
            JOptionPane.showMessageDialog(this, "Thêm loại dịch vụ thành công!");    
            clearText();
       }
       else
       {
           JOptionPane.showMessageDialog(this, "Thêm loại dịch vụ thất bại!");    
           clearText();
       }
    }//GEN-LAST:event_kButton1MouseClicked
    public String idTypeService() {
        String id = "";
        for (ServiceType typeService : serviceTypeDAO.getAllServiceType()) {
            id = typeService.getMaLoaiDV().toString();
        }
        String[] parts = id.split("V");
        if (Integer.parseInt(parts[1]) < 10) {
            int i = Integer.parseInt(parts[1]) + 1;
            id = "LDV00" + i;
        }
        if (Integer.parseInt(parts[1]) >= 10 && Integer.parseInt(parts[1]) < 100) {
            int i = Integer.parseInt(parts[1]) + 1;
            id = "LDV0" + i;
        }
        if (Integer.parseInt(parts[1]) >= 100 && Integer.parseInt(parts[1]) < 1000) {
            int i = Integer.parseInt(parts[1]) + 1;
            id = "LDV" + i;
        }
        return id;
    }
    public void clearText()
    {
        txtTenLoaiDichVu.setText("");
    }
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
            java.util.logging.Logger.getLogger(frmAddServiceType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAddServiceType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAddServiceType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAddServiceType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAddServiceType().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private javax.swing.JTextField txtTenLoaiDichVu;
    // End of variables declaration//GEN-END:variables
}
