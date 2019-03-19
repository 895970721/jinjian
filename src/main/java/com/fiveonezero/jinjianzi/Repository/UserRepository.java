package com.fiveonezero.jinjianzi.Repository;

import com.fiveonezero.jinjianzi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
