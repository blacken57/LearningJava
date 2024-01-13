package src.basics;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LambdaExpressionPOC {
  public static boolean functionalInterfaceTestMethod(FunctionalClassTest obj) {
    System.out.println(obj.result("Called it"));
    return false;
  }

  public static void main(String[] args) {

    // This is a directory. For some reason the root directory is src. Might want to
    // look into it
    File directory = new File("./src/basics");

    // This lists all the files or directories inside the directory.
    String[] names = directory.list();
    // I am converting the String[] to an ArrayList here
    ArrayList<String> nameArray = new ArrayList<String>(Arrays.asList(names));
    List<String> nameList = Arrays.asList(names);
    // System.out.println(nameList);

    nameArray.add("newItemHere");
    // System.out.println(nameList.size());
    // System.out.println(nameArray);

    // Anyway, proper Lambda Application starts here
    // String namesActual[] = directory.list(new FilenameFilter() {
    // @Override
    // public boolean accept(File dir, String name) {
    // return name.endsWith("java");
    // }
    // });

    String namesActual[] = directory.list((dir, name) -> name.endsWith(".java"));
    System.out.println(Arrays.asList(namesActual));

    functionalInterfaceTestMethod(new FunctionalClassTest() {
      public boolean result(String input) {
        System.out.println("Called it in runtime from the main method");
        return false;
      }
    });

    functionalInterfaceTestMethod((input) -> {
      System.out.println("Called it from a lambda");
      return false;
    });
  }
}
