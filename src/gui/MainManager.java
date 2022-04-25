/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author vomin
 */
public class MainManager extends javax.swing.JFrame {

    /**
     * Creates new form MainManager1
     */
    public MainManager() {
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setResizable(true);
        this.setVisible(true);

        initComponents();

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        Check();

    }

    void Check() {
        Component[] components = pnlSlide.getComponents();
        Component component = null;
        for (int i = 0; i < components.length; i++) {
            component = components[i];
            if (component == pnlHome) {
                pnlHome.requestFocus();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlSlide = new javax.swing.JPanel();
        pnlImage = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new com.k33ptoo.components.KButton();
        pnlHome = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        pnlRoom = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        lblRoom = new javax.swing.JLabel();
        pnlService = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lblService = new javax.swing.JLabel();
        pnlDevice = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblDevice = new javax.swing.JLabel();
        pnlEmployee = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lblEmployee = new javax.swing.JLabel();
        pnlStatistics = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblStatistics = new javax.swing.JLabel();
        pnlContacInfo = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        lblContactInfo = new javax.swing.JLabel();
        pnlTitile = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setPreferredSize(new java.awt.Dimension(700, 600));
        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlSlide.setBackground(new java.awt.Color(237, 240, 250));
        pnlSlide.setPreferredSize(new java.awt.Dimension(250, 200));

        pnlImage.setBackground(new java.awt.Color(237, 240, 250));
        pnlImage.setPreferredSize(new java.awt.Dimension(250, 119));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Admin");

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel18.setText("Võ Minh Phương");

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-manager.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout-icon-16.png"))); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.setAlignmentX(0.9F);
        btnLogout.setAlignmentY(10.0F);
        btnLogout.setDefaultCapable(false);
        btnLogout.setFocusable(false);
        btnLogout.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setIconTextGap(1);
        btnLogout.setkEndColor(new java.awt.Color(5, 154, 3));
        btnLogout.setkHoverEndColor(new java.awt.Color(22, 146, 224));
        btnLogout.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnLogout.setkHoverStartColor(new java.awt.Color(129, 61, 191));
        btnLogout.setkStartColor(new java.awt.Color(16, 218, 246));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlImageLayout = new javax.swing.GroupLayout(pnlImage);
        pnlImage.setLayout(pnlImageLayout);
        pnlImageLayout.setHorizontalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImageLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addGroup(pnlImageLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlImageLayout.createSequentialGroup()
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlImageLayout.setVerticalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImageLayout.createSequentialGroup()
                .addGroup(pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlImageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlImage);

        pnlHome.setBackground(new java.awt.Color(255, 255, 255));
        pnlHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlHome.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlHome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnlHomeFocusGained(evt);
            }
        });
        pnlHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHomeMousePressed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home-page-16.png"))); // NOI18N
        jLabel15.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.setPreferredSize(new java.awt.Dimension(30, 30));

        lblHome.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblHome.setText("Trang chủ");
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblHome)
                .addGap(0, 132, Short.MAX_VALUE))
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHome))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlHome);

        pnlRoom.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlRoom.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlRoomMousePressed(evt);
            }
        });

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/room.png"))); // NOI18N
        jLabel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel29.setPreferredSize(new java.awt.Dimension(30, 30));

        lblRoom.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblRoom.setText("Quản lý phòng");
        lblRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlRoomLayout = new javax.swing.GroupLayout(pnlRoom);
        pnlRoom.setLayout(pnlRoomLayout);
        pnlRoomLayout.setHorizontalGroup(
            pnlRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoomLayout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblRoom)
                .addGap(0, 99, Short.MAX_VALUE))
        );
        pnlRoomLayout.setVerticalGroup(
            pnlRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoomLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRoom))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlRoom);

        pnlService.setBackground(new java.awt.Color(255, 255, 255));
        pnlService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlService.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlServiceMousePressed(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/service.png"))); // NOI18N
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.setPreferredSize(new java.awt.Dimension(30, 30));

        lblService.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblService.setText("Quản lý dịch vụ");
        lblService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlServiceLayout = new javax.swing.GroupLayout(pnlService);
        pnlService.setLayout(pnlServiceLayout);
        pnlServiceLayout.setHorizontalGroup(
            pnlServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServiceLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblService)
                .addGap(0, 92, Short.MAX_VALUE))
        );
        pnlServiceLayout.setVerticalGroup(
            pnlServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServiceLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblService))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlService);

        pnlDevice.setBackground(new java.awt.Color(255, 255, 255));
        pnlDevice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlDevice.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlDevice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlDeviceMousePressed(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/device.png"))); // NOI18N
        jLabel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.setPreferredSize(new java.awt.Dimension(30, 30));

        lblDevice.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblDevice.setText("Quản lý trang thiết bị");
        lblDevice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlDeviceLayout = new javax.swing.GroupLayout(pnlDevice);
        pnlDevice.setLayout(pnlDeviceLayout);
        pnlDeviceLayout.setHorizontalGroup(
            pnlDeviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeviceLayout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblDevice)
                .addGap(0, 49, Short.MAX_VALUE))
        );
        pnlDeviceLayout.setVerticalGroup(
            pnlDeviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeviceLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlDeviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDevice))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlDevice);

        pnlEmployee.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlEmployee.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlEmployeeMousePressed(evt);
            }
        });

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/employee.png"))); // NOI18N
        jLabel20.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.setPreferredSize(new java.awt.Dimension(30, 30));

        lblEmployee.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblEmployee.setText("Quản lý nhân viên");
        lblEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlEmployeeLayout = new javax.swing.GroupLayout(pnlEmployee);
        pnlEmployee.setLayout(pnlEmployeeLayout);
        pnlEmployeeLayout.setHorizontalGroup(
            pnlEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeeLayout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEmployee)
                .addGap(0, 73, Short.MAX_VALUE))
        );
        pnlEmployeeLayout.setVerticalGroup(
            pnlEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployee))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlEmployee);

        pnlStatistics.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatistics.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlStatistics.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlStatisticsMousePressed(evt);
            }
        });

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/statistics.png"))); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.setPreferredSize(new java.awt.Dimension(30, 30));

        lblStatistics.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblStatistics.setText("Thống kê doanh thu");
        lblStatistics.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlStatisticsLayout = new javax.swing.GroupLayout(pnlStatistics);
        pnlStatistics.setLayout(pnlStatisticsLayout);
        pnlStatisticsLayout.setHorizontalGroup(
            pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatisticsLayout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblStatistics)
                .addGap(0, 60, Short.MAX_VALUE))
        );
        pnlStatisticsLayout.setVerticalGroup(
            pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatisticsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatistics))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlStatistics);

        pnlContacInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlContacInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlContacInfo.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlContacInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlContacInfoMousePressed(evt);
            }
        });

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/info.png"))); // NOI18N
        jLabel22.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.setPreferredSize(new java.awt.Dimension(30, 30));

        lblContactInfo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblContactInfo.setText("Xuất thông tin khách hàng");
        lblContactInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlContacInfoLayout = new javax.swing.GroupLayout(pnlContacInfo);
        pnlContacInfo.setLayout(pnlContacInfoLayout);
        pnlContacInfoLayout.setHorizontalGroup(
            pnlContacInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContacInfoLayout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblContactInfo)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        pnlContacInfoLayout.setVerticalGroup(
            pnlContacInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContacInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlContacInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContactInfo))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSlide.add(pnlContacInfo);

        pnlMain.add(pnlSlide, java.awt.BorderLayout.WEST);

        pnlTitile.setBackground(new java.awt.Color(41, 141, 71));
        pnlTitile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlTitile.setPreferredSize(new java.awt.Dimension(40, 40));
        pnlTitile.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(41, 141, 71));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hotel ABC");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setFocusable(false);
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(115, 20));
        pnlTitile.add(jLabel2, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlTitile, java.awt.BorderLayout.PAGE_START);

        pnlForm.setOpaque(false);
        pnlForm.setLayout(new java.awt.BorderLayout());
        pnlMain.add(pnlForm, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void pnlHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHomeMousePressed
        setColor(pnlHome, lblHome);
        resetColor(pnlRoom, lblRoom);
        resetColor(pnlService, lblService);
        resetColor(pnlDevice, lblDevice);
        resetColor(pnlEmployee, lblEmployee);
        resetColor(pnlStatistics, lblStatistics);
        resetColor(pnlContacInfo, lblContactInfo);

       frmHome frame = new frmHome();
       openComponent(frame);

    }//GEN-LAST:event_pnlHomeMousePressed

    private void pnlRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRoomMousePressed
        setColor(pnlRoom, lblRoom);
        resetColor(pnlHome, lblHome);
        resetColor(pnlService, lblService);
        resetColor(pnlDevice, lblDevice);
        resetColor(pnlEmployee, lblEmployee);
        resetColor(pnlStatistics, lblStatistics);
        resetColor(pnlContacInfo, lblContactInfo);

        frmRoomManager frame = new frmRoomManager();
        openComponent(frame);
    }//GEN-LAST:event_pnlRoomMousePressed

    private void pnlServiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlServiceMousePressed
        setColor(pnlService, lblService);
        resetColor(pnlRoom, lblRoom);
        resetColor(pnlHome, lblHome);
        resetColor(pnlDevice, lblDevice);
        resetColor(pnlEmployee, lblEmployee);
        resetColor(pnlStatistics, lblStatistics);
        resetColor(pnlContacInfo, lblContactInfo);

        frmService frame = new frmService();
        openComponent(frame);
    }//GEN-LAST:event_pnlServiceMousePressed

    private void pnlDeviceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDeviceMousePressed
        setColor(pnlDevice, lblDevice);
        resetColor(pnlRoom, lblRoom);
        resetColor(pnlService, lblService);
        resetColor(pnlHome, lblHome);
        resetColor(pnlEmployee, lblEmployee);
        resetColor(pnlStatistics, lblStatistics);
        resetColor(pnlContacInfo, lblContactInfo);

        frmDevice frame = new frmDevice();
        openComponent(frame);
    }//GEN-LAST:event_pnlDeviceMousePressed

    private void pnlEmployeeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEmployeeMousePressed
        setColor(pnlEmployee, lblEmployee);
        resetColor(pnlRoom, lblRoom);
        resetColor(pnlService, lblService);
        resetColor(pnlDevice, lblDevice);
        resetColor(pnlHome, lblHome);
        resetColor(pnlStatistics, lblStatistics);
        resetColor(pnlContacInfo, lblContactInfo);

        frmEmployee frame = new frmEmployee();
        openComponent(frame);
    }//GEN-LAST:event_pnlEmployeeMousePressed

    private void pnlStatisticsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatisticsMousePressed
        setColor(pnlStatistics, lblStatistics);
        resetColor(pnlRoom, lblRoom);
        resetColor(pnlService, lblService);
        resetColor(pnlDevice, lblDevice);
        resetColor(pnlEmployee, lblEmployee);
        resetColor(pnlHome, lblHome);
        resetColor(pnlContacInfo, lblContactInfo);

        frmStatistical frame = new frmStatistical();
        openComponent(frame);
    }//GEN-LAST:event_pnlStatisticsMousePressed

    private void pnlContacInfoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlContacInfoMousePressed
        setColor(pnlContacInfo, lblContactInfo);
        resetColor(pnlRoom, lblRoom);
        resetColor(pnlService, lblService);
        resetColor(pnlDevice, lblDevice);
        resetColor(pnlEmployee, lblEmployee);
        resetColor(pnlStatistics, lblStatistics);
        resetColor(pnlHome, lblHome);

        frmInforCustomer frame = new frmInforCustomer();
        openComponent(frame);
      
    }//GEN-LAST:event_pnlContacInfoMousePressed

    private void pnlHomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnlHomeFocusGained
        setColor(pnlHome, lblHome);
        resetColor(pnlRoom, lblRoom);
        resetColor(pnlService, lblService);
        resetColor(pnlDevice, lblDevice);
        resetColor(pnlEmployee, lblEmployee);
        resetColor(pnlStatistics, lblStatistics);
        resetColor(pnlContacInfo, lblContactInfo);

       frmHome frame = new frmHome();
        openComponent(frame);

       
    }//GEN-LAST:event_pnlHomeFocusGained

    void openComponent(JInternalFrame frame) {
        Component[] components = pnlForm.getComponents();
        Component component = null;
        for (int i = 0; i < components.length; i++) {
            component = components[i];
            if (component != null) {
                component.setVisible(false);
            }
        }
        pnlForm.add(frame);
        frame.setVisible(true);
    }

    void setColor(JPanel panel, JLabel label) {
        panel.setBackground(new Color(204, 232, 255));
        label.setForeground(new Color(33, 162, 72));
    }

    void resetColor(JPanel panel, JLabel label) {
        panel.setBackground(new Color(255, 255, 255));
        label.setForeground(new Color(0, 0, 0));
    }

    public MainManager(KButton btnLogout, JLabel jLabel1, JLabel jLabel15, JLabel jLabel16, JLabel jLabel17, JLabel jLabel18, JLabel jLabel19, JLabel jLabel2, JLabel jLabel20, JLabel jLabel21, JLabel jLabel22, JLabel jLabel29, JPanel jPanel11, KGradientPanel kGradientPanel1, JLabel lblContactInfo, JLabel lblDevice, JLabel lblEmployee, JLabel lblHome, JLabel lblRoom, JLabel lblService, JLabel lblStatistics, JPanel pnlContacInfo, JPanel pnlDevice, JPanel pnlEmployee, JPanel pnlForm, JPanel pnlHome, JPanel pnlImage, JPanel pnlMain, JPanel pnlRoom, JPanel pnlService, JPanel pnlSlide, JPanel pnlStatistics, JPanel pnlTitile) throws HeadlessException {
        this.btnLogout = btnLogout;
        this.jLabel1 = jLabel1;
        this.jLabel15 = jLabel15;
        this.jLabel16 = jLabel16;
        this.jLabel17 = jLabel17;
        this.jLabel18 = jLabel18;
        this.jLabel19 = jLabel19;
        this.jLabel2 = jLabel2;
        this.jLabel20 = jLabel20;
        this.jLabel21 = jLabel21;
        this.jLabel22 = jLabel22;
        this.jLabel29 = jLabel29;
        this.jPanel11 = jPanel11;
        this.lblContactInfo = lblContactInfo;
        this.lblDevice = lblDevice;
        this.lblEmployee = lblEmployee;
        this.lblHome = lblHome;
        this.lblRoom = lblRoom;
        this.lblService = lblService;
        this.lblStatistics = lblStatistics;
        this.pnlContacInfo = pnlContacInfo;
        this.pnlDevice = pnlDevice;
        this.pnlEmployee = pnlEmployee;
        this.pnlForm = pnlForm;
        this.pnlHome = pnlHome;
        this.pnlImage = pnlImage;
        this.pnlMain = pnlMain;
        this.pnlRoom = pnlRoom;
        this.pnlService = pnlService;
        this.pnlSlide = pnlSlide;
        this.pnlStatistics = pnlStatistics;
        this.pnlTitile = pnlTitile;
    }

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
            java.util.logging.Logger.getLogger(MainManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JLabel lblContactInfo;
    private javax.swing.JLabel lblDevice;
    private javax.swing.JLabel lblEmployee;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblService;
    private javax.swing.JLabel lblStatistics;
    private javax.swing.JPanel pnlContacInfo;
    private javax.swing.JPanel pnlDevice;
    private javax.swing.JPanel pnlEmployee;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlImage;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRoom;
    private javax.swing.JPanel pnlService;
    private javax.swing.JPanel pnlSlide;
    private javax.swing.JPanel pnlStatistics;
    private javax.swing.JPanel pnlTitile;
    // End of variables declaration//GEN-END:variables
}
