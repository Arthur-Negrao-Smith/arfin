package cli;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cli.exceptions.CLIException;
import cli.exceptions.CLIBadUsage;

// import the commands
import cli.commands.Help;
import cli.commands.Version;

/*
 * @brief Class to parse all commands
 */
public class Cli {

  private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

  // register new commands
  static {
    registerCommand(new Help());
    registerCommand(new Version());
  }

  /*
   * @brief Method to add new command to cli
   */
  private static void registerCommand(Command command) {
    COMMAND_MAP.put(command.getName(), command);
  }

  /*
   * @brief Command to run Cli
   */
  public static void parse(String[] args) {
    if (args == null || args.length == 0) {
      System.err.println("Too few arguments. The program need at least 1 command.");
      show_help();
      return;
    }

    // get the first command name
    String command_name = args[0].toLowerCase();

    // get the location of the command
    Command command = COMMAND_MAP.get(command_name);

    if (command == null) {
      System.err.println("Unknown command: " + command_name);
      show_help();
      return;
    }

    String[] remaining_args = Arrays.copyOfRange(args, 1, args.length);

    try {

      command.execute(remaining_args);

    } catch (CLIBadUsage e) {

      System.err.println("Bad Usage: " + e.getMessage());
      command.help();

    } catch (CLIException e) {

      System.err.println("Fatal Error: " + e.getMessage());
      e.printStackTrace();

    } catch (Exception e) {

      System.err.println("Fatal Error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  /*
   * @brief Method to help the user with the app usage
   */
  public static void show_help() {
    System.out.println("\nUsage: java Arfin <command> [arguments]");
    System.out.println("Avaliable commands:");

    COMMAND_MAP.values().forEach(cmd -> System.out.printf("  %-10s %s%n", cmd.getName(), cmd.getDescription()));
  }
}
