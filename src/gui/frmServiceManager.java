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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import regex.RegexHelper;

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

    private RegexHelper helper;
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
        helper = new RegexHelper();

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
        txtServiceName = new javax.swing.JTextField();
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
        lblTitile.setText("QU???N L?? D???CH V???");
        pnlTitle.add(lblTitile, java.awt.BorderLayout.CENTER);

        pnlAddSerice.setLayout(new java.awt.BorderLayout());

        btnAddService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-plus.png"))); // NOI18N
        btnAddService.setText("Th??m lo???i d???ch v???");
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
        txtSearch.setText("T??m d???ch v???");
        txtSearch.setBorder(null);
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        jPanel1.add(txtSearch, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        cboTypeService2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTypeService2ItemStateChanged(evt);
            }
        });
        jPanel2.add(cboTypeService2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Th??ng tin chi ti???t"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("T??n d???ch v???: ");

        txtServiceName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Lo???i d???ch v???: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Gi?? d???ch v???: ");

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
                            .addComponent(txtServiceName, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
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
                    .addComponent(txtServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh s??ch d???ch v???"));

        tableServiceManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "T??n d???ch v???", "Lo???i d???ch v???", "Gi?? d???ch v???"
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
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("X??? l??"));

        btnThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-add.png"))); // NOI18N
        btnThemDichVu.setText("Th??m d???ch v???");
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
        btnSuaDichVu.setText("S???a d???ch v???");
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
        btnXoaDichVu.setText("X??a d???ch v???");
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
        if (txtSearch.getText().equals("T??m d???ch v???")) {
            txtSearch.setText("");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText() != null) {
            txtSearch.setText("T??m d???ch v???");
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
    private void clearText(){
        txtServiceName.setText("");
        txtSearch.setText("");
    }
    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        frmAddServiceType frame = new frmAddServiceType();
        frame.setVisible(true);
        frame.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) {
                    if (e.getComponent().isVisible() == false) {
                        LoadDataToCombobox();
                        System.err.println("kkkkk");
                    }
                }
            });
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void btnThemDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemDichVuMouseClicked

        String gia = txtBasicPrice.getText().trim();
        String name = txtServiceName.getText().trim();
        String loaiDV = cboTypeService.getSelectedItem().toString();
        if (gia.equals("") || name.equals("") || loaiDV.equals("")) {
            JOptionPane.showConfirmDialog(this, "Vui l??ng nh???p th??ng tin ????? th???c hi???n ch???c n??ng th??m", "Th??ng b??o", JOptionPane.CLOSED_OPTION);
            return;
        }
        if(!helper.regexPriceService(gia))
        {
            JOptionPane.showConfirmDialog(this, "Vui l??ng ki???m tra l???i gi?? d???ch v???", "Th??ng b??o", JOptionPane.CLOSED_OPTION);
            return;
        }
        String idService = idService();
        for (Service service : serviceDAO.getAllService()) {
            if (name.equals(service.getTenDV())) {
                JOptionPane.showConfirmDialog(this, "D???ch v??? ???? t???n t???i", "Th??ng b??o", JOptionPane.CLOSED_OPTION);
                return;
            }
        }
        ServiceType serviceType = serviceTypeDAO.findServiceTypeByName(loaiDV);
        Staff staff = staffDAO.getEmployeeBYID(username);
        Service service = new Service(idService, name, Double.parseDouble(gia), "1", serviceType, staff);
        if (serviceDAO.addService(service)) {
            JOptionPane.showMessageDialog(this, "Th??m d???ch v??? th??nh c??ng!");
            clearText();
            loadDataToTableService();
        } else {
            JOptionPane.showMessageDialog(this, "Th??m d???ch v??? th???t b???i!");
        }
    }//GEN-LAST:event_btnThemDichVuMouseClicked

    private void btnSuaDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaDichVuMouseClicked
        if (id == null) {
            JOptionPane.showConfirmDialog(this, "Vui l??ng ch???n d???ch v??? c???n s???a!", "Th??ng b??o", JOptionPane.CLOSED_OPTION);
            return;
        }
        String gia = txtBasicPrice.getText().trim();
        String name = txtServiceName.getText().trim();
        Staff staff = staffDAO.getEmployeeBYID(username);
        Service service = serviceDAO.findServiceByID(id);
        if(!helper.regexPriceService(gia))
        {
            JOptionPane.showConfirmDialog(this, "Vui l??ng ki???m tra l???i gi?? d???ch v???", "Th??ng b??o", JOptionPane.CLOSED_OPTION);
            return;
        }
        try {
            int choise = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n s???a d???ch v??? n??y kh??ng?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
            if (service != null) {
                if (choise == JOptionPane.YES_OPTION) {
                    service.setDonGia(Double.parseDouble(gia));
                    service.setTenDV(name);
                    service.setStaff(staff);
                    if (serviceDAO.updateService(service)) {
                        JOptionPane.showMessageDialog(this, "Ch???nh s???a d???ch v??? th??nh c??ng!");
                        clearText();
                        loadDataToTableService();
                    } else {
                        JOptionPane.showMessageDialog(this, "Ch???nh s???a d???ch v??? th???t b???i!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaDichVuMouseClicked

    private void btnXoaDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaDichVuMouseClicked
        if (id == null) {
            JOptionPane.showConfirmDialog(this, "Vui l??ng ch???n d???ch v??? c???n x??a!", "Th??ng b??o", JOptionPane.CLOSED_OPTION);
            return;
        }
        Service service = serviceDAO.findServiceByID(id);
        Staff staff = staffDAO.getEmployeeBYID(username);
        service.setTrangThai("0");
        service.setStaff(staff);
        try {
            int choise = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n x??a d???ch v??? n??y kh??ng?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
            if (service != null) {
                if (choise == JOptionPane.YES_OPTION) {
                    if (serviceDAO.deleteService(service)) {
                        JOptionPane.showMessageDialog(this, " X??a th??nh c??ng!");
                        clearText();
                        loadDataToTableService();
                    } else {
                        JOptionPane.showMessageDialog(this, "D???ch v??? ch??a ???????c x??a!");
                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaDichVuMouseClicked

    private void tableServiceManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableServiceManagerMouseClicked
         cboTypeService.setEnabled(false);
        int selected = tableServiceManager.getSelectedRow();
        if (selected >= 0) {
            id = (String) tableServiceManager.getValueAt(selected, 0);
            System.err.println(id);
            txtServiceName.setText((String) tableServiceManager.getValueAt(selected, 1));
            txtBasicPrice.setText((String) tableServiceManager.getValueAt(selected, 2).toString());
            cboTypeService.setSelectedItem((String) tableServiceManager.getValueAt(selected, 3));
        }
    }//GEN-LAST:event_tableServiceManagerMouseClicked

    private void cboTypeService2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTypeService2ItemStateChanged
            modelTableService.setRowCount(0);
            String txt = cboTypeService2.getSelectedItem().toString();
            if(txt.equals("T???t c???"))
            {
                loadDataToTableService();
            }
            else
            {
                loadDataToTableServiceLDV(txt);
            }
            
    }//GEN-LAST:event_cboTypeService2ItemStateChanged

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String textFind = txtSearch.getText().trim();
        if (textFind.equals("")) {
            loadDataToTableService();
            return;
        }
        List<Service> services = serviceDAO.findServiceByFirstName(textFind);

        if (services.isEmpty()) {
            services = serviceDAO.findServiceByLastName(textFind);
        }

        if (services.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kh??ng t???n t???i d???ch v??? n??y", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            loadDataToTableByFind(services);
        }
    }//GEN-LAST:event_txtSearchActionPerformed


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
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtServiceName;
    // End of variables declaration//GEN-END:variables

    public void LoadDataToCombobox() {
        cboTypeService2.addItem("T???t c???");
        for (ServiceType serviceType : serviceTypeDAO.getAllServiceType()) {
            cboTypeService.addItem(serviceType.getTenLoaiDV());
            cboTypeService2.addItem(serviceType.getTenLoaiDV());
        }
    }
           
    public void loadDataToTableByFind(List<Service> list) {
        modelTableService.setRowCount(0);

        for (Service service : list) {

            Object[] row = new Object[]{
                service.getTenDV(), service.getDonGia(), service.getServiceType().getTenLoaiDV()
            };
            modelTableService.addRow(row);
        }
    }
    private void initColTableService() {
        modelTableService.setColumnIdentifiers(new String[]{
             "T??n D???ch V???", "Gi?? D???ch V???", "Lo???i D???ch V???"
        });
        tableServiceManager.setModel(modelTableService);
    }
    private void loadDataToTableServiceLDV(String ldv) {
        modelTableService.setRowCount(0);
        for (Service service : serviceDAO.getAllService()) {
            if (service.getTrangThai().equals("1") && service.getServiceType().getTenLoaiDV().equals(ldv)) {
                Object[] row = new Object[]{
                     service.getTenDV(), service.getDonGia(), service.getServiceType().getTenLoaiDV()
                };
                modelTableService.addRow(row);
            }

        }
        modelTableService.fireTableDataChanged();
    }
    public void loadDataToTableService() {
        modelTableService.setRowCount(0);
        for (Service service : serviceDAO.getAllService()) {
            if (service.getTrangThai().equals("1")) {
                Object[] row = new Object[]{
                     service.getTenDV(), service.getDonGia(), service.getServiceType().getTenLoaiDV()
                };
                modelTableService.addRow(row);
            }

        }
        modelTableService.fireTableDataChanged();
    }
}
