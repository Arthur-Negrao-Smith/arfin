package cli.exceptions;

public class CLIBadUsage extends RuntimeException {
  public CLIBadUsage(String message) {
    super(message);
  }
}
