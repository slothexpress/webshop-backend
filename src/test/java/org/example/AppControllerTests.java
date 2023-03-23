package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(AppController.class)
@ExtendWith(SpringExtension.class)
public class AppControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AppService service;


    @Test
    public void dummyEndpointTest() throws Exception {
        String defaultResult = "HALLO ";
        String input = "SAMI";

        this.mvc.perform(get("/test/" + input))
                .andExpect(
                        status().isOk())
                .andExpect(
                        content().string(containsString(
                                defaultResult + input
                        ))
                );
    }

    @Test
    public void getAllProductsTest() throws Exception {
        when(service.getAllProducts())
                .thenReturn(new HashMap<>());

        this.mvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{}"));
    }

}
