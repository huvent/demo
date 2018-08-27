package com.huxp.demo.controller;

import com.huxp.demo.entity.Role;
import com.huxp.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Huxp
 * @Since: 2018/8/27 下午2:01
 */
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/sys/role/insert", method = RequestMethod.POST)
    public @ResponseBody
    Role insert(@RequestBody Role role) {
        return roleService.save(role);
    }

    @RequestMapping(value = "/sys/role/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Role> findAll() {
        return roleService.findAll();
    }

}
