package com.epam.gift.model.factories;

import com.epam.gift.model.products.Candy;

/**
 * AVK candy factory class
 */
public class AVKCandyFactory extends CandyFactory {

    /* Names of candies */
    private static final String CHOCOLATE_NAME = "Red poppy candy";
    private static final String CARAMEL_NAME = "Caramella candy";
    private static final String JELLY_NAME = "Souffle candy";

    /* Contains of candies */
    private static final String CHOCOLATE_FILLING = "milk chocolate, 50% cacao";
    private static final String CARAMEL_FILLING = "caramel cream";
    private static final String JELLY_FILLING = "pistachio and kiwi jelly";

    /* Candies weights */
    private static final double CHOCOLATE_WEIGHT = 2.3;
    private static final double CARAMEL_WEIGHT = 1.4;
    private static final double JELLY_WEIGHT = 0.9;

    /* Candies sugar contains */
    private static final double CHOCOLATE_SUGAR = 6.3;
    private static final double CARAMEL_SUGAR = 5.2;
    private static final double JELLY_SUGAR = 2.8;

    /* Candies prices */
    private static final double CHOCOLATE_PRICE = 5.6;
    private static final double CARAMEL_PRICE = 4.7;
    private static final double JELLY_PRICE = 3.2;

    @Override
    public Candy createChocolateCandy() {
        return new Candy(CHOCOLATE_NAME, CHOCOLATE_FILLING, Factories.AVK, CHOCOLATE_WEIGHT,
                         CHOCOLATE_SUGAR, CHOCOLATE_PRICE);
    }

    @Override
    public Candy createCaramelCandy() {
        return new Candy(CARAMEL_NAME, CARAMEL_FILLING, Factories.AVK, CARAMEL_WEIGHT,
                         CARAMEL_SUGAR, CARAMEL_PRICE);
    }

    @Override
    public Candy createJellyCandy() {
        return new Candy(JELLY_NAME, JELLY_FILLING, Factories.AVK, JELLY_WEIGHT, JELLY_SUGAR,
                         JELLY_PRICE);
    }
}
