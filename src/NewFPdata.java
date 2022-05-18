
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kashmira Lokhande
 */
public class NewFPdata extends javax.swing.JFrame {
    public static  ArrayList<projectData> project;
    public static  ArrayList<FPdata> fp;    
    public static  String projname;
    private static int EI;
    public  static int EO;
    public  static int EInq;
    public  static int ILF;
    public  static int EIF;
    public  static int EIvalue;
    public  static int EOvalue;
    public  static int EInqvalue;
    public  static int ILFvalue;
    public  static int EIFvalue;
    public  static int EIWeight;
    public  static int EOWeight;
    public  static int EInqWeight;
    public  static int ILFWeight;
    public  static int EIFWeight;
    public  static int VAFvalue = 0;
    public  static String language = "C";
    public  static int total = 0;
    public  static double FPcal = 0;
    private static DecimalFormat df = new DecimalFormat("0.00");
    public  static String FPname;
    public  static int codeSize = 0;
    public  static int currentVAF = 0;
    /**
     * Creates new form NewFPdata
     */
    public NewFPdata() {
        initComponents();
        project = new ArrayList<projectData>();
        fp = new  ArrayList<FPdata>();
        VAFvalue = 0;
        language = "C";
    }
 public static void fetchprojdetails(){
        try{
            project.clear();
            System.out.println("Inside fetchprojdetails "+projname);
            FileInputStream file = new FileInputStream(projname+".ms");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean endofFile = false;
            while(!endofFile){
                   try{
                        project.add((projectData) inputFile.readObject());
                   }
                   catch(EOFException e){
                       endofFile = true;
                   }
                   catch(Exception f){
                        JOptionPane.showMessageDialog(null, f.getMessage());
                   }
            }
            inputFile.close();
            
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(Exception k){
                        JOptionPane.showMessageDialog(null, k.getMessage());
                   }

    }
    public static void fetchFPdetails(){
        try{
            fp.clear();
            System.out.println("Inside fetchFPdetails" + project.get(0).getFPDataFile());
            FileInputStream file1 = new FileInputStream(project.get(0).getFPDataFile());
            ObjectInputStream inputFile1 = new ObjectInputStream(file1);
            boolean endofFile = false;
            while(!endofFile){
                   try{
                        fp.add((FPdata) inputFile1.readObject());
                   }
                   catch(EOFException e){
                       endofFile = true;
                   }
                   catch(Exception f){
                       System.out.println("mmm"+f.getMessage());
                        JOptionPane.showMessageDialog(null, f.getMessage());
                   }
            }
            inputFile1.close();
        }
        catch(IOException e){
            System.out.println("kkkk"+e.getMessage());            
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(Exception k){
            System.out.println("rrr"+k.getMessage());
//                        JOptionPane.showMessageDialog(null, k.getMessage());
                   }
        
    }
    public static void saveCurrentFP(String name){
        try{
            fetchprojdetails();
            fetchFPdetails();
        int EI = Integer.parseInt(EItext.getText());
        int EO = Integer.parseInt(EOtext.getText());
        int EInq = Integer.parseInt(EInqtext.getText());
        int ILF = Integer.parseInt(ILFtext.getText());
        int EIF = Integer.parseInt(EIFtext.getText());
        int total = Integer.parseInt(Total.getText());
        int VAFvalue = Integer.parseInt(VAF.getText());
        String language  = CurrentLanguage.getText();
        double FPcal = Double.parseDouble(FP.getText());
        int EIvalue = Integer.parseInt(EIValuetext.getText());
        int EOvalue = Integer.parseInt(EOValuetext.getText());
        int EInqvalue = Integer.parseInt(EInqValuetext.getText());
        int ILFvalue = Integer.parseInt(ILFValuetext.getText());
        int EIFvalue = Integer.parseInt(EIFValuetext.getText());
        int codesize;
        if(CodeSize.getText().equals("")){
            codesize = 0;
        }
        else{
            codesize = Integer.parseInt(CodeSize.getText());
        }
        
        int EIweight  = getEIweight() ;
        int EOweight = getEOWeight();
        int EInqweight = getEInqWeight();
        int ILFweight = getILFWeight();
        int EIFweight = getEIFWeight();
       
        
        //FPdata fd = new FPdata(FPname, EI, EO, EInq, ILF, EIF, EIWeight, EOWeight, EInqWeight, ILFWeight, EIFWeight, EIvalue, EOvalue, EInqvalue, ILFvalue, EIFvalue, total, VAFvalue, language, FPcal, codeSize);
        for (int i =0 ; i<fp.size(); i++){
            if(fp.get(i).getFPName().equals(name)){
                fp.get(i).setEI(EI);
                fp.get(i).setEO(EO);
                fp.get(i).setEE(EInq);
                fp.get(i).setILF(ILF);
                fp.get(i).setEIF(EIF);
                fp.get(i).setEIweightingFactor(EIweight);
                fp.get(i).setEOweightingFactor(EOweight);
                fp.get(i).setEEweightingFactor(EInqweight);
                fp.get(i).setILFweightingFactor(ILFweight);
                fp.get(i).setEIweightingFactor(EIFweight);
                fp.get(i).setEIvalue(EIvalue);
                fp.get(i).setEOvalue(EOvalue);
                fp.get(i).setEEvalue(EInqvalue);
                fp.get(i).setILFvalue(ILFvalue);
                fp.get(i).setEIFvalue(EIFvalue);
                fp.get(i).setTotal(total);
                fp.get(i).setVAF(VAFvalue);
                fp.get(i).setLanguage(language);
                fp.get(i).setFP(FPcal);
                fp.get(i).setCodeSize(codesize);
                fp.get(i).setTabOpen(true);
            }
        }
        
        FileOutputStream file = new FileOutputStream(project.get(0).getFPDataFile());
        ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for (int j =0 ; j<fp.size(); j++){
                outputFile.writeObject(fp.get(j));
            }
            
            outputFile.close();
            
        }
                catch(IOException e){
            System.out.println("sdfsf"+e.getMessage());            
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(Exception k){
            System.out.println("jkjkj"+k.getMessage());
//                        JOptionPane.showMessageDialog(null, k.getMessage());
                   }
        
    }
    public static void setFPValuesonOpen(FPdata fd){
        
        EItext.setText(Integer.toString(fd.getEI()));
        EOtext.setText(Integer.toString(fd.getEO()));
        EInqtext.setText(Integer.toString(fd.getEE()));
        ILFtext.setText(Integer.toString(fd.getILF()));
        EIFtext.setText(Integer.toString(fd.getEIF()));
        if(fd.getEIweightingFactor() == 3){
            EISimple.setSelected(true);
        }
        else if(fd.getEIweightingFactor() == 4){
            EIavg.setSelected(true);
        }
        else if(fd.getEIweightingFactor() == 6){
            EIcomplex.setSelected(true);
        }
        
        
        if(fd.getEOweightingFactor() == 4){
            EOsimple.setSelected(true);
        }
        else if(fd.getEOweightingFactor() == 5){
            EOAvg.setSelected(true);
        }
        else if(fd.getEOweightingFactor() == 7){
            EOcomplex.setSelected(true);
        }
        
        
        if(fd.getEEweightingFactor() == 3){
            EInqsimple.setSelected(true);
        }
        else if(fd.getEEweightingFactor() == 4){
            EInqAvg.setSelected(true);
        }
        else if(fd.getEEweightingFactor() == 6){
            EInqComplex.setSelected(true);
        }
        
        
        if(fd.getILFweightingFactor() == 7){
            ILFSimple.setSelected(true);
        }
        else if(fd.getILFweightingFactor() == 10){
            ILFAvg.setSelected(true);
        }
        else if(fd.getILFweightingFactor() == 15){
            ILFComplex.setSelected(true);
        }
        
        if(fd.getEIFweightingFactor() == 5){
            EIFSimple.setSelected(true);
        }
        else if(fd.getEIFweightingFactor() == 7){
            EIFAvg.setSelected(true);
        }
        else if(fd.getEIFweightingFactor() == 10){
            EIFComplex.setSelected(true);
        }
        
         EIValuetext.setText(Integer.toString(fd.getEIvalue()));
         EOValuetext.setText(Integer.toString(fd.getEOvalue()));
         EInqValuetext.setText(Integer.toString(fd.getEEvalue()));
         ILFValuetext.setText(Integer.toString(fd.getILFvalue()));
         EIFValuetext.setText(Integer.toString(fd.getEIFvalue()));
         EIValuetext.setText(Integer.toString(fd.getEIvalue()));
         Total.setText(Integer.toString(fd.getTotal()));
         FP.setText(Double.toString(fd.getFP()));
         VAF.setText(Integer.toString(fd.getVAF()));
         CurrentLanguage.setText(fd.getLanguage());
         CodeSize.setText(Integer.toString(fd.getCodeSize()));
    }
public static int getEIweight(){
    if(EISimple.isSelected()){
            EIWeight = Integer.parseInt(EISimple.getText());
        }
        else if(EIavg.isSelected()){
            EIWeight = Integer.parseInt(EIavg.getText());
        }
        else if(EIcomplex.isSelected()){
            EIWeight = Integer.parseInt(EIcomplex.getText());
        }
    return EIWeight;
}
public static int getEOWeight(){
    if(EOsimple.isSelected()){
            EOWeight = Integer.parseInt(EOsimple.getText());
        }
        else if(EOAvg.isSelected()){
            EOWeight = Integer.parseInt(EOAvg.getText());
        }
        else if(EOcomplex.isSelected()){
            EOWeight = Integer.parseInt(EOcomplex.getText());
        }
      return EOWeight;  
}
public static int  getEInqWeight(){
    if(EInqsimple.isSelected()){
            EInqWeight = Integer.parseInt(EInqsimple.getText());
        }
        else if(EInqAvg.isSelected()){
            EInqWeight = Integer.parseInt(EInqAvg.getText());
        }
        else if(EInqComplex.isSelected()){
            EInqWeight = Integer.parseInt(EInqComplex.getText());
        }
    return EInqWeight;
}
public static int getILFWeight(){
    if(ILFSimple.isSelected()){
            ILFWeight = Integer.parseInt(ILFSimple.getText());
        }
        else if(ILFAvg.isSelected()){
            ILFWeight = Integer.parseInt(ILFAvg.getText());
        }
        else if(ILFComplex.isSelected()){
            ILFWeight = Integer.parseInt(ILFComplex.getText());
        }
    return ILFWeight;
}
public static int getEIFWeight(){
     if(EIFSimple.isSelected()){
            EIFWeight = Integer.parseInt(EIFSimple.getText());
        }
        else if(EIFAvg.isSelected()){
            EIFWeight = Integer.parseInt(EIFAvg.getText());
        }
        else if(EIFComplex.isSelected()){
            EIFWeight = Integer.parseInt(EIFComplex.getText());
        }
     return EIFWeight;
}
public static void setVAF(int v){
    
    VAF.setText(Integer.toString(v));
}
public static void tabClosed(String FPname){
    try{
        
    fetchprojdetails();
    fetchFPdetails();
      for (int i =0 ; i<fp.size(); i++){
           if(fp.get(i).getFPName().equals(FPname)){
               fp.get(i).setTabOpen(false);
           }
      }
      FileOutputStream file = new FileOutputStream(project.get(0).getFPDataFile());
        ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for (int j =0 ; j<fp.size(); j++){
                outputFile.writeObject(fp.get(j));
            }
            
            outputFile.close();
            
        }
                catch(IOException e){
            System.out.println("sdfsf"+e.getMessage());            
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(Exception k){
            System.out.println("jkjkj"+k.getMessage());
//                        JOptionPane.showMessageDialog(null, k.getMessage());
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

        EIFactor = new javax.swing.ButtonGroup();
        EOFactor = new javax.swing.ButtonGroup();
        EinqFactor = new javax.swing.ButtonGroup();
        EIFfactor = new javax.swing.ButtonGroup();
        ILFfactor = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        EISimple = new javax.swing.JRadioButton();
        EIcomplex = new javax.swing.JRadioButton();
        EIavg = new javax.swing.JRadioButton();
        EIFtext = new javax.swing.JTextField();
        EOtext = new javax.swing.JTextField();
        EItext = new javax.swing.JTextField();
        ILFtext = new javax.swing.JTextField();
        EInqtext = new javax.swing.JTextField();
        EOsimple = new javax.swing.JRadioButton();
        EOAvg = new javax.swing.JRadioButton();
        EOcomplex = new javax.swing.JRadioButton();
        EInqsimple = new javax.swing.JRadioButton();
        EInqComplex = new javax.swing.JRadioButton();
        EInqAvg = new javax.swing.JRadioButton();
        EIFAvg = new javax.swing.JRadioButton();
        EIFComplex = new javax.swing.JRadioButton();
        EIFSimple = new javax.swing.JRadioButton();
        ILFSimple = new javax.swing.JRadioButton();
        ILFComplex = new javax.swing.JRadioButton();
        ILFAvg = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        EIValuetext = new javax.swing.JTextField();
        EInqValuetext = new javax.swing.JTextField();
        EOValuetext = new javax.swing.JTextField();
        ILFValuetext = new javax.swing.JTextField();
        Total = new javax.swing.JTextField();
        EIFValuetext = new javax.swing.JTextField();
        FP = new javax.swing.JTextField();
        VAF = new javax.swing.JTextField();
        CodeSize = new javax.swing.JTextField();
        CurrentLanguage = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ComputeFP = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setAutoscrolls(true);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Weighting Factors");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 24, 162, 27));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Simple");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 51, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("Average");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 51, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Complex");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 51, -1, -1));

        jLabel5.setText("External Input");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 81, -1, -1));

        jLabel6.setText("External Outputs");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 110, -1, -1));

        jLabel7.setText("External Inquires");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 145, -1, -1));

        jLabel8.setText("Internal Logical Files");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 177, -1, 22));

        jLabel9.setText("External Interface Files");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 209, -1, -1));

        EIFactor.add(EISimple);
        EISimple.setText("3");
        EISimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EISimpleActionPerformed(evt);
            }
        });
        jPanel1.add(EISimple, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 77, -1, -1));

        EIFactor.add(EIcomplex);
        EIcomplex.setText("6");
        EIcomplex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EIcomplexActionPerformed(evt);
            }
        });
        jPanel1.add(EIcomplex, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 77, -1, -1));

        EIFactor.add(EIavg);
        EIavg.setSelected(true);
        EIavg.setText("4");
        EIavg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EIavgActionPerformed(evt);
            }
        });
        jPanel1.add(EIavg, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 77, -1, -1));

        EIFtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EIFtextActionPerformed(evt);
            }
        });
        jPanel1.add(EIFtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 206, 40, -1));
        jPanel1.add(EOtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 107, 40, -1));
        jPanel1.add(EItext, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 78, 40, -1));
        jPanel1.add(ILFtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 177, 40, -1));
        jPanel1.add(EInqtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 142, 40, -1));

        EOFactor.add(EOsimple);
        EOsimple.setText("4");
        EOsimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EOsimpleActionPerformed(evt);
            }
        });
        jPanel1.add(EOsimple, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 110, -1, -1));

        EOFactor.add(EOAvg);
        EOAvg.setSelected(true);
        EOAvg.setText("5");
        EOAvg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EOAvgActionPerformed(evt);
            }
        });
        jPanel1.add(EOAvg, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 114, -1, -1));

        EOFactor.add(EOcomplex);
        EOcomplex.setText("7");
        EOcomplex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EOcomplexActionPerformed(evt);
            }
        });
        jPanel1.add(EOcomplex, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 112, -1, -1));

        EinqFactor.add(EInqsimple);
        EInqsimple.setText("3");
        EInqsimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EInqsimpleActionPerformed(evt);
            }
        });
        jPanel1.add(EInqsimple, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 142, -1, -1));

        EinqFactor.add(EInqComplex);
        EInqComplex.setText("6");
        EInqComplex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EInqComplexActionPerformed(evt);
            }
        });
        jPanel1.add(EInqComplex, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 142, -1, -1));

        EinqFactor.add(EInqAvg);
        EInqAvg.setSelected(true);
        EInqAvg.setText("4");
        EInqAvg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EInqAvgActionPerformed(evt);
            }
        });
        jPanel1.add(EInqAvg, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 142, -1, -1));

        EIFfactor.add(EIFAvg);
        EIFAvg.setSelected(true);
        EIFAvg.setText("7");
        jPanel1.add(EIFAvg, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 204, -1, -1));

        EIFfactor.add(EIFComplex);
        EIFComplex.setText("10");
        EIFComplex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EIFComplexActionPerformed(evt);
            }
        });
        jPanel1.add(EIFComplex, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 204, -1, -1));

        EIFfactor.add(EIFSimple);
        EIFSimple.setText("5");
        EIFSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EIFSimpleActionPerformed(evt);
            }
        });
        jPanel1.add(EIFSimple, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 204, -1, -1));

        ILFfactor.add(ILFSimple);
        ILFSimple.setText("7");
        ILFSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ILFSimpleActionPerformed(evt);
            }
        });
        jPanel1.add(ILFSimple, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 172, -1, -1));

        ILFfactor.add(ILFComplex);
        ILFComplex.setText("15");
        jPanel1.add(ILFComplex, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 172, -1, -1));

        ILFfactor.add(ILFAvg);
        ILFAvg.setSelected(true);
        ILFAvg.setText("10");
        jPanel1.add(ILFAvg, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 172, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Total");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 287, 70, 25));

        EIValuetext.setEditable(false);
        EIValuetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EIValuetextActionPerformed(evt);
            }
        });
        jPanel1.add(EIValuetext, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 77, 80, -1));

        EInqValuetext.setEditable(false);
        EInqValuetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EInqValuetextActionPerformed(evt);
            }
        });
        jPanel1.add(EInqValuetext, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 145, 80, -1));

        EOValuetext.setEditable(false);
        EOValuetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EOValuetextActionPerformed(evt);
            }
        });
        jPanel1.add(EOValuetext, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 113, 80, -1));

        ILFValuetext.setEditable(false);
        jPanel1.add(ILFValuetext, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 175, 80, -1));

        Total.setEditable(false);
        jPanel1.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 287, 80, -1));

        EIFValuetext.setEditable(false);
        jPanel1.add(EIFValuetext, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 204, 80, -1));

        FP.setEditable(false);
        FP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FPActionPerformed(evt);
            }
        });
        jPanel1.add(FP, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 80, -1));

        VAF.setEditable(false);
        VAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VAFActionPerformed(evt);
            }
        });
        jPanel1.add(VAF, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 383, 80, -1));

        CodeSize.setEditable(false);
        jPanel1.add(CodeSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 426, 80, -1));

        CurrentLanguage.setEditable(false);
        CurrentLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrentLanguageActionPerformed(evt);
            }
        });
        jPanel1.add(CurrentLanguage, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 426, 82, -1));

        jLabel11.setText("Current Language");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 429, -1, -1));

        ComputeFP.setText("Compute FP");
        ComputeFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComputeFPActionPerformed(evt);
            }
        });
        jPanel1.add(ComputeFP, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 339, -1, -1));

        jButton2.setText("Value Adjustments");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 382, -1, -1));

        jButton3.setText("Compute Code Size");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 425, -1, -1));

        jButton4.setText("Change Language");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 463, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 519));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FPActionPerformed

    private void EIFSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EIFSimpleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EIFSimpleActionPerformed

    private void EIFComplexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EIFComplexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EIFComplexActionPerformed

    private void EInqComplexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EInqComplexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EInqComplexActionPerformed

    private void EIFtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EIFtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EIFtextActionPerformed

    private void EISimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EISimpleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EISimpleActionPerformed

    private void ComputeFPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComputeFPActionPerformed
        // TODO add your handling code here:
        
//        int EI = Integer.parseInt(this.EI.getText())*getEIweight();
//        int EO = Integer.parseInt(this.EO.getText())*getEOWeight();
//        int EInq = Integer.parseInt(this.EInq.getText())*getEInqWeight();
//        int ILF = Integer.parseInt(this.ILF.getText())*getILFWeight();
//        int EIF = Integer.parseInt(this.EIF.getText())*getEIFWeight();
        //VAF.setText(Integer.toString(VAFvalue));
        int vafactor = 0;
        CurrentLanguage.setText(language);
        EI = Integer.parseInt(this.EItext.getText());
        EO = Integer.parseInt(this.EOtext.getText());
        EInq = Integer.parseInt(this.EInqtext.getText());
        ILF = Integer.parseInt(this.ILFtext.getText());
        EIF = Integer.parseInt(this.EIFtext.getText());
        int ei = EI * getEIweight();
        int eo = EO * getEOWeight();
        int einq = EInq * getEInqWeight();
        int ilf = ILF * getILFWeight();
        int eif = EIF * getEIFWeight();
        this.EIValuetext.setText(Integer.toString(ei));
        this.EOValuetext.setText(Integer.toString(eo));
        this.EInqValuetext.setText(Integer.toString(einq));
        this.ILFValuetext.setText(Integer.toString(ilf));
        this.EIFValuetext.setText(Integer.toString(eif));
        int totalvalue = ei+eo+einq+ilf+eif;
        this.Total.setText(Integer.toString(totalvalue));
        if(VAF.getText().equals("")){
            VAF.setText(Integer.toString(0));
        }
        vafactor = Integer.parseInt(VAF.getText());
        double fpvalue = totalvalue* (0.65 + (0.01 * vafactor));
        FP.setText(df.format(fpvalue));
        int index = metricsuite.jTabbedPane1.getSelectedIndex();
//        saveCurrentFP(metricsuite.jTabbedPane1.getTitleAt(index));
        
        
        
        
        
        
        
       
    }//GEN-LAST:event_ComputeFPActionPerformed

    private void VAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VAFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VAFActionPerformed

    private void EIavgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EIavgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EIavgActionPerformed

    private void EIcomplexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EIcomplexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EIcomplexActionPerformed

    private void EOsimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EOsimpleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EOsimpleActionPerformed

    private void EOAvgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EOAvgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EOAvgActionPerformed

    private void EOcomplexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EOcomplexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EOcomplexActionPerformed

    private void EInqsimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EInqsimpleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EInqsimpleActionPerformed

    private void EInqAvgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EInqAvgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EInqAvgActionPerformed

    private void ILFSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ILFSimpleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ILFSimpleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new VAF().setVisible(true);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new changeLanguage().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CurrentLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrentLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CurrentLanguageActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int t = Integer.parseInt(Total.getText());
        int valueAF = Integer.parseInt(VAF.getText());
        String l = CurrentLanguage.getText();
        double functionpoint = t* (0.65 + (0.01 * valueAF));
        int cs = 0;
        if(l.equals("Assembler")){
            cs = (int)(209 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
            
        }
        else if(l.equals("ADA 95")){
            cs = (int)(154 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
        }
        else if(l.equals("C")){
            cs = (int)(148 * functionpoint);
            CodeSize.setText(Integer.toString(cs));        }
        else if(l.equals("C++")){
            cs = (int)(59 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
        }
        else if(l.equals("C#")){
            cs = (int)(58 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
        }
        else if(l.equals("COBOL")){
            cs = (int)(80 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
        }
        else if(l.equals("FORTRAN")){
            cs = (int)(90 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
        }
        else if(l.equals("HTML")){
            cs = (int)(43 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
        }
        else if(l.equals("Java")){
            cs = (int)(55 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
        }
        else if(l.equals("JavaScript")){
            cs = (int)(54 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
        }
        else if(l.equals("VBScript")){
            cs = (int)(38 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
        }
        else if(l.equals("Visual Basic")){
            cs = (int)(50 * functionpoint);
            CodeSize.setText(Integer.toString(cs));
        }
//        saveCurrentFP(FPname);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void EOValuetextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EOValuetextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EOValuetextActionPerformed

    private void EInqValuetextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EInqValuetextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EInqValuetextActionPerformed

    private void EIValuetextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EIValuetextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EIValuetextActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NewFPdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NewFPdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NewFPdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NewFPdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new NewFPdata().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField CodeSize;
    private javax.swing.JButton ComputeFP;
    public static javax.swing.JTextField CurrentLanguage;
    public static javax.swing.JRadioButton EIFAvg;
    public static javax.swing.JRadioButton EIFComplex;
    public static javax.swing.JRadioButton EIFSimple;
    public static javax.swing.JTextField EIFValuetext;
    private javax.swing.ButtonGroup EIFactor;
    private javax.swing.ButtonGroup EIFfactor;
    public static javax.swing.JTextField EIFtext;
    public static javax.swing.JRadioButton EISimple;
    public static javax.swing.JTextField EIValuetext;
    public static javax.swing.JRadioButton EIavg;
    public static javax.swing.JRadioButton EIcomplex;
    public static javax.swing.JRadioButton EInqAvg;
    public static javax.swing.JRadioButton EInqComplex;
    public static javax.swing.JTextField EInqValuetext;
    public static javax.swing.JRadioButton EInqsimple;
    public static javax.swing.JTextField EInqtext;
    public static javax.swing.JTextField EItext;
    public static javax.swing.JRadioButton EOAvg;
    private javax.swing.ButtonGroup EOFactor;
    public static javax.swing.JTextField EOValuetext;
    public static javax.swing.JRadioButton EOcomplex;
    public static javax.swing.JRadioButton EOsimple;
    public static javax.swing.JTextField EOtext;
    private javax.swing.ButtonGroup EinqFactor;
    public static javax.swing.JTextField FP;
    public static javax.swing.JRadioButton ILFAvg;
    public static javax.swing.JRadioButton ILFComplex;
    public static javax.swing.JRadioButton ILFSimple;
    public static javax.swing.JTextField ILFValuetext;
    private javax.swing.ButtonGroup ILFfactor;
    public static javax.swing.JTextField ILFtext;
    public static javax.swing.JTextField Total;
    public static javax.swing.JTextField VAF;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
