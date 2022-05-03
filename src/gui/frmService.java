/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import dao.OrderDetail_Room_DAO;
import dao.RoomDAO;
import dao.ServiceDAO;
import entity.OrderDetail_Room;
import entity.Room;
import entity.Service;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huy
 */
public class frmService extends javax.swing.JInternalFrame {

    // INIT
    private DefaultTableModel modellListServices, modelListServicesAdded;
    
    private RoomDAO roomDAO;
    private ServiceDAO serviceDAO;
    private OrderDetail_Room_DAO orderDetailRoomDAO;
    
    /**
     * Creates new form QuanLyPhong
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public frmService() throws ClassNotFoundException, SQLException {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        initComponents();
        
        // TABLE MODEL
        modellListServices = new DefaultTableModel();
        modelListServicesAdded = new DefaultTableModel();
        
        // DAO
        roomDAO = new RoomDAO();
        serviceDAO = new ServiceDAO();
        orderDetailRoomDAO = new OrderDetail_Room_DAO();
        
        // CALLING
        loadDataToCombobox();
        initColsListServices();
        loadDataToTblListServices();
        initColsListServicesAdded();
        loadDataToTblListServicesAdded();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlTitle = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboTenPhong = new javax.swing.JComboBox<>();
        btnThem = new com.k33ptoo.components.KButton();
        btnDatPhong = new com.k33ptoo.components.KButton();
        btnXoa = new com.k33ptoo.components.KButton();
        btnTaoHoaDon = new com.k33ptoo.components.KButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListServicesAdded = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListServices = new javax.swing.JTable();

        setBorder(null);
        setFrameIcon(null);

        pnlTitle.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Dịch vụ");
        pnlTitle.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin dịch vụ"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Dịch Vụ :");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Số lượng:");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Chọn Phòng: ");

        cboTenPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboTenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTenPhongActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setkEndColor(new java.awt.Color(51, 255, 255));
        btnThem.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnThem.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnThem.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnThem.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnThem.setkStartColor(new java.awt.Color(51, 51, 255));

        btnDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons-edit.png"))); // NOI18N
        btnDatPhong.setText("Sửa");
        btnDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatPhong.setkEndColor(new java.awt.Color(51, 255, 255));
        btnDatPhong.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnDatPhong.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnDatPhong.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnDatPhong.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnDatPhong.setkStartColor(new java.awt.Color(51, 51, 255));

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon-16.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setkEndColor(new java.awt.Color(51, 255, 255));
        btnXoa.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnXoa.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnXoa.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnXoa.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnXoa.setkStartColor(new java.awt.Color(51, 51, 255));

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.setToolTipText("");
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoHoaDon.setkEndColor(new java.awt.Color(51, 255, 255));
        btnTaoHoaDon.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnTaoHoaDon.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnTaoHoaDon.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnTaoHoaDon.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnTaoHoaDon.setkStartColor(new java.awt.Color(51, 51, 255));
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTenPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(cboTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách dịch vụ đã thêm"));

        tblListServicesAdded.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Số phòng", "Tên dịch vụ", "Số lượng", "Tổng tiền"
            }
        ));
        jScrollPane2.setViewportView(tblListServicesAdded);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách dịch vụ"));

        tblListServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên dịch vụ", "Đơn giá", "Trạng thái"
            }
        ));
        jScrollPane3.setViewportView(tblListServices);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    // LOAD DATA TO COMBOBOX
    private void loadDataToCombobox() {
        for (Room room : roomDAO.getAllRooms()) {
            cboTenPhong.addItem(room.getTenPhong());
        }
    }
    
    // CREATE TITLE COLUMNS OF LIST SERVICE
    private void initColsListServices() {
        modellListServices.setColumnIdentifiers(new String[] {
            "Tên dich vu", "Ðon giá", "Trang thái"
        });
        tblListServices.setModel(modellListServices);
    }
    
    // LOAD DATA TO TABLE LIST SERVICE
    private void loadDataToTblListServices() throws ClassNotFoundException, SQLException {
        modellListServices.setRowCount(0);
        
        for (Service service : serviceDAO.getServices()) {
            Object[] row = new Object[] {
              service.getTenDV(), service.getDonGia(), service.getTrangThai()  
            };
            modellListServices.addRow(row);
        }
        modellListServices.fireTableDataChanged();
    }
    
    // CREATE TITLE COLUMNS OF LIST SERVICE ADDED
    private void initColsListServicesAdded() {
        modelListServicesAdded.setColumnIdentifiers(new String[] {
            "So phòng", "Tên dich vu", "So luong", "Tong Tien"
        });
        tblListServicesAdded.setModel(modelListServicesAdded);
    }
    
    // LOAD DATA TO TABLE LIST SERVICE ADDED
    private void loadDataToTblListServicesAdded() throws ClassNotFoundException, SQLException {
        modelListServicesAdded.setRowCount(0);
        
        for (OrderDetail_Room or : orderDetailRoomDAO.getListServicesAdded()) {
            Object[] row = new Object[] {
              or.getTenPhong(), or.getService().getTenDV(), or.getSoLuong(), or.getTongTien()
            };
            modelListServicesAdded.addRow(row);
        }
        modelListServicesAdded.fireTableDataChanged();
    }
    
    private void cboTenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTenPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTenPhongActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        frmBill frm = new frmBill();
        frm.setVisible(true);
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnDatPhong;
    private com.k33ptoo.components.KButton btnTaoHoaDon;
    private com.k33ptoo.components.KButton btnThem;
    private com.k33ptoo.components.KButton btnXoa;
    private javax.swing.JComboBox<String> cboTenPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTable tblListServices;
    private javax.swing.JTable tblListServicesAdded;
    // End of variables declaration//GEN-END:variables
}
