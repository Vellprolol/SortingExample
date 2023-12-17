package ru.alexeykuznetsov.spbgti.sdlab.filler.impl;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import ru.alexeykuznetsov.spbgti.sdlab.filler.Filler;
import ru.alexeykuznetsov.spbgti.sdlab.utils.ValidationUtils;

/**
 * Реализация {@link Filler} для заполнения массива случайными числами.
 *
 * @author Alexey Kuznetsov
 */
public class RandomFiller implements Filler {

  @Override
  public int[] fill() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите размер массива: ");
    int size = ValidationUtils.validateArraySize(scanner);

    System.out.print("Введите минимальное значение: ");
    int min = ValidationUtils.validateInteger(scanner);

    System.out.print("Введите максимальное значение: ");
    int max = ValidationUtils.validateInteger(scanner);
    scanner.close();

    Random random = new Random();
    return IntStream.generate(() -> random.nextInt(max - min + 1) + min)
        .limit(size)
        .toArray();
  }
}
