package com.arfin.cli.commands;

import com.arfin.cli.exceptions.CLIBadUsage;
import com.arfin.cli.util.ProgramMode;
import com.arfin.util.ColorPrint;

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
    System.out.println("Avaliable arguments:");

    System.out.printf("  %-15s %s%n", "cli", "Initialize the application cli");
    System.out.printf("  %-15s %s%n", "server", "Initialize the application server");
    System.out.printf("  %-15s %s%n", "-h, --help", "Help menu to use 'start' command");
  }

  @Override
  public void execute(String[] args) {
    if (args.length == 0) {
      throw new CLIBadUsage("The " + this.getName() + " command needs arguments");
    }

    if (args[0].equals("-h") || args[0].equals("--help")) {
      help();
      return;
    }

    if (args.length == 1 && args[0].equalsIgnoreCase("cli")) {
      ColorPrint.print("Starting cli program...");
      progMode = ProgramMode.CLI;
      return;
    }

    if (args.length == 1 && args[0].equalsIgnoreCase("server")) {
      ColorPrint.print("Starting server mode...");
      progMode = ProgramMode.SERVER;
      return;
    }

    throw new CLIBadUsage("Invalid arguments for 'start' command: '" + String.join(" ", args) + "'");
  }

  public ProgramMode getProgMode() {
    return progMode;
  }

}
