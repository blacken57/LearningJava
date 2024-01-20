package src.CompletableFuturePOCs;

import java.util.concurrent.CompletableFuture;

class CFutureMethods {
  public static void main(String[] args) throws Exception {
    CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
      }
      return 2;
    }).thenApply(x -> 2 * x).thenAccept((x) -> System.out.println(x));
    Thread.sleep(2000);
    System.out.println(future);

  }
}
