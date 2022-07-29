package com.yavir.chief_cooker;

import com.yavir.chief_cooker.dish.Dish;
import com.yavir.chief_cooker.ingredient.vegetables.Vegetable;

public class Main {
    public static void main(String[] args) {

        Vegetable tomato = new Vegetable("Tomato", 100,15,0.2,0.9,3.9, Vegetable.VegetableType.FRUIT);
        Vegetable carrot = new Vegetable("Carrot", 100, 34, 0.2, 0.9, 9.6, Vegetable.VegetableType.ROOT);
        Vegetable cucumber = new Vegetable("Cucumber", 100, 15,0.1,0.7,3.6, Vegetable.VegetableType.FRUIT);

        Dish salad = new Dish("Salad",tomato,carrot,cucumber);
        System.out.println(salad);
        salad.printIngredients();
        salad.printIngredientsDetail();
    }
}
