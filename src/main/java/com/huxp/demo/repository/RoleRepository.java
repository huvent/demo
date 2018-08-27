package com.huxp.demo.repository;

import com.huxp.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Huxp
 * @Since: 2018/8/27 下午1:57
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,String>, CrudRepository<Role,String> {

}
