package com.example.Library.controller;

        import com.example.Library.dto.request.AuthenticationRequest;
        import com.example.Library.dto.request.RegisterRequest;
        import com.example.Library.dto.respone.AuthenticationResponse;
        import com.example.Library.dto.respone.ResponeMessage;
        import com.example.Library.service.AuthenticationService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<ResponeMessage> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
