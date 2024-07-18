package com.shearing.blog.services;

import com.shearing.blog.model.Recipe;
import com.shearing.blog.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService implements RecipeServices {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe;
    }

    @Override
    public List<Recipe> getInfo() {
        return recipeRepository.findAll();
    }
}
