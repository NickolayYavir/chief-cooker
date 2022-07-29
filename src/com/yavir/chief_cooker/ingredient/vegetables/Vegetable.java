package com.yavir.chief_cooker.ingredient.vegetables;

import com.yavir.chief_cooker.ingredient.Ingredient;

import java.util.Objects;

public class Vegetable extends Ingredient {

    public enum VegetableType {
        BULB, //fennel, garlic, leek, onion, shallot, spring onion
        FLOWER, //artichoke (globe), broccoflower, cauliflower, broccoli, choi sum, courgette or other squash flowers, gai  lan (Chinese sprouting broccoli)
        FRUIT, //bitter melon, capsicum, chilli, choko, courgette, cucumber, eggplant, fuzzy melon, Indian marrow, marrow, plantain, pumpkin and squash, scallopini, tindora, tomatillo, tomato, turia (ribbed gourd)
        FUNGI, //button white, Swiss brown, cup (opened not flat), enoki, oyster, Portabello (brown flat or cup), shiitake, truffle - black and white
        LEAVE, //bok choy, Brussels sprouts, cabbage, lettuce, ong choi, puha, radicchio, silverbeet, sorrel, spinach, tat soi, tung ho, watercress, witloof, wong nga baak (Peking cabbage)
        ROOT, //beetroot, carrot, celeriac, daikon, parsnip, radish, swede, turnip
        SEED, //bean (green, French, butter, snake), broad bean, pea, snow pea, sweet corn
        STERM, //asparagus, celery, kohlrabi
        TUBER //earth gem, Jerusalem artichoke, kūmara, potato, yam
    }

    private String vegetableType;

    public Vegetable(String name, double weighInGrams, double caloriesPerHundredGrams, double fatsPerHundredGrams, double proteinsPerHundredGrams, double carbohydratesPerHundredGrams, VegetableType vegetableType) {
        super(name, weighInGrams, caloriesPerHundredGrams, fatsPerHundredGrams, proteinsPerHundredGrams, carbohydratesPerHundredGrams);
        setVegetableType(vegetableType);
    }

    public String getVegetableType() {
        return vegetableType;
    }

    public void setVegetableType(VegetableType vegetableType) {
        for (VegetableType v : VegetableType.values()){
            if (v.equals(vegetableType)){
                this.vegetableType = vegetableType.toString();
                return;
            }
        }
        throw new IllegalArgumentException("Wrong Vegetable type");
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tVegetable info:\n\t\tVegetable Type " + getVegetableType() + "\n___________________________\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vegetable vegetable = (Vegetable) o;
        return vegetableType.equals(vegetable.vegetableType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vegetableType);
    }
}
