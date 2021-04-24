/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.dao.BookInfoDAO;
import model.dao.BookIssueDAO;
import model.to.BookIssueTO;

/**
 *
 * @author DELL
 */
public class ViewBookIssue extends javax.swing.JInternalFrame {

    List<BookIssueTO> allbooki;
    JPopupMenu popupMenu;
    int IssueID;

    public ViewBookIssue() {
        initComponents();
        bindBookIssue();
        popupMenu = new JPopupMenu();
        JMenuItem jmiDelete = new JMenuItem("Delete This Record");
         JMenuItem jmiReturnBook = new JMenuItem("Return The Book");
        popupMenu.add(jmiDelete);
        popupMenu.add(jmiReturnBook);
        jmiDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });
        jmiReturnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnbookRecord();
            }
        });
    }

    private void returnbookRecord() {
       if(IssueID!=0 && allbooki!=null && allbooki.size()>0){
         ReturnBookInfo rbi=new ReturnBookInfo(IssueID);
          rbi.setVisible(true);
        getDesktopPane().add(rbi);
        try{
          rbi.setSelected(true);
        }catch(PropertyVetoException ex){
        }
        dispose();
        }   
    }

    private void deleteRecord() {
        if (IssueID != 0 && allbooki != null && allbooki.size() > 0) {
            int selection = JOptionPane.showConfirmDialog(this, "Are You Sure To Delete This Record", "Message From System", JOptionPane.YES_NO_OPTION);
            if (selection == JOptionPane.YES_OPTION) {
                String message = "";
                BookIssueDAO action = new BookIssueDAO();
                if (action.deleteRecord(IssueID)) {
                    message = "BookIssue   Is Deleted From The System";
                    bindBookIssue();
                } else {
                    message = action.getErrorMessage();
                }
                JOptionPane.showMessageDialog(this, message);
                IssueID = 0;

            }
        }
    }

    private void bindBookIssue() {
        allbooki = new BookIssueDAO().getAllRecord();
        String[] columnNames = {"Issue ID", "MemberID", "BookID", "NoOfDays", "BookDate"};
        Object[][] data = null;

        if (allbooki != null && allbooki.size() > 0) {
            data = new Object[allbooki.size()][columnNames.length];
            int i = 0;
            for (BookIssueTO biit : allbooki) {
                data[i] = new Object[]{biit.getIssueID(), biit.getMemberID(), biit.getBookID(), biit.getNoOfDays(), biit.getBookDate()};
                i++;
            }

        } else {
            data = new Object[1][columnNames.length];
            data[0] = new Object[]{"There is No Record" , "There is No Record", "There is No Record", "There is No Record", "There is No Record"};

        }
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableBookIssue.setAutoCreateRowSorter(true);
        tableBookIssue.getTableHeader().setReorderingAllowed(false);
        tableBookIssue.setModel(dtm);

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
        tableBookIssue = new javax.swing.JTable();
        btnRefreshBookIssue = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Book Info");

        tableBookIssue.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBookIssue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBookIssueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBookIssue);

        btnRefreshBookIssue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/ui/r2.png"))); // NOI18N
        btnRefreshBookIssue.setText("Refresh");
        btnRefreshBookIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshBookIssueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(btnRefreshBookIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefreshBookIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableBookIssueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBookIssueMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            int rowpos = tableBookIssue.rowAtPoint(evt.getPoint());
            tableBookIssue.getSelectionModel().setSelectionInterval(rowpos, rowpos);
            popupMenu.show(tableBookIssue, evt.getX(), evt.getY());
            IssueID = Integer.parseInt(tableBookIssue.getValueAt(tableBookIssue.getSelectedRow(), 0).toString());
            System.out.println(IssueID);
        }
    }//GEN-LAST:event_tableBookIssueMouseClicked

    private void btnRefreshBookIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshBookIssueActionPerformed
        bindBookIssue();
    }//GEN-LAST:event_btnRefreshBookIssueActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefreshBookIssue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBookIssue;
    // End of variables declaration//GEN-END:variables
}