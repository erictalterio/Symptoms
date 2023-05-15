package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * ReadSymptomDataFromFile is a class that implements the ISymptomReader interface.
 * It reads a list of symptoms from a file, validates the format of each line, and
 * returns a list of symptoms.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

  private final String filepath; // The path of the file that contains the list of symptoms

  /**
   * Constructs a new ReadSymptomDataFromFile object with the specified filepath.
   * If the filepath is null or empty, an IllegalArgumentException is thrown.
   * If the file is empty or contains invalid lines, a RuntimeException is thrown.
   *
   * @param filepath The path of the file that contains the list of symptoms
   * @throws IllegalArgumentException if the filepath is null or empty
   * @throws RuntimeException if the file is empty or contains invalid lines
   */
  public ReadSymptomDataFromFile(String filepath) {
    if (filepath == null || filepath.isEmpty()) {
      throw new IllegalArgumentException("Error: Filepath is null or empty");
    }
    this.filepath = filepath;
    try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) { // Work in conjunction to read the contents of a file faster. FileReader reads a file character by character, while BufferedReader reads the file line by line and stores each line in a buffer to improve performance.
      String line = null; // initializes the line variable as null
      boolean emptyFile = true; // check Whether the file is empty or not. Initialized as true
      while ((line = reader.readLine()) != null) {
        emptyFile = false; // emptyFile changes to false if file is not empty
        if (!line.matches("^\\s*\\S.*\\S\\s*$")) { //This regex pattern matches any string that starts with zero or more whitespace characters, followed by a non-whitespace character, followed by any number of characters (including whitespace), and ending with a non-whitespace character, followed by zero or more whitespace characters. This ensures that each line contains only one symptom and that there is no extraneous whitespace before or after the symptom.
          throw new RuntimeException("Error: File contents have invalid format. Each line should contain only one symptom and no extraneous whitespace before or after the symptom.");
        }
      }
      if (emptyFile) { // initialized if emptyFile remains true
        throw new RuntimeException("Error: Symptom list is null or empty");
      }
    } catch (IOException e) {
      throw new RuntimeException("Error opening file: " + e.getMessage());
    }
  }

  /**
   * Reads the list of symptoms from the file and returns them as a list of strings.
   *
   * @return A list of strings that contains the symptoms
   * @throws FileNotFoundException if the file is not found
   * @throws IOException if an I/O error occurs
   */
  @Override
  public List < String > getSymptoms() throws FileNotFoundException, IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
      List < String > result = new ArrayList < > ();
      String line = null;
      while ((line = reader.readLine()) != null) {
        result.add(line);
      }
      return result;
    }
  }
}
