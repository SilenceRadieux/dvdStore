package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.DvdStoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DvdStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(DvdStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DvdStoreApplication.class);
	}

	@Bean
	public CommandLineRunner demo(DvdStoreRepository repository) {
		return (args) -> {
			repository.save(new DvdModel("The Matrix", "Action"));
			repository.save(new DvdModel("The Matrix Reloaded", "Action"));
			repository.save(new DvdModel("The Matrix Revolutions", "Action"));
			repository.save(new DvdModel("The Matrix Resurrections", "Action"));

			log.info("DvdModel found with findAll():");
			log.info("-------------------------------");


			DvdModel dvdModel = repository.findById(152L);
			log.info("DvdModel found with findById(1L):");
			log.info("--------------------------------");
			log.info(dvdModel.toString());
			log.info("");

			log.info("DvdModel found with findByLastName('The Matrix'):");
			log.info("--------------------------------------------");
			repository.findByName("The Matrix").forEach(
					theMatrix -> log.info(theMatrix.toString())
			);
			log.info("");
		};
	}

}
