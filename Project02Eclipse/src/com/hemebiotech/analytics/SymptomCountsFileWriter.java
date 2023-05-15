package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * A class to write the counts of each symptom to a file.
 */
public class SymptomCountsFileWriter {

  /**
   * Write the counts of each symptom to a file.
   * 
   * @param symptomCountMap A map containing the counts of each symptom.
   * @param outputFilePath The path to the file to write the counts to.
   */
  public void writeSymptomCountsToFile(Map < String, Integer > symptomCountMap, String outputFilePath) {
    try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
      // Loop over each symptom in the map and write the count to the output file
      for (String symptom: symptomCountMap.keySet()) {
        String line = symptom + ": " + symptomCountMap.get(symptom);
        fileWriter.write(line);
        fileWriter.newLine();
      }
    } catch (IOException e) {
      // If an exception occurs during file writing, print an error message and stack trace
      System.err.println("Error writing file: " + e.getMessage());
      e.printStackTrace();
    }
  }
}