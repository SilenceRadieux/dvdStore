package com.simplon.dvdstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DvdStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(DvdStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DvdStoreApplication.class);
	}

}
