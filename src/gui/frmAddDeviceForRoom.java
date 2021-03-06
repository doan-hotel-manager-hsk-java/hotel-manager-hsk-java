/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.DeviceDAO;
import dao.RoomDAO;
import dao.RoomDeviceDAO;
import entity.Device;
import entity.Room;
import entity.Room_Device;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vomin
 */
public class frmAddDeviceForRoom extends javax.swing.JFrame {

    private DefaultComboBoxModel<String> nameRoomBoxModel;
    private DefaultComboBoxModel<String> nameDeviceBoxModel;
    private DefaultTableModel deviceForRoomTableModel;
    private final RoomDAO roomDAO;
    private final DeviceDAO deviceDAO;
    private final RoomDeviceDAO roomDeviceDAO;
    private String idRoom;

    /**
     * Creates new form frmAddDeviceForRoom
     */
    public frmAddDeviceForRoom() {
        this.setAlwaysOnTop(true);
        initComponents();

        roomDAO = new RoomDAO();
        deviceDAO = new DeviceDAO();
        roomDeviceDAO = new RoomDeviceDAO();

        nameRoomBoxModel = new DefaultComboBoxModel<>();
        nameDeviceBoxModel = new DefaultComboBoxModel<>();
        deviceForRoomTableModel = new DefaultTableModel();
        deviceForRoomTableModel.setColumnIdentifiers(new String[]{"Ten Trang Thiet Bi", "So Luong"});
        tblDeviceForRoom.setModel(deviceForRoomTableModel);

        loadNameRoomToComboBox();

        idRoom = roomDAO.findRoomByNameRoom(cboNameRoom.getSelectedItem().toString()).getMaPhong();
        loadDataToTable(idRoom);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeviceForRoom = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new com.k33ptoo.components.KButton();
        btnChange = new com.k33ptoo.components.KButton();
        btnDel = new com.k33ptoo.components.KButton();
        cboNameRoom = new javax.swing.JComboBox<>();
        cboNameDevice = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh s??ch trang thi???t b???"));

        tblDeviceForRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeviceForRoomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDeviceForRoom);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Th??ng tin chi ti???t"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("T??n trang thi???t b???");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("S??? ph??ng");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-add.png"))); // NOI18N
        btnAdd.setText("Th??m");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setIconTextGap(25);
        btnAdd.setkEndColor(new java.awt.Color(51, 255, 255));
        btnAdd.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnAdd.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnAdd.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnAdd.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnAdd.setkStartColor(new java.awt.Color(51, 51, 255));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons-edit.png"))); // NOI18N
        btnChange.setText("S???a");
        btnChange.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChange.setIconTextGap(25);
        btnChange.setkEndColor(new java.awt.Color(51, 255, 255));
        btnChange.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnChange.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnChange.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnChange.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnChange.setkStartColor(new java.awt.Color(51, 51, 255));
        btnChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChangeMouseClicked(evt);
            }
        });

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon-16.png"))); // NOI18N
        btnDel.setText("X??a");
        btnDel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDel.setIconTextGap(25);
        btnDel.setkEndColor(new java.awt.Color(51, 255, 255));
        btnDel.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnDel.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnDel.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnDel.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnDel.setkStartColor(new java.awt.Color(51, 51, 255));
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });

        cboNameRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboNameRoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNameRoomItemStateChanged(evt);
            }
        });

        cboNameDevice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("S??? l?????ng");

        txtNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboNameRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboNameDevice, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(76, 76, 76)
                        .addComponent(txtNumber))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNameRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNameDevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnDel.getAccessibleContext().setAccessibleName("");

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Th??m trang thi???t b??? v??o ph??ng");
        jPanel2.add(jLabel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cboNameRoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNameRoomItemStateChanged
        idRoom = roomDAO.findRoomByNameRoom(cboNameRoom.getSelectedItem().toString()).getMaPhong();
        loadDataToTable(idRoom);
    }//GEN-LAST:event_cboNameRoomItemStateChanged

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if (txtNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ?????y ????? th??ng tin!", "C???nh b??o", JOptionPane.WARNING_MESSAGE);
        } else {
            if (!txtNumber.getText().matches("(\\d)+")) {
                JOptionPane.showMessageDialog(this, "S??? l?????ng ph???i l?? s??? ho???c s??? l???n h??n 0!", "C???nh b??o", JOptionPane.WARNING_MESSAGE);
            } else {
                Room room = roomDAO.findRoomByNameRoom(cboNameRoom.getSelectedItem().toString());
                Device device = deviceDAO.findDeviceByName(cboNameDevice.getSelectedItem().toString());

                if (roomDeviceDAO.findDeviceByIdRoomIdDevice(device.getMaTTB(), room.getMaPhong()) != null) {
                    JOptionPane.showMessageDialog(this, "Thi???t b??? n??y ???? t???n t???i trong ph??ng vui l??ng th???c hi???n c???p nh???t ho???c ch???n thi???t b??? kh??c!", "C???nh b??o", JOptionPane.WARNING_MESSAGE);
                } else {
                    int soLuong = Integer.parseInt(txtNumber.getText());
                    if (soLuong > device.getSoLuongTon()) {
                        JOptionPane.showMessageDialog(this, "S??? l?????ng nh???p v??o l???n l??n s??? l?????ng trong kho. Vui l??ng nh???p l???i!", "C???nh b??o", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {
                        int soLuongConLai = device.getSoLuongTon() - soLuong;
                        device.setSoLuongTon(soLuongConLai);

                        Room_Device roomDevice = new Room_Device(soLuong, device, room);
                        roomDeviceDAO.insertDeviceToRoom(roomDevice);
                        deviceDAO.updateDeviceById(device);
                        loadDataToTable(room.getMaPhong());
                        clearInput();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeMouseClicked
        if (txtNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ?????y ????? th??ng tin!", "Th??ng b??o", JOptionPane.WARNING_MESSAGE);
        } else {
            if (!txtNumber.getText().matches("(\\d)+")) {
                JOptionPane.showMessageDialog(this, "S??? l?????ng ph???i l?? s??? ho???c s??? l???n h??n 0!", "Th??ng b??o", JOptionPane.WARNING_MESSAGE);
            } else {
                Room room = roomDAO.findRoomByNameRoom(cboNameRoom.getSelectedItem().toString());
                Device device = deviceDAO.findDeviceByName(cboNameDevice.getSelectedItem().toString());

                Room_Device deviceTemp = roomDeviceDAO.findDeviceByIdRoomIdDevice(device.getMaTTB(), room.getMaPhong());
                int soLuong = Integer.parseInt(txtNumber.getText());
                if (soLuong > device.getSoLuongTon()) {
                    JOptionPane.showMessageDialog(this, "S??? l?????ng nh???p v??o l???n l??n s??? l?????ng trong kho. Vui l??ng nh???p l???i!", "C???nh b??o", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    int soLuongConLai = 0;

                    if (soLuong > deviceTemp.getSoLuong()) {
                        soLuongConLai = device.getSoLuongTon() - (soLuong - deviceTemp.getSoLuong());
                    } else if (soLuong < deviceTemp.getSoLuong()) {
                        soLuongConLai = device.getSoLuongTon() + (deviceTemp.getSoLuong() - soLuong);
                    } else {
                        soLuongConLai = deviceTemp.getSoLuong();
                    }

                    device.setSoLuongTon(soLuongConLai);

                    Room_Device roomDevice = new Room_Device(soLuong, device, room);
                    roomDeviceDAO.updateDeviceToRoom(roomDevice);
                    deviceDAO.updateDeviceById(device);
                    loadDataToTable(room.getMaPhong());
                    clearInput();
                }

            }
        }
    }//GEN-LAST:event_btnChangeMouseClicked

    private void tblDeviceForRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeviceForRoomMouseClicked
        btnAdd.setEnabled(false);
        int i = tblDeviceForRoom.getSelectedRow();
        cboNameDevice.setSelectedItem(tblDeviceForRoom.getValueAt(i, 0));
        txtNumber.setText((String) tblDeviceForRoom.getValueAt(i, 1));
        cboNameDevice.setEnabled(false);
        cboNameRoom.setEnabled(false);
    }//GEN-LAST:event_tblDeviceForRoomMouseClicked

    private void btnDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n x??a thi???t b??? n??y ra kh???i ph??ng?", "H???ii", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choose == JOptionPane.YES_OPTION) {
            Room room = roomDAO.findRoomByNameRoom(cboNameRoom.getSelectedItem().toString());
            Device device = deviceDAO.findDeviceByName(cboNameDevice.getSelectedItem().toString());

            Room_Device deviceTemp = roomDeviceDAO.findDeviceByIdRoomIdDevice(device.getMaTTB(), room.getMaPhong());
            int soLuongConLai = device.getSoLuongTon() + deviceTemp.getSoLuong();
            device.setSoLuongTon(soLuongConLai);

            roomDeviceDAO.deleteDeviceToRoom(deviceTemp);
            deviceDAO.updateDeviceById(device);
            loadDataToTable(room.getMaPhong());
        }
    }//GEN-LAST:event_btnDelMouseClicked

    private void clearInput() {
        cboNameDevice.setSelectedIndex(0);
        txtNumber.setText("");
    }

    private void loadNameRoomToComboBox() {
        List<Room> rooms = new ArrayList();       
        for(Room r :roomDAO.getAllRooms())
        {
            if(r.getRoomStatusType().getMaLoaiTTP().equals("LTTP003"))
            {
                rooms.add(r);
            }
        }
        loadDataRoomToModel(rooms, nameRoomBoxModel);
        List<Device> devices = deviceDAO.getAllDevices();
        loadDataDeviceToModel(devices, nameDeviceBoxModel);
    }

    private void loadDataRoomToModel(List<Room> list, DefaultComboBoxModel model) {
        for (Room item : list) {
            model.addElement(item.getTenPhong());
        }

        cboNameRoom.setModel(model);
    }

    private void loadDataDeviceToModel(List<Device> list, DefaultComboBoxModel model) {
        for (Device item : list) {
            model.addElement(item.getTenTTB());
        }

        cboNameDevice.setModel(model);
    }

    private void loadDataToTable(String idRoom) {
        List<Room_Device> devices = roomDeviceDAO.getAllRoomDevicesById(idRoom);
        loadDataDeviceForRoomToModel(devices, deviceForRoomTableModel);

        cboNameDevice.setEnabled(true);
        cboNameRoom.setEnabled(true);
        btnAdd.setEnabled(true);
    }

    private void loadDataDeviceForRoomToModel(List<Room_Device> list, DefaultTableModel model) {
        model.setRowCount(0);
        for (Room_Device item : list) {
            model.addRow(new String[]{item.getDevice().getTenTTB(), String.valueOf(item.getSoLuong())});
        }
    }

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
            java.util.logging.Logger.getLogger(frmAddDeviceForRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAddDeviceForRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAddDeviceForRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAddDeviceForRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAddDeviceForRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnAdd;
    private com.k33ptoo.components.KButton btnChange;
    private com.k33ptoo.components.KButton btnDel;
    private javax.swing.JComboBox<String> cboNameDevice;
    private javax.swing.JComboBox<String> cboNameRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDeviceForRoom;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
