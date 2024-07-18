package com.shearing.blog.controller;

import com.shearing.blog.model.Recipe;
import com.shearing.blog.services.RecipeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/recipe")
@CrossOrigin
public class RecipeController {

    @Autowired
    private RecipeServices recipeServices;

    private static String UPLOADED_FOLDER = "path_to_your_upload_directory/";

    @PostMapping("/add")
    public String saveRecipe
   (@RequestParam("Title") String title,
    @RequestParam("Description") String description,
    @RequestParam("Ingredients") String ingredients,
    @RequestParam("Image") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select an image to upload.";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            Recipe recipe = new Recipe();
            recipe.setTitle(title);
            recipe.setDescription(description);
            recipe.setIngredients(ingredients);
            recipe.setImage(file.getOriginalFilename());

            recipeServices.saveRecipe(recipe);
            return "Recipe Saved";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save recipe";
        }
    }

    @GetMapping("/get")
    public List<Recipe> getInfo() {
        return recipeServices.getInfo();
    }
}
