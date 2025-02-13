package fr.khj.gettingstarted;

import fr.khj.gettingstarted.model.StudentEntity;
import fr.khj.gettingstarted.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(StudentRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new StudentEntity("Jill Royce", "Preps")));
            log.info("Preloading " + repository.save(new StudentEntity("Rusty Burgmeister", "Dik")));
        };
    }
}