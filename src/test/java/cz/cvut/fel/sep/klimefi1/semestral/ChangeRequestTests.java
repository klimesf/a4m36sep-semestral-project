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
                .andExpect(content().string(containsString("SUSPEND")))
                .andExpect(content().string(containsString("REMOVE")))
                .andExpect(content().string(containsString("REFUND")));
    }

    @Test
    @WithMockUser
    public void showAddChangeRequestForm() throws Exception {
        mockMvc.perform(get("/change-requests/add"))
                .andExpect(content().string(containsString("Create Change Request")));
    }

    @Test
    @WithMockUser
    public void showEditChangeRequestForm() throws Exception {
        mockMvc.perform(get("/change-requests/edit"))
                .andExpect(content().string(containsString("Create Change Request")));
    }

    @Test
    @WithMockUser
    public void showRefundChangeRequestForm() throws Exception {
        mockMvc.perform(get("/change-requests/refund"))
                .andExpect(content().string(containsString("Create Change Request")));
    }

    @Test
    @WithMockUser
    public void showSuspendChangeRequestForm() throws Exception {
        mockMvc.perform(get("/change-requests/suspend"))
                .andExpect(content().string(containsString("Create Change Request")));
    }

    @Test
    @WithMockUser
    public void showRemoveChangeRequestForm() throws Exception {
        mockMvc.perform(get("/change-requests/remove"))
                .andExpect(content().string(containsString("Create Change Request")));
    }

    @Test
    @WithMockUser
    public void submitAddChangeRequestForm() throws Exception {
        mockMvc.perform(
                post("/change-requests/add")
                        .with(csrf())
                        .param("clientId", "12345")
                        .param("firstName", "John")
                        .param("surname", "Doe")
                        .param("address", "Add")
                        .param("phoneNum", "123456789")
                        .param("birthNum", "1234567890")
                        .param("countryOfOrigin", "Czech Republic"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/change-requests"));
    }

    @Test
    @WithMockUser
    public void submitEditChangeRequestForm() throws Exception {
        mockMvc.perform(
                post("/change-requests/edit")
                        .with(csrf())
                        .param("clientId", "12345")
                        .param("firstName", "John")
                        .param("surname", "Doe")
                        .param("address", "Add")
                        .param("phoneNum", "123456789")
                        .param("birthNum", "1234567890")
                        .param("countryOfOrigin", "Czech Republic"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/change-requests"));
    }

    @Test
    @WithMockUser
    public void submitSuspendChangeRequestForm() throws Exception {
        mockMvc.perform(
                post("/change-requests/suspend")
                        .with(csrf())
                        .param("clientId", "12345"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/change-requests"));
    }

    @Test
    @WithMockUser
    public void submitRefundChangeRequestForm() throws Exception {
        mockMvc.perform(
                post("/change-requests/refund")
                        .with(csrf())
                        .param("clientId", "12345"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/change-requests"));
    }

    @Test
    @WithMockUser
    public void submitRemoveChangeRequestForm() throws Exception {
        mockMvc.perform(
                post("/change-requests/remove")
                        .with(csrf())
                        .param("clientId", "12345"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/change-requests"));
    }
}
