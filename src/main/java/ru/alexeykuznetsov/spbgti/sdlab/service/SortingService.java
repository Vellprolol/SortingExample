package ru.alexeykuznetsov.spbgti.sdlab.service;

import java.util.List;

/**
 * Сервис для сортировки массива.
 *
 * @author Alexey Kuznetsov
 */
public interface SortingService {

  /**
   * Метод для сортировки переданного массива при помощи метода сортировки MergeSort.
   *
   * @param toSort - список для сортировки
   * @return отсортированный список
   */
  List<Integer> sortArrayByMergeSort(List<Integer> toSort);
}
