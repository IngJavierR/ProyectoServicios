package mx.com.curso.services.facade.impl;

import mx.com.curso.commons.to.UserTO;
import mx.com.curso.services.facade.IMicroservicioFacade;
import mx.com.curso.services.service.IMicroservicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class MicroservicioFacade implements IMicroservicioFacade {

    @Value("${MICROSERVICE_TWO_SVC_SERVICE_HOST}")
    private String serviceHost;
    @Value("${MICROSERVICE_TWO_SVC_SERVICE_PORT}")
    private String servicePort;

    @Autowired
    private IMicroservicioService microservicioService;

    @Autowired
    RestTemplate restTemplate;

    public List<UserTO> getAllUsers() {
        //ResponseEntity<UserTO[]> response = restTemplate.getForEntity(String.format("http://%s:%s/microservicio/users", serviceHost, servicePort), UserTO[].class);
        ResponseEntity<UserTO[]> response = restTemplate.getForEntity(String.format("http://%s:%s/microservicio/users", "microservice-two-svc.default.svc.cluster.local", servicePort), UserTO[].class);
        return Arrays.asList(response.getBody());
        //return this.microservicioService.getUsers();
    }
}
