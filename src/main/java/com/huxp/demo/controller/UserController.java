package com.huxp.demo.controller;

import com.huxp.core.annotation.Json;
import com.huxp.demo.controller.structure.UserRole;
import com.huxp.demo.entity.User;
import com.huxp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Huxp
 * @Since: 2018/8/27 下午1:59
 */
@RestController
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/sys/user/insert", method = RequestMethod.POST)
    public @ResponseBody
    User insertUser(@RequestBody User user) {
        return userService.save(user);
    }

    @Json(type = User.class)
    @RequestMapping(value = "/sys/user/list", method = RequestMethod.GET)
    public @ResponseBody
    List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/sys/user/insertRole", method = RequestMethod.POST)
    public @ResponseBody User linkRole(@RequestBody UserRole userRole){
        return  userService.linkRole(userRole);
    }


}
