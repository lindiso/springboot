package za.co.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.spring.boot.dto.FileDTO;
import za.co.spring.boot.service.FilePathService;

@RequestMapping("/file")
@RestController
public class Controller {

    @Autowired
    private FilePathService filePathService;

    @RequestMapping(value = "/filepath", produces = MediaType.APPLICATION_JSON_VALUE)
    public FileDTO getFilePath(@RequestParam("path") String path){
        FileDTO results = filePathService.fileFilePath(path);
        System.out.printf("FP : " + results);
        return results;
    }
}
