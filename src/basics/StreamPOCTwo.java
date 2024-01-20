package src.basics;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.sound.sampled.AudioFileFormat.Type;

class StreamPOCTwo {
  public static void main(String[] args) {
    // Trying to convert a simple array of strings to a List of String
    List<String> strings = Stream.of("this", "is", "a", "list").collect(Collectors.toList());
    System.out.println(strings);

    // Trying to convert a primitive type
    List<Integer> integers = IntStream.of(1, 2, 3, 4, 5).mapToObj(Integer::valueOf).collect(Collectors.toList());
    System.out.println(integers);

    // Define a String from which the streams will be created
    ArrayList<Integer> intArray = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    intArray.stream().filter(x -> x % 3 == 0).map(x -> x * x)// .map(String::valueOf)
        .forEach(x -> System.out.println(x.getClass()));
  }
}
