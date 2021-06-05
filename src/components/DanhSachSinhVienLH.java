package components;

import DAO.GiaoVuDAO;
import DAO.HocPhanDAO;
import DAO.MonHocDAO;
import DAO.SinhVienDAO;
import hibernate.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DanhSachSinhVienLH extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form DanhSachSinhVienLH
     */
    private LophocEntity lophoc;
    public DanhSachSinhVienLH(LophocEntity lophoc) {
        initComponents();
        this.lophoc = lophoc;
        updateTableSinhVien();

        //add popup menu
        popupMenu = new JPopupMenu();
        menuItemView = new JMenuItem("Xem danh sách");
        menuItemUpdateProfile = new JMenuItem("Update Profile");
        menuItemResetPassword = new JMenuItem("Reset Password");

        menuItemView.addActionListener(this);
        menuItemUpdateProfile.addActionListener(this);
        menuItemResetPassword.addActionListener(this);

        popupMenu.add(menuItemView);
        popupMenu.add(menuItemUpdateProfile);
        popupMenu.add(menuItemResetPassword);

        tableSinhVien.setComponentPopupMenu(popupMenu);
        tableSinhVien.addMouseListener(new TableMouseListener(tableSinhVien));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHocPhan = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSinhVien = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 640));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tableHocPhan);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Danh sách sinh viên");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tableSinhVien.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "ID", "Mã giáo vụ", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableSinhVien);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Danh sách học phần");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSearch)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAdd))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(252, 252, 252))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAdd)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtSearch)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>


    @Override
    public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == menuItemView) {
            viewCurrentRow();
        }else if(menu == menuItemUpdateProfile){
            changeProfileCurrentRow();
        }else if(menu == menuItemResetPassword){
            resetPassword();
        }
    }

    private void viewCurrentRow(){
        int selectedRow = tableSinhVien.getSelectedRow();
        updateTableHocPhan(sinhvien.get(selectedRow));
    }

    private void resetPassword(){
        int selectedRow = tableSinhVien.getSelectedRow();
        SinhvienEntity selected = sinhvien.get(selectedRow);
        int result = SinhVienDAO.ChangePassword(selected.getId(), selected.getMaSinhVien());
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Reset mật khẩu thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Reset mật khẩu không thành công");
        }
    }

    private void changeProfileCurrentRow() {
        int selectedRow = tableSinhVien.getSelectedRow();
        SinhvienEntity selected = sinhvien.get(selectedRow);
        JFrame frame = new ChangeProfile(selected.getId(), selected.getTenSinhVien(), selected.getGioiTinh(), selected.getNgaySinh(), selected.getDiaChi(), false);
        frame.setTitle("Change profile");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        tableSinhVien.clearSelection();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tableSinhVien.setModel(defaultTableModel);
        defaultTableModel.addColumn("MSSV");
        defaultTableModel.addColumn("Họ tên");
        defaultTableModel.addColumn("Ngày sinh");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Địa chỉ");
        this.sinhvien = SinhVienDAO.getStudentByClass(this.lophoc, txtSearch.getText());
        if(this.sinhvien.isEmpty()){
            Object[] temp = new Object[]{null, null, null, null, null};
            defaultTableModel.addRow(temp);
            return;
        }
        for (SinhvienEntity sv: this.sinhvien){
            Object[] temp = new Object[]{sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getNgaySinh(), sv.getGioiTinh(), sv.getDiaChi()};
            defaultTableModel.addRow(temp);
        }
        return;

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
            java.util.logging.Logger.getLogger(DanhSachSinhVienLH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachSinhVienLH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachSinhVienLH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachSinhVienLH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    private void updateTableSinhVien(){
        tableSinhVien.clearSelection();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tableSinhVien.setModel(defaultTableModel);
        defaultTableModel.addColumn("MSSV");
        defaultTableModel.addColumn("Họ tên");
        defaultTableModel.addColumn("Ngày sinh");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Địa chỉ");
        this.sinhvien = SinhVienDAO.getStudentByClass(this.lophoc, "");
        for (SinhvienEntity sv: this.sinhvien){
            Object[] temp = new Object[]{sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getNgaySinh(), sv.getGioiTinh(), sv.getDiaChi()};
            defaultTableModel.addRow(temp);
        }
    }

    private void updateTableHocPhan(SinhvienEntity sinhvien){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tableHocPhan.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã môn học");
        defaultTableModel.addColumn("Tên môn học");
        defaultTableModel.addColumn("Số TC");
        defaultTableModel.addColumn("Giáo viên");
        defaultTableModel.addColumn("Phòng");
        defaultTableModel.addColumn("Thời gian");
        defaultTableModel.addColumn("Ca");
        defaultTableModel.addColumn("Slot");

        List<SinhvienHocphanEntity> sinhvienhocphan = HocPhanDAO.getHocPhanBySV(sinhvien);

        for(SinhvienHocphanEntity svhp: sinhvienhocphan){
            Object[] temp = new Object[]{svhp.getHocphanmo().getMonhoc().getMaMonHoc(), svhp.getHocphanmo().getTenHocPhan(), svhp.getHocphanmo().getMonhoc().getSoTinChi(), MonHocDAO.getTeacherByCode(svhp.getHocphanmo().getMaGvlt()),  svhp.getHocphanmo().getTenPhongHoc(), svhp.getHocphanmo().getThu(), svhp.getHocphanmo().getCa(), svhp.getHocphanmo().getDaDangKi() + "/" + svhp.getHocphanmo().getSoLuong()};
            defaultTableModel.addRow(temp);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableHocPhan;
    private javax.swing.JTable tableSinhVien;
    private javax.swing.JTextField txtSearch;
    private JPopupMenu popupMenu;

    private JMenuItem menuItemView;
    private JMenuItem menuItemUpdateProfile;
    private JMenuItem menuItemResetPassword;

    // End of variables declaration

    private List<SinhvienEntity> sinhvien;
}
