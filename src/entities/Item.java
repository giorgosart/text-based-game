package entities;

public class Item {

  private String description;
  private String name;
  private int weight;
  private boolean movable;
  private String descriptionAfterUse;

  public Item(String description, String name, int weight) {
    this.description = description;
    this.name = name;
    this.weight = weight;
    this.movable = true;
  }

  public Item(String description, String name, int weight, boolean movable) {
    this(description, name, weight);
    this.movable = movable;
  }

  public Item(String description, String name, int weight, boolean movable, String descriptionAfterUse) {
    this(description, name, weight, movable);
    this.descriptionAfterUse = descriptionAfterUse;
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name;
  }

  public boolean isMovable() {
    return movable;
  }

  public int getWeight() {
    return weight;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public void setMovable(boolean movable) {
    this.movable = movable;
  }

  public String getDescriptionAfterUse() {
    return descriptionAfterUse;
  }

  public void setDescriptionAfterUse(String descriptionAfterUse) {
    this.descriptionAfterUse = descriptionAfterUse;
  }

  @Override
  public String toString() {
    return name + " (" + description + ", " + weight + "kg)\n";
  }
}
