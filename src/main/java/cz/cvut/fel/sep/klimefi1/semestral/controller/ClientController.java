package cz.cvut.fel.sep.klimefi1.semestral.controller;

import cz.cvut.fel.sep.klimefi1.semestral.exception.NotFoundException;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.WebServiceException;
import java.math.BigInteger;
import java.util.logging.Logger;

@Controller
public class ClientController {

    private final ClientRepository repository;

    private final Logger logger = Logger.getGlobal();

    @Autowired
    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/clients")
    public String list(@RequestParam(required = false, name = "page", defaultValue = "1") Integer page, Model model) {
        try {
            model.addAttribute(
                    "clients",
                    repository.findAll(
                            BigInteger.valueOf(50L),
                            BigInteger.valueOf((page - 1) * 50L)
                    )
            );
            model.addAttribute("nextPage", page + 1);
        } catch (WebServiceException e) {
            logger.warning("Failed to retrieve list of clients: " + e.getMessage());
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
            logger.warning("Failed to retrieve detail of client: " + e.getMessage());
            model.addAttribute("errorMessage", "Failed to connect to Profinit API.");
            model.addAttribute("client", null);
        }
        return "client";
    }

}
