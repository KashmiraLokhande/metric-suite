
import java.io.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kashmira Lokhande
 */
public class projectData implements Serializable{
    private String projectName;
    private String creatorName;
    private String comment;
    private String FPDataFile;
    private String UCPDataFile;
    private String SMIDataFile;

    public projectData(String projectName, String creatorName, String comment, String FPDataFile, String UCPDataFile, String SMIDataFile) {
        this.projectName = projectName;
        this.creatorName = creatorName;
        this.comment = comment;
        this.FPDataFile = FPDataFile;
        this.UCPDataFile = UCPDataFile;
        this.SMIDataFile = SMIDataFile;
    }


    


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFPDataFile() {
        return FPDataFile;
    }

    public void setFPDataFile(String FPDataFile) {
        this.FPDataFile = FPDataFile;
    }

    public String getUCPDataFile() {
        return UCPDataFile;
    }

    public void setUCPDataFile(String UCPDataFile) {
        this.UCPDataFile = UCPDataFile;
    }

    public String getSMIDataFile() {
        return SMIDataFile;
    }

    public void setSMIDataFile(String SMIDataFile) {
        this.SMIDataFile = SMIDataFile;
    }

    
}
