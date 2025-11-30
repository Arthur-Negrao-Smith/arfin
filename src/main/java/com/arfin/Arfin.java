package com.arfin;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.arfin.cli.Cli;
import com.arfin.cli.commands.Command;
import com.arfin.cli.commands.StartCmd;
import com.arfin.cli.util.ProgramMode;
import com.arfin.cli.CliRunner;

@SpringBootApplication
public class Arfin {
  public static void main(String[] args) {
    if (args.length == 0 || !args[0].equalsIgnoreCase("start")) {
      System.out.println("INFO: Use the 'start' command to use all arfin commands.");
      Cli.parse(args);
      return;
    }

    Cli.parse(args);

    ProgramMode mode = new StartCmd().getProgMode();

    // program don't run
    if (mode == ProgramMode.DEFAULT) {
      return;
    }

    SpringApplication app = new SpringApplication(Arfin.class);

    // if cli, then disable server mode
    if (mode == ProgramMode.CLI) {
      app.setWebApplicationType(WebApplicationType.NONE);

    } else if (mode == ProgramMode.SERVER) {
      app.setAdditionalProfiles("server");
      app.setWebApplicationType(WebApplicationType.SERVLET);

    }

    app.run(args);
  }

  @Bean
  public CommandLineRunner cliRunner(ApplicationContext context, Map<String, Command> commandMap) {
    return args -> {

      ProgramMode mode = new StartCmd().getProgMode();

      if (mode == ProgramMode.CLI) {
        Cli.registerAllCommands(commandMap);
        CliRunner.run();

        // function to close spring
        SpringApplication.exit(context, () -> 0);
      }
    };
  }

}
