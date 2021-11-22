package com.songpa.songpaalgo.board.controller;

import com.songpa.songpaalgo.board.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/test")
    public ResponseEntity<User> test(@RequestBody User user) {

        System.out.println( user.getId() + " : " + user.getName() );
        return null;
    }

    @PutMapping("/put-test/{id}")
    public ResponseEntity<User> putTest(@PathVariable int id, @RequestBody User user) {
        System.out.println( user.getId() + " : " + user.getName() + " : " + id );
        return null;
    }

    @DeleteMapping("/del-test/{id}")
    public ResponseEntity<User> delTest(@PathVariable int id, @RequestBody User user) {
        System.out.println( user.getId() + " : " + user.getName() + " : " + id );
        return null;
    }

}
