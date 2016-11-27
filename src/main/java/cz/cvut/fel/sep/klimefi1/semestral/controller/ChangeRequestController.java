package cz.cvut.fel.sep.klimefi1.semestral.controller;

import cz.cvut.fel.sep.klimefi1.semestral.form.CreateChangeRequestForm;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ChangeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ChangeRequestController {

    @Autowired
    private ChangeRequestRepository repository;

    /**
     * Lists all Change Requests in a table.
     * @param model
     * @return
     */
    @GetMapping("/change-requests")
    public String list(Model model) {
        model.addAttribute("changeRequests", repository.findAll());
        return "change-requests";
    }

    /**
     * Displays form for creating a Change Request.
     * @param form
     * @param clientId
     * @return
     */
    @GetMapping("/change-requests/create")
    public String getCreate(CreateChangeRequestForm form, @RequestParam(name = "clientId", required = false) Long clientId) {
        if (clientId != null) {
            form.setClientId(clientId);
        }
        return "create-change-request";
    }

    /**
     * Receives submited form for creating a Change Request.
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/change-requests/create")
    public String postCreate(@Valid CreateChangeRequestForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-change-request";
        }
        return "redirect:/change-requests";
    }

    public void setRepository(ChangeRequestRepository repository) {
        this.repository = repository;
    }
}
