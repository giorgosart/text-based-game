package entities;

import java.util.HashSet;
import java.util.Iterator;

public class Player extends AbstractPlayer {

  private int maxWeight;
  private Room currentRoom;
  private HashSet<Item> items;

  public Player(String name, Room room) {
    super(name);
    maxWeight = 10;
    currentRoom = room;
    items = new HashSet<>();
  }

  public int getMaxWeight() {
    return maxWeight;
  }

  public HashSet getItems() {
    return items;
  }

  public int getTotalItemWeight() {
    Iterator iter = items.iterator();
    int total = 0;
    while (iter.hasNext()) {
      total += ((Item) iter.next()).getWeight();
    }
    return total;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public Item getItem(String theItem) {
    for (Item item : items) {
      if (item.getName().equalsIgnoreCase(theItem)) {
        return item;
      }
    }
    return null;
  }

  public String getInventory() {

    if (items.isEmpty()) {
      return "\tNo items in my inventory";
    }

    StringBuilder returnString = new StringBuilder("Inventory ("+ getTotalItemWeight() + "kg / " + getMaxWeight()+ "kg)\n");
    for (Item item : items) {
      returnString.append("\t- ").append(item.toString());
    }
    return returnString.toString();
  }

  public void removeItem(Item myItem) {
    items.remove(myItem);
  }

}
