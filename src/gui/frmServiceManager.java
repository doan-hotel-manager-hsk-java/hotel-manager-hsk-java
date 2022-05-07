/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import dao.ServiceDAO;
import dao.ServiceTypeDAO;
import dao.StaffDAO;
import entity.Service;
import entity.ServiceType;
import entity.Staff;
import gui.frmAddServiceType;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vomin
 */
public class frmServiceManager extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame1
     */
    //model
    private DefaultTableModel modelTableService;
    //Dao
    private ServiceDAO serviceDAO;
    private ServiceTypeDAO serviceTypeDAO;
    private StaffDAO staffDAO;

    //
    private String id;
    private String username;

    public frmServiceManager(String _username) {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);

        initComponents();
        this.setFocusable(true);

        username = _username;
        modelTableService = new DefaultTableModel();

        serviceDAO = new ServiceDAO();
        serviceTypeDAO = new ServiceTypeDAO();
        staffDAO = new StaffDAO();

        LoadDataToCombobox();
        initColTableService();
        loadDataToTableService();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlTitle = new javax.swing.JPanel();
        lblTitile = new javax.swing.JLabel();
        pnlAddSerice = new javax.swing.JPanel();
        btnAddService = new com.k33ptoo.components.KButton();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cboTypeService2 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumberRoom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBasicPrice = new javax.swing.JTextField();
        cboTypeService = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableServiceManager = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnThemDichVu = new com.k33ptoo.components.KButton();
        btnSuaDichVu = new com.k33ptoo.components.KButton();
        btnXoaDichVu = new com.k33ptoo.components.KButton();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);

        pnlTitle.setLayout(new java.awt.BorderLayout());

        lblTitile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitile.setText("QUẢN LÝ DỊCH VỤ");
        pnlTitle.add(lblTitile, java.awt.BorderLayout.CENTER);

        pnlAddSerice.setLayout(new java.awt.BorderLayout());

        btnAddService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-plus.png"))); // NOI18N
        btnAddService.setText("Thêm loại dịch vụ");
        btnAddService.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddService.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddService.setkHoverEndColor(new java.awt.Color(0, 204, 153));
        btnAddService.setkHoverForeGround(new java.awt.Color(0, 255, 204));
        btnAddService.setkHoverStartColor(new java.awt.Color(0, 204, 102));
        btnAddService.setkPressedColor(new java.awt.Color(0, 204, 51));
        btnAddService.setkSelectedColor(new java.awt.Color(0, 153, 0));
        btnAddService.setkStartColor(new java.awt.Color(0, 204, 0));
        btnAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceActionPerformed(evt);
            }
        });
        pnlAddSerice.add(btnAddService, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(204, 204, 204));
        txtSearch.setText("Tìm dịch vụ");
        txtSearch.setBorder(null);
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        jPanel1.add(txtSearch, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(cboTypeService2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tên dịch vụ: ");

        txtNumberRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Loại dịch vụ: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Giá dịch vụ: ");

        txtBasicPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cboTypeService.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumberRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                            .addComponent(txtBasicPrice)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboTypeService, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumberRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTypeService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBasicPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách dịch vụ"));

        tableServiceManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên dịch vụ", "Loại dịch vụ", "Giá dịch vụ"
            }
        ));
        tableServiceManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableServiceManagerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableServiceManager);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Xử lý"));

        btnThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-add.png"))); // NOI18N
        btnThemDichVu.setText("Thêm dịch vụ");
        btnThemDichVu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemDichVu.setIconTextGap(25);
        btnThemDichVu.setkEndColor(new java.awt.Color(51, 255, 255));
        btnThemDichVu.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnThemDichVu.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnThemDichVu.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnThemDichVu.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnThemDichVu.setkStartColor(new java.awt.Color(51, 51, 255));
        btnThemDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemDichVuMouseClicked(evt);
            }
        });

        btnSuaDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons-edit.png"))); // NOI18N
        btnSuaDichVu.setText("Sửa dịch vụ");
        btnSuaDichVu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuaDichVu.setIconTextGap(25);
        btnSuaDichVu.setkEndColor(new java.awt.Color(51, 255, 255));
        btnSuaDichVu.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnSuaDichVu.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnSuaDichVu.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnSuaDichVu.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnSuaDichVu.setkStartColor(new java.awt.Color(51, 51, 255));
        btnSuaDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaDichVuMouseClicked(evt);
            }
        });

        btnXoaDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon-16.png"))); // NOI18N
        btnXoaDichVu.setText("Xóa dịch vụ");
        btnXoaDichVu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaDichVu.setIconTextGap(25);
        btnXoaDichVu.setkEndColor(new java.awt.Color(51, 255, 255));
        btnXoaDichVu.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnXoaDichVu.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnXoaDichVu.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnXoaDichVu.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnXoaDichVu.setkStartColor(new java.awt.Color(51, 51, 255));
        btnXoaDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaDichVuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnSuaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnXoaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlAddSerice, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAddSerice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Tìm dịch vụ")) {
            txtSearch.setText("");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText() != null) {
            txtSearch.setText("Tìm dịch vụ");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtSearchFocusLost

    public String idService() {
        String id = "";
        for (Service service : serviceDAO.getAllService()) {
            id = service.getMaDV().toString();
        }
        String[] parts = id.split("V");
        if (Integer.parseInt(parts[1]) < 10) {
            int i = Integer.parseInt(parts[1]) + 1;
            id = "DV00" + i;
        }
        if (Integer.parseInt(parts[1]) >= 10 && Integer.parseInt(parts[1]) < 100) {
            int i = Integer.parseInt(parts[1]) + 1;
            id = "DV0" + i;
        }
        if (Integer.parseInt(parts[1]) >= 100 && Integer.parseInt(parts[1]) < 1000) {
            int i = Integer.parseInt(parts[1]) + 1;
            id = "DV" + i;
        }
        return id;
    }
    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        frmAddServiceType frame = new frmAddServiceType();
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void btnThemDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemDichVuMouseClicked

        String gia = txtBasicPrice.getText().trim();
        String name = txtNumberRoom.getText().trim();
        String loaiDV = cboTypeService.getSelectedItem().toString();
        String idService = idService();
        for (Service service : serviceDAO.getAllService()) {
            if (name.equals(service.getTenDV())) {
                JOptionPane.showConfirmDialog(this, "Dịch vụ đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        ServiceType serviceType = serviceTypeDAO.findServiceTypeByName(loaiDV);
        Staff staff = staffDAO.getEmployeeBYID(username);
        Service service = new Service(idService, name, Double.parseDouble(gia), "1", serviceType, staff);
        if (serviceDAO.addService(service)) {
            JOptionPane.showMessageDialog(this, "Thêm dịch vụ thành công!");
            loadDataToTableService();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm dịch vụ thất bại!");
        }
    }//GEN-LAST:event_btnThemDichVuMouseClicked

    private void btnSuaDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaDichVuMouseClicked
        String gia = txtBasicPrice.getText().trim();
        String name = txtNumberRoom.getText().trim();
        Staff staff = staffDAO.getEmployeeBYID(username);
        Service service = serviceDAO.findServiceByID(id);
        for (Service service1 : serviceDAO.getAllService()) {
            if (name.equals(service1.getTenDV())) {
                JOptionPane.showConfirmDialog(this, "Dịch vụ đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        try {
            int choise = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa dịch vụ này không?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (service != null) {
                if (choise == JOptionPane.YES_OPTION) {
                    service.setDonGia(Double.parseDouble(gia));
                    service.setTenDV(name);
                    service.setStaff(staff);
                    if (serviceDAO.updateService(service)) {
                        JOptionPane.showMessageDialog(this, "Chỉnh sửa dịch vụ thành công!");
                        loadDataToTableService();
                    } else {
                        JOptionPane.showMessageDialog(this, "Chỉnh sửa dịch vụ thất bại!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaDichVuMouseClicked

    private void btnXoaDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaDichVuMouseClicked
        //String name = txtNumberRoom.getText().trim();
        Service service = serviceDAO.findServiceByID(id);
        Staff staff = staffDAO.getEmployeeBYID(username);
        service.setTrangThai("0");
        service.setStaff(staff);
        try {
            int choise = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dịch vụ này không?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (service != null) {
                if (choise == JOptionPane.YES_OPTION) {
                    if (serviceDAO.deleteService(service)) {
                        JOptionPane.showMessageDialog(this, " Xóa thành công!");
                        loadDataToTableService();
                    } else {
                        JOptionPane.showMessageDialog(this, "Dịch vụ chưa được xóa!");
                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaDichVuMouseClicked

    private void tableServiceManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableServiceManagerMouseClicked
        int selected = tableServiceManager.getSelectedRow();
        if (selected >= 0) {
            id = (String) tableServiceManager.getValueAt(selected, 0);
            System.err.println(id);
            txtNumberRoom.setText((String) tableServiceManager.getValueAt(selected, 1));
            txtBasicPrice.setText((String) tableServiceManager.getValueAt(selected, 2).toString());
            cboTypeService.setSelectedItem((String) tableServiceManager.getValueAt(selected, 3));
        }
    }//GEN-LAST:event_tableServiceManagerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnAddService;
    private com.k33ptoo.components.KButton btnSuaDichVu;
    private com.k33ptoo.components.KButton btnThemDichVu;
    private com.k33ptoo.components.KButton btnXoaDichVu;
    private javax.swing.JComboBox<String> cboTypeService;
    private javax.swing.JComboBox<String> cboTypeService2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitile;
    private javax.swing.JPanel pnlAddSerice;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTable tableServiceManager;
    private javax.swing.JTextField txtBasicPrice;
    private javax.swing.JTextField txtNumberRoom;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void LoadDataToCombobox() {
        for (ServiceType serviceType : serviceTypeDAO.getAllServiceType()) {
            cboTypeService.addItem(serviceType.getTenLoaiDV());
            cboTypeService2.addItem(serviceType.getTenLoaiDV());
        }
    }

    private void initColTableService() {
        modelTableService.setColumnIdentifiers(new String[]{
            "Mã Dịch Vụ", "Tên Dịch Vụ", "Giá Dịch Vụ", "Loại Dịch Vụ"
        });
        tableServiceManager.setModel(modelTableService);
    }

    private void loadDataToTableService() {
        modelTableService.setRowCount(0);
        for (Service service : serviceDAO.getAllService()) {
            if (service.getTrangThai().equals("1")) {
                Object[] row = new Object[]{
                    service.getMaDV(), service.getTenDV(), service.getDonGia(), service.getServiceType().getTenLoaiDV()
                };
                modelTableService.addRow(row);
            }

        }
        modelTableService.fireTableDataChanged();
    }
}
