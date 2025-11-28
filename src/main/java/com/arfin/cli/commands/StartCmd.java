package com.arfin.cli.commands;

import java.util.Arrays;

import com.arfin.cli.commands.Command;
import com.arfin.cli.exceptions.CLIBadUsage;
import com.arfin.cli.enums.ProgramMode;

public class StartCmd implements Command {

  private static ProgramMode progMode = ProgramMode.DEFAULT;

  @Override
  public String getName() {
    return "start";
  }

  @Override
  public String getDescription() {
    return "Start the Arfin application in interactive or server mode.";
  }

  @Override
  public void help() {
    System.out.println("\nUsage: java Arfin start [argument]");
    System.out.println("Avaliable commands:");

    System.out.printf("  %-15s %s%n", "cli", "Initialize the application cli");
    System.out.printf("  %-15s %s%n", "server", "Initialize the application server");
    System.out.printf("  %-15s %s%n", "-h, --help", "Help menu to use 'start' command");
  }

  @Override
  public void execute(String[] args) {
    if (args.length == 0 || args[0].equals("-h") || args[0].equals("--help")) {
      help();
      return;
    }

    if (args.length == 1 && args[0].equalsIgnoreCase("cli")) {
      System.out.println("Starting cli program...");
      progMode = ProgramMode.CLI;
      return;
    }

    if (args.length == 1 && args[0].equalsIgnoreCase("server")) {
      System.out.println("Starting server mode...");
      progMode = ProgramMode.SERVER;
      return;
    }

    throw new CLIBadUsage("Invalid arguments for 'start' command: " + Arrays.toString(args));
  }

  public ProgramMode getProgMode() {
    return progMode;
  }

}
