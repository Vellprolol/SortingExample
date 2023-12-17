package ru.alexeykuznetsov.spbgti.sdlab.utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationUtils {

  public static int validateArraySize(Scanner scanner) {
    boolean valid = false;
    int size = 0;
    while (!valid) {
      try {
        size = Integer.parseInt(scanner.next());
        if (size <= 0) {
          throw new NumberFormatException("Negative array size");
        }
        valid = true;
      } catch (NumberFormatException e) {
        System.out.println("""
            Введена некорректная размерность массива.
            Длина массива должна быть целочисленными положительным числом. Повторите ввод""");
      }
    }
    return size;
  }

  public static int validateInteger(Scanner scanner) {
    boolean valid = false;
    int data = 0;
    while (!valid) {
      try {
        data = Integer.parseInt(scanner.next());
        valid = true;
      } catch (NumberFormatException e) {
        System.out.println("Элемент массива должен являться целым числом. Повторите ввод");
      }
    }
    return data;
  }

  public static int validateMenuInput(Scanner scanner) {
    boolean valid = false;
    int input = 0;
    while (!valid) {
      try {
        input = Integer.parseInt(scanner.next());
        if (input != 1 && input != 2) {
          throw new NumberFormatException();
        }
        valid = true;
      } catch (NumberFormatException e) {
        System.out.println("Введен неверный пункт меню. Повторите ввод");
      }
    }
    return input;
  }
}
