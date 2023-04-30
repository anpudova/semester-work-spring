package ru.kpfu.itis.model.entity.api;

import java.util.List;

public class IngredientEntity {
    private List<Result> ingredients;

    public IngredientEntity(List<Result> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Result> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Result> ingredients) {
        this.ingredients = ingredients;
    }

    public static class Result {
        private String unit;
        private Float value;
        private String name;

        public Result(String unit, Float value, String name) {
            this.unit = unit;
            this.value = value;
            this.name = name;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public float getValue() {
            return value;
        }

        public void setValue(Float value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

