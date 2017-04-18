package graphEndpoint.dataConnection.controller;

import graphEndpoint.MainApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = CustomerController.class)
@ContextConfiguration(classes = MainApp.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
    public void shouldReturn200WhenSendingRequestToControllerWithRoleUser() throws Exception {
        mockMvc.perform(get("/customer/all")).andExpect(status().isOk());
    }

}