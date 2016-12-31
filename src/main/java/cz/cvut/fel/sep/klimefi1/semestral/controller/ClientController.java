package cz.cvut.fel.sep.klimefi1.semestral.controller;

import cz.cvut.fel.sep.klimefi1.semestral.exception.NotFoundException;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.WebServiceException;

@Controller
public class ClientController {

    private final ClientRepository repository;

    @Autowired
    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/clients")
    public String list(Model model) {
        try {
            model.addAttribute("clients", repository.findAll());
        } catch (WebServiceException e) {
            model.addAttribute("errorMessage", "Failed to connect to Profinit API.");
            model.addAttribute("clients", null);
        }
        return "clients";
    }

    @RequestMapping("/client/{id}")
    public String detail(@PathVariable Integer id, Model model) throws NotFoundException {
        try {
            model.addAttribute("client", repository.find(id));
        } catch (WebServiceException e) {
            model.addAttribute("errorMessage", "Failed to connect to Profinit API.");
            model.addAttribute("client", null);
        }
        return "client";
    }

}
