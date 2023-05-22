package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    // Create a new TreeMap to store the symptom counts in alphabetical order
    Map < String, Integer > symptomCounts = new TreeMap < > ();

    // Loop through each symptom in the list of symptoms
    for (String symptom: symptoms) {
      String lowercaseSymptom = symptom.toLowerCase();
      Integer count = symptomCounts.get(lowercaseSymptom);
      if (count == null) {
        count = 0;
      }
      symptomCounts.put(lowercaseSymptom, count + 1);
    }

    // Return the sorted map of symptom counts
    return symptomCounts;
  }
}