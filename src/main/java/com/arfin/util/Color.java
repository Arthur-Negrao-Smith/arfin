package com.arfin.util;

public enum Color {
  RESET {
    @Override
    public String toString() {
      return AnsiColor.ANSI_RESET;
    }
  },

  BLACK {
    @Override
    public String toString() {
      return AnsiColor.ANSI_BLACK;
    }
  },

  RED {
    @Override
    public String toString() {
      return AnsiColor.ANSI_RED;
    }
  },

  GREEN {
    @Override
    public String toString() {
      return AnsiColor.ANSI_GREEN;
    }
  },

  YELLOW {
    @Override
    public String toString() {
      return AnsiColor.ANSI_YELLOW;
    }
  },

  BLUE {
    @Override
    public String toString() {
      return AnsiColor.ANSI_BLUE;
    }
  },

  PURPLE {
    @Override
    public String toString() {
      return AnsiColor.ANSI_PURPLE;
    }
  },

  CYAN {
    @Override
    public String toString() {
      return AnsiColor.ANSI_CYAN;
    }
  },

  WHITE {
    @Override
    public String toString() {
      return AnsiColor.ANSI_WHITE;
    }
  },
}
