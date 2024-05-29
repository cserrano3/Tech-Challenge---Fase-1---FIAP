package com.patasamigas.webapi.adapter.controllers;

import com.patasamigas.webapi.adapter.controllers.dtos.user.RegisterUserDTO;
import com.patasamigas.webapi.adapter.controllers.dtos.user.UserLoginDTO;
import com.patasamigas.webapi.adapter.controllers.dtos.user.RecoverTokenDTO;
import com.patasamigas.webapi.application.useCases.AuthenticateUserUseCase;
import com.patasamigas.webapi.application.useCases.RegisterUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final RegisterUserUseCase registerUserUseCase;
    private final AuthenticateUserUseCase authenticateUserUseCase;

    public UserController(RegisterUserUseCase registerUserUseCase, AuthenticateUserUseCase authenticateUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<RecoverTokenDTO> authenticateUser(@Valid @RequestBody UserLoginDTO loginUserDto) throws Exception {
        try {
            RecoverTokenDTO token = authenticateUserUseCase.authenticateUser(loginUserDto);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch(Exception e) {
            throw new Exception(e);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> createUser(@RequestBody RegisterUserDTO newUserData) {
        this.registerUserUseCase.createUser(newUserData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<String> getAuthenticationTest() {
        return new ResponseEntity<>("Authentication Successfull", HttpStatus.OK);
    }

    @GetMapping("/test/customer")
    public ResponseEntity<String> getCustomerAuthenticationTest() {
        return new ResponseEntity<>("Cliente autenticado com sucesso", HttpStatus.OK);
    }

    @GetMapping("/test/administrator")
    public ResponseEntity<String> getAdminAuthenticationTest() {
        return new ResponseEntity<>("Administrador autenticado com sucesso", HttpStatus.OK);
    }

}