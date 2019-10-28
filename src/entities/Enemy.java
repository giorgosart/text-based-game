package entities;

public class Enemy extends AbstractPlayer {

  private String name;
  private int health, level;

  public Enemy(String name, int level) {
    super(name);
    this.level = level;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
}
