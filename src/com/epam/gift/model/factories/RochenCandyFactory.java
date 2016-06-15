package com.epam.gift.model.factories;

import com.epam.gift.model.products.Candy;

/**
 * Rochen candy factory class
 */
public class RochenCandyFactory extends CandyFactory {

    /* Names of candies */
    private static final String CHOCOLATE_NAME = "Truffle candy";
    private static final String CARAMEL_NAME = "Custard cream candy";

    /* Contains of candies */
    private static final String CHOCOLATE_FILLING = "dark chocolate, 80% cacao";
    private static final String CARAMEL_FILLING = "custard cream caramel";

    /* Candies weights */
    private static final double CHOCOLATE_WEIGHT = 6.2;
    private static final double CARAMEL_WEIGHT = 4.8;

    /* Candies sugar contains */
    private static final double CHOCOLATE_SUGAR = 3.1;
    private static final double CARAMEL_SUGAR = 8.7;

    /* Candies prices */
    private static final double CHOCOLATE_PRICE = 9.1;
    private static final double CARAMEL_PRICE = 7.6;

    @Override
    public Candy createChocolateCandy() {
        return new Candy(CHOCOLATE_NAME, CHOCOLATE_FILLING, Factories.ROCHEN, CHOCOLATE_WEIGHT,
                         CHOCOLATE_SUGAR, CHOCOLATE_PRICE);
    }

    @Override
    public Candy createCaramelCandy() {
        return new Candy(CARAMEL_NAME, CARAMEL_FILLING, Factories.ROCHEN, CARAMEL_WEIGHT,
                         CARAMEL_SUGAR, CARAMEL_PRICE);
    }

    @Override
    public Candy createJellyCandy() {
        return null;
    }
}
