package com.example.demo.example.democontroller;


import com.example.demo.example.demoservice.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    private StringBuilder driveList = new StringBuilder();

    @GetMapping(value = "/detect/drives")
    public ResponseEntity<StringBuilder> displayDrives() {
        driveList.delete(0, driveList.length());
        driveList = demoService.getDriveInfo();
        return new ResponseEntity<>(driveList, HttpStatus.OK);
    }
}