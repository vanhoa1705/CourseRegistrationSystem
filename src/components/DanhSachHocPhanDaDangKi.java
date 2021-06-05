package components;


import DAO.HocPhanDAO;
import DAO.MonHocDAO;
import hibernate.HocphanmoEntity;
import hibernate.SinhvienHocphanEntity;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DanhSachHocPhanDaDangKi extends javax.swing.JFrame {

    /**
     * Creates new form DanhSachHocPhanDangKi
     */
    public DanhSachHocPhanDaDangKi() {
        initComponents();
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableHocPhan = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(tableHocPhan);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Danh sách học phần đã đăng kí");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(206, 206, 206))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

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
            java.util.logging.Logger.getLogger(DanhSachHocPhanDaDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachHocPhanDaDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachHocPhanDaDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachHocPhanDaDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        List<SinhvienHocphanEntity> svhp = HocPhanDAO.getHocPhanBySV(Global.sinhvien);
        for(SinhvienHocphanEntity hp: svhp){
            Object[] temp = new Object[]{hp.getHocphanmo().getMonhoc().getMaMonHoc(), hp.getHocphanmo().getTenHocPhan(), hp.getHocphanmo().getMonhoc().getSoTinChi(), MonHocDAO.getTeacherByCode(hp.getHocphanmo().getMaGvlt()) , hp.getHocphanmo().getTenPhongHoc(), hp.getHocphanmo().getThu(), hp.getHocphanmo().getCa(), hp.getHocphanmo().getDaDangKi() +"/"+hp.getHocphanmo().getSoLuong()};
            defaultTableModel.addRow(temp);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHocPhan;
    // End of variables declaration
}
