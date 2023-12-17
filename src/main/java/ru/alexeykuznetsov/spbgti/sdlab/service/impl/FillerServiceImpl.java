package ru.alexeykuznetsov.spbgti.sdlab.service.impl;

import java.util.Map;

import java.util.Scanner;
import ru.alexeykuznetsov.spbgti.sdlab.filler.Filler;
import ru.alexeykuznetsov.spbgti.sdlab.filler.impl.ManualFiller;
import ru.alexeykuznetsov.spbgti.sdlab.filler.impl.RandomFiller;
import ru.alexeykuznetsov.spbgti.sdlab.service.FillerService;
import ru.alexeykuznetsov.spbgti.sdlab.utils.ValidationUtils;

public class FillerServiceImpl implements FillerService {

  private final Map<Integer, Filler> fillerStrategy = initFillers();

  @Override
  public int[] fillData() {
    Scanner scanner = new Scanner(System.in);
    printFillerMenu();

    int choice = ValidationUtils.validateMenuInput(scanner);
    return fillerStrategy.get(choice).fill();
  }

  private void printFillerMenu() {
    System.out.println("""
        Выберите способ заполнения массива:
          1. Заполнение вручную
          2. Заполнение случайными данными""");
  }

  private Map<Integer, Filler> initFillers() {
    return Map.of(1, new ManualFiller(), 2, new RandomFiller());
  }
}
