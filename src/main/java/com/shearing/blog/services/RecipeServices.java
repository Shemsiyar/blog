package com.shearing.blog.services;

import com.shearing.blog.model.Recipe;

import java.util.List;

public interface RecipeServices {
    Recipe saveRecipe(Recipe recipe);

    List<Recipe> getInfo();
}
