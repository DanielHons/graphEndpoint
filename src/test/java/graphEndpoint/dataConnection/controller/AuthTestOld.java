package graphEndpoint.dataConnection.controller;

import graphEndpoint.MainApp;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.servlet.Filter;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * Created by Daniel Hons on 15.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthenticationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    private MockMvc mvc;

    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilters(springSecurityFilterChain)
                .build();
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void shouldReturn200WhenSendingRequestToControllerWithRoleUser() throws Exception {
        then(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        mvc.perform(get("/test")).andExpect(status().isOk());

    }

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void shouldAuthenticatedBeTrueWithRoleUser() throws Exception {
        then(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
    }

    @Test
    public void shouldReturn401WhenSendingRequestToControllerNotAuthenticated() throws Exception {

        //then(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated());

    }

}
