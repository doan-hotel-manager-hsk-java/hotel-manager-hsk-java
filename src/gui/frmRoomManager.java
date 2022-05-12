/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import dao.RoomDAO;
import dao.RoomStatusTypeDAO;
import dao.RoomTypeDAO;
import dao.StaffDAO;
import entity.Room;
import entity.RoomStatusType;
import entity.RoomType;
import entity.Staff;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
public class frmRoomManager extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame1
     */
    private DefaultTableModel modelListRoom;

    private RoomDAO roomDao;
    private RoomTypeDAO roomTypeDAO;
    private RoomStatusTypeDAO roomStatusTypeDAO;
    private StaffDAO staffDAO;

    private RegexHelper regexHelper;

    private String username;
    private String id;

    public frmRoomManager(String _username) {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);

        initComponents();
        this.setFocusable(true);

        username = _username;
        modelListRoom = new DefaultTableModel();
        roomDao = new RoomDAO();
        roomTypeDAO = new RoomTypeDAO();
        staffDAO = new StaffDAO();
        regexHelper = new RegexHelper();

        txtBasicPrice.setEnabled(false);
        initColRoomList();
        loadDataToCombobox();
        loadDataToRoomList();
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
        cboStyleRoom2 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumberRoom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFloor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBasicPrice = new javax.swing.JTextField();
        cboStyleRoom = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRoom = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnThemPhong = new com.k33ptoo.components.KButton();
        btnSuaPhong = new com.k33ptoo.components.KButton();
        btnXoaPhong = new com.k33ptoo.components.KButton();
        pnlAddSerice = new javax.swing.JPanel();
        pnlService = new javax.swing.JPanel();
        btnAddService = new com.k33ptoo.components.KButton();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);

        pnlTitle.setLayout(new java.awt.BorderLayout());

        lblTitile.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        lblTitile.setText("QUẢN LÝ PHÒNG");
        pnlTitle.add(lblTitile, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(204, 204, 204));
        txtSearch.setText("Tìm kiếm phòng");
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

        cboStyleRoom2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboStyleRoom2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboStyleRoom2ItemStateChanged(evt);
            }
        });
        jPanel2.add(cboStyleRoom2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tên phòng: ");

        txtNumberRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tầng: ");

        txtFloor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Loại phòng: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Giá cơ bản: ");

        txtBasicPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cboStyleRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboStyleRoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboStyleRoomItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(12, 12, 12)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumberRoom)
                    .addComponent(txtFloor)
                    .addComponent(txtBasicPrice)
                    .addComponent(cboStyleRoom, 0, 593, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumberRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cboStyleRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBasicPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách phòng"));

        tableRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Số phòng", "Tầng", "Loại phòng", "Trang thiết bị", "Giá cơ bản"
            }
        ));
        tableRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRoomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRoom);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Xử lý"));

        btnThemPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-add.png"))); // NOI18N
        btnThemPhong.setText("Thêm phòng");
        btnThemPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemPhong.setIconTextGap(25);
        btnThemPhong.setkEndColor(new java.awt.Color(51, 255, 255));
        btnThemPhong.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnThemPhong.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnThemPhong.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnThemPhong.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnThemPhong.setkStartColor(new java.awt.Color(51, 51, 255));
        btnThemPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemPhongMouseClicked(evt);
            }
        });

        btnSuaPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons-edit.png"))); // NOI18N
        btnSuaPhong.setText("Sửa phòng");
        btnSuaPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuaPhong.setIconTextGap(25);
        btnSuaPhong.setkEndColor(new java.awt.Color(51, 255, 255));
        btnSuaPhong.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnSuaPhong.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnSuaPhong.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnSuaPhong.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnSuaPhong.setkStartColor(new java.awt.Color(51, 51, 255));
        btnSuaPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaPhongMouseClicked(evt);
            }
        });

        btnXoaPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon-16.png"))); // NOI18N
        btnXoaPhong.setText("Xóa phòng");
        btnXoaPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaPhong.setIconTextGap(25);
        btnXoaPhong.setkEndColor(new java.awt.Color(51, 255, 255));
        btnXoaPhong.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnXoaPhong.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnXoaPhong.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnXoaPhong.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnXoaPhong.setkStartColor(new java.awt.Color(51, 51, 255));
        btnXoaPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaPhongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnSuaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlAddSerice.setLayout(new java.awt.BorderLayout());

        pnlService.setLayout(new java.awt.BorderLayout());

        btnAddService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons-edit.png"))); // NOI18N
        btnAddService.setText("Cập nhật trang thiết bị");
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
        pnlService.add(btnAddService, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlService, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAddSerice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAddSerice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlService, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        if (txtSearch.getText().equals("Tìm kiếm phòng")) {
            txtSearch.setText("");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText() != null) {
            txtSearch.setText("Tìm kiếm phòng");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtSearchFocusLost
    
    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        frmAddDeviceForRoom frame = new frmAddDeviceForRoom();
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddServiceActionPerformed
     public String idRoom() {
        String id = "";
        for (Room room : roomDao.getAllRooms()) {
            id = room.getMaPhong().toString();
        }
        String[] parts = id.split("P");
        if (Integer.parseInt(parts[1]) < 10) {
            int i = Integer.parseInt(parts[1]) + 1;
            id = "P00" + i;
        }
        if (Integer.parseInt(parts[1]) >= 10 && Integer.parseInt(parts[1]) < 100) {
            int i = Integer.parseInt(parts[1]) + 1;
            id = "P0" + i;
        }
        if (Integer.parseInt(parts[1]) >= 100 && Integer.parseInt(parts[1]) < 1000) {
            int i = Integer.parseInt(parts[1]) + 1;
            id = "P" + i;
        }
        return id;
    }
     public void clearText(){
        txtFloor.setText("");
        txtSearch.setText("");
        txtNumberRoom.setText("");
    }
    private void btnThemPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemPhongMouseClicked
        String gia = txtBasicPrice.getText().trim();
        String name = txtNumberRoom.getText().trim();
        String tang = txtFloor.getText().trim();
        String loaiPhong = cboStyleRoom.getSelectedItem().toString();
        String idRoom = idRoom();
        Room room1 = roomDao.findRoomByNameRoom(name);

        if (gia.equals("") || name.equals("") || tang.equals("")) {
            JOptionPane.showConfirmDialog(this, "Vui lòng nhập thông tin đầy đủ!", "Thông báo", JOptionPane.CLOSED_OPTION);
            return;
        }
        if (!regexHelper.regexNameRoom(name)) {
            JOptionPane.showConfirmDialog(this, "Vui lòng xem lại tên phòng. Ví dụ: V001 hoặc T001", "Thông báo", JOptionPane.CLOSED_OPTION);
            return;
        }
        if (!regexHelper.regexTangPhong(tang)) {
            JOptionPane.showConfirmDialog(this, "Vui lòng xem lại tầng phòng", "Thông báo", JOptionPane.CLOSED_OPTION);
            return;
        }
        for (Room room : roomDao.getAllRooms()) {
            if (name.equals(room.getTenPhong())) {
                JOptionPane.showConfirmDialog(this, "Tên phòng đã tồn tại", "Thông báo", JOptionPane.CLOSED_OPTION);
                return;
            }
        }
        RoomType rt = roomTypeDAO.findRoomTypeByName(loaiPhong);
        RoomStatusType roomStatusType = new RoomStatusType("LTTP003", "Trống");
        Staff staff = staffDAO.getEmployeeBYID(username);
        Room room = new Room(idRoom, name, Integer.parseInt(tang), rt, roomStatusType, staff);
        if (roomDao.addRoom(room)) {
            JOptionPane.showMessageDialog(this, "Thêm Phòng thành công!");
            clearText();
            loadDataToRoomList();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Phòng thất bại!");
        }
    }//GEN-LAST:event_btnThemPhongMouseClicked

    private void btnSuaPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaPhongMouseClicked
        if (id == null) {
            JOptionPane.showConfirmDialog(this, "Vui lòng chọn phòng cần sửa!", "Thông báo", JOptionPane.CLOSED_OPTION);
            return;
        }
        String tang = txtFloor.getText().trim();
        String name = txtNumberRoom.getText().trim();
        Room room = roomDao.findRoomById(id);
        Staff staff = staffDAO.getEmployeeBYID(username);
        if (name.equals("") || tang.equals("")) {
            JOptionPane.showConfirmDialog(this, "Vui lòng nhập thông tin đầy đủ!", "Thông báo", JOptionPane.CLOSED_OPTION);
            return;
        }
        try {
            int choise = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa Phòng này không?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (room != null) {
                if (choise == JOptionPane.YES_OPTION) {
                    room.setTang(Integer.parseInt(tang));
                    room.setStaff(staff);
                    room.setTenPhong(name);
                    if (roomDao.updateRoomByID(room)) {
                        JOptionPane.showMessageDialog(this, "Chỉnh sửa phòng thành công!");
                        clearText();
                        loadDataToRoomList();
                    } else {
                        JOptionPane.showMessageDialog(this, "Chỉnh sửa phòng thất bại!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaPhongMouseClicked

    private void btnXoaPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaPhongMouseClicked
        String name = txtNumberRoom.getText().trim();
        Room room = roomDao.findRoomByNameRoom(name);
        Staff staff = staffDAO.getEmployeeBYID(username);
        RoomStatusType roomStatusType = new RoomStatusType("LTTP004", "Xóa");

        if (id == null) {
            JOptionPane.showConfirmDialog(this, "Vui lòng chọn phòng cần xóa!", "Thông báo", JOptionPane.CLOSED_OPTION);
            return;
        }

        try {
            int choise = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa phòng này không?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (room != null) {
                if (choise == JOptionPane.YES_OPTION) {
                    room.setRoomStatusType(roomStatusType);
                    room.setStaff(staff);
                    if (roomDao.deleteRoom(room)) {
                        JOptionPane.showMessageDialog(this, " Xóa thành công!");
                        clearText();
                        loadDataToRoomList();
                    } else {
                        JOptionPane.showMessageDialog(this, "Phòng chưa được xóa!");
                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaPhongMouseClicked

    private void tableRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRoomMouseClicked
       int selected = tableRoom.getSelectedRow();
        if (selected >= 0) {
            id = (String) tableRoom.getValueAt(selected, 0);
            txtNumberRoom.setText((String) tableRoom.getValueAt(selected, 1));
            txtFloor.setText((String) tableRoom.getValueAt(selected, 2).toString());
            txtBasicPrice.setText((String) tableRoom.getValueAt(selected, 4).toString());
            cboStyleRoom.setSelectedItem((String) tableRoom.getValueAt(selected, 3));
        }
    }//GEN-LAST:event_tableRoomMouseClicked

    private void cboStyleRoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboStyleRoomItemStateChanged
       switch (cboStyleRoom.getSelectedItem().toString()) {
            case "VIP" -> {
                txtBasicPrice.setText("5000000");
            }
            case "THUONG" -> {
                txtBasicPrice.setText("2000000");
            }
            default -> {
                txtBasicPrice.setText("5000000");
            }
        }
    }//GEN-LAST:event_cboStyleRoomItemStateChanged

    private void cboStyleRoom2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboStyleRoom2ItemStateChanged
        switch (cboStyleRoom2.getSelectedItem().toString()) {
            case "VIP" -> {
                loadDataToRoomListByTypeService("VIP");
            }
            case "THUONG" -> {
                loadDataToRoomListByTypeService("THUONG");
            }
            default -> {
                loadDataToRoomList();
            }
        }
    }//GEN-LAST:event_cboStyleRoom2ItemStateChanged

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String textFind = txtSearch.getText().trim();
        if (textFind.equals("")) {
            loadDataToRoomList();
            return;
        }
        List<Room> rooms = roomDao.findRoomByIDFirstName(textFind);
        if (rooms == null) {
            JOptionPane.showMessageDialog(this, "Không tồn tại phòng này", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            loadDataToTableByFind(rooms);
        }
    }//GEN-LAST:event_txtSearchActionPerformed
 public void loadDataToTableByFind(List<Room> list) {
        modelListRoom.setRowCount(0);

        for (Room room : list) {

            Object[] row = new Object[]{
                room.getMaPhong(), room.getTenPhong(), room.getTang(), room.getRoomType().getTenLoaiPhong(), room.getRoomType().getDonGia()
            };
            modelListRoom.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnAddService;
    private com.k33ptoo.components.KButton btnSuaPhong;
    private com.k33ptoo.components.KButton btnThemPhong;
    private com.k33ptoo.components.KButton btnXoaPhong;
    private javax.swing.JComboBox<String> cboStyleRoom;
    private javax.swing.JComboBox<String> cboStyleRoom2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel pnlService;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTable tableRoom;
    private javax.swing.JTextField txtBasicPrice;
    private javax.swing.JTextField txtFloor;
    private javax.swing.JTextField txtNumberRoom;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void initColRoomList() {
        modelListRoom.setColumnIdentifiers(new String[]{
            "Mã Phòng", "Tên Phòng", "Tầng", "Loại Phòng", "Giá Phòng"
        });
        tableRoom.setModel(modelListRoom);
    }

    private void loadDataToCombobox() {
        for (RoomType room : roomTypeDAO.getAllRoomTypes()) {
            cboStyleRoom.addItem(room.getTenLoaiPhong());
            cboStyleRoom2.addItem(room.getTenLoaiPhong());
        }
    }
private void loadDataToRoomListByTypeService(String type) {
        modelListRoom.setRowCount(0);
        for (Room room : roomDao.getAllRooms()) {
            if (room.getRoomStatusType().getTenLoai().equals("Trống") && room.getRoomType().getTenLoaiPhong().equals(type)) {
                Object[] row = new Object[]{
                    room.getMaPhong(), room.getTenPhong(), room.getTang(), room.getRoomType().getTenLoaiPhong(), room.getRoomType().getDonGia()
                };
                modelListRoom.addRow(row);
            }
        }
        modelListRoom.fireTableDataChanged();
    }
   private void loadDataToRoomList() {
        modelListRoom.setRowCount(0);
        for (Room room : roomDao.getAllRooms()) {
            if (room.getRoomStatusType().getTenLoai().equals("Trống") && room.getRoomType().getTenLoaiPhong().equals("VIP")) {
                Object[] row = new Object[]{
                    room.getMaPhong(), room.getTenPhong(), room.getTang(), room.getRoomType().getTenLoaiPhong(), room.getRoomType().getDonGia()
                };
                modelListRoom.addRow(row);
            }
        }
        modelListRoom.fireTableDataChanged();
    }
}
