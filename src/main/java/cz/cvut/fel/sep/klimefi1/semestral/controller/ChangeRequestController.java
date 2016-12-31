package cz.cvut.fel.sep.klimefi1.semestral.controller;

import cz.cvut.fel.sep.klimefi1.semestral.dto.ClientDetailDTO;
import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import cz.cvut.fel.sep.klimefi1.semestral.form.*;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ChangeRequestRepository;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ClientRepository;
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

    private final ChangeRequestRepository repository;

    private final ChangeRequestCreator creator;

    private final ChangeRequestDeleter deleter;

    private ClientRepository clientRepository;

    @Autowired
    public ChangeRequestController(ChangeRequestRepository repository,
                                   ChangeRequestCreator creator,
                                   ChangeRequestDeleter deleter,
                                   ClientRepository clientRepository) {
        this.repository = repository;
        this.creator = creator;
        this.deleter = deleter;
        this.clientRepository = clientRepository;
    }

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
     * Displays form for creating a Create Change Request.
     *
     * @return
     */
    @GetMapping("/change-requests/add")
    public String getAdd(Model model) {
        model.addAttribute("form", new AddChangeRequestForm());
        return "change-requests/add-change-request";
    }

    /**
     * Receives submitred form for creating a Change Request.
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/change-requests/add")
    public String postAdd(@Valid @ModelAttribute AddChangeRequestForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "change-requests/add-change-request";
        }

        ChangeRequest request = form.createChangeRequest();
        try {
            creator.create(request);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully created Add Change Request with id: " + request.getId());
            return "redirect:/change-requests";
        } catch (ValidationException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Could not create Add Change Request: " + ex.getMessage());
            return "redirect:/change-requests/add";
        }
    }

    /**
     * Displays form for creating a Change Request.
     *
     * @param clientId
     * @return
     */
    @GetMapping("/change-requests/edit")
    public String getEdit(@RequestParam(name = "clientId", required = false) Long clientId, Model model) {
        EditChangeRequestForm form = new EditChangeRequestForm();
        if (clientId != null) {
            form.setClientId(clientId);
            ClientDetailDTO client = clientRepository.find(Math.toIntExact(clientId));
            if (client != null) {

                if (client.getFirstName().size() > 0) {
                    form.setFirstName(client.getFirstName().iterator().next());
                }

                if (client.getSurname().size() > 0) {
                    form.setSurname(client.getSurname().iterator().next());
                }

                if (client.getAddress().size() > 0) {
                    form.setAddress(client.getAddress().iterator().next());
                }

                if (client.getPhoneNum().size() > 0) {
                    form.setPhoneNum(client.getPhoneNum().iterator().next());
                }

                form.setBirthNum(client.getBirthNum());
                form.setCountryOfOrigin(client.getCountryOfOrigin());
            }
        }
        model.addAttribute("form", form);
        return "change-requests/edit-change-request";
    }

    /**
     * Receives submitred form for creating a Change Request.
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/change-requests/edit")
    public String postEdit(@Valid @ModelAttribute EditChangeRequestForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "change-requests/edit-change-request";
        }

        ChangeRequest request = form.createChangeRequest();
        try {
            creator.create(request);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully created Edit Change Request with id: " + request.getId());
            return "redirect:/change-requests";
        } catch (ValidationException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Could not create Edit Change Request: " + ex.getMessage());
            return "redirect:/change-requests/edit";
        }
    }

    /**
     * Displays form for creating a Change Request.
     *
     * @param clientId
     * @return
     */
    @GetMapping("/change-requests/refund")
    public String getRefund(@RequestParam(name = "clientId", required = false) Long clientId, Model model) {
        RefundChangeRequestForm form = new RefundChangeRequestForm();
        if (clientId != null) {
            form.setClientId(clientId);
        }
        model.addAttribute("form", form);
        return "change-requests/refund-change-request";
    }

    /**
     * Receives submitred form for creating a Change Request.
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/change-requests/refund")
    public String postRefund(@Valid @ModelAttribute RefundChangeRequestForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "change-requests/refund-change-request";
        }

        ChangeRequest request = form.createChangeRequest();
        try {
            creator.create(request);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully created Refund Change Request with id: " + request.getId());
            return "redirect:/change-requests";
        } catch (ValidationException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Could not create Refund Change Request: " + ex.getMessage());
            return "redirect:/change-requests/edit";
        }
    }

    /**
     * Displays form for creating a Change Request.
     *
     * @param clientId
     * @return
     */
    @GetMapping("/change-requests/suspend")
    public String getSuspend(@RequestParam(name = "clientId", required = false) Long clientId, Model model) {
        SuspendChangeRequestForm form = new SuspendChangeRequestForm();
        if (clientId != null) {
            form.setClientId(clientId);
        }
        model.addAttribute("form", form);
        return "change-requests/suspend-change-request";
    }

    /**
     * Receives submitred form for creating a Change Request.
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/change-requests/suspend")
    public String postSuspend(@Valid @ModelAttribute SuspendChangeRequestForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "change-requests/suspend-change-request";
        }

        ChangeRequest request = form.createChangeRequest();
        try {
            creator.create(request);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully created Suspend Change Request with id: " + request.getId());
            return "redirect:/change-requests";
        } catch (ValidationException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Could not create Suspend Change Request: " + ex.getMessage());
            return "redirect:/change-requests/edit";
        }
    }

    /**
     * Displays form for creating a Change Request.
     *
     * @param clientId
     * @return
     */
    @GetMapping("/change-requests/remove")
    public String getRemove(@RequestParam(name = "clientId", required = false) Long clientId, Model model) {
        RemoveChangeRequestForm form = new RemoveChangeRequestForm();
        if (clientId != null) {
            form.setClientId(clientId);
        }
        model.addAttribute("form", form);
        return "change-requests/remove-change-request";
    }

    /**
     * Receives submitred form for creating a Change Request.
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/change-requests/remove")
    public String postRemove(@Valid @ModelAttribute RemoveChangeRequestForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "change-requests/remove-change-request";
        }

        ChangeRequest request = form.createChangeRequest();
        try {
            creator.create(request);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully created Remove Change Request with id: " + request.getId());
            return "redirect:/change-requests";
        } catch (ValidationException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Could not create Remove Change Request: " + ex.getMessage());
            return "redirect:/change-requests/edit";
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
            return "redirect:/change-requests";
        }
    }
}
