
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kashmira Lokhande
 */
public class FPdata implements Serializable {
    private String FPName;
    private int EI;
    private int EO;
    private int EE;
    private int ILF;
    private int EIF;
    private int EIweightingFactor;
    private int EOweightingFactor;
    private int EEweightingFactor;
    private int ILFweightingFactor;
    private int EIFweightingFactor;
    private int EIvalue;
    private int EOvalue;
    private int EEvalue;
    private int ILFvalue;
    private int EIFvalue;
    private int total;
    private int VAF;
    private String language;
    private double FP;
    private int codeSize;
    private boolean tabOpen;

    public FPdata(String FPName, int EI, int EO, int EE, int ILF, int EIF, int EIweightingFactor, int EOweightingFactor, int EEweightingFactor, int ILFweightingFactor, int EIFweightingFactor, int EIvalue, int EOvalue, int EEvalue, int ILFvalue, int EIFvalue, int total, int VAF, String language, double FP, int codeSize, boolean tabOpen) {
        this.FPName = FPName;
        this.EI = EI;
        this.EO = EO;
        this.EE = EE;
        this.ILF = ILF;
        this.EIF = EIF;
        this.EIweightingFactor = EIweightingFactor;
        this.EOweightingFactor = EOweightingFactor;
        this.EEweightingFactor = EEweightingFactor;
        this.ILFweightingFactor = ILFweightingFactor;
        this.EIFweightingFactor = EIFweightingFactor;
        this.EIvalue = EIvalue;
        this.EOvalue = EOvalue;
        this.EEvalue = EEvalue;
        this.ILFvalue = ILFvalue;
        this.EIFvalue = EIFvalue;
        this.total = total;
        this.VAF = VAF;
        this.language = language;
        this.FP = FP;
        this.codeSize = codeSize;
        this.tabOpen = tabOpen;
    }

    public String getFPName() {
        return FPName;
    }

    public void setFPName(String FPName) {
        this.FPName = FPName;
    }

    public int getEI() {
        return EI;
    }

    public void setEI(int EI) {
        this.EI = EI;
    }

    public int getEO() {
        return EO;
    }

    public void setEO(int EO) {
        this.EO = EO;
    }

    public int getEE() {
        return EE;
    }

    public void setEE(int EE) {
        this.EE = EE;
    }

    public int getILF() {
        return ILF;
    }

    public void setILF(int ILF) {
        this.ILF = ILF;
    }

    public int getEIF() {
        return EIF;
    }

    public void setEIF(int EIF) {
        this.EIF = EIF;
    }

    public int getEIweightingFactor() {
        return EIweightingFactor;
    }

    public void setEIweightingFactor(int EIweightingFactor) {
        this.EIweightingFactor = EIweightingFactor;
    }

    public int getEOweightingFactor() {
        return EOweightingFactor;
    }

    public void setEOweightingFactor(int EOweightingFactor) {
        this.EOweightingFactor = EOweightingFactor;
    }

    public int getEEweightingFactor() {
        return EEweightingFactor;
    }

    public void setEEweightingFactor(int EEweightingFactor) {
        this.EEweightingFactor = EEweightingFactor;
    }

    public int getILFweightingFactor() {
        return ILFweightingFactor;
    }

    public void setILFweightingFactor(int ILFweightingFactor) {
        this.ILFweightingFactor = ILFweightingFactor;
    }

    public int getEIFweightingFactor() {
        return EIFweightingFactor;
    }

    public void setEIFweightingFactor(int EIFweightingFactor) {
        this.EIFweightingFactor = EIFweightingFactor;
    }

    public int getEIvalue() {
        return EIvalue;
    }

    public void setEIvalue(int EIvalue) {
        this.EIvalue = EIvalue;
    }

    public int getEOvalue() {
        return EOvalue;
    }

    public void setEOvalue(int EOvalue) {
        this.EOvalue = EOvalue;
    }

    public int getEEvalue() {
        return EEvalue;
    }

    public void setEEvalue(int EEvalue) {
        this.EEvalue = EEvalue;
    }

    public int getILFvalue() {
        return ILFvalue;
    }

    public void setILFvalue(int ILFvalue) {
        this.ILFvalue = ILFvalue;
    }

    public int getEIFvalue() {
        return EIFvalue;
    }

    public void setEIFvalue(int EIFvalue) {
        this.EIFvalue = EIFvalue;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getVAF() {
        return VAF;
    }

    public void setVAF(int VAF) {
        this.VAF = VAF;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getFP() {
        return FP;
    }

    public void setFP(double FP) {
        this.FP = FP;
    }

    public int getCodeSize() {
        return codeSize;
    }

    public void setCodeSize(int codeSize) {
        this.codeSize = codeSize;
    }

    public boolean isTabOpen() {
        return tabOpen;
    }

    public void setTabOpen(boolean tabOpen) {
        this.tabOpen = tabOpen;
    }
    

 

}
