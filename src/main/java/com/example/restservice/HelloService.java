package com.example.restservice;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Cacheable("greetings")
    public String getGreeting(String name) {
        simulateSlowService();
        return "Hola " + name + ", bienvenido al servicio REST con caché.";
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000L); // simula una operación lenta
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
