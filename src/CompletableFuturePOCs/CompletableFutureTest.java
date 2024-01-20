package src.CompletableFuturePOCs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.CompletableFuturePOCs.CompletableFuturePOC.Product;

class CompletableFutureTest {
  public static void main(String[] args) throws Exception {
    CompletableFuturePOC poc = new CompletableFuturePOC();
    ArrayList<Integer> products = new ArrayList<>(Arrays.asList());
    Integer NUM_PRODUCTS = 30;
    for (int i = 0; i < NUM_PRODUCTS; i++) {
      products.add(i);
    }
    System.out.println("Starting to Retrieve the prodcucts");
    for (int i = 0; i < NUM_PRODUCTS; i++) {
      System.out.println(poc.getProduct(i));
    }
    // System.out.println(poc.getProduct(3));
    // System.out.println(poc.getProduct(3));
    // System.out.println(poc.getProduct(4));
    // System.out.println(poc.getProduct(666));
    Integer NUM_TIME_MILLIS = 8050;
    Thread.sleep(NUM_TIME_MILLIS);
    System.out.println("Waited for " + String.valueOf(NUM_TIME_MILLIS));
    for (int i = 0; i < NUM_PRODUCTS; i++) {
      System.out.println(poc.getProduct(i));
    }
  }
}
