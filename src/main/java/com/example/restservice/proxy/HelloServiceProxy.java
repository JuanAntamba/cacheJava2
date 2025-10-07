package com.example.restservice.proxy;

import com.example.restservice.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceProxy {

    private final HelloService helloService;

    // Inyección del servicio original
    public HelloServiceProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    // Método que intercepta la llamada
    public String getGreeting(String name) {
        System.out.println("Proxy: interceptando llamada...");
        String response = helloService.getGreeting(name); // Llamada al servicio real
        System.out.println("Proxy: respuesta obtenida correctamente.");
        return response;
    }
}
