package com.yavir.chief_cooker.ingredient.comparators;

import com.yavir.chief_cooker.ingredient.Ingredient;

import java.util.Comparator;

public class CarbohydratesComparator implements Comparator<Ingredient> {
    @Override
    public int compare(Ingredient o1, Ingredient o2) {
        return Double.compare(o1.calculateCarbohydrates(), o2.calculateCarbohydrates());
    }
}
