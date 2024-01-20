package src.CompletableFuturePOCs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FuturePOC {
  public static void getIfNotCancelled(Future<String> future) {
    try {
      if (!future.isCancelled()) {
        System.out.println(future.get());
      } else {
        System.out.println("Cancelled");
      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ExecutorService service = Executors.newCachedThreadPool();
    Future<String> future = service.submit(() -> {
      Thread.sleep(100);
      return "Hello World!";
    });
    future.cancel(true);
    System.out.println("More Processing...");
    while (!future.isDone()) {
      System.out.println("Waiting!");
    }
    System.out.println("Processing ...");
    getIfNotCancelled(future);
    return;
  }
}
