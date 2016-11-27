package cz.cvut.fel.sep.klimefi1.semestral.controller;

import cz.cvut.fel.sep.klimefi1.semestral.form.CreateChangeRequestForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ChangeRequestController {

    @GetMapping("/change-requests")
    public String list() {
        return "change-requests";
    }

    @GetMapping("/change-requests/create")
    public String getCreate(CreateChangeRequestForm form, @RequestParam(name = "clientId", required = false) Integer clientId) {
        if (clientId != null) {
            form.setClientId(clientId);
        }
        return "create-change-request";
    }

    @PostMapping("/change-requests/create")
    public String postCreate(@Valid CreateChangeRequestForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-change-request";
        }
        return "redirect:/change-requests";
    }
}
