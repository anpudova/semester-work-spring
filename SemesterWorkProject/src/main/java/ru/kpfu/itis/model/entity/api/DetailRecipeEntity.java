package ru.kpfu.itis.model.entity.api;

import java.util.List;

public class DetailRecipeEntity {

    private String name;
    private List<Step> steps;

    public DetailRecipeEntity(String name, List<Step> steps) {
        this.name = name;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public static class Step {
        private Integer number;
        private String step;

        public Step(Integer number, String step) {
            this.number = number;
            this.step = step;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }
    }
}
