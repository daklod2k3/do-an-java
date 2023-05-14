package GUI;

import BUS.category_BUS;
import DTO.category_DTO;
import assets.Classes.Validate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
public class category_GUI extends javax.swing.JFrame {
    public ArrayList<category_DTO> categoryList = new ArrayList<>();
    DefaultTableModel model;
    category_BUS c = new category_BUS();
    private String current_maLoai;
    private String current_tenLoai;
    public category_GUI() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        getAllCategorys();
    }
    public ArrayList<category_DTO> getAllCategorys() {
        categoryList = c.getAllCategorys();
        // reset lại table
        model.setRowCount(0);
        for(int i=0;i<categoryList.size();i++) {
            String maLoai = categoryList.get(i).getMaLoai();
            String tenLoai = categoryList.get(i).getTenLoai();
            Object []row = {maLoai, tenLoai};
            model.addRow(row);
        }
        jTable1.setModel(model);
        return categoryList;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã loại", "Tên loại"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin loại"));

        jLabel2.setText("Mã Loại");

        jLabel3.setText("Tên Loại");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/plus.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/service.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image/remove.png"))); // NOI18N
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOẠI MẶT HÀNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        jTextField1.setText((String)jTable1.getValueAt(row, 0));
        jTextField2.setText((String)jTable1.getValueAt(row, 1));
        current_maLoai = (String)jTable1.getValueAt(row, 0);
        current_tenLoai = (String)jTable1.getValueAt(row, 1);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String maLoai = jTextField1.getText();
        String tenLoai = jTextField2.getText();
        if(!Validate.ValidateMaLoai(maLoai)) {
            JOptionPane.showMessageDialog(null, "Mã loại sai định dạng! Vui lòng nhập đúng định dạng (Lxx)",
                    "Thông báo",JOptionPane.OK_OPTION);
            return;
        }
        if(!Validate.ValidateName(tenLoai)) {
            JOptionPane.showMessageDialog(null, "Tên loại sai định dạng!",
                    "Thông báo",JOptionPane.OK_OPTION);
            return;
        }
        category_DTO cate = new category_DTO(maLoai,tenLoai);
        String result = c.addCategory(cate);
        JOptionPane.showMessageDialog(null, result,
           "Thông báo",JOptionPane.OK_OPTION);
        if(result.equalsIgnoreCase("Thêm thành công!")) {
            getAllCategorys();
            // load lại danh sách sản phẩm
            product_GUI pGUI = new product_GUI();
            pGUI.loadAll();
        }
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1) {
            String maLoai = jTextField1.getText();
            String tenLoai = jTextField2.getText();
            if(!Validate.ValidateMaLoai(maLoai)) {
                JOptionPane.showMessageDialog(null, "Mã loại sai định dạng! Vui lòng nhập đúng định dạng (Lxx)",
                    "Thông báo",JOptionPane.OK_OPTION);
                return;
            }
            if(!Validate.ValidateName(tenLoai)) {
                JOptionPane.showMessageDialog(null, "Tên loại sai định dạng!",
                        "Thông báo",JOptionPane.OK_OPTION);
                return;
            }
            // kiểm tra trùng mã loại, tên loại trong table 
            int row = 0;
            while (row < jTable1.getRowCount()) {
                if(jTable1.getValueAt(row, 0).toString().equalsIgnoreCase(maLoai) && 
                    !jTable1.getValueAt(row, 0).toString().equalsIgnoreCase(current_maLoai) ||
                    jTable1.getValueAt(row, 1).toString().equalsIgnoreCase(tenLoai) && 
                    !jTable1.getValueAt(row, 1).toString().equalsIgnoreCase(current_tenLoai)) {
                    JOptionPane.showMessageDialog(null, "Mã hoặc tên loại đã tồn tại!",
                        "Thông báo",JOptionPane.OK_OPTION);
                    return;
                }
                row++;
            }
            category_DTO cate = new category_DTO(maLoai,tenLoai);
            String result = c.fixCategory(cate,current_maLoai);
            JOptionPane.showMessageDialog(null, result,
                        "Thông báo",JOptionPane.OK_OPTION);
            if(result.equalsIgnoreCase("Sửa thành công!")) {
                getAllCategorys();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if(row != -1) {
            int a = JOptionPane.showConfirmDialog(null, "Nếu xóa danh mục, các sản phẩm trong "
                    + "đó cũng sẽ bị xóa. Bạn có muốn xóa?","Thông báo",JOptionPane.YES_NO_OPTION);
            if(a == JOptionPane.YES_OPTION) {
                String maLoai = (String)jTable1.getValueAt(row, 0);
                JOptionPane.showMessageDialog(null, c.deleteCategory(maLoai),
                        "Thông báo",JOptionPane.OK_OPTION);
                getAllCategorys();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new category_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
