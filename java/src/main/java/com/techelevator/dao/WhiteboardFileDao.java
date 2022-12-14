package com.techelevator.dao;

import com.techelevator.model.WhiteboardFile;

public interface WhiteboardFileDao {

    WhiteboardFile getFileById(int id);

    WhiteboardFile getFileByName(String fileName);

    WhiteboardFile addFile(WhiteboardFile file);

//    boolean deleteFile(int id);
//
//    boolean deleteFile(String fileName);


}
