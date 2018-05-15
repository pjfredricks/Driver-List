package com.example.demo.example.democontroller;

import com.example.demo.example.demoservice.impl.DemoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class DemoControllerTest {

    @Mock
    DemoServiceImpl demoServiceImpl;

    @InjectMocks
    DemoController demoController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(demoServiceImpl)
                .build();
    }

    @Test
    public void displayDrives() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/displayDrives"));
        assertEquals(HttpStatus.OK, demoController.displayDrives().getStatusCode());
    }
}