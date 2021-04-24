/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.ui;

import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class UserNewScreen extends javax.swing.JFrame {

    /**
     * Creates new form UserNewScreen
     */
    public UserNewScreen() {
          setIconImage(new ImageIcon(getClass().getResource("/user/ui/book.jpg")).getImage());
            initComponents();
            setSize(800,500);
            setLocationRelativeTo(null);
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myDesktopPane1 = new user.ui.MyDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jmiSearchMember = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(myDesktopPane1, java.awt.BorderLayout.CENTER);

        jMenu3.setText("Search Data");

        jmiSearchMember.setText("Search By MemberName");
        jmiSearchMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSearchMemberActionPerformed(evt);
            }
        });
        jMenu3.add(jmiSearchMember);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiSearchMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSearchMemberActionPerformed
        SearchByMName sbmn=new SearchByMName();
        sbmn.setVisible(true);
        myDesktopPane1.add(sbmn);
    }//GEN-LAST:event_jmiSearchMemberActionPerformed

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
            java.util.logging.Logger.getLogger(UserNewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserNewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserNewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserNewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserNewScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmiSearchMember;
    private user.ui.MyDesktopPane myDesktopPane1;
    // End of variables declaration//GEN-END:variables
}