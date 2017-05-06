package org.mafagafogigante.dungeon.io;

import org.mafagafogigante.dungeon.schema.JsonRule;
import org.mafagafogigante.dungeon.schema.rules.JsonRuleFactory;

import java.util.HashMap;
import java.util.Map;

class ExtendedJsonRuleFactory {

  private ExtendedJsonRuleFactory() {
  }

  static JsonRule makeIntegersRule(String... names) {
    Map<String, JsonRule> populationRules = new HashMap<>();
    JsonRule integerRule = JsonRuleFactory.makeIntegerRule();
    for (String name : names) {
      populationRules.put(name, integerRule);
    }
    return JsonRuleFactory.makeObjectRule(populationRules);
  }

}
