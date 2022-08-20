package com.example.demospring1.bt.repository.database;

import com.example.demospring1.bt.model.enity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesDB extends JpaRepository<Categories, Integer> {

}

