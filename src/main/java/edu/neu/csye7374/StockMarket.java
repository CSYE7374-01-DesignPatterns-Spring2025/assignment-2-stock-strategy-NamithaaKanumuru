package edu.neu.csye7374;

import edu.neu.csye7374.strategy.BullMarketStrategy;
import edu.neu.csye7374.strategy.BearMarketStrategy;

public class StockMarket {
    private static StockMarket instance;

    // Private constructor to enforce Singleton pattern
    private StockMarket() {}

    // Singleton instance retrieval method
    public static StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void demo() {
        // Create stocks with different strategies
        Stock infyStock = new Stock("INFY", 100, "Infosys Stock", new BullMarketStrategy());
        Stock relianceStock = new Stock("RELI", 150, "Reliance Stock", new BearMarketStrategy());

        System.out.println("Initial Stock Prices:");
        System.out.println(infyStock);
        System.out.println(relianceStock);

        // Simulating trades with bids
        infyStock.setBid(120);
        relianceStock.setBid(130);

        System.out.println("After first trade:");
        System.out.println(infyStock);
        System.out.println(relianceStock);

        infyStock.setBid(140);
        relianceStock.setBid(110);

        System.out.println("After second trade:");
        System.out.println(infyStock);
        System.out.println(relianceStock);
    }
}
