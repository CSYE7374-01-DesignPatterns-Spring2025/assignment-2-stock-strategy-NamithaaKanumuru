package edu.neu.csye7374;


import edu.neu.csye7374.strategy.StockPricingStrategy;
import java.util.ArrayList;
import java.util.List;


public class Stock {
    private String ID;
    private String description;
    protected double price;
    private int metric;
    private List<Double> bids;
    private StockPricingStrategy pricingStrategy;

    public Stock(String ID, double price, String description, StockPricingStrategy pricingStrategy) {
        this.ID = ID;
        this.price = price;
        this.description = description;
        this.bids = new ArrayList<>();
        this.bids.add(price);
        this.metric = 0;
        this.pricingStrategy = pricingStrategy;
    }

    public void setPricingStrategy(StockPricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void setBid(double bid) {
        this.bids.add(bid);
        calculatePrice(bid);
    }

    public void calculatePrice(double bid) {
        if (pricingStrategy != null) {
            double newPrice = pricingStrategy.calculateNewPrice(this.price, bid, this.metric);
            this.price = newPrice;
        }
    }

    @Override
    public String toString() {
        return "Stock{" + "ID='" + ID + '\'' + ", price=" + price + ", description='" + description + '\'' + '}';
    }
}
