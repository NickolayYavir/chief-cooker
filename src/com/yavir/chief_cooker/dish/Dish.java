package com.yavir.chief_cooker.dish;

import com.yavir.chief_cooker.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Dish {

    private static final int MAX_DISH_NAME_LENGTH = 120;

    private String dishName;
    private double dishWeight;
    private double dishFats;
    private double dishCarbohydrates;
    private double dishProteins;

    List<Ingredient> ingredients = new ArrayList<>();

    public Dish(String dishName, Ingredient... ingredients){
        setDishName(dishName);
        setIngredients(ingredients);
        setNutritionalValue(getIngredients());
    }

    public String getDishName() {
        return dishName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public double getDishWeight() {
        return dishWeight;
    }

    public double getDishFats() {
        return dishFats;
    }

    public double getDishCarbohydrates() {
        return dishCarbohydrates;
    }

    public double getDishProteins() {
        return dishProteins;
    }

    public void setIngredients(Ingredient... ingredients) {
        if (ingredients.length > 1){
            this.ingredients.addAll(Arrays.stream(ingredients).toList());
        } else {
            throw new IllegalArgumentException("Dish have to contain two and more ingredients");
        }
        for (int i = 0; i < ingredients.length; i++) {
            for (int j = 0; j < ingredients.length; j++) {
                if (i != j && ingredients[i].getIngredientName().equals(ingredients[j].getIngredientName())){
                    throw new IllegalArgumentException("A dish cannot contain the same ingredient");
                }
            }
        }

    }

    public void setDishName(String dishName) {
        if (!dishName.isBlank() && !dishName.isEmpty() && dishName.length() < MAX_DISH_NAME_LENGTH){
            this.dishName = dishName;
        } else {
            throw new IllegalArgumentException("Illegal dish name");
        }
    }

    private void setNutritionalValue(List<Ingredient> ingredients) {
        this.dishWeight = calculateWeight(ingredients);
        this.dishFats = calculateFats(ingredients);
        this.dishCarbohydrates = calculateCarbohydrates(ingredients);
        this.dishProteins = calculateProteins(ingredients);
    }

    private double calculateWeight(List<Ingredient> ingredients) {
        double result = 0;
        for (Ingredient ingredient : ingredients){
            result += ingredient.getWeighInGrams();
        }
        return result;
    }

    private double calculateFats(List<Ingredient> ingredients) {
        double result = 0;
        for (Ingredient ingredient : ingredients){
            result += ingredient.calculateFats();
        }
        return result;
    }

    private double calculateCarbohydrates(List<Ingredient> ingredients) {
        double result = 0;
        for (Ingredient ingredient : ingredients){
            result += ingredient.calculateCarbohydrates();
        }
        return result;
    }

    private double calculateProteins(List<Ingredient> ingredients) {
        double result = 0;
        for (Ingredient ingredient : ingredients){
            result += ingredient.calculateProteins();
        }
        return result;
    }

    public void printIngredients() {
        System.out.println("\n" + getDishName() + " ingredients:");
        ingredients.forEach(el -> System.out.println(el.getIngredientName() + " " + el.getWeighInGrams() + "g"));
    }

    public void printIngredientsDetail() {
        System.out.println("\n" + getDishName() + " ingredients details:");
        ingredients.forEach(System.out::println);
    }

    public void printIngredientsCaloriesRange(Double rangeStart, Double rangeEnd) {
        ingredients.forEach(el -> {
            if (el.calculateCalories() > rangeStart && el.calculateCalories() < rangeEnd){
                System.out.println(el);
            }
        });
    }

    @Override
    public String toString() {
        return getDishName() + ":\n\tWeight " + String.format("%,.2f", getDishWeight())  + "g" +
                "\n\tFats " + String.format("%,.2f", getDishFats()) + "g" +
                "\n\tCarbohydrates " + String.format("%,.2f", getDishCarbohydrates()) + "g" +
                "\n\tProteins " + String.format("%,.2f", getDishProteins()) + "g";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.dishWeight, dishWeight) == 0 && Double.compare(dish.dishFats, dishFats) == 0 && Double.compare(dish.dishCarbohydrates, dishCarbohydrates) == 0 && Double.compare(dish.dishProteins, dishProteins) == 0 && dishName.equals(dish.dishName) && ingredients.equals(dish.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishName, dishWeight, dishFats, dishCarbohydrates, dishProteins, ingredients);
    }
}
