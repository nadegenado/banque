/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.models.Client;
import com.example.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author USER
 */
@Configuration
public class LoadDatabase {
      private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ClientRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Client("Bilbo Baggins", "burglar")));
      log.info("Preloading " + repository.save(new Client("Frodo Baggins", "thief")));
    };
  }
 
}

