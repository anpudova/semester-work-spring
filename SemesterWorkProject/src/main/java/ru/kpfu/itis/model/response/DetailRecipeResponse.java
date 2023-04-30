package ru.kpfu.itis.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class DetailRecipeResponse extends ArrayList<DetailRecipeResponse.Result> {

    public static class Result {
        @SerializedName("name")
        private String name;
        @SerializedName("steps")
        private List<Step> steps;

        public String getName() {
            return name;
        }

        public List<Step> getSteps() {
            return steps;
        }
    }

    public static class Step {
        @SerializedName("equipment")
        private List<Equipment> equipment = null;
        @SerializedName("ingredients")
        private List<Ingredients> ingredients = null;
        @SerializedName("length")
        private Length len = null;
        @SerializedName("number")
        private Integer number;
        @SerializedName("step")
        private String step;

        public List<Equipment> getEquipment() {
            return equipment;
        }

        public List<Ingredients> getIngredients() {
            return ingredients;
        }

        public Length getLen() {
            return len;
        }

        public Integer getNumber() {
            return number;
        }

        public String getStep() {
            return step;
        }
    }

    public static class Equipment {
        @SerializedName("id")
        private Long id;
        @SerializedName("image")
        private String image;
        @SerializedName("name")
        private String name;
        @SerializedName("temperature")
        private Temperature temp = null;

        public Long getId() {
            return id;
        }

        public String getImage() {
            return image;
        }

        public String getName() {
            return name;
        }

        public Temperature getTemp() {
            return temp;
        }
    }

    public static class Ingredients {
        @SerializedName("id")
        private Long id;
        @SerializedName("image")
        private String image;
        @SerializedName("name")
        private String name;

        public Long getId() {
            return id;
        }

        public String getImage() {
            return image;
        }

        public String getName() {
            return name;
        }
    }

    public static class Temperature {
        @SerializedName("number")
        private Double num;
        @SerializedName("unit")
        private String unit;

        public Double getNum() {
            return num;
        }

        public String getUnit() {
            return unit;
        }
    }

    public static class Length {
        @SerializedName("number")
        private Integer number;
        @SerializedName("unit")
        private String unit;


        public Integer getNumber() {
            return number;
        }

        public String getUnit() {
            return unit;
        }
    }
}