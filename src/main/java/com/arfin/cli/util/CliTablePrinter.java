package com.arfin.cli.util;

import com.arfin.model.User;

public final class CliTablePrinter {
  private static int LINE_SIZE = 80;

  public static void printUserTableHeader() {
    System.out.println("-".repeat(LINE_SIZE));
    System.out.print("| ");
    centeredPrint("ID", 32);
    System.out.print(" | ");
    centeredPrint("Name", LINE_SIZE - 39);
    System.out.println(" |");
    System.out.println("-".repeat(LINE_SIZE));
  }

  public static void printUserTableLine(User user) {
    System.out.print("| ");
    centeredPrint(user.getId().toString(), 32);
    System.out.print(" | ");
    centeredPrint(user.getName(), LINE_SIZE - 39);
    System.out.println(" |");
    System.out.println("-".repeat(LINE_SIZE));
  }

  public static void centeredPrint(String text, int size) {
    if (text.length() >= size) {
      System.out.print(text);
      return;
    }

    int left_padding = (size - text.length()) / 2;
    int right_padding = size - left_padding - text.length();

    System.out.print(" ".repeat(left_padding) + text + " ".repeat(right_padding));
  }

  public static void centeredPrint(String text, int size, String symbol) {
    if (text.length() >= size) {
      System.out.print(text);
      return;
    }

    int left_padding = (size - text.length()) / 2;
    int right_padding = size - left_padding - text.length();

    System.out.print(symbol.repeat(left_padding) + text + symbol.repeat(right_padding));
  }
}
