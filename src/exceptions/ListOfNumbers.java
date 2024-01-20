package exceptions;

import java.io.*;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {

  private List<Integer> list;
  private static final int SIZE = 10;

  public ListOfNumbers() {
    list = new ArrayList<Integer>(SIZE);
    for (int i = 0; i < SIZE; i++) {
      list.add(Integer.valueOf(i));
    }
  }

  public void writeList() {
    // The FileWriter constructor throws IOException, which must be caught.
    PrintWriter out = null;
    FileWriter f = null;
    try {
      System.out.println("Entered try statement");
      f = new FileWriter("OutFile.txt");
      out = new PrintWriter(f);
      for (int i = 0; i < SIZE; i++) {
        System.out.println("value being printed is: " + i);
        out.println("Value at: " + i + " = " + list.get(i));
      }
    } catch (IndexOutOfBoundsException e) {
      System.err.println("IndexOutAOfBoundsException: " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    } finally {
      if (out != null) {
        System.out.println("Closing PrintWriter");
        out.close();
      } else {
        System.out.println("PrintWriter not open");
      }
      if (f != null) {
        System.out.println("Closing FileWriter");
        try {
          f.close();
        } catch (IOException err) {
          System.err.println("Message is: " + err.getMessage());
        }

      }
    }
  }
}
