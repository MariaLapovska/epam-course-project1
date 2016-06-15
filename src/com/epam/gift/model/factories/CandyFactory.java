package com.epam.gift.model.factories;

import com.epam.gift.model.products.Candies;
import com.epam.gift.model.products.Candy;

/**
 * Candy factory class
 */
public abstract class CandyFactory {

    /**
     * Creates instance of candy of given type
     *
     * @param candyType Type of candy to create
     * @return Candy of given type
     */
    public Candy createCandy(Candies candyType) {
        switch (candyType) {
            case CARAMEL:
                return createCaramelCandy();

            case CHOCOLATE:
                return createChocolateCandy();

            case JELLY:
                return createJellyCandy();

            default:
                return null;
        }
    }

    /** Creates instance of chocolate candy */
    public abstract Candy createChocolateCandy();

    /** Creates instance of caramel candy */
    public abstract  Candy createCaramelCandy();

    /** Creates instance of jelly candy */
    public abstract  Candy createJellyCandy();
}
