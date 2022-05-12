package com.sha.springbootmicroservice3gateway.controller;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("gateway/user")
public class UserController
{
    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JsonElement product)
    {
        return ResponseEntity.ok(userService.add(product));
    }

    @GetMapping("/findbyemail")
    public ResponseEntity<?> findByEmail(@RequestParam String email)
    {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @GetMapping("/getall")
    public ResponseEntity<?> findAllUsers()
    {
        return ResponseEntity.ok(userService.findAllUsers());
    }
}
