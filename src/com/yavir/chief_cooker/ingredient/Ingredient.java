package com.yavir.chief_cooker.ingredient;

import java.util.Objects;

public abstract class Ingredient implements Comparable<Ingredient>{

    private static final int MAX_INGREDIENT_NAME_LENGTH = 60;

    private String ingredientName;
    private double weighInGrams;
    private double caloriesPerHundredGrams;
    private double fatsPerHundredGrams;
    private double proteinsPerHundredGrams;
    private double carbohydratesPerHundredGrams;


    public Ingredient(String ingredientName, double weighInGrams, double caloriesPerHundredGrams,
                      double fatsPerHundredGrams, double proteinsPerHundredGrams, double carbohydratesPerHundredGrams) {
        setIngredientName(ingredientName);
        setWeight(weighInGrams);
        setCaloriesPerHundredGrams(caloriesPerHundredGrams);
        setFatsPerHundredGrams(fatsPerHundredGrams);
        setProteinsPerHundredGrams(proteinsPerHundredGrams);
        setCarbohydratesPerHundredGrams(carbohydratesPerHundredGrams);
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public double getWeighInGrams() {
        return weighInGrams;
    }

    public double getCaloriesPerHundredGrams() {
        return caloriesPerHundredGrams;
    }

    public double getFatsPerHundredGrams() {
        return fatsPerHundredGrams;
    }

    public double getProteinsPerHundredGrams() {
        return proteinsPerHundredGrams;
    }

    public double getCarbohydratesPerHundredGrams() {
        return carbohydratesPerHundredGrams;
    }

    public void setIngredientName(String ingredientName) {
        if (!ingredientName.isBlank() && !ingredientName.isEmpty() && ingredientName.length() < MAX_INGREDIENT_NAME_LENGTH){
            this.ingredientName = ingredientName;
        } else {
            throw new IllegalArgumentException("Illegal vegetable name");
        }
    }

    public void setWeight(double weighInGrams) {
        if (weighInGrams > 0){
            this.weighInGrams = weighInGrams;
        } else {
            throw new IllegalArgumentException("A vegetable cannot have zero weight or less");
        }
    }

    public void setCaloriesPerHundredGrams(double caloriesPerHundredGrams) {
        if (caloriesPerHundredGrams > 0){
            this.caloriesPerHundredGrams = caloriesPerHundredGrams;
        } else {
            throw new IllegalArgumentException("Calories per 100 gram cannot be zero or less");
        }
    }

    public void setFatsPerHundredGrams(double fatsPerHundredGrams) {
        if (fatsPerHundredGrams >= 0){
            this.fatsPerHundredGrams = fatsPerHundredGrams;
        } else {
            throw new IllegalArgumentException("Fats per 100 gram cannot be negative");
        }
    }

    public void setProteinsPerHundredGrams(double proteinsPerHundredGrams) {
        if (proteinsPerHundredGrams >= 0){
            this.proteinsPerHundredGrams = proteinsPerHundredGrams;
        } else {
            throw new IllegalArgumentException("Proteins per 100 gram cannot be negative");
        }
    }

    public void setCarbohydratesPerHundredGrams(double carbohydratesPerHundredGrams) {
        if (carbohydratesPerHundredGrams >= 0){
            this.carbohydratesPerHundredGrams = carbohydratesPerHundredGrams;
        } else {
            throw new IllegalArgumentException("Carbohydrates per 100 gram cannot be negative");
        }
    }

    public double calculateCalories() {
        return (getCaloriesPerHundredGrams() * getWeighInGrams()) / 100;
    }

    public double calculateFats() {
        return (getFatsPerHundredGrams() * getWeighInGrams()) / 100;
    }

    public double calculateProteins() {
        return (getProteinsPerHundredGrams() * getWeighInGrams()) / 100;
    }

    public double calculateCarbohydrates() {
            return (getCarbohydratesPerHundredGrams() * getWeighInGrams()) / 100;
    }

    public String getNutritionalValue() {
        return "\tWeight " + String.format("%,.2f", getWeighInGrams()) + "g" +
                "\n\tCalories " + String.format("%,.2f", calculateCalories()) +
                "\n\tFat " + String.format("%,.2f", calculateFats()) + "g" +
                "\n\tCarbohydrate " + String.format("%,.2f", calculateCarbohydrates()) + "g" +
                "\n\tProtein " + String.format("%,.2f", calculateProteins()) + "g";
    }

    @Override
    public String toString() {
        return getIngredientName() + ":\n" + getNutritionalValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(that.weighInGrams, weighInGrams) == 0 && Double.compare(that.caloriesPerHundredGrams, caloriesPerHundredGrams) == 0 && Double.compare(that.fatsPerHundredGrams, fatsPerHundredGrams) == 0 && Double.compare(that.proteinsPerHundredGrams, proteinsPerHundredGrams) == 0 && Double.compare(that.carbohydratesPerHundredGrams, carbohydratesPerHundredGrams) == 0 && ingredientName.equals(that.ingredientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientName, weighInGrams, caloriesPerHundredGrams, fatsPerHundredGrams, proteinsPerHundredGrams, carbohydratesPerHundredGrams);
    }
}
