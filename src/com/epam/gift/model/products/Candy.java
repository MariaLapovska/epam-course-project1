package com.epam.gift.model.products;

import com.epam.gift.model.factories.Factories;

/**
 * Candy class
 */
public class Candy {

    private String name;
    private String ingredients;
    private Factories factory;
    private double weight;
    private double sugar;
    private double price;

    /** Constructor with parameters */
    public Candy(String name, String ingredients, Factories factory, double weight, double sugar,
                 double price) {
        this.name = name;
        this.ingredients = ingredients;
        this.factory = factory;
        this.weight = weight;
        this.sugar = sugar;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Factories getFactory() {
        return factory;
    }

    public void setFactory(Factories factory) {
        this.factory = factory;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns information about candy.
     *
     * @return String with candy description.
     */
    public String getDescription() {
        return String.format("Name: %s, Ingredients: %s, Factory: %s%nWeight: %.2f, " +
                             "Sugar: %.2f, Price: %.2f%n",
                             name, ingredients, factory, weight, sugar, price);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (this.getClass() != that.getClass()) {
            return false;
        }

        Candy candy = (Candy) that;

        if (!this.name.equals(candy.name)) {
            return false;
        }
        if (!this.ingredients.equals(candy.ingredients)) {
            return false;
        }
        if (!this.factory.equals(candy.factory)) {
            return false;
        }
        if (this.weight != candy.weight) {
            return false;
        }
        if (this.sugar != candy.sugar) {
            return false;
        }

        return this.price == candy.price;
    }

    @Override
    public int hashCode() {
        final double prime = 31.;
        double result = 1.;

        result = prime * result + name.hashCode();
        result = prime * result + ingredients.hashCode();
        result = prime * result + factory.hashCode();
        result = prime * result + weight;
        result = prime * result + sugar;
        result = prime * result + price;

        return (int) result;
    }
}