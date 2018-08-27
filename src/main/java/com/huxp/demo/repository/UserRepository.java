package com.huxp.demo.repository;

import com.huxp.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Huxp
 * @Since: 2018/8/27 下午1:56
 */
@Repository
public interface UserRepository extends JpaRepository<User,String> , CrudRepository<User,String> {

}
