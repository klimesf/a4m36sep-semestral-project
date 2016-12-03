package cz.cvut.fel.sep.klimefi1.semestral.controller;

import cz.cvut.fel.sep.klimefi1.semestral.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {

    private final ClientRepository repository;

    @Autowired
    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/clients")
    public String list(Model model) {
        model.addAttribute("clients", repository.findAll());
        return "clients";
    }

    @RequestMapping("/client/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("client", repository.find(id));
        return "client";
    }

}
