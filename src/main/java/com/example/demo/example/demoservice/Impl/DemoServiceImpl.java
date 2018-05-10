package com.example.demo.example.demoservice.Impl;

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

    StringBuffer driveJson = new StringBuffer();
    private DecimalFormat sizeFormat = new DecimalFormat("#.00");

    FileSystemView fsv = FileSystemView.getFileSystemView();
    
    ObjectMapper mapper = new ObjectMapper();

    public StringBuffer getDriveInfo() {
        if (File.listRoots() != null && File.listRoots().length > 0) {
            try {
                for (File drive : File.listRoots()) {
                    demoModel.setDriveName(drive.toString());
                    demoModel.setDriveType(fsv.getSystemTypeDescription(drive));
                    demoModel.setTotalSpace(sizeFormat.format(drive.getTotalSpace() / (1024.0 * 1024.0 * 1024.0)) + " GB");
                    demoModel.setFreeSpace(sizeFormat.format(drive.getFreeSpace() / (1024.0 * 1024.0 * 1024.0)) + " GB");
                    driveJson.append(mapper.writeValueAsString(demoModel));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driveJson;
    }
}
