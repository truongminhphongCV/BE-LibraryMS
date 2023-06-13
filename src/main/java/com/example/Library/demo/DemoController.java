package com.example.Library.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo-controller")
@CrossOrigin("http://localhost:3000")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
    @PostMapping
    public ResponseEntity<String> sayHello1() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
    @PutMapping
    public ResponseEntity<String> sayHello2() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
    @DeleteMapping
    public ResponseEntity<String> sayHello3() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

}