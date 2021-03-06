package gui;

import dao.AccountDAO;
import dao.StaffDAO;
import entity.Staff;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends javax.swing.JFrame {

    AccountDAO accountDAO;
    StaffDAO staffDAO;

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        chkSave = new javax.swing.JCheckBox();
        lblForgotPass = new javax.swing.JLabel();
        btnLogin = new com.k33ptoo.components.KButton();
        btnExit = new com.k33ptoo.components.KButton();
        jPanel3 = new javax.swing.JPanel();
        imgLogin = new javax.swing.JLabel();

        setTitle("Đăng nhập");
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(107, 193, 133));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 0));

        jPanel2.setBackground(new java.awt.Color(107, 193, 133));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome Hotel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jPanel4.setBackground(new java.awt.Color(107, 193, 133));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 150));

        jPanel6.setBackground(new java.awt.Color(107, 193, 133));
        jPanel6.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel6.setLayout(new java.awt.BorderLayout(4, 4));

        txtUserName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUserName.setPreferredSize(new java.awt.Dimension(7, 25));
        jPanel6.add(txtUserName, java.awt.BorderLayout.PAGE_END);

        jLabel3.setBackground(new java.awt.Color(22, 147, 224));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User name: ");
        jPanel6.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6);

        jPanel5.setBackground(new java.awt.Color(107, 193, 133));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel5.setLayout(new java.awt.BorderLayout(4, 4));

        jLabel2.setBackground(new java.awt.Color(22, 147, 224));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password: ");
        jPanel5.add(jLabel2, java.awt.BorderLayout.CENTER);

        txtPassword.setPreferredSize(new java.awt.Dimension(7, 25));
        jPanel5.add(txtPassword, java.awt.BorderLayout.PAGE_END);

        jPanel4.add(jPanel5);

        jPanel7.setBackground(new java.awt.Color(107, 193, 133));
        jPanel7.setPreferredSize(new java.awt.Dimension(300, 25));
        jPanel7.setLayout(new java.awt.BorderLayout());

        chkSave.setBackground(new java.awt.Color(107, 193, 133));
        chkSave.setText("Ghi nhớ tài khoản");
        jPanel7.add(chkSave, java.awt.BorderLayout.WEST);

        lblForgotPass.setForeground(new java.awt.Color(255, 0, 51));
        lblForgotPass.setText("Bạn quên mật khẩu ?");
        lblForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblForgotPassMousePressed(evt);
            }
        });
        jPanel7.add(lblForgotPass, java.awt.BorderLayout.EAST);

        jPanel4.add(jPanel7);

        jPanel1.add(jPanel4);

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Login-icon-16.png"))); // NOI18N
        btnLogin.setText("Đăng nhập");
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogin.setkEndColor(new java.awt.Color(102, 255, 51));
        btnLogin.setkHoverColor(new java.awt.Color(255, 153, 153));
        btnLogin.setkHoverForeGround(new java.awt.Color(255, 255, 102));
        btnLogin.setkHoverStartColor(new java.awt.Color(255, 204, 51));
        btnLogin.setkIndicatorThickness(10);
        btnLogin.setkPressedColor(new java.awt.Color(0, 255, 255));
        btnLogin.setPreferredSize(new java.awt.Dimension(120, 30));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon-16.png"))); // NOI18N
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExit.setHideActionText(true);
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setIconTextGap(20);
        btnExit.setkEndColor(new java.awt.Color(102, 255, 51));
        btnExit.setkHoverColor(new java.awt.Color(255, 153, 153));
        btnExit.setkHoverForeGround(new java.awt.Color(255, 255, 102));
        btnExit.setkHoverStartColor(new java.awt.Color(255, 204, 51));
        btnExit.setkPressedColor(new java.awt.Color(51, 255, 255));
        btnExit.setLabel("Thoát");
        btnExit.setPreferredSize(new java.awt.Dimension(120, 30));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        imgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_login.jpg"))); // NOI18N
        jPanel3.add(imgLogin);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát ?", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        accountDAO = new AccountDAO();
        staffDAO = new StaffDAO();

        String username = accountDAO.findUserName(txtUserName.getText().toUpperCase());
        String passwordData = accountDAO.findPass(username);
        String statusNV = staffDAO.getEmployeeBYID(username).getTrangThai();
        String passwordInput = String.valueOf(txtPassword.getPassword());

        if (txtUserName.getText().equals("") || passwordInput.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tài khoản hoặc mật khẩu");
        } else {
            if (username != null && passwordData.equals(passwordInput)) {
                if (statusNV != null) {
                    String employeeType = staffDAO.getEmployeeBYID(username).getStaffType().getIdLoaiNV();
                    if (employeeType.equals("LNV001")) {
                        this.setVisible(false);
                        MainManager mainManager = new MainManager(username);
                        mainManager.setLocationRelativeTo(this);
                        mainManager.setVisible(true);
                        dispose();
                    } else if (employeeType.equals("LNV002")) {
                        this.setVisible(false);
                        MainEmployee mainEmployee = new MainEmployee(username);
                        mainEmployee.setVisible(true);
                    }
                } else{
                    JOptionPane.showMessageDialog(this, "Tài khoản đã bị xóa");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn nhập sai mật khẩu hoặc tài khoản");
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblForgotPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPassMousePressed
        JOptionPane.showMessageDialog(this, "Vui lòng liên hệ quản lý");
    }//GEN-LAST:event_lblForgotPassMousePressed

    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, UnsupportedLookAndFeelException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login frm = new Login();
                frm.setDefaultCloseOperation(HIDE_ON_CLOSE);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnExit;
    private com.k33ptoo.components.KButton btnLogin;
    private javax.swing.JCheckBox chkSave;
    private javax.swing.JLabel imgLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblForgotPass;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
