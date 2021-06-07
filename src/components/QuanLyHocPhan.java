package components;

import DAO.HocKiDAO;
import DAO.HocPhanDAO;
import DAO.LopHocDAO;
import DAO.MonHocDAO;
import hibernate.HockiEntity;
import hibernate.HocphanmoEntity;
import hibernate.MonhocEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuanLyHocPhan extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form DSGiaoVu
     */
    public QuanLyHocPhan() {
        initComponents();

        updateTable();

        //add popup menu
        popupMenu = new JPopupMenu();
        menuItemView = new JMenuItem("Xem danh sách");
        menuItemDelete = new JMenuItem("Delete");

        menuItemView.addActionListener(this);
        menuItemDelete.addActionListener(this);

        popupMenu.add(menuItemView);
        popupMenu.add(menuItemDelete);

        tableHocPhan.setComponentPopupMenu(popupMenu);
        tableHocPhan.addMouseListener(new TableMouseListener(tableHocPhan));
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
        tableHocPhan = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Quản lý học phần");

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

        tableHocPhan.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null, null},
                },
                new String [] {
                        "ID", "Mã môn học", "Tên môn học", "Số TC", "Giáo viên", "Phòng", "Thời gian", "Ca", "Slot"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableHocPhan);

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

    @Override
    public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == menuItemDelete) {
            deleteCurrentRow();
        }else if(menu == menuItemView){
            viewDSDK();
        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        HocKiDAO.getCurrentHK();

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

        this.hocphan = new ArrayList<HocphanmoEntity>();

        for(HocphanmoEntity hp: Global.currentHocKy.getHocphanmoSet()){
            if(hp.getTenHocPhan().toUpperCase().contains(txtSearch.getText().toUpperCase())){
                Object[] temp = new Object[]{hp.getMonhoc().getMaMonHoc(), hp.getTenHocPhan(), hp.getMonhoc().getSoTinChi(), MonHocDAO.getTeacherByCode(hp.getMaGvlt()),  hp.getTenPhongHoc(), hp.getThu(), hp.getCa(), hp.getDaDangKi() + "/" + hp.getSoLuong()};
                defaultTableModel.addRow(temp);
                hocphan.add(hp);
            }
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new CreateHocPhan();
        frame.setTitle("Thêm học phần");
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
            java.util.logging.Logger.getLogger(QuanLyHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    private void updateTable(){
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

        this.hocphan = Global.currentHocKy.getHocphanmoSet().stream().toList();
        for(HocphanmoEntity hp: this.hocphan){
            Object[] temp = new Object[]{hp.getMonhoc().getMaMonHoc(), hp.getTenHocPhan(), hp.getMonhoc().getSoTinChi(), MonHocDAO.getTeacherByCode(hp.getMaGvlt()) , hp.getTenPhongHoc(), hp.getThu(), hp.getCa(), hp.getDaDangKi()+"/"+hp.getSoLuong()};
            defaultTableModel.addRow(temp);
        }
    }

    private void viewDSDK() {
        int selectedRow = tableHocPhan.getSelectedRow();
        JFrame frame = new DanhSachSinhVien(hocphan.get(selectedRow));
        frame.setTitle("Danh sách sinh viên");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void deleteCurrentRow(){
        int selectedRow = tableHocPhan.getSelectedRow();
        int result = HocPhanDAO.deleteHocPhan(hocphan.get(selectedRow));
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Xoa thanh cong");
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Xoa khong thanh cong");
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHocPhan;
    private javax.swing.JTextField txtSearch;
    private JPopupMenu popupMenu;

    private JMenuItem menuItemDelete;
    private JMenuItem menuItemView;
    // End of variables declaration

    private List<HocphanmoEntity> hocphan;

}

