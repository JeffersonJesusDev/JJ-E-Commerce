package com.jjdev.JJE_commerce.resources;

import com.jjdev.JJE_commerce.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u =new User(1L, "Maria,", "maria@gmail.com", "11213123", "123456");
        return ResponseEntity.ok().body(u);
    }
}
