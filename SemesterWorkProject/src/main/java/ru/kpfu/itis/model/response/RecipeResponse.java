package ru.kpfu.itis.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RecipeResponse {

    @SerializedName("results")
    private List<Result> result;

    public RecipeResponse(List<Result> result) {
        this.result = result;
    }

    public List<Result> getResult() {
        return result;
    }

    public static class Result {

        @SerializedName("id")
        private Long id;

        @SerializedName("title")
        private String title;

        @SerializedName("image")
        private String image;

        @SerializedName("imageType")
        private String imageType;

        public Result(Long id, String title, String image, String imageType) {
            this.id = id;
            this.title = title;
            this.image = image;
            this.imageType = imageType;
        }

        public Long getId() {
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
