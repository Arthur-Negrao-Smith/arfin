package com.arfin.cli.util;

import com.arfin.model.User;

/**
 * Class to keep all cli methods to show the arfin's tables.
 * <p>
 * This class contains methods to show contents of the arfin's tables with cli
 * </p>
 *
 * @author Arthur Negrão
 * @since 1.0.0
 */
public final class CliTablePrinter {

  /**
   * The total length of the cli line.
   *
   * @value 80
   */
  private static final int LINE_SIZE = 80;

  /**
   * Print the Header of Users table.
   */
  public static void printUserTableHeader() {
    System.out.println("-".repeat(LINE_SIZE));
    System.out.print("| ");
    centeredPrint("ID", 32);
    System.out.print(" | ");
    centeredPrint("Name", LINE_SIZE - 39);
    System.out.println(" |");
    System.out.println("-".repeat(LINE_SIZE));
  }

  /**
   * Print a user line from Users table.
   */
  public static void printUserTableLine(User user) {
    System.out.print("| ");
    centeredPrint(user.getId().toString(), 32);
    System.out.print(" | ");
    centeredPrint(user.getName(), LINE_SIZE - 39);
    System.out.println(" |");
  }

  /**
   * Print a centered content.
   *
   * @param text String to print.
   * @param size Int to define a size to centralize.
   */
  public static void centeredPrint(String text, int size) {
    if (text.length() >= size) {
      System.out.print(text);
      return;
    }

    int left_padding = (size - text.length()) / 2;
    int right_padding = size - left_padding - text.length();

    System.out.print(" ".repeat(left_padding) + text + " ".repeat(right_padding));
  }

  /**
   * Method to print a centered content.
   *
   * @param text   String to print.
   * @param size   Int to define a size to centralize.
   * @param symbol String to use around the {@code text}.
   */
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
