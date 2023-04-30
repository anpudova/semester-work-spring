package ru.kpfu.itis.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IngredientResponse {

    @SerializedName("ingredients")
    private List<Result> results;

    public IngredientResponse(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public static class Result {
        @SerializedName("amount")
        private Amount amount;

        @SerializedName("image")
        private String image;

        @SerializedName("name")
        private String name;

        public Result(Amount amount, String image, String name) {
            this.amount = amount;
            this.image = image;
            this.name = name;
        }

        public Amount getAmount() {
            return amount;
        }

        public String getImage() {
            return image;
        }

        public String getName() {
            return name;
        }
    }

    public static class Amount {

        @SerializedName("metric")
        private UnitValue metric;

        @SerializedName("us")
        private UnitValue us;

        public Amount(UnitValue metric, UnitValue us) {
            this.metric = metric;
            this.us = us;
        }

        public UnitValue getMetric() {
            return metric;
        }

        public UnitValue getUs() {
            return us;
        }
    }

    public static class UnitValue {

        @SerializedName("unit")
        private String unit;

        @SerializedName("value")
        private Float value;

        public UnitValue(String unit, Float value) {
            this.unit = unit;
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public Float getValue() {
            return value;
        }
    }
}
