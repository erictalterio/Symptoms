package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class for counting the occurrences of each symptom in a list of symptoms.
 */
public class SymptomCounter implements ISymptomCounter {

  /**
   * Count the occurrences of each symptom in a list of symptoms.
   *
   * @param symptoms The list of symptoms to count.
   * @return A map containing the counts of each symptom.
   */
  @Override
  public Map < String, Integer > countSymptoms(List < String > symptoms) {
    // Create a new HashMap to store the symptom counts
    Map < String, Integer > symptomCounts = new HashMap < > ();

    // Loop through each symptom in the list of symptoms
    for (String symptom: symptoms) {
      // Convert the symptom to lowercase before counting
      String lowercaseSymptom = symptom.toLowerCase();
      
      // Increment the count of the current symptom in the symptomCounts map,
      // or set the count to 1 if it does not yet exist in the map
      symptomCounts.put(lowercaseSymptom, symptomCounts.getOrDefault(lowercaseSymptom, 0) + 1);
    }

    // Return the map of symptom counts
    return symptomCounts;
  }
}
