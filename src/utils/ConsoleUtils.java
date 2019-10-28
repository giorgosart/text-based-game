package utils;

import enums.Color;
import java.io.IOException;

public class ConsoleUtils {

  public static void write(String string){
    System.out.println(string);
  }

  public static void waitForInput() {
    ConsoleUtils.write("Press " + Color.CYAN_BACKGROUND + " [ENTER] " + Color.RESET + " to continue ...");
    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
