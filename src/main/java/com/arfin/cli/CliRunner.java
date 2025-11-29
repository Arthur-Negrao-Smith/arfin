package com.arfin.cli;

import java.util.Scanner;

import com.arfin.cli.util.CliState;

public class CliRunner {

  public static void run() {
    System.out.println("#################################");
    System.out.println("#   Arfin Interative Terminal   #");
    System.out.println("#################################");

    Scanner scanner = new Scanner(System.in);
    String input = "";
    String[] splited_input;

    while (!input.equalsIgnoreCase(CliState.EXIT_CLI)) {
      System.out.print("arfin >>> ");

      input = scanner.nextLine().trim();
      splited_input = split(input);

      if (splited_input[0].equalsIgnoreCase(CliState.EXIT_CLI) &&
          (input.length() == CliState.EXIT_CLI.length())) {
        input = "exit";

      } else if (splited_input[0].equalsIgnoreCase(CliState.EXIT_CLI) &&
          (input.length() != CliState.EXIT_CLI.length())) {
        System.out.printf(
            "Bad usage: The '%s' command does not accept arguments: %s\n",
            CliState.EXIT_CLI,
            input.substring(CliState.EXIT_CLI.length()).trim());

      } else {
        parse_input(input);

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
