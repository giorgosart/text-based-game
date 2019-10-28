package enums;

public enum CommandWord {
  GO("go"),
  USE("use"),
  QUIT("quit"),
  HELP("help"),
  INSPECT("inspect"),
  TAKE("take"),
  DROP("drop"),
  INVENTORY("inventory"),
  BATTLE("battle"),
  UNKNOWN("unknown");

  public final String command;

  CommandWord(String command) {
    this.command = command;
  }

  public static boolean isCommandValid(String command) {
    for (CommandWord c : values()) {
      if (c.command.equals(command)) {
        return true;
      }
    }
    return false;
  }
}
