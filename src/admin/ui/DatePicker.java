package admin.ui;


import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class DatePicker extends javax.swing.JPanel {

    GregorianCalendar gcal;

    public DatePicker() {
        initComponents();
        gcal = new GregorianCalendar();
        jcbYear.removeAllItems();        
        jcbYear.addItem("Year");
        int currentyear = gcal.get(Calendar.YEAR);
        for (int year = currentyear; year >= currentyear - 20; year--) {
            jcbYear.addItem(year);

        }

    }

    public Date getSelectedDate() {
        Date date = null;
        try {
            if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0 && jcbDate.getSelectedIndex() > 0) {
                int Year = Integer.parseInt(jcbYear.getSelectedItem().toString());
                int month = jcbMonth.getSelectedIndex();
                int dat = jcbDate.getSelectedIndex();
                String datevalue = Year + "-" + month + "-" + dat;
                date = Date.valueOf(datevalue);
            }
        } catch (IllegalArgumentException ex) {
        }
        return date;
    }

    public void setDate(Date date) {
        try {
            String datevalue = date.toString();
            System.out.println("datevalue");
            String[] values = datevalue.split("-");
            int Year = Integer.parseInt(values[0]);
            int month = Integer.parseInt(values[1]);
            int dat = Integer.parseInt(values[2]);
            for (int i = 1; i < jcbYear.getItemCount(); i++) {
                int syear = Integer.parseInt(jcbYear.getItemAt(i).toString());
                if (syear == Year) {
                    jcbYear.setSelectedIndex(i);
                    break;
                }
            }
            jcbMonth.setSelectedIndex(month);
            jcbDate.setSelectedIndex(dat);
        } catch (Exception ex) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbMonth = new javax.swing.JComboBox();
        jcbYear = new javax.swing.JComboBox();
        jcbDate = new javax.swing.JComboBox();

        jcbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMonthItemStateChanged(evt);
            }
        });

        jcbYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbYearItemStateChanged(evt);
            }
        });
        jcbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbYearActionPerformed(evt);
            }
        });

        jcbDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDateActionPerformed

    private void jcbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbYearActionPerformed

    private void jcbYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYearItemStateChanged
        int Monthindex = jcbMonth.getSelectedIndex();
        int Dateindex = jcbDate.getSelectedIndex();
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        if (jcbYear.getSelectedIndex() > 0) {
            MonthName[] allmonths = MonthName.values();
            int IndexRange = allmonths.length - 1;
            int SelectedYear = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int currentyear = gcal.get(Calendar.YEAR);
            if (SelectedYear == currentyear) {
                IndexRange = gcal.get(Calendar.MONTH);
            }
            for (int i = 0; i <= IndexRange; i++) {
                jcbMonth.addItem(allmonths[i]);
            }
            if (Monthindex < jcbMonth.getItemCount()) {
                jcbMonth.setSelectedIndex(Monthindex);
            }
            if (Dateindex < jcbDate.getItemCount()) {
                jcbDate.setSelectedIndex(Dateindex);
            }
        }
    }//GEN-LAST:event_jcbYearItemStateChanged
    
    private void jcbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMonthItemStateChanged
        int Dateindex = jcbDate.getSelectedIndex();
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0) {
            int SelectedYear = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int currentyear = gcal.get(Calendar.YEAR);
            int currentmonth = gcal.get(Calendar.MONTH);
            MonthName selectedmonth = MonthName.valueOf(jcbMonth.getSelectedItem().toString());
            int daterange = 31;
            if (currentmonth == selectedmonth.ordinal() && currentyear == SelectedYear) {
                daterange = gcal.get(Calendar.DATE);
            } else {
                switch (selectedmonth) {
                    case April:
                    case June:
                    case September:
                    case November:
                        daterange = 30;
                        break;
                    case February:
                        daterange = gcal.isLeapYear(SelectedYear) ? 29 : 28;
                        break;

                }
            }
            for (int i = 1; i <= daterange; i++) {
                jcbDate.addItem(i);
            }
            if (Dateindex < jcbDate.getItemCount()) {
                jcbDate.setSelectedIndex(Dateindex);
            }
        }
    }//GEN-LAST:event_jcbMonthItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jcbDate;
    private javax.swing.JComboBox jcbMonth;
    private javax.swing.JComboBox jcbYear;
    // End of variables declaration//GEN-END:variables
}
