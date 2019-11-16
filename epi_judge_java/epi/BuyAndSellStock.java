package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;
public class BuyAndSellStock {
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
    int buy_index = 0;
    int sell_index = 1;
    double maxProfit = 0.0;
    while (buy_index < sell_index && sell_index < prices.size()) {

      if (prices.get(sell_index) > prices.get(buy_index))
        maxProfit = Math.max(maxProfit,prices.get(sell_index)-prices.get(buy_index));
      else
        buy_index = sell_index;

      sell_index++;
    }
    return maxProfit;

//    double maxProfit = Double.MIN_VALUE;
//    double minPrice = Double.MAX_VALUE;
//    for (Double price: prices) {
//      minPrice = Math.min(minPrice, price);
//      maxProfit = Math.max(maxProfit, price-minPrice);
//    }
//    return maxProfit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
