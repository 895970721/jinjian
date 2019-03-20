package com.fiveonezero.jinjianzi.Repository;

import com.fiveonezero.jinjianzi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    //登陆
    @Query(value = "select * from user where username = ?1 and password = ?2",nativeQuery = true)
    List<User> findByUsernameAndUserpassword(String username, String password);

    //注册，通过username查找用户
    @Query(value = "select * from user where username = ?1",nativeQuery = true)
    List<User> findByUsername(String username);

    //通过username查找用户信息
}
