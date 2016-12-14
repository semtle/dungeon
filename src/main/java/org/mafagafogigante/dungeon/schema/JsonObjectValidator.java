package org.mafagafogigante.dungeon.schema;

import org.mafagafogigante.dungeon.util.JsonElementSearchUtil;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.util.ArrayList;
import java.util.List;

public final class JsonObjectValidator {

  private final JsonRulesFactory jsonRulesFactory;

  public JsonObjectValidator(JsonRulesFactory jsonRulesFactory) {
    this.jsonRulesFactory = jsonRulesFactory;
  }

  /**
   * Applies json rule pairs to json object and returns validation result list.
   */
  public List<JsonValidationResult> applyTo(JsonObject sourceJsonObject) {
    final List<JsonRulePair> jsonRulePairs = jsonRulesFactory.getJsonRulePairs();
    List<JsonValidationResult> jsonValidationResults = new ArrayList<>();
    for (JsonRulePair jsonRulePair : jsonRulePairs) {
      List<JsonValue> sourceJsonObjectValues =
          JsonElementSearchUtil.searchJsonValueByAttributeName(sourceJsonObject, jsonRulePair.getTargetElementName());
      for (JsonValue sourceJsonValue : sourceJsonObjectValues) {
        jsonValidationResults.add(jsonRulePair.getJsonRule().validate(sourceJsonValue));
      }
    }
    return jsonValidationResults;
  }
}
