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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Properties;
import java.util.Random;
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
    OrderDAO orderDAO;
    RoomDAO roomDAO;
    StaffDAO staffDAO;
    BookRoomDAO bookRoomDAO;
    RoomStatusTypeDAO roomStatusTypeDAO;
    CustomerDAO customerDAO;

    //List
    List<Room> listRoomVip;
    List<Room> listRoomNormals;
    List<BookRoom> listBookRooms;

    public frmBookRoom(String _username) {
        usename = _username;
        orderDAO = new OrderDAO();
        roomDAO = new RoomDAO();
        staffDAO = new StaffDAO();
        bookRoomDAO = new BookRoomDAO();
        roomStatusTypeDAO = new RoomStatusTypeDAO();
        customerDAO = new CustomerDAO();

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
        tblModel.setColumnIdentifiers(new String[]{"S??? ph??ng", "T??n kh??ch h??ng", "CMND", "S??? ??i???n tho???i", "Gi???i t??nh",
            "?????a ch???", "Ng??y ?????t", "Gi??? ?????t", "Ng??y nh???n", "Gi??? nh???n", "Tr???ng th??i"});
        tblDsDatPhong.setModel(tblModel);
    }

    // Load danh s??ch ?????t ph??ng
    public void loadAllDSDatPhong() {
        tblModel.setRowCount(0);
        listBookRooms = bookRoomDAO.getAlLBookRooms();
        for (BookRoom bookRoom : listBookRooms) {
            String[] row = new String[]{
                bookRoom.getRoom().getTenPhong(),
                bookRoom.getCustomer().getTenKH(),
                bookRoom.getCustomer().getMaKH(),
                bookRoom.getCustomer().getSoDT(),
                bookRoom.getCustomer().isGioiTinh() == true ? "Nam" : "N???",
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
        lblListNormal = new JLabel("Danh s??ch ph??ng th?????ng");
        lblListNormal.setBounds(20, 20, 300, 30);
        lblListNormal.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Danh s??ch ph??ng
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
                    createNameRoom(room.getMaPhong(), pnlRoom, new Color(241, 91, 56), room);
                } else if (trangThaiPhong.equals("LTTP002")) {
                    createStatusRoom(trangThaiPhong, new Color(51, 176, 224), pnlRoom);
                    createNameRoom(room.getMaPhong(), pnlRoom, new Color(113, 108, 176), room);
                } else {
                    createStatusRoom(trangThaiPhong, new Color(5, 154, 3), pnlRoom);
                    createNameRoom(room.getMaPhong(), pnlRoom, Color.WHITE, room);
                }

                pnlListRoom.add(pnlRoom, BorderLayout.CENTER);
                x += width + 20;

                if (numberRoomNormal % 5 == 0 || numberRoomNormal == listRoomNormals.size() - countNumberRoomNormalRemove) {
                    y += width + 20;
                    x = 20;
                    countHeight = y + 40;
                }
                if (numberRoomNormal == listRoomNormals.size() - countNumberRoomNormalRemove) {
                    lblListVip = new JLabel("Danh s??ch ph??ng Vip");
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
                    createNameRoom(room.getMaPhong(), pnlRoom, new Color(241, 91, 56), room);
                } else if (trangThaiPhong.equals("LTTP002")) {
                    createStatusRoom(trangThaiPhong, new Color(51, 176, 224), pnlRoom);
                    createNameRoom(room.getMaPhong(), pnlRoom, new Color(113, 108, 176), room);
                } else {
                    createStatusRoom(trangThaiPhong, new Color(5, 154, 3), pnlRoom);
                    createNameRoom(room.getMaPhong(), pnlRoom, Color.WHITE, room);

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

// tr???ng th??i ph??ng
    private void createStatusRoom(String idTrangThai, Color color, JPanel pnlRom) {
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                roomStatusTypeDAO.finRoomStatusTypeById(idTrangThai).getTenLoai().toUpperCase());
        titledBorder.setTitleColor(color);
        titledBorder.setTitleFont(new Font("Segoe UI", Font.PLAIN, 10));
        pnlRom.setBorder(titledBorder);
    }
// t??n ph??ng

    private void createNameRoom(String idPhong, JPanel pnlRom, Color colorBackground, Room room) {
        lblRoom = new JButton();
        lblRoom.setText(roomDAO.findRoomById(idPhong).getTenPhong());
        lblRoom.setOpaque(true);
        lblRoom.setBackground(colorBackground);
        lblRoom.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblRoom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lblRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameRoom = room.getTenPhong();
            }
        });
        pnlRom.add(lblRoom, BorderLayout.CENTER);
    }

    // create ID order
    public String idRandom(String name) {
        Random random = new Random();
        int i = random.nextInt(9999999);

        return String.valueOf(name + i);
    }

    // create customer
    private Customer createCustomer() {
        Customer customer = new Customer(txtCMND.getText(), txtTenKH.getText(), txtSDT.getText(),
                cboGioiTinh.getSelectedIndex() == 1 ? true : false, txtDiaChi.getText());
        return customer;
    }

    private void clearText() {
        txtCMND.setText("");
        txtDiaChi.setText("");
        txtGioDat.setText("");
        txtGioNhan.setText("");
        txtSDT.setText("");
        txtTenKH.setText("");
        datePickerDat.getJFormattedTextField().setText("");
        datePickerNhan.getJFormattedTextField().setText("");
    }

    // Check Data File
    private boolean checkDataFile() {
        String messege = "";
        if (txtCMND.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtTenKH.getText().isEmpty()
                || txtSDT.getText().isEmpty() || txtGioDat.getText().isEmpty() || txtGioNhan.getText().isEmpty()
                || datePickerNhan.getJFormattedTextField().getText().isEmpty()
                || datePickerDat.getJFormattedTextField().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "B???n vui l??ng nh???p ?????y ????? th??ng tin");
            return false;
        } else if (customerDAO.findCustomerById(txtCMND.getText()) != null) {
            JOptionPane.showMessageDialog(null, "Kh??ch h??ng n??y ???? ?????t ph??ng");
            return false;
        }
        if (nameRoom != null) {
            if (roomDAO.findRoomByNameRoom(nameRoom).getRoomStatusType().getMaLoaiTTP().equals("LTTP001")) {
                JOptionPane.showMessageDialog(null, "Ph??ng n??y ???? c?? ng?????i ?????t");
                return false;
            } else if (roomDAO.findRoomByNameRoom(nameRoom).getRoomStatusType().getMaLoaiTTP().equals("LTTP002")) {
                JOptionPane.showMessageDialog(null, "Ph??ng n??y ??ang c?? ng?????i s??? d???ng");
                return false;
            }
        } else if (nameRoom == null) {
            JOptionPane.showMessageDialog(null, "Vui l??ng ch???n ph??ng");
            return false;
//        } else {
//            String regexCMND = "^[0-9]{9}|[0-9]{12}";
//            Pattern patternCMND = Pattern.compile(regexCMND);
//            Matcher matcherCMND = patternCMND.matcher(txtCMND.getText());
//            Boolean checkCMND = matcherCMND.matches();
//
//            if (!checkCMND) {
//                messege += "CMND ph???i l?? s??? v?? bao g???m 9 ho???c 12 s???";
//            }
//            if (!messege.isEmpty()) {
//                JOptionPane.showMessageDialog(null, messege);
//                return false;
//            } else {
//                
//            }
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
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Th??ng tin ?????t ph??ng"));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("T??n kh??ch h??ng: ");

        txtSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("S??? CMND: ");

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("S??? ??i???n tho???i:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ng??y nh???n ph??ng:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ng??y ?????t ph??ng:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Gi??? ?????t:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("?????a ch???: ");

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Gi??? nh???n ph??ng: ");

        txtGioNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtCMND.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        pnlNhan.setLayout(new java.awt.BorderLayout());

        pnlDat.setLayout(new java.awt.BorderLayout());

        txtGioDat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Gi???i t??nh: ");

        cboGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "N???" }));

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
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh s??ch ?????t ph??ng"));

        tblDsDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CMND", "T??n kh??ch h??ng", "S??? ??i???n tho???i", "Ng??y ?????t", "Ng??y nh???n", "S??? ph??ng", "Tr???ng th??i"
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
        btnMoPhong.setText("M??? Ph??ng");
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
        btnDoiPhong.setText("?????i ph??ng");
        btnDoiPhong.setActionCommand("");
        btnDoiPhong.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnDoiPhong.setkEndColor(new java.awt.Color(51, 255, 255));
        btnDoiPhong.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnDoiPhong.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnDoiPhong.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnDoiPhong.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnDoiPhong.setkStartColor(new java.awt.Color(51, 51, 255));
        btnDoiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiPhongActionPerformed(evt);
            }
        });

        btnDatPhong.setBackground(new java.awt.Color(255, 255, 255));
        btnDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smartphone.png"))); // NOI18N
        btnDatPhong.setText("?????t Ph??ng");
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
        txtSearch.setText("T??m kh??ch h??ng");
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
        lblTitile.setText("Ph??ng");
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
                                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)))
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
            if (customerDAO.insertCustomer(createCustomer()) && roomDAO.updateRoom(room)) {
                Staff staff = staffDAO.getEmployeeBYID(usename);
                BookRoom bookRoom = new BookRoom(idRandom("DDP"), datePickerDat.getJFormattedTextField().getText(),
                        txtGioDat.getText(), datePickerNhan.getJFormattedTextField().getText(), txtGioNhan.getText(),
                        room, createCustomer(), staff);
                if (bookRoomDAO.insertBookRoom(bookRoom)) {
                    JOptionPane.showMessageDialog(null, "?????t ph??ng th??nh c??ng");
                    loadAllDSDatPhong();
                    createRoom();
                    clearText();
                }
            }
        }
    }//GEN-LAST:event_btnDatPhongActionPerformed
// forcus search
    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("T??m kh??ch h??ng")) {
            txtSearch.setText("");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchFocusGained
// no focus search
    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText() != null) {
            txtSearch.setText("T??m kh??ch h??ng");
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
            if (tblDsDatPhong.getValueAt(row, 6) != null) {
                datePickerDat.getJFormattedTextField().setText(tblDsDatPhong.getValueAt(row, 6).toString());
            } else {
                datePickerDat.getJFormattedTextField().setText("");
            }
            if (tblDsDatPhong.getValueAt(row, 7) != null) {
                txtGioDat.setText(tblDsDatPhong.getValueAt(row, 7).toString());
            } else {
                txtGioDat.setText("");
            }
            datePickerNhan.getJFormattedTextField().setText(tblDsDatPhong.getValueAt(row, 8).toString());
            txtGioNhan.setText(tblDsDatPhong.getValueAt(row, 9).toString());
        }
    }//GEN-LAST:event_tblDsDatPhongMouseClicked

    private void btnMoPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoPhongActionPerformed
        int row = tblDsDatPhong.getSelectedRow();
        if (row >= 0) {
            if (tblDsDatPhong.getValueAt(row, 10).toString().equals("???? ?????t")) {
                Room room = roomDAO.findRoomByNameRoom(tblDsDatPhong.getValueAt(row, 0).toString());
                RoomStatusType roomStatusType = roomStatusTypeDAO.finRoomStatusTypeById(room.getRoomStatusType().getMaLoaiTTP());

                if (roomStatusType.getMaLoaiTTP().equals("LTTP001")) {
                    roomStatusType = roomStatusTypeDAO.finRoomStatusTypeById("LTTP002");
                }
                room.setRoomStatusType(roomStatusType);
                roomDAO.updateRoom(room);
                BookRoom bookRoom = bookRoomDAO.findBookRoomByIDRoom(room.getMaPhong());
                Customer customer = customerDAO.findCustomerById(bookRoom.getCustomer().getMaKH());
                Staff staff = staffDAO.findStaffById(usename);
                Order order = new Order(idRandom("HD"), bookRoom.getNgayNhan(), bookRoom.getGioNhan(), null, null,
                        java.time.LocalDate.now().toString(), 10, customer, room, staff, 0);
                if (orderDAO.insertOrder(order)) {
                    JOptionPane.showMessageDialog(null, "M??? ph??ng th??nh c??ng");
                    loadAllDSDatPhong();
                    createRoom();
                    clearText();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ph??ng n??y ???? m???");
            }
        } else if (checkDataFile()) {
            Room room = roomDAO.findRoomByNameRoom(nameRoom);
            RoomStatusType roomStatusType = roomStatusTypeDAO.finRoomStatusTypeById(room.getRoomStatusType().getMaLoaiTTP());

            if (roomStatusType.getMaLoaiTTP().equals("LTTP003")) {
                roomStatusType = roomStatusTypeDAO.finRoomStatusTypeById("LTTP002");
            }
            room.setRoomStatusType(roomStatusType);
            if (customerDAO.insertCustomer(createCustomer()) && roomDAO.updateRoom(room)) {
                Staff staff = staffDAO.getEmployeeBYID(usename);
                BookRoom bookRoom = new BookRoom(idRandom("DDP"), null, null, datePickerNhan.getJFormattedTextField().getText(),
                        txtGioNhan.getText(), room, createCustomer(), staff);
                Order order = new Order(idRandom("HD"), bookRoom.getNgayNhan(), bookRoom.getGioNhan(), null, null,
                        java.time.LocalDate.now().toString(), 10, createCustomer(), room, staff, 0);

                if (bookRoomDAO.insertBookRoom(bookRoom) && orderDAO.insertOrder(order)) {
                    JOptionPane.showMessageDialog(null, "M??? ph??ng th??nh c??ng");
                    loadAllDSDatPhong();
                    createRoom();
                    clearText();
                }
            }
        }
    }//GEN-LAST:event_btnMoPhongActionPerformed

    private void btnDoiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiPhongActionPerformed
        int row = tblDsDatPhong.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Ch???n th??ng tin kh??ch h??ng mu???n ?????i ph??ng");
        } else {
            Room room = roomDAO.findRoomByNameRoom(tblDsDatPhong.getValueAt(row, 0).toString());
            BookRoom bookRoom = bookRoomDAO.findBookRoomByIDRoom(room.getMaPhong());
            frmChangeRoom frm = new frmChangeRoom(room, bookRoom, usename);
            frm.setVisible(true);
            frm.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) {
                    if (e.getComponent().isVisible() == false) {
                        createRoom();
                        loadAllDSDatPhong();
                        clearText();
                        
                        JOptionPane.showMessageDialog(null, "?????i ph??ng th??nh c??ng");
                    }
                }
            });
        }
    }//GEN-LAST:event_btnDoiPhongActionPerformed


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
