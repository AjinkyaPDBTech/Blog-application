package com.blogger.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogger.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
