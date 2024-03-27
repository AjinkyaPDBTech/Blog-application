package com.blogger.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogger.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
