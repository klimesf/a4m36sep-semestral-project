package cz.cvut.fel.sep.klimefi1.semestral;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ChangeRequestTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void showChangeRequestsList() throws Exception {
        mockMvc.perform(get("/change-requests"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("John Doe")))
                .andExpect(content().string(containsString("Chuck Norris")));
    }

    @Test
    @WithMockUser
    public void showChangeRequestForm() throws Exception {
        mockMvc.perform(get("/change-requests/create"))
                .andExpect(content().string(containsString("Create Change Request")));
    }

    @Test
    @WithMockUser
    public void submitChangeRequestForm() throws Exception {
        mockMvc.perform(
                post("/change-requests/create")
                        .with(csrf())
                        .param("clientId", "12345")
                        .param("type", "REMOVE")
                        .param("note", "Because reasons..."))
                .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/change-requests"));
    }
}
