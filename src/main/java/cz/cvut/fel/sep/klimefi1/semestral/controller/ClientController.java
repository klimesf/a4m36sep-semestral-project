package cz.cvut.fel.sep.klimefi1.semestral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {

    @RequestMapping("/clients")
    public String list() {
        return "clients";
    }

    @RequestMapping("/client/{id}")
    public String detail(@PathVariable Integer id, Model model) { return "client"; }

}
