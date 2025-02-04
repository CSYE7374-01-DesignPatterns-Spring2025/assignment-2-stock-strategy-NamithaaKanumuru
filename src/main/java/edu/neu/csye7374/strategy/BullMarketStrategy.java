package edu.neu.csye7374.strategy;

public class BullMarketStrategy implements StockPricingStrategy {
    @Override
    public double calculateNewPrice(double currentPrice, double bid, int metric) {
        return currentPrice + (bid - currentPrice) * 0.7; // 70% adjustment towards bid price
    }
}