package com.epam.gift.controller;

import com.epam.gift.GlobalConstants;
import com.epam.gift.model.Gift;
import com.epam.gift.model.factories.Factories;
import com.epam.gift.model.products.Candies;
import com.epam.gift.view.View;

/**
 * Controller class.
 */
public class Controller {

    private Gift gift;
    private View view;

    /**
     * Constructor with parameters.
     * @param gift Gift
     * @param view View
     */
    public Controller(Gift gift, View view) {
        this.gift = gift;
        this.view = view;
    }

    //Work method
    public void processUser() {
        gift.setName(GlobalConstants.GIFT_NAME);
        fillGift(gift);

        view.printMessageAndNumber(View.GIFT_PRICE, gift.getGiftPrice());
        view.printMessageAndNumber(View.GIFT_WEIGHT, gift.getGiftWeight());
        view.printMessage(View.SEPARATOR);
        view.printMessage(gift.getDescription());
        view.printMessage(View.SEPARATOR);
        view.printMessage(View.SORT_BY_WEIGHT);
        gift.sortCandiesByWeight().forEach(candy -> view.printMessage(candy.getDescription()));
        view.printMessage(View.SEPARATOR);
        view.printMessage(View.SORT_BY_PRICE);
        gift.sortCandiesByPrice().forEach(candy -> view.printMessage(candy.getDescription()));
        view.printMessage(View.SEPARATOR);
        view.printMessage(View.SORT_BY_SUGAR);
        gift.sortCandiesBySugar().forEach(candy -> view.printMessage(candy.getDescription()));
        view.printMessage(View.SEPARATOR);
        view.printMessageAndRange(View.SWEETS_IN_RANGE, GlobalConstants.SUGAR_LOWER_BOUNDARY,
                                    GlobalConstants.SUGAR_UPPER_BOUNDARY);

        gift.getCandiesBySugar(GlobalConstants.SUGAR_LOWER_BOUNDARY,
                               GlobalConstants.SUGAR_UPPER_BOUNDARY).forEach(candy ->
                                    view.printMessage(candy.getDescription()));

        view.printMessage(View.TOTAL_NUMBER + gift.getCandiesNumber());
        view.printMessage(View.CHOCOLATE_NUMBER + gift.getCandiesNumber(Candies.CHOCOLATE));
        view.printMessage(View.AVK_NUMBER + gift.getCandiesNumber(Factories.AVK));
    }

    //Auxiliary methods

    /**
     * Fills given gift with candies
     *
     * @param gift Gift to fill with candies
     */
    private void fillGift(Gift gift) {
        gift.addCandy(Candies.CARAMEL, Factories.AVK, 3);
        gift.addCandy(Candies.CHOCOLATE, Factories.AVK, 2);
        gift.addCandy(Candies.JELLY, Factories.AVK, 4);
        gift.addCandy(Candies.CARAMEL, Factories.ROCHEN, 1);
        gift.addCandy(Candies.CHOCOLATE, Factories.ROCHEN, 5);
        gift.addCandy(Candies.CHOCOLATE, Factories.SVITOCH, 1);
        gift.addCandy(Candies.JELLY, Factories.SVITOCH, 6);
        gift.addCandy(Candies.CARAMEL, Factories.AVK, 2);
    }
}
