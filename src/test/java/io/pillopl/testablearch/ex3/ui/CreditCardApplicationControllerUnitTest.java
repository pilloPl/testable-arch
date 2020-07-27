package io.pillopl.testablearch.ex3.ui;

import io.pillopl.testablearch.ex3.MessagingApplication;
import io.pillopl.testablearch.ex3.application.ApplyForCardService;
import io.pillopl.testablearch.ex3.model.CreditCard;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CreditCardApplicationController.class)
public class CreditCardApplicationControllerUnitTest {

    @MockBean
    ApplyForCardService applyForCardService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void gettingCardIs200OK() throws Exception {
        //when
        when(applyForCardService.apply("317171717")).thenReturn(Optional.of(new CreditCard()));
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/").header("Content-Type", "application/json").content("{\"pesel\": \"317171717\"}")).andExpect(status().isOk());
    }

    @Test
    public void notGettingCardIs403FORBIDDEN() throws Exception {
        //when
        when(applyForCardService.apply("817171717")).thenReturn(Optional.empty());
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/").header("Content-Type", "application/json").content("{\"pesel\": \"317171717\"}")).andExpect(status().isForbidden());
    }

}