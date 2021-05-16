package com.ticketservice.partner;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

  @Bean(name = "modelMapper")
    public ModelMapper getModelMapper() {
      ModelMapper modelMapper = new ModelMapper();
      return modelMapper;
    }
}
