package io.pillopl.testablearch.ex3.ui;

import io.pillopl.testablearch.ex3.MessagingApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = MessagingApplication.class)
@AutoConfigureMockMvc
public class CreditCardApplicationControllerIntegrationTestMockMvc {

    @LocalServerPort
    private int port;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void gettingCardIs200OK() throws Exception {

        //expect
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:" + port + "/").header("Content-Type", "application/json").content("{\"pesel\": \"717171717\"}")).andExpect(status().isOk());
    }

    @Test
    public void notGettingCardIs403FORBIDDEN() throws Exception {

        //expect
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:" + port + "/").header("Content-Type", "application/json").content("{\"pesel\": \"617171717\"}")).andExpect(status().isForbidden());
    }

}