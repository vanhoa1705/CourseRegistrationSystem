package components;

import DAO.GiaoVuDAO;
import hibernate.GiaovuEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author HoaNguyen
 */
public class DanhSachGiaoVu extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form DSGiaoVu
     */
    public DanhSachGiaoVu() {
        initComponents();

        updateTable();

        //add popup menu
        popupMenu = new JPopupMenu();
        menuItemResetPassword = new JMenuItem("Reset password");
        menuItemChangeProfile = new JMenuItem("Change profile");
        menuItemDelete = new JMenuItem("Delete");

        menuItemResetPassword.addActionListener(this);
        menuItemChangeProfile.addActionListener(this);
        menuItemDelete.addActionListener(this);

        popupMenu.add(menuItemResetPassword);
        popupMenu.add(menuItemChangeProfile);
        popupMenu.add(menuItemDelete);

        tableGiaoVu.setComponentPopupMenu(popupMenu);
        tableGiaoVu.addMouseListener(new TableMouseListener(tableGiaoVu));

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
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGiaoVu = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Danh sách giáo vụ");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tableGiaoVu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableGiaoVu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(284, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(252, 252, 252))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAdd)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSearch))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = txtSearch.getText();
        giaovu = GiaoVuDAO.searchGiaoVu(keyword);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tableGiaoVu.setModel(defaultTableModel);
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Mã giáo vụ");
        defaultTableModel.addColumn("Họ tên");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Ngày sinh");
        defaultTableModel.addColumn("Địa chỉ");

        for(GiaovuEntity gv: giaovu){
            Object[] temp = new Object[]{gv.getId(), gv.getMaGiaoVu(), gv.getTenGiaoVu(), gv.getGioiTinh(), gv.getNgaySinh(), gv.getDiaChi()};
            defaultTableModel.addRow(temp);
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt){
        JFrame frame = new CreateAccountGV();
        frame.setTitle("Create Account");
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
            java.util.logging.Logger.getLogger(DanhSachGiaoVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachGiaoVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachGiaoVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachGiaoVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == menuItemResetPassword) {
            resetPasswordCurrentRow();
        }else if(menu == menuItemChangeProfile){
            changeProfileCurrentRow();
        } else if (menu == menuItemDelete) {
            deleteCurrentRowRows();
        }
    }

    private void changeProfileCurrentRow() {
        int selectedRow = tableGiaoVu.getSelectedRow();
        GiaovuEntity selected = giaovu.get(selectedRow);
        JFrame frame = new ChangeProfile(selected.getId(), selected.getTenGiaoVu(), selected.getGioiTinh(), selected.getNgaySinh(), selected.getDiaChi(), true);
        frame.setTitle("Change profile");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void resetPasswordCurrentRow() {
        int selectedRow = tableGiaoVu.getSelectedRow();
        GiaovuEntity selected = giaovu.get(selectedRow);
        int result = GiaoVuDAO.changePasswordGiaoVu(selected.getId(), selected.getMaGiaoVu());
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Reset thanh cong");
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Reset khong thanh cong");
        }
    }

    private void deleteCurrentRowRows() {
        int selectedRow = tableGiaoVu.getSelectedRow();
        int result = GiaoVuDAO.deleteGiaoVu(giaovu.get(selectedRow).getId());
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Xoa thanh cong");
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Xoa khong thanh cong");
        }
    }

    private void updateTable(){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tableGiaoVu.setModel(defaultTableModel);
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Mã giáo vụ");
        defaultTableModel.addColumn("Họ tên");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Ngày sinh");
        defaultTableModel.addColumn("Địa chỉ");

        giaovu = GiaoVuDAO.searchGiaoVu("");
        for(GiaovuEntity gv: giaovu){
            Object[] temp = new Object[]{gv.getId(), gv.getMaGiaoVu(), gv.getTenGiaoVu(), gv.getGioiTinh(), gv.getNgaySinh(), gv.getDiaChi()};
            defaultTableModel.addRow(temp);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableGiaoVu;
    private javax.swing.JTextField txtSearch;
    private JPopupMenu popupMenu;

    private JMenuItem menuItemResetPassword;
    private JMenuItem menuItemChangeProfile;
    private JMenuItem menuItemDelete;


    private List<GiaovuEntity> giaovu;
}


