package org.mafagafogigante.dungeon.schema;

import com.eclipsesource.json.JsonValue;

/**
 * General interface for json value validation rules.
 */
public interface JsonRule {

  /**
   * Key method for json validation.
   */
  JsonValidationResult validate(JsonValue validationElement);
}
