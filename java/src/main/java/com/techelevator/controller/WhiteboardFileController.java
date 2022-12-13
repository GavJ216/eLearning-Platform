package com.techelevator.controller;

import com.techelevator.dao.WhiteboardFileDao;
import com.techelevator.model.WhiteboardFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class WhiteboardFileController {

    private WhiteboardFileDao whiteboardFileDao;

    public WhiteboardFileController (WhiteboardFileDao whiteboardFileDao) {
        this.whiteboardFileDao = whiteboardFileDao;
    }

    @RequestMapping(path = "/files", method = RequestMethod.GET)
    public WhiteboardFile getFileByName(@RequestBody String fileName) {
        return whiteboardFileDao.getFileByName(fileName);
    }
}
