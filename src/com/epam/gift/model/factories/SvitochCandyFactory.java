package com.epam.gift.model.factories;

import com.epam.gift.model.products.Candy;

/**
 * Svitoch candy factory class
 */
public class SvitochCandyFactory extends CandyFactory {

    /* Names of candies */
    private static final String CHOCOLATE_NAME = "Star light candy";
    private static final String JELLY_NAME = "White jelly candy";

    /* Contains of candies */
    private static final String CHOCOLATE_FILLING = "white chocolate, 20% cacao";
    private static final String JELLY_FILLING = "banana jelly with nuts";

    /* Candies weights */
    private static final double CHOCOLATE_WEIGHT = 5.4;
    private static final double JELLY_WEIGHT = 3.9;

    /* Candies sugar contains */
    private static final double CHOCOLATE_SUGAR = 8.5;
    private static final double JELLY_SUGAR = 4.1;

    /* Candies prices */
    private static final double CHOCOLATE_PRICE = 6.5;
    private static final double JELLY_PRICE = 4.8;

    @Override
    public Candy createChocolateCandy() {
        return new Candy(CHOCOLATE_NAME, CHOCOLATE_FILLING, Factories.SVITOCH, CHOCOLATE_WEIGHT,
                         CHOCOLATE_SUGAR, CHOCOLATE_PRICE);
    }

    @Override
    public Candy createJellyCandy() {
        return new Candy(JELLY_NAME, JELLY_FILLING, Factories.SVITOCH, JELLY_WEIGHT, JELLY_SUGAR,
                         JELLY_PRICE);
    }

    @Override
    public Candy createCaramelCandy() {
        return null;
    }
}
