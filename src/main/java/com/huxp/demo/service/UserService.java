package com.huxp.demo.service;

import com.huxp.demo.controller.structure.UserRole;
import com.huxp.demo.entity.Role;
import com.huxp.demo.entity.User;
import com.huxp.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Huxp
 * @Since: 2018/8/27 下午1:58
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findOne(id);
    }

    public User linkRole(UserRole userRole) {

        User user = findById(userRole.getUserId());

        if (user == null) {
            return null;
        }
        //清空roles
        user.getRoles().clear();

        //重新授权
        List<Role> roles = roleService.findByIds(userRole.getRoleIds());

        if (roles == null || roles.isEmpty()) {
            return user;
        }

        roles.forEach(user::addRole);

        return userRepository.save(user);

    }
}
