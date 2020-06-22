package org.sid.formation;

import org.sid.formation.dao.FormationRepository;
import org.sid.formation.dao.ProfileRepository;
import org.sid.formation.entities.Formation;
import org.sid.formation.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class FormationApplication {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(FormationApplication.class, args);
    }

    @Bean
    CommandLineRunner start(FormationRepository formationRepository, ProfileRepository profileRepository) {
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Formation.class);
            repositoryRestConfiguration.exposeIdsFor(Profile.class);
            Stream.of("F1 Formation1", "F2 Formation", "F3 Formation").forEach(f -> {
                formationRepository.save(new Formation(f.split("")[0], "Formation1", "formation.png", "mécanique", "Coach1", 100, "15/01/1900"));

            });
            formationRepository.findAll().forEach(System.out::println);
            Stream.of("P1 Profile1", "P2 Profile2", "P3 Profile3", "P4 Profile4").forEach(p -> {
                profileRepository.save(new Profile(p.split("")[0], "Profile1", "lastname", "adresse", "xyz@gmail.com", "1234568", "8100"));
            });
            profileRepository.findAll().forEach(System.out::println);
        };

    }
}
