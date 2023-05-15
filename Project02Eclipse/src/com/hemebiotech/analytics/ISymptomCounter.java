package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * An interface for counting the occurrences of each symptom in a list of symptoms.
 */
public interface ISymptomCounter {

  /**
   * Count the occurrences of each symptom in a list of symptoms.
   * 
   * @param symptoms The list of symptoms to count.
   * @return A map containing the counts of each symptom.
   */
  Map < String, Integer > countSymptoms(List < String > symptoms);
}