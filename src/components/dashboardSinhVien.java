package components;

import javax.swing.*;

public class dashboardSinhVien extends javax.swing.JFrame {

    /**
     * Creates new form dashboardSinhVien
     */
    public dashboardSinhVien() {
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
        btnDKHP = new javax.swing.JButton();
        btbDanhSachHocPhanDaDangKi = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        account = new javax.swing.JMenu();
        menuAccount = new javax.swing.JMenuItem();
        menuChangPass = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Danh sách chức năng");

        btnDKHP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDKHP.setText("Đăng kí học phần");
        btnDKHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDKHPActionPerformed(evt);
            }
        });

        btbDanhSachHocPhanDaDangKi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btbDanhSachHocPhanDaDangKi.setText("Danh sách đã đăng kí");
        btbDanhSachHocPhanDaDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachHocPhanDaDangKiActionPerformed(evt);
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

        menuChangPass.setText("Thay đổi mật khẩu");
        menuChangPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChangPasswordActionPerformed(evt);
            }
        });
        account.add(menuChangPass);

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
                                .addContainerGap()
                                .addComponent(btnDKHP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btbDanhSachHocPhanDaDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(btnDKHP)
                                        .addComponent(btbDanhSachHocPhanDaDangKi))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void btnDKHPActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new DangKiHocPhan();
        frame.setTitle("Đăng kí học phần");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void btnDanhSachHocPhanDaDangKiActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new DanhSachHocPhanDaDangKi();
        frame.setTitle("Danh sách học phần đã đăng kí");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void menuAccountActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new ChangeProfile(Global.sinhvien.getId(), Global.sinhvien.getTenSinhVien(), Global.sinhvien.getGioiTinh(), Global.sinhvien.getNgaySinh(), Global.sinhvien.getDiaChi(), false);
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
            java.util.logging.Logger.getLogger(dashboardSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JMenu account;
    private javax.swing.JButton btnDKHP;
    private javax.swing.JButton btbDanhSachHocPhanDaDangKi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuAccount;
    private javax.swing.JMenuItem menuChangPass;
    private javax.swing.JMenuItem menuLogout;
    // End of variables declaration
}
