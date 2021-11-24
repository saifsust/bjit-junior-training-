package org.mvctraining.controller;

import org.mvctraining.jdbc.UserRepository;
import org.mvctraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    public static final String INDEX_ROUTE = "/";
    public static final String INDEX_BY_USER_ID_ROUTE = "/{userId}";
    public static final String DELETE_BY_USER_ID_ROUTE = "/delete/{userId}";
    public static final String DB_USER_JDBC_ROUTE = "/user-from-db";
    public static final String DB_USER_JPA_ROUTE = "/user-from-db/jpa";

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public HomeController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @RequestMapping(path = {INDEX_ROUTE+"db"}, method = RequestMethod.GET)
    public String indexFromDB(ModelMap modelMap){
        modelMap.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @RequestMapping(path = {INDEX_ROUTE}, method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.addAttribute("users", userService.findAll());
        return "index";
    }


    @RequestMapping(path = {INDEX_BY_USER_ID_ROUTE}, method = RequestMethod.GET)
    public String user(@PathVariable("userId") int userId, ModelMap modelMap){
        modelMap.addAttribute("users", userService.findUserByUserId(userId));
        return "index";
    }

    @RequestMapping(path = {DELETE_BY_USER_ID_ROUTE}, method = RequestMethod.GET)
    public String delete(@PathVariable("userId") int userId, ModelMap modelMap){
        modelMap.addAttribute("users", userService.deleteByUserId(userId));
        return "index";
    }


}
