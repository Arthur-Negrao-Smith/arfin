package com.arfin.cli.commands;

import com.arfin.cli.commands.Command;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/*
 * @brief Class to show app version
 */
public class VersionCmd implements Command {

  private static final String PROPERTIES_FILE = "version.properties";
  private final Properties properties = new Properties();

  public VersionCmd() {
    try (
        InputStream input = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {

      if (input == null) {
        throw new IOException("Porpeties file don't finded: " + PROPERTIES_FILE);
      }

      // to read the file with utf-8 decode
      try (InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8)) {

        properties.load(reader);
      }

    } catch (IOException e) {
      throw new RuntimeException("Error to load program version: " + e.getMessage(), e);
    }
  }

  @Override
  public String getName() {
    return "version";
  }

  @Override
  public String getDescription() {
    return "Show the version of the program";
  }

  @Override
  public void execute(String[] args) {
    String version = properties.getProperty("app.version", "Unknown");
    String name = properties.getProperty("app.name", "Arfin");
    String build_date = properties.getProperty("app.build.date", "N/A");

    System.out.println(name + "-" + version + " builded at " + build_date);
  }

  @Override
  public void help() {
  }

}
