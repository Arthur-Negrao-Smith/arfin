package com.arfin.util;

public final class ColorPrint {
  public static void print(String text) {
    System.out.println(Color.YELLOW.toString() + text + Color.RESET.toString());
  }

  public static void print(String text, Color color) {
    System.out.println(color.toString() + text + Color.RESET.toString());
  }

  public static void print(String text, String end) {
    System.out.print(Color.YELLOW.toString() + text + Color.RESET.toString() + end);
  }

  public static void print(String text, Color color, String end) {
    System.out.print(color.toString() + text + Color.RESET.toString() + end);
  }
}
