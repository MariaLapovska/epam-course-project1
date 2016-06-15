package com.epam.gift.view;

/**
 * Class for output and UI
 */
public class View {

    public static final String SEPARATOR = "--------------------------";
    public static final String SORT_BY_WEIGHT = "Gift sorted by weight: ";
    public static final String SORT_BY_PRICE = "Gift sorted by price: ";
    public static final String SORT_BY_SUGAR = "Gift sorted by sugar: ";
    public static final String SWEETS_IN_RANGE = "Candies that contain sugar from %.2f to %.2f:%n";
    public static final String GIFT_WEIGHT = "Gift weight: %.2f%n";
    public static final String GIFT_PRICE = "Gift price: %.2f%n";
    public static final String TOTAL_NUMBER = "Total number of candies: ";
    public static final String CHOCOLATE_NUMBER = "Number of chocolate candies in the gift: ";
    public static final String AVK_NUMBER = "Number of AVK candies in the gift: ";

    public void printMessage(String... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public void printMessageAndNumber(String message, double number) {
        System.out.format(message, number);
    }

    public void printMessageAndRange(String message, double min, double max) {
        System.out.format(message, min, max);
    }
}
