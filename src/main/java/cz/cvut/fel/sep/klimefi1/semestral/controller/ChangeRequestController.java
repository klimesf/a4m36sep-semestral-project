package cz.cvut.fel.sep.klimefi1.semestral.controller;

import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import cz.cvut.fel.sep.klimefi1.semestral.form.CreateChangeRequestForm;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ChangeRequestRepository;
import cz.cvut.fel.sep.klimefi1.semestral.service.ChangeRequestCreator;
import cz.cvut.fel.sep.klimefi1.semestral.service.ChangeRequestDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.ValidationException;

@Controller
public class ChangeRequestController {

    @Autowired
    private ChangeRequestRepository repository;

    @Autowired
    private ChangeRequestCreator creator;

    @Autowired
    private ChangeRequestDeleter deleter;

    /**
     * Lists all Change Requests in a table.
     *
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
     *
     * @param clientId
     * @return
     */
    @GetMapping("/change-requests/create")
    public String getCreate(@RequestParam(name = "clientId", required = false) Long clientId, Model model) {
        CreateChangeRequestForm form = new CreateChangeRequestForm();
        if (clientId != null) {
            form.setClientId(clientId);
        }
        model.addAttribute("form", form);
        return "create-change-request";
    }

    /**
     * Receives submitred form for creating a Change Request.
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/change-requests/create")
    public String postCreate(@Valid @ModelAttribute CreateChangeRequestForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create-change-request";
        }

        ChangeRequest request = form.createChangeRequest();
        try {
            creator.create(request);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully created Change Request with id: " + request.getId());
            return "redirect:/change-requests";
        } catch (ValidationException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Could not create Change Request: " + ex.getMessage());
            return "redirect:/change-requests/create";
        }
    }

    /**
     * Deletes ChangeRequest with given id.
     *
     * @param id
     * @return
     */
    @GetMapping("/change-requests/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Boolean result = deleter.delete(id);
        if (result) {
            redirectAttributes.addFlashAttribute("successMessage", "Successfully deleted Change Request with id: " + id);
            return "redirect:/change-requests";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Could not delete Change Request with id: " + id);
            return "redirect:/change-requests/create";
        }
    }
}
