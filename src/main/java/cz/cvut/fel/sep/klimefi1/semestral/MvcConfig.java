package cz.cvut.fel.sep.klimefi1.semestral;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/clients").setViewName("clients");
        registry.addViewController("/client/{id}").setViewName("client");
        registry.addViewController("/change-requests").setViewName("change-requests");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/404.html").setViewName("404");
    }

}
