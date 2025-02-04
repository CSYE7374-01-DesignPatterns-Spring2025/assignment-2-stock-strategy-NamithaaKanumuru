package edu.neu.csye7374.strategy;

public class BearMarketStrategy implements StockPricingStrategy {
    @Override
    public double calculateNewPrice(double currentPrice, double bid, int metric) {
        return currentPrice + (bid - currentPrice) * 0.3; // 30% adjustment towards bid price
    }
}
