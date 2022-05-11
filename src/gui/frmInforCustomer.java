/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import dao.CustomerDAO;
import dao.OrderDAO;
import entity.Customer;
import entity.Order;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import regex.RegexHelper;

/**
 *
 * @author vomin
 */
public class frmInforCustomer extends javax.swing.JInternalFrame {

    private DefaultTableModel customerTableModel;
    private OrderDAO orderDAO;
    private CustomerDAO customerDAO;

    /**
     * Creates new form NewJInternalFrame1
     */
    public frmInforCustomer() {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);

        initComponents();
        this.setFocusable(true);

        //set model table
        customerTableModel = new DefaultTableModel();
        orderDAO = new OrderDAO();
        customerDAO = new CustomerDAO();

        customerTableModel.setColumnIdentifiers(new String[]{"CMND/ CCCD", "Tên Khách Hàng", "Số Điện Thoại", "Giới Tính", "Địa Chỉ", "Ngày Đến", "Ngày Đi"});
        tblCustomer.setModel(customerTableModel);

        loadDataToComboGender();
        loadDataToTable();
    }

    private void loadDataToComboGender() {
        cboGender.addItem("Nam");
        cboGender.addItem("Nữ");

        cboFilter.addItem("Hôm nay");
        cboFilter.addItem("Tháng này");
        cboFilter.addItem("Năm này");
    }

    private void loadDataToTable() {
        List<Order> orders = orderDAO.getAllOrderToDay();

        loadDataToModel(orders);
    }

    private void loadDataToModel(List<Order> list) {
        customerTableModel.setRowCount(0);

        for (Order item : list) {
            customerTableModel.addRow(new String[]{item.getCustomer().getMaKH(), item.getCustomer().getTenKH(),
                item.getCustomer().getSoDT(), item.getCustomer().isGioiTinh() == true ? "Nam" : "Nữ",
                item.getCustomer().getDiaChi(), reverseDate(item.getNgayVao()), reverseDate(item.getNgayRa())});
        }
    }

    private void loadDataToModelByFind(List<Customer> list) {
        customerTableModel.setRowCount(0);

        for (Customer item : list) {
            customerTableModel.addRow(new String[]{item.getMaKH(), item.getTenKH(),
                "0" + item.getSoDT(), item.isGioiTinh() == true ? "Nam" : "Nữ",
                item.getDiaChi(), "", ""});
        }
    }

    private String reverseDate(String date) {
        SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfClient = new SimpleDateFormat("dd-MM-yyyy");
        Date dateTemp;
        try {
            dateTemp = sdfSQL.parse(date);
            String dateFormatToString = sdfClient.format(dateTemp);
            return dateFormatToString;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ERROR!";
    }

    private void eventChangeComboBox() {
        switch (cboFilter.getSelectedItem().toString()) {
            case "Hôm nay" -> {
                List<Order> orders = orderDAO.getAllOrderToDay();
                loadDataToModel(orders);
            }
            case "Tháng này" -> {
                List<Order> orders = orderDAO.getAllOrderToMonth();
                loadDataToModel(orders);
            }
            default -> {
                List<Order> orders = orderDAO.getAllOrderToYear();
                loadDataToModel(orders);
            }
        }
    }

    private void clearInput() {
        txtAddress.setText("");
        txtCustomerName.setText("");
        txtIdCustomer.setText("");
        txtPhoneNumber.setText("");
        cboGender.setSelectedIndex(0);
    }

    public boolean exportFileExcel(JTable table, String part) {
        TableModel model = table.getModel();
        
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Danh sách khách hàng");
        
        Row headerRow = sheet.createRow(0);
        
        for(int i = 0; i < model.getColumnCount(); ++i) {
            headerRow.createCell(i).setCellValue(model.getColumnName(i));
        }
        
        
        for(int i = 0; i < model.getRowCount(); i++) {
            Row curentRow = sheet.createRow(i + 1);
            for(int j = 0; j < model.getColumnCount(); j++) {
                curentRow.createCell(j).setCellValue(model.getValueAt(i, j).toString());
                System.err.println(model.getValueAt(i, j).toString());
            }
        }
        
        try(FileOutputStream fos = new FileOutputStream(new File(part))){
            workbook.write(fos);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlTitle = new javax.swing.JPanel();
        lblTitile = new javax.swing.JLabel();
        pnlAddSerice = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIdCustomer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        cboGender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        btnChangeInforCustomer = new com.k33ptoo.components.KButton();
        txtSearch = new javax.swing.JTextField();
        cboFilter = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnExportData = new com.k33ptoo.components.KButton();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);

        pnlTitle.setLayout(new java.awt.BorderLayout());

        lblTitile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitile.setText("QUẢN LÝ KHÁCH HÀNG");
        pnlTitle.add(lblTitile, java.awt.BorderLayout.CENTER);

        pnlAddSerice.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khách hàng"));

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết"));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("SDT: ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtIdCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIdCustomer.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Giới tính: ");

        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cboGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("CMND: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên khách hàng: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        txtCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnChangeInforCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons-edit.png"))); // NOI18N
        btnChangeInforCustomer.setText("Sửa thông tin khách hàng");
        btnChangeInforCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChangeInforCustomer.setIconTextGap(25);
        btnChangeInforCustomer.setkEndColor(new java.awt.Color(0, 204, 255));
        btnChangeInforCustomer.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnChangeInforCustomer.setkHoverForeGround(new java.awt.Color(0, 204, 0));
        btnChangeInforCustomer.setkHoverStartColor(new java.awt.Color(0, 204, 255));
        btnChangeInforCustomer.setkPressedColor(new java.awt.Color(0, 153, 153));
        btnChangeInforCustomer.setkStartColor(new java.awt.Color(51, 51, 255));
        btnChangeInforCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChangeInforCustomerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel1)))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCustomerName)
                            .addComponent(txtIdCustomer))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneNumber)
                            .addComponent(cboGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtAddress)
                    .addComponent(btnChangeInforCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangeInforCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cboFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboFilterItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Lựa chọn xuất thông tin:");

        btnExportData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons-print.png"))); // NOI18N
        btnExportData.setText("Xuất thông tin");
        btnExportData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExportData.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExportData.setkHoverEndColor(new java.awt.Color(0, 204, 153));
        btnExportData.setkHoverForeGround(new java.awt.Color(0, 255, 204));
        btnExportData.setkHoverStartColor(new java.awt.Color(0, 204, 102));
        btnExportData.setkPressedColor(new java.awt.Color(0, 204, 51));
        btnExportData.setkSelectedColor(new java.awt.Color(0, 153, 0));
        btnExportData.setkStartColor(new java.awt.Color(0, 204, 0));
        btnExportData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportDataMouseClicked(evt);
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
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportData, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlAddSerice, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAddSerice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExportData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText() != null) {
            txtSearch.setText("Tìm khách hàng");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Tìm khách hàng")) {
            txtSearch.setText("");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        int index = tblCustomer.getSelectedRow();
        txtIdCustomer.setText(tblCustomer.getValueAt(index, 0).toString());
        txtCustomerName.setText(tblCustomer.getValueAt(index, 1).toString());
        txtPhoneNumber.setText(tblCustomer.getValueAt(index, 2).toString());
        cboGender.setSelectedItem(tblCustomer.getValueAt(index, 3).toString());
        txtAddress.setText(tblCustomer.getValueAt(index, 4).toString());
    }//GEN-LAST:event_tblCustomerMouseClicked

    private void cboFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFilterItemStateChanged
        eventChangeComboBox();
    }//GEN-LAST:event_cboFilterItemStateChanged

    private void btnChangeInforCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeInforCustomerMouseClicked
        int index = tblCustomer.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để thực hiện chỉnh sửa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else {
            String maKH = txtIdCustomer.getText().trim();
            String tenKH = txtCustomerName.getText().trim();
            String sdt = txtPhoneNumber.getText().trim();
            boolean gioiTinh = cboGender.getSelectedItem().toString().equals("Nam");
            String diaChi = txtAddress.getText().trim();

            if (!RegexHelper.regexCustomerName(tenKH)) {
                JOptionPane.showMessageDialog(this, "Tên khách hàng sai định dạng!\n VD: Lê Tuấn", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (!RegexHelper.regexPhoneNumber(sdt)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không chứa ký tự chữ, phải đủ 10 số và bắt đầu bằng các đầu số hợp lệ ( 09, 08, 03, 07, 05 )!\n VD: 0343229978", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                Customer customer = new Customer(maKH, tenKH, sdt, gioiTinh, diaChi);
                customerDAO.updateCustomerById(customer);
                loadDataToTable();
                Customer c=customerDAO.findCustomerById(maKH);
                List<Customer> cs =new ArrayList<>();
                cs.add(c);
                loadDataToModelByFind(cs);
                clearInput();
            }

        }
    }//GEN-LAST:event_btnChangeInforCustomerMouseClicked

    private void btnExportDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportDataMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String name = fileChooser.getSelectedFile().getName();
            String path = fileChooser.getSelectedFile().getParentFile().getPath();
            String pathFile = path + "\\" + name + ".xlsx";
            if(exportFileExcel(tblCustomer, pathFile)) {
                JOptionPane.showMessageDialog(this, "Xuất file thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this, "Xuất file thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExportDataMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String s=txtSearch.getText();
        filter(s);
    }//GEN-LAST:event_txtSearchKeyReleased
     private void filter(String s){
         TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(customerTableModel);
        tblCustomer.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+s));      
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnChangeInforCustomer;
    private com.k33ptoo.components.KButton btnExportData;
    private javax.swing.JComboBox<String> cboFilter;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitile;
    private javax.swing.JPanel pnlAddSerice;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtIdCustomer;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
