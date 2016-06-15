package com.epam.gift.model;

import com.epam.gift.model.products.*;
import com.epam.gift.model.factories.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Gift class
 */
public class Gift {

    /** Gift's name */
    private String name;

    /** Map of candies and amount of each of them contained in gift */
    private Map<Candy, Integer> candies = new LinkedHashMap<>();

    /** Total number of candies in gift */
    private int candiesQuantity = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Candy, Integer> getCandies() {
        return candies;
    }

    /**
     * Adds certain amount of candies of given type and factory to gift
     *
     * @param candyType Type of candy to add
     * @param candyFactory Factory that will create candy
     * @param amount Amount of candies to add
     */
    public void addCandy(Candies candyType, Factories candyFactory, int amount) {
        Candy candy = containsCandy(candyType, candyFactory);

        if (candy != null) {
            candies.compute(candy, (k, v) -> v + amount);
        } else { //candy == null
            candy = getFactory(candyFactory).createCandy(candyType);
            candies.put(candy, amount);
        }

        candiesQuantity += amount;
    }

    /**
     * Counts weight of gift
     *
     * @return Gift's weight
     */
    public double getGiftWeight() {
        double weight = 0;
        Set<Map.Entry<Candy, Integer>> candiesSet = candies.entrySet();

        for (Map.Entry<Candy, Integer> entry : candiesSet) {
            weight += entry.getValue() * entry.getKey().getWeight();
        }

        return weight;
    }

    /**
     * Counts price of gift
     *
     * @return Gift's price
     */
    public double getGiftPrice() {
        double price = 0;
        Set<Map.Entry<Candy, Integer>> candiesSet = candies.entrySet();

        for (Map.Entry<Candy, Integer> entry : candiesSet) {
            price += entry.getValue() * entry.getKey().getPrice();
        }

        return price;
    }

    /**
     * Counts total number of candies contained in gift
     *
     * @return Number of candies in gift
     */
    public int getCandiesNumber() {
        return candiesQuantity;
    }

    /**
     * Counts number of candies of given type
     *
     * @param candyType Type of candies to search
     * @return Number of found candies of given type
     */
    public int getCandiesNumber(Candies candyType) {
        int num = 0;
        Set<Map.Entry<Candy, Integer>> candiesSet = candies.entrySet();

        for (Map.Entry<Candy, Integer> entry : candiesSet) {
            if (entry.getKey().getIngredients().toUpperCase().contains(candyType.toString())) {
                num += entry.getValue();
            }
        }

        return num;
    }

    /**
     * Counts number of candies made by given factory
     *
     * @param candyFactory Candy factory to search
     * @return Number of found candies made by given factory
     */
    public int getCandiesNumber(Factories candyFactory) {
        int num = 0;
        Set<Map.Entry<Candy, Integer>> candiesSet = candies.entrySet();

        for (Map.Entry<Candy, Integer> entry : candiesSet) {
            if (entry.getKey().getFactory() == candyFactory) {
                num += entry.getValue();
            }
        }

        return num;
    }

    /**
     * Finds candies with sugar contents in given range
     *
     * @param min Lower sugar range boundary
     * @param max Upper sugar range boundary
     * @return List with found candies
     */
    public List<Candy> getCandiesBySugar(double min, double max) {
        return candies.keySet().stream().filter(candy -> candy.getSugar() <= max 
                                                && candy.getSugar() >= min).collect
                                                                         (Collectors.toList());
    }

    /**
     * Sorts candies by price
     *
     * @return List with candies sorted by price
     */
    public List<Candy> sortCandiesByPrice() {
        return candies.keySet().stream().sorted((candy1, candy2) -> {
            if (candy1.getPrice() == candy2.getPrice())
                return 0;

            return candy1.getPrice() > candy2.getPrice() ? 1 : -1;
        }).collect(Collectors.toList());
    }

    /**
     * Sorts candies by weight
     *
     * @return List with candies sorted by weight
     */
    public List<Candy> sortCandiesByWeight() {
        return candies.keySet().stream().sorted((candy1, candy2) -> {
            if (candy1.getWeight() == candy2.getWeight())
                return 0;

            return candy1.getWeight() > candy2.getWeight() ? 1 : -1;
        }).collect(Collectors.toList());
    }

    /**
     * Sorts candies by sugar
     *
     * @return List with candies sorted by sugar
     */
    public List<Candy> sortCandiesBySugar() {
        return candies.keySet().stream().sorted((candy1, candy2) -> {
            if (candy1.getSugar() == candy2.getSugar())
                return 0;

            return candy1.getSugar() > candy2.getSugar() ? 1 : -1;
        }).collect(Collectors.toList());
    }

    /**
     * Sorts candies by name
     *
     * @return List with candies sorted by name
     */
    public List<Candy> sortCandiesByName() {
        return candies.keySet().stream().sorted((candy1, candy2) ->
                                         candy1.getName().compareTo(candy2.getName()))
                                        .collect(Collectors.toList());
    }

    /**
     * Returns information about gift - it's name and
     * description of all candies in it and their amounts.
     *
     * @return String with gift description.
     */
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Candy, Integer>> candiesSet = candies.entrySet();

        for (Map.Entry<Candy, Integer> entry : candiesSet) {
            sb.append("\n").append(entry.getKey().getDescription()).
               append("Amount: ").append(entry.getValue()).append("\n");
        }

        return name + "\n" + sb;
    }

    /**
     * Gets factory depending on given factory type
     *
     * @param candyFactory Type of factory to get
     * @return Candy factory of given factory type
     */
    private CandyFactory getFactory(Factories candyFactory) {
        switch (candyFactory) {
            case AVK:
                return new AVKCandyFactory();

            case ROCHEN:
                return new RochenCandyFactory();

            case SVITOCH:
                return new SvitochCandyFactory();

            default:
                return null;
        }
    }

    /**
     * Checks if gift contains candy of given type,
     * made by given factory
     *
     * @param candyType Type of candy to search
     * @param candyFactory Candy factory to search
     * @return Candy from gift with given parameters, if it exists in gift,
     * null otherwise
     */
    private Candy containsCandy(Candies candyType, Factories candyFactory) {
        Set<Map.Entry<Candy, Integer>> candiesSet = candies.entrySet();

        for (Map.Entry<Candy, Integer> entry : candiesSet) {
            if (entry.getKey().getIngredients().toUpperCase().contains(candyType.toString()) 
                    && entry.getKey().getFactory() == candyFactory) {
                return entry.getKey();
            }
        }

        return null;
    }
}