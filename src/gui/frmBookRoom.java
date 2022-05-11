package gui;

import dao.*;
import entity.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class frmBookRoom extends javax.swing.JInternalFrame {

    DefaultTableModel tblModel;
    JDatePickerImpl datePickerNhan;
    JDatePickerImpl datePickerDat;
    JPanel pnlRoom;
    JButton lblRoom;
    private String usename;
    String nameRoom;

    //dao
    OrderDAO orderDAO = new OrderDAO();
    RoomDAO roomDAO = new RoomDAO();
    StaffDAO staffDAO = new StaffDAO();
    BookRoomDAO bookRoomDAO = new BookRoomDAO();
    RoomStatusTypeDAO roomStatusTypeDAO = new RoomStatusTypeDAO();
    CustomerDAO customerDAO = new CustomerDAO();
    //List
    List<Room> listRoomVip;
    List<Room> listRoomNormals;
    List<BookRoom> listBookRooms;

    public frmBookRoom(String _username) {
        usename = _username;
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        initComponents();
        initTable();
        createRoom();
        loadAllDSDatPhong();
        // create ngayNhan
        UtilDateModel modelNgayNhan = new UtilDateModel();
        Properties pNhan = new Properties();
        pNhan.put("text.today", "Today");
        pNhan.put("text.month", "Month");
        pNhan.put("text.year", "Year");
        JDatePanelImpl dateNhan = new JDatePanelImpl(modelNgayNhan, pNhan);
        datePickerNhan = new JDatePickerImpl(dateNhan, new DateLabelFormatter());

        pnlNhan.add(datePickerNhan);

        // create ngayNhan
        UtilDateModel modelNgayDat = new UtilDateModel();
        Properties pDat = new Properties();
        pDat.put("text.today", "Today");
        pDat.put("text.month", "Month");
        pDat.put("text.year", "Year");
        JDatePanelImpl dateDat = new JDatePanelImpl(modelNgayDat, pDat);
        datePickerDat = new JDatePickerImpl(dateDat, new DateLabelFormatter());

        pnlDat.add(datePickerDat);
    }

    // METHOD
    //Create colum table
    private void initTable() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Số phòng", "Tên khách hàng", "CMND", "Số điện thoại", "Giới tính",
            "Địa chỉ", "Ngày đặt", "Giờ đặt", "Ngày nhận", "Giờ nhận", "Trạng thái"});
        tblDsDatPhong.setModel(tblModel);
    }

    // Load danh sách đặt phòng
    private void loadAllDSDatPhong() {
        tblModel.setRowCount(0);
        listBookRooms = bookRoomDAO.getAlLBookRooms();
        for (BookRoom bookRoom : listBookRooms) {
            String[] row = new String[]{
                bookRoom.getRoom().getTenPhong(),
                bookRoom.getCustomer().getTenKH(),
                bookRoom.getCustomer().getMaKH(),
                bookRoom.getCustomer().getSoDT(),
                bookRoom.getCustomer().isGioiTinh() == true ? "Nam" : "Nữ",
                bookRoom.getCustomer().getDiaChi(),
                bookRoom.getNgayDat(),
                bookRoom.getGioDat(),
                bookRoom.getNgayNhan(),
                bookRoom.getGioNhan(),
                bookRoom.getRoom().getRoomStatusType().getTenLoai()
            };
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }

    // Create list rooms
    private void createRoom() {
        listRoomVip = roomDAO.findRoomByIDLoaiPhong("LP001");
        listRoomNormals = roomDAO.findRoomByIDLoaiPhong("LP002");

        JLabel lblListNormal;
        // Titile Normal
        lblListNormal = new JLabel("Danh sách phòng thường");
        lblListNormal.setBounds(20, 20, 300, 30);
        lblListNormal.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Danh sách phòng
        JPanel pnlListRoom = new JPanel();
        pnlListRoom.removeAll();
        pnlListRoom.setBackground(Color.white);
        pnlListRoom.setLayout(null);
        pnlListRoom.setPreferredSize(new Dimension(600, 830));
        pnlListRoom.add(lblListNormal);

        JLabel lblListVip;

        int x = 20;
        int y = 60;
        int width = 100;
        int height = 100;
        int countHeight = 0;
        int numberRoomNormal = 1;
        int countNumberRoomNormalRemove = 0;
        int numberRoomVip = 1;
        String trangThaiPhong;
        for (Room room : listRoomNormals) {
            trangThaiPhong = room.getRoomStatusType().getMaLoaiTTP().toUpperCase();
            if (trangThaiPhong.equals("LTTP004")) {
                countNumberRoomNormalRemove++;
            }
        }
        for (Room room : listRoomNormals) {
            trangThaiPhong = room.getRoomStatusType().getMaLoaiTTP().toUpperCase();
            if (!trangThaiPhong.equals("LTTP004")) {
                //Room
                pnlRoom = new JPanel();
                pnlRoom.setBackground(Color.white);
                pnlRoom.setLayout(new BorderLayout());
                pnlRoom.setBounds(x, y, width, height);

                if (trangThaiPhong.equals("LTTP001")) {
                    createStatusRoom(trangThaiPhong, new Color(241, 98, 86), pnlRoom);
                    createNameRoom(room.getMaPhong(), pnlRoom, new Color(241, 91, 56));
                } else if (trangThaiPhong.equals("LTTP002")) {
                    createStatusRoom(trangThaiPhong, new Color(51, 176, 224), pnlRoom);
                    createNameRoom(room.getMaPhong(), pnlRoom, new Color(113, 108, 176));
                } else {
                    createStatusRoom(trangThaiPhong, new Color(5, 154, 3), pnlRoom);
                    createNameRoom(room.getMaPhong(), pnlRoom, Color.WHITE);
                    lblRoom.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            nameRoom = room.getTenPhong();
                            System.out.println(nameRoom);
                        }
                    });
                }
                pnlListRoom.add(pnlRoom, BorderLayout.CENTER);
                x += width + 20;

                if (numberRoomNormal % 5 == 0 || numberRoomNormal == listRoomNormals.size() - countNumberRoomNormalRemove) {
                    y += width + 20;
                    x = 20;
                    countHeight = y + 40;
                }
                if (numberRoomNormal == listRoomNormals.size() - countNumberRoomNormalRemove) {
                    lblListVip = new JLabel("Danh sách phòng Vip");
                    lblListVip.setBounds(20, y, 300, 30);
                    lblListVip.setFont(new Font("Segoe UI", Font.BOLD, 14));
                    pnlListRoom.add(lblListVip);
                }
                numberRoomNormal++;
            }
        }

        for (Room room : listRoomVip) {
            trangThaiPhong = room.getRoomStatusType().getMaLoaiTTP().toUpperCase();
            if (!trangThaiPhong.equals("LTTP004")) {
                //Room
                pnlRoom = new JPanel();
                pnlRoom.setBackground(Color.white);
                pnlRoom.setLayout(new BorderLayout());
                pnlRoom.setBounds(x, countHeight, width, height);

                if (trangThaiPhong.equals("LTTP001")) {
                    createStatusRoom(trangThaiPhong, new Color(241, 98, 86), pnlRoom);
                    createNameRoom(room.getMaPhong(), pnlRoom, new Color(241, 91, 56));
                } else if (trangThaiPhong.equals("LTTP002")) {
                    createStatusRoom(trangThaiPhong, new Color(51, 176, 224), pnlRoom);
                    createNameRoom(room.getMaPhong(), pnlRoom, new Color(113, 108, 176));
                } else {
                    createStatusRoom(trangThaiPhong, new Color(5, 154, 3), pnlRoom);
                    createNameRoom(room.getMaPhong(), pnlRoom, Color.WHITE);

                }
                pnlListRoom.add(pnlRoom);
                x += width + 20;

                if (numberRoomVip % 5 == 0) {
                    countHeight += width + 20;
                    x = 20;
                }
                numberRoomVip++;
            }
        }

        scrollPanel.setViewportView(pnlListRoom);
    }

// trạng thái phòng
    private void createStatusRoom(String idTrangThai, Color color, JPanel pnlRom) {
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                roomStatusTypeDAO.finRoomStatusTypeById(idTrangThai).getTenLoai().toUpperCase());
        titledBorder.setTitleColor(color);
        titledBorder.setTitleFont(new Font("Segoe UI", Font.PLAIN, 10));
        pnlRom.setBorder(titledBorder);
    }
// tên phòng

    private void createNameRoom(String idPhong, JPanel pnlRom, Color colorBackground) {
        lblRoom = new JButton();
        lblRoom.setText(roomDAO.findRoomById(idPhong).getTenPhong());
        lblRoom.setOpaque(true);
        lblRoom.setBackground(colorBackground);
        lblRoom.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblRoom.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        pnlRom.add(lblRoom, BorderLayout.CENTER);
    }

// create ID book room
    public String idBookRoom() {
        int id = 1;
        for (BookRoom bookRoom : bookRoomDAO.getAlLBookRooms()) {
            if (bookRoom.getMaDDP().equals(id)) {
                id++;
            } else {
                return String.valueOf(id);
            }
        }
        return String.valueOf(id);
    }

    // create ID order
    public String idOrder() {
        int id = 1;
        for (Order order : orderDAO.getAllOrders()) {
            if (order.getMaHD().equals(id)) {
                id++;
            } else {
                return String.valueOf(id);
            }
        }
        return String.valueOf(id);
    }
    // create customer
    private Customer createCustomer() {
        Customer customer = new Customer(txtCMND.getText(), txtTenKH.getText(), txtSDT.getText(),
                cboGioiTinh.getSelectedIndex() == 1 ? true : false, txtDiaChi.getText());
        return customer;
    }

    // Check Data File
    private boolean checkDataFile() {
        String messege = "";
        if (txtCMND.getText().isEmpty() || txtDiaChi.getText().isEmpty()
                || txtSDT.getText().isEmpty() || txtGioDat.getText().isEmpty() || txtGioNhan.getText().isEmpty()
                || datePickerNhan.getJFormattedTextField().getText().isEmpty()
                || datePickerDat.getJFormattedTextField().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn vui lòng nhập đầy đủ thông tin");
            return false;
        } else if (nameRoom == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng");
            return false;
//        } else {
//            String regexCMND = "^[0-9]{9}|[0-9]{12}";
//            Pattern patternCMND = Pattern.compile(regexCMND);
//            Matcher matcherCMND = patternCMND.matcher(txtCMND.getText());
//            Boolean checkCMND = matcherCMND.matches();
//
//            if (!checkCMND) {
//                messege += "CMND phải là số và bao gồm 9 hoặc 12 số";
//            }
//            if (!messege.isEmpty()) {
//                JOptionPane.showMessageDialog(null, messege);
//                return false;
//            } else {
//                
//            }
        } else if (roomDAO.findRoomByNameRoom(nameRoom).getRoomStatusType().getMaLoaiTTP().equals("LTTP001")) {
            JOptionPane.showMessageDialog(null, "Phòng này đã có người đặt");
            return false;
        }else if (roomDAO.findRoomByNameRoom(nameRoom).getRoomStatusType().getMaLoaiTTP().equals("LTTP002")) {
            JOptionPane.showMessageDialog(null, "Phòng này đang có người sử dụng");
            return false;
        } else if (customerDAO.findCustomerById(txtCMND.getText()) != null) {
            JOptionPane.showMessageDialog(null, "Khách hàng này đã đặt phòng");
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGioNhan = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        pnlNhan = new javax.swing.JPanel();
        pnlDat = new javax.swing.JPanel();
        txtGioDat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDsDatPhong = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        btnMoPhong = new com.k33ptoo.components.KButton();
        btnDoiPhong = new com.k33ptoo.components.KButton();
        btnDatPhong = new com.k33ptoo.components.KButton();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        pnlTitle = new javax.swing.JPanel();
        lblTitile = new javax.swing.JLabel();
        scrollPanel = new javax.swing.JScrollPane();

        setBorder(null);
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(1500, 553));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin đặt phòng"));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên khách hàng: ");

        txtSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Số CMND: ");

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Số điện thoại:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ngày nhận phòng:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ngày đặt phòng:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Giờ đặt:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Địa chỉ: ");

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Giờ nhận phòng: ");

        txtGioNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtCMND.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        pnlNhan.setLayout(new java.awt.BorderLayout());

        pnlDat.setLayout(new java.awt.BorderLayout());

        txtGioDat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Giới tính: ");

        cboGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCMND)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlDat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cboGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGioDat)
                            .addComponent(txtGioNhan))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(pnlDat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtGioDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGioNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách đặt phòng"));

        tblDsDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CMND", "Tên khách hàng", "Số điện thoại", "Ngày đặt", "Ngày nhận", "Số phòng", "Trạng thái"
            }
        ));
        tblDsDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDsDatPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDsDatPhong);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        btnMoPhong.setBackground(new java.awt.Color(255, 255, 255));
        btnMoPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/opened-door-aperture.png"))); // NOI18N
        btnMoPhong.setText("Mở Phòng");
        btnMoPhong.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnMoPhong.setkEndColor(new java.awt.Color(51, 255, 255));
        btnMoPhong.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnMoPhong.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnMoPhong.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnMoPhong.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnMoPhong.setkStartColor(new java.awt.Color(51, 51, 255));
        btnMoPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoPhongActionPerformed(evt);
            }
        });

        btnDoiPhong.setBackground(new java.awt.Color(255, 255, 255));
        btnDoiPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exchange.png"))); // NOI18N
        btnDoiPhong.setText("Đổi phòng");
        btnDoiPhong.setActionCommand("");
        btnDoiPhong.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnDoiPhong.setkEndColor(new java.awt.Color(51, 255, 255));
        btnDoiPhong.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnDoiPhong.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnDoiPhong.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnDoiPhong.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnDoiPhong.setkStartColor(new java.awt.Color(51, 51, 255));

        btnDatPhong.setBackground(new java.awt.Color(255, 255, 255));
        btnDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smartphone.png"))); // NOI18N
        btnDatPhong.setText("Đặt Phòng");
        btnDatPhong.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnDatPhong.setkEndColor(new java.awt.Color(51, 255, 255));
        btnDatPhong.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnDatPhong.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnDatPhong.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnDatPhong.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnDatPhong.setkStartColor(new java.awt.Color(51, 51, 255));
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDoiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setLayout(new java.awt.BorderLayout());

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(204, 204, 204));
        txtSearch.setText("Tìm khách hàng");
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

        pnlTitle.setLayout(new java.awt.BorderLayout());

        lblTitile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitile.setText("Phòng");
        pnlTitle.add(lblTitile, java.awt.BorderLayout.CENTER);

        scrollPanel.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//Event
    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
        if (checkDataFile()) {
            Room room = roomDAO.findRoomByNameRoom(nameRoom);
            RoomStatusType roomStatusType = roomStatusTypeDAO.finRoomStatusTypeById("LTTP001");
            room.setRoomStatusType(roomStatusType);
            if (customerDAO.insertCustomer(createCustomer()) && roomDAO.updateBookRoom(room)) {
                Staff staff = staffDAO.getEmployeeBYID(usename);
                BookRoom bookRoom = new BookRoom(idBookRoom(), datePickerDat.getJFormattedTextField().getText(),
                        txtGioDat.getText(), datePickerNhan.getJFormattedTextField().getText(), txtGioNhan.getText(),
                        room, createCustomer(), staff);
                if (bookRoomDAO.insertBookRoom(bookRoom)) {
                    JOptionPane.showMessageDialog(null, "Đặt phòng thành công");
                    loadAllDSDatPhong();
                    createRoom();
                }
            }
        }
    }//GEN-LAST:event_btnDatPhongActionPerformed
// forcus search
    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Tìm khách hàng")) {
            txtSearch.setText("");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchFocusGained
// no focus search
    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText() != null) {
            txtSearch.setText("Tìm khách hàng");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void tblDsDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDsDatPhongMouseClicked
        int row = tblDsDatPhong.getSelectedRow();
        if (row >= 0) {
            txtCMND.setText(tblDsDatPhong.getValueAt(row, 2).toString());
            txtTenKH.setText(tblDsDatPhong.getValueAt(row, 1).toString());
            txtSDT.setText(tblDsDatPhong.getValueAt(row, 3).toString());
            txtDiaChi.setText(tblDsDatPhong.getValueAt(row, 5).toString());
            cboGioiTinh.setSelectedIndex(tblDsDatPhong.getValueAt(row, 4).toString() == "Nam" ? 0 : 1);
            datePickerDat.getJFormattedTextField().setText(tblDsDatPhong.getValueAt(row, 6).toString());
            txtGioDat.setText(tblDsDatPhong.getValueAt(row, 7).toString());
            datePickerNhan.getJFormattedTextField().setText(tblDsDatPhong.getValueAt(row, 8).toString());
            txtGioNhan.setText(tblDsDatPhong.getValueAt(row, 9).toString());
        }
    }//GEN-LAST:event_tblDsDatPhongMouseClicked

    private void btnMoPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoPhongActionPerformed
        int row = tblDsDatPhong.getSelectedRow();
        if(row > 0){
            BookRoom bookRoom = bookRoomDAO.findBookRoomByIDRoom(tblDsDatPhong.getValueAt(row, 0).toString());
            Customer customer = customerDAO.findCustomerById(bookRoom.getCustomer().getMaKH());
            Room room = roomDAO.findRoomByNameRoom(tblDsDatPhong.getValueAt(row, 0).toString());
            RoomStatusType roomStatusType = roomStatusTypeDAO.finRoomStatusTypeById(room.getRoomStatusType().getMaLoaiTTP());
            if(roomStatusType.getTenLoai().endsWith("Đã đặt")){
                roomStatusType.setMaLoaiTTP("LTTP002");
                room.setRoomStatusType(roomStatusType);
            }
        }
    }//GEN-LAST:event_btnMoPhongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnDatPhong;
    private com.k33ptoo.components.KButton btnDoiPhong;
    private com.k33ptoo.components.KButton btnMoPhong;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitile;
    private javax.swing.JPanel pnlDat;
    private javax.swing.JPanel pnlNhan;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTable tblDsDatPhong;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGioDat;
    private javax.swing.JTextField txtGioNhan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
