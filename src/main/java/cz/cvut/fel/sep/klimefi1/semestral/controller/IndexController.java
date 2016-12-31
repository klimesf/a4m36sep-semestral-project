package cz.cvut.fel.sep.klimefi1.semestral.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = ERROR_PATH)
    public String error() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
