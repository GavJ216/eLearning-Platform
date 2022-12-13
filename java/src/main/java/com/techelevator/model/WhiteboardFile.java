package com.techelevator.model;

public class WhiteboardFile {

    private int fileId;
    private String fileName;
    private String filePath;

    public WhiteboardFile(int fileId, String fileName, String filePath) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public WhiteboardFile() {

    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
