package src.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class JavaFunctionUtilPOC {
  public static String getNamesOfLength(Integer length, List<String> names) {
    // return Arrays.stream(names).filter((x) -> x.length() ==
    // length).collect(Collectors.joining(", "));
    return names.stream().filter((x) -> x.length() == length).collect(Collectors.joining(", "));
  }

  public static void main(String[] args) {
    // Here I attempt to decipher how the Functions package in utils is used.
    // First let's try to figure out what forEach does
    String[] strings = { "one", "two", "three" };
    ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(strings));

    System.out.println("Printing using consumer");
    stringList.forEach(
        new Consumer<String>() {
          @Override
          public void accept(String input) {
            System.out.println(input);
          }
        });

    System.out.println("Printing as lambda");
    stringList.forEach((x) -> System.out.println(x));

    // Testing out collectors now
    List<String> names = Arrays.asList("Arun", "Barun", "Tarun", "Ankita", "Abhishek", "Tom", "Pom", "Candy");
    System.out.println(getNamesOfLength(5, names));
  }
}
