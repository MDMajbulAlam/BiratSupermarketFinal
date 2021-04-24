/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;

import admin.ui.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


public class MyDesktopPane extends JDesktopPane {

    Image backImage;

    public MyDesktopPane() {
        try {
            backImage = new ImageIcon(getClass().getResource("/admin/ui/ccc.jpeg")).getImage();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (backImage != null) {
            g.drawImage(backImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
