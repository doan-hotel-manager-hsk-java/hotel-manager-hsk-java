/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import dao.DeviceDAO;
import dao.StaffDAO;
import entity.Device;
import entity.Staff;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import regex.RegexHelper;

/**
 *
 * @author vomin
 */
public class frmDeviceManager extends javax.swing.JInternalFrame {
    private DeviceDAO deviceDAO;
    private DefaultTableModel dtm;
    private StaffDAO staffDAO;
    
    private String id;
    private String username;
    public frmDeviceManager(String _username) {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
       
        initComponents();
       this.setFocusable(true);
       
       username = _username;
       dtm=(DefaultTableModel) tblDevice.getModel();
       deviceDAO=new DeviceDAO();
       staffDAO=new StaffDAO();
        loadDataToTable(deviceDAO.getAllDevices(), dtm);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenThietBi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDevice = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new com.k33ptoo.components.KButton();
        btnSua = new com.k33ptoo.components.KButton();
        btnXoa = new com.k33ptoo.components.KButton();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);

        pnlTitle.setLayout(new java.awt.BorderLayout());

        lblTitile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitile.setText("QU???N L?? THI???T B???");
        pnlTitle.add(lblTitile, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(204, 204, 204));
        txtSearch.setText("T??m thi???t b???");
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
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Th??ng tin chi ti???t"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("T??n thi???t b???: ");

        txtTenThietBi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("S??? l?????ng: ");

        txtSoLuongTon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Gi??: ");

        txtGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

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
                            .addComponent(txtTenThietBi, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                            .addComponent(txtGia)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongTon)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh s??ch thi???t b???"));

        tblDevice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "T??n thi???t b???", "S??? l?????ng", "Gi??"
            }
        ));
        tblDevice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeviceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDevice);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("X??? l??"));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon-add.png"))); // NOI18N
        btnThem.setText("Th??m thi???t b???");
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
        btnSua.setText("S???a thi???t b???");
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
        btnXoa.setText("X??a thi???t b???");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if(txtSearch.getText().equals("T??m thi???t b???")){
            txtSearch.setText("");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
       if(txtSearch.getText() != null){
            txtSearch.setText("T??m thi???t b???");
            txtSearch.setFont(txtSearch.getFont());
            txtSearch.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkData()){
            Device d= createDevice();
            try{
                if(deviceDAO.findDeviceByName(txtTenThietBi.getText()) ==null){
                deviceDAO.insertDevice(d);
                loadDataToTable(deviceDAO.getAllDevices(), dtm);
                clearInput();
                JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng!");
                }else
                    JOptionPane.showMessageDialog(this, "Thi???t b??? n??y ???? c??, h??y ki???m tra l???i t??n thi???t b???!");        
            }catch (Exception e1){
                JOptionPane.showMessageDialog(this, e1.getMessage());
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int index = tblDevice.getSelectedRow();
        if (index==-1){
            JOptionPane.showMessageDialog(this, "H??y ch???n d??ng c???n s???a!");
        }else{
        if (checkData()){
            Device d=deviceDAO.findDeviceByName(dtm.getValueAt(index, 0)+"");
             if(!txtTenThietBi.getText().equals(dtm.getValueAt(index, 0)+"")){
                txtTenThietBi.setText(tblDevice.getValueAt(index, 0)+"");
                JOptionPane.showMessageDialog(this, "Kh??ng ???????c s???a t??n thi???t b???!");
            }else{
            d.setSoLuongTon(Integer.parseInt(txtSoLuongTon.getText()));
            d.setGia(Double.parseDouble(txtGia.getText()));
            if (d.getTenTTB().equals(dtm.getValueAt(index, 0)+""))
            deviceDAO.updateDeviceById(d);
            loadDataToTable(deviceDAO.getAllDevices(), dtm);
            clearInput();
            JOptionPane.showMessageDialog(this, "S???a th??nh c??ng!");
            }
        }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index= tblDevice.getSelectedRow();
        if (index==-1){
            JOptionPane.showMessageDialog(this, "H??y ch???n d??ng c???n x??a!");
        }else{
            int choose = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n x??a thi???t b??? n??y?", "H???i", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choose == JOptionPane.YES_OPTION) {
                Device d=deviceDAO.findDeviceByName(dtm.getValueAt(index, 0)+"");
                d.setTrangThai(0);
                deviceDAO.updateDeviceById(d);
                
                loadDataToTable(deviceDAO.getAllDevices(), dtm);
                clearInput();
                JOptionPane.showMessageDialog(this, "X??a th??nh c??ng!");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblDeviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeviceMouseClicked
        int index = tblDevice.getSelectedRow();
        txtTenThietBi.setText(tblDevice.getValueAt(index, 0).toString());
        txtSoLuongTon.setText(tblDevice.getValueAt(index, 1).toString());
        txtGia.setText(tblDevice.getValueAt(index, 2).toString());
    }//GEN-LAST:event_tblDeviceMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String s=txtSearch.getText();
        filter(s);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void filter(String s){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(dtm);
        tblDevice.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+s));

        
    }
    private void loadDataToTable(List<Device> list, DefaultTableModel dtm) {  
        dtm.setRowCount(0);
        for (Device device: list) {
            String gia = NumberFormat.getInstance().format(device.getGia());
            dtm.addRow(new Object[] {device.getTenTTB(),String.valueOf(device.getSoLuongTon()),device.getGia()});
        }
    }
    
    private Device createDevice() {
        String tenTTB= txtTenThietBi.getText();
        int soLuong= Integer.parseInt(txtSoLuongTon.getText());
        double gia=Double.parseDouble(txtGia.getText());
        
        Staff staff = staffDAO.getEmployeeBYID(username);
        Device d=new Device(setMaTTB(), tenTTB, soLuong, "M??y", gia, 1,staff);
        return d;
    }
    private boolean checkData() {
        if (txtTenThietBi.getText().trim().equals("") || txtSoLuongTon.getText().trim().equals("") || txtGia.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "H??y nh???p ?????y ????? th??ng tin!");
            return false;
        }else{
            String thongBao="";
            if (!RegexHelper.regexDeviceName(txtTenThietBi.getText()))
                thongBao+="* T??n thi???t b??? sai d???nh d???ng!VD: ??i???u h??a\n";
            if (!RegexHelper.regexSoLuongTon(txtSoLuongTon.getText()))
                thongBao+="* S??? l?????ng ch??? t??? 1-100\n";
            if (!RegexHelper.regexGia(txtGia.getText()))
                thongBao+="* Gi?? c???a thi???t b??? ph???i tr??n 1.000 v?? d?????i 10.000.000";
            if (thongBao.isEmpty())
                return true;
            else{
                JOptionPane.showMessageDialog(this, thongBao);
                return false;
            }
        }
        
    }
    
    private String setMaTTB(){
        String s="TTB";
        int ma= deviceDAO.getDevicesByAllStatus().size();
        if (ma<9)
            s=s+ "00"+ (ma+1);
        else
            s=s+"0"+(ma+1);
        return s;
    }
    private void clearInput(){
        txtTenThietBi.setText("");
        txtSoLuongTon.setText("");
        txtGia.setText("");
        txtTenThietBi.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnSua;
    private com.k33ptoo.components.KButton btnThem;
    private com.k33ptoo.components.KButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTitile;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTable tblDevice;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenThietBi;
    // End of variables declaration//GEN-END:variables
}
