package entities;

public abstract class AbstractPlayer {

  private String name;
  private int hp;

  public AbstractPlayer(String name) {
    this.name = name;
    this.hp = 100;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }
}
