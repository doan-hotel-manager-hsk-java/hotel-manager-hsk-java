/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import dao.AccountDAO;
import dao.StaffDAO;
import dao.StaffTypeDAO;
import entity.Account;
import entity.Staff;
import entity.StaffType;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import regex.RegexHelper;

/**
 *
 * @author vomin
 */
public class frmEmployeeManager extends javax.swing.JInternalFrame {
    private StaffDAO staffDAO;
    private StaffTypeDAO staffTypeDAO;
    private DefaultTableModel dtm;
    private AccountDAO accountDAO;
    /**
     * Creates new form NewJInternalFrame1
     */
    public frmEmployeeManager() {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);

        initComponents();
        this.setFocusable(true);
        
        dtm=(DefaultTableModel) tblEmployee.getModel();
        staffDAO=new StaffDAO();
        staffTypeDAO=new StaffTypeDAO();
        loadDataToTable(staffDAO.getAllStaffByStatus(), dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlTitle = new javax.swing.JPanel();
        lblTitile = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cmbChucVu1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cmbGioiTinh = new javax.swing.JComboBox<>();
        cmbChucVu = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new com.k33ptoo.components.KButton();
        btnSua = new com.k33ptoo.components.KButton();
        btnXoa = new com.k33ptoo.components.KButton();
        btnTaoAccount = new com.k33ptoo.components.KButton();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);

        pnlTitle.setLayout(new java.awt.BorderLayout());

        lblTitile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitile.setText("QU???N L?? NH??N VI??N");
        pnlTitle.add(lblTitile, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(204, 204, 204));
        txtSearch.setText("T??m nh??n vi??n");
        txtSearch.setBorder(null);
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        cmbChucVu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbChucVu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T???t c???", "L??? t??n", "V??? sinh", "B???o v???" }));
        cmbChucVu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbChucVu1ActionPerformed(evt);
            }
        });
        jPanel2.add(cmbChucVu1, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Th??ng tin chi ti???t"));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Email: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("T??n nh??n vi??n: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("S??T: ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Ch???c v???:");

        txtCMND.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Gi???i t??nh: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("CMND: ");

        txtTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cmbGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "N???" }));

        cmbChucVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L??? t??n", "V??? sinh", "B???o v???" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addComponent(txtTen)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbChucVu, 0, 278, Short.MAX_VALUE)
                            .addComponent(txtCMND))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh s??ch nh??n vi??n"));

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CMND/CCCD", "T??n nh??n vi??n", "Gi???i t??nh", "SDT", "Ch???c v???", "Email", "T??i kho???n"
            }
        ));
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployee);
        if (tblEmployee.getColumnModel().getColumnCount() > 0) {
            tblEmployee.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("X??? l??"));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-add.png"))); // NOI18N
        btnThem.setText("Th??m nh??n vi??n");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIconTextGap(25);
        btnThem.setkEndColor(new java.awt.Color(51, 255, 255));
        btnThem.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnThem.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnThem.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnThem.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnThem.setkStartColor(new java.awt.Color(51, 51, 255));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons-edit.png"))); // NOI18N
        btnSua.setText("S???a nh??n vi??n");
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIconTextGap(25);
        btnSua.setkEndColor(new java.awt.Color(51, 255, 255));
        btnSua.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnSua.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnSua.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnSua.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnSua.setkStartColor(new java.awt.Color(51, 51, 255));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon-16.png"))); // NOI18N
        btnXoa.setText("X??a nh??n vi??n");
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIconTextGap(25);
        btnXoa.setkEndColor(new java.awt.Color(51, 255, 255));
        btnXoa.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnXoa.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnXoa.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnXoa.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnXoa.setkStartColor(new java.awt.Color(51, 51, 255));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnTaoAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-plus.png"))); // NOI18N
        btnTaoAccount.setText("T???o t??i kho???n");
        btnTaoAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaoAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTaoAccount.setkHoverEndColor(new java.awt.Color(0, 204, 153));
        btnTaoAccount.setkHoverForeGround(new java.awt.Color(0, 255, 204));
        btnTaoAccount.setkHoverStartColor(new java.awt.Color(0, 204, 102));
        btnTaoAccount.setkPressedColor(new java.awt.Color(0, 204, 51));
        btnTaoAccount.setkSelectedColor(new java.awt.Color(0, 153, 0));
        btnTaoAccount.setkStartColor(new java.awt.Color(0, 204, 0));
        btnTaoAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTaoAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(15, 15, 15))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("T??m nh??n vi??n")) {
            txtSearch.setText("");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText() != null) {
            txtSearch.setText("T??m nh??n vi??n");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void btnTaoAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoAccountActionPerformed
        int index= tblEmployee.getSelectedRow();        
        if (index==-1){
            JOptionPane.showMessageDialog(this, "H??y ch???n nh??n vi??n c???n t???o t??i kho???n!");
        }else{
            String chucVu= dtm.getValueAt(index, 4)+"";
            if ("B???o v???".equals(chucVu)  || "V??? sinh".equals(chucVu)){
                JOptionPane.showMessageDialog(this, "Ch??? c?? th??? t???o t??i kho???n cho l??? t??n!");
            } else if(dtm.getValueAt(index, 6) != "Ch??a c??"){
                JOptionPane.showMessageDialog(this, "Nh??n vi??n n??y ???? c?? t??i kho???n !!");
            }else{
                int choose = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n t???o t??i kho???n cho nh??n vi??n n??y?", "H???i", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choose == JOptionPane.YES_OPTION) {
                    Staff s= staffDAO.findStaffByCMND(dtm.getValueAt(index, 0)+"");
                    String taiKhoan=s.getMaNV();
                    Account a=new Account(taiKhoan,"123456");
                    accountDAO.insertAccount(a);
                    loadDataToTable(staffDAO.getAllStaffByStatus(), dtm);
                    JOptionPane.showMessageDialog(this, "T???o th??nh c??ng! \n Username: " + taiKhoan+"\n Pass m???c ?????nh: 123456");
                    clearInput();
                }
            } 
        }   
    }//GEN-LAST:event_btnTaoAccountActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkData()){
            Staff s= createStaff();
            try{
                if(staffDAO.findStaffByCMND(txtCMND.getText()) ==null){
                    staffDAO.insertStaff(s);
                    loadDataToTable(staffDAO.getAllStaffByStatus(), dtm);
                    clearInput();
                    JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng!");
                }else
                    JOptionPane.showMessageDialog(this, "M?? CMND n??y ???? c??, h??y ki???m tra l???i!");                        
            }catch (Exception e1){
                JOptionPane.showMessageDialog(this, e1.getMessage());
            } 
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        int index=tblEmployee.getSelectedRow();
        txtCMND.setText(tblEmployee.getValueAt(index, 0).toString());
        txtTen.setText(tblEmployee.getValueAt(index, 1).toString());
        cmbGioiTinh.setSelectedItem(tblEmployee.getValueAt(index, 2).toString());
        txtSDT.setText(tblEmployee.getValueAt(index, 3).toString());
        cmbChucVu.setSelectedItem(tblEmployee.getValueAt(index, 4));
        txtEmail.setText(tblEmployee.getValueAt(index, 5).toString());
        
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        
        int index = tblEmployee.getSelectedRow();
        if (index==-1){
            JOptionPane.showMessageDialog(this, "H??y ch???n d??ng c???n s???a!");
        }else{
        if (checkData()){
            staffTypeDAO=new StaffTypeDAO();
            Staff s=staffDAO.findStaffByCMND(dtm.getValueAt(index, 0)+"");            
            if(!txtCMND.getText().equals(dtm.getValueAt(index, 0)+"")){
                JOptionPane.showMessageDialog(this, "Kh??ng ???????c s???a CMND!");
            }else{
            s.setTenNV(txtTen.getText());
            s.setSdt(txtSDT.getText());
            s.setEmail(txtEmail.getText());
            s.setGioiTinh(cmbGioiTinh.getSelectedItem().toString().equals("Nam"));
            s.setStaffType(staffTypeDAO.findStaffByName(cmbChucVu.getSelectedItem().toString()));
            if (s.getCmnd().equals(dtm.getValueAt(index, 0)+""))
                staffDAO.updateStaff(s);
            cmbChucVu1.setSelectedIndex(0);
            
            loadDataToTable(staffDAO.getAllStaffByStatus(), dtm);
            clearInput();
            JOptionPane.showMessageDialog(this, "S???a th??nh c??ng!");
            }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
         int index= tblEmployee.getSelectedRow();
        if (index==-1){
            JOptionPane.showMessageDialog(this, "H??y ch???n d??ng c???n x??a!");
        }else{
            int choose = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n x??a nh??n vi??n n??y?", "H???i", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choose == JOptionPane.YES_OPTION) {
                Staff s=staffDAO.findStaffByCMND(dtm.getValueAt(index, 0)+"");
                s.setTrangThai(null);
                staffDAO.updateStaff(s);
                cmbChucVu1.setSelectedIndex(0);
                loadDataToTable(staffDAO.getAllStaffByStatus(), dtm);
                clearInput();
                JOptionPane.showMessageDialog(this, "X??a th??nh c??ng!");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String s=txtSearch.getText();
        filter(s);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cmbChucVu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbChucVu1ActionPerformed
        String chucVu= cmbChucVu1.getSelectedItem().toString();
        if (!chucVu.equals("T???t c???")){
        String maChucVu = staffTypeDAO.findStaffByName(chucVu).getIdLoaiNV();
        loadDataToTable(staffDAO.getAllStaffByType(maChucVu), dtm);
        }else
            loadDataToTable(staffDAO.getAllStaffByStatus(), dtm);
    }//GEN-LAST:event_cmbChucVu1ActionPerformed
    private void filter(String s){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(dtm);
        tblEmployee.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+s));

        
    }
    
    private void loadDataToTable(List<Staff> list, DefaultTableModel dtm) {  
        dtm.setRowCount(0);
        accountDAO=new AccountDAO();
        for (Staff s: list) {
            String taiKhoan = "Ch??a c??";
            if (accountDAO.findUserName(s.getMaNV()) != null )
                if (!s.getStaffType().getIdLoaiNV().equals("LNV002"))
                    taiKhoan="???? kh??a";
                else
                    taiKhoan=s.getMaNV();
            
            dtm.addRow(new String[] {s.getCmnd(),s.getTenNV(),s.getGioiTinh()== true ? "Nam" : "N???",s.getSdt(),s.getStaffType().getTenLoaiNV(),s.getEmail(), taiKhoan});
        }
    }
    private Staff createStaff() {
        String tenNV= txtTen.getText();
        String cmnd=txtCMND.getText();
        String sdt=txtSDT.getText();
        String email= txtEmail.getText();
        boolean gioiTinh =cmbGioiTinh.getSelectedItem().toString().equals("Nam");
        StaffTypeDAO stD=new StaffTypeDAO();
        StaffType st= stD.findStaffByName(cmbChucVu.getSelectedItem().toString());
        
        Staff s=new Staff(setMaNV(), tenNV, gioiTinh, email, cmnd, sdt, "1", st);
        return s;
    }
    
     private String setMaNV(){
        String s="NV";
        int ma= staffDAO.getAllStaff().size();
        if (ma<9)
            s=s+ "00"+ (ma+1);
        else
            s=s+"0"+(ma+1);
        return s;
    }
    private void clearInput(){
        txtCMND.setText("");
        txtEmail.setText("");
        txtSearch.setText("");
        txtSDT.setText("");
        txtTen.setText("");
        txtCMND.requestFocus();
    }

     private boolean checkData() {
        if (txtTen.getText().trim().equals("") || txtSDT.getText().trim().equals("") || txtEmail.getText().trim().equals("") || txtCMND.getText().trim().equals("") ){
            JOptionPane.showMessageDialog(this, "H??y nh???p ?????y ????? th??ng tin!");
            return false;
        }else{
            String thongBao="";
            if (!RegexHelper.regexCMND(txtCMND.getText()))
                thongBao+="*S??? ch???ng minh nh??n g???m 9 s???, kh??ng ch???a k?? t???!\n";
            if(!RegexHelper.regexCustomerName(txtTen.getText()))
                thongBao+="*T??n kh??ch h??ng sai ?????nh d???ng! VD: L?? Tu???n\n";
            if(!RegexHelper.regexPhoneNumber(txtSDT.getText()))
                thongBao+="*S??? ??i???n tho???i kh??ng ch???a k?? t??? ch???, ph???i ????? 10 s??? v?? b???t ?????u b???ng c??c ?????u s??? h???p l??? ( 09, 08, 03, 07, 05 )! VD: 0343229978\n";
            if (!RegexHelper.regexEmail(txtEmail.getText()))
                thongBao+="*Email sai ?????nh d???ng! VD: thu123@gmail.com";
            if (thongBao.isEmpty())
                return true;
            else{
                JOptionPane.showMessageDialog(this, thongBao);
                return false;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnSua;
    private com.k33ptoo.components.KButton btnTaoAccount;
    private com.k33ptoo.components.KButton btnThem;
    private com.k33ptoo.components.KButton btnXoa;
    private javax.swing.JComboBox<String> cmbChucVu;
    private javax.swing.JComboBox<String> cmbChucVu1;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitile;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
