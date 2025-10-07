package com.example.restservice;

import org.springframework.web.bind.annotation.*;
import com.example.restservice.proxy.HelloServiceProxy;

@RestController
@RequestMapping("/api")          // Prefijo para todos los endpoints
@CrossOrigin(origins = "*")     // Habilita CORS para cualquier frontend
public class GreetingController {

    private final HelloServiceProxy helloProxy;

    // Inyección de dependencias del proxy
    public GreetingController(HelloServiceProxy helloProxy) {
        this.helloProxy = helloProxy;
    }

    // Endpoint GET: /api/hello/{name}
    @GetMapping("/hello/{name}")
    public String getGreeting(@PathVariable String name) {
        return helloProxy.getGreeting(name);
    }
}
