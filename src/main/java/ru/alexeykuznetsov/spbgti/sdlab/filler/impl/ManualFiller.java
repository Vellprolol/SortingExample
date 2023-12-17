package ru.alexeykuznetsov.spbgti.sdlab.filler.impl;

import java.util.Scanner;
import ru.alexeykuznetsov.spbgti.sdlab.filler.Filler;
import ru.alexeykuznetsov.spbgti.sdlab.utils.ValidationUtils;

/**
 * Реализация {@link Filler} для заполнения массива данными от пользователя.
 *
 * @author Alexey Kuznetsov
 */
public class ManualFiller implements Filler {

  @Override
  public int[] fill() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите размер массива: ");
    int size = ValidationUtils.validateArraySize(scanner);

    int[] arr = new int[size];

    for (int i = 0; i < arr.length; i++) {
      System.out.println("Введите число: ");
      int number = ValidationUtils.validateInteger(scanner);
      arr[i] = number;
    }
    scanner.close();
    return arr;
  }
}
