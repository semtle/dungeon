package org.mafagafogigante.dungeon.entity.creatures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Effect implements Serializable {

  private final List<Effect> drinkableEffects = new ArrayList<Effect>();

  public abstract void affect(Creature creature);

}
