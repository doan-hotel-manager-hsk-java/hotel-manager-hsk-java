package gui;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;
import gui.frmBookRoom;
import gui.frmService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author vomin
 */
public class MainEmployee extends javax.swing.JFrame {

    private static String username;

    public MainEmployee(String _userName) {
        username = _userName;
        this.setUndecorated(true);
        this.setResizable(true);
        this.setVisible(true);

        initComponents();

        // full screen
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);

        // set pnl room focus
        pnlRoom.setFocusable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlSlide = new javax.swing.JPanel();
        pnlImage = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new com.k33ptoo.components.KButton();
        pnlRoom = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        lblRoom = new javax.swing.JLabel();
        pnlService = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lblService = new javax.swing.JLabel();
        pnlChangePass = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblChangePass = new javax.swing.JLabel();
        pnlTitile = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setPreferredSize(new java.awt.Dimension(700, 600));
        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlSlide.setBackground(new java.awt.Color(237, 240, 250));
        pnlSlide.setPreferredSize(new java.awt.Dimension(250, 200));

        pnlImage.setBackground(new java.awt.Color(237, 240, 250));
        pnlImage.setPreferredSize(new java.awt.Dimension(250, 119));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Nhân viên");

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel18.setText("Võ Minh Phương");

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-manager.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout-icon-16.png"))); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.setAlignmentX(0.9F);
        btnLogout.setAlignmentY(10.0F);
        btnLogout.setDefaultCapable(false);
        btnLogout.setFocusable(false);
        btnLogout.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setIconTextGap(1);
        btnLogout.setkEndColor(new java.awt.Color(5, 154, 3));
        btnLogout.setkHoverEndColor(new java.awt.Color(22, 146, 224));
        btnLogout.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnLogout.setkHoverStartColor(new java.awt.Color(129, 61, 191));
        btnLogout.setkStartColor(new java.awt.Color(16, 218, 246));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlImageLayout = new javax.swing.GroupLayout(pnlImage);
        pnlImage.setLayout(pnlImageLayout);
        pnlImageLayout.setHorizontalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImageLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addGroup(pnlImageLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlImageLayout.createSequentialGroup()
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlImageLayout.setVerticalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImageLayout.createSequentialGroup()
                .addGroup(pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlImageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlImage);

        pnlRoom.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlRoom.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlRoom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnlRoomFocusGained(evt);
            }
        });
        pnlRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlRoomMousePressed(evt);
            }
        });

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/room.png"))); // NOI18N
        jLabel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel29.setPreferredSize(new java.awt.Dimension(30, 30));

        lblRoom.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblRoom.setText("Phòng");
        lblRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlRoomLayout = new javax.swing.GroupLayout(pnlRoom);
        pnlRoom.setLayout(pnlRoomLayout);
        pnlRoomLayout.setHorizontalGroup(
            pnlRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoomLayout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblRoom)
                .addGap(0, 159, Short.MAX_VALUE))
        );
        pnlRoomLayout.setVerticalGroup(
            pnlRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoomLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRoom))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlRoom);

        pnlService.setBackground(new java.awt.Color(255, 255, 255));
        pnlService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlService.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlServiceMousePressed(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/service.png"))); // NOI18N
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.setPreferredSize(new java.awt.Dimension(30, 30));

        lblService.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblService.setText("Dịch vụ");
        lblService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlServiceLayout = new javax.swing.GroupLayout(pnlService);
        pnlService.setLayout(pnlServiceLayout);
        pnlServiceLayout.setHorizontalGroup(
            pnlServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServiceLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblService)
                .addGap(0, 149, Short.MAX_VALUE))
        );
        pnlServiceLayout.setVerticalGroup(
            pnlServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServiceLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblService))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlService);

        pnlChangePass.setBackground(new java.awt.Color(255, 255, 255));
        pnlChangePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlChangePass.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlChangePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlChangePassMousePressed(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/padlock.png"))); // NOI18N
        jLabel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.setPreferredSize(new java.awt.Dimension(30, 30));

        lblChangePass.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblChangePass.setText("Đổi mật khẩu");
        lblChangePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlChangePassLayout = new javax.swing.GroupLayout(pnlChangePass);
        pnlChangePass.setLayout(pnlChangePassLayout);
        pnlChangePassLayout.setHorizontalGroup(
            pnlChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChangePassLayout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblChangePass)
                .addGap(0, 105, Short.MAX_VALUE))
        );
        pnlChangePassLayout.setVerticalGroup(
            pnlChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChangePassLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChangePass))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlChangePass);

        pnlMain.add(pnlSlide, java.awt.BorderLayout.WEST);

        pnlTitile.setBackground(new java.awt.Color(41, 141, 71));
        pnlTitile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlTitile.setPreferredSize(new java.awt.Dimension(40, 40));
        pnlTitile.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(153, 204, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hotel ABC");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setPreferredSize(new java.awt.Dimension(115, 20));
        pnlTitile.add(jLabel2, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlTitile, java.awt.BorderLayout.PAGE_START);

        pnlForm.setBackground(new java.awt.Color(255, 255, 255));
        pnlForm.setLayout(new java.awt.BorderLayout());
        pnlMain.add(pnlForm, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.setVisible(false);
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void pnlRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoomMousePressed

        setColor(pnlRoom, lblRoom);
        resetColor(pnlService, lblService);
        resetColor(pnlChangePass, lblChangePass);
        frmBookRoom frame = new frmBookRoom();
        openComponent(frame);

    }//GEN-LAST:event_pnlRoomMousePressed

    private void pnlServiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlServiceMousePressed
        try {
            setColor(pnlService, lblService);
            resetColor(pnlRoom, lblRoom);
            resetColor(pnlChangePass, lblChangePass);
            frmService frame = new frmService();
            openComponent(frame);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pnlServiceMousePressed

    private void pnlRoomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnlRoomFocusGained

        setColor(pnlRoom, lblRoom);
        resetColor(pnlService, lblService);
        resetColor(pnlChangePass, lblChangePass);
        frmBookRoom frame = new frmBookRoom();
        openComponent(frame);

    }//GEN-LAST:event_pnlRoomFocusGained

    private void pnlChangePassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlChangePassMousePressed
        setColor(pnlChangePass, lblChangePass);
        resetColor(pnlService, lblService);
        resetColor(pnlRoom, lblRoom);

        frmChangePass frm = new frmChangePass(username);
        frm.setVisible(true);
    }//GEN-LAST:event_pnlChangePassMousePressed
    // open frame when click panel
    void openComponent(JInternalFrame frame) {
        Component[] components = pnlForm.getComponents();
        Component component = null;
        for (int i = 0; i < components.length; i++) {
            component = components[i];
            if (component != null) {
                component.setVisible(false);
            }
        }
        pnlForm.add(frame);
        frame.setVisible(true);
    }

    // set color
    void setColor(JPanel panel, JLabel label) {
        panel.setBackground(new Color(204, 232, 255));
        label.setForeground(new Color(33, 162, 72));
    }

    // rest color
    void resetColor(JPanel panel, JLabel label) {
        panel.setBackground(new Color(255, 255, 255));
        label.setForeground(new Color(0, 0, 0));
    }

    public MainEmployee(KButton btnLogout, JLabel jLabel1, JLabel jLabel15, JLabel jLabel16, JLabel jLabel17, JLabel jLabel18, JLabel jLabel19, JLabel jLabel2, JLabel jLabel20, JLabel jLabel21, JLabel jLabel22, JLabel jLabel29, JPanel jPanel11, KGradientPanel kGradientPanel1, JLabel lblContactInfo, JLabel lblDevice, JLabel lblEmployee, JLabel lblHome, JLabel lblRoom, JLabel lblService, JLabel lblStatistics, JPanel pnlContacInfo, JPanel pnlDevice, JPanel pnlEmployee, JPanel pnlForm, JPanel pnlHome, JPanel pnlImage, JPanel pnlMain, JPanel pnlRoom, JPanel pnlService, JPanel pnlSlide, JPanel pnlStatistics, JPanel pnlTitile) throws HeadlessException {
        this.btnLogout = btnLogout;
        this.jLabel1 = jLabel1;
        this.jLabel16 = jLabel16;
        this.jLabel17 = jLabel17;
        this.jLabel18 = jLabel18;
        this.jLabel2 = jLabel2;
        this.jLabel29 = jLabel29;
        this.jPanel11 = jPanel11;
        this.lblRoom = lblRoom;
        this.lblService = lblService;
        this.pnlForm = pnlForm;
        this.pnlImage = pnlImage;
        this.pnlMain = pnlMain;
        this.pnlRoom = pnlRoom;
        this.pnlService = pnlService;
        this.pnlSlide = pnlSlide;
        this.pnlTitile = pnlTitile;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainEmployee(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JLabel lblChangePass;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblService;
    private javax.swing.JPanel pnlChangePass;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlImage;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRoom;
    private javax.swing.JPanel pnlService;
    private javax.swing.JPanel pnlSlide;
    private javax.swing.JPanel pnlTitile;
    // End of variables declaration//GEN-END:variables
}
