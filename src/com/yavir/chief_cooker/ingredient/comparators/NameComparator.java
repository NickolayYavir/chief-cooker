package com.yavir.chief_cooker.ingredient.comparators;

import com.yavir.chief_cooker.ingredient.Ingredient;

import java.util.Comparator;

public class NameComparator implements Comparator<Ingredient> {
    @Override
    public int compare(Ingredient o1, Ingredient o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getIngredientName(), o2.getIngredientName());
    }
}
