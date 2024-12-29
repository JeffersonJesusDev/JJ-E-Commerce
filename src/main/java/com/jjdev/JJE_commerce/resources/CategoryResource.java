package com.jjdev.JJE_commerce.resources;

import com.jjdev.JJE_commerce.entities.Category;
import com.jjdev.JJE_commerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {


    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> cat = categoryService.findAll();
        return ResponseEntity.ok().body(cat);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id) {
        Category cat = categoryService.findById(id);
        return ResponseEntity.ok().body(cat);
    }

}
