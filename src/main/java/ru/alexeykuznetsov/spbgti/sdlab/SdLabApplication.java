package ru.alexeykuznetsov.spbgti.sdlab;


import java.util.Arrays;
import ru.alexeykuznetsov.spbgti.sdlab.service.FileWriterService;
import ru.alexeykuznetsov.spbgti.sdlab.service.FillerService;
import ru.alexeykuznetsov.spbgti.sdlab.service.SortingService;
import ru.alexeykuznetsov.spbgti.sdlab.service.impl.FileWriterServiceImpl;
import ru.alexeykuznetsov.spbgti.sdlab.service.impl.FillerServiceImpl;
import ru.alexeykuznetsov.spbgti.sdlab.service.impl.SortingServiceImpl;

public class SdLabApplication {

  public static void main(String[] args) {
    FileWriterService fileWriterService = new FileWriterServiceImpl();
    FillerService fillerService = new FillerServiceImpl();
    SortingService sortingService = new SortingServiceImpl();

    System.out.println("Программа сортировки массива. Выполнил студент 434 группы Кузнецов Алексей");

    int[] initialArray = fillerService.fillData();
    System.out.println("Исходный массив: " + Arrays.toString(initialArray));
    sortingService.sortArrayByMergeSort(initialArray);
    System.out.println("Отсортированный массив: " + Arrays.toString(initialArray));
    fileWriterService.writeData(initialArray);
  }

}
