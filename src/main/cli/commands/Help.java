package cli.commands;

import cli.Command;
import cli.Cli;

public class Help implements Command {

  @Override
  public String getName() {
    return "help";
  }

  @Override
  public String getDescription() {
    return "Show the help menu";
  }

  @Override
  public void execute(String[] args) {
    Cli.show_help();
  }

  @Override
  public void help() {
  }
}
