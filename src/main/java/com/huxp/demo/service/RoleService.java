package com.huxp.demo.service;

import com.huxp.demo.entity.Role;
import com.huxp.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Huxp
 * @Since: 2018/8/27 下午1:58
 */
@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(String id) {
        return roleRepository.findOne(id);
    }

    public List<Role> findByIds(List<String> ids) {
        return roleRepository.findAll(ids);
    }
}
