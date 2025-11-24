package cli;

/*
 * @brief Interface to CLI commands
 */
public interface Command {
  String getName();

  String getDescription();

  void execute(String[] args);

  void help();
}
