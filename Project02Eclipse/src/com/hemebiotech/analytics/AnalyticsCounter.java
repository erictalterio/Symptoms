package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * This class is responsible for running the analytics counter application.
 * It reads symptoms from a file, counts their occurrences, and writes the results to a file.
 */
public class AnalyticsCounter {

  public void run() {
 
    try {
      // Step 1: Read the symptoms from the file
      final String filepath = "symptoms.txt";
      ISymptomReader symptomReader = new ReadSymptomDataFromFile(filepath);
      List<String> symptomsList = symptomReader.getSymptoms();

      // Step 2: Count the occurrences of each symptom
      ISymptomCounter symptomCounter = new SymptomCounter();
      Map<String, Integer> symptomCounts = symptomCounter.countSymptoms(symptomsList);

      // Step 3: Write the results to a file
      SymptomCountsFileWriter writer = new SymptomCountsFileWriter();
      writer.writeSymptomCountsToFile(symptomCounts, "result.out");

    } catch (Exception e) {
      System.err.println("An error occurred while processing the data: " + e.getMessage());
    }
  }
}
