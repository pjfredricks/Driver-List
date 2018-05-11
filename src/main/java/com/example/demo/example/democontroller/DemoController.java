package com.example.demo.example.democontroller;


import com.example.demo.example.demoservice.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/")
@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    private StringBuffer driveList = new StringBuffer();

    @GetMapping(value = "/displayDrives")
    public ResponseEntity<StringBuffer> displayDrives() {
        driveList.delete(0, driveList.length());
        driveList = demoService.getDriveInfo();
        return new ResponseEntity<>(driveList, HttpStatus.OK);

    }
}