
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kashmira Lokhande
 */
public class SMI extends javax.swing.JFrame {
    public static int currentTotal = 0;
    public static DefaultTableModel tablemodel;
    /**
     * Creates new form SMI
     */
    public SMI() {
        initComponents();
        tablemodel = (DefaultTableModel) jTable1.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public static void savecurrentSMItoFile(){
        
        if(tablemodel.getRowCount()>0){
            int modulesaddedval = (int) tablemodel.getValueAt(tablemodel.getRowCount()-1, 1);
            int moduleschangedval = (int) tablemodel.getValueAt(tablemodel.getRowCount()-1, 2);
            int modulesdeletedval = (int) tablemodel.getValueAt(tablemodel.getRowCount()-1, 3);
            double SMIval = (double) tablemodel.getValueAt(tablemodel.getRowCount()-1, 0);
            int totalval = (int) tablemodel.getValueAt(tablemodel.getRowCount()-1, 4);
            boolean tabOpen = true;
            SMIData smid = new SMIData(SMIval, modulesaddedval, moduleschangedval, modulesdeletedval, totalval, tabOpen);
            metricsuite.saveSMItofile(smid);
        }
        
        
    }
    public static void setSMIValuesOnOpen(SMIData smid){
        tablemodel.addRow(new Object[]{smid.getSMI() , smid.getModulesAdded(), smid.getModuleChanged(), smid.getModulesDeleted(), smid.getTotalModules()});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Software Maturity Index");
        jLabel1.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SMI", "Modules Added", "Modules Changed", "Modules Deleted", "Total Modules"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDoubleBuffered(true);
        jTable1.setShowHorizontalLines(false);
        jTable1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTable1ComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Add Row");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Compute Index");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        tablemodel.addRow(new Object[]{0.0 , 0, 0, 0, 0});
        double SMIval = 0.0;
        int modulesaddedval = 0;
        int moduleschangedval = 0;
        int modulesdeletedval = 0;
        int totalmodules = currentTotal;
        boolean tabOpen = true;
        SMIData smid = new SMIData(SMIval, modulesaddedval, moduleschangedval, modulesdeletedval, totalmodules, tabOpen);
        metricsuite.saveSMItofile(smid);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (jTable1.isEditing()){
            jTable1.getCellEditor().stopCellEditing();
        }
        int modulesaddedval = (int) tablemodel.getValueAt(tablemodel.getRowCount()-1, 1);
        int moduleschangedval = (int) tablemodel.getValueAt(tablemodel.getRowCount()-1, 2);
        int modulesdeletedval = (int) tablemodel.getValueAt(tablemodel.getRowCount()-1, 3);
        int totalval = currentTotal + modulesaddedval - modulesdeletedval;
        currentTotal = totalval;
        double SMIval = (double)(totalval - (modulesaddedval+moduleschangedval+modulesdeletedval))/totalval;
        tablemodel.setValueAt(SMIval, tablemodel.getRowCount()-1, 0);
        tablemodel.setValueAt(totalval, tablemodel.getRowCount()-1, 4);
//        SMIData smid = new SMIData(SMIval, modulesaddedval, moduleschangedval, modulesdeletedval, totalval);
//        metricsuite.saveSMItofile(smid);
//        savecurrentSMItoFile();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTable1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1ComponentAdded

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
