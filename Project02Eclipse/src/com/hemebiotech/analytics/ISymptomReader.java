package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;

/**
 * Reads symptom data from a source and returns a list of symptoms, which may contain duplicates.
 * The implementation does not guarantee the order of the list.
 */
public interface ISymptomReader {
 /**
   * Returns a raw list of all symptoms obtained from a data source, which may contain duplicates.
   * If no data is available, an empty list is returned.
   * 
   * @return a list of all symptoms obtained from the data source, which may contain duplicates.
   * @throws FileNotFoundException if the data source file is not found.
   * @throws IOException if there is an IO error while reading the file.
   */
  List < String > getSymptoms() throws FileNotFoundException, IOException;
}