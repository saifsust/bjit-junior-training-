package org.mvctraining.controller;

import org.mvctraining.jdbc.UserRepository;
import org.mvctraining.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    private final UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = {HomeController.DB_USER_JDBC_ROUTE}, produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> getUserFromDBUsingJDBC(){
        return  new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = {HomeController.DB_USER_JDBC_ROUTE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<User> insert(@RequestBody User user){
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping(path = {HomeController.DB_USER_JDBC_ROUTE +"/{userId}"}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<User> delete(@PathVariable("userId") int userid){
        return new ResponseEntity<User>(userRepository.delete(userid), HttpStatus.ACCEPTED);
    }

    @PatchMapping(path = {HomeController.DB_USER_JDBC_ROUTE +"/{userId}"}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<User> getOne(@PathVariable("userId") int userid){
        return new ResponseEntity<User>(userRepository.findUserByUserId(userid), HttpStatus.ACCEPTED);
    }
    @PutMapping(path = {HomeController.DB_USER_JDBC_ROUTE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<User> update(@RequestBody User user){
        return new ResponseEntity<User>(userRepository.update(user), HttpStatus.ACCEPTED);
    }

    // JDBC


}
