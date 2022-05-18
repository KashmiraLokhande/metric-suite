

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kashmira Lokhande
 */
public class metricsuite extends javax.swing.JFrame {
   public  static String projname;
   public  static String newfpname;
   public static ArrayList<projectData> project;
   public static ArrayList<FPdata> fp; 
   public static ArrayList<UCPdata> ucp;
   public static ArrayList<SMIData> smi;
   public static boolean SMICreated = false;
   public static DefaultTreeModel model;
    /**
     * Creates new form metricsuite
     */
    public metricsuite() {
        initComponents();
        project = new ArrayList<projectData>();
        fp = new  ArrayList<FPdata>();
        ucp = new ArrayList<UCPdata>();
        smi = new ArrayList<SMIData>();
        model = (DefaultTreeModel)jTree1.getModel();
        this.setTitle("CECSE 543 Metric Suite project");
    }
    
    public static boolean checkproject(){
        if(projname == null){
            
            return true;
        }
        else 
            return false;
    }

    public static void fetchprojdetails(){
        try{
            project.clear();
            //System.out.println("Inside fetchprojdetails "+projname);
            FileInputStream file23 = new FileInputStream(projname+".ms");
            ObjectInputStream inputFile23 = new ObjectInputStream(file23);
            boolean endofFile = false;
            while(!endofFile){
                   try{
                        project.add((projectData) inputFile23.readObject());
                   }
                   catch(EOFException e){
                       endofFile = true;
                   }
                   catch(Exception f){
                        JOptionPane.showMessageDialog(null, f.getMessage());
                   }
            }
            inputFile23.close();
            
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(Exception k){
                        JOptionPane.showMessageDialog(null, k.getMessage());
                   }

    }
    public  static void fetchFPdetails(){
        try{
            fp.clear();
            //System.out.println("Inside fetchFPdetails" + project.get(0).getFPDataFile());
            FileInputStream file12 = new FileInputStream(project.get(0).getFPDataFile());
            ObjectInputStream inputFile12 = new ObjectInputStream(file12);
            boolean endofFile = false;
            while(!endofFile){
                   try{
                        fp.add((FPdata) inputFile12.readObject());
                   }
                   catch(EOFException e){
                       endofFile = true;
                   }
                   catch(Exception f){
                        //JOptionPane.showMessageDialog(null, f.getMessage());
                   }
            }
            inputFile12.close();
        }
        catch(IOException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(Exception k){
            //JOptionPane.showMessageDialog(null, k.getMessage());
                   }
        
    }
        public static void fetchUCPdetails(){
        try{
            ucp.clear();
            //System.out.println("Inside fetchUCPdetails" + project.get(0).getUCPDataFile());
            FileInputStream file13 = new FileInputStream(project.get(0).getUCPDataFile());
            ObjectInputStream inputFile13 = new ObjectInputStream(file13);
            boolean endofFile = false;
            while(!endofFile){
                   try{
                        ucp.add((UCPdata) inputFile13.readObject());
                   }
                   catch(EOFException e){
                       endofFile = true;
                   }
                   catch(Exception f){
                       // JOptionPane.showMessageDialog(null, f.getMessage());
                   }
            }
            inputFile13.close();
        }
        catch(IOException e){     
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(Exception k){
//                        JOptionPane.showMessageDialog(null, k.getMessage());
                   }
        
    }
        public static void fetchSMIdetails(){
        try{
            smi.clear();
            FileInputStream file14 = new FileInputStream(project.get(0).getSMIDataFile());
            ObjectInputStream inputFile14 = new ObjectInputStream(file14);
            boolean endofFile = false;
            while(!endofFile){
                   try{
                        smi.add((SMIData) inputFile14.readObject());
                   }
                   catch(EOFException e){
                       endofFile = true;
                   }
                   catch(Exception f){
                       // JOptionPane.showMessageDialog(null, f.getMessage());
                   }
            }
            inputFile14.close();
        }
        catch(IOException e){     
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(Exception k){
//                        JOptionPane.showMessageDialog(null, k.getMessage());
                   }
        
    }
    public static void saveFPtofile(FPdata fd){
        try{
            int i;
            fetchprojdetails();
            fetchFPdetails();
            fp.add(fd);
            
            FileOutputStream file = new FileOutputStream(project.get(0).getFPDataFile());
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for (i =0 ; i<fp.size(); i++){
                outputFile.writeObject(fp.get(i));
                
            }
            
            outputFile.close();
            int count= jTabbedPane1.getTabCount();
            jTabbedPane1.setSelectedIndex(count-1);
//            Component contentPane = jTabbedPane1.getComponentAt(i-1);

        }
        catch(IOException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }
        catch(Exception f){
            System.out.println(f.getMessage());
//                        JOptionPane.showMessageDialog(null, f.getMessage());
                   }        
    }
        public static void saveUCPtofile(UCPdata uc){
        try{
            int i;
            fetchprojdetails();
            fetchUCPdetails();
            ucp.add(uc);
            
            FileOutputStream file = new FileOutputStream(project.get(0).getUCPDataFile());
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for (i =0 ; i<ucp.size(); i++){
                outputFile.writeObject(ucp.get(i));
                
            }
            
            outputFile.close();
            int count= jTabbedPane1.getTabCount();
            jTabbedPane1.setSelectedIndex(count-1);

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception f){
            System.out.println(f.getMessage());
                   }        
    }
        public static void saveSMItofile(SMIData smid){
            try{
            int i;
            fetchprojdetails();
            fetchSMIdetails();
            smi.add(smid);
            
            FileOutputStream file = new FileOutputStream(project.get(0).getSMIDataFile());
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for (i =0 ; i<smi.size(); i++){
                outputFile.writeObject(smi.get(i));
                
            }
            
            outputFile.close();
            int count= jTabbedPane1.getTabCount();
            jTabbedPane1.setSelectedIndex(count-1);

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception f){
            System.out.println(f.getMessage());
                   }
            
        }
        public static void SMITabClosed(){
            try{
            fetchprojdetails();
            fetchSMIdetails();
            smi.get(0).setTabOpen(false);
            FileOutputStream file = new FileOutputStream(project.get(0).getSMIDataFile());
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for (int i =0 ; i<smi.size(); i++){
                outputFile.writeObject(smi.get(i));
                
            }
            
            outputFile.close();
            int count= jTabbedPane1.getTabCount();
            jTabbedPane1.setSelectedIndex(count-1);

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception f){
            System.out.println(f.getMessage());
                   }
        
        }
        public static void projectTree(String projName){
         fetchprojdetails();
         fetchFPdetails();
         fetchUCPdetails();
        DefaultMutableTreeNode projectName = new DefaultMutableTreeNode(projName);
        model.setRoot(projectName);
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        DefaultMutableTreeNode FP = new DefaultMutableTreeNode("FP");
        root.add(FP);
        DefaultMutableTreeNode UCP = new DefaultMutableTreeNode("UCP");
        root.add(UCP);
        DefaultMutableTreeNode SMI = new DefaultMutableTreeNode("SMI");
        root.add(SMI);
        
        model.reload(root);
        
        
        System.out.println(project.get(0).getProjectName());
        }
        public static void AddFPtoTree(String FPName){
            DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
            DefaultMutableTreeNode FP = (DefaultMutableTreeNode) model.getChild(root, 0);
            DefaultMutableTreeNode FP1 = new DefaultMutableTreeNode(FPName);
            FP.add(FP1);
        }
    public static void AddUCPtoTree(String UCPName){
            DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
            DefaultMutableTreeNode UCP = (DefaultMutableTreeNode) model.getChild(root, 1);
            DefaultMutableTreeNode UCP1 = new DefaultMutableTreeNode(UCPName);
            UCP.add(UCP1);
        }
    public static void AddSMItoTree(){
            DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
            DefaultMutableTreeNode SMI = (DefaultMutableTreeNode) model.getChild(root, 2);
            DefaultMutableTreeNode SMI1 = new DefaultMutableTreeNode(projname+"SMI");
            SMI.add(SMI1);
        }
    public  void OpenonJtreeClick( TreeSelectionEvent tse){
        fetchprojdetails();
        fetchFPdetails();
        fetchUCPdetails();
        fetchSMIdetails();
        String node = tse.getNewLeadSelectionPath().getLastPathComponent().toString();
        if(node != "FP" && node != "UCP" && node != "SMI"){
            System.out.println(node);
            String parent = tse.getNewLeadSelectionPath().getParentPath().getLastPathComponent().toString();
            System.out.println(parent);
            if(parent.equals("FP")){
                        for (int i =0 ; i<fp.size(); i++){
                            if(fp.get(i).getFPName().equals(node)){
                                if(!fp.get(i).isTabOpen()){
                                    ImageIcon close_icon = new ImageIcon(new ImageIcon( this.getClass().getResource("closeTab.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
                                    metricsuite.jTabbedPane1.addTab( fp.get(i).getFPName() , close_icon, new NewFPdata().getContentPane(),"FP");
                                    FPdata fd = fp.get(i);
                                    NewFPdata.setFPValuesonOpen(fd);
                                }
                            }
                        }
            }
            else if(parent.equals("UCP")){
                for (int i =0 ; i<ucp.size(); i++){
                            if(ucp.get(i).getUCPName().equals(node)){
                                if(!ucp.get(i).isTabOpen()){
                                    ImageIcon close_icon = new ImageIcon(new ImageIcon( this.getClass().getResource("closeTab.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
                                    metricsuite.jTabbedPane1.addTab( ucp.get(i).getUCPName() , close_icon, new NewUCPdata().getContentPane(),"UCP");
                                    UCPdata ucd = ucp.get(i);
                                    NewUCPdata.setUCPValuesOnOpen(ucd);
                                }
                            }
                        }
            }
            else if(parent.equals("SMI")){
                if(!smi.get(0).isTabOpen()){
                    ImageIcon close_icon = new ImageIcon(new ImageIcon( this.getClass().getResource("closeTab.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
                    metricsuite.jTabbedPane1.addTab( projname+"SMI" , close_icon, new SMI().getContentPane(),"SMI");
                    for (int i =0 ; i<smi.size(); i++){
                        SMIData smid = smi.get(i);
                        SMI.setSMIValuesOnOpen(smid);
                    }
                }
            }
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jTree1 = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        Close = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Preferences = new javax.swing.JMenu();
        Language = new javax.swing.JMenuItem();
        Metrics = new javax.swing.JMenu();
        CreateFP = new javax.swing.JMenuItem();
        CreateUCP = new javax.swing.JMenuItem();
        CreateSMI = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.UTILITY);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jSplitPane1.setLeftComponent(jTree1);

        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTabbedPane1ComponentAdded(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });
        jSplitPane1.setRightComponent(jTabbedPane1);

        File.setText("File");

        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        File.add(New);

        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        File.add(Open);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        File.add(Save);

        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        File.add(Close);

        jMenuBar1.add(File);

        Edit.setText("Edit");
        jMenuBar1.add(Edit);

        Preferences.setText("Preferences");

        Language.setText("Language");
        Language.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LanguageActionPerformed(evt);
            }
        });
        Preferences.add(Language);

        jMenuBar1.add(Preferences);

        Metrics.setText("Metrics");

        CreateFP.setText("Create FP");
        CreateFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateFPActionPerformed(evt);
            }
        });
        Metrics.add(CreateFP);

        CreateUCP.setText("Create UCP");
        CreateUCP.setToolTipText("");
        CreateUCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateUCPActionPerformed(evt);
            }
        });
        Metrics.add(CreateUCP);

        CreateSMI.setText("Create SMI");
        CreateSMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateSMIActionPerformed(evt);
            }
        });
        Metrics.add(CreateSMI);

        jMenuBar1.add(Metrics);

        Help.setText("Help");
        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        // TODO add your handling code here:
        new NewProject().setVisible(true);

        
        
    }//GEN-LAST:event_NewActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CloseActionPerformed

    private void LanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LanguageActionPerformed
        // TODO add your handling code here:
        new changeLanguage().setVisible(true);
    }//GEN-LAST:event_LanguageActionPerformed

    
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        fetchFPdetails();
        
        
        int k = jTabbedPane1.getSelectedIndex();
        if(jTabbedPane1.getToolTipTextAt(k) == "FP"){
            NewFPdata.projname = projname;
            NewFPdata.saveCurrentFP(jTabbedPane1.getTitleAt(k));
        }
        else if(jTabbedPane1.getToolTipTextAt(k) == "UCP"){
            NewUCPdata.projname = projname;
            NewUCPdata.saveCurrentUCP(jTabbedPane1.getTitleAt(k));
        }
        else if(jTabbedPane1.getToolTipTextAt(k) == "SMI"){
            SMI.savecurrentSMItoFile();
        }
//        NewFPdata.projname = projname;
//        NewFPdata.saveCurrentFP(fp.get(k).getFPName());
//        
//        for (int i =0 ; i<jTabbedPane1.getTabCount(); i++){
//            jTabbedPane1.setSelectedIndex(i);
//            System.out.println(jTabbedPane1.getToolTipTextAt(i));
//            if(jTabbedPane1.getToolTipTextAt(i) == "FP"){
//                NewFPdata.projname = projname;
//                NewFPdata.saveCurrentFP(jTabbedPane1.getTitleAt(i));
//            }
//            else if(jTabbedPane1.getToolTipTextAt(i) == "UCP"){
//                
//            }
//        }
    }//GEN-LAST:event_SaveActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.removeAll();
        JFileChooser filechooser = new JFileChooser();
        filechooser.setMultiSelectionEnabled(false);
        filechooser.setAcceptAllFileFilterUsed(false);
        filechooser.setFileFilter(new FileNameExtensionFilter("MetricSuite ms", "ms"));
        int m = filechooser.showOpenDialog(this);
        if(m == JFileChooser.APPROVE_OPTION){
            File file1 = filechooser.getSelectedFile();
            try{
                project.clear();
            FileInputStream file23 = new FileInputStream(file1.getAbsolutePath());
            ObjectInputStream inputFile23 = new ObjectInputStream(file23);
            
            boolean endofFile = false;
            while(!endofFile){
                   try{
                        project.add((projectData) inputFile23.readObject());
                   }
                   catch(EOFException e){
                       endofFile = true;
                   }
                   catch(Exception f){
                        JOptionPane.showMessageDialog(null, f.getMessage());
                   }
            }
            inputFile23.close();
            
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(Exception k){
                        JOptionPane.showMessageDialog(null, k.getMessage());
                   }
            projname = project.get(0).getProjectName();
            projectTree(projname);
            fetchFPdetails();
            fetchUCPdetails();
            fetchSMIdetails();
            
        for (int i =0 ; i<fp.size(); i++){
            ImageIcon close_icon = new ImageIcon(new ImageIcon( this.getClass().getResource("closeTab.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
            metricsuite.jTabbedPane1.addTab( fp.get(i).getFPName() , close_icon, new NewFPdata().getContentPane(),"FP");
            FPdata fd = fp.get(i);
            NewFPdata.setFPValuesonOpen(fd);
            AddFPtoTree(fp.get(i).getFPName());
        }    
           for (int i =0 ; i<ucp.size(); i++){
            ImageIcon close_icon = new ImageIcon(new ImageIcon( this.getClass().getResource("closeTab.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
            metricsuite.jTabbedPane1.addTab( ucp.get(i).getUCPName() , close_icon, new NewUCPdata().getContentPane(),"UCP");
            UCPdata ucpd = ucp.get(i);
            NewUCPdata.setUCPValuesOnOpen(ucpd);  
               AddUCPtoTree(ucp.get(i).getUCPName());
        } 
           if(smi.size()>0){
               ImageIcon close_icon = new ImageIcon(new ImageIcon( this.getClass().getResource("closeTab.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
                metricsuite.jTabbedPane1.addTab( projname+"SMI" , close_icon, new SMI().getContentPane(),"SMI");
                for (int i =0 ; i<smi.size(); i++){
                SMIData smid = smi.get(i);
                SMI.setSMIValuesOnOpen(smid);
           }
                AddSMItoTree();
           }
           
        }
                
    }//GEN-LAST:event_OpenActionPerformed

    private void CreateFPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateFPActionPerformed
        // TODO add your handling code here:
        new CreateFP().setVisible(true);
    }//GEN-LAST:event_CreateFPActionPerformed

    private void CreateUCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateUCPActionPerformed
        // TODO add your handling code here:
        new CreateUCP().setVisible(true);
    }//GEN-LAST:event_CreateUCPActionPerformed

    private void jTabbedPane1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1ComponentAdded

    private void CreateSMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateSMIActionPerformed
        // TODO add your handling code here:
        if(checkproject()){
            JOptionPane.showMessageDialog(null, "No project created");
        }
        else{
        CreateSMI.setVisible(false);
        ImageIcon close_icon = new ImageIcon(new ImageIcon( this.getClass().getResource("closeTab.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
        jTabbedPane1.addTab(projname+"SMI", close_icon, new SMI().getContentPane(),"SMI");
        AddSMItoTree();
        int count= jTabbedPane1.getTabCount();
        jTabbedPane1.setSelectedIndex(count-1);
        }
        
    }//GEN-LAST:event_CreateSMIActionPerformed

    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
        // TODO add your handling code here:
        System.out.println("mouse pressed");
        int index = jTabbedPane1.getSelectedIndex();
        
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem delete = new JMenuItem("Close");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jTabbedPane1.getToolTipTextAt(index) == "FP"){
                    NewFPdata.projname = projname;
                    NewFPdata.tabClosed(jTabbedPane1.getTitleAt(index));
                }
                else if(jTabbedPane1.getToolTipTextAt(index) == "UCP"){
                    NewUCPdata.projname = projname;
                    NewUCPdata.tabClosed(jTabbedPane1.getTitleAt(index));
                }
                else if(jTabbedPane1.getToolTipTextAt(index) == "SMI"){
                    SMITabClosed();
                }
                
                 jTabbedPane1.remove(index);
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               
            }
        } );
        popupMenu.add(delete);
        popupMenu.show(jSplitPane1, evt.getX(), evt.getY());
        
    }//GEN-LAST:event_jTabbedPane1MousePressed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
        OpenonJtreeClick(evt);
    }//GEN-LAST:event_jTree1ValueChanged

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
            java.util.logging.Logger.getLogger(metricsuite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(metricsuite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(metricsuite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(metricsuite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new metricsuite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Close;
    private javax.swing.JMenuItem CreateFP;
    private javax.swing.JMenuItem CreateSMI;
    private javax.swing.JMenuItem CreateUCP;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem Language;
    private javax.swing.JMenu Metrics;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenu Preferences;
    public javax.swing.JMenuItem Save;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSplitPane jSplitPane1;
    public static javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
