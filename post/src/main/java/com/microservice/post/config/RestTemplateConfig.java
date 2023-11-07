package com.microservice.post.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


// RestTemplate is a class in the Spring Framework that provides a convenient way to communicate with
// RESTful web services. It simplifies the process of making HTTP requests to external APIs or services
// and handling the responses.

@Configuration
public class RestTemplateConfig {
    @Bean
   public RestTemplate getRestTemplate(){
       return new RestTemplate();
   }
}
