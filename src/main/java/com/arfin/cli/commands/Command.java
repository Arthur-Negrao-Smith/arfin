package com.arfin.cli.commands;

/*
 * Interface to create CLI commands
 * <p>This interface create a base to create a new cli command.</p>
 */
public interface Command {

  /**
   * Return command's name.
   *
   * @return Command's name.
   */
  String getName();

  /**
   * Return command's description.
   *
   * @return Command's description.
   */
  String getDescription();

  /**
   * Execute the command.
   */
  void execute(String[] args);

  /**
   * Print command's help table.
   */
  void help();
}
