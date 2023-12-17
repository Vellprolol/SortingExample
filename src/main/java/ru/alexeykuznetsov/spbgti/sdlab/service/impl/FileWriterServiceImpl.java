package ru.alexeykuznetsov.spbgti.sdlab.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import ru.alexeykuznetsov.spbgti.sdlab.service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {

  @Override
  public void writeData(int[] arr) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\SortingExample\\SortedData.txt"))) {
      writer.write(String.format("Отсортированный массив: %s", mapArrayToString(arr)));
    } catch (IOException e) {
      System.out.printf("Exception while writing sorted data to file\nMessage: %s", e.getMessage());
    }
  }

  private String mapArrayToString(int[] arr) {
    return Arrays.stream(arr)
        .boxed()
        .map(String::valueOf)
        .collect(Collectors.joining(", "));
  }
}
