package edu.neu.csye7374.strategy;

// Strategy interface for stock pricing
public interface StockPricingStrategy {  // Ensure this is public
    double calculateNewPrice(double currentPrice, double bid, int metric);
}

