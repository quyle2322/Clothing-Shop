package com.poly.service;

import com.poly.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategory(int id);
}
