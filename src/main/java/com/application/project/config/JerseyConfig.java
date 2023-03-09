package com.application.project.config;

import org.springframework.stereotype.Component;
import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/")
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        this.packages("com.application.project.controllers");
    }
}
