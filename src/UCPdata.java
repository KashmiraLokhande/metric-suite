
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kashmira Lokhande
 */
public class UCPdata implements Serializable {
    private String UCPName;
    private double TCF;
    private double ECF;
    private int SimpleUC;
    private int AverageUC;
    private int ComplexUC;
    private int UUCWsimple;
    private int UUCWaverage;
    private int UUCWcomplex;
    private int UUCW;
    private int SimpleActor;
    private int AverageActor;
    private int ComplexActor;
    private int UAWsimple;
    private int UAWaverage;
    private int UAWcomplex;
    private int UAW;
    private int UUCP;
    private int PF;
    private double UCP;
    private int LOCperpm;
    private int LOCperUCP;
    private int estimatedHrs;
    private int estimatedLOC;
    private int estimatedPM;
    private boolean tabOpen;

    public UCPdata(String UCPName, double TCF, double ECF, int SimpleUC, int AverageUC, int ComplexUC, int UUCWsimple, int UUCWaverage, int UUCWcomplex, int UUCW, int SimpleActor, int AverageActor, int ComplexActor, int UAWsimple, int UAWaverage, int UAWcomplex, int UAW, int UUCP, int PF, double UCP, int LOCperpm, int LOCperUCP, int estimatedHrs, int estimatedLOC, int estimatedPM, boolean tabOpen) {
        this.UCPName = UCPName;
        this.TCF = TCF;
        this.ECF = ECF;
        this.SimpleUC = SimpleUC;
        this.AverageUC = AverageUC;
        this.ComplexUC = ComplexUC;
        this.UUCWsimple = UUCWsimple;
        this.UUCWaverage = UUCWaverage;
        this.UUCWcomplex = UUCWcomplex;
        this.UUCW = UUCW;
        this.SimpleActor = SimpleActor;
        this.AverageActor = AverageActor;
        this.ComplexActor = ComplexActor;
        this.UAWsimple = UAWsimple;
        this.UAWaverage = UAWaverage;
        this.UAWcomplex = UAWcomplex;
        this.UAW = UAW;
        this.UUCP = UUCP;
        this.PF = PF;
        this.UCP = UCP;
        this.LOCperpm = LOCperpm;
        this.LOCperUCP = LOCperUCP;
        this.estimatedHrs = estimatedHrs;
        this.estimatedLOC = estimatedLOC;
        this.estimatedPM = estimatedPM;
        this.tabOpen = tabOpen;
    }

    public String getUCPName() {
        return UCPName;
    }

    public void setUCPName(String UCPName) {
        this.UCPName = UCPName;
    }

    public double getTCF() {
        return TCF;
    }

    public void setTCF(double TCF) {
        this.TCF = TCF;
    }

    public double getECF() {
        return ECF;
    }

    public void setECF(double ECF) {
        this.ECF = ECF;
    }

    public int getSimpleUC() {
        return SimpleUC;
    }

    public void setSimpleUC(int SimpleUC) {
        this.SimpleUC = SimpleUC;
    }

    public int getAverageUC() {
        return AverageUC;
    }

    public void setAverageUC(int AverageUC) {
        this.AverageUC = AverageUC;
    }

    public int getComplexUC() {
        return ComplexUC;
    }

    public void setComplexUC(int ComplexUC) {
        this.ComplexUC = ComplexUC;
    }

    public int getUUCWsimple() {
        return UUCWsimple;
    }

    public void setUUCWsimple(int UUCWsimple) {
        this.UUCWsimple = UUCWsimple;
    }

    public int getUUCWaverage() {
        return UUCWaverage;
    }

    public void setUUCWaverage(int UUCWaverage) {
        this.UUCWaverage = UUCWaverage;
    }

    public int getUUCWcomplex() {
        return UUCWcomplex;
    }

    public void setUUCWcomplex(int UUCWcomplex) {
        this.UUCWcomplex = UUCWcomplex;
    }

    public int getUUCW() {
        return UUCW;
    }

    public void setUUCW(int UUCW) {
        this.UUCW = UUCW;
    }

    public int getSimpleActor() {
        return SimpleActor;
    }

    public void setSimpleActor(int SimpleActor) {
        this.SimpleActor = SimpleActor;
    }

    public int getAverageActor() {
        return AverageActor;
    }

    public void setAverageActor(int AverageActor) {
        this.AverageActor = AverageActor;
    }

    public int getComplexActor() {
        return ComplexActor;
    }

    public void setComplexActor(int ComplexActor) {
        this.ComplexActor = ComplexActor;
    }

    public int getUAWsimple() {
        return UAWsimple;
    }

    public void setUAWsimple(int UAWsimple) {
        this.UAWsimple = UAWsimple;
    }

    public int getUAWaverage() {
        return UAWaverage;
    }

    public void setUAWaverage(int UAWaverage) {
        this.UAWaverage = UAWaverage;
    }

    public int getUAWcomplex() {
        return UAWcomplex;
    }

    public void setUAWcomplex(int UAWcomplex) {
        this.UAWcomplex = UAWcomplex;
    }

    public int getUAW() {
        return UAW;
    }

    public void setUAW(int UAW) {
        this.UAW = UAW;
    }

    public int getUUCP() {
        return UUCP;
    }

    public void setUUCP(int UUCP) {
        this.UUCP = UUCP;
    }

    public int getPF() {
        return PF;
    }

    public void setPF(int PF) {
        this.PF = PF;
    }

    public double getUCP() {
        return UCP;
    }

    public void setUCP(double UCP) {
        this.UCP = UCP;
    }

    public int getLOCperpm() {
        return LOCperpm;
    }

    public void setLOCperpm(int LOCperpm) {
        this.LOCperpm = LOCperpm;
    }

    public int getLOCperUCP() {
        return LOCperUCP;
    }

    public void setLOCperUCP(int LOCperUCP) {
        this.LOCperUCP = LOCperUCP;
    }

    public int getEstimatedHrs() {
        return estimatedHrs;
    }

    public void setEstimatedHrs(int estimatedHrs) {
        this.estimatedHrs = estimatedHrs;
    }

    public int getEstimatedLOC() {
        return estimatedLOC;
    }

    public void setEstimatedLOC(int estimatedLOC) {
        this.estimatedLOC = estimatedLOC;
    }

    public int getEstimatedPM() {
        return estimatedPM;
    }

    public void setEstimatedPM(int estimatedPM) {
        this.estimatedPM = estimatedPM;
    }

    public boolean isTabOpen() {
        return tabOpen;
    }

    public void setTabOpen(boolean tabOpen) {
        this.tabOpen = tabOpen;
    }
    
    

    
    
}
