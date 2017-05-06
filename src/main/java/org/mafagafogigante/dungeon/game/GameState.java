package org.mafagafogigante.dungeon.game;

import org.mafagafogigante.dungeon.commands.CommandHistory;
import org.mafagafogigante.dungeon.entity.creatures.Hero;
import org.mafagafogigante.dungeon.io.JsonObjectFactory;
import org.mafagafogigante.dungeon.io.Version;
import org.mafagafogigante.dungeon.stats.Statistics;

import java.io.Serializable;

public class GameState implements Serializable {

  private static final long serialVersionUID = Version.MAJOR;
  private final CommandHistory commandHistory;
  private final World world;
  private final Statistics statistics = new Statistics();
  private Hero hero;
  private Point heroPosition;

  private transient boolean saved = false;

  /**
   * Constructs a new GameState.
   */
  public GameState() {
    commandHistory = new CommandHistory();
    world = new World(statistics.getWorldStatistics());
    createHeroAndStartingLocation();
  }

  /**
   * Returns a String with a story about how the character got where he or she currently is.
   */
  public String getPreface() {
    return String.format(JsonObjectFactory.makeJsonObject("preface.json").get("format").asString(), hero.getLocation());
  }

  /**
   * Creates the Hero and the starting Location.
   */
  private void createHeroAndStartingLocation() {
    hero = world.getCreatureFactory().makeHero(world.getWorldDate(), world, statistics);
    heroPosition = new Point(0, 0, 0);
    world.getLocation(heroPosition).addCreature(hero);
    getStatistics().getExplorationStatistics().addVisit(heroPosition, world.getLocation(heroPosition).getId());
  }

  public CommandHistory getCommandHistory() {
    return commandHistory;
  }

  public World getWorld() {
    return world;
  }

  public Statistics getStatistics() {
    return statistics;
  }

  public Hero getHero() {
    return hero;
  }

  public void setHeroPosition(Point heroPosition) {
    this.heroPosition = heroPosition;
  }

  public boolean isSaved() {
    return saved;
  }

  public void setSaved(boolean saved) {
    this.saved = saved;
  }

}
