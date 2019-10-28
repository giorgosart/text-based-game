package entities;

public class RoomExit {

  private Room nextRoom;
  private boolean isLocked;
  private Item requiredItem;

  public RoomExit(Room nextRoom) {
    this.nextRoom = nextRoom;
    this.isLocked = false;
  }

  public RoomExit(Room nextRoom, boolean isLocked) {
    this(nextRoom);
    this.isLocked = isLocked;
  }

  public RoomExit(Room nextRoom, boolean isLocked, Item requiredItem) {
    this(nextRoom, isLocked);
    this.requiredItem = requiredItem;
  }

  public Room getNextRoom() {
    return nextRoom;
  }

  public void setNextRoom(Room nextRoom) {
    this.nextRoom = nextRoom;
  }

  public boolean isLocked() {
    return isLocked;
  }

  public void setLocked(boolean locked) {
    isLocked = locked;
  }

  public Item getRequiredItem() {
    return requiredItem;
  }

  public void setRequiredItem(Item requiredItem) {
    this.requiredItem = requiredItem;
  }
}
