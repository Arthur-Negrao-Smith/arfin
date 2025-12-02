package com.arfin.cli.commands;

import java.util.List;

import org.springframework.stereotype.Component;

import com.arfin.cli.Cli;
import com.arfin.cli.exceptions.CLIBadUsage;
import com.arfin.cli.util.CliTablePrinter;
import com.arfin.model.User;
import com.arfin.service.UserService;

@Component
public class ShowCmd implements Command {

  private UserService userService;

  public ShowCmd(UserService userService) {
    this.userService = userService;
  }

  @Override
  public String getName() {
    return "show";
  }

  @Override
  public String getDescription() {
    return "Command to show informations";
  }

  @Override
  public void help() {
    System.out.println("\nUsage: java arfin " + this.getName() + " [argument] <options>");
    System.out.println("Avaliable arguments:");

    System.out.printf("  %-15s %s%n", "user", "Show a user by him name");
    System.out.printf("  %-15s %s%n", "users", "Show multiples users");
    System.out.printf("  %-15s %s%n", "transaction", "Show a transaction by ID");
    System.out.printf("  %-15s %s%n", "transactions", "Show multiples transactions in a interval");
    System.out.printf("  %-15s %s%n", "-h, --help", "Help menu to use " + this.getName() + " command");
  }

  @Override
  public void execute(String[] args) {
    final String command_name = args[0];

    if (args.length == 0) {
      throw new CLIBadUsage("The '" + this.getName() + "' command needs arguments");
    }

    if (command_name.equals("-h") || command_name.equals("--help")) {
      help();
      return;
    }

    if (command_name.equalsIgnoreCase("users")) {
      List<User> users = userService.getAll();

      if (!users.isEmpty()) {
        CliTablePrinter.printUserTableHeader();

        users.forEach(user -> {
          CliTablePrinter.printUserTableLine(user);
        });

      } else {
        System.out.println("No registered users.");
      }
    }

    // TODO: Add `show user`
    // TODO: Add `show transactions`
    // TODO: Add `show transaction`
    // TODO: Add arguments error
  }
}
