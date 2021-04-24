/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.ui;

import Operations.Checks;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.MemberInfoDAO;
import model.to.MemberInfoTO;

/**
 *
 * @author DELL
 */
public class SearchByMName extends javax.swing.JInternalFrame {

    /**
     * Creates new form SearchByMName
     */
        public SearchByMName(){
        initComponents();
        clearTable();
         
 }
        private void clearTable(){
         String[] columnNames = {"Member ID", "Member Name", "Address", "DOB", "Contact NO", "Fee", "Start Date"};
        Object[][] data = null;

        
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableMemberInfo.setModel(dtm);   
        }
      
    private void bindMemberInfo(String MName) {
        List<MemberInfoTO>   allmember = new MemberInfoDAO().getAllRecord(MName);
        String[] columnNames = {"Member ID", "Member Name", "Address", "DOB", "Contact NO", "Fee", "Start Date"};
        Object[][] data = null;

        if (allmember != null && allmember.size() > 0) {
            data = new Object[allmember.size()][columnNames.length];
            int i = 0;
            for (MemberInfoTO mit : allmember) {
                data[i] = new Object[]{mit.getMemberID(), mit.getMemberName(), mit.getAddress(), mit.getDOB(), mit.getContactNo(), mit.getFee(), mit.getStartDate()};
                i++;
            }

        } else {
            data = new Object[1][columnNames.length];
            data[0] = new Object[]{"There Is no Record", "There is No Record", "There is No Record", "There is No Record", "There is No Record", "There is No Record", "There is No Record"};

        }
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableMemberInfo.setModel(dtm);
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jtfMName = new javax.swing.JTextField();
        btnSearchResult = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMemberInfo = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);

        jtfMName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMNameActionPerformed(evt);
            }
        });
        jtfMName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMNameKeyTyped(evt);
            }
        });

        btnSearchResult.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearchResult.setText("Search Result");
        btnSearchResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchResultActionPerformed(evt);
            }
        });

        tableMemberInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableMemberInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jtfMName, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearchResult, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchResult, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jtfMName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfMNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMNameActionPerformed
        
    }//GEN-LAST:event_jtfMNameActionPerformed

    private void btnSearchResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchResultActionPerformed
       String value=jtfMName.getText().trim();
       if(Checks.isEmpty(value)){
           JOptionPane.showMessageDialog(this, "Fill Any Value");
       }else{
          bindMemberInfo(value);
       }
    }//GEN-LAST:event_btnSearchResultActionPerformed

    private void jtfMNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMNameKeyTyped
         String value=jtfMName.getText().trim();
         if(Checks.isEmpty(value)){
             clearTable();
             
         }else{
              bindMemberInfo(value); 
         }
    }//GEN-LAST:event_jtfMNameKeyTyped

    private void jtfMNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMNameKeyReleased
       String value=jtfMName.getText().trim();
         if(Checks.isEmpty(value)){
             clearTable();
             
         }else{
              bindMemberInfo(value); 
         }
    }//GEN-LAST:event_jtfMNameKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchResult;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtfMName;
    private javax.swing.JTable tableMemberInfo;
    // End of variables declaration//GEN-END:variables
}