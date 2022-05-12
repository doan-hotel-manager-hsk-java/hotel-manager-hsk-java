package gui;

import dao.BookRoomDAO;
import dao.DeviceDAO;
import dao.OrderDAO;
import dao.RoomDAO;
import dao.RoomDeviceDAO;
import dao.RoomStatusTypeDAO;
import dao.ServiceTypeDAO;
import entity.BookRoom;
import entity.Device;
import entity.Order;
import entity.Room;
import entity.RoomStatusType;
import entity.ServiceType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vomin
 */
public class frmChangeRoom extends javax.swing.JFrame {

    private DefaultComboBoxModel<String> nameRoomBoxModel;
    private RoomDAO roomDAO;
    private BookRoomDAO bookRoomDAO;
    OrderDAO orderDAO;
    RoomStatusTypeDAO roomStatusTypeDAO;
    Room room;
    BookRoom bookRoom;
    String username;

    public frmChangeRoom(Room _room, BookRoom _bookRoom, String _username) {
        room = _room;
        bookRoom = _bookRoom;
        username = _username;
        this.setAlwaysOnTop(true);
        initComponents();

        roomDAO = new RoomDAO();
        roomStatusTypeDAO = new RoomStatusTypeDAO();
        bookRoomDAO = new BookRoomDAO();
        orderDAO = new OrderDAO();
        nameRoomBoxModel = new DefaultComboBoxModel<>();
        loadNameRoomToComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnChange = new com.k33ptoo.components.KButton();
        bntExit = new com.k33ptoo.components.KButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboListRoom = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtRoomCurrent = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Chọn phòng đổi: ");

        btnChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exchange.png"))); // NOI18N
        btnChange.setText("Đổi");
        btnChange.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
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
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        bntExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon-16.png"))); // NOI18N
        bntExit.setText("Thoát");
        bntExit.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        bntExit.setkEndColor(new java.awt.Color(51, 255, 255));
        bntExit.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        bntExit.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        bntExit.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        bntExit.setkPressedColor(new java.awt.Color(0, 153, 153));
        bntExit.setkStartColor(new java.awt.Color(51, 51, 255));
        bntExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntExitActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Đổi phòng");
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        cboListRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboListRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Phòng hiện tại:");

        txtRoomCurrent.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRoomCurrent))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboListRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(bntExit, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRoomCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cboListRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntExit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bntExitActionPerformed

    private void btnChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeMouseClicked

    }//GEN-LAST:event_btnChangeMouseClicked

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        Room roomCurrent = roomDAO.findRoomByNameRoom(cboListRoom.getSelectedItem().toString());
        RoomStatusType roomStatusTypeCurrent = roomStatusTypeDAO.finRoomStatusTypeById(room.getRoomStatusType().getMaLoaiTTP());
        roomCurrent.setRoomStatusType(roomStatusTypeCurrent);
        roomDAO.updateRoom(roomCurrent);

        bookRoom.setRoom(roomCurrent);

        Order order = orderDAO.findRoomByIDRoom(room.getMaPhong());
        if (order != null) {
            order.setRoom(roomCurrent);
            orderDAO.updateRoomByID(order);
        }

        RoomStatusType roomStatusType = roomStatusTypeDAO.finRoomStatusTypeById("LTTP003");
        room.setRoomStatusType(roomStatusType);

        if (bookRoomDAO.updateBookRoom(bookRoom) && roomDAO.updateRoom(room)) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    private void loadNameRoomToComboBox() {
        txtRoomCurrent.setText(room.getTenPhong());
        List<Room> rooms = new ArrayList();
        for (Room r : roomDAO.getAllRooms()) {
            if (r.getRoomStatusType().getMaLoaiTTP().equals("LTTP003")) {
                rooms.add(r);
            }
        }
        loadDataRoomToModel(rooms, nameRoomBoxModel);
    }

    private void loadDataRoomToModel(List<Room> list, DefaultComboBoxModel model) {
        for (Room item : list) {
            model.addElement(item.getTenPhong());
        }

        cboListRoom.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton bntExit;
    private com.k33ptoo.components.KButton btnChange;
    private javax.swing.JComboBox<String> cboListRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtRoomCurrent;
    // End of variables declaration//GEN-END:variables
}
