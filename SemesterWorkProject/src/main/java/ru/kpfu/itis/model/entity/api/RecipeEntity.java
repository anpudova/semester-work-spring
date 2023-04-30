package ru.kpfu.itis.model.entity.api;

import java.util.List;

public class RecipeEntity {
    private List<RecipeEntity> recipes;

    public RecipeEntity(List<RecipeEntity> recipes) {
        this.recipes = recipes;
    }

    public List<RecipeEntity> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeEntity> recipes) {
        this.recipes = recipes;
    }

    public static class Result {
        private Long id;
        private String title;
        private String image;
        private String imageType;

        public Result(Long id, String title, String image, String imageType) {
            this.id = id;
            this.title = title;
            this.image = image;
            this.imageType = imageType;
        }

        public long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public String getImageType() {
            return imageType;
        }
    }
}
