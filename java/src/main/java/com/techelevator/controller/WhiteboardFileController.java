package com.techelevator.controller;


import com.techelevator.dao.WhiteboardFileDao;
import com.techelevator.model.WhiteboardFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
public class WhiteboardFileController {

    private WhiteboardFileDao dao;

    public WhiteboardFileController(WhiteboardFileDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "/file", method = RequestMethod.GET)
    public WhiteboardFile getFileById(@RequestBody int fileId) {
        return dao.getFileById(fileId);
    }

    @RequestMapping(path = "/files", method = RequestMethod.GET)
    public WhiteboardFile getFileByName(@RequestBody String fileName) {
        return dao.getFileByName(fileName);
    }

    @RequestMapping(path = "/files", method = RequestMethod.POST)
    public WhiteboardFile addFile(@RequestBody WhiteboardFile file) {
        return dao.addFile(file);
    }



}
