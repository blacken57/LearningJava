package src.CompletableFuturePOCs;

import java.util.concurrent.CompletableFuture;

class SimpleCompletableFutureutils {
  static void completedFutureExample() {
    CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
  }
}
