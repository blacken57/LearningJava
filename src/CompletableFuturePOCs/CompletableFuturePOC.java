package src.CompletableFuturePOCs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

class CompletableFuturePOC {
  public static class Product {
    String name;
    Integer id;

    public Product(Integer id, String name) {
      this.id = id;
      this.name = name;
    }
  }

  private Map<Integer, Product> cache = new HashMap<>();
  private Logger logger = Logger.getLogger(this.getClass().getName());

  private Product getLocal(int id) {
    return cache.get(id);
  }

  private Product getRemote(int id) {
    try {
      Thread.sleep(4000);
      if (id == 666) {
        throw new RuntimeException("Evil request");
      }
    } catch (InterruptedException ignored) {

    }
    return new Product(id, "name");
  }

  public CompletableFuture<Product> getProduct(int id) {
    Long startingTime = System.currentTimeMillis();
    try {
      Product product = getLocal(id);
      if (product != null) {
        System.out.println("Getting from local Instance this time: " + String.valueOf(id));
        return CompletableFuture.completedFuture(product);
      } else {
        System.out.println("Getting from remote Instance this time: " + String.valueOf(id));
        return CompletableFuture.supplyAsync(() -> {
          Product p = getRemote(id);
          cache.put(id, p);
          return p;
        });
        // CompletableFuture<Product> future = new CompletableFuture<>();
        // Product p = getRemote(id);
        // cache.put(id, p);
        // future.complete(p);
        // return future;
      }
    } catch (Exception e) {
      CompletableFuture<Product> future = new CompletableFuture<>();
      future.completeExceptionally(e);
      return future;
    } finally {
      Long endingTime = System.currentTimeMillis();
      System.out.println(
          "the entire process of getting " + String.valueOf(id) + " took: "
              + String.valueOf(endingTime - startingTime));
    }
  }
}
