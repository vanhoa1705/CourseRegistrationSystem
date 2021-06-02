package components;

import hibernate.GiaovuEntity;

import javax.swing.*;

/**
 *
 * @author HoaNguyen
 */
public class dashboardGiaoVu extends javax.swing.JFrame {
    private GiaovuEntity giaovu;
    /**
     * Creates new form LoginFrame
     */
    public dashboardGiaoVu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnDSGiaoVu = new javax.swing.JButton();
        btnQuanLyMonHoc = new javax.swing.JButton();
        btnQuanLyHocKi = new javax.swing.JButton();
        btnQuanLyLopHoc = new javax.swing.JButton();
        btnQuanLyThoiGianDangKi = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        account = new javax.swing.JMenu();
        menuAccount = new javax.swing.JMenuItem();
        menuChangPassword = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Danh sách chức năng");

        btnDSGiaoVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDSGiaoVu.setText("Danh sách giáo vụ");
        btnDSGiaoVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDSGiaoVuActionPerformed(evt);
            }
        });

        btnQuanLyMonHoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuanLyMonHoc.setText("Quản lý môn học");
        btnQuanLyMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyMonHocActionPerformed(evt);
            }
        });

        btnQuanLyHocKi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuanLyHocKi.setText("Quản lý học kì");
        btnQuanLyHocKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyHocKiActionPerformed(evt);
            }
        });

        btnQuanLyLopHoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuanLyLopHoc.setText("Quản lý lớp học");
        btnQuanLyLopHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyLopHocActionPerformed(evt);
            }
        });

        btnQuanLyThoiGianDangKi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuanLyThoiGianDangKi.setText("Quản lý thời gian đăng kí");
        btnQuanLyThoiGianDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyThoiGianDangKiActionPerformed(evt);
            }
        });

        account.setText("Tài khoản");

        menuAccount.setText("Thông tin tài khoản");
        menuAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAccountActionPerformed(evt);
            }
        });
        account.add(menuAccount);

        menuChangPassword.setText("Thay đổi mật khẩu");
        menuChangPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChangPasswordActionPerformed(evt);
            }
        });
        account.add(menuChangPassword);

        menuLogout.setText("Đăng xuất");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        account.add(menuLogout);

        jMenuBar1.add(account);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnQuanLyThoiGianDangKi))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnQuanLyMonHoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnDSGiaoVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(63, 63, 63)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(btnQuanLyLopHoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnQuanLyHocKi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnDSGiaoVu)
                                        .addComponent(btnQuanLyHocKi))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnQuanLyMonHoc)
                                        .addComponent(btnQuanLyLopHoc))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnQuanLyThoiGianDangKi)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void btnDSGiaoVuActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new DanhSachGiaoVu();
        frame.setTitle("Danh sách giáo vụ");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void btnQuanLyMonHocActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new QuanLyMonHoc();
        frame.setTitle("Quản lý môn học");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void btnQuanLyHocKiActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new QuanLyHocKi();
        frame.setTitle("Quản lý học kì");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void btnQuanLyLopHocActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnQuanLyThoiGianDangKiActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void menuAccountActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new ChangeProfile(Global.giaovu.getId(), Global.giaovu.getTenGiaoVu(), Global.giaovu.getGioiTinh(), Global.giaovu.getNgaySinh(), Global.giaovu.getDiaChi(), true);
        frame.setTitle("Cập nhật thông tin");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void menuChangPasswordActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new ChangePassword();
        frame.setTitle("Thay đổi mật khẩu");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        JFrame frame = new Login();
        frame.setTitle("Login");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
            java.util.logging.Logger.getLogger(dashboardGiaoVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardGiaoVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardGiaoVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardGiaoVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify
    private javax.swing.JMenu account;
    private javax.swing.JButton btnDSGiaoVu;
    private javax.swing.JButton btnQuanLyHocKi;
    private javax.swing.JButton btnQuanLyLopHoc;
    private javax.swing.JButton btnQuanLyMonHoc;
    private javax.swing.JButton btnQuanLyThoiGianDangKi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuAccount;
    private javax.swing.JMenuItem menuChangPassword;
    private javax.swing.JMenuItem menuLogout;
    // End of variables declaration
}
