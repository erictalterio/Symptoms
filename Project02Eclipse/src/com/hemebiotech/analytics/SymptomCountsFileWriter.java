package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * A class to write the counts of each symptom to a file.
 */
public class SymptomCountsFileWriter {

  public void writeSymptomCountsToFile(Map < String, Integer > symptomCountMap, String outputFilePath) { 
    BufferedWriter fileWriter = null;
    try {
      fileWriter = new BufferedWriter(new FileWriter(outputFilePath));
      for (String symptom: symptomCountMap.keySet()) {
        String line = symptom + ": " + symptomCountMap.get(symptom);
        fileWriter.write(line);
        fileWriter.newLine();
      }
    } catch (IOException e) {
      System.err.println("Error writing file: " + e.getMessage());
      e.printStackTrace();
    } finally {
      if (fileWriter != null) {
        try {
          fileWriter.close();
        } catch (IOException e) {
          // Handle the exception if necessary
          System.err.println("Error closing writer: " + e.getMessage());
          e.printStackTrace();
        }
      }
    }
  }
}