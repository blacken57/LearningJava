package src.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamPOC {
  public static class Order {
    private String id;

    public Order(String id) {
      this.id = id;
    }

    public String getId() {
      return this.id;
    }
  }

  public static class Customer {
    private String name;
    private List<Order> orders = new ArrayList<Order>();

    public Customer(String name) {
      this.name = name;
    }

    public String getName() {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {

      }
      return this.name;
    }

    public Customer addOrder(Order order) {
      this.orders.add(order);
      return this;
    }

    public List<Order> getOrders() {
      return this.orders;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    // String names = Stream.of("one", "two", "three",
    // "abcd").sorted().collect(Collectors.joining(": "));
    // System.out.println(names);
    Customer avroy = new Customer("Abhishek Roy");
    Customer ankita = new Customer("Ankita Saha");
    Customer noOne = new Customer("noOne");

    avroy.addOrder(new Order("MacBook"))
        .addOrder(new Order("BoatHeadphones"))
        .addOrder(new Order("StarWarsCD"))
        .addOrder(new Order("3DPrinter"));
    ankita.addOrder(new Order("LipBalm"))
        .addOrder(new Order("Apartment"))
        .addOrder(new Order("XMasTree"));
    noOne.addOrder(new Order("Everything"));

    // Get information about Runtime
    Runtime runtime = Runtime.getRuntime();
    System.out.println("Number Of Cores Available: " + Integer.toString(runtime.availableProcessors()));

    Long startTime = System.currentTimeMillis();
    // List<Customer> customers = Arrays.asList(avroy, ankita, noOne, ankita, avroy,
    // noOne);
    ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList());
    Integer NUM_OF_CUSTOMERS = 100;
    System.out.println("Creating a List of Customers with " + Integer.toString(NUM_OF_CUSTOMERS) + " members");
    for (int i = 0; i < NUM_OF_CUSTOMERS; i++) {
      Customer newCustomer = new Customer(UUID.randomUUID().toString());
      newCustomer.addOrder(new Order(UUID.randomUUID().toString()));
      customers.add(newCustomer);
    }
    List<String> customerNames = customers.parallelStream().map((x) -> x.getName()).collect(Collectors.toList());
    System.out.println(customerNames);
    Long endTime = System.currentTimeMillis();
    System.out.println("Time taken is: " + Long.toString(endTime - startTime));
  }
}
