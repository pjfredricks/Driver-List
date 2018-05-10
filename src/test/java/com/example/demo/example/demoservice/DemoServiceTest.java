package com.example.demo.example.demoservice;

import com.example.demo.example.demomodel.DemoModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class DemoServiceTest {
    @Mock
    DemoModel demoModel;

    @InjectMocks
    DemoService demoService;

    FileSystemView fsv = FileSystemView.getFileSystemView();
    File[] driveList = File.listRoots();
    ObjectMapper mapper = new ObjectMapper();
    StringBuilder driveJson = new StringBuilder();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getDriveInfo() throws Exception {

    }
}