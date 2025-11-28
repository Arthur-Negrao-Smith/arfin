package com.arfin.cli;

import java.util.Scanner;

public class CliRunner {
  public static void run() {
    System.out.println("#################################");
    System.out.println("#   Arfin Interative Terminal   #");
    System.out.println("#################################");

    Scanner scanner = new Scanner(System.in);
    String input = "";

    while (!input.equalsIgnoreCase("exit")) {
      System.out.print(">>> ");

      input = scanner.nextLine().trim();
      if (!split(input)[0].equalsIgnoreCase("exit")) {
        parse_input(input);
      } else {
        input = "exit";
      }
    }

    scanner.close();

    System.out.println("Exiting from Arfin cli...");
  }

  private static void parse_input(String input) {
    Cli.parse(split(input));
  }

  private static String[] split(String input) {
    return input.split("\\s+");
  }
}
