package enums;

public enum Direction {

  NORTH("north"), EAST("east"), SOUTH("south"), WEST("west");

  public final String direction;

  Direction(String direction) {
    this.direction = direction;
  }

  public static boolean validate(String direction) {
    for (Direction d : values()) {
      if (d.direction.equals(direction)) {
        return true;
      }
    }
    return false;
  }
}
