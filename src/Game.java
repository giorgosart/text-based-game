import static utils.ConsoleUtils.waitForInput;import static utils.ConsoleUtils.write;import entities.Item;import entities.Parser;import entities.Player;import entities.Room;import entities.RoomExit;import enums.Color;import enums.CommandWord;import enums.Direction;import input.Command;import java.util.HashMap;public class Game {  private Parser parser;  private Room currentRoom;  private Player currentPlayer;  private boolean finished;  public Game() {    createRooms();    finished = false;    parser = new Parser();    currentPlayer = new Player("George", currentRoom);  }  private void createRooms() {    Room hut = new Room("You are in a hut lying on slab of wood.", "Hut");    Room conservatory = new Room(        "A room with a glass roof and walls used as a sun lounge or for growing delicate plants.",        "Conservatory");    Room courtyard = new Room("You are in the courtyard", "Courtyard");    Room temple = new Room("Temple", "Temple");    Room chiefHut = new Room("A big hut that the Chief's family lives in", "Chief's Hut");    Room market = new Room("A small market", "Market");    Room shop1 = new Room("A small shop", "Shop1");    Room shop2 = new Room("A small shop", "Shop2");    Room crypt = new Room("A crypt", "Crypt");    Room catacomb = new Room("You are in a dark place", "Catacomb");    Room jungle = new Room("A vast jungle", "Jungle");    hut.addItem(new Item("A pair of worn out trousers", "Trousers", 2));    hut.addItem(new Item("A pair of worn out shoes", "Shoes", 1));    hut.addItem(new Item("A worn out shirt", "Shirt", 1));    hut.addItem(new Item("A worn out hat", "Hat", 1));    hut.addItem(new Item("A big table made of wood ", "Table", 40, false));    hut.addItem(new Item("A nice juicy red apple", "Apple", 1));    conservatory.addItem(new Item("A small rusty key", "Key", 1, true, "The hut door is now unlocked"));    hut.setRoomExits(new HashMap<String, RoomExit>() {{      put(Direction.NORTH.direction, new RoomExit(courtyard, true, conservatory.getItem("Key")));      put(Direction.SOUTH.direction, new RoomExit(conservatory));    }});    conservatory.setRoomExits(new HashMap<String, RoomExit>() {{      put(Direction.NORTH.direction, new RoomExit(hut));    }});    courtyard.setRoomExits( new HashMap<String, RoomExit>() {{      put(Direction.NORTH.direction, new RoomExit(temple));      put(Direction.EAST.direction, new RoomExit(chiefHut));      put(Direction.WEST.direction, new RoomExit(market));    }});    temple.setRoomExits(new HashMap<String, RoomExit>() {{      put(Direction.NORTH.direction, new RoomExit(crypt));    }});    crypt.setRoomExits(new HashMap<String, RoomExit>() {{      put(Direction.WEST.direction, new RoomExit(catacomb));    }});    catacomb.setRoomExits( new HashMap<String, RoomExit>() {{      put(Direction.EAST.direction, new RoomExit(crypt));    }});    market.setRoomExits( new HashMap<String, RoomExit>() {{      put(Direction.NORTH.direction, new RoomExit(shop1));      put(Direction.EAST.direction, new RoomExit(courtyard));      put(Direction.WEST.direction, new RoomExit(jungle, true));      put(Direction.SOUTH.direction, new RoomExit(shop2));    }});    chiefHut.setRoomExits( new HashMap<String, RoomExit>() {{      put(Direction.WEST.direction, new RoomExit(market));    }});    shop1.setRoomExits( new HashMap<String, RoomExit>() {{      put(Direction.SOUTH.direction, new RoomExit(market));    }});    shop2.setRoomExits( new HashMap<String, RoomExit>() {{      put(Direction.NORTH.direction, new RoomExit(market));    }});    /*    Item knife = new Item("A big , sharp, knife ", "knife", 4, true);    sacrificePit.addItem(knife);    Item scull = new Item("Scull", "Scull", 3, true);    sacrificePit.addItem(scull);    Item sacrificeStone = new Item("A big rock full of blood ", "sactificeStone", 3000, false);    sacrificePit.addItem(sacrificeStone);    Item flowerpot = new Item("A big flowerpot ", "flowerpot", 12, true);    RoyalPalace.addItem(flowerpot);    Item tomatoes = new Item("Some tomatoes", "tomatoes", 5, true);    stores.addItem(tomatoes);    Item maize = new Item("maize - a type of corn", "maize", 5, true);    stores.addItem(maize);    Item avocados = new Item("Some avocados", "avocados", 5, true);    stores.addItem(avocados);    Item duckMeat = new Item("Some duck meat", "duckMeat", 15, true);    stores.addItem(duckMeat);    Item chocolate = new Item("chocolate bars!!!", "chocolate", 5, true);    stores.addItem(chocolate);    Item tools = new Item("Tools, this must be useful for repairing something", "tools", 25, true);    stores.addItem(tools);    Item desk = new Item("A desk made of stone", "desk", 5000, false);    court.addItem(desk);    Item chain = new Item("just a chain on the floor", "chain", 10, true);    jail.addItem(chain);    workshop.addItem(knife);    Item gold = new Item("Some gold", "gold", 20, true);    workshop.addItem(gold);    Item silver = new Item("Some silver", "silver", 20, true);    workshop.addItem(silver);    Item tree = new Item("Just a tree", "tree", 0, false);    Jungle.addItem(tree);    Item slave = new Item("Slave", "slave", 0, false);    Market.addItem(slave);    Item rock = new Item("A small rock", "rock", 8, true);    Market.addItem(rock);    Item plane = new Item("Your airplane but is crashed", "plane", 0, false);    planeCrash.addItem(plane);    Item wallet = new Item("Your wallet!!", "wallet", 5, true);    planeCrash.addItem(wallet);    Item radio = new Item("Woo hoo you found the radio. Let's hope it works", "radio", 60, true);    planeCrash.addItem(radio);    Enemy demon = new Enemy("demon", 1);    cave.addEnemy(demon);    Enemy evilSpirit = new Enemy("evilSpirit", 1);    jail.addEnemy(evilSpirit);    Enemy snake = new Enemy("snake", 4);    Jungle.addEnemy(snake);    Enemy gorilla = new Enemy("gorilla", 5);    planeCrash.addEnemy(gorilla);     */    currentRoom = hut;  // start game inside the hut  }  public void play() {    printWelcome();    // Enter the main command loop.  Here we repeatedly read commands and    // execute them until the game is over.    while (!finished) {      Command command = parser.getCommand();      finished = processCommand(command, this.currentRoom);    }    write("Thank you for playing. Goodbye.");  }  private void printWelcome() {    write(        "Your airplane has crash landed in the Amazonian jungle, leaving you in a very bad state."            + "You wake up, you don't remember anything and find your self surrounded by people You don't "            + "recognise anyone, and it seems that they are trying to communicate with you."            + "They keep pointing to the sky, but you don't remember anything, your memory is blank."            + "Your task is to look around and to try and understand what happened to you");    waitForInput();    write("Let's start by typing " + Color.RED + "inspect" + Color.RESET        + " to check out your surroundings");  }  /**   * Given a command, process (that is: execute) the command. If this command ends the game, true is   * returned, otherwise false is returned.   */  private boolean processCommand(Command command, Room room) {    if (command.isUnknown()) {      write("Unknown command please type " + Color.RED_BACKGROUND + " help " + Color.RESET          + " for more information");      return false;    }    CommandWord action = command.getCommandWord();    if (action == CommandWord.HELP) {      printHelp();    } else if (action == CommandWord.GO) {      goRoom(command, room);    } else if (action == CommandWord.USE) {      use(command, room);    } else if (action == CommandWord.INSPECT) {      inspect(command, room);    } else if (action == CommandWord.TAKE) {      take(command, room);    } else if (action == CommandWord.INVENTORY) {      inventory(command);    } else if (action == CommandWord.DROP) {      drop(command);    } else if (action == CommandWord.BATTLE) {      battle(command);    } else if (action == CommandWord.QUIT) {      return true;  // signal that we want to quit    }    return false;  }  private void use(Command command, Room room) {    String itemString = command.getSecondWord();    Item item = currentPlayer.getItem(itemString);    boolean exitUnlocked = false;    for (RoomExit exit : room.getRoomExits().values()) {      if (exit.getRequiredItem() != null && exit.getRequiredItem().getName()          .equalsIgnoreCase(itemString)) {        exit.setLocked(false);        exitUnlocked = true;        write(item.getDescriptionAfterUse());        currentPlayer.removeItem(item);      }    }    if (!exitUnlocked) {      write("cannot use this item here");    }  }  private void printHelp() {    write("Player: " + currentPlayer.getName());    write("Location: " + currentRoom.getName());    write("Inventory Items:" + currentPlayer.getItems());    write("");    write("Available commands:");    parser.showCommands();  }  /**   * "Take" was entered. take a item in a room, if there is any   */  private void take(Command command, Room room) {    String itemString = command.getSecondWord();    Item item = room.getItem(itemString);    if (!command.hasSecondWord()) {      write("Take what?");      return;    }    if (item == null) {      write("Item does not exist, type " + Color.RED + "inspect" + Color.RESET          + " to check out your surroundings");      return;    }    if (currentPlayer.getTotalItemWeight() +        item.getWeight() > currentPlayer.getMaxWeight()) {      write("You have no space in your inventory.");      return;    }    if (item.isMovable()) {      currentPlayer.addItem(item);      write("The item is now in your inventory");      currentRoom.removeItem(item);    } else {      write("You can't move the item");    }  }  /**   * "Drop was entered. Drop an item from hero's inventory   */  private void drop(Command command) {    String theItem = command.getSecondWord();    Item theItems = currentPlayer.getItem(theItem);    if (!command.hasSecondWord()) {      System.out.println("Drop what?");      return;    }    currentPlayer.removeItem(theItems);    System.out.println("you have dropped the item");    currentRoom.addItem(theItems);  }  private void inventory(Command command) {    write(currentPlayer.getInventory());  }  private void inspect(Command command, Room room) {    System.out.println(room.getLongDescription());    System.out.println(room.getMyItemsDescription());    if (currentRoom.hasEnemies()) {      //Print Warning + entities.Enemy info      System.out.println("Be careful! There are enemies in this room!");      System.out.println(currentRoom.getAllEnemyInfo());    }  }  /**   * "battle" was entered. (unfinished command)   */  private void battle(Command command) {//    currentRoom.remove(entities.Enemy);  }  /**   * Try to go to one direction. If there is an exit, enter the new room, otherwise print an error   * message.   */  private void goRoom(Command command, Room room) {    if (!command.hasSecondWord()) {      // if there is no second word, we don't know where to go...      write("Go where?");      return;    }    String direction = command.getSecondWord();    if (Direction.validate(direction) && room.getRoomExits().containsKey(direction)) {      Room nextRoom = room.getRoomExits().get(direction)          .getNextRoom(); // Try to leave current room.      if (nextRoom == null) {        write("No exits available");      } else if (room.getRoomExits().get(direction).isLocked()) {        write("Your path is blocked, try another way");        //TODO: check if player has the item required      } else {        currentRoom.setVisited(true);        currentRoom = nextRoom;        write(currentRoom.getLongDescription());      }    } else {      write("Invalid direction: " + room.getExitString());    }  }}