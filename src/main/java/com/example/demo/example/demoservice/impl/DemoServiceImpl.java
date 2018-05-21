package com.example.demo.example.demoservice.impl;

import com.example.demo.example.demomodel.DemoModel;
import com.example.demo.example.demoservice.DemoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.DecimalFormat;

@Service
public class DemoServiceImpl implements DemoService
{

    @Autowired
    DemoModel demoModel;

    StringBuilder driveJson = new StringBuilder();
    private DecimalFormat sizeFormat = new DecimalFormat("#.00");
    FileSystemView fsv = FileSystemView.getFileSystemView();
    ObjectMapper mapper = new ObjectMapper();


    public StringBuilder getDriveInfo() {
        if (File.listRoots() != null && File.listRoots().length > 0) {
            try {
                for (File driveLabel : File.listRoots()) {
                        demoModel.setDriveLetter(driveLabel.toString().charAt(0));
                        demoModel.setDriveName(fsv.getSystemDisplayName(driveLabel));
                        demoModel.setDriveType(fsv.getSystemTypeDescription(driveLabel));
                        demoModel.setTotalSpace(sizeFormat.format(driveLabel.getTotalSpace() / (1024.0 * 1024.0 * 1024.0)) + " GB");
                        demoModel.setFreeSpace(sizeFormat.format(driveLabel.getFreeSpace() / (1024.0 * 1024.0 * 1024.0)) + " GB");
                        driveJson.append(mapper.writeValueAsString(demoModel));
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return driveJson;
    }
}