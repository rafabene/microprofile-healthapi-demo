package com.rafabene.demo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

@Liveness
@Readiness
@ApplicationScoped
public class MyHealthCheck implements HealthCheck {

    @Inject
    private HelloResource hr;

    @Override
    public HealthCheckResponse call() {
        Response response =  hr.hello();
        HealthCheckResponseBuilder hResponseBuilder = HealthCheckResponse.builder()
            .name("hello").withData("statusCode", response.getStatus());
        if (response.getStatus() > 500){
            return hResponseBuilder.down().build();
        }else{
            return hResponseBuilder.up().build();        
        }
    }

}