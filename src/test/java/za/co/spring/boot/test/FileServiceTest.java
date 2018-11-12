package za.co.spring.boot.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.co.spring.boot.controller.Controller;
import za.co.spring.boot.service.FilePathService;

@RunWith(PowerMockRunner.class)
public class FileServiceTest {

    private MockMvc mockMvc;

    @InjectMocks
    private Controller restController;

    @Mock
    private FilePathService  filePathService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
    }

    @Test
    public void findFilePathTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.patch("/file/filepath").accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.parseMediaType("application/json"))
        .param("path", "Test"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
