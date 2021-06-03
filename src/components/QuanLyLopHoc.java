package components;

import DAO.HocKiDAO;
import DAO.LopHocDAO;
import DAO.MonHocDAO;
import DAO.SinhVienDAO;
import hibernate.LophocEntity;
import hibernate.MonhocEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QuanLyLopHoc extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form DSGiaoVu
     */
    public QuanLyLopHoc() {
        initComponents();

        updateTable();

        //add popup menu
        popupMenu = new JPopupMenu();
        menuItemView = new JMenuItem("view");
        menuItemDelete = new JMenuItem("Delete");

        menuItemView.addActionListener(this);
        menuItemDelete.addActionListener(this);

        popupMenu.add(menuItemView);
        popupMenu.add(menuItemDelete);

        tableLopHoc.setComponentPopupMenu(popupMenu);
        tableLopHoc.addMouseListener(new TableMouseListener(tableLopHoc));
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
        tableLopHoc = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Danh sách lớp học");

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

        tableLopHoc.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "ID", "Tên lớp", "Số học sinh", "Số nam", "Số nữ", "Mã GVCN"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableLopHoc);

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
            deleteCurrentRowRows();
        }else if(menu == menuItemView){
            viewCurrentRowRows();
        }
    }

    private void viewCurrentRowRows() {
        int selectedRow = tableLopHoc.getSelectedRow();
        System.out.println(lophoc.get(selectedRow));
    }

    private void deleteCurrentRowRows() {
        int selectedRow = tableLopHoc.getSelectedRow();
        int result = LopHocDAO.deleteLopHoc(lophoc.get(selectedRow));
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Xoa thanh cong");
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Xoa khong thanh cong");
        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = txtSearch.getText();
        lophoc = LopHocDAO.searchLopHoc(keyword);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tableLopHoc.setModel(defaultTableModel);
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Tên lớp");
        defaultTableModel.addColumn("Số học sinh");
        defaultTableModel.addColumn("Số nam");
        defaultTableModel.addColumn("Số nữ");
        defaultTableModel.addColumn("Mã GVCN");
        for(LophocEntity lh: lophoc){
            int [] gender = SinhVienDAO.countGender(lh.getId());
            Object[] temp = new Object[]{lh.getId(), lh.getTenLop(), gender[0] + gender[1], gender[0], gender[1], lh.getMaGvcn()};
            defaultTableModel.addRow(temp);
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new CreateClass();
        frame.setTitle("Create class");
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
            java.util.logging.Logger.getLogger(QuanLyLopHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyLopHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyLopHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyLopHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    private void updateTable(){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tableLopHoc.setModel(defaultTableModel);
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Tên lớp");
        defaultTableModel.addColumn("Số học sinh");
        defaultTableModel.addColumn("Số nam");
        defaultTableModel.addColumn("Số nữ");
        defaultTableModel.addColumn("Mã GVCN");
        lophoc = LopHocDAO.searchLopHoc("");
        for(LophocEntity lh: lophoc){
            int [] gender = SinhVienDAO.countGender(lh.getId());
            Object[] temp = new Object[]{lh.getId(), lh.getTenLop(), gender[0] + gender[1], gender[0], gender[1], lh.getMaGvcn()};
            defaultTableModel.addRow(temp);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableLopHoc;
    private javax.swing.JTextField txtSearch;
    private JPopupMenu popupMenu;

    private JMenuItem menuItemDelete;
    private JMenuItem menuItemView;
    // End of variables declaration

    private List<LophocEntity> lophoc;
}
