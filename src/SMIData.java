
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
public class SMIData implements Serializable{
    private double SMI;
    private int modulesAdded;
    private int moduleChanged;
    private int modulesDeleted;
    private int totalModules;
    private boolean tabOpen;

    public SMIData(double SMI, int modulesAdded, int moduleChanged, int modulesDeleted, int totalModules, boolean tabOpen) {
        this.SMI = SMI;
        this.modulesAdded = modulesAdded;
        this.moduleChanged = moduleChanged;
        this.modulesDeleted = modulesDeleted;
        this.totalModules = totalModules;
        this.tabOpen = tabOpen;
    }

    public double getSMI() {
        return SMI;
    }

    public void setSMI(double SMI) {
        this.SMI = SMI;
    }

    public int getModulesAdded() {
        return modulesAdded;
    }

    public void setModulesAdded(int modulesAdded) {
        this.modulesAdded = modulesAdded;
    }

    public int getModuleChanged() {
        return moduleChanged;
    }

    public void setModuleChanged(int moduleChanged) {
        this.moduleChanged = moduleChanged;
    }

    public int getModulesDeleted() {
        return modulesDeleted;
    }

    public void setModulesDeleted(int modulesDeleted) {
        this.modulesDeleted = modulesDeleted;
    }

    public int getTotalModules() {
        return totalModules;
    }

    public void setTotalModules(int totalModules) {
        this.totalModules = totalModules;
    }

    public boolean isTabOpen() {
        return tabOpen;
    }

    public void setTabOpen(boolean tabOpen) {
        this.tabOpen = tabOpen;
    }
    
    
}
