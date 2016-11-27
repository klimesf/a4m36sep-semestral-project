package cz.cvut.fel.sep.klimefi1.semestral;

import cz.cvut.fel.sep.klimefi1.semestral.entity.ChangeRequest;
import cz.cvut.fel.sep.klimefi1.semestral.repository.ChangeRequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner createDefaultData(ChangeRequestRepository repository) {
        return (args) -> {
            repository.save(new ChangeRequest(null, ChangeRequest.Type.ADD, "Name: John Doe"));
            repository.save(new ChangeRequest(101L, ChangeRequest.Type.REMOVE, null));
            repository.save(new ChangeRequest(102L, ChangeRequest.Type.CHANGE_DATA, "Name: Chuck Norris"));
            repository.save(new ChangeRequest(103L, ChangeRequest.Type.REFUND, "Reason: ..."));
            repository.save(new ChangeRequest(100L, ChangeRequest.Type.SUSPEND, "Reason: Violation of agreements"));
        };
    }
}
