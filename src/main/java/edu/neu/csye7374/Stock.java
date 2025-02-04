package edu.neu.csye7374;

import edu.neu.csye7374.interfaces.Tradable;
import edu.neu.csye7374.strategy.StockPricingStrategy;
import java.util.ArrayList;
import java.util.List;

public class Stock implements Tradable {
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

    @Override
    public void setBid(double bid) {
        this.bids.add(bid);
        calculatePrice(bid);
    }

    private void calculatePrice(double bid) {
        if (pricingStrategy != null) {
            double newPrice = pricingStrategy.calculateNewPrice(this.price, bid, this.metric);
            this.price = newPrice;
        }
    }

    @Override
    public int getMetric() {
        return this.metric;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public String toString() {
        return "Stock{" + "ID='" + ID + '\'' + ", price=" + price + ", description='" + description + '\'' + '}';
    }
}
